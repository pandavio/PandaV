B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=8
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: True
	#IncludeTitle: False
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.
	Private frontCamera As Boolean = False
	
End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.
	Private kvs As KeyValueStore
	Private camEx As CameraExClass
	Private filename As String
	Private Panel1 As Panel
	Private ChangeCamera As Button
	Private btnEffect As Button
	Private btnFocus As Button
	Private btnFlash As Button
	Private btnGallery As Button
	
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("lyCamera")
	kvs.Initialize(File.DirDefaultExternal, "Userdatastore")
	
End Sub

Private Sub InitializeCamera
	
	camEx.Initialize(Panel1, frontCamera, Me, "Camera1")
	'camEx.SetFlashMode = True
	frontCamera = camEx.Front
	
End Sub

Sub Camera1_Ready (Success As Boolean)
	
	If Success Then
		camEx.SetPictureSize(1920, 1080)
'		camEx.SetPictureSize(4096, 2304)
		camEx.SetJpegQuality(100)
		camEx.CommitParameters
		camEx.StartPreview
'		camEx.SetFlashMode("FLASH_MODE_ON")
		Log(camEx.GetPreviewSize)
	Else
		ToastMessageShow("Cannot open camera.", True)
	End If
	
End Sub

Sub Camera1_PictureTaken (Data() As Byte)
	
	Private Today As Long
	Today = DateTime.Now
	
	Private FNYear As Int
	Private FNMonth As Int
	Private FNDay As Int
	Private strFNYear As String
	Private strFNMonth As String
	Private strFNDay As String
'	Private strMobileNo As String 
	Private imgFileName As String
	Private RandomNumber As String
	
	FNYear = DateTime.GetYear (Today)
	FNMonth = DateTime.GetMonth (Today)
	FNDay = DateTime.GetDayOfMonth (Today)

	strFNYear = FNYear
	strFNMonth = Num2Place(FNMonth)
	strFNDay = Num2Place(FNDay)
'	strMobileNo = kvs.GetSimple("CurrUserMobileNo").Replace ("%","")
	RandomNumber = Rnd(1000000,9999999)
'	imgFileName = strMobileNo & "-" & strFNYear & strFNMonth & strFNDay & RandomNumber & ".jpg"
	imgFileName = strFNYear & strFNMonth & strFNDay & RandomNumber & ".jpg"
		
	filename  = imgFileName
	Private dir As String = File.DirRootExternal
	dir=dir & "/DCIM/"
	
	camEx.SavePictureToFile(Data, dir, filename)
	camEx.StartPreview 'restart preview
	
	'send a broadcast intent to the media scanner to force it to scan the saved file.
	Private Phone As Phone
	Private i As Intent
	i.Initialize("android.intent.action.MEDIA_SCANNER_SCAN_FILE", _
		"file://" & File.Combine(dir, filename))
	Phone.SendBroadcastIntent(i)
	camEx.Release

	kvs.PutSimple ("ImgFileName",filename)
	StartActivity("Preview")
	Activity.Finish
	
End Sub

Sub Num2Place(DayMonth As Int ) As String
	
	If DayMonth < 10 Then
		Return "0" & DayMonth
	Else
		Return DayMonth
	End If
	
End Sub

Sub SetPictureSize
	
	Private pictureSizes() As CameraSize = camEx.GetSupportedPicturesSizes
	camEx.SetPictureSize(4096, 2304)
	camEx.CommitParameters
		
End Sub

Sub Activity_Resume
	
	InitializeCamera
	
End Sub

Sub Activity_Pause (UserClosed As Boolean)
	
	camEx.Release
	
End Sub

Sub ChangeCamera_Click
	
	camEx.Release
	frontCamera = Not(frontCamera)
	InitializeCamera
	
End Sub

Sub btnEffect_Click
	
	Private effects As List = camEx.GetSupportedColorEffects
	If effects.IsInitialized = False Then
		ToastMessageShow("Effects not supported.", False)
		Return
	End If
	
	Private effect As String = effects.Get((effects.IndexOf(camEx.GetColorEffect) + 1) Mod effects.Size)
	camEx.SetColorEffect(effect)
	ToastMessageShow(effect, False)
	camEx.CommitParameters
	
End Sub

Sub btnFlash_Click
	
	Private f() As Float = camEx.GetFocusDistances
	Log(f(0) & ", " & f(1) & ", " & f(2))
	
	Private flashModes As List = camEx.GetSupportedFlashModes
	If flashModes.IsInitialized = False Then
		ToastMessageShow("Flash not supported.", False)
		Return
	End If
	
	Private flash As String = flashModes.Get((flashModes.IndexOf(camEx.GetFlashMode) + 1) Mod flashModes.Size)
	camEx.SetFlashMode(flash)
	ToastMessageShow(flash, False)
	camEx.CommitParameters
	
End Sub


Sub btnFocus_Click
	
	camEx.GetSupportedFocusModes 'detect AF mode
'	camEx.FocusAndTakePicture 

End Sub

Sub Activity_KeyPress (KeyCode As Int) As Boolean
	
	If KeyCode = KeyCodes.KEYCODE_BACK Then
		kvs.PutSimple ("ImgFileName","")
		Activity.Finish
		Return True
	End If
	
End Sub