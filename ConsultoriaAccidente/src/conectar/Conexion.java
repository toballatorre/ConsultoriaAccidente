package conectar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	public static Conexion instancia = null;//Singleton
	private static Connection con;
	
	// Atributos para hacer la conexión a la base de datos
	private String url;
	private String driver;
	private String user;
	private String password;
	
	// Constructor privado para no hacer multiples instancias
	private Conexion() {
		
		// Datos para la conexión a la base de datos
		url = "jdbc:oracle:thin:@localhost:1521:xe";
		driver = "oracle.jdbc.driver.OracleDriver";
		user = "consultoria";
		password = "consultoria";
		
		try {
			Class.forName(driver);//driver
			con = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Error: Conexion - Constructor");
			e.printStackTrace();
		}	
	}
	
	public synchronized static Conexion connect() {
		if(instancia == null) {
			instancia = new Conexion();
		}
		return instancia;
	}
	
	public Connection getConection() {
		return con;
	}
	
	public void closeConnection() {
		instancia = null;
	}
}
