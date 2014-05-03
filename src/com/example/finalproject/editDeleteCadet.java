package com.example.finalproject;

import java.util.ArrayList;

import com.parse.ParseException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class editDeleteCadet extends Activity {
	
	private String cdtID = "";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_delete_cadet);
		varApplication va = (varApplication)getApplicationContext();
		String dbId = va.getId();
		Bundle extras = getIntent().getExtras();
		String cdtId = extras.getString("id");//cdt id
		cdtID = cdtId;
		ArrayList<ArrayList<String>> cdt = DBUtil.cdtList(dbId);
		
		ArrayList<String> info = DBUtil.getCdtInfo(cdtId);
		
		EditText editL = (EditText)findViewById(R.id.inputLastName);
		EditText editF = (EditText)findViewById(R.id.inputFirstName);
		EditText editD = (EditText)findViewById(R.id.inputDOB);
		EditText editG = (EditText)findViewById(R.id.inputGender);
		
		String[] split = info.get(0).split(",");
		String last = split[0];
		String first = split[1].substring(1);
		
		editL.setText(last);
		editF.setText(first);
		editD.setText(info.get(1));
		editG.setText(info.get(2));
		

	}

	public void onButtonClick(View v) throws ParseException
	{
		switch(v.getId())
		{
			case R.id.button_deleteCadet:
				varApplication va = (varApplication)getApplicationContext();
				String dbId = va.getId();
				DBUtil.deleteCdt(dbId, cdtID);
			case R.id.button_saveCadet:
				EditText editL = (EditText)findViewById(R.id.inputLastName);
				EditText editF = (EditText)findViewById(R.id.inputFirstName);
				EditText editD = (EditText)findViewById(R.id.inputDOB);
				EditText editG = (EditText)findViewById(R.id.inputGender);
				
				String name = editL.getText().toString() + ", " + editF.getText().toString();
				String dob = editD.getText().toString();
				String gen = editG.getText().toString();
				DBUtil.editCdt(cdtID, name, dob, gen);
			default:
		}
	}
}
