<%--
  Created by IntelliJ IDEA.
  User: andre
  Date: 23/07/2020
  Time: 08:03 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Preguntas</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body>

    <center><div class="p-3 mb-2 bg-success text-white">Preguntas</div></center>

    <!--Tabla -->
    <center>
    <table class="table table-hover">
        <span class="border border-success"></span>
        <thead>
        <tr>
            <th scope="col">Identificador de Pregunta</th>
            <th scope="col">Descripcción</th>

        </tr>
        </thead>
        <tbody>
        <tr>
            <th scope="row">1</th>
            <td>¿El o la Docente asistió regularmente a clase y fue puntual?</td>

        </tr>
        <tr>
            <th scope="row">2</th>
            <td>¿Su forma de explicar proporcionó una idea clara del conocimiento profundo y actualizado sobre la materia y sirvió para vincular nuevos temas?</td>
        </tr>
        <tr>
            <th scope="row">3</th>
            <td>@¿Abordó los temas estableciendo ejemplos prácticos o basados en situaciones reales que me permitieron aprender y desarrollar mi creatividad?</td>
        </tr>
        <tr>
            <th scope="row">3</th>
            <td>¿Las actividades realizadas durante el curso en relación con el programa, mostraron organización y orden?</td>
        </tr>
        <tr>
            <th scope="row">3</th>
            <td>¿Regresó tareas, trabajos, proyectos, exámenes etc. con comentarios que sirvieron de retroalimentación?</td>
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
