/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.umb.mvcproject.application.exceptions;

import co.edu.umb.mvcproject.application.lasting.EMessage;

/**
 *
 * @author dev_manuel
 */
public class MvcProjectException extends Exception {

  private Integer code;
  private String message;
  private Object data;
  
  public MvcProjectException(EMessage message){
    this.code = message.getCode();
    this.message = message.getDescription();
  }
  
  public MvcProjectException(EMessage message, Object data){
    this.code = message.getCode();
    this.message = message.getDescription();
    this.data = data;
  }
}
