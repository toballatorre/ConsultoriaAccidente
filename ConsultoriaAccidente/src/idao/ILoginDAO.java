package idao;

import java.util.List;

public interface ILoginDAO <Obj>{
	
	public boolean create(Obj o);
	public boolean delete(Object key);
	public boolean update(Obj o);
	
	public Obj read(Object key);
	public List<Obj> readAll();
	
}