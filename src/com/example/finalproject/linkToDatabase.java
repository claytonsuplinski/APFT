package com.example.finalproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class linkToDatabase extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_link_to_database);
	}
	
	public void onButtonClick(View v)
	{
		Intent i;
		switch(v.getId())
		{
		case R.id.button_inputCode:
			i = new Intent(this, inputDatabaseCode.class);
			startActivity(i);
			break;
		case R.id.button_createNewDatabase:
			i = new Intent(this, createNewDatabase.class);
			startActivity(i);
			break;
		case R.id.button_myDatabases:
			i = new Intent(this, myDatabases.class);
			startActivity(i);
			break;
		case R.id.button_previousCodes:
			i = new Intent(this, previousCodes.class);
			startActivity(i);
			break;
		case R.id.button_copyPreviousCode:
			i = new Intent(this, copyPreviousCodes.class);
			startActivity(i);
			break;

		default:
		}
	}

}
