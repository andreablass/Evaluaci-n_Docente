<%@ page import="bean.BeanDocente" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="bean.BeanAdministrador" %><%--
  Created by IntelliJ IDEA.
  User: Esmeralda Lara
  Date: 23/07/2020
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String context = request.getContextPath();
    List<BeanDocente> docentes = new ArrayList<>();

    if (request.getSession().getAttribute("docentes") != null) {
        docentes = (List) request.getSession().getAttribute("docentes");
    }

    BeanAdministrador user = new BeanAdministrador();
    if (request.getSession().getAttribute("user") != null) {
        user = (BeanAdministrador) request.getSession().getAttribute("user");
    }

%>

<html>
<head>
    <title>Docentes</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body>
<jsp:include page="headerMenu.jsp"/>

<center><div class="p-3 mb-2 bg-success text-white">Docentes</div></center>
<!-- Tabla -->
<table class="table table-hover">
    <thead>
    <tr>
        <th scope="col">Matrícula</th>
        <th scope="col">Nombre</th>
        <th scope="col">Apellido Paterno</th>
        <th scope="col">Apellido Materno</th>
        <th scope="col">Estado</th>
    </tr>
    </thead>
    <tbody>
    <% for(BeanDocente docente: docentes){ %>
    <tr>
        <th scope="row"><%=docente.getId_Matricula()%></th>
        <td><%=docente.getNombre()%></td>
        <td><%=docente.getApellido1()%></td>
        <td><%=docente.getApellido2()%></td>
        <td><%=docente.getEstado()%></td>
    </tr>
    <% } %>
    </tbody>
</table>
<br/>
<br/>
<br/>

<% if (user.getTipo() == 1) {%>

<div class="card-deck">
    <div class="card">
        <div class="card-body">
            <form action="<%=context%>/ServletDocente" method="POST">
                <input name="opcion" type="hidden" value="agregar">
                <h1 align="center">Agregar</h1>
                <div class="form-group">
                    <label>Correo</label>
                    <input name="correo"type="text" class="form-control">
                </div>
                <div class="form-group">
                    <label>Nombre</label>
                    <input name="nombre" type="text" class="form-control">
                </div>
                <div class="form-group">
                    <label>Apellido  Paterno</label>
                    <input name="apellido1" type="text" class="form-control">
                </div>
                <div class="form-group">
                    <label>Apellido  Materno</label>
                    <input name="apellido2" type="text" class="form-control" >
                </div>
                <div class="form-group">
                    <label>Estado</label>
                    <input name="estado" type="numeric" class="form-control" >
                </div>
                <div class="card-footer">
                    <small class="text-muted"><button type="submit" class="btn btn-outline-success">Agregar</button></small>
                </div>
            </form>
        </div>
    </div>
    <div class="card">
        <div class="card-body">
            <form action="<%=context%>/ServletDocente">
                <input name="opcion" type="hidden" value="modificar">
                <h1 align="center">Modificar</h1>
                <div class="form-group">
                    <label>Correo</label>
                    <input name="correo" type="text" class="form-control">
                </div>
                <div class="form-group">
                    <label>Nuevo nombre</label>
                    <input name="nombre" type="text" class="form-control">
                </div>
                <div class="form-group">
                    <label>Nuevo apellido paterno</label>
                    <input name="apellido1" type="text" class="form-control"  >
                </div>
                <div class="form-group">
                    <label>Nuevo apellido materno</label>
                    <input name="apellido2" type="text" class="form-control" >
                </div>
                <div class="form-group">
                    <label>Nuevo estado</label>
                    <input name="estado" type="numeric" class="form-control" >
                </div>
                <div class="card-footer">
                    <small class="text-muted"><button type="submit" class="btn btn-outline-warning">Modificar</button></small>
                </div>
            </form>
        </div>
    </div>
    <div class="card">
        <div class="card-body">
            <form action="<%=context%>/ServletDocente" method="POST">
                <input name="opcion" type="hidden" value="eliminar">
                <h1 align="center">Eliminar</h1>
                <div class="form-group">
                    <label> Matricula</label>
                    <input name="correo" type="text" class="form-control">
                </div>
                <div class="card-footer">
                    <small class="text-muted"><button type="submit" class="btn btn-outline-danger">Eliminar</button></small>
                </div>
            </form>
        </div>
    </div>
</div>

<%}%>

</br></br></br>
</body>
</html>



