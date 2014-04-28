package com.example.finalproject;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class individualDatabaseInfo extends Activity implements View.OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_individual_database_info);

		int i=0;

		TableLayout events = (TableLayout)findViewById(R.id.tableLayout1);
		events.setStretchAllColumns(true);
		events.bringToFront();

		TableRow tr =  new TableRow(this);
		TextView c1 = new TextView(this);
		c1.setId(i);
		i++;
		c1.setText("Database Name");
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
		c1.setText("Database ID: ");
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
		c1.setText("Copy User Code");
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
		c1.setText("Copy Grader Code");
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
		c1.setText("Copy Admin Code");
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

	}

}
