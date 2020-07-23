package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("ServletValidar")
public class ServletValidar extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        atenderPeticion(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        atenderPeticion(request, response);
    }
    protected void atenderPeticion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String correo = request.getParameter("correo");
        String token = request.getParameter("token");
        String context = request.getParameter("context");

        int inicio = correo.indexOf('@');
        int end = correo.length();

        String correoValidacion = correo.substring(inicio, end);

        if(correoValidacion.equals("@utez.edu.mx")){

        }else
            request.getRequestDispatcher("http://localhost:8080/Integradora_war_exploded/index.jsp").forward(request, response);
    }
}
