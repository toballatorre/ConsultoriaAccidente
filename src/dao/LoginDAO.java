package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conectar.Conexion;
import idao.ILoginDAO;
import modelo.LoginDTO;

public class LoginDAO implements ILoginDAO<LoginDTO>{
	//private static final String SQL_INSERT = "INSERT INTO ";
	//private static final String SQL_DELETE = "DELETE FROM ";
	//private static final String SQL_UPDATE = "UPDATE ";
	private static final String SQL_READ = "select * from usuario where idusuario = '?'";
	private static final String SQL_READALL = "SELECT * FROM usuario";
	
	private static final Conexion con = Conexion.connect();
	
	@Override
	public LoginDTO read(Object key) {
		LoginDTO i = null;
		
		PreparedStatement ps;
		ResultSet res;
		
		key = key.toString();
		try {
			ps = con.getConection().prepareStatement(SQL_READ);
			ps.setString(1, key.toString());
			
			res = ps.executeQuery();
			
			while(res.next()) {
				i = new LoginDTO(res.getInt("idusuario"), res.getString("usuario"), res.getString("tipousuario"), res.getString("clave"),res.getString("mail"),res.getString("activo"));
			}
		} catch (SQLException e) {
			System.out.println("Error: LoginDAO read()");
			e.printStackTrace();
		}finally {
			con.closeConnection();
		}
				
		return i;
	}

	@Override
	public List<LoginDTO> readAll() {
		ArrayList<LoginDTO> listaLogin = new ArrayList<LoginDTO>();
		PreparedStatement ps;
		ResultSet res;
		
		try {
			ps = con.getConection().prepareStatement(SQL_READALL);
			res = ps.executeQuery();
			
			while(res.next()) {
				listaLogin.add(new LoginDTO(res.getInt("idusuario"), res.getString("usuario"), res.getString("tipousuario"), res.getString("clave"),res.getString("mail"),res.getString("activo")));
			}
			
		} catch (SQLException e) {
			
			System.out.println("Error: LoginDAO readAll");
			e.printStackTrace();
		} finally {
			con.closeConnection();
		}

		return listaLogin;
	}

	@Override
	public boolean create(LoginDTO o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Object key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(LoginDTO o) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
