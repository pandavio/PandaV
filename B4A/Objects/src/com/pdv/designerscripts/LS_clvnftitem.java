package com.pdv.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_clvnftitem{

public static void LS_general(anywheresoftware.b4a.BA ba, android.view.View parent, anywheresoftware.b4a.keywords.LayoutValues lv, java.util.Map props,
java.util.Map<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) throws Exception {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
//BA.debugLineNum = 2;BA.debugLine="AutoScaleAll"[clvNFTItem/General script]
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
//BA.debugLineNum = 5;BA.debugLine="pnNFT.Width = 90%x"[clvNFTItem/General script]
views.get("pnnft").vw.setWidth((int)((90d / 100 * width)));
//BA.debugLineNum = 6;BA.debugLine="pnNFT.Height = 80dip"[clvNFTItem/General script]
views.get("pnnft").vw.setHeight((int)((80d * scale)));
//BA.debugLineNum = 7;BA.debugLine="pnNFT.Left = 0%x"[clvNFTItem/General script]
views.get("pnnft").vw.setLeft((int)((0d / 100 * width)));
//BA.debugLineNum = 8;BA.debugLine="pnNFT.Top = 0%y"[clvNFTItem/General script]
views.get("pnnft").vw.setTop((int)((0d / 100 * height)));
//BA.debugLineNum = 10;BA.debugLine="imgNFT.Width = 80dip"[clvNFTItem/General script]
views.get("imgnft").vw.setWidth((int)((80d * scale)));
//BA.debugLineNum = 11;BA.debugLine="imgNFT.Height = 80dip"[clvNFTItem/General script]
views.get("imgnft").vw.setHeight((int)((80d * scale)));
//BA.debugLineNum = 12;BA.debugLine="imgNFT.Left = 0%x"[clvNFTItem/General script]
views.get("imgnft").vw.setLeft((int)((0d / 100 * width)));
//BA.debugLineNum = 13;BA.debugLine="imgNFT.Top = 0%y"[clvNFTItem/General script]
views.get("imgnft").vw.setTop((int)((0d / 100 * height)));
//BA.debugLineNum = 15;BA.debugLine="lblHeader.Width = 67%x"[clvNFTItem/General script]
views.get("lblheader").vw.setWidth((int)((67d / 100 * width)));
//BA.debugLineNum = 16;BA.debugLine="lblHeader.Height = 20dip"[clvNFTItem/General script]
views.get("lblheader").vw.setHeight((int)((20d * scale)));
//BA.debugLineNum = 17;BA.debugLine="lblHeader.Left = imgNFT.Right"[clvNFTItem/General script]
views.get("lblheader").vw.setLeft((int)((views.get("imgnft").vw.getLeft() + views.get("imgnft").vw.getWidth())));
//BA.debugLineNum = 18;BA.debugLine="lblHeader.Top = 0%y"[clvNFTItem/General script]
views.get("lblheader").vw.setTop((int)((0d / 100 * height)));
//BA.debugLineNum = 20;BA.debugLine="imgNFTname.Width = 20dip"[clvNFTItem/General script]
views.get("imgnftname").vw.setWidth((int)((20d * scale)));
//BA.debugLineNum = 21;BA.debugLine="imgNFTname.Height = 20dip"[clvNFTItem/General script]
views.get("imgnftname").vw.setHeight((int)((20d * scale)));
//BA.debugLineNum = 22;BA.debugLine="imgNFTname.Left = lblHeader.Left"[clvNFTItem/General script]
views.get("imgnftname").vw.setLeft((int)((views.get("lblheader").vw.getLeft())));
//BA.debugLineNum = 23;BA.debugLine="imgNFTname.Top = lblHeader.Bottom"[clvNFTItem/General script]
views.get("imgnftname").vw.setTop((int)((views.get("lblheader").vw.getTop() + views.get("lblheader").vw.getHeight())));
//BA.debugLineNum = 25;BA.debugLine="imgNFTid.Width = imgNFTname.Width"[clvNFTItem/General script]
views.get("imgnftid").vw.setWidth((int)((views.get("imgnftname").vw.getWidth())));
//BA.debugLineNum = 26;BA.debugLine="imgNFTid.Height = imgNFTname.Height"[clvNFTItem/General script]
views.get("imgnftid").vw.setHeight((int)((views.get("imgnftname").vw.getHeight())));
//BA.debugLineNum = 27;BA.debugLine="imgNFTid.Left = imgNFTname.Left"[clvNFTItem/General script]
views.get("imgnftid").vw.setLeft((int)((views.get("imgnftname").vw.getLeft())));
//BA.debugLineNum = 28;BA.debugLine="imgNFTid.Top = imgNFTname.Bottom"[clvNFTItem/General script]
views.get("imgnftid").vw.setTop((int)((views.get("imgnftname").vw.getTop() + views.get("imgnftname").vw.getHeight())));
//BA.debugLineNum = 30;BA.debugLine="imgStatus.Width = imgNFTname.Width"[clvNFTItem/General script]
views.get("imgstatus").vw.setWidth((int)((views.get("imgnftname").vw.getWidth())));
//BA.debugLineNum = 31;BA.debugLine="imgStatus.Height = imgNFTname.Height"[clvNFTItem/General script]
views.get("imgstatus").vw.setHeight((int)((views.get("imgnftname").vw.getHeight())));
//BA.debugLineNum = 32;BA.debugLine="imgStatus.Left = imgNFTname.Left"[clvNFTItem/General script]
views.get("imgstatus").vw.setLeft((int)((views.get("imgnftname").vw.getLeft())));
//BA.debugLineNum = 33;BA.debugLine="imgStatus.Top = imgNFTid.Bottom"[clvNFTItem/General script]
views.get("imgstatus").vw.setTop((int)((views.get("imgnftid").vw.getTop() + views.get("imgnftid").vw.getHeight())));
//BA.debugLineNum = 35;BA.debugLine="lblNFTname.Width = 60%x"[clvNFTItem/General script]
views.get("lblnftname").vw.setWidth((int)((60d / 100 * width)));
//BA.debugLineNum = 36;BA.debugLine="lblNFTname.Height = 20dip"[clvNFTItem/General script]
views.get("lblnftname").vw.setHeight((int)((20d * scale)));
//BA.debugLineNum = 37;BA.debugLine="lblNFTname.Left = imgNFTname.Right+1%x"[clvNFTItem/General script]
views.get("lblnftname").vw.setLeft((int)((views.get("imgnftname").vw.getLeft() + views.get("imgnftname").vw.getWidth())+(1d / 100 * width)));
//BA.debugLineNum = 38;BA.debugLine="lblNFTname.Top = imgNFTname.Top"[clvNFTItem/General script]
views.get("lblnftname").vw.setTop((int)((views.get("imgnftname").vw.getTop())));
//BA.debugLineNum = 40;BA.debugLine="lblNFTid.Width = lblNFTname.Width"[clvNFTItem/General script]
views.get("lblnftid").vw.setWidth((int)((views.get("lblnftname").vw.getWidth())));
//BA.debugLineNum = 41;BA.debugLine="lblNFTid.Height = lblNFTname.Height"[clvNFTItem/General script]
views.get("lblnftid").vw.setHeight((int)((views.get("lblnftname").vw.getHeight())));
//BA.debugLineNum = 42;BA.debugLine="lblNFTid.Left = lblNFTname.Left"[clvNFTItem/General script]
views.get("lblnftid").vw.setLeft((int)((views.get("lblnftname").vw.getLeft())));
//BA.debugLineNum = 43;BA.debugLine="lblNFTid.Top = lblNFTname.Bottom"[clvNFTItem/General script]
views.get("lblnftid").vw.setTop((int)((views.get("lblnftname").vw.getTop() + views.get("lblnftname").vw.getHeight())));
//BA.debugLineNum = 45;BA.debugLine="lblValidStatus.Width = lblNFTname.Width"[clvNFTItem/General script]
views.get("lblvalidstatus").vw.setWidth((int)((views.get("lblnftname").vw.getWidth())));
//BA.debugLineNum = 46;BA.debugLine="lblValidStatus.Height = lblNFTname.Height"[clvNFTItem/General script]
views.get("lblvalidstatus").vw.setHeight((int)((views.get("lblnftname").vw.getHeight())));
//BA.debugLineNum = 47;BA.debugLine="lblValidStatus.Left = lblNFTname.Left"[clvNFTItem/General script]
views.get("lblvalidstatus").vw.setLeft((int)((views.get("lblnftname").vw.getLeft())));
//BA.debugLineNum = 48;BA.debugLine="lblValidStatus.Top = lblNFTid.Bottom"[clvNFTItem/General script]
views.get("lblvalidstatus").vw.setTop((int)((views.get("lblnftid").vw.getTop() + views.get("lblnftid").vw.getHeight())));

}
}