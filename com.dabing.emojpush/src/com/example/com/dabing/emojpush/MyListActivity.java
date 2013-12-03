package com.example.com.dabing.emojpush;

import java.util.ArrayList;
import java.util.List;

import com.dabing.ads.AppConnect;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;


public class MyListActivity extends ListActivity {
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		AppConnect.getInstance(MyListActivity.this).close();
	}

	ListView listView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		listView = getListView();
		Bind();
		InitAD();
	}
	
	public void Bind(){
		String[] names = {"MyPushEmojActivity"
						  
						};
		
		final Class<?>[] classes = {MyPushEmojActivity.class
									
									};
		List<String> nameArray = new ArrayList<String>();
		for(String a : names){
			nameArray.add(a);
		}
		ListAdapter adapter= new ArrayAdapter<String>(MyListActivity.this, android.R.layout.simple_list_item_1, nameArray);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MyListActivity.this,classes[position]);
				startActivity(intent);
				
			}
		});
	}
	
	protected void InitAD(){
		AppConnect.getInstance("4bedbf302e55d6a0e8833404f073e31c", "QQ", MyListActivity.this);
		AppConnect.getInstance(MyListActivity.this).setAdViewClassName("com.dabing.emoj.advertise.WAPS_ADView");
		// 禁用错误报告
		AppConnect.getInstance(MyListActivity.this).setCrashReport(false);
		
		//初始化广告数据
		AppConnect.getInstance(MyListActivity.this).initAdInfo();
	}
}
