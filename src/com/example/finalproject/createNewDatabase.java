package com.example.finalproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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
		/*case R.id.button_gradeAPFT:
			i = new Intent(this, gradeApftActivity.class);
			startActivity(i);
			break;
*/
		default:
		}
	}

}
