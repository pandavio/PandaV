B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=12.8
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: False
	#IncludeTitle: False
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.

End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.
	Private kvs As KeyValueStore
	Private rp As RuntimePermissions
	Private shared As String
	Private SQL1 As SQL
	Private cursor2, cursorSetting As Cursor
	Dim zx As JhsIceZxing1
	Private lblTopic As Label
	Private imgicon1 As ImageView
	Private imgicon2 As ImageView
	Private imgicon3 As ImageView
	Private lblicon1 As Label
	Private lblicon2 As Label
	Private lblicon3 As Label
	Private lblSpline1 As Label
	Private lblSpline2 As Label
	Private clv1 As CustomListView
	Private lblDisplayName As Label
	Private lbluid As Label
	Private imgAvatar As ImageView
	Private lblTitle As Label
	Private lblBalance As Label
	Private lblFooter As Label

	Private lblDate2 As Label
	Private lblDot1 As Label
	Private lblDate1 As Label
	Private lblDesc2 As Label
	Private lblStatus2 As Label
	Private lblDot2 As Label
	Private lblStatus1 As Label
	Private lblGateway As Label
	Private lblDot3 As Label
	Private lblDesc1 As Label
	Private imgStatus As ImageView

	Private Label1 As Label
	Private Label2 As Label
	Private Label3 As Label
	Private Label4 As Label
	Private Label5 As Label
	Private Label6 As Label
	Private Label7 As Label
	Private Label8 As Label
	Private Label9 As Label
	Private Label10 As Label
	Private ImageView1 As ImageView
	Private Label11 As Label
	Private Label12 As Label
	Private Label13 As Label
	Private Label14 As Label
	Private Label15 As Label
	Private Label16 As Label
	Private Label17 As Label
	Private Label18 As Label
	Private Label19 As Label
	Private Label20 As Label
	Private ImageView2 As ImageView
	Private Label21 As Label
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("HomeLy")

	shared = rp.GetSafeDirDefaultExternal("")
	kvs.Initialize(shared, "Userdatastore")
	
	If File.Exists(File.DirDefaultExternal ,"db.db") = False Then
		File.Copy(File.DirAssets,"db.db",File.DirDefaultExternal,"db.db")
	End If
	
	If SQL1.IsInitialized = False Then
		SQL1.Initialize(File.DirDefaultExternal, "db.db", False)
	End If
	
	If kvs.ContainsKey("CurrLanguage") = False Then
		kvs.Put("CurrLanguage","English")
	End If


	

End Sub


Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub


Private Sub lblStatus2_Click
	StartActivity("QRMd")
End Sub

Private Sub imgStatus_Click
	StartActivity("QRMd")
End Sub

Private Sub imgicon1_Click
	zx.isportrait = True
	zx.useFrontCam = False

	'set the timeoutDuration to a very high value (such as 2000000000) if you dont want it to time out
	'2000000000 = 63 years+
	zx.timeoutDuration = 30

	'change these factors between 0 and 1 to change the size of the viewfinder rectangle
	'the library will limit the minimum size to 240 x 240 pixels and the maximum to (screen width) x   (screen height) pixels
	zx.theViewFinderXfactor = 0.7
	zx.theViewFinderYfactor = 0.4

	zx.theFrameColor = Colors.Black
	zx.theLaserColor = Colors.Red
	zx.theMaskColor = Colors.Black
	zx.theResultColor = Colors.Black
	zx.theResultPointColor = Colors.White

'	'set the prompt messages
'	zx.theTopPromptMessage = "This was done......"
'	zx.theTopPromptTextSize = 5%y'text size in pixels
'	zx.topPromptColor = Colors.Red
'	zx.topPromptDistanceFromTop = 1%y'pixel distance from top
'
'	zx.theBottomPromptMessage = "Just for fun......"
'	zx.theBottomPromptTextSize = 5%y'text size in pixels
'	zx.bottomPromptColor = Colors.Blue
'	zx.bottomPromptDistanceFromBottom = 5%y'pixel distance from top



	zx.BeginScan("myzx")
End Sub

Private Sub lblicon1_Click
	zx.isportrait = True
	zx.useFrontCam = False
	
	'change these factors between 0 and 1
	'the library will limit the minimum size to 240 x 240 pixels and the maximum to (screen width) x (screen height pixels)
	'  zx.theViewFinderXfactor = 0.7
	'  zx.theViewFinderYfactor = 0.5

	zx.theViewFinderXfactor = 0.7
	zx.theViewFinderYfactor = 0.4
	
	zx.theFrameColor = Colors.Black
	zx.theLaserColor = Colors.Red
	zx.theMaskColor = Colors.Black
	zx.theResultColor = Colors.Black
	zx.theResultPointColor = Colors.White
	zx.BeginScan("myzx")
End Sub

Sub myzx_result(atype As String, Value As String, image As Bitmap)

    Log("type:" & atype &  "Value:" & Value)
	Msgbox(Value,"NFT Access: " & "INVALID")

End Sub

Sub myzx_timedout(timedOut As Boolean)
	Log("timedOut " & timedOut)

End Sub

Sub myzx_usercancelled(userCancelled As Boolean)
	Log("userCancelled " & userCancelled)

End Sub

Sub Activity_KeyPress (KeyCode As Int) As Boolean

	If KeyCode = KeyCodes.KEYCODE_BACK Then
		
		Dim str1 As String
		Dim str2 As String
		
		Select Case "English" 'kvs.GetSimple("CurrLanguage")
			Case "中文"
				str1 = "确定要离开吗?"
				str2 = "温馨提醒"
			Case "English"
				str1 = "Are You Sure Want to Exit?"
				str2 = "Reminder"
		End Select
		
		Select Msgbox2(str1,str2,"Yes","","No",Null)
			Case DialogResponse.POSITIVE
'				CallSubDelayed(FirebaseMessaging, "UnSubscribeToTopics")
				kvs.Put("LEAVE","YES")
				kvs.put("Logout","NO")
				Activity.Finish
			Case Else
				Return True
		End Select
	End If
  
End Sub