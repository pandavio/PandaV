B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=9.85
@EndOfDesignText@
' B4XMainPage
#Region Shared Files
#CustomBuildAction: folders ready, %WINDIR%\System32\Robocopy.exe,"..\..\Shared Files" "..\Files"
#End Region

Sub Class_Globals
	Private Root As B4XView
	Private xui As XUI
	Private Picasso1 As Picasso
	Private btnConnect As Button
	Private btnOpenWallet As Button
	Private lblStatus As Label
	Private lblTitle As Label
	Private ivQRCode As ImageView
	Private loginHelp As LoginHelper
	Private pn1 As Panel
	Private lblTop As Label
	Private lblTopBg As Label
	Private imgWallet As ImageView
	Private lblPDVAmout As Label
	Private clvNFTs As CustomListView
	Private currentWalletAddress As String
	Private pnNFT As Panel
	Private lblHeader As Label
	Private lblNFTname As Label
	Private lblNFTid As Label
	Private imgNFT As ImageView
	Private lblValidStatus As Label
	Private pnListView As Panel
	Private lblLine1 As Label
	Private lblDisplay As Label
	Private imgNFTname As ImageView
	Private imgNFTid As ImageView
	Private imgStatus As ImageView
	
	Private kvs As KeyValueStore
	Private rp As RuntimePermissions
	Private shared As String
End Sub

Public Sub Initialize
	Picasso1.Initialize
End Sub

Sub B4XPage_Created (Root1 As B4XView)
	Root = Root1
	Root.LoadLayout("MainPage")
	loginHelp.Initialize(Me)
	shared = rp.GetSafeDirDefaultExternal("")
	kvs.Initialize(shared, "Userdatastore")
	btnOpenWallet.Enabled = False
	clvNFTs.AsView.Visible = False
	ivQRCode.Bitmap = Null
	currentWalletAddress = ""
	
	Dim detailPage As NFTDetailPage
	detailPage.Initialize
	B4XPages.AddPage("NFTDetailPage", detailPage)

End Sub

Sub btnConnect_Click
	lblStatus.Text = "正在请求Session..."
	ivQRCode.Bitmap = Null
	loginHelp.CreateLoginSession
	btnOpenWallet.Visible = True
	btnConnect.Visible = False
	ivQRCode.Visible = True
End Sub

Sub btnOpenWallet_Click
	Try
		Dim deeplink As String = btnOpenWallet.Tag
		If deeplink.StartsWith("http://") Or deeplink.StartsWith("https://") Then
			deeplink = deeplink.Replace("http://", "ergopay://").Replace("https://", "ergopay://")
		End If
		Dim intent As Intent
		intent.Initialize(intent.ACTION_VIEW, deeplink)
		StartActivity(intent)
	Catch
		MsgboxAsync("找不到支持 ergopay:// 的钱包应用。请安装Nautilus Wallet。", "提示")
	End Try
	btnOpenWallet.Visible = False
End Sub

Sub OnLoginSessionCreated(deeplink As String)
	lblStatus.Text = "Session created. Scan QR or open Wallet to connect."
	btnOpenWallet.Tag = deeplink
	btnOpenWallet.Enabled = True
	Dim qrGen As QRcode
	qrGen.Initialize
	ivQRCode.Bitmap = qrGen.drawQRCode(deeplink)
End Sub

Sub OnLoginSuccess(walletAddress As String)
	lblStatus.Text = "已登录成功"
	currentWalletAddress = walletAddress
	lblTitle.Text = walletAddress
	If walletAddress.Length > 10 Then lblTitle.Text = "..." & walletAddress.SubString(walletAddress.Length - 7)
	btnOpenWallet.Enabled = False
	pn1.Visible = False
	ivQRCode.Bitmap = Null
	GetWalletBalance(currentWalletAddress)
End Sub

Sub OnLoginError(msg As String)
	lblStatus.Text = "ERROR: " & msg
	ivQRCode.Bitmap = Null
End Sub

Sub OnWaitingForScan(ignored As String)
	lblStatus.Text = "Waiting Wallet Scan..."
End Sub

Sub B4XPage_Resume
	If Starter.CurrentSessionId <> "" Then loginHelp.StartPolling

End Sub



Private Sub GetWalletBalance(walletAddress As String)
	Dim job As HttpJob
	job.Initialize("GetBalance", Me)
	job.Download($"https://api.ergoplatform.com/api/v1/addresses/${walletAddress}/balance/total"$)
	lblStatus.Text = "正在获取钱包余额..."
End Sub

Private Sub GetWalletNFTs(walletAddress As String)
	Dim job As HttpJob
	job.Initialize("GetNFTs", Me)
	job.Download($"https://api.ergoplatform.com/api/v1/addresses/${walletAddress}/balance/total"$)
	lblStatus.Text = "正在获取NFT列表..."
End Sub

Sub JobDone(job As HttpJob)
	If job.Success Then
		Select True
			Case job.JobName = "GetBalance"
				Dim parser As JSONParser
				parser.Initialize(job.GetString)
				Dim result As Map = parser.NextObject
				Dim confirmed As Map = result.Get("confirmed")
				Dim tokens As List = confirmed.Get("tokens")
				Dim pdvAmount As Double = 0
				For i = 0 To tokens.Size - 1
					Dim token As Map = tokens.Get(i)
					If token.Get("name") = "PDV" Then
						pdvAmount = token.Get("amount") / Power(10, token.Get("decimals"))
						Exit
					End If
				Next
				lblPDVAmout.Text = $"PDV: ${NumberFormat(pdvAmount,1,2)}"$
				clvNFTs.AsView.Visible = True
				GetWalletNFTs(currentWalletAddress)

			Case job.JobName = "GetNFTs"
				Dim parser As JSONParser
				parser.Initialize(job.GetString)
				Dim result As Map = parser.NextObject
				Dim confirmed As Map = result.Get("confirmed")
				Dim tokens As List = confirmed.Get("tokens")
				clvNFTs.Clear
				For i = 0 To tokens.Size - 1
					Dim token As Map = tokens.Get(i)
					If token.Get("amount") = 1 And token.Get("decimals") = 0 Then
						Dim tokenId As String = token.Get("tokenId")
						Dim job1 As HttpJob
						job1.Initialize("TokenInfo_" & tokenId, Me)
						job1.Download($"https://api.ergoplatform.com/api/v1/tokens/${tokenId}"$)
					End If
				Next

			Case job.JobName.StartsWith("TokenInfo_")
				Dim tokenId As String = job.JobName.SubString("TokenInfo_".Length)
				Dim parser As JSONParser
				parser.Initialize(job.GetString)
				Dim result As Map = parser.NextObject
				Dim boxId As String = result.Get("boxId")
				Dim nftName As String = result.GetDefault("name", "NFT")
				If boxId <> "" Then
					Dim job2 As HttpJob
					job2.Initialize("BoxInfo_" & tokenId & "|" & nftName, Me)
					job2.Download($"https://api.ergoplatform.com/api/v1/boxes/${boxId}"$)
				End If

			Case job.JobName.StartsWith("BoxInfo_")
				Dim parts() As String = Regex.Split("\|", job.JobName.SubString("BoxInfo_".Length))
				Dim tokenId As String = parts(0)
				Dim nftName As String = parts(1)

				Dim parser As JSONParser
				parser.Initialize(job.GetString)
				Dim result As Map = parser.NextObject

				' ⭐ 修正：如果name是默认NFT，则尝试从assets(0).name获取
				If nftName = "NFT" And result.ContainsKey("assets") Then
					Dim assets As List = result.Get("assets")
					If assets.Size > 0 Then
						Dim asset As Map = assets.Get(0)
						nftName = asset.GetDefault("name", "NFT")
					End If
				End If

				Dim imageUrl As String = ""
				If result.ContainsKey("additionalRegisters") Then
					Dim registers As Map = result.Get("additionalRegisters")
					Dim rawValue As String = ""
					If registers.ContainsKey("R9") Then
						Dim r9Map As Map = registers.Get("R9")
						rawValue = r9Map.Get("renderedValue")
					Else If registers.ContainsKey("R4") Then
						Dim r4Map As Map = registers.Get("R4")
						rawValue = r4Map.Get("renderedValue")
					End If
					If rawValue.Length > 0 Then
						Dim bc As ByteConverter
						Dim bytes() As Byte = bc.HexToBytes(rawValue)
						imageUrl = BytesToString(bytes, 0, bytes.Length, "UTF8")
					End If
				End If

				If imageUrl.StartsWith("ipfs://") Then
					imageUrl = imageUrl.Replace("ipfs://", "https://ipfs.io/ipfs/")
				End If
				' ✅ 确保 AddNFTItem 在UI线程
				AddNFTItem(tokenId, imageUrl, nftName)

		End Select
	End If
	job.Release
End Sub


Private Sub FindViewByTag(pnl As Panel, tag As String) As View
	For Each v As View In pnl.GetAllViewsRecursive
		If v.Tag = tag Then Return v
	Next
	Return Null
End Sub

Private Sub AddNFTItem(tokenId As String, imageUrl As String, nftName As String)
    Dim itemPanel As Panel
    itemPanel.Initialize("")
    itemPanel.LoadLayout("clvNFTItem")
    itemPanel.Height = 80dip
    Dim lblHeader As Label = FindViewByTag(itemPanel, "lblHeader")
    Dim imgNFT As ImageView = FindViewByTag(itemPanel, "imgNFT")
    Dim lblNFTname As Label = FindViewByTag(itemPanel, "lblNFTname")
    Dim lblNFTid As Label = FindViewByTag(itemPanel, "lblNFTid")
    Dim lblValidStatus As Label = FindViewByTag(itemPanel, "lblValidStatus")

    lblHeader.Text = "PDV ACCESS TOKEN"
    lblNFTname.Text = nftName
    lblNFTid.Text = tokenId
    lblValidStatus.Text = "Valid"

    ' ⭐ 把imageUrl放到Panel.Tag，方便后面点击时读取
    itemPanel.Tag = imageUrl

    LoadNFTImage(imgNFT, imageUrl)
    clvNFTs.Add(itemPanel, tokenId)
End Sub


Private Sub LoadNFTImage(TargetImage As ImageView, imageUrl As String)
	If imageUrl = "" Then Return
	Picasso1.LoadUrl(imageUrl).IntoImageView(TargetImage)
End Sub

Private Sub clvNFTs_ItemClick (Index As Int, Value As Object)
	Dim pnl As B4XView = clvNFTs.GetPanel(Index)
	Dim lblNFTname As Label = FindViewByTag(pnl, "lblNFTname")

	Dim nftName As String = lblNFTname.Text
	Dim tokenId As String = Value
	Dim imageUrl As String = ""
	If pnl.Tag <> Null And pnl.Tag <> "" Then
		imageUrl = pnl.Tag
	End If

	' ✅ 添加前判断页面是否已注册
	If B4XPages.GetPage("NFTDetailPage") = Null Then
		Dim detailPage As NFTDetailPage
		detailPage.Initialize
		B4XPages.AddPage("NFTDetailPage", detailPage)
	End If

	' ✅ 获取页面实例、传值、显示页面
	Dim dp As NFTDetailPage = B4XPages.GetPage("NFTDetailPage")
	dp.SetNFTData(nftName, tokenId, imageUrl)
	B4XPages.ShowPage("NFTDetailPage")
End Sub

'Return True to close, False to cancel
Private Sub B4XPage_CloseRequest As ResumableSub
	Dim sf As Object = xui.Msgbox2Async("Are you sure you want to exit the app?", "Exit", "Yes", "", "No", Null)
	Wait For (sf) Msgbox_Result (Result As Int)
	If Result = xui.DialogResponse_Positive Then
		ExitApplication ' ✅ 彻底关闭 App，下次启动重新开始
		Return True ' 这个还是必须 return 给框架
	End If
	Return False
End Sub
