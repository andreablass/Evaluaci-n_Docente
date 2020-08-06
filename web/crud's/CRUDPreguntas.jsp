<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="bean.BeanPregunta" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="bean.BeanAdministrador" %><%--
  Created by IntelliJ IDEA.
  User: Esmeralda Lara
  Date: 23/07/2020
  Time: 20:40
  To change this template use File | Settings | File Templates.
--%>
<%
    String context = request.getContextPath();
    List<BeanPregunta> preguntas = new ArrayList<>();

    if (request.getSession().getAttribute("preguntas") != null) {
        preguntas = (List) request.getSession().getAttribute("preguntas");
    }

    BeanAdministrador user = new BeanAdministrador();
    if (request.getSession().getAttribute("user") != null) {
        user = (BeanAdministrador) request.getSession().getAttribute("user");
    }
%>
<html>
<head>
    <title>Preguntas</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body>
<jsp:include page="headerMenu.jsp"/>

<center>
    <div class="p-3 mb-2 bg-success text-white">Preguntas</div>
</center>

<!--Tabla -->
<center>
    <table class="table table-hover">
        <thead>
        <tr>
            <th scope="col">Identificador de Pregunta</th>
            <th scope="col">Descripción</th>

        </tr>
        </thead>
        <tbody>
        <% for (BeanPregunta pregunta : preguntas) { %>
        <tr>
            <th scope="row"><%=pregunta.getId()%>
            </th>
            <td><%=pregunta.getDescripcion()%>
            </td>

        </tr>
        <% } %>
        </tbody>
    </table>
</center>

<br/>
<br/>
<br/>

<% if (user.getTipo() == 1) {%>
<div class="card-deck">
    <div class="card">
        <div class="card-body">
            <form action="<%=context%>/ServletPregunta">
                <h1>Agregar</h1>
                <input name="opcion" type="hidden" value="agregar">
                <div class="form-group">
                    <label>Identificador de pregunta</label>
                    <input name="id" type="text" class="form-control">
                </div>
                <div class="form-group">
                    <label>Descipción</label>
                    <input name="descripcion" type="text" class="form-control">
                </div>
                <div class="card-footer">
                    <small class="text-muted">
                        <button type="submit" class="btn btn-outline-success">Agregar</button>
                    </small>
                </div>
            </form>
        </div>
    </div>
    <div class="card">
        <div class="card-body">
            <form action="<%=context%>/ServletPregunta">
                <h1>Modificar</h1>
                <input name="opcion" type="hidden" value="modificar">
                <div class="form-group">
                    <label>Identificador de pregunta</label>
                    <input name="id" type="text" class="form-control">
                </div>
                <div class="form-group">
                    <label>Descipción</label>
                    <input name="descripcion" type="text" class="form-control">
                </div>
                <div class="card-footer">
                    <small class="text-muted">
                        <button type="submit" class="btn btn-outline-warning">Modificar</button>
                    </small>
                </div>
            </form>
        </div>

    </div>
    <div class="card">
        <div class="card-body">
            <form action="<%=context%>/ServletPregunta">
                <h1>Eliminar</h1>
                <input name="opcion" type="hidden" value="eliminar">
                <div class="form-group">
                    <label>Identificador de pregunta</label>
                    <input name="id" type="text" class="form-control">
                </div>
                <div class="card-footer">
                    <small class="text-muted">
                        <button type="submit" class="btn btn-outline-danger">Eliminar</button>
                    </small>
                </div>
            </form>
        </div>
    </div>
</div>

<%}%>
<br/>
<br/>
<br/>

</body>
</html>


