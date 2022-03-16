/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.umb.mvcproject.persistence.db;

import co.edu.umb.mvcproject.application.exceptions.MvcProjectException;
import co.edu.umb.mvcproject.application.lasting.EMessage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author dev_manuel
 */
public class DbConnection {

  public static Connection connect() throws MvcProjectException {
    try {
      Context ctx = new InitialContext();
      DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/MvcProjectDS");
      Connection cnn = ds.getConnection();
      /*Connection cnn = DriverManager.getConnection(
              "jdbc:postgresql://127.0.0.1:5432/management",
              "dbmanagement",
              "123456"
      );*/
      cnn.setAutoCommit(false);
      return cnn;
    } catch (SQLException | NamingException e) {
      throw new MvcProjectException(EMessage.DB_CONNECTION_ERROR);
    }
  }

  private static void disconnect(Connection cnn, PreparedStatement ps) {
    try {
      if (ps != null) {
        ps.close();
      }
      if (cnn != null) {
        cnn.close();
      }
    } catch (SQLException e) {
      // registrar en log
      e.printStackTrace(System.err);
    }
  }

  public static void disconnect(PreparedStatement ps) {
    disconnect(null, ps);
  }

  public static void disconnect(Connection cnn) {
    disconnect(cnn, null);
  }

  public static void rollback(Connection cnn) {
    try {
      cnn.rollback();
    } catch (SQLException e) {
      // registrar en log
      e.printStackTrace(System.err);
    }
  }

  public static void commit(Connection cnn) {
    try {
      cnn.commit();
    } catch (SQLException e) {
      // registrar en log
      e.printStackTrace(System.err);
    }
  }

}
