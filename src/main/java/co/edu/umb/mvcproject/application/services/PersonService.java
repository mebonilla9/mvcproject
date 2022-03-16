/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.umb.mvcproject.application.services;

import co.edu.umb.mvcproject.persistence.daos.PersonDao;
import co.edu.umb.mvcproject.persistence.entities.Person;
import java.sql.Connection;

/**
 *
 * @author dev_manuel
 */
public class PersonService extends GenericService<Person>{
  
  private final PersonDao personDao;
  
  public PersonService(Connection cnn){
    super(cnn);
    personDao = new PersonDao(cnn);
    genericDao = personDao;
  }
  
}
