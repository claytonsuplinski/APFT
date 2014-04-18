package com.example.finalproject;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class inputEventScoreActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_input_event_score);
		
		TableLayout cadets = (TableLayout)findViewById(R.id.tableLayout1);
		cadets.setStretchAllColumns(true);
		cadets.bringToFront();
		
		TableRow tr =  new TableRow(this);
		TextView c1 = new TextView(this);
		c1.setId(0);
		c1.setText("Input Pushups/Situps");
		c1.setTextSize(24);
		c1.setTextColor(Color.WHITE);
		c1.setGravity(Gravity.CENTER);
		tr.setBackgroundResource(R.drawable.gradient);
		tr.setGravity(Gravity.CENTER);
		tr.addView(c1);
		cadets.addView(tr);
		
		tr =  new TableRow(this);
		c1 = new TextView(this);
		c1.setId(1);
		c1.setText("Solider Name");
		c1.setTextSize(20);
		c1.setTextColor(Color.WHITE);
		c1.setGravity(Gravity.CENTER);
		tr.setBackgroundResource(R.drawable.gradient);
		tr.setGravity(Gravity.CENTER);
		tr.addView(c1);
		cadets.addView(tr);
		
		tr =  new TableRow(this);
		c1 = new TextView(this);
		c1.setId(1);
		c1.setText("Age: ");
		c1.setTextSize(18);
		c1.setTextColor(Color.WHITE);
		c1.setGravity(Gravity.CENTER);
		tr.setBackgroundResource(R.drawable.gradient);
		tr.setGravity(Gravity.CENTER);
		tr.addView(c1);
		cadets.addView(tr);
		
		tr =  new TableRow(this);
		c1 = new TextView(this);
		c1.setId(1);
		c1.setText("Gender: ");
		c1.setTextSize(18);
		c1.setTextColor(Color.WHITE);
		c1.setGravity(Gravity.CENTER);
		tr.setBackgroundResource(R.drawable.gradient);
		tr.setGravity(Gravity.CENTER);
		tr.addView(c1);
		cadets.addView(tr);
		
		tr =  new TableRow(this);
		c1 = new TextView(this);
		c1.setId(1);
		c1.setText("Min: ");
		c1.setTextSize(18);
		c1.setTextColor(Color.WHITE);
		c1.setGravity(Gravity.CENTER);
		tr.setBackgroundResource(R.drawable.gradient);
		tr.setGravity(Gravity.CENTER);
		tr.addView(c1);
		cadets.addView(tr);
		
		tr =  new TableRow(this);
		c1 = new TextView(this);
		c1.setId(1);
		c1.setText("Max: ");
		c1.setTextSize(18);
		c1.setTextColor(Color.WHITE);
		c1.setGravity(Gravity.CENTER);
		tr.setBackgroundResource(R.drawable.gradient);
		tr.setGravity(Gravity.CENTER);
		tr.addView(c1);
		cadets.addView(tr);
		
	}
	
}
