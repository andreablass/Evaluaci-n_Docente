<%@ page import="modelo.BeanAdministrador" %><%--
  Created by IntelliJ IDEA.
  User: Esmeralda Lara
  Date: 23/07/2020
  Time: 20:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String context = request.getContextPath();
BeanAdministrador user = new BeanAdministrador();

if(request.getSession().getAttribute("user") != null ){
    user = (BeanAdministrador)request.getSession().getAttribute("user");
}

%>
<html>

<head>
    <title>CRUDReporte</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
        integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <link rel="stylesheet" href="../css/estilosDeInterfaces.css">

    </head>

<body class="background">

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

    <center>
        <div class="p-3 mb-2 bg-success ">REPORTES</div>
    </center>

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

    <br />
    <br />
    <br />
    <% if(user.getTipo() == 1){ %>
    <div class="card border-light mb-3" style="max-width: 18rem;">
        <div class="card-body">
            <form>
                <div class="form-group">
                    <label for="formGroupExampleInput">Identificador de Reportes</label>
                    <input type="text" class="form-control">
                </div>
                <div class="form-group">
                    <label for="formGroupExampleInput2">Identificador de Maestros</label>
                    <input type="text" class="form-control">
                </div>
                <div class="form-group">
                    <label for="formGroupExampleInput2">Identificador de Periodos</label>
                    <input type="text" class="form-control">
                </div>
            </form>
            <small class="text-muted"><button type="button" class="btn btn-outline-danger">Eliminar</button></small>
        </div>
    </div>
    <% } %>
    

</body>

</html>