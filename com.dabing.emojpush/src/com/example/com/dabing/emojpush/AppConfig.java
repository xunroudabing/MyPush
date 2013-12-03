package com.example.com.dabing.emojpush;

import java.io.File;

import android.os.Environment;

public class AppConfig {
	static final String ROOT = "EmojPush";
	static final String TAG = AppConfig.class.getSimpleName();
	
	public static String getRoot(){
		return Environment.getExternalStorageDirectory() + File.separator + ROOT + File.separator;
	}
}
