package com.Api.Generics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtilities {
	 public static Connection con = null;
	 public static ResultSet result = null;
	 public static Driver driverRef;
	
	public void connectToDB() {
		
		try {
			driverRef = new Driver();
			DriverManager.registerDriver(driverRef);
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
	}
	
	
	public void closeDb() throws SQLException {
		con.close();
	}
	
	public ResultSet execyteQuery(String query) throws Throwable {
	
		try {
			// executing the query
			 result = con.createStatement().executeQuery(query);
			 return result;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			 
				
			
		}
		return result;
		
	}
		
	public   String executeQueryAndGetData(String query ,int columnName , String expectedData) throws Throwable{
		boolean flag = false;
		result = con.createStatement().executeQuery(query);
		String actualData=null;
		while (result.next()) {
			if(result.getString(columnName).equals(expectedData)) {
				actualData=result.getString(columnName);
				flag= true;
				break;
			}
		}

		if(flag==true) {
			System.out.println(expectedData + "===> data verified in data base table");
			return actualData;
		}else {
			System.out.println(columnName + "===> data not verified in data base table");
			return actualData;
		}
		
		
	}
	
}
