package com.example.topspy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class StartScreen extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.start_screen);
        Thread timer = new Thread(){
			
			public void run(){
				
				try
				{
					
					sleep(5000);
				
				}
				
				catch(InterruptedException e)
				{
					e.printStackTrace();
				}
				
				finally{
					Intent start_activity=new Intent("android.intent.action.MENU");
					startActivity(start_activity);
					
				}
			
		
			
		
		
		}
		
		
	};
	
	timer.start();
		
	}
	
	
	
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();		
		finish();
	}
	

}
