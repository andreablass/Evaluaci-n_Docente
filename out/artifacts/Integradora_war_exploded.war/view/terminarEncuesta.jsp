<%--
  Created by IntelliJ IDEA.
  User: luis
  Date: 7/26/2020
  Time: 5:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String context = request.getContextPath(); %>
<html>
<head>
    <title>Title</title>

</head>
<body>
<h1>Encuesta Finalizada</h1>
<form action="<%=context%>/ServletTerminarEncuesta" method="POST">
    <button type="submit">Finalizar encuesta</button>
</form>
</body>
</html>
