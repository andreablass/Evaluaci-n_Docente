package servlet;

import dao.DaoDocente;
import dao.DaoPeriodo;
import dao.DaoReporte;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;

@WebServlet("/ServletReporte")
public class ServletReporte extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        atenderPeticion(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        atenderPeticion(request, response);
    }
    protected void atenderPeticion(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        DaoReporte daoRepo = new DaoReporte();
        DaoPeriodo daoPeriodo = new DaoPeriodo();
        DaoDocente daoDocente = new DaoDocente();

        int idPeriodo = 0;

        if(request.getParameter("opcion") != null) {
            String option = request.getParameter("opcion");

            switch (option){
                case "periodo":
                    idPeriodo = Integer.parseInt(request.getParameter("idPeriodo"));
                    break;

                case "profesor":
                    String idProfesor = request.getParameter("idProfesor");
                    request.getSession().setAttribute("datosReporteDefault", daoRepo.reportePorProfesor(idProfesor));
                    request.getSession().setAttribute("periodos", daoPeriodo.consultarPeriodos());
                    request.getSession().setAttribute("profesores",daoDocente.consultarDocentes() );
                    request.getRequestDispatcher("/crud's/CRUDReporte.jsp").forward(request, response);

                    break;

                case "repoPeriodo":

                   /* idPeriodo = Integer.parseInt(request.getParameter("idPeriodo"));

                    try {

                        Connection con = ConexionBD.getConnection();
                        String jasperFileName = "/reportes/reporteGeneral.jasper";
                        File archivoReporte = new File(request.getRealPath(jasperFileName));

                        //Agregar parametros
                        HashMap parametros = new HashMap();
                        parametros.put("idPeriodo",idPeriodo);

                        ServletOutputStream servletOutputStream = response.getOutputStream();

                        byte[] bytes = null;

                            bytes = JasperRunManager.runReportToPdf(archivoReporte.getPath(), parametros, con);

                            response.setContentType("application/pdf");
                            response.setContentLength(bytes.length);
                            response.setHeader("Content-Disposition", "Attachment;Filename=\"Reporte Periodo.pdf" + "\"");
                            servletOutputStream.write(bytes, 0, bytes.length);
                            servletOutputStream.flush();
                            servletOutputStream.close();
                            con.close();

                    } catch (Exception e) {
                        System.out.println(e);
                    }

                    */

                    break;
            }

        }else {
            idPeriodo = daoRepo.consultarPeriodoActivo();
        }

        request.getSession().setAttribute("datosReporteDefault", daoRepo.reportePorIdPeriodo(idPeriodo));
        request.getSession().setAttribute("periodos", daoPeriodo.consultarPeriodos());
        request.getSession().setAttribute("profesores",daoDocente.consultarDocentes());
        request.getSession().setAttribute("general", true);
        request.getRequestDispatcher("/crud's/CRUDReporte.jsp").forward(request, response);

    }
}
