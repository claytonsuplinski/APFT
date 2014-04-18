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

public class analyticsSelectCadet extends Activity implements View.OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cadet_select);
		
		int numCadets = 22;

		TableLayout cadets = (TableLayout)findViewById(R.id.tableLayout1);
		cadets.setStretchAllColumns(true);
		cadets.bringToFront();
		for(int i = 0; i < numCadets; i++){
			TableRow tr =  new TableRow(this);
			TextView c1 = new TextView(this);
			c1.setId(i);
			c1.setOnClickListener(this);
			c1.setText("Cadet" + (i+1));
			c1.setTextSize(24);
			c1.setTextColor(Color.WHITE);
			c1.setGravity(Gravity.CENTER);
			tr.setBackgroundResource(R.drawable.gradient);
			tr.setGravity(Gravity.CENTER);
			tr.addView(c1);
			cadets.addView(tr);
		}
	}
	
	@Override
	public void onClick(View arg0) {
		int selectedEvent = arg0.getId();
		Intent i = new Intent(this, analyticsIndividualCadet.class);
		startActivity(i);
	}
	
}
