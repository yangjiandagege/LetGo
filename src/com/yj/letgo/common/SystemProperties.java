package com.yj.letgo.common;

import com.yj.letgo.LetgoApp;
import android.app.Activity;
import android.content.SharedPreferences;

public class SystemProperties{
	public String get(String name,String defValue){
		SharedPreferences sharedPreferences = LetgoApp.getAppContext().getSharedPreferences("prop",
				Activity.MODE_PRIVATE);
		return sharedPreferences.getString(name, defValue);
	}
	
	public void set(String name,String value){
		SharedPreferences mySharedPreferences = LetgoApp.getAppContext().getSharedPreferences("prop",
				Activity.MODE_PRIVATE);
		SharedPreferences.Editor editor = mySharedPreferences.edit();
		editor.putString(name, value);
		editor.commit();
	}
}