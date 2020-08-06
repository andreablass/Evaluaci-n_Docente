package dao;

import bean.BeanDocente;
import bean.BeanPeriodo;
import bean.BeanReporte;
import util.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoReporte {

    Connection con;
    PreparedStatement pstm;
    Statement stm;
    ResultSet rs;

    public List<BeanReporte> reportePorIdPeriodo(int idPeriodo){
        List<BeanReporte> datosReporte = new ArrayList<>();
        try{
            con = ConexionBD.getConnection();
            stm = con.createStatement();
            pstm = con.prepareStatement("SELECT AVG(ev.promedio) AS promedio, m.Id_Matricula, m.Nombre, m.Apellido1, m. Apellido2, ev.Id_periodo, p.nombre AS nombre_periodo, ev.Num_preguntas AS num_preguntas, COUNT(ev.Id_maestro) AS num_alumnos  FROM evaluaciones ev, maestros m, periodos p WHERE ev.Id_maestro=m.Id_Matricula AND p.id=ev.Id_periodo AND ev.id_periodo=? GROUP BY Id_maestro, ev.Num_preguntas ORDER BY promedio DESC ;");
            pstm.setInt(1, idPeriodo);

            System.out.println(pstm);
            rs = pstm.executeQuery();

            while(rs.next()){
                BeanReporte dato = new BeanReporte();
                dato.setPromedio(rs.getDouble("promedio"));
                dato.setNum_alumnos(rs.getInt("num_alumnos"));
                dato.setNum_preguntas(rs.getInt("num_preguntas"));

                BeanPeriodo periodo = new BeanPeriodo();
                periodo.setId(rs.getInt("Id_periodo"));
                periodo.setNombre(rs.getString("nombre_periodo"));
                dato.setPeriodo(periodo);

                BeanDocente docente = new BeanDocente();
                docente.setId_Matricula(rs.getString("Id_Matricula"));
                docente.setNombre(rs.getString("Nombre"));
                docente.setApellido1(rs.getString("Apellido1"));
                docente.setApellido2(rs.getString("Apellido2"));
                dato.setDocente(docente);

                datosReporte.add(dato);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                if(con!=null)
                    con.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        return datosReporte;
    }

    public List<BeanReporte> reportePorProfesor(String idProfesor){
        List<BeanReporte> datosReporte = new ArrayList<>();
        try{
            con = ConexionBD.getConnection();
            stm = con.createStatement();
            pstm = con.prepareStatement("SELECT AVG(ev.promedio) AS promedio, m.Id_Matricula, m.Nombre, m.Apellido1, m. Apellido2, ev.Id_periodo, p.nombre AS nombre_periodo, ev.Num_preguntas AS num_preguntas, COUNT(ev.Id_maestro) AS num_alumnos  FROM evaluaciones ev, maestros m, periodos p WHERE ev.Id_maestro=m.Id_Matricula AND p.id=ev.Id_periodo AND ev.Id_maestro=? GROUP BY Id_periodo, ev.Num_preguntas ORDER BY Id_periodo;");
            pstm.setString(1, idProfesor);

            System.out.println(pstm);
            rs = pstm.executeQuery();

            while(rs.next()){
                BeanReporte dato = new BeanReporte();
                dato.setPromedio(rs.getDouble("promedio"));
                dato.setNum_alumnos(rs.getInt("num_alumnos"));
                dato.setNum_preguntas(rs.getInt("num_preguntas"));

                BeanPeriodo periodo = new BeanPeriodo();
                periodo.setId(rs.getInt("Id_periodo"));
                periodo.setNombre(rs.getString("nombre_periodo"));
                dato.setPeriodo(periodo);

                BeanDocente docente = new BeanDocente();
                docente.setId_Matricula(rs.getString("Id_Matricula"));
                docente.setNombre(rs.getString("Nombre"));
                docente.setApellido1(rs.getString("Apellido1"));
                docente.setApellido2(rs.getString("Apellido2"));
                dato.setDocente(docente);

                datosReporte.add(dato);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                if(con!=null)
                    con.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        return datosReporte;
    }


    public int consultarPeriodoActivo(){
        int idPeriodo = 0;
        try{
            con = ConexionBD.getConnection();
            stm = con.createStatement();
            PreparedStatement pstm = con.prepareStatement("SELECT id FROM periodos WHERE estado = 1");
            rs = pstm.executeQuery();
            while(rs.next()){
                idPeriodo = rs.getInt(1);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try {
                if (con != null)
                    con.close();
                if (stm != null)
                    stm.close();
                if (rs != null)
                    rs.close();
                if (pstm != null)
                    pstm.close();
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        return idPeriodo;
    }
}
