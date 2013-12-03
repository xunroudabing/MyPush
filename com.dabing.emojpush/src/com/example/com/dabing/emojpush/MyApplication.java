package com.example.com.dabing.emojpush;

import java.io.File;

import android.app.Application;

public class MyApplication extends Application {

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		InitFolder();
	}

	@Override
	public void onTerminate() {
		// TODO Auto-generated method stub
		super.onTerminate();
	}
	
	protected void InitFolder(){
		File file = new File(AppConfig.getRoot());
		if(!file.exists()){
			file.mkdirs();
		}
	}
}
