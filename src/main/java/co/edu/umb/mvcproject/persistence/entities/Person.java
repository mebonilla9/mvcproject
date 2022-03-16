/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.umb.mvcproject.persistence.entities;

/**
 *
 * @author dev_manuel
 */
public class Person {
  
  private Integer id;
  private String document;
  private String name;
  private Integer state;

  public Person() {
  }

  public Person(String document, String name, Integer state) {
    this.document = document;
    this.name = name;
    this.state = state;
  }

  public Person(Integer id, String document, String name, Integer state) {
    this.id = id;
    this.document = document;
    this.name = name;
    this.state = state;
  }

  /**
   * @return the id
   */
  public Integer getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * @return the document
   */
  public String getDocument() {
    return document;
  }

  /**
   * @param document the document to set
   */
  public void setDocument(String document) {
    this.document = document;
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @return the state
   */
  public Integer getState() {
    return state;
  }

  /**
   * @param state the state to set
   */
  public void setState(Integer state) {
    this.state = state;
  }
  
  
}
