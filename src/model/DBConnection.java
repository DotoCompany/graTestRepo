package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
   private Connection conn;
   public static final DBConnection dbConnection;
   static {
      dbConnection = new DBConnection();
   }
   public Connection getConn() {
      return conn;
   }
   public static DBConnection getInstance() {
      return dbConnection;
   }
   private DBConnection() {
      try {
         Class.forName("com.mysql.jdbc.Driver");
         //conn = DriverManager.getConnection("jdbc:mysql://172.31.132.183:3306/graduationRepo","root","0000");
         conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/recallDB","recall","recallpwd");
         conn.setAutoCommit(false);
         
      } catch (Exception ex) {
         ex.printStackTrace();
      }
   }
   public static void main(String [] args) {
      DBConnection.getInstance();
   }
}