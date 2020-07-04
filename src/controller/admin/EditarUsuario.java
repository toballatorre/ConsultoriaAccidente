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
		
		UsuarioDAO userdao = new UsuarioDAO();
		UsuarioDTO user = new UsuarioDTO();
		user = userdao.read(usuarioid);
		
		request.setAttribute("datosusuario", user);
		request.getRequestDispatcher("admin/EditarUsuario.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String usuario = request.getParameter("txtusuario");
		String tipousuario = request.getParameter("txttipousuario");
		String clave = request.getParameter("txtclave");
		String mail = request.getParameter("txtmail");
		String activo = request.getParameter("txtactivo");
		int idusuario = Integer.parseInt(request.getParameter("idusuario"));

		UsuarioDTO user = new UsuarioDTO(idusuario,usuario,tipousuario,clave,mail,activo);
		
		UsuarioDAO userdao = new UsuarioDAO();
		boolean editar = userdao.update(user);
		
		String mensaje = "";
		
		if (editar)
			mensaje = "El usuario se ha editado exitosamente";
		else
			mensaje = "Ocurrió un error al editar el usuario";

		request.setAttribute("datosusuario", user);
		request.setAttribute("cumensaje", mensaje);
		request.getRequestDispatcher("admin/EditarUsuario.jsp").forward(request, response);
				
	}

}
