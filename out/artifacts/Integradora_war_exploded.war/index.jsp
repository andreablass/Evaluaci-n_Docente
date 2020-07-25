<%--
  Created by IntelliJ IDEA.
  User: luis
  Date: 7/20/2020
  Time: 5:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String context = request.getContextPath();
%>
<html>
  <head>
    <title>Inicio Sesión</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <link rel="stylesheet" href="css/estilosDeInicio.css">
  </head>
  <body background-image: linear-gradient( 109.6deg, rgba(0,110,141,1) 21%, rgba(145,200,76,1) 83% );>

  <div class="container login-container">
    <div class="row">
      <div class="col-md-6 login-form-1">
        <h3>Iniciar como Alumno</h3>
        <form action="<%=context%>/ServletRedireccionamiento" method="post">
          <div class="form-group">
            <input name="correo" type="email" class="form-control" placeholder="Correo">
          </div>
          <div class="form-group">
            <input name="token" type="text" class="form-control" placeholder="Token">
          </div>
          <div class="form-group">
            <button type="submit" class="btn btn-outline-light">Ingresar</button>
          </div>
        </form>
      </div>
    </div>
  </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>

  </body>
</html>
