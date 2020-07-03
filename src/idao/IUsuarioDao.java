package idao;

import java.util.List;

import modelo.UsuarioDTO;

public interface IUsuarioDao {

	public boolean crearUsuario(UsuarioDTO user);
	public List<UsuarioDTO> leerUsuarios();
	public boolean actualizarUsuario(UsuarioDTO user);
	//public boolean eliminarUsuario(Object key);
	public UsuarioDTO obtenerUsuario(Object key);
	boolean eliminarUsuario(UsuarioDTO user);
	
}
