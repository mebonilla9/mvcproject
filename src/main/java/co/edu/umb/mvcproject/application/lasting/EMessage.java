/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.umb.mvcproject.application.lasting;

/**
 *
 * @author dev_manuel
 */
public enum EMessage {

  INSERTED(1, "Se insertó correctamente"),
  EDITED(1, "Se modificó correctamente"),
  DELETED(1, "Se eliminó correctamente"),
  QUERIED(1, "Se consulto correctamente"),
  NO_RESULT(0, "No se encontraron  registros"),
  INSERTION_ERROR(-1, "Error al insertar el registro"),
  EDITION_ERROR(-1, "Error al modificar el registro"),
  QUERY_ERROR(-1, "Error al consultar el registro"),
  DELETE_ERROR(-1, "Error al consultar el registro"),
  REGISTERED_DATA_ERROR_(-1, "El registro ya existe"),
  DB_CONNECTION_ERROR(-2, "No hay conexión con la base de datos");

  private Integer code;
  private String description;

  private EMessage(Integer code, String description) {
    this.code = code;
    this.description = description;
  }

  /**
   * @return the code
   */
  public Integer getCode() {
    return code;
  }

  /**
   * @param code the code to set
   */
  public void setCode(Integer code) {
    this.code = code;
  }

  /**
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * @param description the description to set
   */
  public void setDescription(String description) {
    this.description = description;
  }
  
  
}
