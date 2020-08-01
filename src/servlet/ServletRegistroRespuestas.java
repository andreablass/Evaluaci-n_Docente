package servlet;

import modelo.BeanDocente;
import modelo.DaoEvaluacion;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ServletRegistroRespuestas")
public class ServletRegistroRespuestas extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        atenderPeticion(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        atenderPeticion(request, response);
    }
    protected void atenderPeticion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        double puntaje = 0;

        int numeroPregunta = 1;
        while(request.getParameter(numeroPregunta + "")!=null){
            puntaje += Integer.parseInt(request.getParameter(numeroPregunta + ""));
            numeroPregunta++;
        }
        int idPeriodo = Integer.parseInt(request.getParameter("idPeriodo"));
        int idAlumno = Integer.parseInt(request.getParameter("idAlumno"));
        int idGrupo = Integer.parseInt(request.getParameter("idGrupo"));
        String idMaestro = (String)request.getParameter("idMaestro");
        double promedioFinal = puntaje/(numeroPregunta-1);
        DaoEvaluacion evaluacion = new DaoEvaluacion();
        evaluacion.registroEvaluacion(idMaestro, idAlumno, idPeriodo, (numeroPregunta-1),promedioFinal );

        int numeroComentario = 1;

        while(request.getParameter( "comentario-"+numeroComentario)!=null && !request.getParameter( "comentario-"+numeroComentario).trim().equals("")){
            String comentario = request.getParameter( "comentario-"+numeroComentario);
            int idComentario = Integer.parseInt(request.getParameter( "id-"+numeroComentario));
            evaluacion.registroComentarios(idMaestro, idAlumno, idPeriodo, idComentario, comentario);
            numeroComentario++;
        }

        int index = Integer.parseInt(request.getParameter("index"));
        index++;
        request.getRequestDispatcher("/ServletCargaDatos?idAlumno="+idAlumno+"&idPeriodo="+idPeriodo+"&idGrupo="+idGrupo+"&index="+index).forward(request, response);
    }
}
