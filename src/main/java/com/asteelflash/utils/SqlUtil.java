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
import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by hunter.fei on 2018/7/17.
 */
@Component
public class SqlUtil {


  // 连接驱动
  private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";


  //静态代码块
  static {
    try {
      // 加载驱动
      Class.forName(DRIVER);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  public static List<Map<String, Object>> query(String sql) {
    return otherDatabaseQuery("jdbc:sqlserver://10.11.1.130:1433;database=afg_active_90", "sa",
        "Flash123",
        sql);
  }

  /*
   * 获取数据库连接并执行查询sql语句
   */
  public static List<Map<String, Object>> otherDatabaseQuery(String url, String userName,
      String password, String sql) {
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
          System.out.println("数据库连接关闭出错..");
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
  public static int otherDatabaseUpdate(String url, String userName, String password, String sql) {
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
          System.out.println("数据库连接关闭出错..");
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
