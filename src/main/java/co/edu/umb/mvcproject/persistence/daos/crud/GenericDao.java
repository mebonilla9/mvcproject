/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.umb.mvcproject.persistence.daos.crud;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author dev_manuel
 */
public interface GenericDao<T> {

  void save(T entity) throws SQLException;

  void edit(T entity) throws SQLException;

  List<T> findAll() throws SQLException;

  T findById(Integer id) throws SQLException;
}
