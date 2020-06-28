package conectar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionSingleton {

	private static Connection conn = null;
	private String driver;
	private String url;
	private String usuario;
	private String password;
	
	/* toballatorre:
	 * Tengo las direcciones y todo en el XML tenemos
	 * que buscar la manera de hacer llegar los valores */
	private ConexionSingleton() { //revisar configuracion
		url = "jdbc:oracle:thin:@localhost:1521:xe";
		driver = "oracle.jdbc.driver.OracleDriver";
		usuario = "tinyprro"; //tinyprro
		password = "1234"; //1234
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, usuario, password);	
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		if (conn == null) {
			new ConexionSingleton();
		}
		return conn;
	}
}
