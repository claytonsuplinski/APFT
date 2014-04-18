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
		switch(v.getId())
		{
		case R.id.button_linkDB:
			i = new Intent(this, linkToDatabase.class);
			startActivity(i);
			break;
		case R.id.button_inputCadets:
			i = new Intent(this, inputEditCadet.class);
			startActivity(i);
			break;
		case R.id.button_createNewEvent:
			i = new Intent(this, createNewEvent.class);
			startActivity(i);
			break;
		default:
		}
	}

}
