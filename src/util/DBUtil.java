package util;

import java.sql.*;

public class DBUtil {
	 private static Connection conn;
	 
	    public static Connection getConnection() {
	        if( conn != null )
	            return conn;
	 
	       //אם לא קיים קונקשין
	         String url = "jdbc:postgresql://horton.elephantsql.com:5432/gqngyeht";
	    	 String username = "gqngyeht";
	    	 String password = "-x1PGHvGHbUWC-l8DVdyeXVk6Mb5gCBb";
	    	 
	    	 
	    	 try 
	         {
	             Class.forName("org.postgresql.Driver");
	             conn = DriverManager.getConnection(url, username, password);
	         }
	           
	    	 catch (ClassNotFoundException | java.sql.SQLException e) 
	         {
	 	            System.out.println(e.getMessage());
	 	     }
	 
	        return conn;
	    }
	 
	    public static void closeConnection( Connection toBeClosed ) {
	        if( toBeClosed == null )
	            return;
	        
	        
	        try {
	            toBeClosed.close();
	        } catch (SQLException e) {
	        	System.out.println(e.getMessage());
	        }
	    }
}

