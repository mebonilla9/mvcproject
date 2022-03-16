/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.umb.mvcproject.persistence.daos.crud;

import co.edu.umb.mvcproject.persistence.db.DbConnection;
import co.edu.umb.mvcproject.persistence.entities.Person;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dev_manuel
 */
public class PersonCrud implements GenericDao<Person> {

  protected final int ID = 1;
  protected Connection cnn;

  public PersonCrud(Connection cnn) {
    this.cnn = cnn;
  }

  @Override
  public void save(Person entity) throws SQLException {
    PreparedStatement stmt = null;
    try {
      int i = 1;
      String sql = "INSERT INTO person(document, name, state) VALUES(?,?,?);";
      stmt = cnn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
      stmt.setObject(i++, entity.getDocument());
      stmt.setObject(i++, entity.getName());
      stmt.setObject(i++, ID);
      stmt.executeUpdate();

      ResultSet rs = stmt.getGeneratedKeys();

      if (rs.next()) {
        entity.setId(rs.getInt(ID));
      }
    } finally {
      DbConnection.disconnect(stmt);
    }
  }

  @Override
  public void edit(Person entity) throws SQLException {
    PreparedStatement stmt = null;
    try {
      int i = 1;
      String sql = "UPDATE person SET document = ?, name = ?, state = ? WHERE id = ?;";
      stmt = cnn.prepareStatement(sql);
      stmt.setObject(i++, entity.getDocument());
      stmt.setObject(i++, entity.getName());
      stmt.setObject(i++, entity.getState());
      stmt.setObject(i++, entity.getId());
      stmt.executeUpdate();
    } finally {
      DbConnection.disconnect(stmt);
    }
  }

  @Override
  public List<Person> findAll() throws SQLException {
    PreparedStatement stmt = null;
    List<Person> list = new ArrayList<>();
    try {
      String sql = "SELECT * FROM person;";
      stmt = cnn.prepareStatement(sql);
      ResultSet rs = stmt.executeQuery();
      while (rs.next()) {
        list.add(getObject(rs));
      }
    } finally {
      DbConnection.disconnect(stmt);
    }
    return list;
  }

  @Override
  public Person findById(Integer id) throws SQLException {
    PreparedStatement stmt = null;
    Person person = new Person();
    try {
      String sql = "SELECT * FROM person where id = ?;";
      stmt = cnn.prepareStatement(sql);
      stmt.setObject(ID, id);
      ResultSet rs = stmt.executeQuery();
      while (rs.next()) {
        person = getObject(rs);
      }
    } finally {
      DbConnection.disconnect(stmt);
    }
    return person;
  }

  protected Person getObject(ResultSet rs) throws SQLException {
    Person person = new Person();
    person.setId(rs.getInt("id"));
    person.setName(rs.getString("name"));
    person.setDocument(rs.getString("document"));
    person.setState(rs.getInt("state"));
    return person;
  }

}
