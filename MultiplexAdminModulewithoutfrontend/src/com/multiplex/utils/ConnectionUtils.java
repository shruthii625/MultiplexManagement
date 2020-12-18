package com.multiplex.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
  
public class ConnectionUtils {
  
   public static Connection getConnection() throws ClassNotFoundException, SQLException {
       String hostName = "localhost";
       String sid = "xe";
       String userName = "system";
       String password = "javapoint";
  
       return getConnection(hostName, sid, userName, password);
   }
  
   public static Connection getConnection(String hostName, String sid,String userName, String password) 
		   throws ClassNotFoundException,SQLException {
   
       Class.forName("oracle.jdbc.driver.OracleDriver");
       String connectionURL = "jdbc:oracle:thin:@" + hostName + ":1521:" + sid;
       Connection conn = DriverManager.getConnection(connectionURL, userName,
               password);
       return conn;
   }
}