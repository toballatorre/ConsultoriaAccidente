package dao.profesional;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conectar.Conexion;
import idao.IObjectDao;
import modelo.ActividadDTO;
/**
 * Data Access Object (DAO) de Actividad mejora.
 * Esta pertenece a los Casos de Uso:
 * 	- "Ingresar actividad mejora"
 *  - "Revisar actividad mejora"
 * Se aplican los metodos CRUD general que se aplican a todos los DAOs por medio de la interfaz genérica y
 * algunos especiales según necesidad única de este DAO.
 * @author Cristobal L
 *
 */
public class ActividadDAO implements IObjectDao<ActividadDTO> {
	
	private static final String SQL_INSERT = "INSERT INTO actividad (titulo, descripcion, fechaplazo, status, comentario, cliente_idcliente) VALUES(?, ?, ?, ?, ?, ?)";
	private static final String SQL_DELETE = "DELETE FROM actividad WHERE idactividad = ?";
	private static final String SQL_UPDATE = "UPDATE actividad SET titulo = ?, descripcion = ?, status = ?, comentario = ? WHERE idactividad = ?";
	private static final String SQL_READ = "SELECT * FROM actividad WHERE idactividad = ?";
	private static final String SQL_READ_BY_CLIENT = "SELECT * FROM actividad WHERE cliente_idcliente = ?";
	private static final String SQL_READALL = "SELECT * FROM actividad";
	
	private static final Conexion con = Conexion.connect();
	
	/**
	 * Inserta una actividad en la base de datos con realción al cliente seleccionado.
	 */
	@Override
	public boolean create(ActividadDTO o) {
		
		boolean creado = false;
		PreparedStatement ps;
		
		try {
			
			ps = con.getConection().prepareStatement(SQL_INSERT);
			ps.setString(1, o.getTitulo());
			ps.setNString(2, o.getDescripcion());
			ps.setDate(3, o.getFechaPlazo());
			ps.setString(4, o.getStatus());
			ps.setString(5, o.getComentario());
			ps.setInt(6, o.getIdClientePk());
			
			if(ps.executeUpdate() >0)
				creado = true;
			
		} catch (SQLException e) {
			System.out.println("Error: ActividadDAO create()");
			e.printStackTrace();
		} finally {
			con.closeConnection();
		}
				
		return creado;
	}
	
	/**
	 * Elimina una actividad según si identificador único (id).
	 */
	@Override
	public boolean delete(Object key) {
		
		boolean eliminado = false;
		PreparedStatement ps;
		
		try {
			
			ps = con.getConection().prepareStatement(SQL_DELETE);
			ps.setString(1, key.toString());
			
			if(ps.execute())
				eliminado = true;
			
		} catch (SQLException e) {
			System.out.println("Error: ActividadDAO delete()");
			e.printStackTrace();
		} finally {
			con.closeConnection();
		}
		
		return eliminado;
	}
	
	/**
	 * Actualizar los datos de la actividad
	 */
	@Override
	public boolean update(ActividadDTO o) {
		
		boolean actualizado = false;
		PreparedStatement ps;
		
		try {
			
			ps = con.getConection().prepareStatement(SQL_UPDATE);
			ps.setString(1, o.getTitulo());
			ps.setString(2, o.getDescripcion());
			ps.setString(3, o.getStatus());
			ps.setString(4, o.getComentario());
			ps.setInt(5, o.getIdActividad());
			
			if(ps.executeUpdate() > 0)
				actualizado = true;
			
		} catch (SQLException e) {
			System.out.println("Error ActividadDAO update()");
			e.printStackTrace();
		}
		
		return actualizado;
	}
	
	/**
	 * Leer una actividad usando como parámetro si identificador único (id)
	 */
	@Override
	public ActividadDTO read(Object key) {
		
		ActividadDTO actividad = null;
		PreparedStatement ps;
		ResultSet res;
		
		try {
			
			ps = con.getConection().prepareStatement(SQL_READ);
			ps.setString(1, key.toString());
			
			res = ps.executeQuery();
			
			while(res.next())
				actividad = new ActividadDTO(res.getInt("idactividad"), res.getString("titulo"), res.getString("descripcion"), res.getDate("fechaPlazo"), res.getNString("status"), res.getString("comentario"), res.getInt("cliente_idcliente"));
			
			
		} catch (SQLException e) {
			System.out.println("Error ActividadDAO read()");
			e.printStackTrace();
		} finally {
			con.closeConnection();
		}
		
		return actividad;
	}
	/**
	 * devuelve todas las actividades existentes en la base de datos
	 */
	@Override
	public List<ActividadDTO> readAll() {
		
		ArrayList<ActividadDTO> listaActividades = new ArrayList<ActividadDTO>();
		PreparedStatement ps;
		ResultSet res;
		
		try {
			
			ps = con.getConection().prepareStatement(SQL_READALL);
			res = ps.executeQuery();
			
			while (res.next())
				listaActividades.add(new ActividadDTO(res.getInt("idactividad"), res.getString("titulo"), res.getString("descripcion"), res.getDate("fechaPlazo"), res.getNString("status"), res.getString("comentario"), res.getInt("cliente_idcliente")));
				
			
		} catch (SQLException e) {
			System.out.println("Error ActividadDAO readAll()");
			e.printStackTrace();
		} finally {
			con.closeConnection();
		}
		
		return listaActividades;
	}
	
	/**
	 * Retorna una lista de actividades según la id del cliente
	 * @param id del cliente que se especifica
	 * @return lista de actividades de un cliente en específico
	 */
	public List<ActividadDTO> readByCliente(int id){
		
		ArrayList<ActividadDTO> listaPorCliente = new ArrayList<ActividadDTO>();
		PreparedStatement ps;
		ResultSet res;
		
		try {
			
			ps = con.getConection().prepareStatement(SQL_READ_BY_CLIENT);
			ps.setInt(1, id);
			
			res = ps.executeQuery();
			
			while(res.next())
				listaPorCliente.add(new ActividadDTO(res.getInt("idactividad"), res.getString("titulo"), res.getString("descripcion"), res.getDate("fechaPlazo"), res.getNString("status"), res.getString("comentario"), res.getInt("cliente_idcliente")));
				
		} catch (SQLException e) {
			System.out.println("Error: ActividadDAO readByClient()");
			e.printStackTrace();
		}
		
		return listaPorCliente;
	}

}
