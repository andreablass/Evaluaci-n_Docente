<%--
  Created by IntelliJ IDEA.
  User: Esmeralda Lara
  Date: 23/07/2020
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String context = request.getContextPath();%>
<html>
<head>
    <title>Docente</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body>
<center><div class="p-3 mb-2 bg-success text-white">Docentes</div></center>
<!-- Tabla -->
<table class="table table-hover">
    <span class="border border-success"></span>
    <thead>
    <tr>
        <th scope="col">Matrícula</th>
        <th scope="col">Nombre</th>
        <th scope="col">Apellido Paterno</th>
        <th scope="col">Apellido Materno</th>
        <th scope="col">Estado</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <th scope="row">1</th>
        <td>Mark</td>
        <td>Otto</td>
        <td>@mdo</td>
        <td>fat</td>
    </tr>
    <tr>
        <th scope="row">2</th>
        <td>Jacob</td>
        <td>Thornton</td>
        <td>@fat</td>
        <td>fat</td>
    </tr>
    <tr>
        <th scope="row">3</th>
        <td>Larry the Bird</td>
        <td>@twitter</td>
        <td>fat</td>
        <td>fat</td>
    </tr>
    <tr>
        <th scope="row">3</th>
        <td>Larry the Bird</td>
        <td>@twitter</td>
        <td>fat</td>
        <td>fat</td>
    </tr>
    </tbody>
</table>
<br/>
<br/>
<br/>

<div class="card-deck">
    <div class="card">
        <div class="card-body">
            <form>
                <div class="form-group">
                    <label for="formGroupExampleInput">Matricula</label>
                    <input type="text" class="form-control" id="formGroupExampleInput">
                </div>
                <div class="form-group">
                    <label for="formGroupExampleInput2">Nombre</label>
                    <input type="text" class="form-control" id="formGroupExampleInput2" >
                </div>
                <div class="form-group">
                    <label for="formGroupExampleInput2">Apellido  Paterno</label>
                    <input type="text" class="form-control">
                </div>
                <div class="form-group">
                    <label for="formGroupExampleInput2">Apellido  Materno</label>
                    <input type="text" class="form-control" >
                </div>
                <div class="form-group">
                    <label for="formGroupExampleInput2">Estado</label>
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
                    <label for="formGroupExampleInput">Matricula</label>
                    <input type="text" class="form-control"  >
                </div>
                <div class="form-group">
                    <label for="formGroupExampleInput2">Nombre</label>
                    <input type="text" class="form-control"  >
                </div>
                <div class="form-group">
                    <label for="formGroupExampleInput2">Apellido  Paterno</label>
                    <input type="text" class="form-control"  >
                </div>
                <div class="form-group">
                    <label for="formGroupExampleInput2">Apellido  Materno</label>
                    <input type="text" class="form-control" >
                </div>
                <div class="form-group">
                    <label for="formGroupExampleInput2">Estado</label>
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
                    <label for="formGroupExampleInput"> Matricula</label>
                    <input type="text" class="form-control">
                </div>
            </form>
        </div>
        <div class="card-footer">
            <small class="text-muted"><button type="button" class="btn btn-outline-danger">Eliminar</button></small>
        </div>
    </div>
</div>
</br></br></br>
<form action="<%=context%>/crud's/Menu.jsp">
    <button type="submit" class="btn btn-primary btn-lg btn-block" id="RegresarInicio">Menú</button>
</form>

</body>
</html>



