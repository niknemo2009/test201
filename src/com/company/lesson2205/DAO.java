package com.company.lesson2205;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public interface DAO<T> {

    int create(T entity) throws SQLException;
      boolean update(T updEntity);
      boolean delete(int keyEntity);
  default    Connection getConnection(String url,String driver,String user,String password){
//      String usrName = "root";
//      String pwd = "1234";
//      String url = "jdbc:mysql://localhost:3306/";
      Connection result = null;

      try {
         // Class.forName("com.mysql.jdbc.Driver");
          Class.forName(driver);
      } catch (ClassNotFoundException ex) {
          System.out.println("Class not found!");
      }
      try{
          result = DriverManager.getConnection(url, user, password);
          System.out.println("Connected!");
      }
      catch(SQLException e){
          System.out.println("Error! " + e.getMessage());
      }
return result;
  }
      List<T> getAll();
}
