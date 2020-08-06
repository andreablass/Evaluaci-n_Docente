package servlet;

import bean.BeanPregunta;
import dao.DaoPregunta;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ServletComentario")
public class ServletComentario extends HttpServlet {

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

        DaoPregunta daoPre= new DaoPregunta();

        if(request.getParameter("opcion") != null){
            String opcion = request.getParameter("opcion");

            switch(opcion){
                case "agregar":
                    String descripcion = request.getParameter("descripcion");
                    daoPre.agregarComentario(descripcion);
                    break;
                case "eliminar":
                    int idE = Integer.parseInt(request.getParameter("id"));
                    daoPre.eliminarComentario(idE);
                    break;
                case "modificar":
                    int idM = Integer.parseInt(request.getParameter("id"));
                    String descripcionM = request.getParameter("descripcion");
                    daoPre.modificarComentario(idM, descripcionM);
                    break;
            }
        }

        List<BeanPregunta> comentarios = daoPre.consultarComentarios();
        request.getSession().setAttribute("comentarios", comentarios);
        request.getRequestDispatcher("/crud's/CRUDComentarios.jsp").forward(request, response);
    }
}
