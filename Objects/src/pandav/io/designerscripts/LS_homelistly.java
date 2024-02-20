package pandav.io.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_homelistly{

public static void LS_general(anywheresoftware.b4a.BA ba, android.view.View parent, anywheresoftware.b4a.keywords.LayoutValues lv, java.util.Map props,
java.util.Map<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) throws Exception {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
//BA.debugLineNum = 4;BA.debugLine="lblGateway.Width = 96%x"[HomeListLy/General script]
views.get("lblgateway").vw.setWidth((int)((96d / 100 * width)));
//BA.debugLineNum = 5;BA.debugLine="lblGateway.Height = 25dip"[HomeListLy/General script]
views.get("lblgateway").vw.setHeight((int)((25d * scale)));
//BA.debugLineNum = 6;BA.debugLine="lblGateway.Left = 2%x"[HomeListLy/General script]
views.get("lblgateway").vw.setLeft((int)((2d / 100 * width)));
//BA.debugLineNum = 7;BA.debugLine="lblGateway.Top = 1%y"[HomeListLy/General script]
views.get("lblgateway").vw.setTop((int)((1d / 100 * height)));
//BA.debugLineNum = 9;BA.debugLine="imgStatus.Width = 40dip"[HomeListLy/General script]
views.get("imgstatus").vw.setWidth((int)((40d * scale)));
//BA.debugLineNum = 10;BA.debugLine="imgStatus.Height = 40dip"[HomeListLy/General script]
views.get("imgstatus").vw.setHeight((int)((40d * scale)));
//BA.debugLineNum = 11;BA.debugLine="imgStatus.Left = 2%x"[HomeListLy/General script]
views.get("imgstatus").vw.setLeft((int)((2d / 100 * width)));
//BA.debugLineNum = 12;BA.debugLine="imgStatus.Top = lblGateway.Bottom +1%y"[HomeListLy/General script]
views.get("imgstatus").vw.setTop((int)((views.get("lblgateway").vw.getTop() + views.get("lblgateway").vw.getHeight())+(1d / 100 * height)));
//BA.debugLineNum = 14;BA.debugLine="lblDate1.Width = 15%x"[HomeListLy/General script]
views.get("lbldate1").vw.setWidth((int)((15d / 100 * width)));
//BA.debugLineNum = 15;BA.debugLine="lblDate1.Height = 20dip"[HomeListLy/General script]
views.get("lbldate1").vw.setHeight((int)((20d * scale)));
//BA.debugLineNum = 16;BA.debugLine="lblDate1.Left = imgStatus.Right +3%x"[HomeListLy/General script]
views.get("lbldate1").vw.setLeft((int)((views.get("imgstatus").vw.getLeft() + views.get("imgstatus").vw.getWidth())+(3d / 100 * width)));
//BA.debugLineNum = 17;BA.debugLine="lblDate1.Top = lblGateway.Bottom"[HomeListLy/General script]
views.get("lbldate1").vw.setTop((int)((views.get("lblgateway").vw.getTop() + views.get("lblgateway").vw.getHeight())));
//BA.debugLineNum = 19;BA.debugLine="lblDot1.Width = 5%x"[HomeListLy/General script]
views.get("lbldot1").vw.setWidth((int)((5d / 100 * width)));
//BA.debugLineNum = 20;BA.debugLine="lblDot1.Height = 20dip"[HomeListLy/General script]
views.get("lbldot1").vw.setHeight((int)((20d * scale)));
//BA.debugLineNum = 21;BA.debugLine="lblDot1.Left = lblDate1.Right"[HomeListLy/General script]
views.get("lbldot1").vw.setLeft((int)((views.get("lbldate1").vw.getLeft() + views.get("lbldate1").vw.getWidth())));
//BA.debugLineNum = 22;BA.debugLine="lblDot1.Top = lblDate1.Top"[HomeListLy/General script]
views.get("lbldot1").vw.setTop((int)((views.get("lbldate1").vw.getTop())));
//BA.debugLineNum = 24;BA.debugLine="lblDate2.Width = 63%x"[HomeListLy/General script]
views.get("lbldate2").vw.setWidth((int)((63d / 100 * width)));
//BA.debugLineNum = 25;BA.debugLine="lblDate2.Height = 20dip"[HomeListLy/General script]
views.get("lbldate2").vw.setHeight((int)((20d * scale)));
//BA.debugLineNum = 26;BA.debugLine="lblDate2.Left = lblDot1.Right"[HomeListLy/General script]
views.get("lbldate2").vw.setLeft((int)((views.get("lbldot1").vw.getLeft() + views.get("lbldot1").vw.getWidth())));
//BA.debugLineNum = 27;BA.debugLine="lblDate2.Top = lblDate1.Top"[HomeListLy/General script]
views.get("lbldate2").vw.setTop((int)((views.get("lbldate1").vw.getTop())));
//BA.debugLineNum = 29;BA.debugLine="lblStatus1.Width = lblDate1.Width"[HomeListLy/General script]
views.get("lblstatus1").vw.setWidth((int)((views.get("lbldate1").vw.getWidth())));
//BA.debugLineNum = 30;BA.debugLine="lblStatus1.Height = lblDate1.Height"[HomeListLy/General script]
views.get("lblstatus1").vw.setHeight((int)((views.get("lbldate1").vw.getHeight())));
//BA.debugLineNum = 31;BA.debugLine="lblStatus1.Left = lblDate1.Left"[HomeListLy/General script]
views.get("lblstatus1").vw.setLeft((int)((views.get("lbldate1").vw.getLeft())));
//BA.debugLineNum = 32;BA.debugLine="lblStatus1.Top = lblDate1.Bottom"[HomeListLy/General script]
views.get("lblstatus1").vw.setTop((int)((views.get("lbldate1").vw.getTop() + views.get("lbldate1").vw.getHeight())));
//BA.debugLineNum = 34;BA.debugLine="lblDot2.Width = lblDot1.Width"[HomeListLy/General script]
views.get("lbldot2").vw.setWidth((int)((views.get("lbldot1").vw.getWidth())));
//BA.debugLineNum = 35;BA.debugLine="lblDot2.Height = lblDot1.Height"[HomeListLy/General script]
views.get("lbldot2").vw.setHeight((int)((views.get("lbldot1").vw.getHeight())));
//BA.debugLineNum = 36;BA.debugLine="lblDot2.Left = lblDot1.Left"[HomeListLy/General script]
views.get("lbldot2").vw.setLeft((int)((views.get("lbldot1").vw.getLeft())));
//BA.debugLineNum = 37;BA.debugLine="lblDot2.Top = lblDot1.Bottom"[HomeListLy/General script]
views.get("lbldot2").vw.setTop((int)((views.get("lbldot1").vw.getTop() + views.get("lbldot1").vw.getHeight())));
//BA.debugLineNum = 39;BA.debugLine="lblStatus2.Width = lblDate2.Width"[HomeListLy/General script]
views.get("lblstatus2").vw.setWidth((int)((views.get("lbldate2").vw.getWidth())));
//BA.debugLineNum = 40;BA.debugLine="lblStatus2.Height = lblDate2.Height"[HomeListLy/General script]
views.get("lblstatus2").vw.setHeight((int)((views.get("lbldate2").vw.getHeight())));
//BA.debugLineNum = 41;BA.debugLine="lblStatus2.Left = lblDate2.Left"[HomeListLy/General script]
views.get("lblstatus2").vw.setLeft((int)((views.get("lbldate2").vw.getLeft())));
//BA.debugLineNum = 42;BA.debugLine="lblStatus2.Top = lblDate2.Bottom"[HomeListLy/General script]
views.get("lblstatus2").vw.setTop((int)((views.get("lbldate2").vw.getTop() + views.get("lbldate2").vw.getHeight())));
//BA.debugLineNum = 44;BA.debugLine="lblDesc1.Width = lblDate1.Width"[HomeListLy/General script]
views.get("lbldesc1").vw.setWidth((int)((views.get("lbldate1").vw.getWidth())));
//BA.debugLineNum = 45;BA.debugLine="lblDesc1.Height = lblDate1.Height"[HomeListLy/General script]
views.get("lbldesc1").vw.setHeight((int)((views.get("lbldate1").vw.getHeight())));
//BA.debugLineNum = 46;BA.debugLine="lblDesc1.Left = lblDate1.Left"[HomeListLy/General script]
views.get("lbldesc1").vw.setLeft((int)((views.get("lbldate1").vw.getLeft())));
//BA.debugLineNum = 47;BA.debugLine="lblDesc1.Top = lblStatus1.Bottom"[HomeListLy/General script]
views.get("lbldesc1").vw.setTop((int)((views.get("lblstatus1").vw.getTop() + views.get("lblstatus1").vw.getHeight())));
//BA.debugLineNum = 49;BA.debugLine="lblDot3.Width = lblDot1.Width"[HomeListLy/General script]
views.get("lbldot3").vw.setWidth((int)((views.get("lbldot1").vw.getWidth())));
//BA.debugLineNum = 50;BA.debugLine="lblDot3.Height = lblDot1.Height"[HomeListLy/General script]
views.get("lbldot3").vw.setHeight((int)((views.get("lbldot1").vw.getHeight())));
//BA.debugLineNum = 51;BA.debugLine="lblDot3.Left = lblDot1.Left"[HomeListLy/General script]
views.get("lbldot3").vw.setLeft((int)((views.get("lbldot1").vw.getLeft())));
//BA.debugLineNum = 52;BA.debugLine="lblDot3.Top = lblDot2.Bottom"[HomeListLy/General script]
views.get("lbldot3").vw.setTop((int)((views.get("lbldot2").vw.getTop() + views.get("lbldot2").vw.getHeight())));
//BA.debugLineNum = 54;BA.debugLine="lblDesc2.Width = lblDate2.Width"[HomeListLy/General script]
views.get("lbldesc2").vw.setWidth((int)((views.get("lbldate2").vw.getWidth())));
//BA.debugLineNum = 55;BA.debugLine="lblDesc2.Height = lblDate2.Height"[HomeListLy/General script]
views.get("lbldesc2").vw.setHeight((int)((views.get("lbldate2").vw.getHeight())));
//BA.debugLineNum = 56;BA.debugLine="lblDesc2.Left = lblDate2.Left"[HomeListLy/General script]
views.get("lbldesc2").vw.setLeft((int)((views.get("lbldate2").vw.getLeft())));
//BA.debugLineNum = 57;BA.debugLine="lblDesc2.Top = lblStatus2.Bottom"[HomeListLy/General script]
views.get("lbldesc2").vw.setTop((int)((views.get("lblstatus2").vw.getTop() + views.get("lblstatus2").vw.getHeight())));

}
}