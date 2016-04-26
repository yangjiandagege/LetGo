package com.yj.letgo;

import android.app.Application;
import android.content.Context;

public class LetgoApp extends Application{
    private static Context mAppContext;
    
    @Override
    public void onCreate(){
        super.onCreate();
        mAppContext = this.getApplicationContext();
    }
    
    public static Context getAppContext() {
    	return mAppContext;
    }
}
