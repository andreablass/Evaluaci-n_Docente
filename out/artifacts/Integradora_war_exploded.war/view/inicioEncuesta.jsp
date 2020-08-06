<%--
  Created by IntelliJ IDEA.
  User: luis
  Date: 7/20/2020
  Time: 6:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String context = request.getContextPath(); %>
<%
    int idGrupo = Integer.parseInt(request.getSession().getAttribute("idGrupo").toString());
    String token = (String)request.getAttribute("token");
    String correo = (String)request.getAttribute("correo");
    int idAlumno = Integer.parseInt(request.getSession().getAttribute("idAlumno").toString());
    int idPeriodo = Integer.parseInt(request.getSession().getAttribute("idPeriodo").toString());
    int index = 0;
    int indexP = Integer.parseInt(request.getSession().getAttribute("index").toString());
    System.out.println(indexP);
    if(indexP != 0){
        index = Integer.parseInt(request.getSession().getAttribute("index").toString());
    }else
        index = 0;
    System.out.println(index);
%>
<html>
<head>
    <title>Este es el inicio encuesta</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body>
<div class="container">


    <form action="<%=context%>/ServletCargaDatos" method="post">
        <input name="index" type="hidden" value="<%=index%>">
        <input name="idAlumno" type="hidden" value="<%=idAlumno%>">
        <input name="token" type="hidden" value="<%=token%>">
        <input name="correo" type="hidden" value="<%=correo%>">
        <input name="idGrupo" type="hidden" value="<%=idGrupo%>">
        <input name="idPeriodo" type="hidden" value="<%=idPeriodo%>">
        <button class="btn btn-success" type="submit">Iniciar Encuesta</button>
    </form>

</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
</body>
</html>
