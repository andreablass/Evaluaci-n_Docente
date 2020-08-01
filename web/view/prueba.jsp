<%--
  Created by IntelliJ IDEA.
  User: luis
  Date: 7/24/2020
  Time: 10:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
String puntaje = (String)request.getAttribute("puntaje");
%>
<html>
<head>
    <title><%=puntaje%></title>
</head>
<body>
<%=puntaje%>
<p></p>
</body>
</html>
