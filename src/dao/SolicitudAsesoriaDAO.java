package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conectar.Conexion;
import idao.IObjectDao;
import modelo.SolicitudAsesoriaDTO;


public class SolicitudAsesoriaDAO implements IObjectDao<SolicitudAsesoriaDTO> {

	private static final String SQL_READ_BY_CLIENTE = "SELECT * FROM SOLICITUDASESORIA WHERE CLIENTE_IDCLIENTE = ?";
	private static final String SQL_INSERT = "INSERT INTO SOLICITUDASESORIA (FECHAHORA, MOTIVO, PREFERENCIAHORARIO, CLIENTE_IDCLIENTE) VALUES (?, ?, ?, ?)";
	
	private static final Conexion con = Conexion.connect();

	
	/*METODOS*/
	public List<SolicitudAsesoriaDTO> readAllIdClient(Object key) {
		ArrayList<SolicitudAsesoriaDTO> listasolicitudes = new ArrayList<SolicitudAsesoriaDTO>();
		
		PreparedStatement ps;
		ResultSet res;
		
		try {
			ps = con.getConection().prepareStatement(SQL_READ_BY_CLIENTE);
			ps.setInt(1, (int) key);
			res = ps.executeQuery();
			
			while(res.next()) {
				listasolicitudes.add(new SolicitudAsesoriaDTO(res.getInt("IDSOLICITUD"), res.getDate("FECHAHORA"), res.getString("MOTIVO"), res.getString("PREFERENCIAHORARIO"), res.getInt("CLIENTE_IDCLIENTE")));
			}
			return listasolicitudes;
		} catch (SQLException e) {
			
			System.out.println("Error: SolicitudAsesoriaDAO  readAllIdClient(Object key)");
      
			e.printStackTrace();
		} finally {
			con.closeConnection();
		}

		return listasolicitudes;

	}
	
	
	@Override
	public boolean create(SolicitudAsesoriaDTO o) {
		boolean creado = false;
		PreparedStatement ps;
		
		try {
			ps = con.getConection().prepareStatement(SQL_INSERT);
			ps.setDate(1, o.getFechaHora());
			ps.setString(2, o.getMotivo());
			ps.setString(3, o.getPreferenciaHorario());
			ps.setInt(4, o.getIdCliente());
			
			if (ps.executeUpdate() > 0) {
				creado = true;
			}
			
		} catch (SQLException e) {
			System.out.println("Error: SolicitudAsesoriaDAO create(SolicitudAsesoriaDTO o)");
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
	public boolean update(SolicitudAsesoriaDTO o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public SolicitudAsesoriaDTO read(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SolicitudAsesoriaDTO> readAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
