<%@ page import="modelo.BeanDocente" %>
<%@ page import="java.util.List" %>
<%@ page import="modelo.BeanPregunta" %><%--
  Created by IntelliJ IDEA.
  User: luis
  Date: 7/21/2020
  Time: 7:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String token = (String)request.getAttribute("token");
    String correo = (String)request.getAttribute("correo");
    List<BeanDocente> docentes = (List)request.getAttribute("docentes");
    List<BeanPregunta> preguntas = (List)request.getAttribute("docentes");

%>
<html>
<head>

    <title>Title</title>
</head>
<body>

<% for(BeanDocente asdf: docentes){%>
<p>
    <%=asdf.getNombre()%> <%=asdf.getApellidoM()%>
</p>
<% } %>

<p><%=token%><%=correo%></p>
<p>prueba encuesta</p>
</body>
</html>
