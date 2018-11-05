package com.asteelflash.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hunter.fei on 2018/7/31.
 */
public class DB2Util {

  // 连接驱动
  private static final String DRIVER = "com.ibm.db2.jcc.DB2Driver";

  //静态代码块
  static {
    try {
      // 加载驱动
      Class.forName(DRIVER);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  /*
   * 获取数据库连接并执行查询sql语句
   */
  public static List<Map<String, Object>> db2Query(String url, String userName, String password, String sql) {
    Connection conn = null;
    ResultSet rs = null;
    Statement stmt = null;
    List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
    try {
      conn = DriverManager.getConnection(url, userName, password);
      stmt = conn.createStatement();
      //4.执行sql语句，获取查询结果，并输出
      rs = stmt.executeQuery(sql);
      ResultSetMetaData md = rs.getMetaData(); //获得结果集结构信息,元数据
      int columnCount = md.getColumnCount();   //获得列数
      while (rs.next()) {
        Map<String, Object> rowData = new HashMap<String, Object>();
        for (int i = 1; i <= columnCount; i++) {
          rowData.put(md.getColumnName(i), rs.getObject(i));
        }
        list.add(rowData);
      }
      return list;
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      if (conn != null) {
        try {
          conn.close();   //5.关闭数据库连接
        } catch (SQLException e) {
          System.out.println("数据库连接关闭出错");
        }
      }
      if (stmt != null) {
        try {
          stmt.close();
          stmt = null;
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
    return list;
  }

  /*
   * 获取数据库连接并执行update或insert或delete sql语句
   */
  public static int db2Update(String url, String userName, String password, String sql) {
    Connection conn = null;
    int rs = 0;
    Statement stmt = null;

    try {
      conn = DriverManager.getConnection(url, userName, password);
      stmt = conn.createStatement();
      //4.执行sql语句，获取查询结果，并输出
      rs = stmt.executeUpdate(sql);
      return rs;
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      if (conn != null) {
        try {
          conn.close();   //5.关闭数据库连接
        } catch (SQLException e) {
          System.out.println("数据库连接关闭出错");
        }
      }
      if (stmt != null) {
        try {
          stmt.close();
          stmt = null;
        } catch (Exception e) {
          e.printStackTrace();
          e.toString();
        }
      }
    }
    return rs;
  }

}
