package controller.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UsuarioDAO;
import modelo.UsuarioDTO;


/**
 * Servlet implementation class ValidarLogin
 */
@WebServlet("/ValidarLogin")
public class ValidarLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidarLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		
		UsuarioDAO uDAO = new UsuarioDAO();
		UsuarioDTO uDTO;
		
		uDTO = uDAO.readUsername(user);
		
		System.out.println(uDTO);
		System.out.println(user);
		System.out.println(pass);
		
		if (uDTO != null) {
			System.out.println("Activo: " + uDTO.getActivo());
			if(uDTO.getActivo().equals("1")) {
				
				HttpSession sesion = request.getSession();
				sesion.setAttribute("user", uDTO.getUsuario());
				System.out.println("Login as: " + user);
				
				switch (uDTO.getTipousuario()) {
				case "cliente":
					sesion.setAttribute("tipoUsuario", "cliente");
					sesion.setAttribute("idUsuario", uDTO.getIdusuario());
					request.getRequestDispatcher("AreaCliente.jsp").forward(request, response);
					break;
				case "admin":
					sesion.setAttribute("tipoUsuario", "admin");
					sesion.setAttribute("idUsuario", uDTO.getIdusuario());
					request.getRequestDispatcher("AreaAdmin.jsp").forward(request, response);
					break;
				case "profesional":
					sesion.setAttribute("tipoUsuario", "profesional");
					sesion.setAttribute("idUsuario", uDTO.getIdusuario());
					request.getRequestDispatcher("AreaProfesional.jsp").forward(request, response);
					break;
				default:
					break;
				}
			}else {
				PrintWriter salida = response.getWriter();
				salida.println("<script type=\"text/javascript\">");
				salida.println("alert('Usuario desactivado, porfavor contactarse su administrador');");
				salida.println("location='index.jsp';");
				salida.println("</script>");
			}
			
		} else {
			PrintWriter salida = response.getWriter();
			salida.println("<script type=\"text/javascript\">");
			salida.println("alert('Usuario no encontrado');");
			salida.println("location='index.jsp';");
			salida.println("</script>");
		}
				
	}

}
