package modelo;

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
        boolean state = false;
        Connection con = null;
        //Aqui son como estan en bd
        try {
            con = ConexionBD.getConnection();
            String query = "INSERT INTO maestros (Id_Matricula,Nombre,Apellido1,Apellido2,Estado)VALUES(?,?,?,?,?);";
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setString(1, unDocenteX.getId_Matricula());
            pstm.setString(2, unDocenteX.getNombre());
            pstm.setString(3, unDocenteX.getApellido1());
            pstm.setString(4, unDocenteX.getApellido2());
            pstm.setBoolean(5,true);


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

    public static void main(String [] args) {
        DaoDocente daoDoc = new DaoDocente();
        List<BeanDocente> docentes = daoDoc.consultarDocentesGrupo(1);

        for(BeanDocente mostrar:docentes){
            System.out.println("matricula"+mostrar.getId_Matricula());
            System.out.println("nombre"+mostrar.getNombre());
            System.out.println("apellido1"+mostrar.getApellido1());
            System.out.println("apellido2"+mostrar.getApellido2());
        }
    }
}
