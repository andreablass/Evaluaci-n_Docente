<%@ page import="bean.BeanAdministrador" %>
<%@ page import="java.util.List" %>
<%@ page import="bean.BeanReporte" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="bean.BeanPeriodo" %>
<%@ page import="bean.BeanDocente" %><%--
  Created by IntelliJ IDEA.
  User: Esmeralda Lara
  Date: 23/07/2020
  Time: 20:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String context = request.getContextPath();
    BeanAdministrador user = new BeanAdministrador();

    if(request.getSession().getAttribute("user") != null ){
        user = (BeanAdministrador)request.getSession().getAttribute("user");
    }

    List<BeanReporte> reporteDefault = new ArrayList<>();
    if(request.getSession().getAttribute("datosReporteDefault") != null ){
        reporteDefault = (List<BeanReporte>) request.getSession().getAttribute("datosReporteDefault");
    }

    List<BeanPeriodo> periodos = new ArrayList<>();
    if(request.getSession().getAttribute("periodos") != null ){
        periodos = (List<BeanPeriodo>) request.getSession().getAttribute("periodos");
    }

    List<BeanDocente> profesores = new ArrayList<>();
    if(request.getSession().getAttribute("profesores") != null ){
        profesores = (List<BeanDocente>) request.getSession().getAttribute("profesores");
    }

%>
<html>
<head>
    <title>Reportes</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body>
<jsp:include page="headerMenu.jsp"/>

<center><div class="p-3 mb-2 bg-success text-white">Reportes</div></center>

<div class="card-deck">
<div class="card border-light mb-3" style="max-width: 25rem;">
    <div class="card-body">
        <form action="<%=context%>/ServletReporte" method="post">
            <input type="hidden" value="periodo" name="opcion">
            <div class="form-group">
                <label>Filtrar por periodo</label>
                <select name="idPeriodo" class="form-control" required>
                    <%for (BeanPeriodo periodo : periodos){%>
                        <option value="<%=periodo.getId()%>"><%=periodo.getNombre()%></option>
                    <%}%>
                </select>
            </div>
            <small class="text-muted"><button type="submit" class="btn btn-outline-danger"><h4>Consultar Reportes</h4></button></small>
        </form>
    </div>

    <br>

    <div class="card-body">
        <form action="<%=context%>/ServletReporte" method="post">
            <input type="hidden" value="profesor" name="opcion">
            <div class="form-group">
                <label>Filtrar por profesor</label>
                <select name="idProfesor" class="form-control" required>
                    <%for (BeanDocente profesor : profesores){%>
                    <option value="<%=profesor.getId_Matricula()%>"><%=profesor.getNombre() + " "+ profesor.getApellido1() +" "+ profesor.getApellido2() %></option>
                    <%}%>
                </select>
            </div>
            <small class="text-muted"><button type="submit" class="btn btn-outline-danger"><h4>Consultar Reportes</h4></button></small>
        </form>
    </div>

</div>
<!--Tabla -->
<center>


    <table class="table table-hover">
        <thead>
        <tr>
            <th scope="col">Periodo</th>
            <th scope="col">Matricula</th>
            <th scope="col">Profesor</th>
            <th scope="col">Num. preguntas</th>
            <th scope="col">Num. evaluadores</th>
            <th scope="col">Promedio</th>
        </tr>
        </thead>
        <tbody>
        <% for(BeanReporte dato: reporteDefault) {%>
            <tr>
                <td><%=dato.getPeriodo().getNombre()%></td>
                <td><%=dato.getDocente().getId_Matricula()%></td>
                <td style="<% if(dato.getPromedio() >=9 ){%> color: green <%}else {%> color: red;<%}%>"><%=dato.getDocente().getNombre()+" "+dato.getDocente().getApellido1()+" "+dato.getDocente().getApellido2()%></td>
                <td><%=dato.getNum_preguntas()%></td>
                <td><%=dato.getNum_alumnos()%></td>
                <td><%=dato.getPromedio()%></td>
            </tr>
        <%}%>
        </tbody>
    </table>
</center>
</div>


</body>
</html>

