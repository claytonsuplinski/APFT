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

public class lapCounter extends Activity implements View.OnClickListener {
	
	static int UNDO_ID = 9999;
	static int START_ID = 99999;
	static int STOP_ID = 999999;
	static int TIMER_ID = 9999999;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lap_counter);

		int numCadets = 24;

		TableLayout cadets = (TableLayout)findViewById(R.id.tableLayout2);
		cadets.setStretchAllColumns(true);
		cadets.bringToFront();
		TableRow tr =  new TableRow(this);
		for(int i = 0; i < numCadets; i++){
			TextView c1 = new TextView(this);
			c1.setBackgroundResource(R.drawable.gradient);
			
			c1.setId(i);
			c1.setOnClickListener(this);
			
			c1.setText("Soldier " + (i+1) + ": 14");
			c1.setTextSize(24);
			c1.setTextColor(Color.WHITE);
			c1.setGravity(Gravity.CENTER);
			tr.addView(c1);
			
			tr.setGravity(Gravity.CENTER);	
			if(i%2 == 1){
				cadets.addView(tr);
				tr =  new TableRow(this);
			}
		}
		cadets.addView(tr);
		
		tr =  new TableRow(this);
		TextView c1 = new TextView(this);
		c1.setText("\n");
		c1.setTextSize(18);
		tr.setGravity(Gravity.CENTER);
		tr.addView(c1);
		cadets.addView(tr);
		
		tr =  new TableRow(this);
		c1 = new TextView(this);
		c1.setBackgroundResource(R.drawable.gradient);		
		c1.setId(UNDO_ID);
		c1.setOnClickListener(this);
		c1.setText("Undo");
		c1.setTextSize(20);
		c1.setTextColor(Color.WHITE);
		c1.setGravity(Gravity.CENTER);
		tr.addView(c1);
		
		c1 = new TextView(this);
		c1.setBackgroundResource(R.drawable.gradient);		
		c1.setId(START_ID);
		c1.setOnClickListener(this);
		c1.setText("Start");
		c1.setTextSize(20);
		c1.setTextColor(Color.WHITE);
		c1.setGravity(Gravity.CENTER);
		tr.addView(c1);
		tr.setGravity(Gravity.CENTER);
		cadets.addView(tr);
		
		tr =  new TableRow(this);
		c1 = new TextView(this);
		c1.setBackgroundResource(R.drawable.gradient2);		
		c1.setId(TIMER_ID);
		c1.setOnClickListener(this);
		c1.setText("0:00");
		c1.setTextSize(20);
		c1.setTextColor(Color.BLACK);
		c1.setGravity(Gravity.CENTER);
		tr.addView(c1);
		
		c1 = new TextView(this);
		c1.setBackgroundResource(R.drawable.gradient);		
		c1.setId(STOP_ID);
		c1.setOnClickListener(this);
		c1.setText("Stop");
		c1.setTextSize(20);
		c1.setTextColor(Color.WHITE);
		c1.setGravity(Gravity.CENTER);
		tr.addView(c1);
		tr.setGravity(Gravity.CENTER);
		cadets.addView(tr);
		
	}

	@Override
	public void onClick(View arg0) {
		/*int selectedEvent = arg0.getId();
		Intent i = new Intent(this, eventSelectActivity.class);
		startActivity(i);*/
		//Remember to bundle date information so we update the correct day's event info.
		//Use the selectedEvent index for this.
	}

}
