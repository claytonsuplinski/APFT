package com.example.finalproject;

import com.parse.ParseException;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class inputNewCadet extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_input_new_cadet);
	}
	
	public void onButtonClick(View v) throws ParseException
	{
		switch(v.getId())
		{
			case R.id.button_saveCadet:
			System.out.println("AM I EVEN CALLED?");
			EditText editF = (EditText)findViewById(R.id.inputFirstName);
			EditText editL = (EditText)findViewById(R.id.inputLastName);
			EditText editG = (EditText)findViewById(R.id.inputGender);
			EditText editD = (EditText)findViewById(R.id.inputDOB);
			varApplication va = (varApplication)getApplicationContext();
			String id = va.getId();

			boolean success = DBUtil.addCdt(id, editL.getText().toString() + ", " + editF.getText().toString(), 
					editD.getText().toString(), editG.getText().toString());
			
			if(success){
				Toast.makeText(this, "Cadet successfully added.", Toast.LENGTH_SHORT).show();
			}
			else{
				Toast.makeText(this, "Failed to add cadet.", Toast.LENGTH_SHORT).show();
			}
			

			default:
		}
	}
}
