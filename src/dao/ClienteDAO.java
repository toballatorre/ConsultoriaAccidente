package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import conectar.Conexion;
import idao.IObjectDao;
import modelo.ClienteDTO;

public class ClienteDAO implements IObjectDao<ClienteDTO> {
	private static final String SQL_READ = "SELECT * FROM cliente WHERE USUARIO_IDUSUARIO = ?";
	
	private static final Conexion con = Conexion.connect();

	@Override
	public boolean create(ClienteDTO o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Object key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(ClienteDTO o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ClienteDTO read(Object key) {
		ClienteDTO i = null;
		
		PreparedStatement ps;
		ResultSet res;
		
		try {
			ps = con.getConection().prepareStatement(SQL_READ);
			ps.setInt(1, (int) key);
			
			res = ps.executeQuery();
			
			while(res.next()) {
				i = new ClienteDTO(res.getInt("IDCLIENTE"), res.getString("NOMBREEMPRESA"), res.getString("RUTEMPRESA"), res.getInt("USUARIO_IDUSUARIO"));
			}
		} catch (SQLException e) {
			System.out.println("Error: ClienteDAO read()");
			e.printStackTrace();
		}finally {
			con.closeConnection();
		}		
		return i;
	
	}

	@Override
	public List<ClienteDTO> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
