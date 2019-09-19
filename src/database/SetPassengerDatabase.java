package database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import database.CreateConnection;

public class SetPassengerDatabase {
	Statement stmt;
	public SetPassengerDatabase() throws SQLException,ClassNotFoundException
	{
		CreateConnection conn=new CreateConnection("root","ibmxuse1A#@");
		Connection c=conn.returnConnection();
		stmt=c.createStatement();	
	}
	public void setPassengerData(long aadhar_id,String blood_group,int PIN) throws SQLException,ClassNotFoundException
	{
		String sql="INSERT INTO passenger (aadhar_no,blood_group,PIN) "+
	               "VALUES("+aadhar_id+","+"\""+blood_group+"\""+","+"MD5(\""+String.valueOf(PIN)+"\")"+");";
		stmt.executeUpdate(sql);
	}
	public void setPassengerHistory(int customer_id,String fromplace,String toplace) throws SQLException,ClassNotFoundException
	{
	
		String sql="INSERT INTO passengerhistory (customer_id,fromplace,toplace) "+
	               "VALUES("+customer_id+","+"\""+fromplace+"\""+","+"\""+toplace+"\""+");";
		stmt.executeUpdate(sql);
	}
}
