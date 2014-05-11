package com.example.finalproject;

import com.parse.ParseException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class apftCalculator extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calculator);
	}
	public void onButtonClick(View v) throws ParseException
	{
		switch(v.getId())
		{
		case R.id.calc_calculate:
			EditText editAge = (EditText)findViewById(R.id.calc_age);
			EditText editGen = (EditText)findViewById(R.id.calc_gender);
			EditText editPU = (EditText)findViewById(R.id.calc_pushups);
			EditText editSU = (EditText)findViewById(R.id.calc_situps);
			EditText editRU = (EditText)findViewById(R.id.calc_runtime);
			Cadet cdt = new Cadet("joe", Integer.parseInt(editAge.getText().toString()),
					editGen.getText().toString(),
					Integer.parseInt(editPU.getText().toString()),
					Integer.parseInt(editSU.getText().toString()),
					Integer.parseInt(editRU.getText().toString()));

			TextView cal = (TextView)findViewById(R.id.calc_score);
			cal.setText("" + cdt.getScore());

		default:
		}
	}
	
}
