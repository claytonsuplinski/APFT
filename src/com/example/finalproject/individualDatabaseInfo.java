package com.example.finalproject;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class individualDatabaseInfo extends Activity implements View.OnClickListener{
	private String dbId = ""; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_individual_database_info);
		
		Bundle extras = getIntent().getExtras();
		String id = extras.getString("id");
		dbId = id;
		
		ArrayList<String> info = DBUtil.getDbInfo(id);
		
		int i=0;

		TableLayout events = (TableLayout)findViewById(R.id.tableLayout1);
		events.setStretchAllColumns(true);
		events.bringToFront();

		TableRow tr =  new TableRow(this);
		TextView c1 = new TextView(this);
		c1.setId(i);
		i++;
		c1.setText("Database Name " + info.get(0));
		c1.setTextSize(24);
		c1.setTextColor(Color.WHITE);
		c1.setGravity(Gravity.CENTER);
		tr.setBackgroundResource(R.drawable.gradient);
		tr.setGravity(Gravity.CENTER);
		tr.addView(c1);
		events.addView(tr);
		
		tr =  new TableRow(this);
		c1 = new TextView(this);
		c1.setText("\n");
		c1.setTextSize(18);
		tr.setGravity(Gravity.CENTER);
		tr.addView(c1);
		events.addView(tr);

		tr =  new TableRow(this);
		c1 = new TextView(this);
		c1.setId(i);
		i++;
		c1.setText("Database ID: " + info.get(1));
		c1.setTextSize(18);
		c1.setTextColor(Color.WHITE);
		c1.setGravity(Gravity.CENTER);
		tr.setBackgroundResource(R.drawable.gradient);
		tr.setGravity(Gravity.CENTER);
		tr.addView(c1);
		events.addView(tr);
		
		tr =  new TableRow(this);
		c1 = new TextView(this);
		c1.setText("\n");
		c1.setTextSize(18);
		tr.setGravity(Gravity.CENTER);
		tr.addView(c1);
		events.addView(tr);

		tr =  new TableRow(this);
		c1 = new TextView(this);
		c1.setId(i);
		i++;
		c1.setOnClickListener(this);
		c1.setText("User Code: " + info.get(3));
		c1.setTextSize(22);
		c1.setTextColor(Color.WHITE);
		c1.setGravity(Gravity.CENTER);
		tr.setBackgroundResource(R.drawable.gradient);
		tr.setGravity(Gravity.CENTER);
		tr.addView(c1);
		events.addView(tr);

		tr =  new TableRow(this);
		c1 = new TextView(this);
		c1.setId(i);
		i++;
		c1.setOnClickListener(this);
		c1.setText("Grader Code: " + info.get(4));
		c1.setTextSize(22);
		c1.setTextColor(Color.WHITE);
		c1.setGravity(Gravity.CENTER);
		tr.setBackgroundResource(R.drawable.gradient);
		tr.setGravity(Gravity.CENTER);
		tr.addView(c1);
		events.addView(tr);

		tr =  new TableRow(this);
		c1 = new TextView(this);
		c1.setId(i);
		i++;
		c1.setOnClickListener(this);
		c1.setText("Admin Code: " + info.get(2));
		c1.setTextSize(22);
		c1.setTextColor(Color.WHITE);
		c1.setGravity(Gravity.CENTER);
		tr.setBackgroundResource(R.drawable.gradient);
		tr.setGravity(Gravity.CENTER);
		tr.addView(c1);
		events.addView(tr);
		
		tr =  new TableRow(this);
		c1 = new TextView(this);
		c1.setText("\n");
		c1.setTextSize(18);
		tr.setGravity(Gravity.CENTER);
		tr.addView(c1);
		events.addView(tr);

		tr =  new TableRow(this);
		c1 = new TextView(this);
		c1.setId(i);
		i++;
		c1.setOnClickListener(this);
		c1.setText("Delete Database");
		c1.setTextSize(22);
		c1.setTextColor(Color.WHITE);
		c1.setGravity(Gravity.CENTER);
		tr.setBackgroundResource(R.drawable.gradient);
		tr.setGravity(Gravity.CENTER);
		tr.addView(c1);
		events.addView(tr);

	}

	@Override
	public void onClick(View arg0) {
		if(arg0.getId() == 5){//delete TODO//clarify user wants to delete?
			DBUtil.deleteDB(dbId);
		}
	}

}
