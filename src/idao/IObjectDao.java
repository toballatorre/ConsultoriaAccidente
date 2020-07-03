package idao;

import java.util.List;


public interface IObjectDao <Obj>{// Generico para aplicar a todos los DAOs
	
	public boolean create(Obj o);
	public boolean delete(Object key);
	public boolean update(Obj o);
	
	public Obj read(Object key);
	public List<Obj> readAll();
	
}
