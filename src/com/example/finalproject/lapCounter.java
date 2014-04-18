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

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lap_counter);

		int numCadets = 25;

		TableLayout cadets = (TableLayout)findViewById(R.id.tableLayout2);
		cadets.setStretchAllColumns(true);
		cadets.bringToFront();
		TableRow tr =  new TableRow(this);
		for(int i = 0; i < numCadets; i++){
			if(i%2 == 0){
				tr =  new TableRow(this);
			}
			TextView c1 = new TextView(this);
			c1.setBackgroundResource(R.drawable.gradient);
			
			c1.setId(i);
			c1.setOnClickListener(this);
			c1.setText("Soldier " + (i+1) + ": " + (i+3));
			c1.setTextSize(24);
			c1.setTextColor(Color.WHITE);
			c1.setGravity((i%2 == 0 ? Gravity.LEFT : Gravity.RIGHT));
			tr.addView(c1);
			
			tr.setGravity(Gravity.CENTER);	
			if(i%2 == 1){
				cadets.addView(tr);
			}
		}
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
