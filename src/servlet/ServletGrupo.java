package servlet;

import bean.BeanDocente;
import bean.BeanGrupo;
import dao.DaoDocente;
import dao.DaoGrupo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ServletGrupo")
public class ServletGrupo extends HttpServlet {

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

        DaoGrupo daoGrp = new DaoGrupo();

        if(request.getParameter("opcion")!=null) {
            String opcion = request.getParameter("opcion");
            switch(opcion){
                case "agregar":

                   String token ="";
                    do {
                        for (int i = 0; i < 5; i++) {
                            double numero = Math.random() * 10;
                            int parcear = (int) numero;
                            token += parcear;
                        }
                    }while(daoGrp.compararToken(token));

                    BeanGrupo grupo = new BeanGrupo();
                    grupo.setToken(token);
                    grupo.setNum_Alum(Integer.parseInt(request.getParameter("num_alum")));
                    grupo.setCompletado(0);
                    grupo.setGrupo(request.getParameter("grupo"));
                    grupo.setCuatrimestre(request.getParameter("cuatrimestre"));
                    grupo.setCarrera(request.getParameter("carrera"));
                    daoGrp.agregarGrupo(grupo);

                    int idGrupo = daoGrp.consultarIdGrupo(token);

                    String[] profesores = request.getParameterValues("profesores");
                    for (String profesor: profesores){
                       daoGrp.setGrupoMaestros(profesor, idGrupo);
                    }
                    break;

                case "eliminar":
                    int idGrupoE = Integer.parseInt(request.getParameter("id"));
                    boolean sinrelaciones = daoGrp.eliminarGrupo(idGrupoE);
                    break;

                case "modificar":
                    int id = Integer.parseInt(request.getParameter("id"));
                    int num_alum = Integer.parseInt(request.getParameter("num_alum"));
                    String grupoN = request.getParameter("grupo");
                    String cuatrimestre = request.getParameter("cuatrimestre");
                    String carrera = request.getParameter("carrera");
                    daoGrp.modificarGrupo(id, num_alum, grupoN, cuatrimestre, carrera);

                    daoGrp.eliminarGrupoRelaciones(id);
                    profesores = request.getParameterValues("profesores");

                    for (String profesor: profesores){
                        daoGrp.setGrupoMaestros(profesor, id);
                    }

                    break;

            }
        }
        List<BeanGrupo> grupos = daoGrp.consultarGrupos();
        request.getSession().setAttribute("grupos", grupos);

        DaoDocente daoDoc = new DaoDocente();
        request.getSession().setAttribute("docentesActivos", daoDoc.consultarDocentesActivos());

        request.getRequestDispatcher("/crud's/CRUDGrupo.jsp").forward(request, response);
    }

}
