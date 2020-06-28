package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import conectar.ConexionSingleton;
import idao.IObjectDao;
import modelo.RegistroAccidente;

public class RegistroAccidenteDao implements IObjectDao {

	private RegistroAccidente reg;
	
	public RegistroAccidenteDao() {
		
	}
	
	@Override
	public boolean crear(Object obj) {
		
		this.reg = (RegistroAccidente) obj;
		
		boolean registrar = false;
		Connection con = null;
		Statement stm = null;
		
		String sql = "INSERT INTO reporteaccidente (IDREPORTE, TIPOACCIDENTE, DIASPERDIDOS, FECHAACCIDENTE, LUGARACCIDENTE, DESCRIPCION, CLIENTE_IDCLIENTE) "
				+ "VALUES ('"+reg.getIdReporte()+"', '"+reg.getTipoAccidente()+"', '"+reg.getDiasPerdidos()+"', '"+reg.getFechaAccidente()+"', '"+reg.getLugarAccidente()+"', '"+reg.getDescripcion()+"', '"+reg.getPkIdCliente()+"')";
		
		try {
			con = ConexionSingleton.getConnection();
			stm = con.createStatement();
			stm.execute(sql);
			registrar = true;
			stm.close();
		} catch (SQLException e) {
			System.out.println("Error: Clase RegistroAccidenteDao, método crear");
			e.printStackTrace();
		}
		
		return registrar;
	}

	@Override
	public List<Object> leer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean actualizar(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object obtener(int idObj) {
		// TODO Auto-generated method stub
		return null;
	}

}
