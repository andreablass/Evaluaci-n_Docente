package dao;

import bean.BeanPeriodo;
import util.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoPeriodo {

    Connection con;
    PreparedStatement pstm;
    Statement stm;
    ResultSet rs;

    public List<BeanPeriodo> consultarPeriodos(){
        List<BeanPeriodo> periodos = new ArrayList<BeanPeriodo>();
        try{
            con = ConexionBD.getConnection();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT * FROM periodos");
            while(rs.next()){
                BeanPeriodo periodo = new BeanPeriodo();
                periodo.setId(rs.getInt("Id"));
                periodo.setFecha_inicio(rs.getString("Fecha_inicio"));
                periodo.setFecha_fin(rs.getString("Fecha_fin"));
                periodo.setEstado(rs.getInt("Estado"));
                periodo.setNombre(rs.getString("Nombre"));
                periodos.add(periodo);
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
        return periodos;
    }

    public boolean agregarPeriodo(String Nombre, String Fecha_inicio, String Fecha_fin){
        boolean respuesta = false;
        try{
            con = ConexionBD.getConnection();
            pstm = con.prepareStatement("INSERT INTO periodos (Fecha_inicio, Fecha_fin, Estado, Nombre) VALUES(?, ?, ?, ?)");
            pstm.setString(1,Fecha_inicio);
            pstm.setString(2,Fecha_fin);
            pstm.setInt(3, 1);
            pstm.setString(4, Nombre);

            respuesta = pstm.executeUpdate() ==1;

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

    public boolean eliminarPeriodo(int id){
        boolean respuesta = false;
        try{
            con = ConexionBD.getConnection();
            pstm = con.prepareStatement("UPDATE periodos SET Estado=0 WHERE Id = ?");
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

    public boolean modificarPeriodo(int id, String nombre, String fecha_inicio, String fecha_fin, int estado){
        boolean respuesta = false;
        try{
            con = ConexionBD.getConnection();
            pstm = con.prepareStatement("UPDATE periodos SET nombre = ?, Fecha_inicio = ?, Fecha_fin = ?, Estado = ? WHERE Id = ?");
            pstm.setString(1, nombre);
            pstm.setString(2, fecha_inicio);
            pstm.setString(3, fecha_fin);
            pstm.setInt(4, estado);
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

    public boolean desactivarPeriodosAnterior(){
        boolean respuesta = false;
        try{
            con = ConexionBD.getConnection();
            pstm = con.prepareStatement("UPDATE periodos SET Estado=0");
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

    public static void main(String ... Luis){

        DaoPeriodo daoPer = new DaoPeriodo();
        //CONSULTAR
        /*
        List<BeanPeriodo> periodos;
        periodos = daoPer.consultarPeriodos();
        for(BeanPeriodo asdf: periodos){
            System.out.println(asdf.getId());
            System.out.println(asdf.getNombre());
            System.out.println(asdf.getFecha_inicio());
            System.out.println(asdf.getFecha_fin());


        }
         */
        //AGREGAR

        boolean respuesta = false;
        respuesta = daoPer.modificarPeriodo(9, "nueve", "1919-07-20","3030-07-30", 0);
        System.out.println(respuesta);

//        boolean respuesta = false;
//        respuesta = daoPer.eliminarPeriodo(7);
//        System.out.println(respuesta);
    }

}
