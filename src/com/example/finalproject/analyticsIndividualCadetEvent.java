package com.example.finalproject;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class analyticsIndividualCadetEvent extends Activity implements View.OnClickListener{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_analytics_individual_cadet_event);
		
		int numEvents = 25;
		int i=0;

		TableLayout events = (TableLayout)findViewById(R.id.tableLayout1);
		events.setStretchAllColumns(true);
		events.bringToFront();
		
		TableRow tr =  new TableRow(this);
		TextView c1 = new TextView(this);
		c1.setId(i);
		i++;
		c1.setOnClickListener(this);
		c1.setText("Cadet Name");
		c1.setTextSize(24);
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
		c1.setText("Raw Score");
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
		c1.setText("Pushups: 36");
		c1.setTextSize(18);
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
		c1.setText("Situps: 75");
		c1.setTextSize(18);
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
		c1.setText("Run: 13:10");
		c1.setTextSize(18);
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
		c1.setText("APFT Score");
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
		c1.setText("Pushup Score: 87");
		c1.setTextSize(18);
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
		c1.setText("Situp Score: 65");
		c1.setTextSize(18);
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
		c1.setText("Run Score: 88");
		c1.setTextSize(18);
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
		c1.setText("Overall Score: 230");
		c1.setTextSize(20);
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
		c1.setText("Lap Times");
		c1.setTextSize(24);
		c1.setTextColor(Color.WHITE);
		c1.setGravity(Gravity.CENTER);
		tr.setBackgroundResource(R.drawable.gradient);
		tr.setGravity(Gravity.CENTER);
		tr.addView(c1);
		events.addView(tr);
		
		int numLaps = 14;

		for(int j = 0; j < numLaps; j++){
			tr =  new TableRow(this);
			c1 = new TextView(this);
			c1.setId(i+j);
			c1.setOnClickListener(this);
			c1.setText("Lap " + (j+1) + ": 0:57");
			c1.setTextSize(18);
			c1.setTextColor(Color.WHITE);
			c1.setGravity(Gravity.CENTER);
			tr.setBackgroundResource(R.drawable.gradient);
			tr.setGravity(Gravity.CENTER);
			tr.addView(c1);
			events.addView(tr);
		}
	}
	
	@Override
	public void onClick(View arg0) {
		
	}
}
