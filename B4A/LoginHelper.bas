B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=13.1
@EndOfDesignText@
' LoginHelper Class Module
Sub Class_Globals
	Private xui As XUI
	Private Timer1 As Timer
	Private CallBackPage As Object
	Private PollingCount As Int = 0
	Private MaxPolling As Int = 60       ' 最多轮询60次（3分钟）

	Private kvs As KeyValueStore
	Private rp As RuntimePermissions
	Private shared As String
End Sub

Public Sub Initialize(CallBack As Object)
	CallBackPage = CallBack
	Timer1.Initialize("Timer1", 3000)    ' 每3秒轮询
	shared = rp.GetSafeDirDefaultExternal("")
	kvs.Initialize(shared, "Userdatastore")
End Sub

' ✅ Step 1: 直接本地生成 sessionId + ergopay deeplink
Public Sub CreateLoginSession
	Dim jo As JavaObject
	Dim uuid As String = jo.InitializeStatic("java.util.UUID").RunMethod("randomUUID", Null).As(String)
	Starter.CurrentSessionId = uuid.Replace("-", "").ToLowerCase

	Dim deeplink As String = $"ergopay://${Starter.ServerURL.Replace("http://", "").Replace("https://", "")}/setAddress/${Starter.CurrentSessionId}/#P2PK_ADDRESS#"$

	CallSub2(CallBackPage, "OnLoginSessionCreated", deeplink)

	PollingCount = 0
	Timer1.Enabled = True
End Sub

' ✅ Step 2: 轮询服务器是否扫码
Private Sub Timer1_Tick
	Log("👉 [Timer1_Tick] 当前SessionId: " & Starter.CurrentSessionId)
	kvs.Put("CurrSessionId",Starter.CurrentSessionId)
	If Starter.CurrentSessionId = "" Then
		Timer1.Enabled = False
		Return
	End If

	PollingCount = PollingCount + 1
	If PollingCount >= MaxPolling Then
		Timer1.Enabled = False
		Starter.CurrentSessionId = ""
		CallSub2(CallBackPage, "OnLoginError", "等待超时，登录已取消")
		Return
	End If

	Dim j As HttpJob
	j.Initialize("", Me)
	j.Download(Starter.ServerURL & "/getUserAddress/" & Starter.CurrentSessionId)
	Wait For (j) JobDone(j As HttpJob)
	If j.Success Then
		Dim walletAddress As String = j.GetString.Trim
		Log("✅ Server返回 walletAddress: " & walletAddress)
		If walletAddress <> "" Then
			Timer1.Enabled = False
			Starter.CurrentSessionId = ""
			CallSub2(CallBackPage, "OnLoginSuccess", walletAddress)
		Else
			' ✅ 新增：显示等待钱包扫码
			CallSub2(CallBackPage, "OnWaitingForScan", "")
		End If
	Else
		Log("❌ 访问失败: " & j.ErrorMessage)
	End If
	j.Release
End Sub


' ✅ 停止轮询
Public Sub StopPolling
	Timer1.Enabled = False
End Sub

' ✅ Resume时继续轮询
Public Sub StartPolling
	If Starter.CurrentSessionId <> "" Then
		Timer1.Enabled = True
	End If
End Sub
