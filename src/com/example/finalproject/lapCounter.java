package com.example.finalproject;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class lapCounter extends Activity implements View.OnClickListener {

	final static int START_ID = 99999;
	final static int STOP_ID = 999999;
	final static int TIMER_ID = 9999999;

	static boolean clockRunning = false;

	static TextView timerTextView;

	static int seconds = 0;
	static int minutes = 0;
	int numLaps = 0;

	int numCadets = 6;
	
	String event = "";
	int eventNum = 0;
	
	int[] cadetLapCounters;
	
	ArrayList<ArrayList<Integer>> cadetLapTimes = new ArrayList<ArrayList<Integer>>(); 
	ArrayList<Integer> previousLapSums = new ArrayList<Integer>();
	
	ArrayList<ArrayList<String>> cdtList;
 
	static Timer timer = new Timer();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lap_counter);
		Bundle extras = getIntent().getExtras();
		varApplication va = (varApplication)getApplicationContext();
		String dbId = va.getId();
		event = extras.getString("event");//event date

		cdtList = DBUtil.cdtList(dbId);
		numCadets = cdtList.size();
		cadetLapCounters = new int[numCadets];


		TableLayout cadets = (TableLayout)findViewById(R.id.tableLayout2);
		cadets.setStretchAllColumns(true);
		cadets.bringToFront();
		TableRow tr =  new TableRow(this);
		for(int i = 0; i < numCadets; i++){
			cadetLapCounters[i] = 0;
			previousLapSums.add(0);
			cadetLapTimes.add(new ArrayList<Integer>());
			TextView c1 = new TextView(this);
			c1.setBackgroundResource(R.drawable.gradient);

			c1.setId(i);
			c1.setOnClickListener(this);

			c1.setText(cdtList.get(i).get(0) + "\n" + cadetLapCounters[i]);
			c1.setTextSize(16);
			c1.setTextColor(Color.WHITE);
			c1.setGravity(Gravity.CENTER);
			tr.addView(c1);

			tr.setGravity(Gravity.CENTER);	
			if(i%2 == 1){
				cadets.addView(tr);
				tr =  new TableRow(this);
			}
		}
		cadets.addView(tr);

		tr =  new TableRow(this);
		TextView c1 = new TextView(this);
		c1.setText("\n");
		c1.setTextSize(18);
		tr.setGravity(Gravity.CENTER);
		tr.addView(c1);
		cadets.addView(tr);

		tr =  new TableRow(this);
		c1 = new TextView(this);
		c1.setBackgroundResource(R.drawable.gradient);		
		c1.setId(START_ID);
		c1.setOnClickListener(this);
		c1.setText("Start");
		c1.setTextSize(20);
		c1.setTextColor(Color.WHITE);
		c1.setGravity(Gravity.CENTER);
		tr.addView(c1);
		
		c1 = new TextView(this);
		c1.setBackgroundResource(R.drawable.gradient);		
		c1.setId(STOP_ID);
		c1.setOnClickListener(this);
		c1.setText("Save");
		c1.setTextSize(20);
		c1.setTextColor(Color.WHITE);
		c1.setGravity(Gravity.CENTER);
		tr.addView(c1);
		tr.setGravity(Gravity.CENTER);
		cadets.addView(tr);

		tr =  new TableRow(this);		
		c1 = new TextView(this);
		c1.setBackgroundResource(R.drawable.gradient2);		
		c1.setId(TIMER_ID);
		c1.setText("0:00");
		c1.setTextSize(20);
		c1.setTextColor(Color.BLACK);
		c1.setGravity(Gravity.CENTER);
		tr.addView(c1);
		tr.setGravity(Gravity.CENTER);
		cadets.addView(tr);

		timerTextView = (TextView)findViewById(TIMER_ID);

	}


	protected static void startTimer() { 
		clockRunning = true;
		timer.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				seconds++;
				if(seconds == 60){seconds = 0;minutes++;}
				mHandler.obtainMessage(1).sendToTarget();
			}
		}, 0, 1000);
	};

	public static Handler mHandler = new Handler() {
		public void handleMessage(Message msg) {
			timerTextView.setText("" + minutes + ":" + (seconds < 10 ? "0" + seconds : seconds));
		}
	};


	@Override
	public void onClick(View arg0) {

		if(arg0.getId() < numCadets && arg0.getId() >= 0){
			int i = arg0.getId();
			cadetLapCounters[i]--;
			if(cadetLapCounters[i] < 0){cadetLapCounters[i]=0;}
			else{
				cadetLapTimes.get(i).add((60*minutes)+seconds - previousLapSums.get(i));
				previousLapSums.set(i, (60*minutes)+seconds);
			}
			TextView time = (TextView)findViewById(i);
			time.setText(cdtList.get(i).get(0) + "\n" + cadetLapCounters[i]);
			
			
		}
		else{
			switch(arg0.getId())
			{
			case START_ID:

				EditText edit = (EditText)findViewById(R.id.totalLaps);

				try{
					numLaps = Integer.parseInt(edit.getText().toString());
				} catch(NumberFormatException e){
					numLaps = 0;
				}

				if(numLaps > 0){

					previousLapSums.clear();
					cadetLapTimes.clear();
					
					for(int i=0; i<numCadets; i++){
						cadetLapTimes.add(new ArrayList<Integer>());						
						previousLapSums.add(0);
						cadetLapCounters[i] = numLaps;
						TextView time = (TextView)findViewById(i);
						time.setText("Suplinski, Clayton" + "\n" + cadetLapCounters[i]);
					}

					seconds = 0;minutes = 0;
					if(!clockRunning){
						startTimer();
					}

					/*seconds++;
		    	if(seconds == 60){seconds = 0;minutes++;}
				TextView time = (TextView)findViewById(TIMER_ID);
		    	time.setText("" + minutes + ":" + (seconds < 10 ? "0" + seconds : seconds));
					 */

				}
				//timer.schedule(new UpdateClock(), 1000);
				break;
			case STOP_ID:

				if(clockRunning){
					timer.cancel();
					timer.purge();
					timer = new Timer();
					clockRunning = false;
					
					boolean success = true;
					
					//Save to database here
					for(int i = 0; i < numCadets; i++){
						eventNum = DBUtil.cdtGetEventNum(cdtList.get(i).get(1), event);
						int sum = 0;
						for(int j = 0; j < numLaps; j++){
							sum += cadetLapTimes.get(i).get(j);
						}
						boolean tmpSuccess = DBUtil.cdtAddRU(cdtList.get(i).get(1), eventNum, sum, cadetLapTimes.get(i), event);
						if(!tmpSuccess){
							success = false;
						}
					}
					
					if(success){
						Toast.makeText(this, "Saved to database.", Toast.LENGTH_SHORT).show();
					}
					else{
						Toast.makeText(this, "Failed to save to database.", Toast.LENGTH_SHORT).show();
					}
				}

				break;

			default:
			}
		}
	}

}
