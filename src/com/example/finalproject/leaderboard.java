package com.example.finalproject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class leaderboard extends Activity{
	
	ArrayList<ArrayList<String>> cdtList;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_analytics_individual_event);
		
		varApplication va = (varApplication)getApplicationContext();
		String dbId = va.getId();
		cdtList = DBUtil.cdtList(dbId); //cdt list names in 0
		Bundle extras = getIntent().getExtras();
		int eventNum = extras.getInt("eventNum");//eventNum
		eventNum++;
		ArrayList<ArrayList<String>> cdtIds = new ArrayList<ArrayList<String>>();
		for(int i = 0; i < cdtList.size(); i++){
			ArrayList<String> ar = new ArrayList<String>();
			ar.add(cdtList.get(i).get(1));
			String en = "" + eventNum;
			ar.add(en);
			cdtIds.add(ar);
		}
		System.out.println("cdtId size=" + cdtIds.size());
		Collections.sort(cdtIds, new Comparator<ArrayList<String>>() {
		    public int compare(ArrayList<String> a, ArrayList<String> b) {
				String cdtId1 = a.get(0);
				ArrayList<String> cdtInfo1= DBUtil.getCdtInfo(cdtId1);
				String name1 = cdtInfo1.get(0);
				String dob1 = cdtInfo1.get(1); //dob
				String gender1 = cdtInfo1.get(2);
				ArrayList<Integer> cdtScores = DBUtil.cdtGetScores(cdtId1, Integer.parseInt(a.get(1)));
				int pu1 = cdtScores.get(0);
				int su1 = cdtScores.get(1);
				int ru1 = cdtScores.get(2);
				Cadet tmpCdt1 = new Cadet("", Cadet.dobToAge(dob1), gender1, pu1, su1, ru1);
				
				String cdtId2 = b.get(0);
				ArrayList<String> cdtInfo2 = DBUtil.getCdtInfo(cdtId2);
				String name2 = cdtInfo2.get(0);
				String dob2 = cdtInfo2.get(1); //dob
				String gender2 = cdtInfo2.get(2);
				ArrayList<Integer> cdtScores2 = DBUtil.cdtGetScores(cdtId2, Integer.parseInt(b.get(1)));
				int pu2 = cdtScores2.get(0);
				int su2 = cdtScores2.get(1);
				int ru2 = cdtScores2.get(2);
				Cadet tmpCdt2 = new Cadet("", Cadet.dobToAge(dob2), gender2, pu2, su2, ru2);
				
				return tmpCdt2.getScore() - tmpCdt1.getScore();
		    }
		});
		System.out.println("cdtId sorteD: " + cdtIds);
		System.out.println("cdtId size after sort=" + cdtIds.size());
		//now cdtIds is sorted so we build our thing accordingly
		int sumP = 0;
		int sumS = 0;
		int sumR = 0;
		ArrayList<ArrayList<String>> toShow = new ArrayList<ArrayList<String>>();
		for(int i = 0; i < cdtIds.size(); i++){
			ArrayList<String> toAdd = new ArrayList<String>();
			
			String cdtId1 = cdtIds.get(i).get(0);
			ArrayList<String> cdtInfo1= DBUtil.getCdtInfo(cdtId1);
			String name1 = cdtInfo1.get(0);
			String dob1 = cdtInfo1.get(1); //dob
			String gender1 = cdtInfo1.get(2);
			ArrayList<Integer> cdtScores = DBUtil.cdtGetScores(cdtId1, Integer.parseInt(cdtIds.get(i).get(1)));
			int pu1 = cdtScores.get(0);
			int su1 = cdtScores.get(1);
			int ru1 = cdtScores.get(2);
			
			int comp = 0;
			if(pu1 > 4){
				comp++;
			}
			if(su1 > 19){
				comp++;
			}
			if(ru1 > 0){
				comp++;
			}
			Cadet tmpCdt1 = new Cadet("", Cadet.dobToAge(dob1), gender1, pu1, su1, ru1);
			
			sumP += tmpCdt1.getPushUpScore();
			sumS += tmpCdt1.getSitUpScore();
			sumR += tmpCdt1.getRunScore();
			
			toAdd.add(name1);
			toAdd.add(Integer.toString(comp));
			toAdd.add(Integer.toString(tmpCdt1.getScore()));
			System.out.println("toAdd added=" + toAdd);
			toShow.add(toAdd);
		}
		
		int numCadets = toShow.size();

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
			c1.setText(toShow.get(i).get(0));
			c1.setPadding(0, 10, 0, 10);
			c1.setTextSize(16);
			c1.setTextColor(Color.BLACK);
			c1.setGravity(Gravity.CENTER);
			c1.setBackgroundResource(R.drawable.gradient2);
			tr.addView(c1);
			
			c1 = new TextView(this);
			c1.setText(toShow.get(i).get(1) + "/3");
			c1.setTextSize(20);
			c1.setTextColor(Color.BLACK);
			c1.setGravity(Gravity.CENTER);
			c1.setBackgroundResource(R.drawable.gradient2);
			tr.addView(c1);
			
			c1 = new TextView(this);
			c1.setText(toShow.get(i).get(2));
			c1.setTextSize(20);
			c1.setTextColor(Color.BLACK);
			c1.setGravity(Gravity.CENTER);
			c1.setBackgroundResource(R.drawable.gradient2);
			tr.addView(c1);
			tr.setGravity(Gravity.CENTER);
			cadets.addView(tr);
		}
	}

}
