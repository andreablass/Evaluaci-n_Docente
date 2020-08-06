<%@ page import="bean.BeanAdministrador" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Esmeralda Lara
  Date: 23/07/2020
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String context = request.getContextPath();
    String subMenu ="";
%>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <title>Menú principal</title>
</head>
<body background="<%=context%>/images/fondo.png">

  <jsp:include page="headerMenu.jsp"/>

<table width="100%">
    <thead>
    <tr>
        <td width="26%" align="center">
            <img src="<%=context%>/images/Logo_utez.png" width="40%" class="img-fluid" alt="Responsive image">
        </td>
        <td>
            <center>
                <table>
                    <tr>
                        <h1>Preevaluación Docente Datic</h1>
                    </tr>
                    <tr>
                        <h2>DATIC</h2>
                    </tr>
                </table>
            </center>
        </td>
        <td width="26%" align="center">
            <img src="<%=context%>/images/datic.png" width="58%" class="img-fluid" alt="Responsive image">
        </td>
    </tr>
    </thead>


</table>
<br><br>
<table>
    <tr>
        <td width="20%">

        </td>
        <td width="60%">
            <div id="carouselExampleCaptions" class="carousel slide" data-ride="carousel">
                <ol class="carousel-indicators">
                    <li data-target="#carouselExampleCaptions" data-slide-to="0" class="active"></li>
                    <li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
                    <li data-target="#carouselExampleCaptions" data-slide-to="2"></li>
                </ol>
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img src="<%=context%>/images/carousel1.jpg" class="d-block w-100 rounded-pill" alt="Docentes Datic">
                        <div class="carousel-caption d-none d-md-block">
                            <h5>Certificación de Docentes</h5>
                            <p>Gracias a los resultados de las evaluaciones se logran certificar a los docentes de
                                la DATIC</p>
                        </div>
                    </div>
                    <div class="carousel-item">
                        <img src="<%=context%>/images/carousel2.jpg" class="d-block w-100 rounded-pill" alt="Docentes DATIC">
                        <div class="carousel-caption d-none d-md-block">
                            <h5>Docentes Activos</h5>
                            <p>Docentes apasionados y dedicados</p>
                        </div>
                    </div>
                    <div class="carousel-item">
                        <img src="<%=context%>/images/carousel3.jpg" class="d-block w-100 rounded-pill" alt="Docentes CISCO">
                        <div class="carousel-caption d-none d-md-block">
                            <h5>Cisco</h5>
                            <p>Docentes que participan en la enseñanza CISCO</p>
                        </div>
                    </div>
                </div>
                <a class="carousel-control-prev" href="#carouselExampleCaptions" role="button" data-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="carousel-control-next" href="#carouselExampleCaptions" role="button" data-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>
        </td>
        <td width="20%"></td>
    </tr>
</table>
<br><br>
<table>
    <tr>
        <td width="10%"></td>
        <td width="20%">
            <div class="card  shadow p-3 mb-5 bg-white rounded" style="width: 18rem; color: rgb(17, 71, 42);">
                <img src="<%=context%>/images/docentes.jpg" class="card-img-top" alt="Docentes">
                <div class="card-body">
                    <p class="card-text" align="justify">El sistema EDI_UTEZ tiene el objetivo de evaluar la calidad
                        e
                        identificar las áreas de oportunidad de los docentes de la División Académica de Tecnologías
                        de la Información, desde el criterio de la comunidad estudiantil, a través de la
                        administración
                        y el monitoreo digital en evaluaciones periódicas</p>
                </div></div>
        </td>
        <td></td>
        <td width="50%">
            <div class="card  shadow p-3 mb-5 bg-white rounded " style="width:73%; color:  rgb(17, 71, 42);">
                <img src="<%=context%>/images/docentes.jpg" class="card-img-top" alt="Docentes">
                <div class="card-body text-center">
                    <p class="card-text" align="justify">El sistema EDI_UTEZ tiene el objetivo de evaluar la calidad
                        e
                        identificar las áreas de oportunidad de los docentes de la División Académica de Tecnologías
                        de la Información, desde el criterio de la comunidad estudiantil, a través de la
                        administración
                        y el monitoreo digital en evaluaciones periódicas</p>
                </div></div>
        </td>

    </tr>

    </div>
</table>


<!--Scripts-->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>

<!--
<script>

        $(document).ready(function () {
            $("#Docentes").click(function () {
            alert("Docentes function");
            let opcion = $("#Docentes").val();

            console.log("Opción:>"+ opcion);

            subMenu = opcion;

            console.log("subMenu: "+ subMenu);
        })
    })

        $(document).ready(function () {
            $("#Grupos").click(function () {
                alert("Grupos function");
                let opcion = $("#Grupos").val();

                console.log("Opción:>"+ opcion);

                subMenu = opcion;

                console.log("subMenu: "+ subMenu);

            })
        })

        $(document).ready(function () {
            $("#Evaluacion").click(function () {
                alert("Evaluacion function");
                let opcion = $("#Evaluacion").val();

                console.log("Opción:>"+ opcion);

                subMenu = opcion;

                console.log("subMenu: "+ subMenu);

            })
        })

        $(document).ready(function () {
            $("#Periodos").click(function () {
                alert("Periodos function");
                let opcion = $("#Periodos").val();

                console.log("Opción:>"+ opcion);

                subMenu = opcion;

                console.log("subMenu: "+ subMenu);

            })
        })

        $(document).ready(function () {
            $("#Reportes").click(function () {
                alert("Reportes function");
                let opcion = $("#Reportes").val();

                console.log("Opción:>"+ opcion);

                subMenu = opcion;

                console.log("subMenu: "+ subMenu);

            })
        })

        $(document).ready(function () {
            $("#Administradores").click(function () {
                alert("Administradores function");
                let opcion = $("#Administradores").val();

                console.log("Opción:>"+ opcion);

                subMenu = opcion;

                console.log("subMenu: "+ subMenu);

            })
        })

</script>

-->

</body>

</html>
