package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conectar.Conexion;
import idao.IObjectDao;
import modelo.ClienteDTO;

public class ClienteDAO implements IObjectDao<ClienteDTO> {

  private static final String SQL_UPDATE = "UPDATE cliente SET NOMBREEMPRESA = ?, RUTEMPRESA = ? ,USUARIO_IDUSUARIO = ? WHERE IDCLIENTE = ?";
	private static final String SQL_READBYCLIENTE = "SELECT * FROM cliente WHERE IDCLIENTE = ?";
  private static final String SQL_READBYUSUARIO = "SELECT * FROM cliente WHERE USUARIO_IDUSUARIO = ?";
  private static final String SQL_READALL = "SELECT * FROM cliente";
  
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
		boolean actualizado = false;
		PreparedStatement ps;
		
		try {
			ps = con.getConection().prepareStatement(SQL_UPDATE);
			ps.setString(1, o.getNombreEmpresa());
			ps.setString(2, o.getRutEmpresa());
			ps.setInt(3, o.getIdUsuario());
			ps.setInt(4, o.getIdCliente());
			System.out.println(o.getNombreEmpresa());
			System.out.println(o.getRutEmpresa());
			System.out.println(o.getIdCliente());
			System.out.println(o.getIdUsuario());
					
			if(ps.executeUpdate() > 0) {
				actualizado = true;
			}
		}catch (Exception e) {
			System.out.println("Error: ClienteDAO update()");
			e.printStackTrace();
			
		}finally {
			con.closeConnection();
		}
		
		return actualizado;
	
	}

	@Override
	public ClienteDTO read(Object key) {
		ClienteDTO i = null;
		
		PreparedStatement ps;
		ResultSet res;
		
		try {
			ps = con.getConection().prepareStatement(SQL_READBYUSUARIO);
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
		ArrayList<ClienteDTO> lista = new ArrayList<ClienteDTO>();
		
		PreparedStatement ps;
		ResultSet res;
		
		try {
			ps = con.getConection().prepareStatement(SQL_READALL);
			res = ps.executeQuery();
			
			while(res.next())
				lista.add(new ClienteDTO(res.getInt("IDCLIENTE"), res.getString("NOMBREEMPRESA"), res.getString("RUTEMPRESA"), res.getInt("USUARIO_IDUSUARIO")));
			
		} catch (SQLException e) {
			System.out.println("Error: ClienteDAO readAll");
			e.printStackTrace();
		}
		
		return lista;
	}
  
  public ClienteDTO readCliente(Object key) {
		ClienteDTO i = null;
		
		PreparedStatement ps;
		ResultSet res;
		
		try {
			ps = con.getConection().prepareStatement(SQL_READBYCLIENTE);
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
}
