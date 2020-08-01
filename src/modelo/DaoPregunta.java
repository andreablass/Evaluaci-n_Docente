package modelo;

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

    public static void main(String ... hola){
        DaoPregunta DaoPre = new DaoPregunta();
        List<BeanPregunta> preguntasX = DaoPre.consultarComentarios();
        for(BeanPregunta asdf : preguntasX){
            System.out.println(asdf.getId());
            System.out.println(asdf.getDescripcion());
        }
    }

}
