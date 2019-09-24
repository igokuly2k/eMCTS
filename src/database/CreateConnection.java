package database;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
public class CreateConnection 
{
	  private static final String dbClassName = "com.mysql.jdbc.Driver";


	  private static final String CONNECTION =
	                          "jdbc:mysql://127.0.0.1/emcts";
	  
	  private Connection c;
	  public CreateConnection(String user,String password) throws SQLException,ClassNotFoundException
	  {
	    Class.forName(dbClassName);

	    Properties p = new Properties();
	    p.put("user",user);
	    p.put("password",password);

	    // Now try to connect
	    c = DriverManager.getConnection(CONNECTION,p);
	    Statement stmt=c.createStatement();
	    DatabaseMetaData dbm = c.getMetaData();
	    ResultSet tables = dbm.getTables(null, null, "passenger", null);
	    if(!(tables.next()))
	    {
	 	  String sql="CREATE TABLE passenger(customer_id INT NOT NULL AUTO_INCREMENT,aadhar_no BIGINT NOT NULL UNIQUE,blood_group VARCHAR(3) NOT NULL,PIN CHAR(32) NOT NULL,INDEX `idx_md5` (PIN),PRIMARY KEY(customer_id));";
	 	  stmt.executeUpdate(sql);
	    }
	    tables = dbm.getTables(null, null, "passengerhistory", null);
	    if(!(tables.next()))
	    {
	 	  String sql="CREATE TABLE passengerhistory(id INT NOT NULL AUTO_INCREMENT,customer_id INT NOT NULL,fromplace VARCHAR(40),toplace VARCHAR(40),printdate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,PRIMARY KEY(id));";
	 	  stmt.executeUpdate(sql);
	    }
	 	}
		  
	  public Connection returnConnection() throws SQLException,ClassNotFoundException
	  {
		  return c;
	  }

}

