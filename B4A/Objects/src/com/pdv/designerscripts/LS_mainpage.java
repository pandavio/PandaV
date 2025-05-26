package com.pdv.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_mainpage{

public static void LS_general(anywheresoftware.b4a.BA ba, android.view.View parent, anywheresoftware.b4a.keywords.LayoutValues lv, java.util.Map props,
java.util.Map<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) throws Exception {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
views.get("pn1").vw.setWidth((int)((100d / 100 * width)));
views.get("pn1").vw.setHeight((int)((100d / 100 * height)));
views.get("pn1").vw.setLeft((int)((0d / 100 * width)));
views.get("pn1").vw.setTop((int)((0d / 100 * height)));
views.get("ivqrcode").vw.setWidth((int)((128d * scale)));
views.get("ivqrcode").vw.setHeight((int)((128d * scale)));
views.get("ivqrcode").vw.setLeft((int)((50d / 100 * width) - (views.get("ivqrcode").vw.getWidth() / 2)));
views.get("ivqrcode").vw.setTop((int)((50d / 100 * height) - (views.get("ivqrcode").vw.getHeight() / 2)));
views.get("lblstatus").vw.setWidth((int)((100d / 100 * width)));
views.get("lblstatus").vw.setHeight((int)((40d * scale)));
views.get("lblstatus").vw.setLeft((int)((50d / 100 * width) - (views.get("lblstatus").vw.getWidth() / 2)));
views.get("lblstatus").vw.setTop((int)((80d / 100 * height)));
views.get("btnconnect").vw.setWidth((int)((100d / 100 * width)));
views.get("btnconnect").vw.setHeight((int)((60d * scale)));
views.get("btnconnect").vw.setLeft((int)((50d / 100 * width) - (views.get("btnconnect").vw.getWidth() / 2)));
views.get("btnconnect").vw.setTop((int)((views.get("lblstatus").vw.getTop() + views.get("lblstatus").vw.getHeight())));
views.get("btnopenwallet").vw.setWidth((int)((views.get("btnconnect").vw.getWidth())));
views.get("btnopenwallet").vw.setHeight((int)((views.get("btnconnect").vw.getHeight())));
views.get("btnopenwallet").vw.setLeft((int)((50d / 100 * width) - (views.get("btnopenwallet").vw.getWidth() / 2)));
views.get("btnopenwallet").vw.setTop((int)((views.get("btnconnect").vw.getTop())));
views.get("lbltop").vw.setWidth((int)((100d / 100 * width)));
views.get("lbltop").vw.setHeight((int)((60d * scale)));
views.get("lbltop").vw.setLeft((int)((0d / 100 * width)));
views.get("lbltop").vw.setTop((int)((0d / 100 * height)));
views.get("lbltopbg").vw.setWidth((int)((100d / 100 * width)));
views.get("lbltopbg").vw.setHeight((int)((250d * scale)));
views.get("lbltopbg").vw.setLeft((int)((0d / 100 * width)));
views.get("lbltopbg").vw.setTop((int)((0d / 100 * height)));
views.get("lbldisplay").vw.setWidth((int)((90d / 100 * width)));
views.get("lbldisplay").vw.setHeight((int)((180d * scale)));
views.get("lbldisplay").vw.setLeft((int)((50d / 100 * width) - (views.get("lbldisplay").vw.getWidth() / 2)));
views.get("lbldisplay").vw.setTop((int)((views.get("lbltopbg").vw.getTop() + views.get("lbltopbg").vw.getHeight()/2)));
views.get("lblline1").vw.setWidth((int)((90d / 100 * width)));
views.get("lblline1").vw.setHeight((int)((20d * scale)));
views.get("lblline1").vw.setLeft((int)((50d / 100 * width) - (views.get("lblline1").vw.getWidth() / 2)));
//BA.debugLineNum = 49;BA.debugLine="lblLine1.Top = lblDisplay.Top +40dip"[MainPage/General script]
views.get("lblline1").vw.setTop((int)((views.get("lbldisplay").vw.getTop())+(40d * scale)));
//BA.debugLineNum = 51;BA.debugLine="imgWallet.Width = 25dip"[MainPage/General script]
views.get("imgwallet").vw.setWidth((int)((25d * scale)));
//BA.debugLineNum = 52;BA.debugLine="imgWallet.Height = 25dip"[MainPage/General script]
views.get("imgwallet").vw.setHeight((int)((25d * scale)));
//BA.debugLineNum = 53;BA.debugLine="imgWallet.Left = lblDisplay.Left +3%x"[MainPage/General script]
views.get("imgwallet").vw.setLeft((int)((views.get("lbldisplay").vw.getLeft())+(3d / 100 * width)));
//BA.debugLineNum = 54;BA.debugLine="imgWallet.Top = lblDisplay.Top+2%y"[MainPage/General script]
views.get("imgwallet").vw.setTop((int)((views.get("lbldisplay").vw.getTop())+(2d / 100 * height)));
//BA.debugLineNum = 56;BA.debugLine="lblTitle.Width =20%x"[MainPage/General script]
views.get("lbltitle").vw.setWidth((int)((20d / 100 * width)));
//BA.debugLineNum = 57;BA.debugLine="lblTitle.Height = 25dip"[MainPage/General script]
views.get("lbltitle").vw.setHeight((int)((25d * scale)));
//BA.debugLineNum = 58;BA.debugLine="lblTitle.Left = imgWallet.Right +1%x"[MainPage/General script]
views.get("lbltitle").vw.setLeft((int)((views.get("imgwallet").vw.getLeft() + views.get("imgwallet").vw.getWidth())+(1d / 100 * width)));
//BA.debugLineNum = 59;BA.debugLine="lblTitle.Top = imgWallet.Top"[MainPage/General script]
views.get("lbltitle").vw.setTop((int)((views.get("imgwallet").vw.getTop())));
//BA.debugLineNum = 61;BA.debugLine="lblPDVAmout.Width = 45%x"[MainPage/General script]
views.get("lblpdvamout").vw.setWidth((int)((45d / 100 * width)));
//BA.debugLineNum = 62;BA.debugLine="lblPDVAmout.Height = 25dip"[MainPage/General script]
views.get("lblpdvamout").vw.setHeight((int)((25d * scale)));
//BA.debugLineNum = 63;BA.debugLine="lblPDVAmout.Right = lblDisplay.Right -3%x"[MainPage/General script]
views.get("lblpdvamout").vw.setLeft((int)((views.get("lbldisplay").vw.getLeft() + views.get("lbldisplay").vw.getWidth())-(3d / 100 * width) - (views.get("lblpdvamout").vw.getWidth())));
//BA.debugLineNum = 64;BA.debugLine="lblPDVAmout.Top = imgWallet.Top"[MainPage/General script]
views.get("lblpdvamout").vw.setTop((int)((views.get("imgwallet").vw.getTop())));
//BA.debugLineNum = 66;BA.debugLine="pnListView.Width = 90%x"[MainPage/General script]
views.get("pnlistview").vw.setWidth((int)((90d / 100 * width)));
//BA.debugLineNum = 67;BA.debugLine="pnListView.Height = 55%y"[MainPage/General script]
views.get("pnlistview").vw.setHeight((int)((55d / 100 * height)));
//BA.debugLineNum = 68;BA.debugLine="pnListView.HorizontalCenter = 50%x"[MainPage/General script]
views.get("pnlistview").vw.setLeft((int)((50d / 100 * width) - (views.get("pnlistview").vw.getWidth() / 2)));
//BA.debugLineNum = 69;BA.debugLine="pnListView.Top = lblDisplay.Bottom +2%y"[MainPage/General script]
views.get("pnlistview").vw.setTop((int)((views.get("lbldisplay").vw.getTop() + views.get("lbldisplay").vw.getHeight())+(2d / 100 * height)));
//BA.debugLineNum = 71;BA.debugLine="clvNFTs.Width = 90%x"[MainPage/General script]
views.get("clvnfts").vw.setWidth((int)((90d / 100 * width)));
//BA.debugLineNum = 72;BA.debugLine="clvNFTs.Height = 51%y"[MainPage/General script]
views.get("clvnfts").vw.setHeight((int)((51d / 100 * height)));
//BA.debugLineNum = 73;BA.debugLine="clvNFTs.Left = 0%x"[MainPage/General script]
views.get("clvnfts").vw.setLeft((int)((0d / 100 * width)));
//BA.debugLineNum = 74;BA.debugLine="clvNFTs.Top = 2%y"[MainPage/General script]
views.get("clvnfts").vw.setTop((int)((2d / 100 * height)));

}
}