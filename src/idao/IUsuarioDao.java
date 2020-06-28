package idao;

import java.util.List;

import modelo.Usuario;

public interface IUsuarioDao {

	public boolean crearUsuario(Usuario user);
	public List<Usuario> leerUsuarios();
	public boolean actualizarUsuario(Usuario user);
	public boolean eliminarUsuario(Usuario user);
	public Usuario obtenerUsuario(int idusuario);
	
}
