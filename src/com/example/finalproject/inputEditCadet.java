package com.example.finalproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class inputEditCadet extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_input_edit_cadet);
	}
	
	public void onButtonClick(View v)
	{
		Intent i;
		switch(v.getId())
		{
		case R.id.button_inputNewCadet:
			i = new Intent(this, inputNewCadet.class);
			startActivity(i);
			break;
		case R.id.button_editDeleteCadet:
			i = new Intent(this, editDeleteCadetSelect.class);
			startActivity(i);
			break;

		default:
		}
	}

}
