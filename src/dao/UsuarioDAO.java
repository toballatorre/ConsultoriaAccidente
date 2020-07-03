package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import idao.IUsuarioDao;
import modelo.UsuarioDTO;
import conectar.Conexion;

public class UsuarioDAO implements IUsuarioDao {

	private static final String SQL_INSERT = "INSERT INTO usuario (USUARIO, TIPOUSUARIO, CLAVE, MAIL, ACTIVO) VALUES(?, ?, ?, ?, ?)";
	private static final String SQL_DELETE = "DELETE FROM usuario WHERE idusuario = ?";
	private static final String SQL_UPDATE = "UPDATE USUARIO  SET USUARIO = ?, TIPOUSUARIO = ?, CLAVE = ?, MAIL = ?, ACTIVO = ? WHERE ROWID = ?";
	private static final String SQL_READ = "SELECT * FROM usuario WHERE idusuario = ?";
	private static final String SQL_READALL = "SELECT * FROM item";
	
	private static final Conexion con = Conexion.connect();
	
	@Override
	public boolean crearUsuario(UsuarioDTO user) {
		boolean creado = false;
		PreparedStatement ps;
		
		try {
			ps = con.getConection().prepareStatement(SQL_INSERT);
			ps.setString(1, user.getUsuario());
			ps.setString(2, user.getTipousuario());
			ps.setString(3, user.getClave());
			ps.setString(4, user.getMail());
			ps.setString(5, user.getActivo());
				
			
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


	@Override
	public List<UsuarioDTO> leerUsuarios() {
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


	@Override
	public boolean actualizarUsuario(UsuarioDTO user) {
		
		boolean actualizado = false;
		PreparedStatement ps;
		
		try {
			ps = con.getConection().prepareStatement(SQL_UPDATE);
			ps.setString(1, user.getUsuario());
			ps.setString(2, user.getTipousuario());
			ps.setString(3, user.getClave());
			ps.setString(4, user.getMail());
			ps.setString(5, user.getActivo());
					
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

	@Override
	public boolean eliminarUsuario(UsuarioDTO user) {
		boolean borrado = false;
		PreparedStatement ps;
		
		try {
			ps = con.getConection().prepareStatement(SQL_DELETE);
			ps.setString(1, user.toString());
			
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

	@Override
	public UsuarioDTO obtenerUsuario(Object key) {
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
			System.out.println("Error: UsuarioDAO obtenerUsuario()");
			e.printStackTrace();
		}finally {
			con.closeConnection();
		}
				
		return i;
	}
	
	
}
