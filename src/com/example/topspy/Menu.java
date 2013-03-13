package com.example.topspy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends Activity{

	Button btnStart;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);
		btnStart=(Button)findViewById(R.id.btnStart);
		btnStart.setOnClickListener(new Button.OnClickListener() {
		   public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
			    Intent start_test=new Intent("android.intent.action.STRESS");
				startActivity(start_test);
			   
			   
			   
			}
		});
		
	}

}
