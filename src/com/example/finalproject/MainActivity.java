package com.example.finalproject;

import com.parse.Parse;

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
		Parse.initialize(this, DBUtil.appId, DBUtil.clientKey);
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
		varApplication va = (varApplication)getApplicationContext();
		String dbId = va.getAuth();
		switch(v.getId())
		{
		case R.id.button_gradeAPFT:


			if(dbId == "admin" || dbId == "grader"){
				i = new Intent(this, gradeApftActivity.class);
				startActivity(i);
			}
			else if(dbId == "user"){
				Toast.makeText(this, "Grading permissions denied.", Toast.LENGTH_SHORT).show();
			}
			else{
				Toast.makeText(this, "Not connected to database.", Toast.LENGTH_SHORT).show();
			}
			break;
		case R.id.button_quickCalc:
			i = new Intent(this, apftCalculator.class);
			startActivity(i);
			break;
		case R.id.button_dbOps:
			i = new Intent(this, databaseOps.class);
			startActivity(i);
			break;
		case R.id.button_leaderboard:
			if(dbId == "admin" || dbId == "grader" || dbId == "user"){
				i = new Intent(this, leaderboardSelectEvent.class);
				startActivity(i);
			}
			else{
				Toast.makeText(this, "Not connected to database.", Toast.LENGTH_SHORT).show();
			}
			break;
		case R.id.button_analytics:
			if(dbId == "admin" || dbId == "grader" || dbId == "user"){
				i = new Intent(this, analyticsMain.class);
				startActivity(i);
			}
			else{
				Toast.makeText(this, "Not connected to database.", Toast.LENGTH_SHORT).show();
			}
			break;

		default:
		}
	}


}
