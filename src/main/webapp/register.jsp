<%-- 
    Document   : register
    Created on : 15 mar. 2022, 14:13:11
    Author     : dev_manuel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
      <h2>Registrar Persona</h2>
      <div class="row">
        <form action="person/save" method="post">
          <div class="col-auto">
            <label class="form-label" for="txtName">Nombre</label>
            <input type="text" class="form-control" id="txtName" name="txtName" required/>
          </div>
          <div class="col-auto">
            <label class="form-label" for="txtDocument">Documento</label>
            <input type="text" class="form-control" id="txtDocument" name="txtDocument" required/>
          </div>
          <div class="col-auto">
            <button class="btn btn-primary" type="submit">Registrar</button>
            <button class="btn btn-warning" type="reset">Limpiar</button>
            <a href="person/list" class="btn btn-danger">Cancelar</a>
          </div>
        </form>
      </div>
    </div>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  </body>
</html>
