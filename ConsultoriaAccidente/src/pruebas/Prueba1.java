package pruebas;

import java.util.ArrayList;
import java.util.List;

import dao.UsuarioDAO;
import modelo.UsuarioDTO;

public class Prueba1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		ItemDAO item = new ItemDAO();
		ItemDTO itembuscado = item.read(11);
		System.out.println(itembuscado.getConcepto());
		*/
		
		/*
		UsuarioDAO itemdao = new UsuarioDAO();
		UsuarioDTO userbuscado = itemdao.read(5) ;
		System.out.println(userbuscado.getIdusuario()+" "+userbuscado.getUsuario()+" "+userbuscado.getMail()+" "+userbuscado.getTipousuario());
		*/
		
		/*UsuarioDAO uDAO = new UsuarioDAO();
		List<UsuarioDTO> listaUsuarios = new ArrayList<UsuarioDTO>();
		listaUsuarios = uDAO.readAll();
		
		for (UsuarioDTO u : listaUsuarios) {
			System.out.println(u.toString());
			*/
			
		UsuarioDAO userdao = new UsuarioDAO();
		boolean elimino = userdao.delete(9);
		System.out.println(elimino);
			
			
		
	}

}
