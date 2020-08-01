<%--
  Created by IntelliJ IDEA.
  User: andre
  Date: 23/07/2020
  Time: 08:44 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Reportes</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body>
<center><div class="p-3 mb-2 bg-success text-white">Reportes</div></center>

<!--Tabla -->
<center>
    <table class="table table-hover">
        <span class="border border-success"></span>
        <thead>
        <tr>
            <th scope="col">Identificador de Reportes</th>
            <th scope="col">Identificador de Maestros</th>
            <th scope="col">Identificador de Periodos</th>
            <th scope="col">Número de evaluadores</th>
            <th scope="col">Promedio</th>
            <th scope="col">Estado</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <th scope="row">1</th>
            <td>2000dc110</td>
            <td>1</td>
            <td>30</td>
            <td>9.1</td>
            <td>1</td>
        </tr>
        <tr>
            <th scope="row">2</th>
            <td>2000dc110</td>
            <td>1</td>
            <td>30</td>
            <td>9.1</td>
            <td>1</td>
        </tr>
        <tr>
            <th scope="row">3</th>
            <td>2000dc110</td>
            <td>1</td>
            <td>30</td>
            <td>9.1</td>
            <td>1</td>
        </tr>
        <tr>
            <th scope="row">3</th>
            <td>2000dc110</td>
            <td>1</td>
            <td>30</td>
            <td>9.1</td>
            <td>1</td>
        </tr>
        <tr>
            <th scope="row">3</th>
            <td>2000dc110</td>
            <td>1</td>
            <td>30</td>
            <td>9.1</td>
            <td>1</td>
        </tr>
        </tbody>
    </table>
</center>

<!-- Botones -->
<center>
    <div class="card" style="width: 18rem; border: #132D5E" >
        <ul class="list-group list-group-flush">
            <li class="list-group-item"><button type="button" class="btn btn-outline-success">Agregar</button></li>
            <li class="list-group-item"><button type="button" class="btn btn-outline-warning">Modificar</button></li>
            <li class="list-group-item"><button type="button" class="btn btn-outline-danger">Eliminar</button></li>
        </ul>
    </div>
</center>
</body>
</html>
