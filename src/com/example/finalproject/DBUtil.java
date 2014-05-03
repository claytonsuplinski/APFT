package com.example.finalproject;

import java.util.ArrayList;

import android.content.Context;

import com.parse.*;

public class DBUtil {
	
	public static final String appId = "0Dz3pgtpqjqAxzIWo1xNbeYQyXoxvt5p39LxU58e";
	public static final String clientKey = "QYfZLiM6GGIDWDR3GIRg0jNjnrAXk7MI3RHrcjS5";
	public static final String dbListID = "QXfmmCx63v";
	
	public static boolean deleteDB(String dbId){
		//first load db
		ParseObject db = null;
		ParseQuery<ParseObject> query = ParseQuery.getQuery("Database");
		try {
			db = query.get(dbId);
			System.out.println("got here 55656");
		} catch (ParseException e) {
			//Failed to get cdtId TODO:what does this even mean, no connectivity?
			System.out.println("ParseException querying for dbId fffffffff?");
			return false;
		}
		if(db == null){//db is null. Not connected to internet?
			System.out.println("db is null");
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
			System.out.println("ParseException querying for dbList");
			return false;
		}
		if(dbList == null){//DBList is null. Not connected to internet?
			System.out.println("DBList is null");
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
			System.out.println("Failed to write dbList");
		}
		//then finally kill db
		try {
			db.delete();
		} catch (ParseException e) {
			System.out.println("Failed to kill db");
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
			System.out.println("got here 55656");
		} catch (ParseException e) {
			//Failed to get cdtId TODO:what does this even mean, no connectivity?
			System.out.println("ParseException querying for dbId fffffffff?");
			return ret;
		}
		if(db == null){//db is null. Not connected to internet?
			System.out.println("db is null");
			return ret;
		}
		//db loaded
		ret.add(db.getString("name"));
		ret.add(dbId);
		System.out.println("KERPOWWW: " + db.getString("objectId"));
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
			System.out.println("ParseException querying for dbList");
			return ret;
		}
		if(dbList == null){//DBList is null. Not connected to internet?
			System.out.println("DBList is null");
			return ret;//TODO: sactuall handle this
		}	
		System.out.println("now searching through the names in DBList");
		//We have a nonnull DBList so search it for a db with the existing name
		int dbNum = dbList.getInt("dbNum");
		System.out.println("getting dbnum");
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
			System.out.println("got here 1");
		} catch (ParseException e) {
			//Failed to get cdtId TODO:what does this even mean, no connectivity?
			System.out.println("ParseException querying for dbId fffffffff?");
			return null;
		}
		if(db == null){//db is null. Not connected to internet?
			System.out.println("db is null");
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
					System.out.println("Failed to query the cdt with that id");
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
			System.out.println("ParseException querying for cdtId?");
			return false;
		}
		if(cdt == null){//db is null. Not connected to internet?
			System.out.println("db is null");
			return false;
		}
		//have cdt now edit
		cdt.put("name", name);
		cdt.put("dob", dob);
		cdt.put("gender", gender);
		try {
			cdt.save();
		} catch (ParseException e) {
			System.out.println("Failed to write cdt edits");
			return false;
		}
		return true;
	}
	
	public static String getDbName(String dbId){
		ParseObject db = null;
		ParseQuery<ParseObject> query = ParseQuery.getQuery("Database");
		System.out.println("got here 2-1");
		try {
			db = query.get(dbId);
			System.out.println("got here 2-2");
		} catch (ParseException e) {
			//Failed to get dbId TODO:what does this even mean, no connectivity?
			System.out.println("ParseException querying for dbId");
			return "null";
		}
		if(db == null){//DBList is null. Not connected to internet?
			System.out.println("DBList is null");
			return "null";
		}
		return db.getString("name");
	}
	
	// return one of the following strings: admin, grader, user, null
	// depending on code given.
	public static String linkDb(String dbId, String code){
		ParseObject db = null;
		ParseQuery<ParseObject> query = ParseQuery.getQuery("Database");
		System.out.println("got here 2-1");
		try {
			db = query.get(dbId);
			System.out.println("got here 2-2");
		} catch (ParseException e) {
			//Failed to get dbId TODO:what does this even mean, no connectivity?
			System.out.println("ParseException querying for dbId");
			return "null";
		}
		if(db == null){//DBList is null. Not connected to internet?
			System.out.println("DBList is null");
			return "null";
		}
		System.out.println("got here 2-3");
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
		System.out.println("got here 2-4");
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
			System.out.println("got here 1");
		} catch (ParseException e) {
			//Failed to get cdtId TODO:what does this even mean, no connectivity?
			System.out.println("ParseException querying for dbId fffffffff?");
			return false;
		}
		if(db == null){//db is null. Not connected to internet?
			System.out.println("db is null");
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
			System.out.println("got here 2323232323");
		} catch (ParseException e) {
			//Failed to get cdtId TODO:what does this even mean, no connectivity?
			System.out.println("ParseException querying for cdtId");
			return false;
		}
		if(cdt == null){//DBList is null. Not connected to internet?
			System.out.println("cdt is null");
			return false;
		}
		try {
			cdt.delete();
		} catch (ParseException e) {
			System.out.println("failed to delete cdt");
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
			System.out.println("got here 1");
		} catch (ParseException e) {
			//Failed to get dbId TODO:what does this even mean, no connectivity?
			System.out.println("ParseException querying for dbId");
			return ret;
		}
		if(cdt == null){//DBList is null. Not connected to internet?
			System.out.println("DBList is null");
			return ret;//TODO: sactuall handle this
		}
		ret.add(cdt.getString("name"));
		ret.add(cdt.getString("dob"));
		ret.add(cdt.getString("gender"));
		
		return ret;
	}
	
	public static boolean addCdt(String dbId, String name, String dob, String gender){
		//first get the dblist
		ParseObject db = null;
		ParseQuery<ParseObject> query = ParseQuery.getQuery("Database");
		try {
			db = query.get(dbId);
			System.out.println("got here 1");
		} catch (ParseException e) {
			//Failed to get dbId TODO:what does this even mean, no connectivity?
			System.out.println("ParseException querying for dbId");
			return false;
		}
		if(db == null){//DBList is null. Not connected to internet?
			System.out.println("DBList is null");
			return false;//TODO: sactuall handle this
		}
		
		int numCdt = db.getInt("cdtNum");
		ParseObject cdt = new ParseObject("Cadet");
		cdt.put("name", name);
		cdt.put("gender", gender);
		cdt.put("dob", dob);
		try {
			cdt.save();
		} catch (ParseException e) {
			System.out.println("Failed to write cdt");
			return false;
		}
		//now link to the db
		db.put("cdtNum", numCdt+1);
		db.put("cdt" + (numCdt+1), name);
		db.put("cdt" + (numCdt+1) + "Id", cdt.getObjectId());
		try {
			db.save();
		} catch (ParseException e) {
			System.out.println("failed to write to db");
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
			System.out.println("got here 1");
		} catch (ParseException e) {
			//Failed to get DBList TODO:what does this even mean, no connectivity?
			System.out.println("ParseException querying for dbList");
			return false;
		}
		if(dbList == null){//DBList is null. Not connected to internet?
			System.out.println("DBList is null");
			return false;//TODO: sactuall handle this
		}
		
		System.out.println("now searching through the names in DBList");
		//We have a nonnull DBList so search it for a db with the existing name
		int dbNum = dbList.getInt("dbNum");
		System.out.println("getting dbnum");
		if(dbNum != 0){
			for(int i = 1; i <= dbNum; i++){
				if(dbList.getString("db" + Integer.toString(i) + "Name").equalsIgnoreCase(dbName)){
					return false;
				}
			}
		}
		System.out.println("making new db");
		//if we get there then the name is available so we go ahead and make it
		ParseObject db = new ParseObject("Database");
		db.put("name", dbName);
		db.put("adminCode", adminCode);
		db.put("graderCode", graderCode);
		db.put("userCode", userCode);
		db.put("cdtNum", 0);
		db.put("eventNum", 0);
		System.out.println("writing new db");
		try {
			db.save();
		} catch (ParseException e) {
			//Failed to save
			System.out.println("Failed to save");
			return false;
		}
		System.out.println("success");
		//Now update the dblist
		System.out.println("yoyoyoy " + db.getObjectId());
		dbList.put("dbNum", dbNum+1);
		dbList.put("db" + (dbNum+1) + "Name", dbName);
		dbList.put("db" + (dbNum+1) + "Id", db.getObjectId());
		System.out.println("yo2");
		try {
			dbList.save();
			System.out.println("yo3");
		} catch (ParseException e) {
			System.out.println("Failed to update db");
			return false;
		}
		System.out.println("yo4");
		return true;
	}
	
}
