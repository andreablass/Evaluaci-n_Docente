package dao;

import bean.BeanGrupo;
import util.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoGrupo {

    Connection con;
    PreparedStatement pstm;
    Statement stm;
    ResultSet rs;

    public List<BeanGrupo> consultarGrupos(){
        List<BeanGrupo> grupos = new ArrayList<BeanGrupo>();

        try{
            con = ConexionBD.getConnection();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT * FROM grupos");
            while(rs.next()){
                BeanGrupo grupo = new BeanGrupo();
                grupo.setId_grupo(rs.getInt("id_grupo"));
                grupo.setToken(rs.getString("Token"));
                grupo.setNum_Alum(rs.getInt("Num_Alum"));
                grupo.setCompletado(rs.getInt("Completado"));
                grupo.setGrupo(rs.getString("Grupo"));
                grupo.setCuatrimestre(rs.getString("Cuatrimestre"));
                grupo.setCarrera(rs.getString("Carrera"));
                grupo.setEstado(rs.getBoolean("Estado"));
                grupos.add(grupo);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
               if(con!=null)
                   con.close();
               if(stm!=null)
                   stm.close();
               if(rs!=null)
                   rs.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        return grupos;
    }
    public boolean agregarGrupo(BeanGrupo grupo){
        boolean respuesta = false;
        try{
            con = ConexionBD.getConnection();
            pstm = con.prepareStatement("INSERT INTO grupos (Token, Num_Alum, Completado, Grupo, Cuatrimestre, Carrera) VALUES(?, ?, ?, ?, ?, ?)");
            pstm.setString(1, grupo.getToken());
            pstm.setInt(2, grupo.getNum_Alum());
            pstm.setInt(3, grupo.getCompletado());
            pstm.setString(4, grupo.getGrupo());
            pstm.setString(5, grupo.getCuatrimestre());
            pstm.setString(6, grupo.getCarrera());

            respuesta = pstm.executeUpdate() == 1;

        }catch(SQLException ex){
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

    public boolean eliminarGrupo(int id){
        boolean respuesta = false;
        try{
            con = ConexionBD.getConnection();
            pstm = con.prepareStatement("UPDATE grupos SET Estado=0 WHERE id_grupo=?;");
            pstm.setInt(1, id);
            respuesta = pstm.executeUpdate() == 1;
        }catch(SQLException ex){
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

    public boolean modificarGrupo(int id, int num_alum, String grupo, String cuatrimestre, String carrera){
        boolean respuesta = false;
        try{
            con = ConexionBD.getConnection();
            pstm = con.prepareStatement("UPDATE grupos SET Num_Alum = ?, Grupo = ?, Cuatrimestre = ?, Carrera = ? WHERE id_grupo = ?");
            pstm.setInt(1, num_alum);
            pstm.setString(2, grupo);
            pstm.setString(3, cuatrimestre);
            pstm.setString(4, carrera);
            pstm.setInt(5, id);
            respuesta = pstm.executeUpdate() == 1;
        }catch(SQLException ex){
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
    public boolean compararToken(String token){
        boolean respuesta = false;
        try{
            con = ConexionBD.getConnection();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT * FROM grupos");
            while(rs.next()){
                if(rs.getString("Token").equals(token)){
                    respuesta = true;
                }
            }
        }catch(SQLException ex){
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
    public boolean setGrupoMaestros(String id_maestro, int id_grupo){
        boolean respuesta = false;
        try{
            con = ConexionBD.getConnection();
            pstm = con.prepareStatement("INSERT INTO maestros_grupos (id_maestro, id_grupo) VALUES(?, ?)");
            pstm.setString(1, id_maestro);
            pstm.setInt(2, id_grupo);
            respuesta = pstm.executeUpdate() == 1;
        }catch(SQLException ex){
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
    public int consultarIdGrupo(String token){
        int id = 0;
        try{
            con = ConexionBD.getConnection();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT * FROM grupos");
            while(rs.next()){
                if(rs.getString("Token").equals(token))
                    id = rs.getInt("id_grupo");
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
        return id;
    }

    public boolean eliminarGrupoRelaciones(int id_grupo){
        boolean respuesta = false;
        try{
            con = ConexionBD.getConnection();
            pstm = con.prepareStatement("DELETE FROM maestros_grupos WHERE id_grupo = ?");
            pstm.setInt(1, id_grupo);
            respuesta = pstm.executeUpdate() != 0;
        }catch(SQLException ex){
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



    public static void main(String ... Luis){
        DaoGrupo daoGrp = new DaoGrupo();
        /*
        List<BeanGrupo> grupos = new ArrayList<BeanGrupo>();
        grupos = daoGrp.consultarGrupos();
        for(BeanGrupo asdf: grupos){
            System.out.println(asdf.getToken());
        }
         */
        //AGREGAR
        /*
        boolean respuesta;
        BeanGrupo grupoA = new BeanGrupo("735", 20, 1, "6 B", "1", "Sistemas");
        respuesta = daoGrp.agregarGrupo(grupoA);
        System.out.println(respuesta);
         */
        //MODIFICAR GRUPO
        /*
        boolean respuesta = daoGrp.modificarGrupo(89,  1,  "probando", "1", "diseño");
        System.out.println(respuesta);
         */
        //PROBANDO SI SE CREO UN TOKEN YA EXISTENTE
        /*
        boolean respuesta = daoGrp.compararToken("34567");
        System.out.println(respuesta);
         */
        //RELACIONAR GRUPOS MAESTROS
        /*
        boolean esmeralda = false;
        esmeralda = daoGrp.setGrupoMaestros("2001dc030", 5);
        System.out.println(esmeralda);
         */
        //CONSULTAR EL ID EN BASE AL TOKEN
        /*int id;
        id = daoGrp.consultarIdGrupo("23456");
        System.out.println(id);
        */
        //ELIMINAR RELACIONES

        boolean respuesta;
        respuesta = daoGrp.eliminarGrupoRelaciones(26);
        System.out.println(respuesta);

    }
}
