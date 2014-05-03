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

public class editDeleteCadetSelect extends Activity implements View.OnClickListener {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cadet_select);
		varApplication va = (varApplication)getApplicationContext();
		String id = va.getId();
		ArrayList<ArrayList<String>> cdt = DBUtil.cdtList(id);
		int numCadets = cdt.size();

		TableLayout cadets = (TableLayout)findViewById(R.id.tableLayout1);
		cadets.setStretchAllColumns(true);
		cadets.bringToFront();
		for(int i = 0; i < numCadets; i++){
			TableRow tr =  new TableRow(this);
			TextView c1 = new TextView(this);
			c1.setId(i);
			c1.setOnClickListener(this);
			c1.setText(cdt.get(i).get(0));
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
		varApplication va = (varApplication)getApplicationContext();
		String id = va.getId();
		ArrayList<ArrayList<String>> cdt = DBUtil.cdtList(id);
		int selectedEvent = arg0.getId();
		Intent i = new Intent(this, editDeleteCadet.class);
		i.putExtra("id", cdt.get(selectedEvent).get(1));
		startActivity(i);
	}

}
