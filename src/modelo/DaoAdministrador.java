package modelo;

import util.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoAdministrador {
    Connection con;
    PreparedStatement pstm;
    Statement stm;
    ResultSet rs;

    public BeanAdministrador consultarAdministrador(String usuario, String contrasenia){
        BeanAdministrador administrador = new BeanAdministrador();
        try{
            con = ConexionBD.getConnection();
            pstm = con.prepareStatement( "SELECT * FROM administradores WHERE nombreUsuario = ? AND contraseña = ?");
            pstm.setString(1, usuario);
            pstm.setString(2, contrasenia);
            rs = pstm.executeQuery();
            while(rs.next()){
                administrador.setId(rs.getInt("id"));
                administrador.setNombre(rs.getString("nombreUsuario"));
                administrador.setTipo(rs.getInt("tipo"));
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
        return administrador;
    }
    public boolean autenticar(String usuario, String contrasenia){
        boolean respuesta = false;

            try {
                con = ConexionBD.getConnection();
                pstm = con.prepareStatement( "SELECT * FROM administradores WHERE nombreUsuario = ? AND contraseña = ?");
                pstm.setString(1, usuario);
                pstm.setString(2, contrasenia);
                rs = pstm.executeQuery();
                while(rs.next()){
                    respuesta = true;
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    if (con != null) {
                        con.close();
                    }
                    if (pstm != null) {
                        pstm.close();
                    }
                    if (rs != null) {
                        rs.close();
                    }
                    if (stm != null) {
                        stm.close();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        return respuesta;
    }

    public static void main(String ... gatos){
        /*
        List<BeanAdministrador> administradores = new ArrayList<BeanAdministrador>();
        DaoAdministrador daoAdm = new DaoAdministrador();
        administradores = daoAdm.consultarAdministradores();

        for(BeanAdministrador asdf: administradores){
            System.out.println(asdf.getId());
            System.out.println(asdf.getNombre());
            System.out.println(asdf.getContrasenia());
        }

         */
        DaoAdministrador daoAdm = new DaoAdministrador();
        String usuario = "Luis";
        String contrasenia = "21312";
        boolean respuesta = false;

        respuesta = daoAdm.autenticar(usuario, contrasenia);
        System.out.println(respuesta);


    }

}
