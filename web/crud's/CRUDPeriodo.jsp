<%@ page import="bean.BeanPeriodo" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="bean.BeanAdministrador" %>
<%--
  Created by IntelliJ IDEA.
  User: Esmeralda Lara
  Date: 23/07/2020
  Time: 20:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String context = request.getContextPath();

    List<BeanPeriodo> periodos = new ArrayList<>();
    if(request.getSession().getAttribute("periodos") != null){
        periodos = (List)request.getSession().getAttribute("periodos");
    }

    BeanAdministrador user = new BeanAdministrador();
    if (request.getSession().getAttribute("user") != null) {
        user = (BeanAdministrador) request.getSession().getAttribute("user");
    }
%>

<html>

<head>
    <title>Periodos</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>

<body>
<jsp:include page="headerMenu.jsp"/>

<center>
    <div class="p-3 mb-2 bg-success text-white">Periodos</div>
</center>

<!--Tabla -->
<center>
    <table class="table table-hover">
        <thead>
        <tr>
            <th scope="col">Id Periodo</th>
            <th scope="col">Nombre</th>
            <th scope="col">Fecha inicio</th>
            <th scope="col">Fecha fin</th>
            <th scope="col">Estado</th>
        </tr>
        </thead>
        <tbody>
        <% for(BeanPeriodo periodo: periodos){ %>
        <tr>
            <th scope="row"><%=periodo.getId()%></th>
            <td><%=periodo.getNombre()%></td>
            <td><%=periodo.getFecha_inicio()%></td>
            <td><%=periodo.getFecha_fin()%></td>
            <%if(periodo.getEstado()==1){%>
            <td>Activo</td>
            <%} else {%>
            <td>Inactivo</td>
            <%}%>
        </tr>
        <% } %>
        </tbody>
    </table>
</center>

<br />
<br />
<br />
<% if(user.getTipo() == 1){ %>
<div class="card-deck">
    <div class="card">
        <div class="card-body">
            <form action="<%=context%>/ServletPeriodo">
                <h1>Agregar</h1>
                <input name="opcion" type="hidden" value="agregar">
                <div class="form-group">
                    <label>Nombre</label>
                    <input name="nombre" type="text" class="form-control">
                </div>
                <div class="form-group">
                    <label>Fecha inicio</label>
                    <input name="fecha_inicio" type="date" class="form-control">
                </div>
                <div class="form-group">
                    <label>Fecha fin</label>
                    <input name="fecha_fin" type="date" class="form-control">
                </div>
                <div class="card-footer">
                    <small class="text-muted"><button type="submit" class="btn btn-outline-success">Agregar</button></small>
                </div>
            </form>
        </div>
    </div>
    <div class="card">
        <div class="card-body">
            <!--MODIFICAR-->
            <form action="<%=context%>/ServletPeriodo">
                <h1>Modificar</h1>
                <input name="opcion" type="hidden" value="modificar">
                <div class="form-group">
                    <label>Identificador de periodo</label>
                    <input name="id" type="text" class="form-control">
                </div>
                <div class="form-group">
                    <label>Nombre</label>
                    <input name="nombre" type="text" class="form-control">
                </div>
                <div class="form-group">
                    <label>Fecha inicio</label>
                    <input name="fecha_inicio" type="date" class="form-control">
                </div>
                <div class="form-group">
                    <label>Fecha fin</label>
                    <input name="fecha_fin" type="date" class="form-control">
                </div>
                <div class="form-group">
                    <label>Estado</label>
                    <select name="estado" class="form-control">
                        <option value="1">Activo</option>
                        <option value="0">Inactivo</option>
                    </select>
                </div>
                <div class="card-footer">
                    <small class="text-muted"><button type="submit" class="btn btn-outline-warning">Modificar</button></small>
                </div>
            </form>
        </div>
    </div>
    <div class="card">
        <div class="card-body">
            <form action="<%=context%>/ServletPeriodo" method="POST">
                <h1>Eliminar</h1>
                <input name="opcion" type="hidden" value="eliminar">
                <div class="form-group">
                    <label>Identificador de periodo</label>
                    <input name="id" type="text" class="form-control">
                </div>
                <div class="card-footer">
                    <small class="text-muted"><button type="submit" class="btn btn-outline-danger">Eliminar</button></small>
                </div>
            </form>
        </div>
    </div>
</div>
<% } %>
</body>
</html>


