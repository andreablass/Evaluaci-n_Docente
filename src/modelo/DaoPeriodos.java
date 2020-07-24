package modelo;

import util.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoPeriodos {
    Connection con;
    PreparedStatement pstm;
    Statement stm;
    ResultSet rs;

    // Agregar Periodos
    public boolean agregarPeriodo(BeanPeriodos agregaPeriodo) {
        boolean state = false;
        Connection con = null;

        try {
            con = ConexionBD.getConnection();
            String query = "INSERT INTO periodos (Id,Anio,Nombre)VALUES(?,?,?);";
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setInt(1, agregaPeriodo.getId());
            pstm.setFloat(2, agregaPeriodo.getAnio());
            pstm.setString(3, agregaPeriodo.getNombre());

            if (pstm.executeUpdate() == 1) {
                state = true;
            }

            pstm.close();
            con.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return state;
    }

    //Modificar Periodos

    public boolean modificarPeriodo(BeanPeriodos modificaPeriodo) {
        boolean state = false;
        Connection con = null;

        try {
            con = ConexionBD.getConnection();
            String query = "UPDATE periodos SET Anio=?, Nombre=?WHERE Id=?;";
            PreparedStatement pstm = con.prepareStatement(query);

            pstm.setFloat(1, modificaPeriodo.getAnio());
            pstm.setString(2, modificaPeriodo.getNombre());
            pstm.setInt(3, modificaPeriodo.getId());

            if (pstm.executeUpdate() == 1) {
                state = true;
            }

            pstm.close();
            con.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return state;
    }

    // Consultar Periodos

    public List<BeanPeriodos> consultarPeriodos() throws SQLException {
        List<BeanPeriodos> periodos = new ArrayList<BeanPeriodos>();
        try{
            con = ConexionBD.getConnection();
            stm = con.createStatement();
            rs =stm.executeQuery("select * from periodos");
            while(rs.next()) {

                BeanPeriodos periodoX = new BeanPeriodos();
                periodoX.setId(rs.getInt("Id"));
                periodoX.setAnio(rs.getFloat("Anio"));
                periodoX.setNombre(rs.getString("Nombre"));
                periodos.add(periodoX);

            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();

        }finally{
            try{
                if(con!=null){
                    con.close();
                }
                if(pstm!=null){
                    pstm.close();
                }
                if(rs!=null){
                    rs.close();
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        return periodos;
    }

    // Eliminar periodo

    public boolean eliminarPeriodo(BeanPeriodos eliminaPeriodo) {
        boolean state = false;
        Connection con = null;

        try {
            con = ConexionBD.getConnection();
            String query = "DELETE FROM periodos WHERE Id =?;";
            PreparedStatement pstm = con.prepareStatement(query);

            pstm.setInt(1, eliminaPeriodo.getId());


            if (pstm.executeUpdate() == 1) {
                state = true;
            }

            pstm.close();
            con.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return state;
    }
    //------------------------------------------------------------------------
    //Se hacen las pruebas

    public static void main(String[]args) throws SQLException {
        DaoPeriodos daoPer = new DaoPeriodos();

        //Agregar Periodo

         BeanPeriodos periodo = new BeanPeriodos();

        //periodo.setId(6);
        // periodo.setAnio(2019);
        //periodo.setNombre("Mayo-Agosto");

         boolean status = daoPer.agregarPeriodo(periodo);
        //System.out.println("Resultado:" + status);


        //Consultar Periodos

        //List<BeanPeriodos> periodos = daoPer.consultarPeriodos();
        //for (BeanPeriodos mostrar : periodos) {
            // System.out.println("Identificador" + mostrar.getId());
            // System.out.println("Año" + mostrar.getAnio());
            // System.out.println("Nombre" + mostrar.getNombre());

            // }

        //Modificar Periodos
        periodo = new BeanPeriodos();

        periodo.setId(1);
        periodo.setAnio(2090);
        periodo.setNombre("Mayo-abr");

        status = daoPer.modificarPeriodo(periodo);
        System.out.println("Resultado:" + status);

        //Eliminar periodos

        //eriodo = new BeanPeriodos();

        //periodo.setId(6);
        //status = daoPer.eliminarPeriodo(periodo);
        // System.out.println("Resultado" + status);

    }


}

