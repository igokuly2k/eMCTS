package database;
import java.sql.SQLException;
import java.sql.*;

import database.CreateConnection;
public class GetPassengerDatabase 
{
	int customer_id;
	int aadhar_id;
	String blood_group;
	String PIN;
	String fromplace;
	String toplace;
	Timestamp printdate;
	ResultSet rs;
	Statement stmt1;
	public GetPassengerDatabase() throws SQLException,ClassNotFoundException
	{
		CreateConnection conn=new CreateConnection("root","ibmxuse1A#@");
		Connection c=conn.returnConnection();
		Statement stmt=c.createStatement();
		stmt1=c.createStatement();
		String sql="SELECT * FROM passenger";
		rs=stmt.executeQuery(sql);	
	}
	public int getCustomerId() throws SQLException,ClassNotFoundException
	{
		customer_id=rs.getInt("customer_id");
		return customer_id;
	}
	public int getAadharId() throws SQLException,ClassNotFoundException
	{
		aadhar_id=rs.getInt("aadhar_id");
		return aadhar_id;
	}
	public String getFromPlace() throws SQLException,ClassNotFoundException
	{
		fromplace=rs.getString("fromplace");
		return fromplace;
	}
	public String getToPlace() throws SQLException,ClassNotFoundException
	{
		toplace=rs.getString("toplace");
		return toplace;
	}	
	public String getPIN() throws SQLException,ClassNotFoundException
	{
		toplace=rs.getString("toplace");
		return toplace;
	}
	public String getBloodGroup() throws SQLException,ClassNotFoundException
	{
		blood_group=rs.getString("blood_group");
		return blood_group;
	}
	public Timestamp getPrintTime() throws SQLException,ClassNotFoundException
	{
		printdate=rs.getTimestamp("printdate");
		return printdate;
	}
	public boolean validatePIN() throws SQLException
	{   PIN=rs.getString("PIN");
		String sql1="SELECT MD5("+PIN+") AS MD";
	    ResultSet rs1=stmt1.executeQuery(sql1);
	    String MD5=rs1.getString("MD");
	    if(PIN.equals(MD5))
	    	return true;
	    else
	    	return false;
	    
	}
  
	
}
