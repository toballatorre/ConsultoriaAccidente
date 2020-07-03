package controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDAO;
import modelo.UsuarioDTO;

/**
 * Servlet implementation class CrearUsuario
 */
@WebServlet("/CrearUsuario")
public class CrearUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("admin/CreacionUsuario.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String usuario = request.getParameter("txtusuario");
		String tipousuario = request.getParameter("txttipouser");
		String clave = request.getParameter("txtclave");
		String correo = request.getParameter("txtcorreo");
		String activo = request.getParameter("txtactivo");

		UsuarioDTO user = new UsuarioDTO(usuario,tipousuario,clave,correo,activo);
		UsuarioDAO userdao = new UsuarioDAO();
		boolean agregar = userdao.crearUsuario(user);
		
		String mensaje = "";
		
		if (agregar)
			mensaje = "El usuario se ha creado exitosamente";
		else
			mensaje = "Ocurrió un error al crear el usuario";
		
		request.setAttribute("cumensaje", mensaje);
		request.getRequestDispatcher("admin/CreacionUsuario.jsp").forward(request, response);
		
	}

}
