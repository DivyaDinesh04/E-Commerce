package com.genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtils {

	Connection con = null;
	
	/**
	 * This method is used to register driver and get database connection
	 * @throws SQLException
	 */
	public void getRegisterAndConnection() throws SQLException
	{
		//Register driver
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		//get connection
		con = DriverManager.getConnection(IPathConstants.DBUrl,IPathConstants.DBUsername, IPathConstants.DBPassword);
		
	}
	 
	
	/**
	 * This method is used to execute the query and return the matching data
	 * @param query
	 * @param columnindex
	 * @param expData
	 * @throws SQLException
	 */
	public void executeQueryAndGetData(String query, int columnindex, String expData) throws SQLException
	{
		String data = null;
		boolean flag = false;
		ResultSet result = con.createStatement().executeQuery(query);
		while(result.next())
		{
			data= result.getString(columnindex);
			if(data.equalsIgnoreCase(expData))
			{
				flag=true;
				break;
			}
		}
		if(flag)
		{
			System.out.println(data+" data verified");
		}
		else {
			System.out.println("data not verified");
		}
	}
	
	/**
	 * This method is used to close DB connection
	 * @throws SQLException
	 */
	public void closeDB() throws SQLException
	{
		con.close();
	}
	
}
