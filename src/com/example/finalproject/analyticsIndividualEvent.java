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

public class analyticsIndividualEvent extends Activity  implements View.OnClickListener{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_analytics_individual_event);
		
		int numCadets = 22;

		TableLayout cadets = (TableLayout)findViewById(R.id.tableLayout1);
		cadets.setStretchAllColumns(true);
		cadets.bringToFront();
		
		TableRow tr =  new TableRow(this);
		TextView c1 = new TextView(this);
		c1.setText("Name");
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
		cadets.addView(tr);
		
		for(int i = 0; i < numCadets; i++){
			tr =  new TableRow(this);
			c1 = new TextView(this);
			c1.setId(i);
			c1.setText("Suplinski, Clayton" + (i+1));
			c1.setPadding(0, 10, 0, 10);
			c1.setTextSize(16);
			c1.setTextColor(Color.BLACK);
			c1.setGravity(Gravity.CENTER);
			c1.setBackgroundResource(R.drawable.gradient2);
			tr.addView(c1);
			
			c1 = new TextView(this);
			c1.setText("3/3");
			c1.setTextSize(20);
			c1.setTextColor(Color.BLACK);
			c1.setGravity(Gravity.CENTER);
			c1.setBackgroundResource(R.drawable.gradient2);
			tr.addView(c1);
			
			c1 = new TextView(this);
			c1.setText("300");
			c1.setTextSize(20);
			c1.setTextColor(Color.BLACK);
			c1.setGravity(Gravity.CENTER);
			c1.setBackgroundResource(R.drawable.gradient2);
			tr.addView(c1);
			tr.setGravity(Gravity.CENTER);
			cadets.addView(tr);
		}
	}
	
	@Override
	public void onClick(View arg0) {
		
	}

}
