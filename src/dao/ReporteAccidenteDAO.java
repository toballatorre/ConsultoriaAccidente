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

	private static final String SQL_INSERT = 
			"INSERT INTO REPORTEACCIDENTE (TIPOACCIDENTE, DIASPERDIDOS, FECHAACCIDENTE, LUGARACCIDENTE, DESCRIPCION, CLIENTE_IDCLIENTE) VALUES ('?', '?', TO_DATE('? 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '?', '?', '?')";
			//+ "VALUES ('Laboral', '10', TO_DATE('2020-07-07 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '239-6566 Fringilla Avenue', 'Caida misma altura', '3');"

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
		boolean creado = false;
		PreparedStatement ps;
		System.out.println(o.getTipoAccidente());
		System.out.println(o.getDiasPerdidos());
		System.out.println(o.getFechaAccidente());
		System.out.println(o.getLugarAccidente());
		System.out.println(o.getDescripcion());
		System.out.println(o.getPkIdCliente());
		try {
			ps = con.getConection().prepareStatement(SQL_INSERT);
			ps.setString(1, o.getTipoAccidente());
			ps.setInt(2, o.getDiasPerdidos());
			ps.setString(3, o.getFechaAccidente());
			ps.setString(4, o.getLugarAccidente());
			ps.setString(5, o.getDescripcion());
			ps.setInt(6, o.getPkIdCliente());
			
				
			
			if (ps.executeUpdate() > 0) {
				creado = true;
			}
			
		} catch (SQLException e) {
			System.out.println("Error: ReporteAccidenteDAO create(ReporteAccidenteDTO o");
			e.printStackTrace();
			
		} finally {
			con.closeConnection();
		}
		
		return creado;
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
			ps.setInt(1, (int) key);
			res = ps.executeQuery();
			
			while(res.next()) {
				listareportes.add(new ReporteAccidenteDTO(res.getInt("IDREPORTE"), res.getString("TIPOACCIDENTE"), res.getInt("DIASPERDIDOS"), res.getString("FECHAACCIDENTE"), res.getString("LUGARACCIDENTE"),res.getString("DESCRIPCION"), res.getInt("CLIENTE_IDCLIENTE")));
			}
			return listareportes;
		} catch (SQLException e) {
			
			System.out.println("Error: ReporteAccidenteDAO List<Obj> readAllIdClient(Object key)");
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
