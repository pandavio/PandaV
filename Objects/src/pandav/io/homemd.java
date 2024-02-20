package pandav.io;


import anywheresoftware.b4a.B4AMenuItem;
import android.app.Activity;
import android.os.Bundle;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.B4AActivity;
import anywheresoftware.b4a.ObjectWrapper;
import anywheresoftware.b4a.objects.ActivityWrapper;
import java.lang.reflect.InvocationTargetException;
import anywheresoftware.b4a.B4AUncaughtException;
import anywheresoftware.b4a.debug.*;
import java.lang.ref.WeakReference;

public class homemd extends Activity implements B4AActivity{
	public static homemd mostCurrent;
	static boolean afterFirstLayout;
	static boolean isFirst = true;
    private static boolean processGlobalsRun = false;
	BALayout layout;
	public static BA processBA;
	BA activityBA;
    ActivityWrapper _activity;
    java.util.ArrayList<B4AMenuItem> menuItems;
	public static final boolean fullScreen = false;
	public static final boolean includeTitle = false;
    public static WeakReference<Activity> previousOne;
    public static boolean dontPause;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        mostCurrent = this;
		if (processBA == null) {
			processBA = new BA(this.getApplicationContext(), null, null, "pandav.io", "pandav.io.homemd");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (homemd).");
				p.finish();
			}
		}
        processBA.setActivityPaused(true);
        processBA.runHook("oncreate", this, null);
		if (!includeTitle) {
        	this.getWindow().requestFeature(android.view.Window.FEATURE_NO_TITLE);
        }
        if (fullScreen) {
        	getWindow().setFlags(android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN,   
        			android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
		
        processBA.sharedProcessBA.activityBA = null;
		layout = new BALayout(this);
		setContentView(layout);
		afterFirstLayout = false;
        WaitForLayout wl = new WaitForLayout();
        if (anywheresoftware.b4a.objects.ServiceHelper.StarterHelper.startFromActivity(this, processBA, wl, false))
		    BA.handler.postDelayed(wl, 5);

	}
	static class WaitForLayout implements Runnable {
		public void run() {
			if (afterFirstLayout)
				return;
			if (mostCurrent == null)
				return;
            
			if (mostCurrent.layout.getWidth() == 0) {
				BA.handler.postDelayed(this, 5);
				return;
			}
			mostCurrent.layout.getLayoutParams().height = mostCurrent.layout.getHeight();
			mostCurrent.layout.getLayoutParams().width = mostCurrent.layout.getWidth();
			afterFirstLayout = true;
			mostCurrent.afterFirstLayout();
		}
	}
	private void afterFirstLayout() {
        if (this != mostCurrent)
			return;
		activityBA = new BA(this, layout, processBA, "pandav.io", "pandav.io.homemd");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "pandav.io.homemd", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (homemd) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (homemd) Resume **");
        processBA.raiseEvent(null, "activity_resume");
        if (android.os.Build.VERSION.SDK_INT >= 11) {
			try {
				android.app.Activity.class.getMethod("invalidateOptionsMenu").invoke(this,(Object[]) null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	public void addMenuItem(B4AMenuItem item) {
		if (menuItems == null)
			menuItems = new java.util.ArrayList<B4AMenuItem>();
		menuItems.add(item);
	}
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		super.onCreateOptionsMenu(menu);
        try {
            if (processBA.subExists("activity_actionbarhomeclick")) {
                Class.forName("android.app.ActionBar").getMethod("setHomeButtonEnabled", boolean.class).invoke(
                    getClass().getMethod("getActionBar").invoke(this), true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (processBA.runHook("oncreateoptionsmenu", this, new Object[] {menu}))
            return true;
		if (menuItems == null)
			return false;
		for (B4AMenuItem bmi : menuItems) {
			android.view.MenuItem mi = menu.add(bmi.title);
			if (bmi.drawable != null)
				mi.setIcon(bmi.drawable);
            if (android.os.Build.VERSION.SDK_INT >= 11) {
				try {
                    if (bmi.addToBar) {
				        android.view.MenuItem.class.getMethod("setShowAsAction", int.class).invoke(mi, 1);
                    }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			mi.setOnMenuItemClickListener(new B4AMenuItemsClickListener(bmi.eventName.toLowerCase(BA.cul)));
		}
        
		return true;
	}   
 @Override
 public boolean onOptionsItemSelected(android.view.MenuItem item) {
    if (item.getItemId() == 16908332) {
        processBA.raiseEvent(null, "activity_actionbarhomeclick");
        return true;
    }
    else
        return super.onOptionsItemSelected(item); 
}
@Override
 public boolean onPrepareOptionsMenu(android.view.Menu menu) {
    super.onPrepareOptionsMenu(menu);
    processBA.runHook("onprepareoptionsmenu", this, new Object[] {menu});
    return true;
    
 }
 protected void onStart() {
    super.onStart();
    processBA.runHook("onstart", this, null);
}
 protected void onStop() {
    super.onStop();
    processBA.runHook("onstop", this, null);
}
    public void onWindowFocusChanged(boolean hasFocus) {
       super.onWindowFocusChanged(hasFocus);
       if (processBA.subExists("activity_windowfocuschanged"))
           processBA.raiseEvent2(null, true, "activity_windowfocuschanged", false, hasFocus);
    }
	private class B4AMenuItemsClickListener implements android.view.MenuItem.OnMenuItemClickListener {
		private final String eventName;
		public B4AMenuItemsClickListener(String eventName) {
			this.eventName = eventName;
		}
		public boolean onMenuItemClick(android.view.MenuItem item) {
			processBA.raiseEventFromUI(item.getTitle(), eventName + "_click");
			return true;
		}
	}
    public static Class<?> getObject() {
		return homemd.class;
	}
    private Boolean onKeySubExist = null;
    private Boolean onKeyUpSubExist = null;
	@Override
	public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeydown", this, new Object[] {keyCode, event}))
            return true;
		if (onKeySubExist == null)
			onKeySubExist = processBA.subExists("activity_keypress");
		if (onKeySubExist) {
			if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK &&
					android.os.Build.VERSION.SDK_INT >= 18) {
				HandleKeyDelayed hk = new HandleKeyDelayed();
				hk.kc = keyCode;
				BA.handler.post(hk);
				return true;
			}
			else {
				boolean res = new HandleKeyDelayed().runDirectly(keyCode);
				if (res)
					return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}
	private class HandleKeyDelayed implements Runnable {
		int kc;
		public void run() {
			runDirectly(kc);
		}
		public boolean runDirectly(int keyCode) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keypress", false, keyCode);
			if (res == null || res == true) {
                return true;
            }
            else if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK) {
				finish();
				return true;
			}
            return false;
		}
		
	}
    @Override
	public boolean onKeyUp(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeyup", this, new Object[] {keyCode, event}))
            return true;
		if (onKeyUpSubExist == null)
			onKeyUpSubExist = processBA.subExists("activity_keyup");
		if (onKeyUpSubExist) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keyup", false, keyCode);
			if (res == null || res == true)
				return true;
		}
		return super.onKeyUp(keyCode, event);
	}
	@Override
	public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
		this.setIntent(intent);
        processBA.runHook("onnewintent", this, new Object[] {intent});
	}
    @Override 
	public void onPause() {
		super.onPause();
        if (_activity == null)
            return;
        if (this != mostCurrent)
			return;
		anywheresoftware.b4a.Msgbox.dismiss(true);
        if (!dontPause)
            BA.LogInfo("** Activity (homemd) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (homemd) Pause event (activity is not paused). **");
        if (mostCurrent != null)
            processBA.raiseEvent2(_activity, true, "activity_pause", false, activityBA.activity.isFinishing());		
        if (!dontPause) {
            processBA.setActivityPaused(true);
            mostCurrent = null;
        }

        if (!activityBA.activity.isFinishing())
			previousOne = new WeakReference<Activity>(this);
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        processBA.runHook("onpause", this, null);
	}

	@Override
	public void onDestroy() {
        super.onDestroy();
		previousOne = null;
        processBA.runHook("ondestroy", this, null);
	}
    @Override 
	public void onResume() {
		super.onResume();
        mostCurrent = this;
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (activityBA != null) { //will be null during activity create (which waits for AfterLayout).
        	ResumeMessage rm = new ResumeMessage(mostCurrent);
        	BA.handler.post(rm);
        }
        processBA.runHook("onresume", this, null);
	}
    private static class ResumeMessage implements Runnable {
    	private final WeakReference<Activity> activity;
    	public ResumeMessage(Activity activity) {
    		this.activity = new WeakReference<Activity>(activity);
    	}
		public void run() {
            homemd mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (homemd) Resume **");
            if (mc != mostCurrent)
                return;
		    processBA.raiseEvent(mc._activity, "activity_resume", (Object[])null);
		}
    }
	@Override
	protected void onActivityResult(int requestCode, int resultCode,
	      android.content.Intent data) {
		processBA.onActivityResult(requestCode, resultCode, data);
        processBA.runHook("onactivityresult", this, new Object[] {requestCode, resultCode});
	}
	private static void initializeGlobals() {
		processBA.raiseEvent2(null, true, "globals", false, (Object[])null);
	}
    public void onRequestPermissionsResult(int requestCode,
        String permissions[], int[] grantResults) {
        for (int i = 0;i < permissions.length;i++) {
            Object[] o = new Object[] {permissions[i], grantResults[i] == 0};
            processBA.raiseEventFromDifferentThread(null,null, 0, "activity_permissionresult", true, o);
        }
            
    }

public anywheresoftware.b4a.keywords.Common __c = null;
public b4a.example3.keyvaluestore _kvs = null;
public anywheresoftware.b4a.objects.RuntimePermissions _rp = null;
public static String _shared = "";
public anywheresoftware.b4a.sql.SQL _sql1 = null;
public anywheresoftware.b4a.sql.SQL.CursorWrapper _cursor2 = null;
public anywheresoftware.b4a.sql.SQL.CursorWrapper _cursorsetting = null;
public ice.zxing.b4aZXingLib _zx = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbltopic = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imgicon1 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imgicon2 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imgicon3 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblicon1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblicon2 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblicon3 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblspline1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblspline2 = null;
public pandav.io.customlistview _clv1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbldisplayname = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbluid = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imgavatar = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbltitle = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblbalance = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblfooter = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbldate2 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbldot1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbldate1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbldesc2 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblstatus2 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbldot2 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblstatus1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblgateway = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbldot3 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbldesc1 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imgstatus = null;
public anywheresoftware.b4a.objects.LabelWrapper _label1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label2 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label3 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label4 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label5 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label6 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label7 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label8 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label9 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label10 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imageview1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label11 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label12 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label13 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label14 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label15 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label16 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label17 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label18 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label19 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label20 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imageview2 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label21 = null;
public pandav.io.main _main = null;
public pandav.io.starter _starter = null;
public pandav.io.qrmd _qrmd = null;

public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public static String  _activity_create(boolean _firsttime) throws Exception{
 //BA.debugLineNum = 75;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 77;BA.debugLine="Activity.LoadLayout(\"HomeLy\")";
mostCurrent._activity.LoadLayout("HomeLy",mostCurrent.activityBA);
 //BA.debugLineNum = 79;BA.debugLine="shared = rp.GetSafeDirDefaultExternal(\"\")";
mostCurrent._shared = mostCurrent._rp.GetSafeDirDefaultExternal("");
 //BA.debugLineNum = 80;BA.debugLine="kvs.Initialize(shared, \"Userdatastore\")";
mostCurrent._kvs._initialize(processBA,mostCurrent._shared,"Userdatastore");
 //BA.debugLineNum = 82;BA.debugLine="If File.Exists(File.DirDefaultExternal ,\"db.db\")";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirDefaultExternal(),"db.db")==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 83;BA.debugLine="File.Copy(File.DirAssets,\"db.db\",File.DirDefault";
anywheresoftware.b4a.keywords.Common.File.Copy(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"db.db",anywheresoftware.b4a.keywords.Common.File.getDirDefaultExternal(),"db.db");
 };
 //BA.debugLineNum = 86;BA.debugLine="If SQL1.IsInitialized = False Then";
if (mostCurrent._sql1.IsInitialized()==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 87;BA.debugLine="SQL1.Initialize(File.DirDefaultExternal, \"db.db\"";
mostCurrent._sql1.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirDefaultExternal(),"db.db",anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 90;BA.debugLine="If kvs.ContainsKey(\"CurrLanguage\") = False Then";
if (mostCurrent._kvs._containskey("CurrLanguage")==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 91;BA.debugLine="kvs.Put(\"CurrLanguage\",\"English\")";
mostCurrent._kvs._put("CurrLanguage",(Object)("English"));
 };
 //BA.debugLineNum = 97;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
String _str1 = "";
String _str2 = "";
 //BA.debugLineNum = 189;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
 //BA.debugLineNum = 191;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
 //BA.debugLineNum = 193;BA.debugLine="Dim str1 As String";
_str1 = "";
 //BA.debugLineNum = 194;BA.debugLine="Dim str2 As String";
_str2 = "";
 //BA.debugLineNum = 196;BA.debugLine="Select Case \"English\" 'kvs.GetSimple(\"CurrLangua";
switch (BA.switchObjectToInt("English","中文","English")) {
case 0: {
 //BA.debugLineNum = 198;BA.debugLine="str1 = \"确定要离开吗?\"";
_str1 = "确定要离开吗?";
 //BA.debugLineNum = 199;BA.debugLine="str2 = \"温馨提醒\"";
_str2 = "温馨提醒";
 break; }
case 1: {
 //BA.debugLineNum = 201;BA.debugLine="str1 = \"Are You Sure Want to Exit?\"";
_str1 = "Are You Sure Want to Exit?";
 //BA.debugLineNum = 202;BA.debugLine="str2 = \"Reminder\"";
_str2 = "Reminder";
 break; }
}
;
 //BA.debugLineNum = 205;BA.debugLine="Select Msgbox2(str1,str2,\"Yes\",\"\",\"No\",Null)";
switch (BA.switchObjectToInt(anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence(_str1),BA.ObjectToCharSequence(_str2),"Yes","","No",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE)) {
case 0: {
 //BA.debugLineNum = 208;BA.debugLine="kvs.Put(\"LEAVE\",\"YES\")";
mostCurrent._kvs._put("LEAVE",(Object)("YES"));
 //BA.debugLineNum = 209;BA.debugLine="kvs.put(\"Logout\",\"NO\")";
mostCurrent._kvs._put("Logout",(Object)("NO"));
 //BA.debugLineNum = 210;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 break; }
default: {
 //BA.debugLineNum = 212;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 break; }
}
;
 };
 //BA.debugLineNum = 216;BA.debugLine="End Sub";
return false;
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 104;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 106;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 100;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 102;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 15;BA.debugLine="Private kvs As KeyValueStore";
mostCurrent._kvs = new b4a.example3.keyvaluestore();
 //BA.debugLineNum = 16;BA.debugLine="Private rp As RuntimePermissions";
mostCurrent._rp = new anywheresoftware.b4a.objects.RuntimePermissions();
 //BA.debugLineNum = 17;BA.debugLine="Private shared As String";
mostCurrent._shared = "";
 //BA.debugLineNum = 18;BA.debugLine="Private SQL1 As SQL";
mostCurrent._sql1 = new anywheresoftware.b4a.sql.SQL();
 //BA.debugLineNum = 19;BA.debugLine="Private cursor2, cursorSetting As Cursor";
mostCurrent._cursor2 = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
mostCurrent._cursorsetting = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
 //BA.debugLineNum = 20;BA.debugLine="Dim zx As JhsIceZxing1";
mostCurrent._zx = new ice.zxing.b4aZXingLib();
 //BA.debugLineNum = 21;BA.debugLine="Private lblTopic As Label";
mostCurrent._lbltopic = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 22;BA.debugLine="Private imgicon1 As ImageView";
mostCurrent._imgicon1 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 23;BA.debugLine="Private imgicon2 As ImageView";
mostCurrent._imgicon2 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 24;BA.debugLine="Private imgicon3 As ImageView";
mostCurrent._imgicon3 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 25;BA.debugLine="Private lblicon1 As Label";
mostCurrent._lblicon1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 26;BA.debugLine="Private lblicon2 As Label";
mostCurrent._lblicon2 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 27;BA.debugLine="Private lblicon3 As Label";
mostCurrent._lblicon3 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 28;BA.debugLine="Private lblSpline1 As Label";
mostCurrent._lblspline1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 29;BA.debugLine="Private lblSpline2 As Label";
mostCurrent._lblspline2 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 30;BA.debugLine="Private clv1 As CustomListView";
mostCurrent._clv1 = new pandav.io.customlistview();
 //BA.debugLineNum = 31;BA.debugLine="Private lblDisplayName As Label";
mostCurrent._lbldisplayname = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 32;BA.debugLine="Private lbluid As Label";
mostCurrent._lbluid = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 33;BA.debugLine="Private imgAvatar As ImageView";
mostCurrent._imgavatar = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 34;BA.debugLine="Private lblTitle As Label";
mostCurrent._lbltitle = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 35;BA.debugLine="Private lblBalance As Label";
mostCurrent._lblbalance = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 36;BA.debugLine="Private lblFooter As Label";
mostCurrent._lblfooter = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 38;BA.debugLine="Private lblDate2 As Label";
mostCurrent._lbldate2 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 39;BA.debugLine="Private lblDot1 As Label";
mostCurrent._lbldot1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 40;BA.debugLine="Private lblDate1 As Label";
mostCurrent._lbldate1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 41;BA.debugLine="Private lblDesc2 As Label";
mostCurrent._lbldesc2 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 42;BA.debugLine="Private lblStatus2 As Label";
mostCurrent._lblstatus2 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 43;BA.debugLine="Private lblDot2 As Label";
mostCurrent._lbldot2 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 44;BA.debugLine="Private lblStatus1 As Label";
mostCurrent._lblstatus1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 45;BA.debugLine="Private lblGateway As Label";
mostCurrent._lblgateway = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 46;BA.debugLine="Private lblDot3 As Label";
mostCurrent._lbldot3 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 47;BA.debugLine="Private lblDesc1 As Label";
mostCurrent._lbldesc1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 48;BA.debugLine="Private imgStatus As ImageView";
mostCurrent._imgstatus = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 50;BA.debugLine="Private Label1 As Label";
mostCurrent._label1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 51;BA.debugLine="Private Label2 As Label";
mostCurrent._label2 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 52;BA.debugLine="Private Label3 As Label";
mostCurrent._label3 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 53;BA.debugLine="Private Label4 As Label";
mostCurrent._label4 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 54;BA.debugLine="Private Label5 As Label";
mostCurrent._label5 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 55;BA.debugLine="Private Label6 As Label";
mostCurrent._label6 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 56;BA.debugLine="Private Label7 As Label";
mostCurrent._label7 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 57;BA.debugLine="Private Label8 As Label";
mostCurrent._label8 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 58;BA.debugLine="Private Label9 As Label";
mostCurrent._label9 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 59;BA.debugLine="Private Label10 As Label";
mostCurrent._label10 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 60;BA.debugLine="Private ImageView1 As ImageView";
mostCurrent._imageview1 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 61;BA.debugLine="Private Label11 As Label";
mostCurrent._label11 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 62;BA.debugLine="Private Label12 As Label";
mostCurrent._label12 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 63;BA.debugLine="Private Label13 As Label";
mostCurrent._label13 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 64;BA.debugLine="Private Label14 As Label";
mostCurrent._label14 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 65;BA.debugLine="Private Label15 As Label";
mostCurrent._label15 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 66;BA.debugLine="Private Label16 As Label";
mostCurrent._label16 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 67;BA.debugLine="Private Label17 As Label";
mostCurrent._label17 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 68;BA.debugLine="Private Label18 As Label";
mostCurrent._label18 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 69;BA.debugLine="Private Label19 As Label";
mostCurrent._label19 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 70;BA.debugLine="Private Label20 As Label";
mostCurrent._label20 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 71;BA.debugLine="Private ImageView2 As ImageView";
mostCurrent._imageview2 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 72;BA.debugLine="Private Label21 As Label";
mostCurrent._label21 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 73;BA.debugLine="End Sub";
return "";
}
public static String  _imgicon1_click() throws Exception{
 //BA.debugLineNum = 117;BA.debugLine="Private Sub imgicon1_Click";
 //BA.debugLineNum = 118;BA.debugLine="zx.isportrait = True";
mostCurrent._zx.isportrait = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 119;BA.debugLine="zx.useFrontCam = False";
mostCurrent._zx.useFrontCam = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 123;BA.debugLine="zx.timeoutDuration = 30";
mostCurrent._zx.timeoutDuration = (int) (30);
 //BA.debugLineNum = 127;BA.debugLine="zx.theViewFinderXfactor = 0.7";
mostCurrent._zx.theViewFinderXfactor = 0.7;
 //BA.debugLineNum = 128;BA.debugLine="zx.theViewFinderYfactor = 0.4";
mostCurrent._zx.theViewFinderYfactor = 0.4;
 //BA.debugLineNum = 130;BA.debugLine="zx.theFrameColor = Colors.Black";
mostCurrent._zx.theFrameColor = anywheresoftware.b4a.keywords.Common.Colors.Black;
 //BA.debugLineNum = 131;BA.debugLine="zx.theLaserColor = Colors.Red";
mostCurrent._zx.theLaserColor = anywheresoftware.b4a.keywords.Common.Colors.Red;
 //BA.debugLineNum = 132;BA.debugLine="zx.theMaskColor = Colors.Black";
mostCurrent._zx.theMaskColor = anywheresoftware.b4a.keywords.Common.Colors.Black;
 //BA.debugLineNum = 133;BA.debugLine="zx.theResultColor = Colors.Black";
mostCurrent._zx.theResultColor = anywheresoftware.b4a.keywords.Common.Colors.Black;
 //BA.debugLineNum = 134;BA.debugLine="zx.theResultPointColor = Colors.White";
mostCurrent._zx.theResultPointColor = anywheresoftware.b4a.keywords.Common.Colors.White;
 //BA.debugLineNum = 149;BA.debugLine="zx.BeginScan(\"myzx\")";
mostCurrent._zx.BeginScan(mostCurrent.activityBA,"myzx");
 //BA.debugLineNum = 150;BA.debugLine="End Sub";
return "";
}
public static String  _imgstatus_click() throws Exception{
 //BA.debugLineNum = 113;BA.debugLine="Private Sub imgStatus_Click";
 //BA.debugLineNum = 114;BA.debugLine="StartActivity(\"QRMd\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("QRMd"));
 //BA.debugLineNum = 115;BA.debugLine="End Sub";
return "";
}
public static String  _lblicon1_click() throws Exception{
 //BA.debugLineNum = 152;BA.debugLine="Private Sub lblicon1_Click";
 //BA.debugLineNum = 153;BA.debugLine="zx.isportrait = True";
mostCurrent._zx.isportrait = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 154;BA.debugLine="zx.useFrontCam = False";
mostCurrent._zx.useFrontCam = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 161;BA.debugLine="zx.theViewFinderXfactor = 0.7";
mostCurrent._zx.theViewFinderXfactor = 0.7;
 //BA.debugLineNum = 162;BA.debugLine="zx.theViewFinderYfactor = 0.4";
mostCurrent._zx.theViewFinderYfactor = 0.4;
 //BA.debugLineNum = 164;BA.debugLine="zx.theFrameColor = Colors.Black";
mostCurrent._zx.theFrameColor = anywheresoftware.b4a.keywords.Common.Colors.Black;
 //BA.debugLineNum = 165;BA.debugLine="zx.theLaserColor = Colors.Red";
mostCurrent._zx.theLaserColor = anywheresoftware.b4a.keywords.Common.Colors.Red;
 //BA.debugLineNum = 166;BA.debugLine="zx.theMaskColor = Colors.Black";
mostCurrent._zx.theMaskColor = anywheresoftware.b4a.keywords.Common.Colors.Black;
 //BA.debugLineNum = 167;BA.debugLine="zx.theResultColor = Colors.Black";
mostCurrent._zx.theResultColor = anywheresoftware.b4a.keywords.Common.Colors.Black;
 //BA.debugLineNum = 168;BA.debugLine="zx.theResultPointColor = Colors.White";
mostCurrent._zx.theResultPointColor = anywheresoftware.b4a.keywords.Common.Colors.White;
 //BA.debugLineNum = 169;BA.debugLine="zx.BeginScan(\"myzx\")";
mostCurrent._zx.BeginScan(mostCurrent.activityBA,"myzx");
 //BA.debugLineNum = 170;BA.debugLine="End Sub";
return "";
}
public static String  _lblstatus2_click() throws Exception{
 //BA.debugLineNum = 109;BA.debugLine="Private Sub lblStatus2_Click";
 //BA.debugLineNum = 110;BA.debugLine="StartActivity(\"QRMd\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("QRMd"));
 //BA.debugLineNum = 111;BA.debugLine="End Sub";
return "";
}
public static String  _myzx_result(String _atype,String _value,anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _image) throws Exception{
 //BA.debugLineNum = 172;BA.debugLine="Sub myzx_result(atype As String, Value As String,";
 //BA.debugLineNum = 174;BA.debugLine="Log(\"type:\" & atype &  \"Value:\" & Value)";
anywheresoftware.b4a.keywords.Common.LogImpl("41572866","type:"+_atype+"Value:"+_value,0);
 //BA.debugLineNum = 175;BA.debugLine="Msgbox(Value,\"NFT Access: \" & \"INVALID\")";
anywheresoftware.b4a.keywords.Common.Msgbox(BA.ObjectToCharSequence(_value),BA.ObjectToCharSequence("NFT Access: "+"INVALID"),mostCurrent.activityBA);
 //BA.debugLineNum = 177;BA.debugLine="End Sub";
return "";
}
public static String  _myzx_timedout(boolean _timedout) throws Exception{
 //BA.debugLineNum = 179;BA.debugLine="Sub myzx_timedout(timedOut As Boolean)";
 //BA.debugLineNum = 180;BA.debugLine="Log(\"timedOut \" & timedOut)";
anywheresoftware.b4a.keywords.Common.LogImpl("41638401","timedOut "+BA.ObjectToString(_timedout),0);
 //BA.debugLineNum = 182;BA.debugLine="End Sub";
return "";
}
public static String  _myzx_usercancelled(boolean _usercancelled) throws Exception{
 //BA.debugLineNum = 184;BA.debugLine="Sub myzx_usercancelled(userCancelled As Boolean)";
 //BA.debugLineNum = 185;BA.debugLine="Log(\"userCancelled \" & userCancelled)";
anywheresoftware.b4a.keywords.Common.LogImpl("41703937","userCancelled "+BA.ObjectToString(_usercancelled),0);
 //BA.debugLineNum = 187;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return "";
}
}
