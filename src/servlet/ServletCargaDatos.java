package servlet;

import modelo.BeanDocente;
import modelo.BeanPregunta;
import modelo.DaoDocente;
import modelo.DaoPregunta;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ServletCargaDatos")
public class ServletCargaDatos extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        atenderPeticion(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        atenderPeticion(request, response);
    }
    public void atenderPeticion(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        //OBTENCION PREGUNTAS
        DaoPregunta DaoPre = new DaoPregunta();
        List<BeanPregunta> preguntasN = DaoPre.consultarPreguntas();
        List<BeanPregunta> preguntasC = DaoPre.consultarComentarios();

        //OBTENCION DOCENTES

        //CONSERVA DE DATOS
        int idGrupo = Integer.parseInt(request.getParameter("idGrupo"));
        int idAlumno = Integer.parseInt(request.getParameter("idAlumno"));
        int idPeriodo = Integer.parseInt(request.getParameter("idPeriodo"));
        int index = 0;
        DaoDocente daoDoc = new DaoDocente();
        List<BeanDocente> docentesX = daoDoc.consultarDocentesGrupo(idGrupo);
        //INSERCION DE DATOS
        request.setAttribute("docentes", docentesX);
        request.setAttribute("preguntasN", preguntasN);
        request.setAttribute("preguntasC", preguntasC);
        request.setAttribute("idAlumno", idAlumno);
        request.setAttribute("idGrupo", idGrupo);
        request.setAttribute("idPeriodo", idPeriodo);
        if(request.getParameter("index") == null){
            request.setAttribute("index", index);
            request.getRequestDispatcher("/view/encuesta.jsp").forward(request, response);

        }else{
            index = Integer.parseInt(request.getParameter("index"));
            request.setAttribute("index", index);
            if(index < docentesX.size()){
                request.getRequestDispatcher("/view/encuesta.jsp").forward(request, response);
            }else{
                request.getRequestDispatcher("/view/terminarEncuesta.jsp").forward(request, response);
            }
        }
    }
}
