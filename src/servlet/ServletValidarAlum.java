package servlet;

import modelo.DaoToken;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ServletValidarAlum")
public class ServletValidarAlum extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        atenderPeticion(request, response);
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        atenderPeticion(request, response);
    }
    public void atenderPeticion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        DaoToken daoTok = new DaoToken();
        int idPeriodo = daoTok.consultarPeriodoActivo();

        if(idPeriodo != 0) {
            //boolean resultado = daoCan.IngresarAlumno(registro);
            //Simulacion de resultado
            boolean resultado = false;
            //Simulacion de token y correo
            String correo = request.getParameter("correo");
            String token = request.getParameter("token");
            //GUARDANDO DATOS
            request.setAttribute("correo", correo);
            request.setAttribute("token", token);
            //TRATAMIENTO DE CADENA
            int inicio = correo.indexOf('@');
            int end = correo.length();
            String ext = correo.substring(inicio, end);
            //BOOLEAN COMPROBACION SI EL TOKEN SE ENCUENTRA EN LA BASE DE DATOS
            boolean encontrado = false;
            if (ext.equals("@utez.edu.mx")) {

                //COMPROBAMOS SI EL TOKEN ES VALIDO
                int idGrupo = daoTok.consultarToken(token);
                if (idGrupo != 0) {
                    //COMPROBACION SI EL ALUMNO CONTESTO PREVIAS ENCUESTAS
                    int idAlumno = daoTok.consultarAlumno(idGrupo, correo);
                    if(idAlumno == 0) {
                        boolean registrado = daoTok.registroAlumno(idGrupo, correo);
                        if (registrado) {
                            int index = 0;
                            request.getSession().setAttribute("index", index);
                            System.out.println(index);
                            request.getSession().setAttribute("idAlumno", daoTok.consultarAlumno(idGrupo, correo));
                            request.getSession().setAttribute("correo", correo);
                            request.getSession().setAttribute("idGrupo", idGrupo);
                            request.getSession().setAttribute("idPeriodo", idPeriodo);
                            request.getRequestDispatcher("/view/inicioEncuesta.jsp").forward(request, response);
                        } else
                            request.getRequestDispatcher("/index.jsp").forward(request, response);
                    }else{
                        request.getSession().setAttribute("index", daoTok.consultarProgresoEncuesta(idAlumno, idPeriodo));
                        System.out.println(daoTok.consultarProgresoEncuesta(idAlumno, idPeriodo));
                        request.getSession().setAttribute("idAlumno", idAlumno);
                        request.getSession().setAttribute("correo", correo);
                        request.getSession().setAttribute("idGrupo", idGrupo);
                        request.getSession().setAttribute("idPeriodo", idPeriodo);
                        request.getRequestDispatcher("/view/inicioEncuesta.jsp").forward(request, response);
                    }
                } else
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
            } else
                request.getRequestDispatcher("/index.jsp").forward(request, response);
        }else
            request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
