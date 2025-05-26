B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=13.1
@EndOfDesignText@
' NFTDetailPage.bas
Sub Class_Globals
	Private Root As B4XView
	Private lblNFTName As Label
	Private lblNFTId As Label
	Private imgNFT As ImageView
	Private imgTokenQR As ImageView
	Private lblStatus As Label

	Private pendingName As String
	Private pendingId As String
	Private pendingImageUrl As String
	Private lastCardNumber As String

	Private kvs As KeyValueStore
	Private rp As RuntimePermissions
	Private shared As String

	Private TimerDeeplinkCheck As Timer
	Private PollCount As Int = 0
	Private MaxPolls As Int = 20
	Private PollingActive As Boolean = False ' ✅ 避免重复轮询

	Private xui As XUI ' ✅ 声明 xui
	Private B4xLoading As B4XLoadingIndicator
End Sub

Public Sub Initialize
	shared = rp.GetSafeDirDefaultExternal("")
	kvs.Initialize(shared, "Userdatastore")
End Sub

Private Sub B4XPage_Created (Root1 As B4XView)
	Root = Root1
	Root.LoadLayout("NFTDetailPage")
	TimerDeeplinkCheck.Initialize("TimerDeeplinkCheck", 3000)
End Sub

Public Sub SetNFTData(name As String, tokenId As String, imageUrl As String)
	pendingName = name
	pendingId = tokenId
	pendingImageUrl = imageUrl
End Sub

Private Sub B4XPage_Appear
	lblNFTName.Text = pendingName
	lblNFTId.Text   = pendingId

	If pendingImageUrl.StartsWith("ipfs://") Then
		pendingImageUrl = pendingImageUrl.Replace("ipfs://","https://ipfs.io/ipfs/")
	End If
	If pendingImageUrl <> "" Then
		Dim pic As Picasso: pic.Initialize
		pic.LoadUrl(pendingImageUrl).IntoImageView(imgNFT)
	End If
	
	lastCardNumber = ConvertTokenIdToWiegand26(pendingId)
	If lastCardNumber = "" Then
		lblStatus.Text = "⚠️ 无法生成卡号"
		Log("Wiegand26 生成失败 for " & pendingId)
		Return
	End If
	Dim qr As QRcode: qr.Initialize
	imgTokenQR.Bitmap = qr.DrawQRCode(lastCardNumber)
	Log("🟦 QR generated: " & lastCardNumber)
	lblStatus.Text = "绑定卡号中…"
	
	Dim sessionId As String = kvs.GetDefault("CurrSessionId","")
	If sessionId = "" Then
		lblStatus.Text = "⚠️ 未登录，无法绑定卡号"
		Log("No sessionId in kvs!")
		Return
	End If

	Dim payload As String = $"{"sessionId":"${sessionId}","card":"${lastCardNumber}"}"$
	Log("▶️ Binding payload: " & payload)
	Dim jBind As HttpJob
	jBind.Initialize("BindCard", Me)
	jBind.PostString(Starter.ServerURL & "/bindCardToSession", payload)
	jBind.GetRequest.SetContentType("application/json")

	PollCount = 0
	PollingActive = True
	TimerDeeplinkCheck.Enabled = True
End Sub

Public Sub OnCardScanned(cardNumber As String)
	lastCardNumber = cardNumber
	Log(">>> OnCardScanned: " & cardNumber)
	lblStatus.Text = "🚪 等待刷卡…"
	PollCount = 0
	PollingActive = True
	TimerDeeplinkCheck.Enabled = True
End Sub

Private Sub TimerDeeplinkCheck_Tick
	If Not(PollingActive) Then Return
	TimerDeeplinkCheck.Enabled = False
	PollCount = PollCount + 1
	Log("🔁 Timer tick: PollCount = " & PollCount & ", Card = " & lastCardNumber)
	If PollCount > MaxPolls Then
		lblStatus.Text = "⚠️ 开门超时，请重试"
		PollingActive = False
		Return
	End If
	Dim j As HttpJob
	j.Initialize("AccessStatus", Me)
	j.Download(Starter.ServerURL & "/accessStatus/" & lastCardNumber)
End Sub

Private Sub JobDone(job As HttpJob) As ResumableSub
	If job.Success Then
		Select job.JobName
			Case "BindCard"
				If job.GetString = "bound" Then
					lblStatus.Text = "✅ 绑卡成功，等待刷卡"
				Else
					lblStatus.Text = "❌ 绑卡失败: " & job.GetString
				End If

			Case "AccessStatus"
				If job.GetString.StartsWith("valid") Then
					Dim parts() As String = Regex.Split(":", job.GetString)
					If parts.Length > 1 Then
						Dim txid As String = parts(1).Replace(QUOTE, "")
						Log("✅ Transaction ID: " & txid)

						lblStatus.Text = "🔄 提交区块链…"
						B4xLoading.Show ' 显示加载动画

						Sleep(8000)
						lblStatus.Text = "✅ 开门成功"
						PollingActive = False
						Sleep(2000)
						B4xLoading.Hide ' 隐藏加载动画
						Dim url As String = $"https://explorer.ergoplatform.com/transactions/${txid}"$
						Dim p As PhoneIntents
						StartActivity(p.OpenBrowser(url))
						

					End If

				Else
					lblStatus.Text = "🚪 等待刷卡…"
					TimerDeeplinkCheck.Enabled = True
				End If


		End Select
	Else
		lblStatus.Text = "⚠️ 网络错误: " & job.ErrorMessage
	End If
	job.Release
End Sub

Private Sub B4XPage_Disappear
	TimerDeeplinkCheck.Enabled = False
	PollingActive = False
	lblStatus.Text = ""
End Sub

Private Sub ConvertTokenIdToWiegand26(tokenId As String) As String
	If tokenId = "" Then Return ""
	If tokenId.Length >= 6 Then
		Dim s As String = tokenId.SubString2(0, 6)
		Dim v As Long = Bit.ParseInt(s, 16) Mod 67108864
		Return NumberFormat2(v, 8, 0, 0, False)
	Else
		Return tokenId
	End If
End Sub
