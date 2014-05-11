package com.example.finalproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class databaseOps extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_database);
	}

	public void onButtonClick(View v)
	{

		Intent i;
		varApplication va = (varApplication)getApplicationContext();
		String dbId = va.getAuth();
		switch(v.getId())
		{
		case R.id.button_linkDB:
			i = new Intent(this, linkToDatabase.class);
			startActivity(i);
			break;
		case R.id.button_inputCadets:
			if(dbId == "admin"){
				i = new Intent(this, inputEditCadet.class);
				startActivity(i);
			}
			else if(dbId == "grader" || dbId == "user"){
				Toast.makeText(this, "Access denied.", Toast.LENGTH_SHORT).show();
			}
			else{
				Toast.makeText(this, "Not connected to database.", Toast.LENGTH_SHORT).show();
			}
			break;
		case R.id.button_createNewEvent:
			if(dbId == "admin"){
				i = new Intent(this, createNewEvent.class);
				startActivity(i);
			}
			else if(dbId == "grader" || dbId == "user"){
				Toast.makeText(this, "Access denied.", Toast.LENGTH_SHORT).show();
			}
			else{
				Toast.makeText(this, "Not connected to database.", Toast.LENGTH_SHORT).show();
			}
			break;
		default:
		}
	}

}
