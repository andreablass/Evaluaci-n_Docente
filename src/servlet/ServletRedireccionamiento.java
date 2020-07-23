package servlet;
//import modelo.BeanAlumno;
//import modelo.DaoAlumno;

import modelo.DaoToken;
import util.ConexionBD;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ServletRedireccionamiento")
public class ServletRedireccionamiento extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        atenderPeticion(request, response);
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        atenderPeticion(request, response);
    }
    public void atenderPeticion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

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
        if(ext.equals("@utez.edu.mx")) {
            DaoToken daoTok = new DaoToken();
            //COMPROBAMOS SI EL TOKEN ES VALIDO
            boolean respuesta = daoTok.consultarToken(token);

            if(respuesta){
                String grupo;
                grupo = daoTok.obtenerGrupo(token);
                boolean registrado = daoTok.registroAlumno(grupo, correo);
                if(registrado)
                    request.getRequestDispatcher("/view/inicioEncuesta.jsp").forward(request, response);
                else
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
            }else
                request.getRequestDispatcher("/index.jsp").forward(request, response);
        }else
            request.getRequestDispatcher("/index.jsp").forward(request, response);
    }


}
