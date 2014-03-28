package com.example.finalproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void onButtonClick(View v)
	{

		Intent i;
		switch(v.getId())
		{
		case R.id.button_gradeAPFT:
			i = new Intent(this, gradeApftActivity.class);
			startActivity(i);
			Toast.makeText(this, "Grade APFT button selected.", Toast.LENGTH_SHORT).show();
			break;
		case R.id.button_quickCalc:
			i = new Intent(this, apftCalculator.class);
			startActivity(i);
			Toast.makeText(this, "Quick Calc button selected.", Toast.LENGTH_SHORT).show();
			break;
		case R.id.button_dbOps:
			i = new Intent(this, databaseOps.class);
			startActivity(i);
			Toast.makeText(this, "Database Ops button selected.", Toast.LENGTH_SHORT).show();
			break;
		case R.id.button_leaderboard:
			Toast.makeText(this, "Leaderboard button selected.", Toast.LENGTH_SHORT).show();
			break;

		default:
		}
	}


}
