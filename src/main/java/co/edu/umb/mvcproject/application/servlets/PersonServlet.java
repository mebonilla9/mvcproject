/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package co.edu.umb.mvcproject.application.servlets;

import co.edu.umb.mvcproject.application.exceptions.MvcProjectException;
import co.edu.umb.mvcproject.application.lasting.ERoute;
import co.edu.umb.mvcproject.application.services.PersonService;
import co.edu.umb.mvcproject.persistence.db.DbConnection;
import co.edu.umb.mvcproject.persistence.entities.Person;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

/**
 * @author dev_manuel
 */
@WebServlet(name = "PersonServlet",
  urlPatterns = {
    ERoute.Person.LIST,
    ERoute.Person.SAVE,
    ERoute.Person.EDIT,
    ERoute.Person.SEARCH,
    ERoute.Person.DELETE
  })
public class PersonServlet extends HttpServlet {

  /**
   * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
   * methods.
   *
   * @param request  servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException      if an I/O error occurs
   */
  protected void processRequest(HttpServletRequest request,
                                HttpServletResponse response){
    response.setContentType("text/html;charset=UTF-8");
    Connection cnn = null;
    PersonService personService;
    try {
      cnn = DbConnection.connect();
      personService = new PersonService(cnn);
      String path = switch (request.getServletPath()) {
        case ERoute.Person.LIST -> listPeople(personService, request);
        case ERoute.Person.SAVE -> savePerson(personService, request);
        case ERoute.Person.EDIT -> editPerson(personService, request);
        case ERoute.Person.DELETE -> deletePerson(personService, request);
        case ERoute.Person.SEARCH -> searchPerson(personService, request);
        default -> throw new AssertionError();
      };
      DbConnection.commit(cnn);
      request.getRequestDispatcher(path).forward(request, response);
    } catch (MvcProjectException | IOException | ServletException e) {
      e.printStackTrace(System.err);
    } finally {
      DbConnection.disconnect(cnn);
    }
  }

  // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

  /**
   * Handles the HTTP <code>GET</code> method.
   *
   * @param request  servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException      if an I/O error occurs
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Handles the HTTP <code>POST</code> method.
   *
   * @param request  servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException      if an I/O error occurs
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Returns a short description of the servlet.
   *
   * @return a String containing servlet description
   */
  @Override
  public String getServletInfo() {
    return "Short description";
  }// </editor-fold>

  private String listPeople(PersonService personService,
                            HttpServletRequest request) throws MvcProjectException,
    ServletException, IOException {
    List<Person> people = personService.findAll();
    request.setAttribute("people", people);
    return ERoute.Person.LIST_PAGE;
  }

  private String savePerson(PersonService personService,
                            HttpServletRequest request) throws MvcProjectException {
    Person person = new Person(
      request.getParameter("txtDocument"),
      request.getParameter("txtName"),
      1
    );
    personService.save(person);
    request.setAttribute("alertMessage", "Una nueva persona ha sido registrada");
    request.setAttribute("alertType", "success");
    return ERoute.Person.LIST;
  }

  private String editPerson(PersonService personService,
                            HttpServletRequest request) throws MvcProjectException {
    Person person = new Person(
      Integer.parseInt(request.getParameter("txtId")),
      request.getParameter("txtDocument"),
      request.getParameter("txtName"),
      Integer.parseInt(request.getParameter("cbxState"))
    );
    personService.edit(person);
    request.setAttribute("alertMessage", "Una persona ha sido editada");
    request.setAttribute("alertType", "primary");
    return ERoute.Person.LIST;
  }

  private String deletePerson(PersonService personService,
                              HttpServletRequest request) throws MvcProjectException,
    ServletException, IOException {
    Integer idPerson = Integer.parseInt(request.getParameter("idPerson"));
    Person person = personService.findById(idPerson);
    person.setState(0);
    personService.edit(person);
    request.setAttribute("alertMessage", "Una persona ha sido Borrada");
    request.setAttribute("alertType", "danger");
    return ERoute.Person.LIST;
  }

  private String searchPerson(PersonService personService,
                              HttpServletRequest request) throws MvcProjectException {
    Integer idPerson = Integer.parseInt(request.getParameter("idPerson"));
    Person person = personService.findById(idPerson);
    request.setAttribute("person", person);
    return ERoute.Person.EDIT_PAGE;
  }

}
