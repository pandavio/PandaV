B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Service
Version=9.85
@EndOfDesignText@
' Starter Service
#Region  Service Attributes
    #StartAtBoot: False
    #ExcludeFromLibrary: True
#End Region

Sub Process_Globals
	' ✅ 当前登录Session Id
	Public CurrentSessionId As String
	Public LoginSessionId As String
	' ✅ 后端服务器地址
	'domain需要https，TLS Error
	Public ServerURL As String
End Sub

Sub Service_Create
	Dim props As Map = File.ReadMap(File.DirAssets, "config.txt")
	ServerURL = props.Get("server_url")
End Sub

Sub Service_Start (StartingIntent As Intent)
	Service.StopAutomaticForeground
End Sub

Sub Service_TaskRemoved
End Sub

Sub Application_Error (Error As Exception, StackTrace As String) As Boolean
	Return True
End Sub

Sub Service_Destroy
End Sub
