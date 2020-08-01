<%--
  Created by IntelliJ IDEA.
  User: Esmeralda Lara
  Date: 23/07/2020
  Time: 20:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String context = request.getContextPath();%>
<html>
<head>
    <title>CRUDAdministrador</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <link rel="stylesheet" href="../css/estilosDeInterfaces.css">

</head>
<!-- COMIENZO DEL NAV-->
<nav class="navbar navbar-dark ">
    <nav class="navbar navbar-expand-lg ">
        <a class="navbar-brand" href="#">EDI_UTEZ</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown"
            aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <center>
            <div class="collapse navbar-collapse" id="navbarNavDropdown">
                <ul class="navbar-nav">
                    <li class="nav-item active">

                        <a class="nav-link" href="#"> <b>Inicio</b><span class="sr-only">(current)</span></a>
                    </li>

                    <li class="nav-item">
                        <!--Docentes-->
                        <form action="<%=context%>/crud's/CRUDDocente.jsp">
                            <button type="submit" class="navbar btn-primary" id="Docentes" value="Docentes"
                                style="border: none;">Docentes</button>
                        </form>
                    </li>

                    <li class="nav-item">
                        <!--Grupos-->
                        <form action="<%=context%>/crud's/CRUDGrupo.jsp">
                            <button type="submit" class="navbar btn-primary" style="border: none;" id="Grupos"
                                value="Grupos">Grupos</button>
                        </form>
                    </li>

                    <li class="nav-item">
                        <!--Evaluación-->
                        <form action="<%=context%>/crud's/CRUDPreguntas.jsp">
                            <button type="submit" class="navbar  btn-primary" style="border: none;" id="Evaluacion"
                                value="Evaluacion">Evaluacion</button>
                        </form>
                    </li>

                    <li class="nav-item">
                        <!--Periodos-->
                        <form action="<%=context%>/crud's/CRUDPeriodo.jsp">
                            <button type="submit" class="navbar  btn-primary" style="border: none;" id="Periodos"
                                value="Periodos">Periodos</button>
                        </form>
                    </li>

                    <li class="nav-item">
                        <!--Reportes-->
                        <form action="<%=context%>/crud's/CRUDReporte.jsp">
                            <button type="submit" class="navbar  btn-primary" style="border: none;" id="Reportes"
                                value="Reportes">Reportes</button>
                        </form>
                    </li>

                    <li class="nav-item">
                        <!--Administradores-->
                        <form action="<%=context%>/crud's/CRUDAdministrador.jsp">
                            <button type="submit" class="navbar  btn-primary" style="border: none;"
                                id="Administradores" value="Administradores">Administradores</button>
                        </form>
                    </li>

                </ul>
            </div>
        </center>
    </nav>
</nav>
<!-- FIN DEL NAV-->
<center><div class="p-3 mb-2 bg-success ">PREGUNTAS</div></center>

<!--Tabla -->
<center>
    <table class="table table-hover">
        <span class="border border-success"></span>
        <thead>
        <tr>
            <th scope="col">Identificador de Administrador</th>
            <th scope="col">Nombre de usuario</th>
            <th scope="col">Nombre</th>
            <th scope="col">Apellido Paterno</th>
            <th scope="col">Apellido Materno</th>
            <th scope="col">Contraseña</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <th scope="row">1</th>
            <td>Mark</td>
            <td>Otto</td>
            <td>@mdo</td>
            <td>fat</td>
            <td>fat</td>
        </tr>
        <tr>
            <th scope="row">2</th>
            <td>Jacob</td>
            <td>Thornton</td>
            <td>@fat</td>
            <td>fat</td>
            <td>fat</td>
        </tr>
        <tr>
            <th scope="row">3</th>
            <td>Larry the Bird</td>
            <td>@twitter</td>
            <td>fat</td>
            <td>fat</td>
            <td>fat</td>
        </tr>
        <tr>
            <th scope="row">3</th>
            <td>Larry the Bird</td>
            <td>@twitter</td>
            <td>fat</td>
            <td>fat</td>
            <td>fat</td>
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
                    <label for="formGroupExampleInput">Identificador de Administrador</label>
                    <input type="text" class="form-control"  >
                </div>
                <div class="form-group">
                    <label for="formGroupExampleInput2">Nombre de usuario</label>
                    <input type="text" class="form-control" >
                </div>
                <div class="form-group">
                    <label for="formGroupExampleInput2">Nombre</label>
                    <input type="text" class="form-control" >
                </div>
                <div class="form-group">
                    <label for="formGroupExampleInput2">Apellido Paterno</label>
                    <input type="text" class="form-control" >
                </div>
                <div class="form-group">
                    <label for="formGroupExampleInput2">Apellido Materno</label>
                    <input type="text" class="form-control" >
                </div>
                <div class="form-group">
                    <label for="formGroupExampleInput2">Contraseña</label>
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
                    <label for="formGroupExampleInput">Identificador de Administrador</label>
                    <input type="text" class="form-control"  >
                </div>
                <div class="form-group">
                    <label for="formGroupExampleInput2">Nombre de usuario</label>
                    <input type="text" class="form-control" >
                </div>
                <div class="form-group">
                    <label for="formGroupExampleInput2">Nombre</label>
                    <input type="text" class="form-control" >
                </div>
                <div class="form-group">
                    <label for="formGroupExampleInput2">Apellido Paterno</label>
                    <input type="text" class="form-control" >
                </div>
                <div class="form-group">
                    <label for="formGroupExampleInput2">Apellido Materno</label>
                    <input type="text" class="form-control" >
                </div>
                <div class="form-group">
                    <label for="formGroupExampleInput2">Contraseña</label>
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
                    <label for="formGroupExampleInput">Identificador de Administrador</label>
                    <input type="text" class="form-control"  >
                </div>
            </form>
        </div>
        <div class="card-footer">
            <small class="text-muted"><button type="button" class="btn btn-outline-danger">Eliminar</button></small>
        </div>
    </div>
</div>



</body>
</html>


