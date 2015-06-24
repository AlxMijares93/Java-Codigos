/**
 *Clase hecha como ejemplo para el curso de java Avanzado
 * 
 */

package Ejemplo1;

import java.sql.*;

/**
 *
 * @author Alejandro FI
 */
public class BaseDatos {
 
    private String url; // url o ip donde se encuentra la base de datos
    private String user; // usuario de la base de datos(por default es root)
    private String pass; // contraseña de la base de datos(por defualt es "")
    private Connection conexion; // este objeto es el cual hara la conexion a la base de datos

    public BaseDatos(String url, String user, String pass) {
        
        //asignacion de los atributos de clase
        this.url = url;
        this.user = user;
        this.pass = pass;
        
        try{
            Class.forName("com.mysql.jdbc.Driver"); // importamos el driver de la base de datos   
            conexion= DriverManager.getConnection(url,user,pass); // creamos la conexion a la base de datos
        }catch(SQLException e){
            System.out.println("Error de sql");
        }catch(ClassNotFoundException ex){
            System.out.println("No se pudo cargar el driver MySQL");
        }
        
    }
    
    //metodo para hacer consultas SQL a la base de datos
    // como se puede presentar una excepcion de tipo SQLException 
    //agregamos la clausula throws
    public ResultSet hacerConsulta(String query) throws SQLException{
        Statement st = conexion.createStatement();//para poder hacer la consulta a la base necesitamos un objeto de la clase Statement 
        ResultSet rs = st.executeQuery(query); //el objeto st realiza la consulta y retorna el resultado en un objeto de la clase ResultSet
        return rs; // devolvemos la consulta al main
    }
    
    //metodo para poder insertar datos en la base de datos
    // como se puede presentar una excepcion de tipo SQLException 
    //agregamos la clausula throws
    public void insertarDatos(String query) throws SQLException{
        Statement st = conexion.createStatement(); // creamos el mismo objeto statement para realizar la insercion a la base de datos
        st.executeUpdate(query); // se ejecuta la consulta en la base de datos
    }
    
    //metodo para poder cerrar la conexion con la base de datos
    public void cerrarConexion() throws SQLException{
        conexion.close();
    }
    
    
    
}
