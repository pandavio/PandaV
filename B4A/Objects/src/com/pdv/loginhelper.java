package com.pdv;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class loginhelper extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "com.pdv.loginhelper");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", com.pdv.loginhelper.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public anywheresoftware.b4a.objects.Timer _timer1 = null;
public Object _callbackpage = null;
public int _pollingcount = 0;
public int _maxpolling = 0;
public b4a.example3.keyvaluestore _kvs = null;
public anywheresoftware.b4a.objects.RuntimePermissions _rp = null;
public String _shared = "";
public b4a.example.dateutils _dateutils = null;
public com.pdv.main _main = null;
public com.pdv.starter _starter = null;
public com.pdv.b4xpages _b4xpages = null;
public com.pdv.b4xcollections _b4xcollections = null;
public com.pdv.httputils2service _httputils2service = null;
public com.pdv.xuiviewsutils _xuiviewsutils = null;
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 2;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 3;BA.debugLine="Private xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 4;BA.debugLine="Private Timer1 As Timer";
_timer1 = new anywheresoftware.b4a.objects.Timer();
 //BA.debugLineNum = 5;BA.debugLine="Private CallBackPage As Object";
_callbackpage = new Object();
 //BA.debugLineNum = 6;BA.debugLine="Private PollingCount As Int = 0";
_pollingcount = (int) (0);
 //BA.debugLineNum = 7;BA.debugLine="Private MaxPolling As Int = 60       ' 最多轮询60次（3分";
_maxpolling = (int) (60);
 //BA.debugLineNum = 9;BA.debugLine="Private kvs As KeyValueStore";
_kvs = new b4a.example3.keyvaluestore();
 //BA.debugLineNum = 10;BA.debugLine="Private rp As RuntimePermissions";
_rp = new anywheresoftware.b4a.objects.RuntimePermissions();
 //BA.debugLineNum = 11;BA.debugLine="Private shared As String";
_shared = "";
 //BA.debugLineNum = 12;BA.debugLine="End Sub";
return "";
}
public String  _createloginsession() throws Exception{
anywheresoftware.b4j.object.JavaObject _jo = null;
String _uuid = "";
String _deeplink = "";
 //BA.debugLineNum = 22;BA.debugLine="Public Sub CreateLoginSession";
 //BA.debugLineNum = 23;BA.debugLine="Dim jo As JavaObject";
_jo = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 24;BA.debugLine="Dim uuid As String = jo.InitializeStatic(\"java.ut";
_uuid = (BA.ObjectToString(_jo.InitializeStatic("java.util.UUID").RunMethod("randomUUID",(Object[])(__c.Null))));
 //BA.debugLineNum = 25;BA.debugLine="Starter.CurrentSessionId = uuid.Replace(\"-\", \"\").";
_starter._currentsessionid /*String*/  = _uuid.replace("-","").toLowerCase();
 //BA.debugLineNum = 27;BA.debugLine="Dim deeplink As String = $\"ergopay://${Starter.Se";
_deeplink = ("ergopay://"+__c.SmartStringFormatter("",(Object)(_starter._serverurl /*String*/ .replace("http://","").replace("https://","")))+"/setAddress/"+__c.SmartStringFormatter("",(Object)(_starter._currentsessionid /*String*/ ))+"/#P2PK_ADDRESS#");
 //BA.debugLineNum = 29;BA.debugLine="CallSub2(CallBackPage, \"OnLoginSessionCreated\", d";
__c.CallSubNew2(ba,_callbackpage,"OnLoginSessionCreated",(Object)(_deeplink));
 //BA.debugLineNum = 31;BA.debugLine="PollingCount = 0";
_pollingcount = (int) (0);
 //BA.debugLineNum = 32;BA.debugLine="Timer1.Enabled = True";
_timer1.setEnabled(__c.True);
 //BA.debugLineNum = 33;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba,Object _callback) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 14;BA.debugLine="Public Sub Initialize(CallBack As Object)";
 //BA.debugLineNum = 15;BA.debugLine="CallBackPage = CallBack";
_callbackpage = _callback;
 //BA.debugLineNum = 16;BA.debugLine="Timer1.Initialize(\"Timer1\", 3000)    ' 每3秒轮询";
_timer1.Initialize(ba,"Timer1",(long) (3000));
 //BA.debugLineNum = 17;BA.debugLine="shared = rp.GetSafeDirDefaultExternal(\"\")";
_shared = _rp.GetSafeDirDefaultExternal("");
 //BA.debugLineNum = 18;BA.debugLine="kvs.Initialize(shared, \"Userdatastore\")";
_kvs._initialize(ba,_shared,"Userdatastore");
 //BA.debugLineNum = 19;BA.debugLine="End Sub";
return "";
}
public String  _startpolling() throws Exception{
 //BA.debugLineNum = 80;BA.debugLine="Public Sub StartPolling";
 //BA.debugLineNum = 81;BA.debugLine="If Starter.CurrentSessionId <> \"\" Then";
if ((_starter._currentsessionid /*String*/ ).equals("") == false) { 
 //BA.debugLineNum = 82;BA.debugLine="Timer1.Enabled = True";
_timer1.setEnabled(__c.True);
 };
 //BA.debugLineNum = 84;BA.debugLine="End Sub";
return "";
}
public String  _stoppolling() throws Exception{
 //BA.debugLineNum = 75;BA.debugLine="Public Sub StopPolling";
 //BA.debugLineNum = 76;BA.debugLine="Timer1.Enabled = False";
_timer1.setEnabled(__c.False);
 //BA.debugLineNum = 77;BA.debugLine="End Sub";
return "";
}
public void  _timer1_tick() throws Exception{
ResumableSub_Timer1_Tick rsub = new ResumableSub_Timer1_Tick(this);
rsub.resume(ba, null);
}
public static class ResumableSub_Timer1_Tick extends BA.ResumableSub {
public ResumableSub_Timer1_Tick(com.pdv.loginhelper parent) {
this.parent = parent;
}
com.pdv.loginhelper parent;
com.pdv.httpjob _j = null;
String _walletaddress = "";

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 37;BA.debugLine="Log(\"👉 [Timer1_Tick] 当前SessionId: \" & Starter.Cu";
parent.__c.LogImpl("82621441","👉 [Timer1_Tick] 当前SessionId: "+parent._starter._currentsessionid /*String*/ ,0);
 //BA.debugLineNum = 38;BA.debugLine="kvs.Put(\"CurrSessionId\",Starter.CurrentSessionId)";
parent._kvs._put("CurrSessionId",(Object)(parent._starter._currentsessionid /*String*/ ));
 //BA.debugLineNum = 39;BA.debugLine="If Starter.CurrentSessionId = \"\" Then";
if (true) break;

case 1:
//if
this.state = 4;
if ((parent._starter._currentsessionid /*String*/ ).equals("")) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 //BA.debugLineNum = 40;BA.debugLine="Timer1.Enabled = False";
parent._timer1.setEnabled(parent.__c.False);
 //BA.debugLineNum = 41;BA.debugLine="Return";
if (true) return ;
 if (true) break;

case 4:
//C
this.state = 5;
;
 //BA.debugLineNum = 44;BA.debugLine="PollingCount = PollingCount + 1";
parent._pollingcount = (int) (parent._pollingcount+1);
 //BA.debugLineNum = 45;BA.debugLine="If PollingCount >= MaxPolling Then";
if (true) break;

case 5:
//if
this.state = 8;
if (parent._pollingcount>=parent._maxpolling) { 
this.state = 7;
}if (true) break;

case 7:
//C
this.state = 8;
 //BA.debugLineNum = 46;BA.debugLine="Timer1.Enabled = False";
parent._timer1.setEnabled(parent.__c.False);
 //BA.debugLineNum = 47;BA.debugLine="Starter.CurrentSessionId = \"\"";
parent._starter._currentsessionid /*String*/  = "";
 //BA.debugLineNum = 48;BA.debugLine="CallSub2(CallBackPage, \"OnLoginError\", \"等待超时，登录已";
parent.__c.CallSubNew2(ba,parent._callbackpage,"OnLoginError",(Object)("等待超时，登录已取消"));
 //BA.debugLineNum = 49;BA.debugLine="Return";
if (true) return ;
 if (true) break;

case 8:
//C
this.state = 9;
;
 //BA.debugLineNum = 52;BA.debugLine="Dim j As HttpJob";
_j = new com.pdv.httpjob();
 //BA.debugLineNum = 53;BA.debugLine="j.Initialize(\"\", Me)";
_j._initialize /*String*/ (ba,"",parent);
 //BA.debugLineNum = 54;BA.debugLine="j.Download(Starter.ServerURL & \"/getUserAddress/\"";
_j._download /*String*/ (parent._starter._serverurl /*String*/ +"/getUserAddress/"+parent._starter._currentsessionid /*String*/ );
 //BA.debugLineNum = 55;BA.debugLine="Wait For (j) JobDone(j As HttpJob)";
parent.__c.WaitFor("jobdone", ba, this, (Object)(_j));
this.state = 21;
return;
case 21:
//C
this.state = 9;
_j = (com.pdv.httpjob) result[0];
;
 //BA.debugLineNum = 56;BA.debugLine="If j.Success Then";
if (true) break;

case 9:
//if
this.state = 20;
if (_j._success /*boolean*/ ) { 
this.state = 11;
}else {
this.state = 19;
}if (true) break;

case 11:
//C
this.state = 12;
 //BA.debugLineNum = 57;BA.debugLine="Dim walletAddress As String = j.GetString.Trim";
_walletaddress = _j._getstring /*String*/ ().trim();
 //BA.debugLineNum = 58;BA.debugLine="Log(\"✅ Server返回 walletAddress: \" & walletAddress";
parent.__c.LogImpl("82621462","✅ Server返回 walletAddress: "+_walletaddress,0);
 //BA.debugLineNum = 59;BA.debugLine="If walletAddress <> \"\" Then";
if (true) break;

case 12:
//if
this.state = 17;
if ((_walletaddress).equals("") == false) { 
this.state = 14;
}else {
this.state = 16;
}if (true) break;

case 14:
//C
this.state = 17;
 //BA.debugLineNum = 60;BA.debugLine="Timer1.Enabled = False";
parent._timer1.setEnabled(parent.__c.False);
 //BA.debugLineNum = 61;BA.debugLine="Starter.CurrentSessionId = \"\"";
parent._starter._currentsessionid /*String*/  = "";
 //BA.debugLineNum = 62;BA.debugLine="CallSub2(CallBackPage, \"OnLoginSuccess\", wallet";
parent.__c.CallSubNew2(ba,parent._callbackpage,"OnLoginSuccess",(Object)(_walletaddress));
 if (true) break;

case 16:
//C
this.state = 17;
 //BA.debugLineNum = 65;BA.debugLine="CallSub2(CallBackPage, \"OnWaitingForScan\", \"\")";
parent.__c.CallSubNew2(ba,parent._callbackpage,"OnWaitingForScan",(Object)(""));
 if (true) break;

case 17:
//C
this.state = 20;
;
 if (true) break;

case 19:
//C
this.state = 20;
 //BA.debugLineNum = 68;BA.debugLine="Log(\"❌ 访问失败: \" & j.ErrorMessage)";
parent.__c.LogImpl("82621472","❌ 访问失败: "+_j._errormessage /*String*/ ,0);
 if (true) break;

case 20:
//C
this.state = -1;
;
 //BA.debugLineNum = 70;BA.debugLine="j.Release";
_j._release /*String*/ ();
 //BA.debugLineNum = 71;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public void  _jobdone(com.pdv.httpjob _j) throws Exception{
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
