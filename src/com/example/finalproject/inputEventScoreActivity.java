package com.example.finalproject;

import java.util.ArrayList;

import com.parse.ParseException;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class inputEventScoreActivity extends Activity implements OnClickListener {

	int isPU = -1;
	EditText et;
	String cdtId;
	String event;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_input_event_score);
		
		Intent intent = getIntent();
		Bundle extras = intent.getExtras(); 
		int pushups = extras.getInt("pushupsEqualsOne");
		System.out.println("iPU=" + pushups);
		isPU = pushups;
		cdtId = extras.getString("cdtId");
		System.out.println("cdtId: " +cdtId);
		event = extras.getString("event");
		
		ArrayList<String> info = DBUtil.getCdtInfo(cdtId);
		System.out.println(info);
		
		
		TableLayout cadets = (TableLayout)findViewById(R.id.tableLayout1);
		cadets.setStretchAllColumns(true);
		cadets.bringToFront();
		
		TableRow tr =  new TableRow(this);
		TextView c1 = new TextView(this);
		c1.setId(0);
		c1.setText((pushups == 1 ? "Input Push-ups" : "Input Sit-ups"));
		c1.setTextSize(26);
		c1.setTextColor(Color.WHITE);
		c1.setGravity(Gravity.CENTER);
		tr.setBackgroundResource(R.drawable.gradient);
		tr.setGravity(Gravity.CENTER);
		tr.addView(c1);
		cadets.addView(tr);
		
		tr =  new TableRow(this);
		c1 = new TextView(this);
		c1.setText("\n");
		c1.setTextSize(18);
		tr.setGravity(Gravity.CENTER);
		tr.addView(c1);
		cadets.addView(tr);
		
		tr =  new TableRow(this);
		c1 = new TextView(this);
		c1.setId(1);
		c1.setText("Soldier Name: " + info.get(0));
		c1.setTextSize(22);
		c1.setTextColor(Color.WHITE);
		c1.setGravity(Gravity.CENTER);
		tr.setBackgroundResource(R.drawable.gradient);
		tr.setGravity(Gravity.CENTER);
		tr.addView(c1);
		cadets.addView(tr);
		
		tr =  new TableRow(this);
		c1 = new TextView(this);
		c1.setText("\n");
		c1.setTextSize(8);
		tr.setGravity(Gravity.CENTER);
		tr.addView(c1);
		cadets.addView(tr);
		
		tr =  new TableRow(this);
		c1 = new TextView(this);
		c1.setId(1);
		c1.setText("Age: " + Cadet.dobToAge(info.get(1)));
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
		c1.setText("Gender: " + info.get(2));
		c1.setTextSize(18);
		c1.setTextColor(Color.WHITE);
		c1.setGravity(Gravity.CENTER);
		tr.setBackgroundResource(R.drawable.gradient);
		tr.setGravity(Gravity.CENTER);
		tr.addView(c1);
		cadets.addView(tr);
		
		//get min/max needed
		Cadet.Gender g = Cadet.Gender.male;
		if(info.get(2).equalsIgnoreCase("F")){
			g = Cadet.Gender.female;
		}
		ArrayList<int[]> scores = Cadet.minMaxScores(Cadet.dobToAge(info.get(1)), g);
		System.out.println("scores:::: " + scores);
		System.out.println(scores.get(0)[0]);
		System.out.println(scores.get(0)[1]);
		System.out.println(scores.get(1)[0]);
		System.out.println(scores.get(1)[1]);
		System.out.println(scores.get(2)[0]);
		System.out.println(scores.get(2)[1]);
		
		tr =  new TableRow(this);
		c1 = new TextView(this);
		c1.setId(1);
		if(pushups == 1){
			c1.setText("Min: " + scores.get(0)[0]);
		}else{
			c1.setText("Min: " + scores.get(1)[0]);
		}

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
		if(pushups == 1){
			c1.setText("Max: " + scores.get(0)[1]);
		}else{
			c1.setText("Max: " + scores.get(1)[1]);
		}
		c1.setTextSize(18);
		c1.setTextColor(Color.WHITE);
		c1.setGravity(Gravity.CENTER);
		tr.setBackgroundResource(R.drawable.gradient);
		tr.setGravity(Gravity.CENTER);
		tr.addView(c1);
		cadets.addView(tr);
		
		tr =  new TableRow(this);
		c1 = new TextView(this);
		c1.setText("\n");
		c1.setTextSize(18);
		tr.setGravity(Gravity.CENTER);
		tr.addView(c1);
		cadets.addView(tr);
		
		tr =  new TableRow(this);
		EditText c2 = new EditText(this);
		c2.setId(2);
		c2.setHint("Input Score");
		c2.setTextSize(18);
		c2.setTextColor(Color.BLACK);
		c2.setGravity(Gravity.CENTER);
		tr.setGravity(Gravity.CENTER);
		tr.addView(c2);
		cadets.addView(tr);
		
		et = c2;
		
		tr =  new TableRow(this);
		c1 = new TextView(this);
		c1.setText("\n");
		c1.setTextSize(18);
		tr.setGravity(Gravity.CENTER);
		tr.addView(c1);
		cadets.addView(tr);
		
		tr =  new TableRow(this);
		c1 = new TextView(this);
		c1.setId(3);
		c1.setOnClickListener(this);
		c1.setText("Submit");
		c1.setPadding(0, 10, 0, 10);
		c1.setTextSize(18);
		c1.setTextColor(Color.WHITE);
		c1.setGravity(Gravity.CENTER);
		tr.setBackgroundResource(R.drawable.gradient);
		tr.setGravity(Gravity.CENTER);
		tr.addView(c1);
		cadets.addView(tr);

		
	}
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		if(arg0.getId() == 3){
			int eventNum = DBUtil.cdtGetEventNum(cdtId, event);
			if(isPU == 1){
				DBUtil.cdtAddPU(cdtId, eventNum, Integer.parseInt(et.getText().toString()), event);
			}else if(isPU == 0){
				DBUtil.cdtAddSU(cdtId, eventNum, Integer.parseInt(et.getText().toString()), event);
			}
		}
	}
}
