package dao;

import bean.BeanPregunta;
import util.ConexionBD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DaoPregunta {

    Connection con;
    PreparedStatement pstm;
    ResultSet rs;
    Statement stm;

    public List<BeanPregunta> consultarPreguntas(){
        List<BeanPregunta> preguntas = new ArrayList<BeanPregunta>();

        try{
            con = ConexionBD.getConnection();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT * FROM preguntas");
            while(rs.next()){
                BeanPregunta pregunta = new BeanPregunta();
                pregunta.setId(rs.getInt("idP"));
                pregunta.setDescripcion(rs.getString("Descripcion"));
                preguntas.add(pregunta);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                if(con!=null)
                    con.close();
                if(pstm!=null)
                    pstm.close();
                if(rs!=null)
                    rs.close();
                if(stm!=null)
                    stm.close();
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        return preguntas;
    }

    public List<BeanPregunta> consultarComentarios(){
        List<BeanPregunta> preguntas = new ArrayList<BeanPregunta>();

        try{
            con = ConexionBD.getConnection();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT * FROM comentarios");
            while(rs.next()){
                BeanPregunta pregunta = new BeanPregunta();
                pregunta.setId(rs.getInt("id_Comentario"));
                pregunta.setDescripcion(rs.getString("comentario"));
                preguntas.add(pregunta);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                if(con!=null)
                    con.close();
                if(pstm!=null)
                    pstm.close();
                if(rs!=null)
                    rs.close();
                if(stm!=null)
                    stm.close();
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        return preguntas;
    }
    public boolean agregarPregunta(int idP, String descripcion) {
        boolean respuesta = false;
        try {
            con = ConexionBD.getConnection();
            PreparedStatement pstm = con.prepareStatement("INSERT INTO preguntas (IdP, Descripcion)VALUES(?,?)");

            pstm.setInt(1, idP);
            pstm.setString(2, descripcion);

            respuesta = pstm.executeUpdate() == 1;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            try{
                if(con!=null)
                    con.close();
                if(pstm!=null)
                    con.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        return respuesta;
    }
    public boolean eliminarPregunta(int id) {
        boolean respuesta = false;

        try {
            con = ConexionBD.getConnection();
            pstm = con.prepareStatement("DELETE FROM preguntas WHERE IdP = ?");
            pstm.setInt(1, id);

            respuesta = pstm.executeUpdate() == 1;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            try{
                if(con!=null)
                    con.close();
                if(pstm!=null)
                    pstm.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        return respuesta;
    }

    public boolean modificarPregunta(int id, String descripcion) {
        boolean respuesta = false;

        try {
            con = ConexionBD.getConnection();
            pstm = con.prepareStatement("UPDATE preguntas SET Descripcion=? WHERE IdP=?");

            pstm.setString(1, descripcion);
            pstm.setInt(2, id);

            respuesta = pstm.executeUpdate() == 1;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            try{
                if(con!=null)
                    con.close();
                if(pstm!=null)
                    pstm.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }

        return respuesta;
    }

    public boolean eliminarComentario(int id) {
        boolean respuesta = false;

        try {
            con = ConexionBD.getConnection();
            pstm = con.prepareStatement("DELETE FROM comentarios WHERE id_Comentario = ?");
            pstm.setInt(1, id);

            respuesta = pstm.executeUpdate() == 1;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            try{
                if(con!=null)
                    con.close();
                if(pstm!=null)
                    pstm.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        return respuesta;
    }

    public boolean modificarComentario(int id, String descripcion) {
        boolean respuesta = false;

        try {
            con = ConexionBD.getConnection();
            pstm = con.prepareStatement("UPDATE comentarios SET comentario=? WHERE id_comentario=?");

            pstm.setString(1, descripcion);
            pstm.setInt(2, id);

            respuesta = pstm.executeUpdate() == 1;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            try{
                if(con!=null)
                    con.close();
                if(pstm!=null)
                    pstm.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        return respuesta;
    }

    public boolean agregarComentario(String descripcion) {
        boolean respuesta = false;
        try {
            con = ConexionBD.getConnection();
            PreparedStatement pstm = con.prepareStatement("INSERT INTO comentarios (comentario) VALUES(?)");
            pstm.setString(1, descripcion);
            respuesta = pstm.executeUpdate() == 1;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            try{
                if(con!=null)
                    con.close();
                if(pstm!=null)
                    con.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        return respuesta;
    }

    public static void main(String ... hola){
        DaoPregunta daoPre = new DaoPregunta();
        /*
        List<BeanPregunta> preguntasX = DaoPre.consultarComentarios();
        for(BeanPregunta asdf : preguntasX){
            System.out.println(asdf.getId());
            System.out.println(asdf.getDescripcion());
        }
         */
        //AGREGAR UN PREGUNTA
        /*
        boolean respuesta = daoPre.agregarPregunta(12, "esta es una pregunta de prueba");
        System.out.println(respuesta);
        */
        //EliminarPregunta
        /*
        boolean respuesta = daoPre.eliminarPregunta(14);
        System.out.println(respuesta);
         */
        //MODIFICAR PREGUNTA
        boolean respuesta = daoPre.modificarPregunta(12, "modificada");
        System.out.println(respuesta);
    }

}
