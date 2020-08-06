package dao;

import util.ConexionBD;

import java.sql.*;

public class DaoEvaluacion {

    Connection con;
    PreparedStatement pstm;
    ResultSet rs;
    Statement stm;

    public boolean registroComentarios(String idMaestro, int idAlumno, int idPeriodo, int idComentario, String comentario){
        boolean respuesta = false;
        try{
            con = ConexionBD.getConnection();
            pstm = con.prepareStatement("INSERT INTO comentariosevaluacion (Id_maestro, Id_alumno,Id_periodo, id_comentario,comentario_alumno) VALUES(?, ?, ?, ?, ?)");
            pstm.setString(1, idMaestro);
            pstm.setInt(2, idAlumno);
            pstm.setInt(3, idPeriodo);
            pstm.setInt(4, idComentario);
            pstm.setString(5, comentario);
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

    public boolean registroEvaluacion(String idMaestro, int idAlumno, int idPeriodo, int numPreguntas, double promedio){
        boolean respuesta = false;
        try{
            con = ConexionBD.getConnection();
            pstm = con.prepareStatement("INSERT INTO evaluaciones (Id_maestro, Id_alumno, Id_periodo, Num_preguntas, Promedio) VALUES (?, ?, ?, ?, ?)");
            pstm.setString(1, idMaestro);
            pstm.setInt(2, idAlumno);
            pstm.setInt(3, idPeriodo);
            pstm.setInt(4, numPreguntas);
            pstm.setDouble(5, promedio);
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



}
