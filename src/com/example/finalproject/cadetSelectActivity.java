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

public class cadetSelectActivity extends Activity implements View.OnClickListener {

	ArrayList<ArrayList<String>> cdts;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cadet_select);
		varApplication va = (varApplication)getApplicationContext();
		String dbId = va.getId();
		cdts = DBUtil.cdtList(dbId);
		int numCadets = cdts.size();

		TableLayout cadets = (TableLayout)findViewById(R.id.tableLayout1);
		cadets.setStretchAllColumns(true);
		cadets.bringToFront();
		for(int i = 0; i < numCadets; i++){
			TableRow tr =  new TableRow(this);
			TextView c1 = new TextView(this);
			c1.setId(i);
			c1.setOnClickListener(this);
			c1.setText("" + cdts.get(i).get(0));
			c1.setPadding(0, 10, 0, 10);
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


		Intent intent = getIntent();
		Bundle extras = intent.getExtras(); 
		int selectedEvent = arg0.getId();
		int tmp = extras.getInt("pushupsEqualsOne");
		Intent i = new Intent(this, inputEventScoreActivity.class);
		i.putExtra("pushupsEqualsOne",tmp);
		i.putExtra("cdtId", cdts.get(selectedEvent).get(1));
		i.putExtra("event", extras.getString("event"));
		startActivity(i);
	}


}
