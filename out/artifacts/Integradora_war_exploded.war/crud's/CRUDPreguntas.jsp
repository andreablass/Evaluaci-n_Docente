<%--
  Created by IntelliJ IDEA.
  User: Esmeralda Lara
  Date: 23/07/2020
  Time: 20:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String context = request.getContextPath();%>
<html>
<head>
    <title>CRUDPreguntas</title>
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
            <th scope="col">Descripción</th>

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

<br/>
<br/>
<br/>

<div class="card-deck">
    <div class="card">
        <div class="card-body">
            <form>
                <div class="form-group">
                    <label for="formGroupExampleInput">Identificador de pregunta</label>
                    <input type="text" class="form-control"  >
                </div>
                <div class="form-group">
                    <label for="formGroupExampleInput2">Descipción</label>
                    <input type="text" class="form-control" >
                </div>
            </form>
        </div>
        <div class="card-footer">
            <small class="text-muted"><button type="button" class="btn btn-outline-success">Agregar</button></small>
        </div>
    </div>
    <div class="card">
        <div class="card-body">
            <form>
                <div class="form-group">
                    <label for="formGroupExampleInput">Identificador de pregunta</label>
                    <input type="text" class="form-control"  >
                </div>
                <div class="form-group">
                    <label for="formGroupExampleInput2">Descipción</label>
                    <input type="text" class="form-control" >
                </div>
            </form>
        </div>
        <div class="card-footer">
            <small class="text-muted"><button type="button" class="btn btn-outline-warning">Modificar</button></small>
        </div>
    </div>
    <div class="card">
        <div class="card-body">
            <form>
                <div class="form-group">
                    <label for="formGroupExampleInput">Identificador de pregunta</label>
                    <input type="text" class="form-control"  >
                </div>
            </form>
        </div>
        <div class="card-footer">
            <small class="text-muted"><button type="button" class="btn btn-outline-danger">Eliminar</button></small>
        </div>
    </div>
</div>

<form action="<%=context%>/crud's/Menu.jsp">
    <button type="submit" class="btn btn-primary btn-lg btn-block" id="RegresarInicio">Menú</button>
</form>

</body>
</html>


