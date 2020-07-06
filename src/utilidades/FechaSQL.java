package utilidades;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * Conversor de fechas de html a sql
 * @author Cristobal L
 *
 */
public class FechaSQL {

	public FechaSQL(){
		
	}
	/**
	 * Se ingresa el string de fecha y lo convierte a java.sql.Date
	 * @param string
	 * @return Retorna un objeto java.sql.Date para ingresar a sql
	 */
	public java.sql.Date toSQL(String string){
		
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		Date f = new Date();
		try {
			f = format.parse(string);
		} catch (ParseException e) {
			System.out.println("Error: FechaSQL parse fecha a simple format");
			e.printStackTrace();
		}
		java.sql.Date sqlFecha = new java.sql.Date(f.getTime());
		
		return sqlFecha;
	}
	
}
