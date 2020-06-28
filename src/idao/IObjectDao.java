package idao;

import java.util.List;


public interface IObjectDao {
	
	public boolean crear(Object obj);
	public List<Object> leer();
	public boolean actualizar(Object obj);
	public boolean eliminar(Object obj);
	public Object obtener(int idObj);
	
}
