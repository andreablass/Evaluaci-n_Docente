package modelo;

import util.ConexionBD;

import java.sql.Connection;
import java.sql.*;


public class DaoToken {

    Connection con;
    PreparedStatement pstm;
    ResultSet rs;
    Statement stm;

    public boolean consultarToken(String token){
        boolean respuesta = false;
        try{
            con = ConexionBD.getConnection();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT * FROM grupos");
            while(rs.next()){
                if(token.equals(rs.getString("Token"))){
                    respuesta = true;
                }
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
        return respuesta;
    }

    public String obtenerGrupo(String token){
        String grupo = "";
        try{
            con = ConexionBD.getConnection();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT * FROM grupos");
            while(rs.next()){
                if(token.equals(rs.getString("Token"))){
                    grupo = rs.getString("Id_nombre");
                }
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
        return grupo;
    }

    public boolean registroAlumno(String grupo, String correo){
        boolean respuesta = false;
        try{
            con = ConexionBD.getConnection();
            pstm = con.prepareStatement("INSERT INTO alumnos(Id_grupo, correo) VALUES(?,?)");
            pstm.setString(1,grupo);
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


}
