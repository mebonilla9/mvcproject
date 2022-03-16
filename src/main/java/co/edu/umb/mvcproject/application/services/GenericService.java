/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.umb.mvcproject.application.services;

import co.edu.umb.mvcproject.application.exceptions.MvcProjectException;
import co.edu.umb.mvcproject.application.lasting.EMessage;
import co.edu.umb.mvcproject.persistence.daos.crud.GenericDao;
import co.edu.umb.mvcproject.persistence.db.DbConnection;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author dev_manuel
 */
public abstract class GenericService<T> {
  
  protected Connection cnn;
  protected GenericDao genericDao;
  protected boolean commit = true;
  
  public GenericService(Connection cnn){
    this.cnn = cnn;
  }
  
  public void save(T entity) throws MvcProjectException {
    try {
      genericDao.save(entity);
    } catch (SQLException e) {
      e.printStackTrace(System.err);
      DbConnection.rollback(cnn);
      throw new MvcProjectException(EMessage.INSERTION_ERROR);
    }
  }
  
  public void edit(T entity) throws MvcProjectException {
    try {
      genericDao.edit(entity);
    } catch (SQLException e) {
      e.printStackTrace(System.err);
      DbConnection.rollback(cnn);
      throw new MvcProjectException(EMessage.EDITION_ERROR);
    }
  }
  
  public List<T> findAll() throws MvcProjectException {
    try {
      return genericDao.findAll();
    } catch (SQLException e) {
      e.printStackTrace(System.err);
      DbConnection.rollback(cnn);
      throw new MvcProjectException(EMessage.QUERY_ERROR);
    }
  }
  
  public T findById(Integer id) throws MvcProjectException {
    try {
      return (T) genericDao.findById(id);
    } catch (SQLException e) {
      e.printStackTrace(System.err);
      DbConnection.rollback(cnn);
      throw new MvcProjectException(EMessage.QUERY_ERROR);
    }
  }
  
}
