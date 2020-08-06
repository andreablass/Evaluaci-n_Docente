package servlet;

import dao.DaoAdministrador;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/ServletValidarAdm")
public class ServletValidarAdm extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        atenderPeticion(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        atenderPeticion(request, response);
    }
    protected void atenderPeticion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String usuario = request.getParameter("nombreUsuario");
        String contrasenia = request.getParameter("contrasenia");

        DaoAdministrador daoAdm = new DaoAdministrador();

        boolean respuesta = daoAdm.autenticar(usuario, contrasenia);
        if(respuesta){
            request.getSession().setAttribute("user", daoAdm.consultarAdministrador(usuario, contrasenia));
            request.getRequestDispatcher("/crud's/Menu.jsp").forward(request, response);
        }else
            request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

}
