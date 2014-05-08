package com.example.finalproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class eventSelectActivity extends Activity {

	String event = "";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_event_select);
		varApplication va = (varApplication)getApplicationContext();
		String dbId = va.getId();
		Bundle extras = getIntent().getExtras();
		event = extras.getString("event");//cdt id
	}
	

	public void onButtonClick(View v)
	{

		Intent i;
		switch(v.getId())
		{
		case R.id.button_pushups:
			i = new Intent(this, cadetSelectActivity.class);
			i.putExtra("pushupsEqualsOne",1);
			i.putExtra("event", event);
			startActivity(i);
			break;
		case R.id.button_situps:
			i = new Intent(this, cadetSelectActivity.class);
			i.putExtra("pushupsEqualsOne",0);
			i.putExtra("event", event);
			startActivity(i);
			break;
		case R.id.button_2milerun:
			i = new Intent(this, lapCounter.class);
			i.putExtra("event", event);
			startActivity(i);
			break;
		default:
		}

		//Remember to bundle an identifier for which event was selected
	}
	
}
