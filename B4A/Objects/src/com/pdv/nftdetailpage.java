package com.pdv;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class nftdetailpage extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "com.pdv.nftdetailpage");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", com.pdv.nftdetailpage.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _root = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblnftname = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblnftid = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imgnft = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imgtokenqr = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblstatus = null;
public String _pendingname = "";
public String _pendingid = "";
public String _pendingimageurl = "";
public String _lastcardnumber = "";
public b4a.example3.keyvaluestore _kvs = null;
public anywheresoftware.b4a.objects.RuntimePermissions _rp = null;
public String _shared = "";
public anywheresoftware.b4a.objects.Timer _timerdeeplinkcheck = null;
public int _pollcount = 0;
public int _maxpolls = 0;
public boolean _pollingactive = false;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public com.pdv.b4xloadingindicator _b4xloading = null;
public b4a.example.dateutils _dateutils = null;
public com.pdv.main _main = null;
public com.pdv.starter _starter = null;
public com.pdv.b4xpages _b4xpages = null;
public com.pdv.b4xcollections _b4xcollections = null;
public com.pdv.httputils2service _httputils2service = null;
public com.pdv.xuiviewsutils _xuiviewsutils = null;
public String  _b4xpage_appear() throws Exception{
uk.co.martinpearman.b4a.squareup.picasso.Picasso _pic = null;
com.pdv.qrcode _qr = null;
String _sessionid = "";
String _payload = "";
com.pdv.httpjob _jbind = null;
 //BA.debugLineNum = 45;BA.debugLine="Private Sub B4XPage_Appear";
 //BA.debugLineNum = 46;BA.debugLine="lblNFTName.Text = pendingName";
_lblnftname.setText(BA.ObjectToCharSequence(_pendingname));
 //BA.debugLineNum = 47;BA.debugLine="lblNFTId.Text   = pendingId";
_lblnftid.setText(BA.ObjectToCharSequence(_pendingid));
 //BA.debugLineNum = 49;BA.debugLine="If pendingImageUrl.StartsWith(\"ipfs://\") Then";
if (_pendingimageurl.startsWith("ipfs://")) { 
 //BA.debugLineNum = 50;BA.debugLine="pendingImageUrl = pendingImageUrl.Replace(\"ipfs:";
_pendingimageurl = _pendingimageurl.replace("ipfs://","https://ipfs.io/ipfs/");
 };
 //BA.debugLineNum = 52;BA.debugLine="If pendingImageUrl <> \"\" Then";
if ((_pendingimageurl).equals("") == false) { 
 //BA.debugLineNum = 53;BA.debugLine="Dim pic As Picasso: pic.Initialize";
_pic = new uk.co.martinpearman.b4a.squareup.picasso.Picasso();
 //BA.debugLineNum = 53;BA.debugLine="Dim pic As Picasso: pic.Initialize";
_pic.Initialize(ba);
 //BA.debugLineNum = 54;BA.debugLine="pic.LoadUrl(pendingImageUrl).IntoImageView(imgNF";
_pic.LoadUrl(_pendingimageurl).IntoImageView((android.widget.ImageView)(_imgnft.getObject()));
 };
 //BA.debugLineNum = 57;BA.debugLine="lastCardNumber = ConvertTokenIdToWiegand26(pendin";
_lastcardnumber = _converttokenidtowiegand26(_pendingid);
 //BA.debugLineNum = 58;BA.debugLine="If lastCardNumber = \"\" Then";
if ((_lastcardnumber).equals("")) { 
 //BA.debugLineNum = 59;BA.debugLine="lblStatus.Text = \"⚠️ 无法生成卡号\"";
_lblstatus.setText(BA.ObjectToCharSequence("⚠️ 无法生成卡号"));
 //BA.debugLineNum = 60;BA.debugLine="Log(\"Wiegand26 生成失败 for \" & pendingId)";
__c.LogImpl("8851983","Wiegand26 生成失败 for "+_pendingid,0);
 //BA.debugLineNum = 61;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 63;BA.debugLine="Dim qr As QRcode: qr.Initialize";
_qr = new com.pdv.qrcode();
 //BA.debugLineNum = 63;BA.debugLine="Dim qr As QRcode: qr.Initialize";
_qr._initialize /*String*/ (ba);
 //BA.debugLineNum = 64;BA.debugLine="imgTokenQR.Bitmap = qr.DrawQRCode(lastCardNumber)";
_imgtokenqr.setBitmap((android.graphics.Bitmap)(_qr._drawqrcode /*anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper*/ (_lastcardnumber).getObject()));
 //BA.debugLineNum = 65;BA.debugLine="Log(\"🟦 QR generated: \" & lastCardNumber)";
__c.LogImpl("8851988","🟦 QR generated: "+_lastcardnumber,0);
 //BA.debugLineNum = 66;BA.debugLine="lblStatus.Text = \"绑定卡号中…\"";
_lblstatus.setText(BA.ObjectToCharSequence("绑定卡号中…"));
 //BA.debugLineNum = 68;BA.debugLine="Dim sessionId As String = kvs.GetDefault(\"CurrSes";
_sessionid = BA.ObjectToString(_kvs._getdefault("CurrSessionId",(Object)("")));
 //BA.debugLineNum = 69;BA.debugLine="If sessionId = \"\" Then";
if ((_sessionid).equals("")) { 
 //BA.debugLineNum = 70;BA.debugLine="lblStatus.Text = \"⚠️ 未登录，无法绑定卡号\"";
_lblstatus.setText(BA.ObjectToCharSequence("⚠️ 未登录，无法绑定卡号"));
 //BA.debugLineNum = 71;BA.debugLine="Log(\"No sessionId in kvs!\")";
__c.LogImpl("8851994","No sessionId in kvs!",0);
 //BA.debugLineNum = 72;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 75;BA.debugLine="Dim payload As String = $\"{\"sessionId\":\"${session";
_payload = ("{\"sessionId\":\""+__c.SmartStringFormatter("",(Object)(_sessionid))+"\",\"card\":\""+__c.SmartStringFormatter("",(Object)(_lastcardnumber))+"\"}");
 //BA.debugLineNum = 76;BA.debugLine="Log(\"▶️ Binding payload: \" & payload)";
__c.LogImpl("8851999","▶️ Binding payload: "+_payload,0);
 //BA.debugLineNum = 77;BA.debugLine="Dim jBind As HttpJob";
_jbind = new com.pdv.httpjob();
 //BA.debugLineNum = 78;BA.debugLine="jBind.Initialize(\"BindCard\", Me)";
_jbind._initialize /*String*/ (ba,"BindCard",this);
 //BA.debugLineNum = 79;BA.debugLine="jBind.PostString(Starter.ServerURL & \"/bindCardTo";
_jbind._poststring /*String*/ (_starter._serverurl /*String*/ +"/bindCardToSession",_payload);
 //BA.debugLineNum = 80;BA.debugLine="jBind.GetRequest.SetContentType(\"application/json";
_jbind._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ ().SetContentType("application/json");
 //BA.debugLineNum = 82;BA.debugLine="PollCount = 0";
_pollcount = (int) (0);
 //BA.debugLineNum = 83;BA.debugLine="PollingActive = True";
_pollingactive = __c.True;
 //BA.debugLineNum = 84;BA.debugLine="TimerDeeplinkCheck.Enabled = True";
_timerdeeplinkcheck.setEnabled(__c.True);
 //BA.debugLineNum = 85;BA.debugLine="End Sub";
return "";
}
public String  _b4xpage_created(anywheresoftware.b4a.objects.B4XViewWrapper _root1) throws Exception{
 //BA.debugLineNum = 33;BA.debugLine="Private Sub B4XPage_Created (Root1 As B4XView)";
 //BA.debugLineNum = 34;BA.debugLine="Root = Root1";
_root = _root1;
 //BA.debugLineNum = 35;BA.debugLine="Root.LoadLayout(\"NFTDetailPage\")";
_root.LoadLayout("NFTDetailPage",ba);
 //BA.debugLineNum = 36;BA.debugLine="TimerDeeplinkCheck.Initialize(\"TimerDeeplinkCheck";
_timerdeeplinkcheck.Initialize(ba,"TimerDeeplinkCheck",(long) (3000));
 //BA.debugLineNum = 37;BA.debugLine="End Sub";
return "";
}
public String  _b4xpage_disappear() throws Exception{
 //BA.debugLineNum = 156;BA.debugLine="Private Sub B4XPage_Disappear";
 //BA.debugLineNum = 157;BA.debugLine="TimerDeeplinkCheck.Enabled = False";
_timerdeeplinkcheck.setEnabled(__c.False);
 //BA.debugLineNum = 158;BA.debugLine="PollingActive = False";
_pollingactive = __c.False;
 //BA.debugLineNum = 159;BA.debugLine="lblStatus.Text = \"\"";
_lblstatus.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 160;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 2;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 3;BA.debugLine="Private Root As B4XView";
_root = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 4;BA.debugLine="Private lblNFTName As Label";
_lblnftname = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 5;BA.debugLine="Private lblNFTId As Label";
_lblnftid = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 6;BA.debugLine="Private imgNFT As ImageView";
_imgnft = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 7;BA.debugLine="Private imgTokenQR As ImageView";
_imgtokenqr = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 8;BA.debugLine="Private lblStatus As Label";
_lblstatus = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 10;BA.debugLine="Private pendingName As String";
_pendingname = "";
 //BA.debugLineNum = 11;BA.debugLine="Private pendingId As String";
_pendingid = "";
 //BA.debugLineNum = 12;BA.debugLine="Private pendingImageUrl As String";
_pendingimageurl = "";
 //BA.debugLineNum = 13;BA.debugLine="Private lastCardNumber As String";
_lastcardnumber = "";
 //BA.debugLineNum = 15;BA.debugLine="Private kvs As KeyValueStore";
_kvs = new b4a.example3.keyvaluestore();
 //BA.debugLineNum = 16;BA.debugLine="Private rp As RuntimePermissions";
_rp = new anywheresoftware.b4a.objects.RuntimePermissions();
 //BA.debugLineNum = 17;BA.debugLine="Private shared As String";
_shared = "";
 //BA.debugLineNum = 19;BA.debugLine="Private TimerDeeplinkCheck As Timer";
_timerdeeplinkcheck = new anywheresoftware.b4a.objects.Timer();
 //BA.debugLineNum = 20;BA.debugLine="Private PollCount As Int = 0";
_pollcount = (int) (0);
 //BA.debugLineNum = 21;BA.debugLine="Private MaxPolls As Int = 20";
_maxpolls = (int) (20);
 //BA.debugLineNum = 22;BA.debugLine="Private PollingActive As Boolean = False ' ✅ 避免重复";
_pollingactive = __c.False;
 //BA.debugLineNum = 24;BA.debugLine="Private xui As XUI ' ✅ 声明 xui";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 25;BA.debugLine="Private B4xLoading As B4XLoadingIndicator";
_b4xloading = new com.pdv.b4xloadingindicator();
 //BA.debugLineNum = 26;BA.debugLine="End Sub";
return "";
}
public String  _converttokenidtowiegand26(String _tokenid) throws Exception{
String _s = "";
long _v = 0L;
 //BA.debugLineNum = 162;BA.debugLine="Private Sub ConvertTokenIdToWiegand26(tokenId As S";
 //BA.debugLineNum = 163;BA.debugLine="If tokenId = \"\" Then Return \"\"";
if ((_tokenid).equals("")) { 
if (true) return "";};
 //BA.debugLineNum = 164;BA.debugLine="If tokenId.Length >= 6 Then";
if (_tokenid.length()>=6) { 
 //BA.debugLineNum = 165;BA.debugLine="Dim s As String = tokenId.SubString2(0, 6)";
_s = _tokenid.substring((int) (0),(int) (6));
 //BA.debugLineNum = 166;BA.debugLine="Dim v As Long = Bit.ParseInt(s, 16) Mod 67108864";
_v = (long) (__c.Bit.ParseInt(_s,(int) (16))%67108864);
 //BA.debugLineNum = 167;BA.debugLine="Return NumberFormat2(v, 8, 0, 0, False)";
if (true) return __c.NumberFormat2(_v,(int) (8),(int) (0),(int) (0),__c.False);
 }else {
 //BA.debugLineNum = 169;BA.debugLine="Return tokenId";
if (true) return _tokenid;
 };
 //BA.debugLineNum = 171;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 28;BA.debugLine="Public Sub Initialize";
 //BA.debugLineNum = 29;BA.debugLine="shared = rp.GetSafeDirDefaultExternal(\"\")";
_shared = _rp.GetSafeDirDefaultExternal("");
 //BA.debugLineNum = 30;BA.debugLine="kvs.Initialize(shared, \"Userdatastore\")";
_kvs._initialize(ba,_shared,"Userdatastore");
 //BA.debugLineNum = 31;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.keywords.Common.ResumableSubWrapper  _jobdone(com.pdv.httpjob _job) throws Exception{
ResumableSub_JobDone rsub = new ResumableSub_JobDone(this,_job);
rsub.resume(ba, null);
return (anywheresoftware.b4a.keywords.Common.ResumableSubWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.keywords.Common.ResumableSubWrapper(), rsub);
}
public static class ResumableSub_JobDone extends BA.ResumableSub {
public ResumableSub_JobDone(com.pdv.nftdetailpage parent,com.pdv.httpjob _job) {
this.parent = parent;
this._job = _job;
}
com.pdv.nftdetailpage parent;
com.pdv.httpjob _job;
String[] _parts = null;
String _txid = "";
String _url = "";
anywheresoftware.b4a.phone.Phone.PhoneIntents _p = null;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
{
parent.__c.ReturnFromResumableSub(this,null);return;}
case 0:
//C
this.state = 1;
 //BA.debugLineNum = 112;BA.debugLine="If job.Success Then";
if (true) break;

case 1:
//if
this.state = 28;
if (_job._success /*boolean*/ ) { 
this.state = 3;
}else {
this.state = 27;
}if (true) break;

case 3:
//C
this.state = 4;
 //BA.debugLineNum = 113;BA.debugLine="Select job.JobName";
if (true) break;

case 4:
//select
this.state = 25;
switch (BA.switchObjectToInt(_job._jobname /*String*/ ,"BindCard","AccessStatus")) {
case 0: {
this.state = 6;
if (true) break;
}
case 1: {
this.state = 14;
if (true) break;
}
}
if (true) break;

case 6:
//C
this.state = 7;
 //BA.debugLineNum = 115;BA.debugLine="If job.GetString = \"bound\" Then";
if (true) break;

case 7:
//if
this.state = 12;
if ((_job._getstring /*String*/ ()).equals("bound")) { 
this.state = 9;
}else {
this.state = 11;
}if (true) break;

case 9:
//C
this.state = 12;
 //BA.debugLineNum = 116;BA.debugLine="lblStatus.Text = \"✅ 绑卡成功，等待刷卡\"";
parent._lblstatus.setText(BA.ObjectToCharSequence("✅ 绑卡成功，等待刷卡"));
 if (true) break;

case 11:
//C
this.state = 12;
 //BA.debugLineNum = 118;BA.debugLine="lblStatus.Text = \"❌ 绑卡失败: \" & job.GetString";
parent._lblstatus.setText(BA.ObjectToCharSequence("❌ 绑卡失败: "+_job._getstring /*String*/ ()));
 if (true) break;

case 12:
//C
this.state = 25;
;
 if (true) break;

case 14:
//C
this.state = 15;
 //BA.debugLineNum = 122;BA.debugLine="If job.GetString.StartsWith(\"valid\") Then";
if (true) break;

case 15:
//if
this.state = 24;
if (_job._getstring /*String*/ ().startsWith("valid")) { 
this.state = 17;
}else {
this.state = 23;
}if (true) break;

case 17:
//C
this.state = 18;
 //BA.debugLineNum = 123;BA.debugLine="Dim parts() As String = Regex.Split(\":\", job.";
_parts = parent.__c.Regex.Split(":",_job._getstring /*String*/ ());
 //BA.debugLineNum = 124;BA.debugLine="If parts.Length > 1 Then";
if (true) break;

case 18:
//if
this.state = 21;
if (_parts.length>1) { 
this.state = 20;
}if (true) break;

case 20:
//C
this.state = 21;
 //BA.debugLineNum = 125;BA.debugLine="Dim txid As String = parts(1).Replace(QUOTE,";
_txid = _parts[(int) (1)].replace(parent.__c.QUOTE,"");
 //BA.debugLineNum = 126;BA.debugLine="Log(\"✅ Transaction ID: \" & txid)";
parent.__c.LogImpl("81048591","✅ Transaction ID: "+_txid,0);
 //BA.debugLineNum = 128;BA.debugLine="lblStatus.Text = \"🔄 提交区块链…\"";
parent._lblstatus.setText(BA.ObjectToCharSequence("🔄 提交区块链…"));
 //BA.debugLineNum = 129;BA.debugLine="B4xLoading.Show ' 显示加载动画";
parent._b4xloading._show /*String*/ ();
 //BA.debugLineNum = 131;BA.debugLine="Sleep(8000)";
parent.__c.Sleep(ba,this,(int) (8000));
this.state = 29;
return;
case 29:
//C
this.state = 21;
;
 //BA.debugLineNum = 132;BA.debugLine="lblStatus.Text = \"✅ 开门成功\"";
parent._lblstatus.setText(BA.ObjectToCharSequence("✅ 开门成功"));
 //BA.debugLineNum = 133;BA.debugLine="PollingActive = False";
parent._pollingactive = parent.__c.False;
 //BA.debugLineNum = 134;BA.debugLine="Sleep(2000)";
parent.__c.Sleep(ba,this,(int) (2000));
this.state = 30;
return;
case 30:
//C
this.state = 21;
;
 //BA.debugLineNum = 135;BA.debugLine="B4xLoading.Hide ' 隐藏加载动画";
parent._b4xloading._hide /*String*/ ();
 //BA.debugLineNum = 136;BA.debugLine="Dim url As String = $\"https://explorer.ergop";
_url = ("https://explorer.ergoplatform.com/transactions/"+parent.__c.SmartStringFormatter("",(Object)(_txid))+"");
 //BA.debugLineNum = 137;BA.debugLine="Dim p As PhoneIntents";
_p = new anywheresoftware.b4a.phone.Phone.PhoneIntents();
 //BA.debugLineNum = 138;BA.debugLine="StartActivity(p.OpenBrowser(url))";
parent.__c.StartActivity(ba,(Object)(_p.OpenBrowser(_url)));
 if (true) break;

case 21:
//C
this.state = 24;
;
 if (true) break;

case 23:
//C
this.state = 24;
 //BA.debugLineNum = 144;BA.debugLine="lblStatus.Text = \"🚪 等待刷卡…\"";
parent._lblstatus.setText(BA.ObjectToCharSequence("🚪 等待刷卡…"));
 //BA.debugLineNum = 145;BA.debugLine="TimerDeeplinkCheck.Enabled = True";
parent._timerdeeplinkcheck.setEnabled(parent.__c.True);
 if (true) break;

case 24:
//C
this.state = 25;
;
 if (true) break;

case 25:
//C
this.state = 28;
;
 if (true) break;

case 27:
//C
this.state = 28;
 //BA.debugLineNum = 151;BA.debugLine="lblStatus.Text = \"⚠️ 网络错误: \" & job.ErrorMessage";
parent._lblstatus.setText(BA.ObjectToCharSequence("⚠️ 网络错误: "+_job._errormessage /*String*/ ));
 if (true) break;

case 28:
//C
this.state = -1;
;
 //BA.debugLineNum = 153;BA.debugLine="job.Release";
_job._release /*String*/ ();
 //BA.debugLineNum = 154;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public String  _oncardscanned(String _cardnumber) throws Exception{
 //BA.debugLineNum = 87;BA.debugLine="Public Sub OnCardScanned(cardNumber As String)";
 //BA.debugLineNum = 88;BA.debugLine="lastCardNumber = cardNumber";
_lastcardnumber = _cardnumber;
 //BA.debugLineNum = 89;BA.debugLine="Log(\">>> OnCardScanned: \" & cardNumber)";
__c.LogImpl("8917506",">>> OnCardScanned: "+_cardnumber,0);
 //BA.debugLineNum = 90;BA.debugLine="lblStatus.Text = \"🚪 等待刷卡…\"";
_lblstatus.setText(BA.ObjectToCharSequence("🚪 等待刷卡…"));
 //BA.debugLineNum = 91;BA.debugLine="PollCount = 0";
_pollcount = (int) (0);
 //BA.debugLineNum = 92;BA.debugLine="PollingActive = True";
_pollingactive = __c.True;
 //BA.debugLineNum = 93;BA.debugLine="TimerDeeplinkCheck.Enabled = True";
_timerdeeplinkcheck.setEnabled(__c.True);
 //BA.debugLineNum = 94;BA.debugLine="End Sub";
return "";
}
public String  _setnftdata(String _name,String _tokenid,String _imageurl) throws Exception{
 //BA.debugLineNum = 39;BA.debugLine="Public Sub SetNFTData(name As String, tokenId As S";
 //BA.debugLineNum = 40;BA.debugLine="pendingName = name";
_pendingname = _name;
 //BA.debugLineNum = 41;BA.debugLine="pendingId = tokenId";
_pendingid = _tokenid;
 //BA.debugLineNum = 42;BA.debugLine="pendingImageUrl = imageUrl";
_pendingimageurl = _imageurl;
 //BA.debugLineNum = 43;BA.debugLine="End Sub";
return "";
}
public String  _timerdeeplinkcheck_tick() throws Exception{
com.pdv.httpjob _j = null;
 //BA.debugLineNum = 96;BA.debugLine="Private Sub TimerDeeplinkCheck_Tick";
 //BA.debugLineNum = 97;BA.debugLine="If Not(PollingActive) Then Return";
if (__c.Not(_pollingactive)) { 
if (true) return "";};
 //BA.debugLineNum = 98;BA.debugLine="TimerDeeplinkCheck.Enabled = False";
_timerdeeplinkcheck.setEnabled(__c.False);
 //BA.debugLineNum = 99;BA.debugLine="PollCount = PollCount + 1";
_pollcount = (int) (_pollcount+1);
 //BA.debugLineNum = 100;BA.debugLine="Log(\"🔁 Timer tick: PollCount = \" & PollCount & \"";
__c.LogImpl("8983044","🔁 Timer tick: PollCount = "+BA.NumberToString(_pollcount)+", Card = "+_lastcardnumber,0);
 //BA.debugLineNum = 101;BA.debugLine="If PollCount > MaxPolls Then";
if (_pollcount>_maxpolls) { 
 //BA.debugLineNum = 102;BA.debugLine="lblStatus.Text = \"⚠️ 开门超时，请重试\"";
_lblstatus.setText(BA.ObjectToCharSequence("⚠️ 开门超时，请重试"));
 //BA.debugLineNum = 103;BA.debugLine="PollingActive = False";
_pollingactive = __c.False;
 //BA.debugLineNum = 104;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 106;BA.debugLine="Dim j As HttpJob";
_j = new com.pdv.httpjob();
 //BA.debugLineNum = 107;BA.debugLine="j.Initialize(\"AccessStatus\", Me)";
_j._initialize /*String*/ (ba,"AccessStatus",this);
 //BA.debugLineNum = 108;BA.debugLine="j.Download(Starter.ServerURL & \"/accessStatus/\" &";
_j._download /*String*/ (_starter._serverurl /*String*/ +"/accessStatus/"+_lastcardnumber);
 //BA.debugLineNum = 109;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
if (BA.fastSubCompare(sub, "B4XPAGE_CREATED"))
	return _b4xpage_created((anywheresoftware.b4a.objects.B4XViewWrapper) args[0]);
return BA.SubDelegator.SubNotFound;
}
}
