package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import idao.IObjectDao;
//import modelo.LoginDTO;
import modelo.UsuarioDTO;
import conectar.Conexion;

public class UsuarioDAO implements IObjectDao<UsuarioDTO> {

	private static final String SQL_INSERT = "INSERT INTO usuario (USUARIO, TIPOUSUARIO, CLAVE, MAIL, ACTIVO) VALUES(?, ?, ?, ?, ?)";
	private static final String SQL_DELETE = "DELETE FROM usuario WHERE idusuario = ?";
	private static final String SQL_UPDATE = "UPDATE USUARIO  SET USUARIO = ?, TIPOUSUARIO = ?, CLAVE = ?, MAIL = ?, ACTIVO = ? WHERE ROWID = ?";
	private static final String SQL_READ = "SELECT * FROM usuario WHERE idusuario = ?";
	private static final String SQL_READ_BY_USERNAME = "SELECT * FROM usuario WHERE usuario = ?";
	private static final String SQL_READALL = "SELECT * FROM usuario";
	
	private static final Conexion con = Conexion.connect();
	/**
	 * Crear e insertar un nuevo usuario
	 */
	@Override
	public boolean create(UsuarioDTO o) {
		boolean creado = false;
		PreparedStatement ps;
		
		try {
			ps = con.getConection().prepareStatement(SQL_INSERT);
			ps.setString(1, o.getUsuario());
			ps.setString(2, o.getTipousuario());
			ps.setString(3, o.getClave());
			ps.setString(4, o.getMail());
			ps.setString(5, o.getActivo());
				
			
			if (ps.executeUpdate() > 0) {
				creado = true;
			}
			
		} catch (SQLException e) {
			System.out.println("Error: ItemDAO create()");
			e.printStackTrace();
			
		} finally {
			con.closeConnection();
		}
		
		return creado;
	}
	/**
	 * Metodo que obtiene todos los Usuarios
	 */
	@Override
	public List<UsuarioDTO> readAll() {
		ArrayList<UsuarioDTO> listausers = new ArrayList<UsuarioDTO>();
		
		PreparedStatement ps;
		ResultSet res;
		
		try {
			ps = con.getConection().prepareStatement(SQL_READALL);
			res = ps.executeQuery();
			
			while(res.next()) {
				listausers.add(new UsuarioDTO(res.getInt("idusuario"), res.getString("usuario"), res.getString("tipousuario"), res.getString("clave"), res.getString("mail"),res.getString("activo")));
			}
			return listausers;
		} catch (SQLException e) {
			
			System.out.println("Error: UsuarioDAO leerUsuarios()");
			e.printStackTrace();
		} finally {
			con.closeConnection();
		}

		return listausers;
	}
	/**
	 * Actualizar los usuarios
	 */
	@Override
	public boolean update(UsuarioDTO o) {
		boolean actualizado = false;
		PreparedStatement ps;
		
		try {
			ps = con.getConection().prepareStatement(SQL_UPDATE);
			ps.setString(1, o.getUsuario());
			ps.setString(2, o.getTipousuario());
			ps.setString(3, o.getClave());
			ps.setString(4, o.getMail());
			ps.setString(5, o.getActivo());
					
			if(ps.executeUpdate() > 0) {
				actualizado = true;
			}
		}catch (Exception e) {
			System.out.println("Error: UsuarioDAO actualizarUsuario()");
			e.printStackTrace();
			
		}finally {
			con.closeConnection();
		}
		
		return actualizado;
	}
	/**
	 * Elimina un usuario seleccionado por ID
	 */
	@Override
	public boolean delete(Object key) {
		boolean borrado = false;
		PreparedStatement ps;
		
		try {
			ps = con.getConection().prepareStatement(SQL_DELETE);
			ps.setString(1, key.toString());
			
			if(ps.executeUpdate() > 0)
				borrado = true;
			
		} catch (Exception e) {
			System.out.println("Error: ItemDAO delete()");
			e.printStackTrace();
			
		}finally {
			con.closeConnection();
		}
		
		return borrado;
	}
	/**
	 * Obtiene un usuario por ID
	 */
	@Override
	public UsuarioDTO read(Object key) {
		UsuarioDTO i = null;
		
		PreparedStatement ps;
		ResultSet res;
		
		try {
			ps = con.getConection().prepareStatement(SQL_READ);
			ps.setString(1, key.toString());
			
			res = ps.executeQuery();
			
			while(res.next()) {
				i = new UsuarioDTO(res.getInt("idusuario"), res.getString("usuario"), res.getString("tipousuario"), res.getString("clave"), res.getString("mail"),res.getString("activo"));
			}
		} catch (SQLException e) {
			System.out.println("Error: UsuarioDAO read()");
			e.printStackTrace();
		}finally {
			con.closeConnection();
		}
				
		return i;
	}
	
	/**
	 * M�todo que retorna los datos del usuario usando por par�metro el username
	 * @param username
	 * @return retorna un DTO con todos los datos del usuario le�dos desde la Base de datos
	 */
	public UsuarioDTO readUsername(String username) {
		UsuarioDTO i = null;
		
		PreparedStatement ps;
		ResultSet res;
		
		try {
			ps = con.getConection().prepareStatement(SQL_READ_BY_USERNAME);
			ps.setString(1, username);
			
			res = ps.executeQuery();
			
			while(res.next()) {
				i = new UsuarioDTO(res.getInt("idusuario"), res.getString("usuario"), res.getString("tipousuario"), res.getString("clave"),res.getString("mail"),res.getString("activo"));
			}
		} catch (SQLException e) {
			System.out.println("Error: LoginDAO read()");
			e.printStackTrace();
		}finally {
			con.closeConnection();
		}		
		return i;
	}

}
