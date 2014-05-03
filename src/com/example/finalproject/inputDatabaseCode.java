package com.example.finalproject;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class inputDatabaseCode extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_input_database_code);
		
		//Retrieve current db name
		System.out.println("get here 1");
		varApplication va = (varApplication)getApplicationContext();
	    String dbName = va.getName();
		System.out.println("get here 2: " + dbName);
		TableLayout events = (TableLayout)findViewById(R.id.tableLayout1);
		events.setStretchAllColumns(true);
		events.bringToFront();

		TableRow tr =  new TableRow(this);
		TextView c1 = new TextView(this);
		c1.setId(1);
		c1.setText("Current Database : " + dbName);
		c1.setTextSize(20);
		c1.setTextColor(Color.WHITE);
		c1.setGravity(Gravity.CENTER);
		tr.setBackgroundResource(R.drawable.gradient);
		tr.setGravity(Gravity.CENTER);
		tr.addView(c1);
		events.addView(tr);
	}
	
	public void onButtonClick(View v)
	{
		Intent i;
		switch(v.getId())
		{
			case R.id.button_link:
				EditText editId = (EditText)findViewById(R.id.databaseID);
				EditText editCode = (EditText)findViewById(R.id.databaseCode);
				String id = editId.getText().toString();
				String code = editCode.getText().toString();
				System.out.println("get here 3");
				String auth = DBUtil.linkDb(id, code);
				String name = DBUtil.getDbName(id);
				System.out.println("get here 4:" + auth + " : " + id + " : " + code);
				if(auth.equalsIgnoreCase("admin")){
					 varApplication va = (varApplication)getApplicationContext();
				     va.setAuth("admin");
				     va.setId(id);
				     va.setName(name);
				}else if(auth.equalsIgnoreCase("grader")){
					 varApplication va = (varApplication)getApplicationContext();
				     va.setAuth("grader");
				     va.setId(id);
				     va.setName(name);
				}else if(auth.equalsIgnoreCase("user")){
					 varApplication va = (varApplication)getApplicationContext();
				     va.setAuth("user");
				     va.setId(id);
				     va.setName(name);
				}else{
					 varApplication va = (varApplication)getApplicationContext();
				     va.setAuth("null");
				     va.setId("null");
				     va.setName("null");
				}
				System.out.println("get here 5");
			break;

		default:
		}
	}

}
