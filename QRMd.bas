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

	Private lblTop As Label
	Private imgBack As ImageView
	Private imgQR As ImageView
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
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("QrLy")

End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub


Private Sub imgBack_Click
	Activity.Finish
End Sub