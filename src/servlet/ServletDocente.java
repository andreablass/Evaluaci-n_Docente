package servlet;

import bean.BeanDocente;
import dao.DaoDocente;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ServletDocente")
public class ServletDocente extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        atenderPeticion(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        atenderPeticion(request, response);
    }
    protected void atenderPeticion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        DaoDocente daoDoc = new DaoDocente();
        String context = request.getContextPath();
        //DECLARACION DE VARIABLES
        String correo, nombre, apellido1, apellido2;
        int estado;

        if(request.getParameter("opcion")!=null){
            String opcion = request.getParameter("opcion");
            switch(opcion){
                case "agregar":
                    correo = request.getParameter("correo");
                    nombre = request.getParameter("nombre");
                    apellido1 = request.getParameter("apellido1");
                    apellido2 = request.getParameter("apellido2");
                    estado = Integer.parseInt(request.getParameter("estado"));
                    BeanDocente docente = new BeanDocente();
                    docente.setId_Matricula(correo);
                    docente.setNombre(nombre);
                    docente.setApellido1(apellido1);
                    docente.setApellido2(apellido2);
                    docente.setEstado(estado);

                    boolean respuesta = daoDoc.agregarDocente(docente);
                    break;
                case "eliminar":
                    correo = request.getParameter("correo");
                    boolean eliminado = daoDoc.eliminarDocente(correo);
                    break;
                case "modificar":
                    correo = request.getParameter("correo");
                    nombre = request.getParameter("nombre");
                    apellido1 = request.getParameter("apellido1");
                    apellido2 = request.getParameter("apellido2");
                    estado = Integer.parseInt(request.getParameter("estado"));
                    respuesta = daoDoc.modificarDocente(correo, nombre, apellido1, apellido2, estado);
                    break;
            }
        }
        List<BeanDocente> docentes = daoDoc.consultarDocentes();
        request.getSession().setAttribute("docentes", docentes);
        request.getRequestDispatcher("/crud's/CRUDDocente.jsp").forward(request, response);
    }
}
