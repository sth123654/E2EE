import java.sql.*;
import java.io.*;
import java.lang.Throwable;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import com.microsoft.sqlserver.jdbc.SQLServerResultSet;

public class connectURL 
{
	private boolean Debug = true;
	static private String ErrorString ="";
  public static void main(String[] args) 
	{
			  //SQL 認證
		    //String connectionUrl = "jdbc:sqlserver://192.168.8.150:1433;databaseName=HSBC;user=sth;password=123123;applicationName=sth_tools;";
			//String connectionUrl = "jdbc:sqlserver://172.30.197.146:1433;databaseName=AGRIBANK_HCE;user=sth;password=123123;applicationName=sth_tools;encrypt=true;trustServerCertificate=true";
			String connectionUrl = "jdbc:sqlserver://172.30.197.146:1433;databaseName=AGRIBANK_HCE;user=sth;password=123123;applicationName=sth_tools;encrypt=true;trustServerCertificate=false";


				//Declare the JDBC objects.
				Connection con = null;
			
		  	try 
		  	{
		  				//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //sqljdbc4.jar
              con = DriverManager.getConnection(connectionUrl);
		  				//con = DriverManager.getConnection(connectionUrl,"administrator","23039836");
		  				//con = DriverManager.getConnection(connectionUrl,"NI185/administrator","23039836");
		      		//con = DriverManager.getConnection(connectionUrl,"sa","123456");
		          //con = DriverManager.getConnection(connectionUrl,"postgres","123456");
		          
		          if(con != null)
		          {
		              System.out.println("Connection OK");
		              //RunSQL(con,getSerialSQL("MSSQL",""));
									//RunSQL(con,getSystemTableSQL("MSSQL","doc",""));
									//RunSQL(con,getMainTableSQL("MSSQL","doc",""));
				      }
				      else
				      {
				      		System.out.println("Connection Error");	
				      }
		  	}
		        
				// Handle any errors that may have occurred.
				/*catch(java.lang.ClassNotFoundException e)
			  {
			  	   e.printStackTrace();
			  }*/
			  catch(java.sql.SQLException e)
			  {
				   do 
				   {
			         System.out.println("SQL STATE: " + e.getSQLState());
			         System.out.println("ERROR CODE: " + e.getErrorCode());
			         System.out.println("MESSAGE: " + e.getMessage());
			         System.out.println();
			         e = e.getNextException();
			      } while (e != null);

			  }
				catch(Exception e) 
				{
							e.printStackTrace();
				}
				finally 
				{
					    if (con != null) 
			    		try 
			    		{ 
			    			con.close(); 
			    			con = null;
			    		} 
			    		catch(Exception e) 
			    		{
			    		}
				}
	}
   
}

