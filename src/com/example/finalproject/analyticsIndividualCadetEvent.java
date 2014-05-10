package com.example.finalproject;

import java.util.ArrayList;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class analyticsIndividualCadetEvent extends Activity implements View.OnClickListener{
	
	String cdtId = "";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_analytics_individual_cadet_event);
		varApplication va = (varApplication)getApplicationContext();
		String dbId = va.getId();
		Bundle extras = getIntent().getExtras();
		cdtId = extras.getString("cdtId");//eventNum
		int eventNum = extras.getInt("eventNum");
		//eventNum++;
		
		ArrayList<String> info = DBUtil.getCdtInfo(cdtId);
		ArrayList<Integer> scores = DBUtil.cdtGetScores(cdtId, eventNum);
		int age = Cadet.dobToAge(info.get(1));
		Cadet cdt = new Cadet("", age, info.get(2), scores.get(0), scores.get(1), scores.get(2));
		
		int i=0;

		TableLayout events = (TableLayout)findViewById(R.id.tableLayout1);
		events.setStretchAllColumns(true);
		events.bringToFront();
		
		TableRow tr =  new TableRow(this);
		TextView c1 = new TextView(this);
		c1.setId(i);
		i++;
		c1.setOnClickListener(this);
		c1.setText(info.get(0));
		c1.setTextSize(26);
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
		c1.setText("Raw Scores");
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
		c1.setTextSize(8);
		tr.setGravity(Gravity.CENTER);
		tr.addView(c1);
		events.addView(tr);
		
		tr =  new TableRow(this);
		c1 = new TextView(this);
		c1.setId(i);
		i++;
		c1.setOnClickListener(this);
		c1.setText("Pushups: " + scores.get(0));
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
		c1.setText("Situps: " + scores.get(1));
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
		c1.setText("Run: " + scores.get(2));
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
		c1.setText("APFT Score");
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
		c1.setTextSize(8);
		tr.setGravity(Gravity.CENTER);
		tr.addView(c1);
		events.addView(tr);
		
		tr =  new TableRow(this);
		c1 = new TextView(this);
		c1.setId(i);
		i++;
		c1.setOnClickListener(this);
		c1.setText("Pushup Score: " + cdt.getPushUps());
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
		c1.setText("Situp Score: " + cdt.getSitUps());
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
		c1.setText("Run Score: " + cdt.getRunScore());
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
		c1.setText("Overall Score: " + cdt.getScore());
		c1.setTextSize(20);
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
		c1.setText("Lap Times");
		c1.setTextSize(24);
		c1.setPadding(0, 10, 0, 10);
		c1.setTextColor(Color.WHITE);
		c1.setGravity(Gravity.CENTER);
		tr.setBackgroundResource(R.drawable.gradient);
		tr.setGravity(Gravity.CENTER);
		tr.addView(c1);
		events.addView(tr);
		
		tr =  new TableRow(this);
		c1 = new TextView(this);
		c1.setText("\n");
		c1.setTextSize(8);
		tr.setGravity(Gravity.CENTER);
		tr.addView(c1);
		events.addView(tr);
		
		ArrayList<Integer> laps = DBUtil.getCdtLaps(cdtId, eventNum);
		
		int numLaps = laps.size();

		for(int j = 0; j < numLaps; j++){
			tr =  new TableRow(this);
			c1 = new TextView(this);
			c1.setId(i+j);
			c1.setOnClickListener(this);
			c1.setText("Lap " + (j+1) + ": " + laps.get(j));
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
