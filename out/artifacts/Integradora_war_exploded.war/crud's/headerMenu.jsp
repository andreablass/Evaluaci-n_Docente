<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String context = request.getContextPath();%>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"/>

<nav class="navbar navbar-dark bg-primary ">
    <nav class="navbar navbar-expand-lg ">
        <a class="navbar-brand" href="#">EDI_UTEZ</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <center>
            <div class="collapse navbar-collapse" id="navbarNavDropdown">
                <ul class="navbar-nav">
                    <li class="nav-item active" style="margin-left: 1rem;">
                        <a class="nav-link" href="<%=context%>/crud's/Menu.jsp"> <b>Inicio</b><span class="sr-only">(current)</span></a>
                    </li>

                    <li class="nav-item" style="margin-left: 1rem;">
                       <a href="<%=context%>/ServletPeriodo" class="btn btn-primary">Periodos</a>
                    </li>

                    <li class="nav-item" style="margin-left: 1rem;">
                        <a href="<%=context%>/ServletDocente" class="btn btn-primary">Docentes</a>
                    </li>

                    <li class="nav-item" style="margin-left: 1rem;">
                        <a href="<%=context%>/ServletGrupo" class="btn btn-primary">Grupos</a>
                    </li>

                    <li class="nav-item" style="margin-left: 1rem;">
                        <a href="<%=context%>/ServletPregunta" class="btn btn-primary">Preguntas</a>
                    </li>

                    <li class="nav-item" style="margin-left: 1rem;">
                        <a href="<%=context%>/ServletComentario" class="btn btn-primary">Comentarios</a>
                    </li>

                    <li class="nav-item" style="margin-left: 1rem;">
                        <a href="<%=context%>/ServletReporte" class="btn btn-primary">Reportes</a>
                    </li>

                    <li class="nav-item" style="margin-left: 1rem;">
                        <a href="<%=context%>/ServletAdministrador" class="btn btn-primary">Administradores</a>
                    </li>

                    <li class="nav-item" style="margin-left: 1rem;">
                        <a href="<%=context%>/ServletTerminarEncuesta" class="btn btn-primary">Salir</a>
                    </li>

                </ul>
            </div>
        </center>
    </nav>

</nav>
