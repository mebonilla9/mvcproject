/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.umb.mvcproject.persistence.daos;

import co.edu.umb.mvcproject.persistence.daos.crud.PersonCrud;
import java.sql.Connection;

/**
 *
 * @author dev_manuel
 */
public class PersonDao extends PersonCrud{
  
  public PersonDao(Connection cnn){
    super(cnn);
  }
  
}
