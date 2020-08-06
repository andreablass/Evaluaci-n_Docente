<%@ page import="bean.BeanGrupo" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="bean.BeanAdministrador" %>
<%@ page import="bean.BeanDocente" %><%--
  Created by IntelliJ IDEA.
  User: Esmeralda Lara
  Date: 23/07/2020
  Time: 20:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String context = request.getContextPath();
    List<BeanGrupo> grupos = new ArrayList<>();

    List<BeanDocente> docentesActivos = new ArrayList<>();

    if (request.getSession().getAttribute("grupos") != null) {
        grupos = (List<BeanGrupo>) request.getSession().getAttribute("grupos");
    }

    BeanAdministrador user = new BeanAdministrador();
    if (request.getSession().getAttribute("user") != null) {
        user = (BeanAdministrador) request.getSession().getAttribute("user");
    }

    if (request.getSession().getAttribute("docentesActivos") != null) {
        docentesActivos = (List<BeanDocente>) request.getSession().getAttribute("docentesActivos");
    }


%>

<html>
<head>
    <title>Grupos</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body>
<jsp:include page="headerMenu.jsp"/>

<center><div class="p-3 mb-2 bg-success text-white">Grupos</div></center>
<!-- Tabla -->
<table class="table table-hover">
    <thead>
    <tr>
        <th scope="col">Identificador de Grupo</th>
        <th scope="col">Token</th>
        <th scope="col">Número de alumnos</th>
        <th scope="col">Completado</th>
        <th scope="col">Grupo</th>
        <th scope="col">Cuatrimestre</th>
        <th scope="col">Carrera</th>
        <th scope="col">Estado</th>
    </tr>
    </thead>
    <tbody>
    <% for(BeanGrupo grupo: grupos){ %>
    <tr>
        <th scope="row"><%=grupo.getId_grupo()%></th>
        <td><%=grupo.getToken()%></td>
        <td><%=grupo.getNum_Alum()%></td>
        <td><%=grupo.getCompletado()%></td>
        <td><%=grupo.getGrupo()%></td>
        <td><%=grupo.getCuatrimestre()%></td>
        <td><%=grupo.getCarrera()%></td>

        <%if(grupo.getEstado()){%>
         <td>Activo</td>
        <%} else {%>
         <td>Inactivo</td>
        <%}%>
    </tr>
    <% } %>
    </tbody>
</table>
<br/>
<br/>
<br/>

<% if (user.getTipo() == 1) {%>

<div class="container">
    <div class="card-deck">
        <div class="card">
            <div class="card-body">
                <form action="<%=context%>/ServletGrupo" method="POST">
                    <!--AGREGAR-->
                    <h1 align="center">Agregar</h1>
                    <input name="opcion" type="hidden" value="agregar">
                    <div class="form-group">
                        <label for="formGroupExampleInput2">Número de alumnos</label>
                        <input name="num_alum" type="text" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="formGroupExampleInput2">Grupo</label>
                        <input name="grupo" type="text" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="formGroupExampleInput2">Cuatrimestre</label>
                        <input name="cuatrimestre" type="text" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="formGroupExampleInput2">Carrera</label>
                        <input name="carrera" type="text" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="formGroupExampleInput2">Asignar Profesores</label>
                        <select name="profesores" class="mdb-select md-form" multiple>
                            <% for (BeanDocente docente: docentesActivos) {%>
                               <option value="<%=docente.getId_Matricula()%>"><%=docente.getNombre() + " " +docente.getApellido1() +" "+ docente.getApellido2()%></option>
                            <%}%>
                        </select>
                    </div>
                    <div class="card-footer">
                        <small class="text-muted"><button type="submit" class="btn btn-outline-success">Agregar</button></small>
                    </div>
                </form>
            </div>
        </div>
        <div class="card">
            <div class="card-body">
                <form action="<%=context%>/ServletGrupo" method="POST">
                    <!--MODIFICAR-->
                    <h1 align="center">Modificar</h1>
                    <input name="opcion" type="hidden" value="modificar">
                    <div class="form-group">
                        <label for="formGroupExampleInput2">Identificador</label>
                        <input name="id" type="text" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="formGroupExampleInput2">Número de alumnos</label>
                        <input name="num_alum" type="text" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="formGroupExampleInput2">Grupo</label>
                        <input name="grupo" type="text" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="formGroupExampleInput2">Cuatrimestre</label>
                        <input name="cuatrimestre" type="text" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="formGroupExampleInput2">Carrera</label>
                        <input name="carrera" type="text" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="profesores">Asignar Profesores</label>
                        <select id="profesores" name="profesores" class="mdb-select md-form" multiple>
                            <% for (BeanDocente docente: docentesActivos) {%>
                            <option value="<%=docente.getId_Matricula()%>"><%=docente.getNombre() + " " +docente.getApellido1() +" "+ docente.getApellido2()%></option>
                            <%}%>
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
                <form action="<%=context%>/ServletGrupo">
                    <h1 align="center">Eliminar</h1>
                    <input name="opcion" type="hidden" value="eliminar">
                    <div class="form-group">
                        <label for="formGroupExampleInput">Identificador de Grupo</label>
                        <input name="id" type="text" class="form-control">
                    </div>
                    <div class="card-footer">
                        <small class="text-muted"><button type="submit" class="btn btn-outline-danger">Eliminar</button></small>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<%}%>

</body>
</html>


