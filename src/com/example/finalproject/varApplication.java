package com.example.finalproject;

import android.app.Application;

public class varApplication extends Application{
	public String databaseId;
	public String authorization;
	public String databaseName;
	
	public String getName(){
		return databaseName;
	}
	
	public void setName(String s){
		databaseName = s;
	}
	
	public varApplication(){
		databaseId = "";
		authorization = "";
	}
	
	public String getAuth(){
		return authorization;
	}
	
	public void setAuth(String s){
		authorization = s;
	}
	
	public String getId(){
		return databaseId;
	}
	
	public void setId(String id){
		databaseId = id;
	}
}
