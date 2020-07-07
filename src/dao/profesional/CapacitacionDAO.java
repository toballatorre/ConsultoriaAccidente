package dao.profesional;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conectar.Conexion;
import idao.IObjectDao;
import modelo.CapacitacionDTO;

/**
 * Data Access Object (DAO) para manipular la tabla de capacitacion.
 * Se aplican los metodos CRUD general que se aplican a todos los DAOs por medio de la interfaz genérica y
 * algunos especiales según necesidad única de este DAO.
 * @author Cristobal L
 *
 */
public class CapacitacionDAO implements IObjectDao<CapacitacionDTO> {
	
	private static final String SQL_INSERT = "INSERT INTO capacitacion (idcapacitacion, cliente_idcliente, tema, objetivos, contenidos, recursos, fecha, idusuariopro) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String SQL_DELETE = "DELETE FROM capacitacion WHERE idcapacitacion = ?";
	//private static final String SQL_UPDATE = "UPDATE capacitacion SET titulo = ?, descripcion = ?, status = ?, comentario = ? WHERE idactividad = ?";
	private static final String SQL_READ = "SELECT * FROM capacitacion WHERE idcapacitacion = ?";
	private static final String SQL_READALL = "SELECT * FROM capacitacion";
	
	private static final Conexion con = Conexion.connect();

	@Override
	public boolean create(CapacitacionDTO o) {
		
		boolean creado = false;
		PreparedStatement ps;
		
		try {
			
			ps = con.getConection().prepareStatement(SQL_INSERT);
			ps.setInt(1, o.getIdCapacitacion());
			ps.setInt(2, o.getIdClientePK());
			ps.setString(3, o.getTema());
			ps.setString(4, o.getObjetivos());
			ps.setString(5, o.getContenidos());
			ps.setString(6, o.getRecursos());
			ps.setDate(7, o.getFecha());
			ps.setInt(8, o.getIdProfesionalPK());
			
			if (ps.executeUpdate() > 0)
				creado = true;
			
		} catch (SQLException e) {
			System.out.println("Error: CapacitacionDAO create()");
			e.printStackTrace();
		} finally {
			con.closeConnection();
		}
		
		return creado;
	}

	@Override
	public boolean delete(Object key) {
		boolean eliminado = false;
		
		PreparedStatement ps;
		
		try {
			
			ps = con.getConection().prepareStatement(SQL_DELETE);
			ps.setString(1, key.toString());
			
			if (ps.execute())
				eliminado = true;
			
		} catch (SQLException e) {
			System.out.println("Error: CapacitacionDAO delete()");
			e.printStackTrace();
		} finally {
			con.closeConnection();
		}
		
		return eliminado;
	}

	@Override
	public boolean update(CapacitacionDTO o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CapacitacionDTO read(Object key) {
		CapacitacionDTO capacitacion = null;
		
		PreparedStatement ps;
		ResultSet res;
		
		try {
			
			ps = con.getConection().prepareStatement(SQL_READ);
			ps.setString(1, key.toString());
			
			res = ps.executeQuery();
			//idcapacitacion, cliente_idcliente, tema, objetivos, contenidos, recursos, fecha, idusuariopro
			 while(res.next())
				 capacitacion = new CapacitacionDTO(res.getInt("idcapacitacion"), res.getInt("cliente_idcliente"), res.getString("tema"), res.getString("objetivos"), res.getString("contenidos"), res.getString("recursos"), res.getDate("fecha"), res.getInt("idusuariopro"));
			
		} catch (SQLException e) {
			System.out.println("Error: CapacitacionDAO read()");
			e.printStackTrace();
		} finally {
			con.closeConnection();
		}
		
		
		return capacitacion;
	}

	@Override
	public List<CapacitacionDTO> readAll() {
		
		ArrayList<CapacitacionDTO> listaCapacitacion = new ArrayList<CapacitacionDTO>();
		PreparedStatement ps;
		ResultSet res;
		
		try {
			
			ps = con.getConection().prepareStatement(SQL_READALL);
			res = ps.executeQuery();
			
			while(res.next())
				listaCapacitacion.add(new CapacitacionDTO(res.getInt("idcapacitacion"), res.getInt("cliente_idcliente"), res.getString("tema"), res.getString("objetivos"), res.getString("contenidos"), res.getString("recursos"), res.getDate("fecha"), res.getInt("idusuariopro")));
			
		} catch (SQLException e) {
			System.out.println("Error: CapacitacionDAO readAll()");
			e.printStackTrace();
		} finally {
			con.closeConnection();
		}
		
		return listaCapacitacion;
	}
	
	
	
}
