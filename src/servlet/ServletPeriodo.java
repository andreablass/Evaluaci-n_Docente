package servlet;

import bean.BeanPeriodo;
import dao.DaoPeriodo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ServletPeriodo")
public class ServletPeriodo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        atenderPeticion(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        atenderPeticion(request, response);
    }

    protected void atenderPeticion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        DaoPeriodo daoPer = new DaoPeriodo();

        if(request.getParameter("opcion") != null){
            String opcion = request.getParameter("opcion");
            switch(opcion){
                case "agregar":
                    String nombre = request.getParameter("nombre");
                    String fecha_inicio = request.getParameter("fecha_inicio");
                    String fecha_fin = request.getParameter("fecha_fin");

                    daoPer.desactivarPeriodosAnterior();
                    daoPer.agregarPeriodo(nombre, fecha_inicio, fecha_fin);
                    break;

                case "modificar":
                    int id = Integer.parseInt(request.getParameter("id"));
                    String nombre2 = request.getParameter("nombre");
                    String fecha_inicio2 = request.getParameter("fecha_inicio");
                    String fecha_fin2 = request.getParameter("fecha_fin");
                    int estado = Integer.parseInt(request.getParameter("estado"));

                    daoPer.modificarPeriodo(id, nombre2, fecha_inicio2, fecha_fin2, estado);
                    break;

                case "eliminar":
                    int periodo = Integer.parseInt(request.getParameter("id"));
                    daoPer.eliminarPeriodo(periodo);
                    break;

            }
        }

        request.getSession().setAttribute("periodos" , daoPer.consultarPeriodos());
        request.getRequestDispatcher("/crud's/CRUDPeriodo.jsp").forward(request, response);
    }

}
