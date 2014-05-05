package com.example.finalproject;

import com.parse.ParseException;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class createNewEvent extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_new_event);
	}
	
	public void onButtonClick(View v) throws ParseException
	{
		switch(v.getId())
		{
		case R.id.button_saveNewEvent:
			EditText editDate = (EditText)findViewById(R.id.inputNewEvent);
			varApplication va = (varApplication)getApplicationContext();
			String dbId = va.getId();
			DBUtil.addEvent(dbId, editDate.getText().toString());
		default:
		}
	}
}
