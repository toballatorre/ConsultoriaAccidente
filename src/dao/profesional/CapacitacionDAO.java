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
	private static final String SQL_UPDATE = "UPDATE capacitacion SET tema = ?, objetivos = ?, contenidos = ?, recursos = ? WHERE idcapacitacion = ?";
	private static final String SQL_READ = "SELECT * FROM capacitacion WHERE idcapacitacion = ?";
	private static final String SQL_READALL = "SELECT * FROM capacitacion;";
	private static final String SQL_READBYPROF = "SELECT * FROM capacitacion INNER JOIN cliente ON capacitacion.cliente_idcliente = cliente.idcliente WHERE idusuariopro = ?";
	
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
		
		boolean actualizado = false;
		
		PreparedStatement ps;
		
		try {
			//tema = ?, objetivos = ?, contenidos = ?, recuros = ? WHERE idcapacitacion = ?
			ps = con.getConection().prepareStatement(SQL_UPDATE);
			ps.setString(1, o.getTema());
			ps.setString(2, o.getObjetivos());
			ps.setString(3, o.getContenidos());
			ps.setString(4, o.getRecursos());
			ps.setInt(5, o.getIdCapacitacion());
			
			if (ps.execute())
				actualizado = true;
			
		} catch (SQLException e) {
			System.out.println("Error: CapacitacionDAO update()");
			e.printStackTrace();
		} finally {
			con.closeConnection();
		}
		
		return actualizado;
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
	
public List<CapacitacionDTO> readAllByProf(Object key) {
		
		ArrayList<CapacitacionDTO> listaCapacitacion = new ArrayList<CapacitacionDTO>();
		PreparedStatement ps;
		ResultSet res;
		
		try {
			
			ps = con.getConection().prepareStatement(SQL_READBYPROF);
			ps.setString(1, key.toString());
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
