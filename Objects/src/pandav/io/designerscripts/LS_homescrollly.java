package pandav.io.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_homescrollly{

public static void LS_general(anywheresoftware.b4a.BA ba, android.view.View parent, anywheresoftware.b4a.keywords.LayoutValues lv, java.util.Map props,
java.util.Map<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) throws Exception {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
views.get("lblgateway").vw.setWidth((int)((96d / 100 * width)));
views.get("lblgateway").vw.setHeight((int)((25d * scale)));
views.get("lblgateway").vw.setLeft((int)((2d / 100 * width)));
views.get("lblgateway").vw.setTop((int)((1d / 100 * height)));
views.get("imgstatus").vw.setWidth((int)((40d * scale)));
views.get("imgstatus").vw.setHeight((int)((40d * scale)));
views.get("imgstatus").vw.setLeft((int)((2d / 100 * width)));
views.get("imgstatus").vw.setTop((int)((views.get("lblgateway").vw.getTop() + views.get("lblgateway").vw.getHeight())+(1d / 100 * height)));
views.get("lbldate1").vw.setWidth((int)((15d / 100 * width)));
views.get("lbldate1").vw.setHeight((int)((20d * scale)));
views.get("lbldate1").vw.setLeft((int)((views.get("imgstatus").vw.getLeft() + views.get("imgstatus").vw.getWidth())+(3d / 100 * width)));
views.get("lbldate1").vw.setTop((int)((views.get("lblgateway").vw.getTop() + views.get("lblgateway").vw.getHeight())));
views.get("lbldot1").vw.setWidth((int)((5d / 100 * width)));
views.get("lbldot1").vw.setHeight((int)((20d * scale)));
views.get("lbldot1").vw.setLeft((int)((views.get("lbldate1").vw.getLeft() + views.get("lbldate1").vw.getWidth())));
views.get("lbldot1").vw.setTop((int)((views.get("lbldate1").vw.getTop())));
views.get("lbldate2").vw.setWidth((int)((63d / 100 * width)));
views.get("lbldate2").vw.setHeight((int)((20d * scale)));
views.get("lbldate2").vw.setLeft((int)((views.get("lbldot1").vw.getLeft() + views.get("lbldot1").vw.getWidth())));
views.get("lbldate2").vw.setTop((int)((views.get("lbldate1").vw.getTop())));
views.get("lblstatus1").vw.setWidth((int)((views.get("lbldate1").vw.getWidth())));
views.get("lblstatus1").vw.setHeight((int)((views.get("lbldate1").vw.getHeight())));
views.get("lblstatus1").vw.setLeft((int)((views.get("lbldate1").vw.getLeft())));
views.get("lblstatus1").vw.setTop((int)((views.get("lbldate1").vw.getTop() + views.get("lbldate1").vw.getHeight())));
views.get("lbldot2").vw.setWidth((int)((views.get("lbldot1").vw.getWidth())));
views.get("lbldot2").vw.setHeight((int)((views.get("lbldot1").vw.getHeight())));
views.get("lbldot2").vw.setLeft((int)((views.get("lbldot1").vw.getLeft())));
views.get("lbldot2").vw.setTop((int)((views.get("lbldot1").vw.getTop() + views.get("lbldot1").vw.getHeight())));
views.get("lblstatus2").vw.setWidth((int)((views.get("lbldate2").vw.getWidth())));
views.get("lblstatus2").vw.setHeight((int)((views.get("lbldate2").vw.getHeight())));
views.get("lblstatus2").vw.setLeft((int)((views.get("lbldate2").vw.getLeft())));
views.get("lblstatus2").vw.setTop((int)((views.get("lbldate2").vw.getTop() + views.get("lbldate2").vw.getHeight())));
views.get("lbldesc1").vw.setWidth((int)((views.get("lbldate1").vw.getWidth())));
views.get("lbldesc1").vw.setHeight((int)((views.get("lbldate1").vw.getHeight())));
views.get("lbldesc1").vw.setLeft((int)((views.get("lbldate1").vw.getLeft())));
views.get("lbldesc1").vw.setTop((int)((views.get("lblstatus1").vw.getTop() + views.get("lblstatus1").vw.getHeight())));
views.get("lbldot3").vw.setWidth((int)((views.get("lbldot1").vw.getWidth())));
views.get("lbldot3").vw.setHeight((int)((views.get("lbldot1").vw.getHeight())));
views.get("lbldot3").vw.setLeft((int)((views.get("lbldot1").vw.getLeft())));
views.get("lbldot3").vw.setTop((int)((views.get("lbldot2").vw.getTop() + views.get("lbldot2").vw.getHeight())));
views.get("lbldesc2").vw.setWidth((int)((views.get("lbldate2").vw.getWidth())));
views.get("lbldesc2").vw.setHeight((int)((views.get("lbldate2").vw.getHeight())));
views.get("lbldesc2").vw.setLeft((int)((views.get("lbldate2").vw.getLeft())));
views.get("lbldesc2").vw.setTop((int)((views.get("lblstatus2").vw.getTop() + views.get("lblstatus2").vw.getHeight())));

}
}