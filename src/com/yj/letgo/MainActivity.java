package com.yj.letgo;

import android.graphics.Color;

public class MainActivity extends BaseActivity{
	public BtPerform[] initButtons(){
		BtPerform[] btPerform = new BtPerform[BT_NUM];
		int i = -1;
		btPerform[++i] = new BtPerform("Common test", i, Color.RED, MainActivity.this, com.yj.letgo.common.MainActivity.class);
		btPerform[++i] = new BtPerform("AIDL", i, Color.GRAY, MainActivity.this, com.yj.letgo.aidl.ClientActivity.class);
		btPerform[++i] = new BtPerform("Binder pool", i, Color.GRAY, MainActivity.this, com.yj.letgo.binderpool.BinderPoolActivity.class);
		btPerform[++i] = new BtPerform("Bitmap", i, Color.CYAN, MainActivity.this, com.yj.letgo.bitmap.MainActivity.class);
		btPerform[++i] = new BtPerform("BLE central", i, Color.MAGENTA, MainActivity.this, com.yj.letgo.ble.central.CentralActivity.class);
		btPerform[++i] = new BtPerform("BLE peripheral", i, Color.MAGENTA, MainActivity.this, com.yj.letgo.ble.peripheral.PeripheralActivity.class);
		btPerform[++i] = new BtPerform("ViewPager demo", i, Color.CYAN, MainActivity.this, com.yj.letgo.viewpager.MainActivity.class);
		btPerform[++i] = new BtPerform("Content observer", i, Color.GREEN, MainActivity.this, com.yj.letgo.contentobserver.MainActivity.class);
		btPerform[++i] = new BtPerform("Content provider", i, Color.GREEN, MainActivity.this, com.yj.letgo.contentprovider.TeacherActivity.class);
		btPerform[++i] = new BtPerform("Location", i, Color.CYAN, MainActivity.this, com.yj.letgo.location.LocationActivity.class);
		btPerform[++i] = new BtPerform("Touch test", i, Color.CYAN, MainActivity.this, com.yj.letgo.touch.MainActivity.class);
		btPerform[++i] = new BtPerform("Sensors demo", i, Color.CYAN, MainActivity.this, com.yj.letgo.sensors.ListViewActivity.class);
		btPerform[++i] = new BtPerform("QQ login", i, Color.CYAN, MainActivity.this, com.yj.letgo.qqauth.MainActivity.class);
		btPerform[++i] = new BtPerform("Loop advertisement", i, Color.CYAN, MainActivity.this, com.yj.letgo.loopad.LoopAdActivity.class);
		btPerform[++i] = new BtPerform("Asynctask", i, Color.CYAN, MainActivity.this, com.yj.letgo.asynctask.AsyncTaskActivity.class);
		btPerform[++i] = new BtPerform("DIY ViewGroup : My ViewPager", i, Color.YELLOW, MainActivity.this, com.yj.letgo.diyviews.slidingconflict.MainActivity.class);
		btPerform[++i] = new BtPerform("DIY ViewGroup : SlideMenu", i, Color.YELLOW, MainActivity.this, com.yj.letgo.diyviews.slidemenu.SlideMenuActivity.class);
		btPerform[++i] = new BtPerform("Tab layout", i, Color.CYAN, MainActivity.this, com.yj.letgo.tablayout.MainActivity.class);
		btPerform[++i] = new BtPerform("end", i, Color.BLACK, null);
		return btPerform;
	}
}