package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    public static Connection getConnection() throws SQLException {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException ex){
            ex.printStackTrace();
        }

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/evaluacionDocente?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatatimeZoneCode=false&serverTimezone=UTC","root","root");

        return con;
    }

    public static void main(String ... gatos){
        try{
            Connection con = ConexionBD.getConnection();
            System.out.println("Conexion Exitosa");
            con.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }

}
