package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class CreateConnection 
{
	  private static final String dbClassName = "com.mysql.cj.jdbc.Driver";


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
	  }
	  public Connection returnConnection()
	  {
		  return c;
	  }

}

