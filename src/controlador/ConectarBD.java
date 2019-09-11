/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.sql.*;

/**
 *
 * @author Estudiante
 */
public class ConectarBD 
{
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/colsoft?serverTimezone=UTC";
    private Connection con;

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public void conectarme() throws SQLException {

        try {
            setCon(DriverManager.getConnection(url, "root", "1234"));
            Class.forName(driver);
        } catch (ClassNotFoundException cl) {
            System.out.println(cl.getMessage());
        }
        
    }
}
