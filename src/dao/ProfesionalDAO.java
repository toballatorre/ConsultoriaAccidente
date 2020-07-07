package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conectar.Conexion;
import idao.IObjectDao;
import modelo.ClienteDTO;
import modelo.ProfesionalDTO;

public class ProfesionalDAO implements IObjectDao<ProfesionalDTO> {

	private static final String SQL_READALL = "SELECT * FROM profesional ";
	private static final String SQL_READbyID = "SELECT * FROM profesional where IDEMPLEADO = ?";
	private static final String SQL_UPDATE = "UPDATE profesional SET NOMBRE = ?, USUARIO_IDUSUARIO = ? ,CELULAR = ? WHERE IDEMPLEADO = ?";
	
	private static final Conexion con = Conexion.connect();

	@Override
	public boolean create(ProfesionalDTO o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Object key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(ProfesionalDTO o) {
		boolean actualizado = false;
		PreparedStatement ps;
		
		try {
			ps = con.getConection().prepareStatement(SQL_UPDATE);
			ps.setString(1, o.getNombre());
			ps.setInt(2, o.getIdusuario());
			ps.setString(3, o.getCelular());
			ps.setInt(4, o.getIdempleado());
					
			if(ps.executeUpdate() > 0) {
				actualizado = true;
			}
		}catch (Exception e) {
			System.out.println("Error: ProfesionalDAO update(ProfesionalDTO o)");
			e.printStackTrace();
			
		}finally {
			con.closeConnection();
		}
		
		return actualizado;
	}

	@Override
	public ProfesionalDTO read(Object key) {
		ProfesionalDTO i = null;
		
		PreparedStatement ps;
		ResultSet res;
		try {
			ps = con.getConection().prepareStatement(SQL_READbyID);
			ps.setInt(1, (int) key);
			res = ps.executeQuery();
			System.out.println("key:"+(int) key);
			while(res.next()) {
				i = new ProfesionalDTO(res.getInt("IDEMPLEADO"), res.getString("NOMBRE"), res.getInt("USUARIO_IDUSUARIO"), res.getString("CELULAR"));
			}
		} catch (SQLException e) {
			System.out.println("Error: ProfeionalDAO read()");
			e.printStackTrace();
		}finally {
			con.closeConnection();
		}		
		return i;
	}

	@Override
	public List<ProfesionalDTO> readAll() {

		ArrayList<ProfesionalDTO> lprofesionales= new ArrayList<ProfesionalDTO>();
		
		PreparedStatement ps;
		ResultSet res;
		
		try {
			
			ps = con.getConection().prepareStatement(SQL_READALL);
			res = ps.executeQuery();
			
			while(res.next())
				lprofesionales.add(new ProfesionalDTO(res.getInt("IDEMPLEADO"), res.getString("NOMBRE"), res.getInt("USUARIO_IDUSUARIO"),res.getString("CELULAR") ));
			
		} catch (SQLException e) {
			System.out.println("Error: ProfesionalDAO readAll()");
			e.printStackTrace();
		} finally {
			con.closeConnection();
		}
		
		return lprofesionales;





















	}

}
