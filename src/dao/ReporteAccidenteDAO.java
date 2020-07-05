package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conectar.Conexion;
import idao.IObjectDao;
import modelo.ReporteAccidenteDTO;
import modelo.UsuarioDTO;

public class ReporteAccidenteDAO implements IObjectDao<ReporteAccidenteDTO>{

	//private static final String SQL_INSERT = "INSERT INTO usuario (USUARIO, TIPOUSUARIO, CLAVE, MAIL, ACTIVO) VALUES(?, ?, ?, ?, ?)";
	//private static final String SQL_DELETE = "DELETE FROM usuario WHERE idusuario = ?";
	//private static final String SQL_UPDATE = "UPDATE USUARIO  SET USUARIO = ?, TIPOUSUARIO = ?, CLAVE = ?, MAIL = ?, ACTIVO = ? WHERE idusuario = ?";
	//private static final String SQL_READ = "SELECT * FROM usuario WHERE idusuario = ?";
	//private static final String SQL_READ_BY_USERNAME = "SELECT * FROM usuario WHERE usuario = ?";
	private static final String SQL_READALL = "select * from reporteaccidente where cliente_idcliente = ?";
	
	private static final Conexion con = Conexion.connect();
	
	/**
	 * Obtiene una lista de reportes por IDcliente
	 */
	@Override
	public ReporteAccidenteDTO read(Object key) {
		ReporteAccidenteDTO i = null;
		
		PreparedStatement ps;
		ResultSet res;
		/*
		try {
			ps = con.getConection().prepareStatement(SQL_READALL);
			ps.setString(1, key.toString());
			
			res = ps.executeQuery();
			
			while(res.next()) {
				i = new ReporteAccidenteDTO(res.getInt("idReporte"), res.getString("tipoAccidente"), res.getInt("diasPerdidos"), res.getString("fechaAccidente"), res.getString("lugarAccidente"),res.getString("descripcion"), res.getInt("pkIdCliente"));
			}
		} catch (SQLException e) {
			System.out.println("Error: ReporteAccidenteDAO read(Object key)");
			e.printStackTrace();
		}finally {
			con.closeConnection();
		}
		*/		
		return i;
	}

	@Override
	public boolean create(ReporteAccidenteDTO o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Object key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(ReporteAccidenteDTO o) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<ReporteAccidenteDTO> readAllIdClient(Object key) {
		ArrayList<ReporteAccidenteDTO> listareportes = new ArrayList<ReporteAccidenteDTO>();
		
		PreparedStatement ps;
		ResultSet res;
		
		try {
			ps = con.getConection().prepareStatement(SQL_READALL);
			ps.setString(1, key.toString());
			res = ps.executeQuery();
			
			while(res.next()) {
				listareportes.add(new ReporteAccidenteDTO(res.getInt("idReporte"), res.getString("tipoAccidente"), res.getInt("diasPerdidos"), res.getString("fechaAccidente"), res.getString("lugarAccidente"),res.getString("descripcion"), res.getInt("pkIdCliente")));
			}
			return listareportes;
		} catch (SQLException e) {
			
			System.out.println("Error: ReporteAccidenteDAO List<Obj> readAll(Object key)");
			e.printStackTrace();
		} finally {
			con.closeConnection();
		}

		return listareportes;

	}

	@Override
	public List<ReporteAccidenteDTO> readAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
