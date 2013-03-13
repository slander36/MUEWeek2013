package com.example.topspy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Stress extends Activity{

	Button btnNext;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.stress);
		btnNext=(Button)findViewById(R.id.btnNext);
		btnNext.setOnClickListener(new Button.OnClickListener() {
		   public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
			    Intent start_test=new Intent("android.intent.action.CHARM");
				startActivity(start_test);
			   
			   
			   
			}
		});
		
		
		
		
	}
	
	
	
	

}
