package com.example.finalproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class createNewDatabase extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_new_database);
	}
	
	public void onButtonClick(View v)
	{
		Intent i;
		switch(v.getId())
		{
		case R.id.button_createDatabase:
			EditText dbName = (EditText)findViewById(R.id.databaseName);
			EditText admin = (EditText)findViewById(R.id.databaseAdmin);
			EditText grader = (EditText)findViewById(R.id.databaseGrader);
			EditText user = (EditText)findViewById(R.id.databaseUser);
			DBUtil.makeDB(dbName.getText().toString(), admin.getText().toString(), grader.getText().toString(), user.getText().toString());
			
			break;

		default:
		}
	}

}
