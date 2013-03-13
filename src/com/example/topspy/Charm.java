package com.example.topspy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Charm  extends Activity{
	Button btnNext2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.charm);
		btnNext2=(Button)findViewById(R.id.btnNext2);
		btnNext2.setOnClickListener(new Button.OnClickListener() {
		   public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
			    Intent start_test=new Intent("android.intent.action.JUDO");
				startActivity(start_test);
			   
			   
			   
			}
		});
		
	}
	
	
	
	
	

}
