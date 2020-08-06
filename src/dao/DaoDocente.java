package dao;

import bean.BeanDocente;
import util.ConexionBD;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DaoDocente {
    Connection con;
    PreparedStatement pstm;
    Statement stm;
    ResultSet rs;

    public boolean agregarDocente(BeanDocente unDocenteX) {
        boolean respuesta = false;
        try {
            con = ConexionBD.getConnection();
            pstm = con.prepareStatement("INSERT INTO maestros (Id_Matricula,Nombre,Apellido1,Apellido2,Estado)VALUES(?,?,?,?,?)");
            pstm.setString(1, unDocenteX.getId_Matricula());
            pstm.setString(2, unDocenteX.getNombre());
            pstm.setString(3, unDocenteX.getApellido1());
            pstm.setString(4, unDocenteX.getApellido2());
            pstm.setInt(5,unDocenteX.getEstado());

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
    public boolean eliminarDocente(String matricula){
        boolean respuesta = false;
        try{

            con  = ConexionBD.getConnection();
            pstm = con.prepareStatement("DELETE FROM maestros WHERE Id_Matricula = ?");
            pstm.setString(1, matricula);

            respuesta = pstm.executeUpdate() == 1;

        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                if(con != null)
                    con.close();
                if(pstm!=null)
                    pstm.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        return respuesta;
    }
    public List<BeanDocente> consultarDocentes(){
        List<BeanDocente> docentes = new ArrayList<BeanDocente>();
        try{
            con = ConexionBD.getConnection();
            stm = con.createStatement();
            rs =stm.executeQuery("select * from maestros");
            while(rs.next()) {

                BeanDocente docenteX = new BeanDocente();
                docenteX.setId_Matricula(rs.getString("Id_Matricula"));
                docenteX.setNombre(rs.getString("Nombre"));
                docenteX.setApellido1(rs.getString("Apellido1"));
                docenteX.setApellido2(rs.getString("Apellido2"));
                docenteX.setEstado(rs.getInt("Estado"));
                docentes.add(docenteX);

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
                if(stm!=null){
                    stm.close();
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        return docentes;
    }

    public List<BeanDocente> consultarDocentesActivos(){
        List<BeanDocente> docentes = new ArrayList<BeanDocente>();
        try{
            con = ConexionBD.getConnection();
            stm = con.createStatement();
            rs =stm.executeQuery("select * from maestros WHERE Estado=1");
            while(rs.next()) {

                BeanDocente docenteX = new BeanDocente();
                docenteX.setId_Matricula(rs.getString("Id_Matricula"));
                docenteX.setNombre(rs.getString("Nombre"));
                docenteX.setApellido1(rs.getString("Apellido1"));
                docenteX.setApellido2(rs.getString("Apellido2"));
                docenteX.setEstado(rs.getInt("Estado"));
                docentes.add(docenteX);

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
                if(stm!=null){
                    stm.close();
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        return docentes;
    }

    public List<BeanDocente> consultarDocentesGrupo(int idGrupo){
        List<BeanDocente> docentes = new ArrayList<BeanDocente>();
        try{
            con = ConexionBD.getConnection();
            stm = con.createStatement();
            PreparedStatement pstm = con.prepareStatement("SELECT M.Id_Matricula, M.Nombre, M.Apellido1, M.Apellido2 FROM maestros_grupos MG INNER JOIN maestros M ON MG.id_maestro = M.Id_Matricula INNER JOIN grupos G ON G.id_grupo = MG.id_grupo WHERE MG.id_grupo = ? AND M.Estado = 1");
            pstm.setInt(1, idGrupo);
            rs = pstm.executeQuery();
            while(rs.next()) {

                BeanDocente docenteX = new BeanDocente();
                docenteX.setId_Matricula(rs.getString("Id_Matricula"));
                docenteX.setNombre(rs.getString("Nombre"));
                docenteX.setApellido1(rs.getString("Apellido1"));
                docenteX.setApellido2(rs.getString("Apellido2"));
                docentes.add(docenteX);

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
                if(stm!=null){
                    stm.close();
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        return docentes;
    }
    public boolean modificarDocente(String matricula, String nombre, String apellido1, String apellido2, int estado){
        boolean respuesta = false;
        try{
            con = ConexionBD.getConnection();
            pstm = con.prepareStatement("UPDATE maestros SET Nombre = ?, Apellido1 = ?,  Apellido2 = ?, Estado = ? WHERE Id_Matricula = ?");
            pstm.setString(1, nombre);
            pstm.setString(2, apellido1);
            pstm.setString(3, apellido2);
            pstm.setInt(4, estado);
            pstm.setString(5, matricula);

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

    public static void main(String [] args) {
        DaoDocente daoDoc = new DaoDocente();
        //CONSULTA DE MAESTROS SEGUN SU GRUPO
        /*
        List<BeanDocente> docentes = daoDoc.consultarDocentesGrupo(3);

        for(BeanDocente mostrar:docentes){
            System.out.println("matricula"+mostrar.getId_Matricula());
            System.out.println("nombre"+mostrar.getNombre());
            System.out.println("apellido1"+mostrar.getApellido1());
            System.out.println("apellido2"+mostrar.getApellido2());
        }
         */
        //ELIMINAR MAESTRO
        /*
        boolean respuesta = false;
        respuesta = daoDoc.eliminarDocente("2000ns001");
        System.out.println(respuesta);
         */
        //MODIFICAR TODOS LOS DATOS
        /*
        boolean respuesta = false;
        respuesta = daoDoc.modificarDocente("Luis", "Jimenez", "Jimenez", 1, "2000ns001");
        System.out.println(respuesta);
        */
        //INSERTAR DOCENTE
        BeanDocente docente = new BeanDocente("321", "felipe", "gonzales", "garcia", 1);
        boolean respuesta = daoDoc.agregarDocente(docente);
        System.out.println(respuesta);

    }
}
