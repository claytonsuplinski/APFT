package com.example.finalproject;

import java.util.ArrayList;

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
	
	String cdtId;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_analytics_individual_cadet);
		varApplication va = (varApplication)getApplicationContext();
		String dbId = va.getId();
		Bundle extras = getIntent().getExtras();
		cdtId = extras.getString("cdtId");//eventNum

		int numEvents = DBUtil.getCdtEventNum(cdtId);

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
		
		double pu = 0;
		double su = 0;
		double ru = 0;
		double sc = 0;
		
		for(int i = 1; i <= numEvents; i++){
			
			//make Cadet obj
			ArrayList<String> info = DBUtil.getCdtInfo(cdtId);
			ArrayList<Integer> scores = DBUtil.cdtGetScores(cdtId, i);
			int age = Cadet.dobToAge(info.get(1));
			Cadet cdt = new Cadet("", age, info.get(2), scores.get(0), scores.get(1), scores.get(2));
			
			pu += cdt.getPushUpScore();
			su += cdt.getSitUpScore();
			ru += cdt.getRunScore();
			sc += cdt.getScore();
			
			tr =  new TableRow(this);
			c1 = new TextView(this);
			c1.setId(i);
			c1.setText(DBUtil.getCdtEvent(cdtId, i));
			c1.setPadding(0, 10, 0, 10);
			c1.setOnClickListener(this);
			c1.setTextSize(16);
			c1.setTextColor(Color.BLACK);
			c1.setGravity(Gravity.CENTER);
			c1.setBackgroundResource(R.drawable.gradient2);
			tr.addView(c1);
			int comp = 0;
			if(scores.get(0) > 4){
				comp++;
			}
			if(scores.get(1) > 19){
				comp++;
			}
			if(scores.get(2) > 0){
				comp++;
			}
			c1 = new TextView(this);
			c1.setText(comp + "/3");
			c1.setTextSize(20);
			c1.setTextColor(Color.BLACK);
			c1.setGravity(Gravity.CENTER);
			c1.setBackgroundResource(R.drawable.gradient2);
			tr.addView(c1);
			
			c1 = new TextView(this);
			c1.setText(Integer.toString(cdt.getScore()));
			c1.setTextSize(20);
			c1.setTextColor(Color.BLACK);
			c1.setGravity(Gravity.CENTER);
			c1.setBackgroundResource(R.drawable.gradient2);
			tr.addView(c1);
			tr.setGravity(Gravity.CENTER);
			events.addView(tr);
		}
		
		tr =  new TableRow(this);
		c1 = new TextView(this);
		c1.setText("\n");
		c1.setTextSize(18);
		tr.setGravity(Gravity.CENTER);
		tr.addView(c1);
		events.addView(tr);
		
		tr =  new TableRow(this);
		c1 = new TextView(this);
		c1.setText("Averages");
		c1.setTextSize(20);
		c1.setTextColor(Color.WHITE);
		c1.setGravity(Gravity.CENTER);
		c1.setBackgroundResource(R.drawable.gradient);
		tr.addView(c1);
		tr.setGravity(Gravity.CENTER);
		events.addView(tr);
		
		tr =  new TableRow(this);
		c1 = new TextView(this);
		c1.setText("Push-up Score: ");
		c1.setTextSize(18);
		c1.setTextColor(Color.BLACK);
		c1.setGravity(Gravity.CENTER);
		c1.setBackgroundResource(R.drawable.gradient2);
		tr.addView(c1);
		
		c1 = new TextView(this);
		c1.setText(Double.toString((pu/numEvents)));
		c1.setTextSize(18);
		c1.setTextColor(Color.BLACK);
		c1.setGravity(Gravity.CENTER);
		c1.setBackgroundResource(R.drawable.gradient2);
		tr.addView(c1);
		tr.setGravity(Gravity.CENTER);
		events.addView(tr);
		
		tr =  new TableRow(this);
		c1 = new TextView(this);
		c1.setText("Sit-up Score: ");
		c1.setTextSize(18);
		c1.setTextColor(Color.BLACK);
		c1.setGravity(Gravity.CENTER);
		c1.setBackgroundResource(R.drawable.gradient2);
		tr.addView(c1);
		
		c1 = new TextView(this);
		c1.setText(Double.toString((su/numEvents)));
		c1.setTextSize(18);
		c1.setTextColor(Color.BLACK);
		c1.setGravity(Gravity.CENTER);
		c1.setBackgroundResource(R.drawable.gradient2);
		tr.addView(c1);
		tr.setGravity(Gravity.CENTER);
		events.addView(tr);
		
		tr =  new TableRow(this);
		c1 = new TextView(this);
		c1.setText("Run Score: ");
		c1.setTextSize(18);
		c1.setTextColor(Color.BLACK);
		c1.setGravity(Gravity.CENTER);
		c1.setBackgroundResource(R.drawable.gradient2);
		tr.addView(c1);
		
		c1 = new TextView(this);
		c1.setText(Double.toString((ru/numEvents)));
		c1.setTextSize(18);
		c1.setTextColor(Color.BLACK);
		c1.setGravity(Gravity.CENTER);
		c1.setBackgroundResource(R.drawable.gradient2);
		tr.addView(c1);
		tr.setGravity(Gravity.CENTER);
		events.addView(tr);
		
		tr =  new TableRow(this);
		c1 = new TextView(this);
		c1.setText("Overall: ");
		c1.setTextSize(18);
		c1.setTextColor(Color.BLACK);
		c1.setGravity(Gravity.CENTER);
		c1.setBackgroundResource(R.drawable.gradient2);
		tr.addView(c1);
		
		c1 = new TextView(this);
		c1.setText(Double.toString((sc/numEvents)));
		c1.setTextSize(18);
		c1.setTextColor(Color.BLACK);
		c1.setGravity(Gravity.CENTER);
		c1.setBackgroundResource(R.drawable.gradient2);
		tr.addView(c1);
		tr.setGravity(Gravity.CENTER);
		events.addView(tr);
		
		tr =  new TableRow(this);
		c1 = new TextView(this);
		c1.setText("\n");
		c1.setTextSize(18);
		tr.setGravity(Gravity.CENTER);
		tr.addView(c1);
		events.addView(tr);
	}
	
	@Override
	public void onClick(View arg0) {
		int selectedEvent = arg0.getId();
		Intent i = new Intent(this, analyticsIndividualCadetEvent.class);
		i.putExtra("cdtId", cdtId);
		i.putExtra("eventNum", selectedEvent);
		startActivity(i);
	}

}
