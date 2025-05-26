package com.pdv.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_nftdetailpage{

public static void LS_general(anywheresoftware.b4a.BA ba, android.view.View parent, anywheresoftware.b4a.keywords.LayoutValues lv, java.util.Map props,
java.util.Map<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) throws Exception {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
views.get("lbltop").vw.setWidth((int)((100d / 100 * width)));
views.get("lbltop").vw.setHeight((int)((60d * scale)));
views.get("lbltop").vw.setLeft((int)((0d / 100 * width)));
views.get("lbltop").vw.setTop((int)((0d / 100 * height)));
views.get("lbltopbg").vw.setWidth((int)((100d / 100 * width)));
views.get("lbltopbg").vw.setHeight((int)((250d * scale)));
views.get("lbltopbg").vw.setLeft((int)((0d / 100 * width)));
views.get("lbltopbg").vw.setTop((int)((0d / 100 * height)));
views.get("lbldisplay").vw.setWidth((int)((90d / 100 * width)));
views.get("lbldisplay").vw.setHeight((int)((85d / 100 * height)));
views.get("lbldisplay").vw.setLeft((int)((50d / 100 * width) - (views.get("lbldisplay").vw.getWidth() / 2)));
views.get("lbldisplay").vw.setTop((int)((views.get("lbltop").vw.getTop() + views.get("lbltop").vw.getHeight())));
views.get("lblline1").vw.setWidth((int)((90d / 100 * width)));
views.get("lblline1").vw.setHeight((int)((20d * scale)));
views.get("lblline1").vw.setLeft((int)((50d / 100 * width) - (views.get("lblline1").vw.getWidth() / 2)));
views.get("lblline1").vw.setTop((int)((views.get("lbldisplay").vw.getTop())+(40d * scale)));
views.get("lblqrframe").vw.setWidth((int)((200d * scale)));
views.get("lblqrframe").vw.setHeight((int)((views.get("lblqrframe").vw.getWidth())));
views.get("lblqrframe").vw.setLeft((int)((50d / 100 * width) - (views.get("lblqrframe").vw.getWidth() / 2)));
views.get("lblqrframe").vw.setTop((int)((views.get("lbltopbg").vw.getTop() + views.get("lbltopbg").vw.getHeight()) - (views.get("lblqrframe").vw.getHeight() / 2)));
views.get("imgtokenqr").vw.setWidth((int)((192d * scale)));
views.get("imgtokenqr").vw.setHeight((int)((views.get("imgtokenqr").vw.getWidth())));
views.get("imgtokenqr").vw.setLeft((int)((50d / 100 * width) - (views.get("imgtokenqr").vw.getWidth() / 2)));
views.get("imgtokenqr").vw.setTop((int)((views.get("lbltopbg").vw.getTop() + views.get("lbltopbg").vw.getHeight()) - (views.get("imgtokenqr").vw.getHeight() / 2)));
views.get("lblnftid").vw.setWidth((int)((42d / 100 * width)));
views.get("lblnftid").vw.setHeight((int)((40d * scale)));
views.get("lblnftid").vw.setLeft((int)((15d / 100 * width)));
views.get("lblnftid").vw.setTop((int)((views.get("lblqrframe").vw.getTop() + views.get("lblqrframe").vw.getHeight())+(2d / 100 * height)));
views.get("lblnftframe").vw.setWidth((int)((200d * scale)));
views.get("lblnftframe").vw.setHeight((int)((views.get("lblqrframe").vw.getWidth())));
views.get("lblnftframe").vw.setLeft((int)((50d / 100 * width) - (views.get("lblnftframe").vw.getWidth() / 2)));
views.get("lblnftframe").vw.setTop((int)((views.get("lblqrframe").vw.getTop() + views.get("lblqrframe").vw.getHeight())+(2d / 100 * height)));
views.get("imgnft").vw.setWidth((int)((192d * scale)));
views.get("imgnft").vw.setHeight((int)((views.get("imgnft").vw.getWidth())));
views.get("imgnft").vw.setLeft((int)((50d / 100 * width) - (views.get("imgnft").vw.getWidth() / 2)));
views.get("imgnft").vw.setTop((int)((views.get("lblnftframe").vw.getTop() + views.get("lblnftframe").vw.getHeight()/2) - (views.get("imgnft").vw.getHeight() / 2)));
views.get("lblline2").vw.setWidth((int)((90d / 100 * width)));
views.get("lblline2").vw.setHeight((int)((20d * scale)));
views.get("lblline2").vw.setLeft((int)((50d / 100 * width) - (views.get("lblline2").vw.getWidth() / 2)));
views.get("lblline2").vw.setTop((int)((views.get("lblnftframe").vw.getTop() + views.get("lblnftframe").vw.getHeight())+(2d / 100 * height)));
views.get("imgnftname").vw.setWidth((int)((20d * scale)));
views.get("imgnftname").vw.setHeight((int)((20d * scale)));
views.get("imgnftname").vw.setLeft((int)((10d / 100 * width)));
views.get("imgnftname").vw.setTop((int)((views.get("lblline2").vw.getTop() + views.get("lblline2").vw.getHeight())+(2d / 100 * height)));
views.get("lblnftname").vw.setWidth((int)((72d / 100 * width)));
views.get("lblnftname").vw.setHeight((int)((20d * scale)));
views.get("lblnftname").vw.setLeft((int)((views.get("imgnftname").vw.getLeft() + views.get("imgnftname").vw.getWidth())+(1d / 100 * width)));
views.get("lblnftname").vw.setTop((int)((views.get("imgnftname").vw.getTop())));
views.get("imgnftid").vw.setWidth((int)((views.get("imgnftname").vw.getWidth())));
views.get("imgnftid").vw.setHeight((int)((views.get("imgnftname").vw.getHeight())));
views.get("imgnftid").vw.setLeft((int)((views.get("imgnftname").vw.getLeft())));
views.get("imgnftid").vw.setTop((int)((views.get("imgnftname").vw.getTop() + views.get("imgnftname").vw.getHeight())));
views.get("lblnftid").vw.setWidth((int)((views.get("lblnftname").vw.getWidth())));
views.get("lblnftid").vw.setHeight((int)((40d * scale)));
views.get("lblnftid").vw.setLeft((int)((views.get("lblnftname").vw.getLeft())));
//BA.debugLineNum = 72;BA.debugLine="lblNFTid.Top = lblNFTname.Bottom"[NFTDetailPage/General script]
views.get("lblnftid").vw.setTop((int)((views.get("lblnftname").vw.getTop() + views.get("lblnftname").vw.getHeight())));
//BA.debugLineNum = 74;BA.debugLine="imgStatus.Width = imgNFTname.Width"[NFTDetailPage/General script]
views.get("imgstatus").vw.setWidth((int)((views.get("imgnftname").vw.getWidth())));
//BA.debugLineNum = 75;BA.debugLine="imgStatus.Height = imgNFTname.Height"[NFTDetailPage/General script]
views.get("imgstatus").vw.setHeight((int)((views.get("imgnftname").vw.getHeight())));
//BA.debugLineNum = 76;BA.debugLine="imgStatus.Left = imgNFTname.Left"[NFTDetailPage/General script]
views.get("imgstatus").vw.setLeft((int)((views.get("imgnftname").vw.getLeft())));
//BA.debugLineNum = 77;BA.debugLine="imgStatus.Top = lblNFTid.Bottom"[NFTDetailPage/General script]
views.get("imgstatus").vw.setTop((int)((views.get("lblnftid").vw.getTop() + views.get("lblnftid").vw.getHeight())));
//BA.debugLineNum = 79;BA.debugLine="lblValidStatus.Width = lblNFTname.Width"[NFTDetailPage/General script]
views.get("lblvalidstatus").vw.setWidth((int)((views.get("lblnftname").vw.getWidth())));
//BA.debugLineNum = 80;BA.debugLine="lblValidStatus.Height = lblNFTname.Height"[NFTDetailPage/General script]
views.get("lblvalidstatus").vw.setHeight((int)((views.get("lblnftname").vw.getHeight())));
//BA.debugLineNum = 81;BA.debugLine="lblValidStatus.Left = lblNFTname.Left"[NFTDetailPage/General script]
views.get("lblvalidstatus").vw.setLeft((int)((views.get("lblnftname").vw.getLeft())));
//BA.debugLineNum = 82;BA.debugLine="lblValidStatus.Top = lblNFTid.Bottom"[NFTDetailPage/General script]
views.get("lblvalidstatus").vw.setTop((int)((views.get("lblnftid").vw.getTop() + views.get("lblnftid").vw.getHeight())));
//BA.debugLineNum = 84;BA.debugLine="B4xLoading.Width = 100dip"[NFTDetailPage/General script]
views.get("b4xloading").vw.setWidth((int)((100d * scale)));
//BA.debugLineNum = 85;BA.debugLine="B4xLoading.Height = B4xLoading.Width"[NFTDetailPage/General script]
views.get("b4xloading").vw.setHeight((int)((views.get("b4xloading").vw.getWidth())));
//BA.debugLineNum = 86;BA.debugLine="B4xLoading.HorizontalCenter = 50%x"[NFTDetailPage/General script]
views.get("b4xloading").vw.setLeft((int)((50d / 100 * width) - (views.get("b4xloading").vw.getWidth() / 2)));
//BA.debugLineNum = 87;BA.debugLine="B4xLoading.VerticalCenter = 50%y"[NFTDetailPage/General script]
views.get("b4xloading").vw.setTop((int)((50d / 100 * height) - (views.get("b4xloading").vw.getHeight() / 2)));

}
}