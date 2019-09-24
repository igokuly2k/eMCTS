package database;
import java.sql.SQLException;
import java.sql.*;

import database.CreateConnection;
public class GetPassengerDatabase 
{
	int customer_id;
	long aadhar_id;
	String blood_group;
	String PIN;
	String fromplace;
	String toplace;
	Timestamp printdate;
	ResultSet rs;
	Statement stmt1,stmt;
	Connection c;
	public GetPassengerDatabase() throws SQLException,ClassNotFoundException
	{
		CreateConnection conn=new CreateConnection("root","root");
		c=conn.returnConnection();
		stmt=c.createStatement();
		stmt1=c.createStatement();	
	}
	public int getCustomerId() throws SQLException,ClassNotFoundException
	{
		String sql1="SELECT * FROM passenger ORDER BY customer_id DESC LIMIT 1";
	    ResultSet rs1=stmt1.executeQuery(sql1);		
	    rs1.next();
		customer_id=rs1.getInt("customer_id");
		return customer_id;
	}
	public long getAadharId(int cus_id) throws SQLException,ClassNotFoundException
	{
		String sql="SELECT * FROM passenger WHERE customer_id="+cus_id;
		rs=stmt.executeQuery(sql);
		rs.next();
		aadhar_id=rs.getInt("aadhar_no");
		return aadhar_id;
	}
	public String getFromPlace(int cus_id) throws SQLException,ClassNotFoundException
	{
		String sql="SELECT * FROM passengerhistory WHERE customer_id="+cus_id;
		rs=stmt.executeQuery(sql);
		rs.next();
		fromplace=rs.getString("fromplace");
		return fromplace;
	}
	public String getToPlace(int cus_id) throws SQLException,ClassNotFoundException
	{
		String sql="SELECT * FROM passengerhistory WHERE customer_id="+cus_id;
		rs=stmt.executeQuery(sql);
		rs.next();
		toplace=rs.getString("toplace");
		return toplace;
	}	
	public String getPIN(int cus_id) throws SQLException,ClassNotFoundException
	{
		String sql="SELECT * FROM passenger WHERE customer_id="+cus_id;
		rs=stmt.executeQuery(sql);
		rs.next();
		PIN=rs.getString("PIN");
		return PIN;
	}
	public String getBloodGroup(int cus_id) throws SQLException,ClassNotFoundException
	{
		String sql="SELECT * FROM passenger WHERE customer_id="+cus_id;
		rs=stmt.executeQuery(sql);
		rs.next();
		blood_group=rs.getString("blood_group");
		return blood_group;
	}
	public Timestamp getPrintTime(int cus_id) throws SQLException,ClassNotFoundException
	{
		String sql="SELECT * FROM passengerhistory WHERE customer_id="+cus_id;
		rs=stmt.executeQuery(sql);
		rs.next();
		printdate=rs.getTimestamp("printdate");
		return printdate;
	}
	public boolean validatePIN(int cus_id,int PIN) throws SQLException
	{
		String sql1="SELECT MD5("+PIN+") AS MD";
	    ResultSet rs1=stmt1.executeQuery(sql1);
	    rs1.next();
	    String MD5=rs1.getString("MD");
	    try {
			if(getPIN(cus_id).equals(MD5))
				return true;
			else
				return false;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return false;
	}
	public ResultSet getPassengerHistory(int cus_id) throws SQLException
	{
		String sql="SELECT * FROM passengerhistory WHERE customer_id="+cus_id;
		rs=stmt.executeQuery(sql);
		return rs;
	}
  
	
}
