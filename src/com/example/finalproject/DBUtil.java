package com.example.finalproject;

import java.util.ArrayList;

import android.content.Context;

import com.parse.*;

public class DBUtil {
	
	public static final String appId = "0Dz3pgtpqjqAxzIWo1xNbeYQyXoxvt5p39LxU58e";
	public static final String clientKey = "QYfZLiM6GGIDWDR3GIRg0jNjnrAXk7MI3RHrcjS5";
	public static final String dbListID = "QXfmmCx63v";
	
	public static String getDBIdFromName(String name){
		String ret = "";
		//first get the dblist
		ParseObject dbList = null;
		ParseQuery<ParseObject> query = ParseQuery.getQuery("DBList");
		try {
			dbList = query.get(dbListID);
		} catch (ParseException e) {
			//Failed to get DBList TODO:what does this even mean, no connectivity?
			return ret;
		}
		if(dbList == null){//DBList is null. Not connected to internet?
			return ret;//TODO: sactuall handle this
		}
		int dbNum = dbList.getInt("dbNum");
		if(dbNum != 0){
			for(int i = 1; i <= dbNum; i++){//stored as name then id
				String nameDb = dbList.getString("db" + Integer.toString(i) + "Name");
				if(nameDb != null){
					if(nameDb.length() > 0 && !(nameDb.equalsIgnoreCase("null"))){
						if(nameDb.equals(name)){
							ret = dbList.getString("db" + Integer.toString(i) + "Id");
						}
					}
				}
			}
		}
		return ret;
	}
	
	public static boolean deleteDB(String dbId){
		//first load db
		ParseObject db = null;
		ParseQuery<ParseObject> query = ParseQuery.getQuery("Database");
		try {
			db = query.get(dbId);
		} catch (ParseException e) {
			//Failed to get cdtId TODO:what does this even mean, no connectivity?
			return false;
		}
		if(db == null){//db is null. Not connected to internet?
			return false;
		}
		//got db, now kill every cadet in it
		for(int i = 1; i <= db.getInt("cdtNum"); i++){
			deleteCdt(dbId, db.getString("cdt" + Integer.toString(i) + "Id"));
		}
		//now null the entry in dblist
		ParseObject dbList = null;
		ParseQuery<ParseObject> query2 = ParseQuery.getQuery("DBList");
		try {
			dbList = query2.get(dbListID);
		} catch (ParseException e) {
			//Failed to get DBList TODO:what does this even mean, no connectivity?
			return false;
		}
		if(dbList == null){//DBList is null. Not connected to internet?
			return false;//TODO: sactuall handle this
		}
		int dbNum = dbList.getInt("dbNum");
		if(dbNum != 0){
			for(int i = 1; i <= dbNum; i++){//stored as name then id
				String id = dbList.getString("db" + Integer.toString(i) + "Id");
				if(id != null){
					if(id.equals(dbId)){
						dbList.put("db" + Integer.toString(i) + "Id", "null");
						dbList.put("db" + Integer.toString(i) + "Name", "null");
					}
				}
			}
		}
		try {
			dbList.save();
		} catch (ParseException e1) {
		}
		//then finally kill db
		try {
			db.delete();
		} catch (ParseException e) {
			return false;
		}
		return true;
	}
	
	public static ArrayList<String> getEventList(String dbId){
		ArrayList<String> ret = new ArrayList<String>();
		//first load db
		ParseObject db = null;
		ParseQuery<ParseObject> query = ParseQuery.getQuery("Database");
		try {
			db = query.get(dbId);
		} catch (ParseException e) {
			//Failed to get cdtId TODO:what does this even mean, no connectivity?
			return ret;
		}
		if(db == null){//db is null. Not connected to internet?
			return ret;
		}
		int eNum = db.getInt("eventNum");
		for(int i = 1; i <= eNum; i++){
			ret.add(db.getString("event" + i));
		}
		return ret;
	}
	
	public static boolean addEvent(String dbId, String date){
		ArrayList<String> ret = new ArrayList<String>();
		//first load db
		ParseObject db = null;
		ParseQuery<ParseObject> query = ParseQuery.getQuery("Database");
		try {
			db = query.get(dbId);
		} catch (ParseException e) {
			//Failed to get cdtId TODO:what does this even mean, no connectivity?
			return false;
		}
		if(db == null){//db is null. Not connected to internet?
			return false;
		}
		int eNum = db.getInt("eventNum");
		db.put("event" + (eNum+1), date);
		db.put("eventNum", eNum+1);
		try {
			db.save();
		} catch (ParseException e) {
			return false;
		}
		return true;
	}
	
	public static ArrayList<String> getDbInfo(String dbId){
		ArrayList<String> ret = new ArrayList<String>();
		//first load db
		ParseObject db = null;
		ParseQuery<ParseObject> query = ParseQuery.getQuery("Database");
		try {
			db = query.get(dbId);
		} catch (ParseException e) {
			//Failed to get cdtId TODO:what does this even mean, no connectivity?
			return ret;
		}
		if(db == null){//db is null. Not connected to internet?
			return ret;
		}
		//db loaded
		ret.add(db.getString("name"));
		ret.add(dbId);
		ret.add(db.getString("adminCode"));
		ret.add(db.getString("userCode"));
		ret.add(db.getString("graderCode"));
		ret.add(db.getString("updatedAt"));
		return ret;
	}
	
	public static ArrayList<ArrayList<String>> getListDb(){
		ArrayList<ArrayList<String>> ret = new ArrayList<ArrayList<String>>();
		//first get the dblist
		ParseObject dbList = null;
		ParseQuery<ParseObject> query = ParseQuery.getQuery("DBList");
		try {
			dbList = query.get(dbListID);
		} catch (ParseException e) {
			//Failed to get DBList TODO:what does this even mean, no connectivity?
			return ret;
		}
		if(dbList == null){//DBList is null. Not connected to internet?
			return ret;//TODO: sactuall handle this
		}	
		//We have a nonnull DBList so search it for a db with the existing name
		int dbNum = dbList.getInt("dbNum");
		if(dbNum != 0){
			for(int i = 1; i <= dbNum; i++){//stored as name then id
				String name = dbList.getString("db" + Integer.toString(i) + "Name");
				if(name != null){
					if(name.length() > 0 && !(name.equalsIgnoreCase("null"))){
						ArrayList<String> ret1 = new ArrayList<String>();
						ret1.add(dbList.getString("db" + Integer.toString(i) + "Name"));
						ret1.add(dbList.getString("db" + Integer.toString(i) + "Id"));
						ret.add(ret1);
					}
				}
			}
		}
		return ret;
	}
	
	public static ArrayList<ArrayList<String>> cdtList(String dbId){
		ParseObject db = null;
		ParseQuery<ParseObject> query = ParseQuery.getQuery("Database");
		try {
			db = query.get(dbId);
		} catch (ParseException e) {
			//Failed to get cdtId TODO:what does this even mean, no connectivity?
			return null;
		}
		if(db == null){//db is null. Not connected to internet?
			return null;
		}
		//got db, now get list of cdt
		ArrayList<ArrayList<String>> ret = new ArrayList<ArrayList<String>>();
		for(int i = 1; i <= db.getInt("cdtNum"); i++){
			if(!db.getString("cdt" + Integer.toString(i) + "Id").equals("null")){
				ArrayList<String> ret1 = new ArrayList<String>();
				//ret1.add(db.getString("cdt" + Integer.toString(i)));
				ParseObject cd = null;
				ParseQuery<ParseObject> cdq = ParseQuery.getQuery("Cadet");
				try {
					cd = cdq.get(db.getString("cdt" + Integer.toString(i) + "Id"));
					ret1.add(cd.getString("name"));
					ret1.add(db.getString("cdt" + Integer.toString(i) + "Id"));
					ret.add(ret1);
				} catch (ParseException e) {
					//nothing to do
				}

			}
		}
		return ret;
	}
	
	public static boolean editCdt(String cdtId, String name, String dob, String gender){
		ParseObject cdt = null;
		ParseQuery<ParseObject> query = ParseQuery.getQuery("Cadet");
		try {
			cdt = query.get(cdtId);
		} catch (ParseException e) {
			//Failed to get cdtId TODO:what does this even mean, no connectivity?
			return false;
		}
		if(cdt == null){//db is null. Not connected to internet?
			return false;
		}
		//have cdt now edit
		cdt.put("name", name);
		cdt.put("dob", dob);
		cdt.put("gender", gender);
		try {
			cdt.save();
		} catch (ParseException e) {
			return false;
		}
		return true;
	}
	
	public static String getDbName(String dbId){
		ParseObject db = null;
		ParseQuery<ParseObject> query = ParseQuery.getQuery("Database");
		try {
			db = query.get(dbId);
		} catch (ParseException e) {
			//Failed to get dbId TODO:what does this even mean, no connectivity?
			return "null";
		}
		if(db == null){//DBList is null. Not connected to internet?
			return "null";
		}
		return db.getString("name");
	}
	
	// return one of the following strings: admin, grader, user, null
	// depending on code given.
	public static String linkDb(String dbId, String code){
		ParseObject db = null;
		ParseQuery<ParseObject> query = ParseQuery.getQuery("Database");
		try {
			db = query.get(dbId);
		} catch (ParseException e) {
			//Failed to get dbId TODO:what does this even mean, no connectivity?
			return "null";
		}
		if(db == null){//DBList is null. Not connected to internet?
			return "null";
		}
		String admin = db.getString("adminCode");
		String grader = db.getString("graderCode");
		String user = db.getString("userCode");
		if(admin.equals(code)){
			return "admin";
		}else if(grader.equals(code)){
			return "grader";
		}else if(user.equals(code)){
			return "user";
		}
		//else matches non of the codes
		return "null";
	}
	
	//to much effort to delete and its not worth it, just write over the cdt
	//name and id in the db and delete the cadet object?
	public static boolean deleteCdt(String dbId, String cdtId){
		ParseObject db = null;
		ParseQuery<ParseObject> query = ParseQuery.getQuery("Database");
		try {
			db = query.get(dbId);
		} catch (ParseException e) {
			//Failed to get cdtId TODO:what does this even mean, no connectivity?
			return false;
		}
		if(db == null){//db is null. Not connected to internet?
			return false;
		}
		//got db, now rewrite the cdt name and id
		for(int i = 1; i <= db.getInt("cdtNum"); i++){
			if(db.getString("cdt" + Integer.toString(i) + "Id").equals(cdtId)){
				db.put("cdt" + Integer.toString(i) + "Id", "null");
				db.put("cdt" + Integer.toString(i), "null");
				try {
					db.save();
				} catch (ParseException e) {
					return false;
				}
			}
		}
		//and delete the cdt object itself
		ParseObject cdt = null;
		ParseQuery<ParseObject> query2 = ParseQuery.getQuery("Cadet");
		try {
			cdt = query2.get(cdtId);
		} catch (ParseException e) {
			return false;
		}
		if(cdt == null){//DBList is null. Not connected to internet?
			return false;
		}
		try {
			cdt.delete();
		} catch (ParseException e) {
			return false;
		}
		
		return true;
	}
	
	public static ArrayList<String> getCdtInfo(String cdtId){
		ArrayList<String> ret = new ArrayList<String>();
		ParseObject cdt = null;
		ParseQuery<ParseObject> query = ParseQuery.getQuery("Cadet");
		try {
			cdt = query.get(cdtId);
		} catch (ParseException e) {
			//Failed to get dbId TODO:what does this even mean, no connectivity?
			return ret;
		}
		if(cdt == null){//DBList is null. Not connected to internet?
			return ret;//TODO: sactuall handle this
		}
		ret.add(cdt.getString("name"));
		ret.add(cdt.getString("dob"));
		ret.add(cdt.getString("gender"));
		
		return ret;
	}
	
	public static boolean addCdtEvent(String cdtId, String date){
		ParseObject cdt = null;
		ParseQuery<ParseObject> query = ParseQuery.getQuery("Cadet");
		try {
			cdt = query.get(cdtId);
		} catch (ParseException e) {
			//Failed to get cdtId TODO:what does this even mean, no connectivity?
			return false;
		}
		if(cdt == null){//db is null. Not connected to internet?
			return false;
		}
		//have cdt now edit
		int numEvent = cdt.getInt("eventNum");
		cdt.put("eventNum", numEvent+1);
		cdt.put("event" + (numEvent+1), date);
		cdt.put("event" + (numEvent+1) + "PU", 0);
		cdt.put("event" + (numEvent+1) + "SU", 0);
		cdt.put("event" + (numEvent+1) + "RU", 0);
		cdt.put("event" + (numEvent+1) + "LapNum", 0);
		try {
			cdt.save();
		} catch (ParseException e) {
			return false;
		}
		return true;
	}
	
	//return eventNum corresponding to date, or 0 if its not there
	public static int cdtGetEventNum(String cdtId, String date){
		ParseObject cdt = null;
		ParseQuery<ParseObject> query = ParseQuery.getQuery("Cadet");
		try {
			cdt = query.get(cdtId);
		} catch (ParseException e) {
			//Failed to get cdtId TODO:what does this even mean, no connectivity?
			return -1;
		}
		if(cdt == null){//db is null. Not connected to internet?
			return -1;
		}
		if(cdt.getInt("eventNum") == 0){
			return 0;
		}
		//now find event
		for(int i = 1; i <= cdt.getInt("eventNum"); i++){
			if(cdt.getString("event"+i).equalsIgnoreCase(date)){
				return i;
			}
		}
		return 0;
	}
	
	public static ArrayList<Integer> cdtGetScores(String cdtId, int eventNum){
		ArrayList<Integer> ret = new ArrayList<Integer>();
		ParseObject cdt = null;
		ParseQuery<ParseObject> query = ParseQuery.getQuery("Cadet");
		try {
			cdt = query.get(cdtId);
		} catch (ParseException e) {
			//Failed to get cdtId TODO:what does this even mean, no connectivity?
			return ret;
		}
		if(cdt == null){//db is null. Not connected to internet?
			return ret;
		}
		ret.add(cdt.getInt("event" + eventNum + "PU"));
		ret.add(cdt.getInt("event" + eventNum + "SU"));
		ret.add(Cadet.sToA(cdt.getInt("event" + eventNum + "RU")));
		int numLap = cdt.getInt("event"+eventNum+"LapNum");
		for(int i= 1; i <= numLap; i++){
			ret.add(cdt.getInt("event" + eventNum + "Lap" + i));
		}
		return ret;
	}
	
	public static String getCdtEvent(String cdtId, int eventNum){
		ParseObject cdt = null;
		ParseQuery<ParseObject> query = ParseQuery.getQuery("Cadet");
		try {
			cdt = query.get(cdtId);
		} catch (ParseException e) {
			//Failed to get cdtId TODO:what does this even mean, no connectivity?
			return "";
		}
		if(cdt == null){//db is null. Not connected to internet?
			return "";
		}

		return cdt.getString("event"+eventNum);
	}
	
	public static int getCdtEventNum(String cdtId){
		ParseObject cdt = null;
		ParseQuery<ParseObject> query = ParseQuery.getQuery("Cadet");
		try {
			cdt = query.get(cdtId);
		} catch (ParseException e) {
			//Failed to get cdtId TODO:what does this even mean, no connectivity?
			return -1;
		}
		if(cdt == null){//db is null. Not connected to internet?
			return -1;
		}

		return cdt.getInt("eventNum");
	}
	
	public static ArrayList<Integer> getCdtLaps(String cdtId, int eventNum){
		ArrayList<Integer> ret = new ArrayList<Integer>();
		ParseObject cdt = null;
		ParseQuery<ParseObject> query = ParseQuery.getQuery("Cadet");
		try {
			cdt = query.get(cdtId);
		} catch (ParseException e) {
			//Failed to get cdtId TODO:what does this even mean, no connectivity?
			return ret;
		}
		if(cdt == null){//db is null. Not connected to internet?
			return ret;
		}
		for(int i = 0; i < cdt.getInt("event" + eventNum + "LapNum"); i++){
			ret.add(cdt.getInt("event" + eventNum + "Lap" + i));
		}
		return ret;
	}
	
	public static boolean cdtAddPU(String cdtId, int eventNum, int score, String date){
		ParseObject cdt = null;
		ParseQuery<ParseObject> query = ParseQuery.getQuery("Cadet");
		try {
			cdt = query.get(cdtId);
		} catch (ParseException e) {
			//Failed to get cdtId TODO:what does this even mean, no connectivity?
			return false;
		}
		if(cdt == null){//db is null. Not connected to internet?
			return false;
		}
		//have cdt now edit
		if(eventNum == 0){//this event doesnt exist, so add new one
			int e = cdt.getInt("eventNum");
			cdt.put("eventNum", e+1);
			cdt.put("event"+(e+1)+"PU", 0);
			cdt.put("event"+(e+1)+"SU", 0);
			cdt.put("event"+(e+1)+"RU", 0);
			cdt.put("event"+(e+1)+"LapNum", 0);
			cdt.put("event"+(e+1)+"PU", score);
			cdt.put("event"+(e+1), date);

		}else{
			cdt.put("event"+eventNum+"PU", score);
		}
		try {
			cdt.save();
		} catch (ParseException e) {
			return false;
		}
		return true;
	}
	public static boolean cdtAddSU(String cdtId, int eventNum, int score, String date){
		ParseObject cdt = null;
		ParseQuery<ParseObject> query = ParseQuery.getQuery("Cadet");
		try {
			cdt = query.get(cdtId);
		} catch (ParseException e) {
			//Failed to get cdtId TODO:what does this even mean, no connectivity?
			return false;
		}
		if(cdt == null){//db is null. Not connected to internet?
			return false;
		}
		//have cdt now edit
		if(eventNum == 0){//this event doesnt exist, so add new one
			int e = cdt.getInt("eventNum");
			cdt.put("eventNum", e+1);
			cdt.put("event"+(e+1)+"PU", 0);
			cdt.put("event"+(e+1)+"SU", 0);
			cdt.put("event"+(e+1)+"RU", 0);
			cdt.put("event"+(e+1)+"LapNum", 0);
			cdt.put("event"+(e+1)+"SU", score);
			cdt.put("event"+(e+1), date);
		}else{
			cdt.put("event"+eventNum+"SU", score);
		}
		try {
			cdt.save();
		} catch (ParseException e) {
			return false;
		}
		return true;
	}
	public static boolean cdtAddRU(String cdtId, int eventNum, int time, ArrayList<Integer> laps, String date){
		ParseObject cdt = null;
		ParseQuery<ParseObject> query = ParseQuery.getQuery("Cadet");
		try {
			cdt = query.get(cdtId);
		} catch (ParseException e) {
			//Failed to get cdtId TODO:what does this even mean, no connectivity?
			return false;
		}
		if(cdt == null){//db is null. Not connected to internet?
			return false;
		}
		//have cdt now edit
		if(eventNum == 0){//event doesnt exist
			int e = cdt.getInt("eventNum");
			cdt.put("eventNum", e+1);
			cdt.put("event"+(e+1)+"PU", 0);
			cdt.put("event"+(e+1)+"SU", 0);
			cdt.put("event"+(e+1)+"RU", 0);
			cdt.put("event"+(e+1)+"LapNum", laps.size());
			cdt.put("event"+(e+1)+"RU", time);
			for(int i = 0; i < laps.size(); i++){
				cdt.put("event"+(e+1)+"Lap"+i, laps.get(i).intValue());
			}
			cdt.put("event"+(e+1), date);
		}else{
			int lapNum = laps.size();
			cdt.put("event"+eventNum+"LapNum", lapNum);
			for(int i = 0; i < lapNum; i++){
				cdt.put("event"+eventNum+"Lap"+i, laps.get(i).intValue());
			}
			cdt.add("event"+eventNum+"RU", time);
		}
		try {
			cdt.save();
		} catch (ParseException e) {
			return false;
		}
		return true;
	}
	public static boolean addCdt(String dbId, String name, String dob, String gender){
		//first get the dblist
		ParseObject db = null;
		ParseQuery<ParseObject> query = ParseQuery.getQuery("Database");
		try {
			db = query.get(dbId);
		} catch (ParseException e) {
			//Failed to get dbId TODO:what does this even mean, no connectivity?
			return false;
		}
		if(db == null){//DBList is null. Not connected to internet?
			return false;//TODO: sactuall handle this
		}
		
		int numCdt = db.getInt("cdtNum");
		ParseObject cdt = new ParseObject("Cadet");
		cdt.put("name", name);
		cdt.put("gender", gender);
		cdt.put("dob", dob);
		cdt.put("eventNum", 0);
		try {
			cdt.save();
		} catch (ParseException e) {
			return false;
		}
		//now link to the db
		db.put("cdtNum", numCdt+1);
		db.put("cdt" + (numCdt+1), name);
		db.put("cdt" + (numCdt+1) + "Id", cdt.getObjectId());
		try {
			db.save();
		} catch (ParseException e) {
			return false;
		}
		
		return true;
	}
	
	//makes a DB with name dbName and password pass. returns true on success
	public static boolean makeDB(String dbName, String adminCode, String graderCode, String userCode){
		//first get the dblist
		ParseObject dbList = null;
		ParseQuery<ParseObject> query = ParseQuery.getQuery("DBList");
		try {
			dbList = query.get(dbListID);
		} catch (ParseException e) {
			//Failed to get DBList TODO:what does this even mean, no connectivity?
			return false;
		}
		if(dbList == null){//DBList is null. Not connected to internet?
			return false;//TODO: sactuall handle this
		}
		
		//We have a nonnull DBList so search it for a db with the existing name
		int dbNum = dbList.getInt("dbNum");
		if(dbNum != 0){
			for(int i = 1; i <= dbNum; i++){
				if(dbList.getString("db" + Integer.toString(i) + "Name").equalsIgnoreCase(dbName)){
					return false;
				}
			}
		}
		//if we get there then the name is available so we go ahead and make it
		ParseObject db = new ParseObject("Database");
		db.put("name", dbName);
		db.put("adminCode", adminCode);
		db.put("graderCode", graderCode);
		db.put("userCode", userCode);
		db.put("cdtNum", 0);
		db.put("eventNum", 0);
		try {
			db.save();
		} catch (ParseException e) {
			//Failed to save
			return false;
		}
		//Now update the dblist
		dbList.put("dbNum", dbNum+1);
		dbList.put("db" + (dbNum+1) + "Name", dbName);
		dbList.put("db" + (dbNum+1) + "Id", db.getObjectId());
		try {
			dbList.save();
		} catch (ParseException e) {
			return false;
		}
		return true;
	}
	
}
