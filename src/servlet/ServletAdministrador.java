package servlet;

import bean.BeanAdministrador;
import dao.DaoAdministrador;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ServletAdministrador")
public class ServletAdministrador extends HttpServlet {

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

        DaoAdministrador daoAdmin= new DaoAdministrador();
        BeanAdministrador administrador = new BeanAdministrador();

        if(request.getParameter("opcion") != null){
            String opcion = request.getParameter("opcion");
            switch(opcion){
                case "agregar":
                    String nombreUsuario= request.getParameter("nombreUsuario");
                    String nombre = request.getParameter("nombre");
                    String apellido1 = request.getParameter("apellido1");
                    String apellido2 = request.getParameter("apellido2");
                    String password = request.getParameter("password");
                    int tipo = Integer.parseInt(request.getParameter("tipo"));

                    administrador = new BeanAdministrador(nombreUsuario, nombre, apellido1, apellido2, password ,tipo);
                    daoAdmin.agregarAdministrador(administrador);
                    break;
                case "eliminar":
                    int id = Integer.parseInt(request.getParameter("id"));
                    daoAdmin.eliminarAdministrador(id);
                    break;
                case "modificar":
                    id = Integer.parseInt(request.getParameter("id"));
                    nombreUsuario= request.getParameter("nombreUsuario");
                    nombre = request.getParameter("nombre");
                    apellido1 = request.getParameter("apellido1");
                    apellido2 = request.getParameter("apellido2");
                    password = request.getParameter("password");
                    tipo = Integer.parseInt(request.getParameter("tipo"));

                    administrador = new BeanAdministrador(id,nombreUsuario, nombre, apellido1, apellido2, password ,tipo);
                    daoAdmin.modificarAdministrador(administrador);
                    break;
            }
        }

        request.getSession().setAttribute("administradores", daoAdmin.consultarAdministradores());
        request.getRequestDispatcher("/crud's/CRUDAdministrador.jsp").forward(request, response);
    }
}
