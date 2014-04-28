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

public class inputDatabaseCode extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_input_database_code);
		
		TableLayout events = (TableLayout)findViewById(R.id.tableLayout1);
		events.setStretchAllColumns(true);
		events.bringToFront();

		TableRow tr =  new TableRow(this);
		TextView c1 = new TextView(this);
		c1.setId(1);
		c1.setText("Current Database : ");
		c1.setTextSize(20);
		c1.setTextColor(Color.WHITE);
		c1.setGravity(Gravity.CENTER);
		tr.setBackgroundResource(R.drawable.gradient);
		tr.setGravity(Gravity.CENTER);
		tr.addView(c1);
		events.addView(tr);
	}
	
	public void onButtonClick(View v)
	{
		Intent i;
		switch(v.getId())
		{
		/*case R.id.button_inputCode:
			i = new Intent(this, inputDatabaseCode.class);
			startActivity(i);
			break;
*/
		default:
		}
	}

}
