package DB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author EL BUEN ELITH
 */

public class cConexion {
    //Variables para la conexion con la base
    private String Driver_BD, Url_BD, Usuario_BD, Contrasena_BD;
    private Connection conexion=null;
    private Statement statequieto=null;
    //Constructor que sirve para inicializar variables para cualquier base de datos
    public cConexion(String driver, String url, String usuario, String contra){
        Driver_BD=driver;
        Url_BD=url;
        Usuario_BD=usuario;
        Contrasena_BD=contra;
    }
    //Constructor que sirve para inicializar variables para cualquier Base de Datos en MySql
    public cConexion(){
        Driver_BD="com.mysql.jdbc.Driver";
        Url_BD="jdbc:mysql://127.0.0.1:3306/formulario";
        Usuario_BD="root";
        Contrasena_BD="Keane1234";
    }
    //Conexion a la BD
    public void conectar(){
        try {
            Class.forName(Driver_BD).newInstance();
            conexion = DriverManager.getConnection(Url_BD, Usuario_BD, Contrasena_BD);

        } 
        catch ( SQLException err) {
            System.out.println("Error " + err.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(cConexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(cConexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(cConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Cerrar la conexion de BD
    public void cerrarConexion() throws SQLException {
        conexion.close();
    }
    //Metodos para ejecutar sentencias SQL
   //Metodos para ejecutar sentencias SQL
    public ResultSet consulta(String consulta) throws SQLException{
        statequieto = (Statement) conexion.createStatement();
        return statequieto.executeQuery("select * from usuario where curp='"+consulta+"';");
    }
    public void actualizar(String actualiza) throws SQLException{
        statequieto = (Statement) conexion.createStatement();
        statequieto.executeUpdate(actualiza);
        statequieto.closeOnCompletion();
    }
    public int borrar(String borra) throws SQLException{
        statequieto = (Statement) conexion.createStatement();
        return statequieto.executeUpdate(borra);
    }
    public void insertar(String inserta) throws SQLException{
        statequieto = (Statement) conexion.createStatement();
        statequieto.executeUpdate(inserta);
    }
}