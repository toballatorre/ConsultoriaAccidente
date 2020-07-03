package pruebas;

import dao.ItemDAO;
import modelo.ItemDTO;
import dao.UsuarioDAO;
import modelo.UsuarioDTO;

public class Prueba1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ItemDAO item = new ItemDAO();
		ItemDTO itembuscado = item.read(11);
		System.out.println(itembuscado.getConcepto());
		
		
		
		UsuarioDAO itemdao = new UsuarioDAO();
		UsuarioDTO userbuscado = itemdao.obtenerUsuario(5) ;
		System.out.println(userbuscado.getIdusuario()+" "+userbuscado.getUsuario()+" "+userbuscado.getMail()+" "+userbuscado.getTipousuario());
	}

}
