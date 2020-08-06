<%@ page import="bean.BeanAdministrador" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Esmeralda Lara
  Date: 23/07/2020
  Time: 20:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String context = request.getContextPath();

    List<BeanAdministrador> administradores = new ArrayList<>();
    if(request.getSession().getAttribute("administradores") != null){
        administradores = (List<BeanAdministrador>) request.getSession().getAttribute("administradores");
    }

    BeanAdministrador user = new BeanAdministrador();
    if (request.getSession().getAttribute("user") != null) {
        user = (BeanAdministrador) request.getSession().getAttribute("user");
    }
 %>
<html>
<head>
    <title>Administradores</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body>

<jsp:include page="headerMenu.jsp"/>


<center><div class="p-3 mb-2 bg-success text-white">Administradores</div></center>

<!--Tabla -->
<center>
    <table class="table table-hover">
        <thead>
        <tr>
            <th scope="col">Identificador de Administrador</th>
            <th scope="col">Nombre de usuario</th>
            <th scope="col">Nombre</th>
            <th scope="col">Apellido Paterno</th>
            <th scope="col">Apellido Materno</th>
            <th scope="col">Contraseña</th>
        </tr>
        </thead>
        <tbody>
            <% for(BeanAdministrador administrador: administradores){ %>
            <tr>
                <th scope="row"><%=administrador.getId()%></th>
                <td><%=administrador.getNombreUsuario()%></td>
                <td><%=administrador.getNombre()%></td>
                <td><%=administrador.getApellido1()%></td>
                <td><%=administrador.getApellido2()%></td>

                <% if(administrador.getTipo() == 1){%>
                 <td>Super</td>
                <%} else {%>
                 <td>Solo lectura</td>
                <%}%>
            </tr>
            <% } %>
        </tbody>
    </table>
</center>

<br/>
<br/>
<br/>
<% if(user.getTipo() == 1){ %>
<div class="card-deck">
    <div class="card">
        <form action="<%=context%>/ServletAdministrador" method="post">
            <div class="card-body">
                    <input name="opcion" type="hidden" value="agregar">
                    <div class="form-group">
                        <label for="nombreUsuario">Nombre de usuario</label>
                        <input id="nombreUsuario" name="nombreUsuario" type="text" class="form-control" >
                    </div>
                    <div class="form-group">
                        <label for="nombre">Nombre</label>
                        <input id="nombre" name="nombre" type="text" class="form-control" >
                    </div>
                    <div class="form-group">
                        <label for="apellido1">Apellido Paterno</label>
                        <input id="apellido1" name="apellido1" type="text" class="form-control" >
                    </div>
                    <div class="form-group">
                        <label for="apellido2">Apellido Materno</label>
                        <input id="apellido2" name="apellido2" type="text" class="form-control" >
                    </div>
                    <div class="form-group">
                        <label for="password">Contraseña</label>
                        <input id="password" name="password" type="password" class="form-control" >
                    </div>
                    <div class="form-group">
                        <label for="tipo">Tipo</label>
                        <select id="tipo" name="tipo" class="form-control" >
                            <option value="1">Super</option>
                            <option value="2">Solo lectura</option>
                        </select>
                    </div>

            </div>
            <div class="card-footer">
                <small class="text-muted"><button type="submit" class="btn btn-outline-success">Agregar</button></small>
            </div>
        </form>
    </div>
    <div class="card">
        <div class="card-body">
            <form action="<%=context%>/ServletAdministrador" method="post">
                <div class="card-body">
                    <input name="opcion" type="hidden" value="modificar">
                    <div class="form-group">
                        <label for="id">Id de usuario</label>
                        <input id="id" name="id" type="text" class="form-control" >
                    </div>
                    <div class="form-group">
                        <label for="nombreUsuario">Nombre de usuario</label>
                        <input id="nombreUsuario" name="nombreUsuario" type="text" class="form-control" >
                    </div>
                    <div class="form-group">
                        <label for="nombre">Nombre</label>
                        <input id="nombre" name="nombre" type="text" class="form-control" >
                    </div>
                    <div class="form-group">
                        <label for="apellido1">Apellido Paterno</label>
                        <input id="apellido1" name="apellido1" type="text" class="form-control" >
                    </div>
                    <div class="form-group">
                        <label for="apellido2">Apellido Materno</label>
                        <input id="apellido2" name="apellido2" type="text" class="form-control" >
                    </div>
                    <div class="form-group">
                        <label for="password">Contraseña</label>
                        <input id="password" name="password" type="password" class="form-control" >
                    </div>
                    <div class="form-group">
                        <label for="tipo">Tipo</label>
                        <select id="tipo" name="tipo" class="form-control" >
                            <option value="1">Super</option>
                            <option value="2">Solo lectura</option>
                        </select>
                    </div>

                </div>
                <div class="card-footer">
                    <small class="text-muted"><button type="submit" class="btn btn-outline-warning">Modificar</button></small>
                </div>
            </form>
        </div>
    </div>
    <div class="card">
        <form action="<%=context%>/ServletAdministrador" method="post">
            <div class="card-body">
                <input name="opcion" type="hidden" value="eliminar">

                <div class="form-group">
                    <label for="id">Identificador de Administrador</label>
                    <input id="id" name="id" type="text" class="form-control"  >
                </div>

        </div>
        <div class="card-footer">
            <small class="text-muted"><button type="submit" class="btn btn-outline-danger">Eliminar</button></small>
        </div>
        </form>
    </div>
</div>
<% } %>
</body>
</html>


