<%-- 
    Document   : edit
    Created on : 15 mar. 2022, 19:56:42
    Author     : dev_manuel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>JSP Page</title>
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  <style>
      body {
          margin: 0 auto;
      }

      .composed-div {
          min-width: 50%;
          width: 60%
      }
  </style>
</head>
<body>
<div class="container-fluid align-items-center">
  <h2>Registrar Persona</h2>
  <div class="row">
    <form action="edit" method="post">
      <div class="col-auto">
        <label class="form-label" for="txtName">Nombre</label>
        <input type="text" class="form-control" id="txtName" name="txtName" value="${person.name}" required/>
      </div>
      <div class="col-auto">
        <label class="form-label" for="txtDocument">Documento</label>
        <input type="text" class="form-control" id="txtDocument" name="txtDocument" value="${person.document}"
               required/>
      </div>
      <div class="col-auto">
        <div class="form-check">
          <input type="checkbox" class="form-check-input" id="cbxState" name="cbxState" onchange="checkState()"
                 checked="${person.state > 0}" value="${person.state}" required/>
          <label class="form-check-label" for="cbxState">Estado</label>
        </div>
      </div>
      <div class="col-auto">
        <button class="btn btn-primary" type="submit">Editar</button>
        <a href="person/list" class="btn btn-danger">Cancelar</a>
      </div>
      <input type="hidden" value="${person.id}" id="txtId" name="txtId"/>
    </form>
  </div>
</div>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
<script>
    function checkState() {
        const checked = document.getElementById('cbxState').checked;
        if (checked) {
            document.getElementById('cbxState').value = 1;
            return;
        }
        document.getElementById('cbxState').value = 0;
    }
</script>
</body>
</html>
