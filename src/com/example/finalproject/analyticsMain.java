package com.example.finalproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class analyticsMain extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_analytics_main);
	}
	
	public void onButtonClick(View v)
	{

		Intent i;
		switch(v.getId())
		{
		case R.id.button_viewIndividual:
			i = new Intent(this, analyticsSelectCadet.class);
			startActivity(i);
			break;
		case R.id.button_viewEvent:
			i = new Intent(this, analyticsSelectEvent.class);
			startActivity(i);
			break;
		}
	}
	
}
