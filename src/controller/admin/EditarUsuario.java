package controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDao;
import modelo.Usuario;

/**
 * Servlet implementation class EditarUsuario
 */
@WebServlet("/EditarUsuario")
public class EditarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarUsuario() {
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
		
		UsuarioDao userdao = new UsuarioDao();
		Usuario user = new Usuario();
		user = userdao.obtenerUsuario(usuarioid);
		
		request.setAttribute("datosusuario", user);
		request.getRequestDispatcher("EditarUsuario.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String nombre = request.getParameter("txtnombre");
		String apellido = request.getParameter("txtapellido");
		String correo = request.getParameter("txtcorreo");
		String telefono = request.getParameter("txttelefono");
		int id = Integer.parseInt(request.getParameter("hdnidusuario"));

		Usuario user = new Usuario(id,nombre,apellido,correo,telefono);
		
		UsuarioDao userdao = new UsuarioDao();
		boolean editar = userdao.actualizarUsuario(user);
		
		String mensaje = "";
		
		if (editar)
			mensaje = "El usuario se ha editado exitosamente";
		else
			mensaje = "Ocurrió un error al editar el usuario";

		request.setAttribute("datosusuario", user);
		request.setAttribute("cumensaje", mensaje);
		request.getRequestDispatcher("EditarUsuario.jsp").forward(request, response);
		
	}

}
