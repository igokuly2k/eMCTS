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
	public void setPassengerData(int customer_id,int aadhar_id,String blood_group,String PIN) throws SQLException,ClassNotFoundException
	{
		String sql="INSERT INTO passenger "+
	               "VALUES("+customer_id+aadhar_id+blood_group+"MD5(+"+PIN+")"+");";
		stmt.executeUpdate(sql);
	}
	public void setPassengerHistory(int customer_id,String fromplace,String toplace) throws SQLException,ClassNotFoundException
	{
	
		String sql="INSERT INTO passengerhistory "+
	               "VALUES("+customer_id+fromplace+toplace+");";
		stmt.executeUpdate(sql);
	}
}
