package com.example.finalproject;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class previousCodes extends Activity implements View.OnClickListener {
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_of_databases);

		int numEvents = 18;

		TableLayout events = (TableLayout)findViewById(R.id.tableLayout1);
		events.setStretchAllColumns(true);
		events.bringToFront();
		for(int i = 0; i < numEvents; i++){
			TableRow tr =  new TableRow(this);
			TextView c1 = new TextView(this);
			c1.setId(i);
			c1.setOnClickListener(this);
			c1.setText("Link to Database " + (i+1));
			c1.setTextSize(24);
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
		int selectedEvent = arg0.getId();
		//Intent i = new Intent(this, eventSelectActivity.class);
		//startActivity(i);
	}

}
