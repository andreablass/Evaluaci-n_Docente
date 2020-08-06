<%@ page import="java.util.List" %>
<%@ page import="bean.BeanDocente" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dao.DaoDocente" %><%--
  Created by IntelliJ IDEA.
  User: luis
  Date: 7/30/2020
  Time: 7:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String context = request.getContextPath();
    List<BeanDocente> docentes = new ArrayList<BeanDocente>();
    DaoDocente daoDoc = new DaoDocente();
    docentes = daoDoc.consultarDocentes();

%>
<html>
<head>
    <title>Agregar grupo</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body>
<jsp:include page="headerMenu.jsp"/>

<div class="container">
    <div class="card-body">
        <form action="<%=context%>/ServletGrupo" method="POST">
        <h1 align="center">Agregar</h1>
        <input name="opcion" type="hidden" value="agregar">
            <div class="form-group">
                <label>Grupo(Nombre)</label>
                <input name="grupo" type="text" class="form-control">
            </div>
            <div class="form-group">
                <label>Número de alumnos</label>
                <input name="num_alum" type="text" class="form-control">
            </div>
            <div class="form-group">
                <label>Cuatrimestre</label>
                <input name="cuatrimestre" type="text" class="form-control">
            </div>
            <div class="form-group">
                <label>Carrera</label>
                <input name="carrera" type="text" class="form-control">
            </div>
        <% int j = 1; %>
        <% for(BeanDocente asdf: docentes){ %>

            <div class="form-group">
                <div class="form-check">
                    <input name="<%=j%>" value="<%=asdf.getId_Matricula()%>" type="radio" class="form-check-input">
                    <label class="form-check-label"><%=asdf.getNombre()%> <%=asdf.getApellido1()%> <%=asdf.getApellido2()%></label>
                </div>
            </div>
                <% j++; %>
        <% } %>
        <div class="card-footer">
            <small class="text-muted"><button type="submit" class="btn btn-outline-success">Agregar</button></small>
        </div>
        </form>
    </div>
</div>
</body>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>

</html>
