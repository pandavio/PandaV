package pandav.io.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_mainly{

public static void LS_general(anywheresoftware.b4a.BA ba, android.view.View parent, anywheresoftware.b4a.keywords.LayoutValues lv, java.util.Map props,
java.util.Map<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) throws Exception {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
views.get("pnsplash").vw.setWidth((int)((100d / 100 * width)));
views.get("pnsplash").vw.setHeight((int)((100d / 100 * height)));
views.get("pnsplash").vw.setLeft((int)((0d / 100 * width)));
views.get("pnsplash").vw.setTop((int)((0d / 100 * height)));
views.get("imgsplashlogo").vw.setWidth((int)((150d * scale)));
views.get("imgsplashlogo").vw.setHeight((int)((150d * scale)));
views.get("imgsplashlogo").vw.setLeft((int)((50d / 100 * width) - (views.get("imgsplashlogo").vw.getWidth() / 2)));
views.get("imgsplashlogo").vw.setTop((int)((20d / 100 * height)));
views.get("lblcopyright").vw.setWidth((int)((100d / 100 * width)));
views.get("lblcopyright").vw.setHeight((int)((60d * scale)));
views.get("lblcopyright").vw.setLeft((int)((0d * scale)));
views.get("lblcopyright").vw.setTop((int)((100d / 100 * height) - (views.get("lblcopyright").vw.getHeight())));
views.get("imglogo").vw.setWidth((int)((150d * scale)));
views.get("imglogo").vw.setHeight((int)((150d * scale)));
views.get("imglogo").vw.setLeft((int)((50d / 100 * width) - (views.get("imglogo").vw.getWidth() / 2)));
views.get("imglogo").vw.setTop((int)((5d / 100 * height)));
views.get("txtusername").vw.setWidth((int)((70d / 100 * width)));
views.get("txtusername").vw.setHeight((int)((60d * scale)));
views.get("txtusername").vw.setLeft((int)((50d / 100 * width) - (views.get("txtusername").vw.getWidth() / 2)));
views.get("txtusername").vw.setTop((int)((40d / 100 * height)));
views.get("txtpassword").vw.setWidth((int)((70d / 100 * width)));
views.get("txtpassword").vw.setHeight((int)((views.get("txtusername").vw.getHeight())));
views.get("txtpassword").vw.setLeft((int)((50d / 100 * width) - (views.get("txtpassword").vw.getWidth() / 2)));
views.get("txtpassword").vw.setTop((int)((views.get("txtusername").vw.getTop() + views.get("txtusername").vw.getHeight())));
views.get("lbllanguage1").vw.setWidth((int)((70d / 100 * width)));
views.get("lbllanguage1").vw.setHeight((int)((45d * scale)));
views.get("lbllanguage1").vw.setLeft((int)((50d / 100 * width) - (views.get("lbllanguage1").vw.getWidth() / 2)));
views.get("lbllanguage1").vw.setTop((int)((views.get("txtpassword").vw.getTop() + views.get("txtpassword").vw.getHeight())));
views.get("lbllanguage2").vw.setWidth((int)((70d / 100 * width)));
views.get("lbllanguage2").vw.setHeight((int)((45d * scale)));
views.get("lbllanguage2").vw.setLeft((int)((50d / 100 * width) - (views.get("lbllanguage2").vw.getWidth() / 2)));
views.get("lbllanguage2").vw.setTop((int)((views.get("lbllanguage1").vw.getTop() + views.get("lbllanguage1").vw.getHeight())));
views.get("checkbox1").vw.setWidth((int)((views.get("txtusername").vw.getWidth())/2d));
views.get("checkbox1").vw.setHeight((int)((views.get("txtusername").vw.getHeight())));
views.get("checkbox1").vw.setLeft((int)((views.get("txtusername").vw.getLeft())));
views.get("checkbox1").vw.setTop((int)((views.get("txtpassword").vw.getTop() + views.get("txtpassword").vw.getHeight())));
views.get("lblforgot").vw.setWidth((int)((views.get("checkbox1").vw.getWidth())));
views.get("lblforgot").vw.setHeight((int)((views.get("checkbox1").vw.getHeight())));
views.get("lblforgot").vw.setLeft((int)((views.get("checkbox1").vw.getLeft() + views.get("checkbox1").vw.getWidth())));
views.get("lblforgot").vw.setTop((int)((views.get("checkbox1").vw.getTop())));
views.get("lblregister").vw.setWidth((int)((views.get("txtusername").vw.getWidth())));
views.get("lblregister").vw.setHeight((int)((45d * scale)));
views.get("lblregister").vw.setLeft((int)((views.get("txtusername").vw.getLeft())));
views.get("lblregister").vw.setTop((int)((views.get("checkbox1").vw.getTop() + views.get("checkbox1").vw.getHeight())));
views.get("btnlogin").vw.setWidth((int)((100d / 100 * width)));
views.get("btnlogin").vw.setHeight((int)((60d * scale)));
views.get("btnlogin").vw.setLeft((int)((0d * scale)));
views.get("btnlogin").vw.setTop((int)((96d / 100 * height) - (views.get("btnlogin").vw.getHeight())));

}
}