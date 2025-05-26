package com.pdv;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class b4xmainpage extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "com.pdv.b4xmainpage");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", com.pdv.b4xmainpage.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _root = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public uk.co.martinpearman.b4a.squareup.picasso.Picasso _picasso1 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnconnect = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnopenwallet = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblstatus = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbltitle = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _ivqrcode = null;
public com.pdv.loginhelper _loginhelp = null;
public anywheresoftware.b4a.objects.PanelWrapper _pn1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbltop = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbltopbg = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imgwallet = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblpdvamout = null;
public b4a.example3.customlistview _clvnfts = null;
public String _currentwalletaddress = "";
public anywheresoftware.b4a.objects.PanelWrapper _pnnft = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblheader = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblnftname = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblnftid = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imgnft = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblvalidstatus = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlistview = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblline1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbldisplay = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imgnftname = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imgnftid = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imgstatus = null;
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
public String  _addnftitem(String _tokenid,String _imageurl,String _nftname) throws Exception{
anywheresoftware.b4a.objects.PanelWrapper _itempanel = null;
 //BA.debugLineNum = 242;BA.debugLine="Private Sub AddNFTItem(tokenId As String, imageUrl";
 //BA.debugLineNum = 243;BA.debugLine="Dim itemPanel As Panel";
_itempanel = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 244;BA.debugLine="itemPanel.Initialize(\"\")";
_itempanel.Initialize(ba,"");
 //BA.debugLineNum = 245;BA.debugLine="itemPanel.LoadLayout(\"clvNFTItem\")";
_itempanel.LoadLayout("clvNFTItem",ba);
 //BA.debugLineNum = 246;BA.debugLine="itemPanel.Height = 80dip";
_itempanel.setHeight(__c.DipToCurrent((int) (80)));
 //BA.debugLineNum = 247;BA.debugLine="Dim lblHeader As Label = FindViewByTag(itemPan";
_lblheader = new anywheresoftware.b4a.objects.LabelWrapper();
_lblheader = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(_findviewbytag(_itempanel,"lblHeader").getObject()));
 //BA.debugLineNum = 248;BA.debugLine="Dim imgNFT As ImageView = FindViewByTag(itemPa";
_imgnft = new anywheresoftware.b4a.objects.ImageViewWrapper();
_imgnft = (anywheresoftware.b4a.objects.ImageViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ImageViewWrapper(), (android.widget.ImageView)(_findviewbytag(_itempanel,"imgNFT").getObject()));
 //BA.debugLineNum = 249;BA.debugLine="Dim lblNFTname As Label = FindViewByTag(itemPa";
_lblnftname = new anywheresoftware.b4a.objects.LabelWrapper();
_lblnftname = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(_findviewbytag(_itempanel,"lblNFTname").getObject()));
 //BA.debugLineNum = 250;BA.debugLine="Dim lblNFTid As Label = FindViewByTag(itemPane";
_lblnftid = new anywheresoftware.b4a.objects.LabelWrapper();
_lblnftid = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(_findviewbytag(_itempanel,"lblNFTid").getObject()));
 //BA.debugLineNum = 251;BA.debugLine="Dim lblValidStatus As Label = FindViewByTag(it";
_lblvalidstatus = new anywheresoftware.b4a.objects.LabelWrapper();
_lblvalidstatus = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(_findviewbytag(_itempanel,"lblValidStatus").getObject()));
 //BA.debugLineNum = 253;BA.debugLine="lblHeader.Text = \"PDV ACCESS TOKEN\"";
_lblheader.setText(BA.ObjectToCharSequence("PDV ACCESS TOKEN"));
 //BA.debugLineNum = 254;BA.debugLine="lblNFTname.Text = nftName";
_lblnftname.setText(BA.ObjectToCharSequence(_nftname));
 //BA.debugLineNum = 255;BA.debugLine="lblNFTid.Text = tokenId";
_lblnftid.setText(BA.ObjectToCharSequence(_tokenid));
 //BA.debugLineNum = 256;BA.debugLine="lblValidStatus.Text = \"Valid\"";
_lblvalidstatus.setText(BA.ObjectToCharSequence("Valid"));
 //BA.debugLineNum = 259;BA.debugLine="itemPanel.Tag = imageUrl";
_itempanel.setTag((Object)(_imageurl));
 //BA.debugLineNum = 261;BA.debugLine="LoadNFTImage(imgNFT, imageUrl)";
_loadnftimage(_imgnft,_imageurl);
 //BA.debugLineNum = 262;BA.debugLine="clvNFTs.Add(itemPanel, tokenId)";
_clvnfts._add((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_itempanel.getObject())),(Object)(_tokenid));
 //BA.debugLineNum = 263;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.keywords.Common.ResumableSubWrapper  _b4xpage_closerequest() throws Exception{
ResumableSub_B4XPage_CloseRequest rsub = new ResumableSub_B4XPage_CloseRequest(this);
rsub.resume(ba, null);
return (anywheresoftware.b4a.keywords.Common.ResumableSubWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.keywords.Common.ResumableSubWrapper(), rsub);
}
public static class ResumableSub_B4XPage_CloseRequest extends BA.ResumableSub {
public ResumableSub_B4XPage_CloseRequest(com.pdv.b4xmainpage parent) {
this.parent = parent;
}
com.pdv.b4xmainpage parent;
Object _sf = null;
int _result = 0;

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
 //BA.debugLineNum = 297;BA.debugLine="Dim sf As Object = xui.Msgbox2Async(\"Are you sure";
_sf = parent._xui.Msgbox2Async(ba,BA.ObjectToCharSequence("Are you sure you want to exit the app?"),BA.ObjectToCharSequence("Exit"),"Yes","","No",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(parent.__c.Null)));
 //BA.debugLineNum = 298;BA.debugLine="Wait For (sf) Msgbox_Result (Result As Int)";
parent.__c.WaitFor("msgbox_result", ba, this, _sf);
this.state = 5;
return;
case 5:
//C
this.state = 1;
_result = (Integer) result[0];
;
 //BA.debugLineNum = 299;BA.debugLine="If Result = xui.DialogResponse_Positive Then";
if (true) break;

case 1:
//if
this.state = 4;
if (_result==parent._xui.DialogResponse_Positive) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 //BA.debugLineNum = 300;BA.debugLine="ExitApplication ' ✅ 彻底关闭 App，下次启动重新开始";
parent.__c.ExitApplication();
 //BA.debugLineNum = 301;BA.debugLine="Return True ' 这个还是必须 return 给框架";
if (true) {
parent.__c.ReturnFromResumableSub(this,(Object)(parent.__c.True));return;};
 if (true) break;

case 4:
//C
this.state = -1;
;
 //BA.debugLineNum = 303;BA.debugLine="Return False";
if (true) {
parent.__c.ReturnFromResumableSub(this,(Object)(parent.__c.False));return;};
 //BA.debugLineNum = 304;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public void  _msgbox_result(int _result) throws Exception{
}
public String  _b4xpage_created(anywheresoftware.b4a.objects.B4XViewWrapper _root1) throws Exception{
com.pdv.nftdetailpage _detailpage = null;
 //BA.debugLineNum = 45;BA.debugLine="Sub B4XPage_Created (Root1 As B4XView)";
 //BA.debugLineNum = 46;BA.debugLine="Root = Root1";
_root = _root1;
 //BA.debugLineNum = 47;BA.debugLine="Root.LoadLayout(\"MainPage\")";
_root.LoadLayout("MainPage",ba);
 //BA.debugLineNum = 48;BA.debugLine="loginHelp.Initialize(Me)";
_loginhelp._initialize /*String*/ (ba,this);
 //BA.debugLineNum = 49;BA.debugLine="shared = rp.GetSafeDirDefaultExternal(\"\")";
_shared = _rp.GetSafeDirDefaultExternal("");
 //BA.debugLineNum = 50;BA.debugLine="kvs.Initialize(shared, \"Userdatastore\")";
_kvs._initialize(ba,_shared,"Userdatastore");
 //BA.debugLineNum = 51;BA.debugLine="btnOpenWallet.Enabled = False";
_btnopenwallet.setEnabled(__c.False);
 //BA.debugLineNum = 52;BA.debugLine="clvNFTs.AsView.Visible = False";
_clvnfts._asview().setVisible(__c.False);
 //BA.debugLineNum = 53;BA.debugLine="ivQRCode.Bitmap = Null";
_ivqrcode.setBitmap((android.graphics.Bitmap)(__c.Null));
 //BA.debugLineNum = 54;BA.debugLine="currentWalletAddress = \"\"";
_currentwalletaddress = "";
 //BA.debugLineNum = 56;BA.debugLine="Dim detailPage As NFTDetailPage";
_detailpage = new com.pdv.nftdetailpage();
 //BA.debugLineNum = 57;BA.debugLine="detailPage.Initialize";
_detailpage._initialize /*String*/ (ba);
 //BA.debugLineNum = 58;BA.debugLine="B4XPages.AddPage(\"NFTDetailPage\", detailPage)";
_b4xpages._addpage /*String*/ (ba,"NFTDetailPage",(Object)(_detailpage));
 //BA.debugLineNum = 60;BA.debugLine="End Sub";
return "";
}
public String  _b4xpage_resume() throws Exception{
 //BA.debugLineNum = 115;BA.debugLine="Sub B4XPage_Resume";
 //BA.debugLineNum = 116;BA.debugLine="If Starter.CurrentSessionId <> \"\" Then loginHelp.";
if ((_starter._currentsessionid /*String*/ ).equals("") == false) { 
_loginhelp._startpolling /*String*/ ();};
 //BA.debugLineNum = 118;BA.debugLine="End Sub";
return "";
}
public String  _btnconnect_click() throws Exception{
 //BA.debugLineNum = 62;BA.debugLine="Sub btnConnect_Click";
 //BA.debugLineNum = 63;BA.debugLine="lblStatus.Text = \"正在请求Session...\"";
_lblstatus.setText(BA.ObjectToCharSequence("正在请求Session..."));
 //BA.debugLineNum = 64;BA.debugLine="ivQRCode.Bitmap = Null";
_ivqrcode.setBitmap((android.graphics.Bitmap)(__c.Null));
 //BA.debugLineNum = 65;BA.debugLine="loginHelp.CreateLoginSession";
_loginhelp._createloginsession /*String*/ ();
 //BA.debugLineNum = 66;BA.debugLine="btnOpenWallet.Visible = True";
_btnopenwallet.setVisible(__c.True);
 //BA.debugLineNum = 67;BA.debugLine="btnConnect.Visible = False";
_btnconnect.setVisible(__c.False);
 //BA.debugLineNum = 68;BA.debugLine="ivQRCode.Visible = True";
_ivqrcode.setVisible(__c.True);
 //BA.debugLineNum = 69;BA.debugLine="End Sub";
return "";
}
public String  _btnopenwallet_click() throws Exception{
String _deeplink = "";
anywheresoftware.b4a.objects.IntentWrapper _intent = null;
 //BA.debugLineNum = 71;BA.debugLine="Sub btnOpenWallet_Click";
 //BA.debugLineNum = 72;BA.debugLine="Try";
try { //BA.debugLineNum = 73;BA.debugLine="Dim deeplink As String = btnOpenWallet.Tag";
_deeplink = BA.ObjectToString(_btnopenwallet.getTag());
 //BA.debugLineNum = 74;BA.debugLine="If deeplink.StartsWith(\"http://\") Or deeplink.St";
if (_deeplink.startsWith("http://") || _deeplink.startsWith("https://")) { 
 //BA.debugLineNum = 75;BA.debugLine="deeplink = deeplink.Replace(\"http://\", \"ergopay";
_deeplink = _deeplink.replace("http://","ergopay://").replace("https://","ergopay://");
 };
 //BA.debugLineNum = 77;BA.debugLine="Dim intent As Intent";
_intent = new anywheresoftware.b4a.objects.IntentWrapper();
 //BA.debugLineNum = 78;BA.debugLine="intent.Initialize(intent.ACTION_VIEW, deeplink)";
_intent.Initialize(_intent.ACTION_VIEW,_deeplink);
 //BA.debugLineNum = 79;BA.debugLine="StartActivity(intent)";
__c.StartActivity(ba,(Object)(_intent.getObject()));
 } 
       catch (Exception e10) {
			ba.setLastException(e10); //BA.debugLineNum = 81;BA.debugLine="MsgboxAsync(\"找不到支持 ergopay:// 的钱包应用。请安装Nautilus";
__c.MsgboxAsync(BA.ObjectToCharSequence("找不到支持 ergopay:// 的钱包应用。请安装Nautilus Wallet。"),BA.ObjectToCharSequence("提示"),ba);
 };
 //BA.debugLineNum = 83;BA.debugLine="btnOpenWallet.Visible = False";
_btnopenwallet.setVisible(__c.False);
 //BA.debugLineNum = 84;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 7;BA.debugLine="Private Root As B4XView";
_root = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 8;BA.debugLine="Private xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 9;BA.debugLine="Private Picasso1 As Picasso";
_picasso1 = new uk.co.martinpearman.b4a.squareup.picasso.Picasso();
 //BA.debugLineNum = 10;BA.debugLine="Private btnConnect As Button";
_btnconnect = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 11;BA.debugLine="Private btnOpenWallet As Button";
_btnopenwallet = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 12;BA.debugLine="Private lblStatus As Label";
_lblstatus = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 13;BA.debugLine="Private lblTitle As Label";
_lbltitle = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 14;BA.debugLine="Private ivQRCode As ImageView";
_ivqrcode = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 15;BA.debugLine="Private loginHelp As LoginHelper";
_loginhelp = new com.pdv.loginhelper();
 //BA.debugLineNum = 16;BA.debugLine="Private pn1 As Panel";
_pn1 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 17;BA.debugLine="Private lblTop As Label";
_lbltop = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 18;BA.debugLine="Private lblTopBg As Label";
_lbltopbg = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 19;BA.debugLine="Private imgWallet As ImageView";
_imgwallet = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 20;BA.debugLine="Private lblPDVAmout As Label";
_lblpdvamout = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 21;BA.debugLine="Private clvNFTs As CustomListView";
_clvnfts = new b4a.example3.customlistview();
 //BA.debugLineNum = 22;BA.debugLine="Private currentWalletAddress As String";
_currentwalletaddress = "";
 //BA.debugLineNum = 23;BA.debugLine="Private pnNFT As Panel";
_pnnft = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 24;BA.debugLine="Private lblHeader As Label";
_lblheader = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 25;BA.debugLine="Private lblNFTname As Label";
_lblnftname = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 26;BA.debugLine="Private lblNFTid As Label";
_lblnftid = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 27;BA.debugLine="Private imgNFT As ImageView";
_imgnft = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 28;BA.debugLine="Private lblValidStatus As Label";
_lblvalidstatus = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 29;BA.debugLine="Private pnListView As Panel";
_pnlistview = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 30;BA.debugLine="Private lblLine1 As Label";
_lblline1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 31;BA.debugLine="Private lblDisplay As Label";
_lbldisplay = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 32;BA.debugLine="Private imgNFTname As ImageView";
_imgnftname = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 33;BA.debugLine="Private imgNFTid As ImageView";
_imgnftid = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 34;BA.debugLine="Private imgStatus As ImageView";
_imgstatus = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 36;BA.debugLine="Private kvs As KeyValueStore";
_kvs = new b4a.example3.keyvaluestore();
 //BA.debugLineNum = 37;BA.debugLine="Private rp As RuntimePermissions";
_rp = new anywheresoftware.b4a.objects.RuntimePermissions();
 //BA.debugLineNum = 38;BA.debugLine="Private shared As String";
_shared = "";
 //BA.debugLineNum = 39;BA.debugLine="End Sub";
return "";
}
public String  _clvnfts_itemclick(int _index,Object _value) throws Exception{
anywheresoftware.b4a.objects.B4XViewWrapper _pnl = null;
String _nftname = "";
String _tokenid = "";
String _imageurl = "";
com.pdv.nftdetailpage _detailpage = null;
com.pdv.nftdetailpage _dp = null;
 //BA.debugLineNum = 271;BA.debugLine="Private Sub clvNFTs_ItemClick (Index As Int, Value";
 //BA.debugLineNum = 272;BA.debugLine="Dim pnl As B4XView = clvNFTs.GetPanel(Index)";
_pnl = new anywheresoftware.b4a.objects.B4XViewWrapper();
_pnl = _clvnfts._getpanel(_index);
 //BA.debugLineNum = 273;BA.debugLine="Dim lblNFTname As Label = FindViewByTag(pnl, \"lbl";
_lblnftname = new anywheresoftware.b4a.objects.LabelWrapper();
_lblnftname = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(_findviewbytag((anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(_pnl.getObject())),"lblNFTname").getObject()));
 //BA.debugLineNum = 275;BA.debugLine="Dim nftName As String = lblNFTname.Text";
_nftname = _lblnftname.getText();
 //BA.debugLineNum = 276;BA.debugLine="Dim tokenId As String = Value";
_tokenid = BA.ObjectToString(_value);
 //BA.debugLineNum = 277;BA.debugLine="Dim imageUrl As String = \"\"";
_imageurl = "";
 //BA.debugLineNum = 278;BA.debugLine="If pnl.Tag <> Null And pnl.Tag <> \"\" Then";
if (_pnl.getTag()!= null && (_pnl.getTag()).equals((Object)("")) == false) { 
 //BA.debugLineNum = 279;BA.debugLine="imageUrl = pnl.Tag";
_imageurl = BA.ObjectToString(_pnl.getTag());
 };
 //BA.debugLineNum = 283;BA.debugLine="If B4XPages.GetPage(\"NFTDetailPage\") = Null Then";
if (_b4xpages._getpage /*Object*/ (ba,"NFTDetailPage")== null) { 
 //BA.debugLineNum = 284;BA.debugLine="Dim detailPage As NFTDetailPage";
_detailpage = new com.pdv.nftdetailpage();
 //BA.debugLineNum = 285;BA.debugLine="detailPage.Initialize";
_detailpage._initialize /*String*/ (ba);
 //BA.debugLineNum = 286;BA.debugLine="B4XPages.AddPage(\"NFTDetailPage\", detailPage)";
_b4xpages._addpage /*String*/ (ba,"NFTDetailPage",(Object)(_detailpage));
 };
 //BA.debugLineNum = 290;BA.debugLine="Dim dp As NFTDetailPage = B4XPages.GetPage(\"NFTDe";
_dp = (com.pdv.nftdetailpage)(_b4xpages._getpage /*Object*/ (ba,"NFTDetailPage"));
 //BA.debugLineNum = 291;BA.debugLine="dp.SetNFTData(nftName, tokenId, imageUrl)";
_dp._setnftdata /*String*/ (_nftname,_tokenid,_imageurl);
 //BA.debugLineNum = 292;BA.debugLine="B4XPages.ShowPage(\"NFTDetailPage\")";
_b4xpages._showpage /*String*/ (ba,"NFTDetailPage");
 //BA.debugLineNum = 293;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.objects.ConcreteViewWrapper  _findviewbytag(anywheresoftware.b4a.objects.PanelWrapper _pnl,String _tag) throws Exception{
anywheresoftware.b4a.objects.ConcreteViewWrapper _v = null;
 //BA.debugLineNum = 235;BA.debugLine="Private Sub FindViewByTag(pnl As Panel, tag As Str";
 //BA.debugLineNum = 236;BA.debugLine="For Each v As View In pnl.GetAllViewsRecursive";
_v = new anywheresoftware.b4a.objects.ConcreteViewWrapper();
{
final anywheresoftware.b4a.BA.IterableList group1 = _pnl.GetAllViewsRecursive();
final int groupLen1 = group1.getSize()
;int index1 = 0;
;
for (; index1 < groupLen1;index1++){
_v = (anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(group1.Get(index1)));
 //BA.debugLineNum = 237;BA.debugLine="If v.Tag = tag Then Return v";
if ((_v.getTag()).equals((Object)(_tag))) { 
if (true) return _v;};
 }
};
 //BA.debugLineNum = 239;BA.debugLine="Return Null";
if (true) return (anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(__c.Null));
 //BA.debugLineNum = 240;BA.debugLine="End Sub";
return null;
}
public String  _getwalletbalance(String _walletaddress) throws Exception{
com.pdv.httpjob _job = null;
 //BA.debugLineNum = 122;BA.debugLine="Private Sub GetWalletBalance(walletAddress As Stri";
 //BA.debugLineNum = 123;BA.debugLine="Dim job As HttpJob";
_job = new com.pdv.httpjob();
 //BA.debugLineNum = 124;BA.debugLine="job.Initialize(\"GetBalance\", Me)";
_job._initialize /*String*/ (ba,"GetBalance",this);
 //BA.debugLineNum = 125;BA.debugLine="job.Download($\"https://api.ergoplatform.com/api/v";
_job._download /*String*/ (("https://api.ergoplatform.com/api/v1/addresses/"+__c.SmartStringFormatter("",(Object)(_walletaddress))+"/balance/total"));
 //BA.debugLineNum = 126;BA.debugLine="lblStatus.Text = \"正在获取钱包余额...\"";
_lblstatus.setText(BA.ObjectToCharSequence("正在获取钱包余额..."));
 //BA.debugLineNum = 127;BA.debugLine="End Sub";
return "";
}
public String  _getwalletnfts(String _walletaddress) throws Exception{
com.pdv.httpjob _job = null;
 //BA.debugLineNum = 129;BA.debugLine="Private Sub GetWalletNFTs(walletAddress As String)";
 //BA.debugLineNum = 130;BA.debugLine="Dim job As HttpJob";
_job = new com.pdv.httpjob();
 //BA.debugLineNum = 131;BA.debugLine="job.Initialize(\"GetNFTs\", Me)";
_job._initialize /*String*/ (ba,"GetNFTs",this);
 //BA.debugLineNum = 132;BA.debugLine="job.Download($\"https://api.ergoplatform.com/api/v";
_job._download /*String*/ (("https://api.ergoplatform.com/api/v1/addresses/"+__c.SmartStringFormatter("",(Object)(_walletaddress))+"/balance/total"));
 //BA.debugLineNum = 133;BA.debugLine="lblStatus.Text = \"正在获取NFT列表...\"";
_lblstatus.setText(BA.ObjectToCharSequence("正在获取NFT列表..."));
 //BA.debugLineNum = 134;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 41;BA.debugLine="Public Sub Initialize";
 //BA.debugLineNum = 42;BA.debugLine="Picasso1.Initialize";
_picasso1.Initialize(ba);
 //BA.debugLineNum = 43;BA.debugLine="End Sub";
return "";
}
public String  _jobdone(com.pdv.httpjob _job) throws Exception{
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
anywheresoftware.b4a.objects.collections.Map _result = null;
anywheresoftware.b4a.objects.collections.Map _confirmed = null;
anywheresoftware.b4a.objects.collections.List _tokens = null;
double _pdvamount = 0;
int _i = 0;
anywheresoftware.b4a.objects.collections.Map _token = null;
String _tokenid = "";
com.pdv.httpjob _job1 = null;
String _boxid = "";
String _nftname = "";
com.pdv.httpjob _job2 = null;
String[] _parts = null;
anywheresoftware.b4a.objects.collections.List _assets = null;
anywheresoftware.b4a.objects.collections.Map _asset = null;
String _imageurl = "";
anywheresoftware.b4a.objects.collections.Map _registers = null;
String _rawvalue = "";
anywheresoftware.b4a.objects.collections.Map _r9map = null;
anywheresoftware.b4a.objects.collections.Map _r4map = null;
anywheresoftware.b4a.agraham.byteconverter.ByteConverter _bc = null;
byte[] _bytes = null;
 //BA.debugLineNum = 136;BA.debugLine="Sub JobDone(job As HttpJob)";
 //BA.debugLineNum = 137;BA.debugLine="If job.Success Then";
if (_job._success /*boolean*/ ) { 
 //BA.debugLineNum = 138;BA.debugLine="Select True";
switch (BA.switchObjectToInt(__c.True,(_job._jobname /*String*/ ).equals("GetBalance"),(_job._jobname /*String*/ ).equals("GetNFTs"),_job._jobname /*String*/ .startsWith("TokenInfo_"),_job._jobname /*String*/ .startsWith("BoxInfo_"))) {
case 0: {
 //BA.debugLineNum = 140;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
 //BA.debugLineNum = 141;BA.debugLine="parser.Initialize(job.GetString)";
_parser.Initialize(_job._getstring /*String*/ ());
 //BA.debugLineNum = 142;BA.debugLine="Dim result As Map = parser.NextObject";
_result = new anywheresoftware.b4a.objects.collections.Map();
_result = _parser.NextObject();
 //BA.debugLineNum = 143;BA.debugLine="Dim confirmed As Map = result.Get(\"confirmed\")";
_confirmed = new anywheresoftware.b4a.objects.collections.Map();
_confirmed = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_result.Get((Object)("confirmed"))));
 //BA.debugLineNum = 144;BA.debugLine="Dim tokens As List = confirmed.Get(\"tokens\")";
_tokens = new anywheresoftware.b4a.objects.collections.List();
_tokens = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_confirmed.Get((Object)("tokens"))));
 //BA.debugLineNum = 145;BA.debugLine="Dim pdvAmount As Double = 0";
_pdvamount = 0;
 //BA.debugLineNum = 146;BA.debugLine="For i = 0 To tokens.Size - 1";
{
final int step10 = 1;
final int limit10 = (int) (_tokens.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit10 ;_i = _i + step10 ) {
 //BA.debugLineNum = 147;BA.debugLine="Dim token As Map = tokens.Get(i)";
_token = new anywheresoftware.b4a.objects.collections.Map();
_token = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_tokens.Get(_i)));
 //BA.debugLineNum = 148;BA.debugLine="If token.Get(\"name\") = \"PDV\" Then";
if ((_token.Get((Object)("name"))).equals((Object)("PDV"))) { 
 //BA.debugLineNum = 149;BA.debugLine="pdvAmount = token.Get(\"amount\") / Power(10,";
_pdvamount = (double)(BA.ObjectToNumber(_token.Get((Object)("amount"))))/(double)__c.Power(10,(double)(BA.ObjectToNumber(_token.Get((Object)("decimals")))));
 //BA.debugLineNum = 150;BA.debugLine="Exit";
if (true) break;
 };
 }
};
 //BA.debugLineNum = 153;BA.debugLine="lblPDVAmout.Text = $\"PDV: ${NumberFormat(pdvAm";
_lblpdvamout.setText(BA.ObjectToCharSequence(("PDV: "+__c.SmartStringFormatter("",(Object)(__c.NumberFormat(_pdvamount,(int) (1),(int) (2))))+"")));
 //BA.debugLineNum = 154;BA.debugLine="clvNFTs.AsView.Visible = True";
_clvnfts._asview().setVisible(__c.True);
 //BA.debugLineNum = 155;BA.debugLine="GetWalletNFTs(currentWalletAddress)";
_getwalletnfts(_currentwalletaddress);
 break; }
case 1: {
 //BA.debugLineNum = 158;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
 //BA.debugLineNum = 159;BA.debugLine="parser.Initialize(job.GetString)";
_parser.Initialize(_job._getstring /*String*/ ());
 //BA.debugLineNum = 160;BA.debugLine="Dim result As Map = parser.NextObject";
_result = new anywheresoftware.b4a.objects.collections.Map();
_result = _parser.NextObject();
 //BA.debugLineNum = 161;BA.debugLine="Dim confirmed As Map = result.Get(\"confirmed\")";
_confirmed = new anywheresoftware.b4a.objects.collections.Map();
_confirmed = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_result.Get((Object)("confirmed"))));
 //BA.debugLineNum = 162;BA.debugLine="Dim tokens As List = confirmed.Get(\"tokens\")";
_tokens = new anywheresoftware.b4a.objects.collections.List();
_tokens = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_confirmed.Get((Object)("tokens"))));
 //BA.debugLineNum = 163;BA.debugLine="clvNFTs.Clear";
_clvnfts._clear();
 //BA.debugLineNum = 164;BA.debugLine="For i = 0 To tokens.Size - 1";
{
final int step27 = 1;
final int limit27 = (int) (_tokens.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit27 ;_i = _i + step27 ) {
 //BA.debugLineNum = 165;BA.debugLine="Dim token As Map = tokens.Get(i)";
_token = new anywheresoftware.b4a.objects.collections.Map();
_token = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_tokens.Get(_i)));
 //BA.debugLineNum = 166;BA.debugLine="If token.Get(\"amount\") = 1 And token.Get(\"dec";
if ((_token.Get((Object)("amount"))).equals((Object)(1)) && (_token.Get((Object)("decimals"))).equals((Object)(0))) { 
 //BA.debugLineNum = 167;BA.debugLine="Dim tokenId As String = token.Get(\"tokenId\")";
_tokenid = BA.ObjectToString(_token.Get((Object)("tokenId")));
 //BA.debugLineNum = 168;BA.debugLine="Dim job1 As HttpJob";
_job1 = new com.pdv.httpjob();
 //BA.debugLineNum = 169;BA.debugLine="job1.Initialize(\"TokenInfo_\" & tokenId, Me)";
_job1._initialize /*String*/ (ba,"TokenInfo_"+_tokenid,this);
 //BA.debugLineNum = 170;BA.debugLine="job1.Download($\"https://api.ergoplatform.com";
_job1._download /*String*/ (("https://api.ergoplatform.com/api/v1/tokens/"+__c.SmartStringFormatter("",(Object)(_tokenid))+""));
 };
 }
};
 break; }
case 2: {
 //BA.debugLineNum = 175;BA.debugLine="Dim tokenId As String = job.JobName.SubString(";
_tokenid = _job._jobname /*String*/ .substring("TokenInfo_".length());
 //BA.debugLineNum = 176;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
 //BA.debugLineNum = 177;BA.debugLine="parser.Initialize(job.GetString)";
_parser.Initialize(_job._getstring /*String*/ ());
 //BA.debugLineNum = 178;BA.debugLine="Dim result As Map = parser.NextObject";
_result = new anywheresoftware.b4a.objects.collections.Map();
_result = _parser.NextObject();
 //BA.debugLineNum = 179;BA.debugLine="Dim boxId As String = result.Get(\"boxId\")";
_boxid = BA.ObjectToString(_result.Get((Object)("boxId")));
 //BA.debugLineNum = 180;BA.debugLine="Dim nftName As String = result.GetDefault(\"nam";
_nftname = BA.ObjectToString(_result.GetDefault((Object)("name"),(Object)("NFT")));
 //BA.debugLineNum = 181;BA.debugLine="If boxId <> \"\" Then";
if ((_boxid).equals("") == false) { 
 //BA.debugLineNum = 182;BA.debugLine="Dim job2 As HttpJob";
_job2 = new com.pdv.httpjob();
 //BA.debugLineNum = 183;BA.debugLine="job2.Initialize(\"BoxInfo_\" & tokenId & \"|\" &";
_job2._initialize /*String*/ (ba,"BoxInfo_"+_tokenid+"|"+_nftname,this);
 //BA.debugLineNum = 184;BA.debugLine="job2.Download($\"https://api.ergoplatform.com/";
_job2._download /*String*/ (("https://api.ergoplatform.com/api/v1/boxes/"+__c.SmartStringFormatter("",(Object)(_boxid))+""));
 };
 break; }
case 3: {
 //BA.debugLineNum = 188;BA.debugLine="Dim parts() As String = Regex.Split(\"\\|\", job.";
_parts = __c.Regex.Split("\\|",_job._jobname /*String*/ .substring("BoxInfo_".length()));
 //BA.debugLineNum = 189;BA.debugLine="Dim tokenId As String = parts(0)";
_tokenid = _parts[(int) (0)];
 //BA.debugLineNum = 190;BA.debugLine="Dim nftName As String = parts(1)";
_nftname = _parts[(int) (1)];
 //BA.debugLineNum = 192;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
 //BA.debugLineNum = 193;BA.debugLine="parser.Initialize(job.GetString)";
_parser.Initialize(_job._getstring /*String*/ ());
 //BA.debugLineNum = 194;BA.debugLine="Dim result As Map = parser.NextObject";
_result = new anywheresoftware.b4a.objects.collections.Map();
_result = _parser.NextObject();
 //BA.debugLineNum = 197;BA.debugLine="If nftName = \"NFT\" And result.ContainsKey(\"ass";
if ((_nftname).equals("NFT") && _result.ContainsKey((Object)("assets"))) { 
 //BA.debugLineNum = 198;BA.debugLine="Dim assets As List = result.Get(\"assets\")";
_assets = new anywheresoftware.b4a.objects.collections.List();
_assets = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_result.Get((Object)("assets"))));
 //BA.debugLineNum = 199;BA.debugLine="If assets.Size > 0 Then";
if (_assets.getSize()>0) { 
 //BA.debugLineNum = 200;BA.debugLine="Dim asset As Map = assets.Get(0)";
_asset = new anywheresoftware.b4a.objects.collections.Map();
_asset = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_assets.Get((int) (0))));
 //BA.debugLineNum = 201;BA.debugLine="nftName = asset.GetDefault(\"name\", \"NFT\")";
_nftname = BA.ObjectToString(_asset.GetDefault((Object)("name"),(Object)("NFT")));
 };
 };
 //BA.debugLineNum = 205;BA.debugLine="Dim imageUrl As String = \"\"";
_imageurl = "";
 //BA.debugLineNum = 206;BA.debugLine="If result.ContainsKey(\"additionalRegisters\") T";
if (_result.ContainsKey((Object)("additionalRegisters"))) { 
 //BA.debugLineNum = 207;BA.debugLine="Dim registers As Map = result.Get(\"additional";
_registers = new anywheresoftware.b4a.objects.collections.Map();
_registers = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_result.Get((Object)("additionalRegisters"))));
 //BA.debugLineNum = 208;BA.debugLine="Dim rawValue As String = \"\"";
_rawvalue = "";
 //BA.debugLineNum = 209;BA.debugLine="If registers.ContainsKey(\"R9\") Then";
if (_registers.ContainsKey((Object)("R9"))) { 
 //BA.debugLineNum = 210;BA.debugLine="Dim r9Map As Map = registers.Get(\"R9\")";
_r9map = new anywheresoftware.b4a.objects.collections.Map();
_r9map = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_registers.Get((Object)("R9"))));
 //BA.debugLineNum = 211;BA.debugLine="rawValue = r9Map.Get(\"renderedValue\")";
_rawvalue = BA.ObjectToString(_r9map.Get((Object)("renderedValue")));
 }else if(_registers.ContainsKey((Object)("R4"))) { 
 //BA.debugLineNum = 213;BA.debugLine="Dim r4Map As Map = registers.Get(\"R4\")";
_r4map = new anywheresoftware.b4a.objects.collections.Map();
_r4map = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_registers.Get((Object)("R4"))));
 //BA.debugLineNum = 214;BA.debugLine="rawValue = r4Map.Get(\"renderedValue\")";
_rawvalue = BA.ObjectToString(_r4map.Get((Object)("renderedValue")));
 };
 //BA.debugLineNum = 216;BA.debugLine="If rawValue.Length > 0 Then";
if (_rawvalue.length()>0) { 
 //BA.debugLineNum = 217;BA.debugLine="Dim bc As ByteConverter";
_bc = new anywheresoftware.b4a.agraham.byteconverter.ByteConverter();
 //BA.debugLineNum = 218;BA.debugLine="Dim bytes() As Byte = bc.HexToBytes(rawValue";
_bytes = _bc.HexToBytes(_rawvalue);
 //BA.debugLineNum = 219;BA.debugLine="imageUrl = BytesToString(bytes, 0, bytes.Len";
_imageurl = __c.BytesToString(_bytes,(int) (0),_bytes.length,"UTF8");
 };
 };
 //BA.debugLineNum = 223;BA.debugLine="If imageUrl.StartsWith(\"ipfs://\") Then";
if (_imageurl.startsWith("ipfs://")) { 
 //BA.debugLineNum = 224;BA.debugLine="imageUrl = imageUrl.Replace(\"ipfs://\", \"https";
_imageurl = _imageurl.replace("ipfs://","https://ipfs.io/ipfs/");
 };
 //BA.debugLineNum = 227;BA.debugLine="AddNFTItem(tokenId, imageUrl, nftName)";
_addnftitem(_tokenid,_imageurl,_nftname);
 break; }
}
;
 };
 //BA.debugLineNum = 231;BA.debugLine="job.Release";
_job._release /*String*/ ();
 //BA.debugLineNum = 232;BA.debugLine="End Sub";
return "";
}
public String  _loadnftimage(anywheresoftware.b4a.objects.ImageViewWrapper _targetimage,String _imageurl) throws Exception{
 //BA.debugLineNum = 266;BA.debugLine="Private Sub LoadNFTImage(TargetImage As ImageView,";
 //BA.debugLineNum = 267;BA.debugLine="If imageUrl = \"\" Then Return";
if ((_imageurl).equals("")) { 
if (true) return "";};
 //BA.debugLineNum = 268;BA.debugLine="Picasso1.LoadUrl(imageUrl).IntoImageView(TargetIm";
_picasso1.LoadUrl(_imageurl).IntoImageView((android.widget.ImageView)(_targetimage.getObject()));
 //BA.debugLineNum = 269;BA.debugLine="End Sub";
return "";
}
public String  _onloginerror(String _msg) throws Exception{
 //BA.debugLineNum = 106;BA.debugLine="Sub OnLoginError(msg As String)";
 //BA.debugLineNum = 107;BA.debugLine="lblStatus.Text = \"ERROR: \" & msg";
_lblstatus.setText(BA.ObjectToCharSequence("ERROR: "+_msg));
 //BA.debugLineNum = 108;BA.debugLine="ivQRCode.Bitmap = Null";
_ivqrcode.setBitmap((android.graphics.Bitmap)(__c.Null));
 //BA.debugLineNum = 109;BA.debugLine="End Sub";
return "";
}
public String  _onloginsessioncreated(String _deeplink) throws Exception{
com.pdv.qrcode _qrgen = null;
 //BA.debugLineNum = 86;BA.debugLine="Sub OnLoginSessionCreated(deeplink As String)";
 //BA.debugLineNum = 87;BA.debugLine="lblStatus.Text = \"Session created. Scan QR or ope";
_lblstatus.setText(BA.ObjectToCharSequence("Session created. Scan QR or open Wallet to connect."));
 //BA.debugLineNum = 88;BA.debugLine="btnOpenWallet.Tag = deeplink";
_btnopenwallet.setTag((Object)(_deeplink));
 //BA.debugLineNum = 89;BA.debugLine="btnOpenWallet.Enabled = True";
_btnopenwallet.setEnabled(__c.True);
 //BA.debugLineNum = 90;BA.debugLine="Dim qrGen As QRcode";
_qrgen = new com.pdv.qrcode();
 //BA.debugLineNum = 91;BA.debugLine="qrGen.Initialize";
_qrgen._initialize /*String*/ (ba);
 //BA.debugLineNum = 92;BA.debugLine="ivQRCode.Bitmap = qrGen.drawQRCode(deeplink)";
_ivqrcode.setBitmap((android.graphics.Bitmap)(_qrgen._drawqrcode /*anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper*/ (_deeplink).getObject()));
 //BA.debugLineNum = 93;BA.debugLine="End Sub";
return "";
}
public String  _onloginsuccess(String _walletaddress) throws Exception{
 //BA.debugLineNum = 95;BA.debugLine="Sub OnLoginSuccess(walletAddress As String)";
 //BA.debugLineNum = 96;BA.debugLine="lblStatus.Text = \"已登录成功\"";
_lblstatus.setText(BA.ObjectToCharSequence("已登录成功"));
 //BA.debugLineNum = 97;BA.debugLine="currentWalletAddress = walletAddress";
_currentwalletaddress = _walletaddress;
 //BA.debugLineNum = 98;BA.debugLine="lblTitle.Text = walletAddress";
_lbltitle.setText(BA.ObjectToCharSequence(_walletaddress));
 //BA.debugLineNum = 99;BA.debugLine="If walletAddress.Length > 10 Then lblTitle.Text =";
if (_walletaddress.length()>10) { 
_lbltitle.setText(BA.ObjectToCharSequence("..."+_walletaddress.substring((int) (_walletaddress.length()-7))));};
 //BA.debugLineNum = 100;BA.debugLine="btnOpenWallet.Enabled = False";
_btnopenwallet.setEnabled(__c.False);
 //BA.debugLineNum = 101;BA.debugLine="pn1.Visible = False";
_pn1.setVisible(__c.False);
 //BA.debugLineNum = 102;BA.debugLine="ivQRCode.Bitmap = Null";
_ivqrcode.setBitmap((android.graphics.Bitmap)(__c.Null));
 //BA.debugLineNum = 103;BA.debugLine="GetWalletBalance(currentWalletAddress)";
_getwalletbalance(_currentwalletaddress);
 //BA.debugLineNum = 104;BA.debugLine="End Sub";
return "";
}
public String  _onwaitingforscan(String _ignored) throws Exception{
 //BA.debugLineNum = 111;BA.debugLine="Sub OnWaitingForScan(ignored As String)";
 //BA.debugLineNum = 112;BA.debugLine="lblStatus.Text = \"Waiting Wallet Scan...\"";
_lblstatus.setText(BA.ObjectToCharSequence("Waiting Wallet Scan..."));
 //BA.debugLineNum = 113;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
if (BA.fastSubCompare(sub, "B4XPAGE_CREATED"))
	return _b4xpage_created((anywheresoftware.b4a.objects.B4XViewWrapper) args[0]);
if (BA.fastSubCompare(sub, "JOBDONE"))
	return _jobdone((com.pdv.httpjob) args[0]);
if (BA.fastSubCompare(sub, "ONLOGINERROR"))
	return _onloginerror((String) args[0]);
if (BA.fastSubCompare(sub, "ONLOGINSESSIONCREATED"))
	return _onloginsessioncreated((String) args[0]);
if (BA.fastSubCompare(sub, "ONLOGINSUCCESS"))
	return _onloginsuccess((String) args[0]);
if (BA.fastSubCompare(sub, "ONWAITINGFORSCAN"))
	return _onwaitingforscan((String) args[0]);
return BA.SubDelegator.SubNotFound;
}
}
