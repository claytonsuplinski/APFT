package com.example.finalproject;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;

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
			boolean success = DBUtil.addEvent(dbId, editDate.getText().toString());
			if(success){
				Toast.makeText(this, "New event successfully created.", Toast.LENGTH_SHORT).show();
			}
			else{
				Toast.makeText(this, "Failed to create new event.", Toast.LENGTH_SHORT).show();
			}
		default:
		}
	}
}
