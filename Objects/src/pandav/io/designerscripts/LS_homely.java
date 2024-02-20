package pandav.io.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_homely{

public static void LS_general(anywheresoftware.b4a.BA ba, android.view.View parent, anywheresoftware.b4a.keywords.LayoutValues lv, java.util.Map props,
java.util.Map<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) throws Exception {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
views.get("imgavatar").vw.setWidth((int)((75d * scale)));
views.get("imgavatar").vw.setHeight((int)((75d * scale)));
views.get("imgavatar").vw.setLeft((int)((3d / 100 * width)));
views.get("imgavatar").vw.setTop((int)((20d / 100 * height)));
views.get("lbldisplayname").vw.setWidth((int)((35d / 100 * width)));
views.get("lbldisplayname").vw.setHeight((int)((25d * scale)));
views.get("lbldisplayname").vw.setLeft((int)((views.get("imgavatar").vw.getLeft() + views.get("imgavatar").vw.getWidth())+(2d / 100 * width)));
views.get("lbldisplayname").vw.setTop((int)((views.get("imgavatar").vw.getTop())+(2d / 100 * height)));
views.get("lbltitle").vw.setWidth((int)((views.get("lbldisplayname").vw.getWidth())));
views.get("lbltitle").vw.setHeight((int)((views.get("lbldisplayname").vw.getHeight())));
views.get("lbltitle").vw.setLeft((int)((views.get("lbldisplayname").vw.getLeft() + views.get("lbldisplayname").vw.getWidth())));
views.get("lbltitle").vw.setTop((int)((views.get("lbldisplayname").vw.getTop())));
views.get("lbluid").vw.setWidth((int)((views.get("lbldisplayname").vw.getWidth())));
views.get("lbluid").vw.setHeight((int)((views.get("lbldisplayname").vw.getHeight())));
views.get("lbluid").vw.setLeft((int)((views.get("lbldisplayname").vw.getLeft())));
views.get("lbluid").vw.setTop((int)((views.get("lbldisplayname").vw.getTop() + views.get("lbldisplayname").vw.getHeight())));
views.get("lblbalance").vw.setWidth((int)((views.get("lbldisplayname").vw.getWidth())));
views.get("lblbalance").vw.setHeight((int)((views.get("lbldisplayname").vw.getHeight())));
views.get("lblbalance").vw.setLeft((int)((views.get("lbluid").vw.getLeft() + views.get("lbluid").vw.getWidth())));
views.get("lblbalance").vw.setTop((int)((views.get("lbluid").vw.getTop())));
views.get("lbltopic").vw.setWidth((int)((94d / 100 * width)));
views.get("lbltopic").vw.setHeight((int)((60d * scale)));
views.get("lbltopic").vw.setLeft((int)((50d / 100 * width) - (views.get("lbltopic").vw.getWidth() / 2)));
views.get("lbltopic").vw.setTop((int)((32d / 100 * height)));
views.get("imgicon1").vw.setWidth((int)((35d * scale)));
views.get("imgicon1").vw.setHeight((int)((35d * scale)));
views.get("imgicon1").vw.setLeft((int)((views.get("lbltopic").vw.getLeft())+(2d / 100 * width)));
views.get("imgicon1").vw.setTop((int)((views.get("lbltopic").vw.getTop() + views.get("lbltopic").vw.getHeight()/2) - (views.get("imgicon1").vw.getHeight() / 2)));
views.get("lblicon1").vw.setWidth((int)((50d * scale)));
views.get("lblicon1").vw.setHeight((int)((35d * scale)));
views.get("lblicon1").vw.setLeft((int)((views.get("imgicon1").vw.getLeft() + views.get("imgicon1").vw.getWidth())+(2d / 100 * width)));
views.get("lblicon1").vw.setTop((int)((views.get("imgicon1").vw.getTop() + views.get("imgicon1").vw.getHeight()/2) - (views.get("lblicon1").vw.getHeight() / 2)));
views.get("lblspline1").vw.setWidth((int)((20d * scale)));
views.get("lblspline1").vw.setHeight((int)((60d * scale)));
views.get("lblspline1").vw.setLeft((int)((views.get("lblicon1").vw.getLeft() + views.get("lblicon1").vw.getWidth())+(2d / 100 * width)));
views.get("lblspline1").vw.setTop((int)((views.get("lbltopic").vw.getTop())));
views.get("imgicon2").vw.setWidth((int)((views.get("imgicon1").vw.getWidth())));
views.get("imgicon2").vw.setHeight((int)((views.get("imgicon1").vw.getHeight())));
views.get("imgicon2").vw.setLeft((int)((views.get("lblspline1").vw.getLeft() + views.get("lblspline1").vw.getWidth())+(2d / 100 * width)));
views.get("imgicon2").vw.setTop((int)((views.get("imgicon1").vw.getTop() + views.get("imgicon1").vw.getHeight()/2) - (views.get("imgicon2").vw.getHeight() / 2)));
views.get("lblicon2").vw.setWidth((int)((50d * scale)));
views.get("lblicon2").vw.setHeight((int)((35d * scale)));
views.get("lblicon2").vw.setLeft((int)((views.get("imgicon2").vw.getLeft() + views.get("imgicon2").vw.getWidth())+(2d / 100 * width)));
//BA.debugLineNum = 58;BA.debugLine="lblicon2.VerticalCenter = imgicon1.VerticalCenter"[HomeLy/General script]
views.get("lblicon2").vw.setTop((int)((views.get("imgicon1").vw.getTop() + views.get("imgicon1").vw.getHeight()/2) - (views.get("lblicon2").vw.getHeight() / 2)));
//BA.debugLineNum = 60;BA.debugLine="lblSpline2.Width = lblSpline1.Width"[HomeLy/General script]
views.get("lblspline2").vw.setWidth((int)((views.get("lblspline1").vw.getWidth())));
//BA.debugLineNum = 61;BA.debugLine="lblSpline2.Height = lblSpline1.Height"[HomeLy/General script]
views.get("lblspline2").vw.setHeight((int)((views.get("lblspline1").vw.getHeight())));
//BA.debugLineNum = 62;BA.debugLine="lblSpline2.Left = lblicon2.Right +2%x"[HomeLy/General script]
views.get("lblspline2").vw.setLeft((int)((views.get("lblicon2").vw.getLeft() + views.get("lblicon2").vw.getWidth())+(2d / 100 * width)));
//BA.debugLineNum = 63;BA.debugLine="lblSpline2.Top = lblTopic.Top"[HomeLy/General script]
views.get("lblspline2").vw.setTop((int)((views.get("lbltopic").vw.getTop())));
//BA.debugLineNum = 65;BA.debugLine="imgicon3.Width = imgicon1.Width"[HomeLy/General script]
views.get("imgicon3").vw.setWidth((int)((views.get("imgicon1").vw.getWidth())));
//BA.debugLineNum = 66;BA.debugLine="imgicon3.Height = imgicon1.Height"[HomeLy/General script]
views.get("imgicon3").vw.setHeight((int)((views.get("imgicon1").vw.getHeight())));
//BA.debugLineNum = 67;BA.debugLine="imgicon3.Left = lblSpline2.Right +2%x"[HomeLy/General script]
views.get("imgicon3").vw.setLeft((int)((views.get("lblspline2").vw.getLeft() + views.get("lblspline2").vw.getWidth())+(2d / 100 * width)));
//BA.debugLineNum = 68;BA.debugLine="imgicon3.VerticalCenter = lblTopic.VerticalCenter"[HomeLy/General script]
views.get("imgicon3").vw.setTop((int)((views.get("lbltopic").vw.getTop() + views.get("lbltopic").vw.getHeight()/2) - (views.get("imgicon3").vw.getHeight() / 2)));
//BA.debugLineNum = 70;BA.debugLine="lblicon3.Width = 50dip"[HomeLy/General script]
views.get("lblicon3").vw.setWidth((int)((50d * scale)));
//BA.debugLineNum = 71;BA.debugLine="lblicon3.Height = 35dip"[HomeLy/General script]
views.get("lblicon3").vw.setHeight((int)((35d * scale)));
//BA.debugLineNum = 72;BA.debugLine="lblicon3.Left = imgicon3.Right + 2%x"[HomeLy/General script]
views.get("lblicon3").vw.setLeft((int)((views.get("imgicon3").vw.getLeft() + views.get("imgicon3").vw.getWidth())+(2d / 100 * width)));
//BA.debugLineNum = 73;BA.debugLine="lblicon3.VerticalCenter = imgicon1.VerticalCenter"[HomeLy/General script]
views.get("lblicon3").vw.setTop((int)((views.get("imgicon1").vw.getTop() + views.get("imgicon1").vw.getHeight()/2) - (views.get("lblicon3").vw.getHeight() / 2)));
//BA.debugLineNum = 132;BA.debugLine="lblFooter.Width = 100%x"[HomeLy/General script]
views.get("lblfooter").vw.setWidth((int)((100d / 100 * width)));
//BA.debugLineNum = 133;BA.debugLine="lblFooter.Height = 60dip"[HomeLy/General script]
views.get("lblfooter").vw.setHeight((int)((60d * scale)));
//BA.debugLineNum = 134;BA.debugLine="lblFooter.Left = 0%x"[HomeLy/General script]
views.get("lblfooter").vw.setLeft((int)((0d / 100 * width)));
//BA.debugLineNum = 135;BA.debugLine="lblFooter.Bottom = 100%y"[HomeLy/General script]
views.get("lblfooter").vw.setTop((int)((100d / 100 * height) - (views.get("lblfooter").vw.getHeight())));

}
}