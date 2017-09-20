package DB;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.util.*;
/**
 *
 * @author ANDRES
 */
public class DBConexion {
    
public static void main(String[] args) throws Exception {
        //getConnection();
        Post();
    }

    
    public static void Post() throws Exception{
        try{
            Connection con= getConnection();
            PreparedStatement posted= con.prepareStatement("insert into usuario values('Gabriela','Saldaña','Aguilar','X','1997-09-09','pollyketpo@gmail.com',1)");
            posted.executeUpdate();
            
        }catch(Exception e){
            System.out.println(e);
        }finally{
            System.out.println("Insert completed.");
        }
    }
    
    public static Connection getConnection() throws Exception {
        try {
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/formulario";
            String username = "root";
            String password = "Keane1234";
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, username, password);
            //Statement stmt = conn.createStatement();
            //String sql = "describe persona";
            //ResultSet res = stmt.executeQuery(sql);
            //displayResults(res);
            System.out.println("Connected");
            //conn.close();
            return conn;
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
