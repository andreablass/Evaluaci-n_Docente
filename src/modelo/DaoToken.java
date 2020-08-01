package modelo;

import util.ConexionBD;

import java.sql.Connection;
import java.sql.*;


public class DaoToken {

    Connection con;
    PreparedStatement pstm;
    ResultSet rs;
    Statement stm;

    public int consultarToken(String token){
        int idGrupo = 0;
        try{
            con = ConexionBD.getConnection();
            stm = con.createStatement();
            PreparedStatement pstm = con.prepareStatement("SELECT * FROM grupos WHERE Token = ?");
            pstm.setString(1, token);
            rs = pstm.executeQuery();
            while(rs.next()){
                idGrupo = rs.getInt("id_grupo");
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
        return idGrupo;
    }

    public int consultarAlumno(int idGrupo, String correo){
        int idAlumno = 0;
        try{
            con = ConexionBD.getConnection();
            stm = con.createStatement();
            PreparedStatement pstm = con.prepareStatement("SELECT Id FROM alumnos WHERE Id_grupo = ? AND correo = ?");
            pstm.setInt(1, idGrupo);
            pstm.setString(2, correo);
            rs = pstm.executeQuery();
            while(rs.next()){
                idAlumno = rs.getInt("Id");
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
        return idAlumno;
    }

    public int consultarProgresoEncuesta(int idAlumno, int idPeriodo){
        int index = 0;
        try{
            con = ConexionBD.getConnection();
            stm = con.createStatement();
            pstm = con.prepareStatement("SELECT COUNT(*) FROM evaluaciones WHERE Id_alumno = ? AND Id_periodo = ?");
            pstm.setInt(1, idAlumno);
            pstm.setInt(2, idPeriodo);
            rs = pstm.executeQuery();
            while(rs.next()){
                index = rs.getInt(1);
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
        return index;
    }



    public boolean registroAlumno(int idGrupo, String correo){
        boolean respuesta = false;
        try{
            con = ConexionBD.getConnection();
            pstm = con.prepareStatement("INSERT INTO alumnos(Id_grupo, correo) VALUES(?, ?)");
            pstm.setInt(1, idGrupo);
            pstm.setString(2, correo);

            respuesta = pstm.executeUpdate() == 1;
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
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
        return respuesta;
    }
    //SELECT id FROM periodos WHERE estado = 1 AND CURRENT_DATE() BETWEEN Fecha_inicio AND Fecha_fin
    public int consultarPeriodoActivo(){
        int idPeriodo = 0;
        try{
            con = ConexionBD.getConnection();
            stm = con.createStatement();
            PreparedStatement pstm = con.prepareStatement("SELECT id FROM periodos WHERE estado = 1 AND CURRENT_DATE() BETWEEN Fecha_inicio AND Fecha_fin");
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
    public static void main(String[] args){

        DaoToken daTok = new DaoToken();
        boolean respuesta = daTok.registroAlumno(5,"sdfadsfdfg");
        System.out.println(respuesta);

    }



}
