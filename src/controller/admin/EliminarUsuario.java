package controller.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDAO;
import modelo.UsuarioDTO;

/**
 * Servlet implementation class EliminarUsuario
 */
@WebServlet("/EliminarUsuario")
public class EliminarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		int usuarioid = Integer.parseInt(request.getParameter("id"));
		UsuarioDTO user = new UsuarioDTO();
		user.setId(usuarioid);
		
		UsuarioDAO userdao = new UsuarioDAO();
		boolean elimino = userdao.eliminarUsuario(user);

		List<UsuarioDTO> listadoeliminar = new ArrayList<UsuarioDTO>();
		listadoeliminar = userdao.leerUsuarios();
		
		String mensaje = "";
		
		if (elimino)
			mensaje = "El usuario ha sido eliminado exitosamente";
		else
			mensaje = "Ocurrió un problema al eliminar el usuario";
		
		request.setAttribute("cumensaje", mensaje);
		request.setAttribute("listadousuarios", listadoeliminar);
		request.getRequestDispatcher("ListadoUsuarios.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
