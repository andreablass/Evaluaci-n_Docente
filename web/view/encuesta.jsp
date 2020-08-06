<%@ page import="bean.BeanDocente" %>
<%@ page import="java.util.List" %>
<%@ page import="bean.BeanPregunta" %>
<%--
  Created by IntelliJ IDEA.
  User: luis
  Date: 7/21/2020
  Time: 7:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String context = request.getContextPath();
    String token = (String)request.getAttribute("token");
    String correo = (String)request.getAttribute("correo");
    List<BeanDocente> docentes = (List)request.getAttribute("docentes");
    List<BeanPregunta> preguntasN = (List)request.getAttribute("preguntasN");
    List<BeanPregunta> preguntasC = (List)request.getAttribute("preguntasC");
%>
<%
    int nameCounter = 0;
    int idCounter = 0;

    int docenteCounter = Integer.parseInt(request.getAttribute("index").toString());
    int idAlumno = Integer.parseInt(request.getAttribute("idAlumno").toString());
    int idPeriodo = Integer.parseInt(request.getAttribute("idPeriodo").toString());
    int idGrupo = Integer.parseInt(request.getAttribute("idGrupo").toString());
    int NumPreguntas = preguntasN.size();
%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body>
<div class="container col-md-10 offset-md-1">

    <form action="<%=context%>/ServletRegistroRespuestas" method="POST">
        <input name="idAlumno" type="hidden" value="<%=idAlumno%>">
        <input name="idPeriodo" type="hidden" value="<%=idPeriodo%>">
        <input name="idMaestro" type="hidden" value="<%=docentes.get(docenteCounter).getId_Matricula()%>">
        <input name="index" type="hidden" value="<%=docenteCounter%>">
        <input name="idGrupo" type="hidden" value="<%=idGrupo%>">
        <input id="inputNumPreguntas" type="hidden" value="<%=NumPreguntas%>">
        <p id="envioPuntuacion"></p>
        <div class="col-md-12">
        <table class="table table-bordered table-striped table-hover table-center"
               style="background-color:#5ED7A2;">
            <h4>
                <%=docentes.get(docenteCounter).getNombre()%> <%=docentes.get(docenteCounter).getApellido1()%>
                <%=docentes.get(docenteCounter).getApellido2()%>
            </h4>
            <tr>
                <th>Pregunta</th>
                <th>Muy malo</th>
                <th>Malo</th>
                <th>Regular</th>
                <th>Bien</th>
                <th>Muy bien</th>
            </tr>
            <tr>
                <% for(BeanPregunta asdf: preguntasN){ %>
                <%
                    nameCounter += 1;
                    idCounter += 1;
                %>
                <td><%=asdf.getId()%> <%=asdf.getDescripcion()%></td>
                <td><input type="radio" name="<%=nameCounter%>" value="2" id="1<%=nameCounter%>" />
                    </label>
                </td>
                <td>
                    <label>
                        <input type="radio" name="<%=nameCounter%>" value="4" id="2<%=nameCounter%>" />
                    </label>
                </td>
                <td>
                    <label>
                        <input type="radio" name="<%=nameCounter%>" value="6" id="3<%=nameCounter%>" />
                    </label>
                </td>
                <td>
                    <label>
                        <input type="radio" name="<%=nameCounter%>" value="8" id="4<%=nameCounter%>" />
                    </label>
                </td>
                <td>
                    <label>
                        <input type="radio" name="<%=nameCounter%>" value="10" id="5<%=nameCounter%>" />
                    </label>
                </td>
            </tr>
            <% } %>
        </table>
        <table class="table table-bordered table-striped table-hover" style="background-color:#5ED7A2;">
            <%
                int count = 1;
                for(BeanPregunta asdf: preguntasC){ %>
            <tr>
                <td><%=asdf.getId()%> <%=asdf.getDescripcion()%></td>

                <td>
                    <input name="id-<%=count%>" value="<%=asdf.getId()%>" type="hidden">
                    <textarea name="comentario-<%=count%>" rows="1" cols=60" style="resize: none;"></textarea>
                </td>
            </tr>
            <%
                count++;
                } %>
        </table>
            <div><button id="btnSumar" class="btn btn-danger btn-lg btn-block"><h2>Evaluar</h2></button></div>
    </div>

    </form>

</div>

<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
</body>
</html>
