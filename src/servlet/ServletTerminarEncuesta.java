package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/ServletTerminarEncuesta")
public class ServletTerminarEncuesta extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        atenderPeticion(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        atenderPeticion(request, response);
    }
    protected void atenderPeticion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        while(request.getSession().getAttributeNames().hasMoreElements()){
            String attribute = request.getSession().getAttributeNames().nextElement();
            request.getSession().removeAttribute(attribute);
        }
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

}
