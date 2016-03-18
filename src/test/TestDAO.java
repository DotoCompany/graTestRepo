package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.DBConnection;

public class TestDAO {
   private Connection conn;
   public TestDAO() {
      conn = DBConnection.getInstance().getConn();
   }
   public String[] searchDatabases() {
      String sql = "show databases;";
      PreparedStatement pstmt=null;
      List<String> arrayList =new ArrayList<String>();
      try {
         pstmt = conn.prepareStatement(sql);
         ResultSet rs = pstmt.executeQuery();
         while(rs.next()) {
            arrayList.add(rs.getString(1));
         }
      } catch(Exception ex) {
         ex.printStackTrace();
      } finally {
         try {
            pstmt.close();
         } catch (Exception ex) {
            ex.printStackTrace();
         }
      }
      return arrayList.toArray(new String[arrayList.size()]);
   }
   public static void main(String[]args) {
      String[] str = new TestDAO().searchDatabases();
      for(String tmp : str) {
         System.out.println(tmp);
      }
   }
}