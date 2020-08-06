package dao;

import bean.BeanAdministrador;
import util.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoAdministrador {
    Connection con;
    PreparedStatement pstm;
    Statement stm;
    ResultSet rs;

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

    public List<BeanAdministrador> consultarAdministradores(){
        List<BeanAdministrador> administradores = new ArrayList<>();

        try{
            con = ConexionBD.getConnection();
            pstm = con.prepareStatement( "SELECT * FROM administradores");
            rs = pstm.executeQuery();
            while(rs.next()){
                BeanAdministrador administrador = new BeanAdministrador();
                administrador.setId(rs.getInt("id"));
                administrador.setNombreUsuario(rs.getString("nombreUsuario"));
                administrador.setNombre(rs.getString("Nombre"));
                administrador.setApellido1(rs.getString("Apellido1"));
                administrador.setApellido2(rs.getString("Apellido2"));
                administrador.setTipo(rs.getInt("tipo"));
                administradores.add(administrador);
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
        return administradores;
    }

    public boolean agregarAdministrador(BeanAdministrador bean){
        boolean respuesta = false;

        try {
            con = ConexionBD.getConnection();
            pstm = con.prepareStatement( "INSERT INTO administradores(nombreUsuario, Nombre, Apellido1, Apellido2, contraseña, tipo) VALUES (?,?,?,?,?,?)");
            pstm.setString(1, bean.getNombreUsuario());
            pstm.setString(2, bean.getNombre());
            pstm.setString(3, bean.getApellido1());
            pstm.setString(4, bean.getApellido2());
            pstm.setString(5, bean.getContrasenia());
            pstm.setInt(6, bean.getTipo());

            respuesta = pstm.execute();

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

    public boolean modificarAdministrador(BeanAdministrador bean){
        boolean respuesta = false;

        try {
            con = ConexionBD.getConnection();
            pstm = con.prepareStatement( "UPDATE administradores SET nombreUsuario=?, Nombre=?, Apellido1=?, Apellido2=?, contraseña=?, tipo=? WHERE Id=?");
            pstm.setString(1, bean.getNombreUsuario());
            pstm.setString(2, bean.getNombre());
            pstm.setString(3, bean.getApellido1());
            pstm.setString(4, bean.getApellido2());
            pstm.setString(5, bean.getContrasenia());
            pstm.setInt(6, bean.getTipo());
            pstm.setInt(7, bean.getId());

            respuesta = pstm.execute();

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

    public boolean eliminarAdministrador(int id){
        boolean respuesta = false;

        try {
            con = ConexionBD.getConnection();
            pstm = con.prepareStatement( "DELETE FROM administradores WHERE Id=?");
            pstm.setInt(1,id);

            respuesta = pstm.execute();

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
