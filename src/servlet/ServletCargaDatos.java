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
import java.io.PrintWriter;
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
        List<BeanPregunta> preguntasX = DaoPre.consultarPreguntas();
        //OBTENCION DOCENTES
        DaoDocente daoDoc = new DaoDocente();
        List<BeanDocente> docentesX = daoDoc.consultarDocentes();
        //CONSERVA DE DATOS
        String token = request.getParameter("token");
        String correo = request.getParameter("correo");
        //INSERCION DE DATOS
        request.setAttribute("token", token);
        request.setAttribute("correo", correo);
        request.setAttribute("docentes", docentesX);
        request.setAttribute("preguntas", preguntasX);
        request.getRequestDispatcher("/view/encuesta.jsp").forward(request, response);

        PrintWriter out = response.getWriter();
        out.println("correo"+ correo);
    }

}
