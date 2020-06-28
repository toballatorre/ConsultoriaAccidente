package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import idao.IUsuarioDao;
import modelo.Usuario;
import conectar.ConexionSingleton;

public class UsuarioDao implements IUsuarioDao {

	@Override
	public boolean crearUsuario(Usuario user) {
		// TODO Auto-generated method stub

		boolean registrar = false;
		
		Statement stm = null;
		Connection con = null;
		
		String sql = "INSERT INTO usuario VALUES (null,'" + user.getNombre() + "','"+ user.getApellido()+"','"+user.getCorreo()+"','"+user.getTelefono()+"')";
		
		try {
			con = ConexionSingleton.getConnection();
			stm = con.createStatement();
			stm.execute(sql);
			registrar = true;
			stm.close();
			//con.close();
		}catch(SQLException e) {
			System.out.println("Error: Clase UsuarioDao, método crearUsuario");
			e.printStackTrace();
		}
		
		return registrar;	
	
	}

	@Override
	public List<Usuario> leerUsuarios() {
		// TODO Auto-generated method stub

		Connection con = null;
		Statement stm = null;
		ResultSet rs = null;
		
		String sql = "select * from usuario ORDER BY ID";
		
		List<Usuario> listaUsuarios = new ArrayList<Usuario>();
		
		try {
			con = ConexionSingleton.getConnection();
			stm = con.createStatement();
			rs = stm.executeQuery(sql);
			while (rs.next()) {
				Usuario c = new Usuario();
				c.setId(rs.getInt(1));
				c.setNombre(rs.getString(2));
				c.setApellido(rs.getString(3));
				c.setCorreo(rs.getString(4));
				c.setTelefono(rs.getString(5));
				listaUsuarios.add(c);
			}
			stm.close();
			rs.close();
			//con.close();
		} catch(SQLException e) {
			System.out.println("Error: Clase UsuarioDao, método leerUsuarios ");
			e.printStackTrace();
		}
		
		return listaUsuarios;
	}

	@Override
	public boolean actualizarUsuario(Usuario user) {
		// TODO Auto-generated method stub

		Connection con = null;
		Statement stm = null;
		
		boolean actualizar = false;
		
		String sql = "UPDATE usuario SET nombre = '" + user.getNombre() + "', apellido = '" + user.getApellido() + "', correo = '" + user.getCorreo() + "', telefono = '"+user.getTelefono()+"' WHERE id = '" + user.getId() + "'";
		
		try {
			con = ConexionSingleton.getConnection();
			stm = con.createStatement();
			stm.execute(sql);
			actualizar = true;
			stm.close();
			//con.close();
		}catch(SQLException e) {
			System.out.println("Error: Clase UsuarioDao, método actualizar");
			e.printStackTrace();
		}
		
		return actualizar;

	}

	@Override
	public boolean eliminarUsuario(Usuario user) {
		// TODO Auto-generated method stub
		Connection con = null;
		Statement stm = null;
		
		boolean eliminar = false;
		
		String sql = "DELETE FROM usuario WHERE id = " + user.getId();
		
		try {
			con = ConexionSingleton.getConnection();
			stm = con.createStatement();
			stm.execute(sql);
			eliminar = true;
			stm.close();
			//con.close();
		}catch(SQLException e) {
			System.out.println("Error: Clase UsuarioDao, método eliminarUsuario");
			e.printStackTrace();
		}
		
		return eliminar;
	}

	@Override
	public Usuario obtenerUsuario(int idusuario) {
		Connection con = null;
		Statement stm = null;
		ResultSet rs = null;
		
		String sql = "select * from usuario where ID = " + idusuario;
		
		Usuario u = new Usuario();
		try {
			con = ConexionSingleton.getConnection();
			stm = con.createStatement();
			rs = stm.executeQuery(sql);
			while (rs.next()) {
				u.setId(rs.getInt(1));
				u.setNombre(rs.getString(2));
				u.setApellido(rs.getString(3));
				u.setCorreo(rs.getString(4));
				u.setTelefono(rs.getString(5));
			}
			stm.close();
			rs.close();
			//con.close();
		} catch(SQLException e) {
			System.out.println("Error: Clase UsuarioDao, método obtenerUsuario ");
			e.printStackTrace();
		}
		
		return u;
	}

	
	
}
