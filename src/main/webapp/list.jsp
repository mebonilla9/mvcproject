<%--
    Document   : list
    Created on : 11 mar. 2022, 19:14:42
    Author     : dev_manuel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <style>
      body{
        margin: 0 auto;
      }

      .composed-div{
        min-width: 50%;
        width: 60%
      }
    </style>
  </head>
  <body>
    <div class="container-fluid align-items-center">
      <div class="composed-div">
        <h3>Lista de personas</h3>
      </div>
      <div>
        <a class="btn btn-primary" href="../register.jsp">Registrar persona</a>
      </div>
      <div class="composed-div">
        <table class="table">
          <thead>
            <tr>
              <th>Id</th>
              <th>Nombre</th>
              <th>Documento</th>
              <th>Estado</th>
              <th>Acciones</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach items="${people}" var="person">
              <c:if test="${person.state == 1}">
                <tr>
                  <td><c:out value = "${person.id}"/></td>
                  <td><c:out value = "${person.name}"/></td>
                  <td><c:out value = "${person.document}"/></td>
                  <td><c:out value = '${person.state == 1 ? "activo" : "inactivo"}'/></td>
                  <td>
                    <a href="search?idPerson=${person.id}" class="btn btn-primary">Editar</a>
                    <a href="../confirm-delete.jsp?idPerson=${person.id}" class="btn btn-danger">Borrar</a>
                  </td>
                </tr>
              </c:if>
            </c:forEach>
          </tbody>
        </table>
      </div>
      <div>
        <c:if test="${!alertMessage.isEmpty()}">
          <div class="alert alert-dismissible alert-${alertType}" role="alert">
            <c:out value="${alertMessage}" />
          </div>
        </c:if>
      </div>
    </div>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  </body>
</html>
