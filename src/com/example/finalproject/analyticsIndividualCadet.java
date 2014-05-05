package com.example.finalproject;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class analyticsIndividualCadet extends Activity  implements View.OnClickListener{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_analytics_individual_cadet);
		
		int numEvents = 25;

		TableLayout events = (TableLayout)findViewById(R.id.tableLayout1);
		events.setStretchAllColumns(true);
		events.bringToFront();
		
		TableRow tr =  new TableRow(this);
		TextView c1 = new TextView(this);
		c1.setText("Event");
		c1.setTextSize(20);
		c1.setTextColor(Color.WHITE);
		c1.setGravity(Gravity.CENTER);
		c1.setBackgroundResource(R.drawable.gradient);
		tr.addView(c1);
		
		c1 = new TextView(this);
		c1.setText("Completed");
		c1.setTextSize(20);
		c1.setTextColor(Color.WHITE);
		c1.setGravity(Gravity.CENTER);
		c1.setBackgroundResource(R.drawable.gradient);
		tr.addView(c1);
		
		c1 = new TextView(this);
		c1.setText("Score");
		c1.setTextSize(20);
		c1.setTextColor(Color.WHITE);
		c1.setGravity(Gravity.CENTER);
		c1.setBackgroundResource(R.drawable.gradient);
		tr.addView(c1);
		tr.setGravity(Gravity.CENTER);
		events.addView(tr);
		
		for(int i = 0; i < numEvents; i++){
			tr =  new TableRow(this);
			c1 = new TextView(this);
			c1.setId(i);
			c1.setText("01/01/2014");
			c1.setPadding(0, 10, 0, 10);
			c1.setOnClickListener(this);
			c1.setTextSize(16);
			c1.setTextColor(Color.BLACK);
			c1.setGravity(Gravity.CENTER);
			c1.setBackgroundResource(R.drawable.gradient2);
			tr.addView(c1);
			
			c1 = new TextView(this);
			c1.setText("3/3");
			c1.setOnClickListener(this);
			c1.setTextSize(20);
			c1.setTextColor(Color.BLACK);
			c1.setGravity(Gravity.CENTER);
			c1.setBackgroundResource(R.drawable.gradient2);
			tr.addView(c1);
			
			c1 = new TextView(this);
			c1.setText("300");
			c1.setOnClickListener(this);
			c1.setTextSize(20);
			c1.setTextColor(Color.BLACK);
			c1.setGravity(Gravity.CENTER);
			c1.setBackgroundResource(R.drawable.gradient2);
			tr.addView(c1);
			tr.setGravity(Gravity.CENTER);
			events.addView(tr);
		}
	}
	
	@Override
	public void onClick(View arg0) {
		int selectedEvent = arg0.getId();
		Intent i = new Intent(this, analyticsIndividualCadetEvent.class);
		startActivity(i);
	}

}
