package controller.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.usuarios.Usuario;


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
		/*  Por ahora solo valida 3 usuarios del array en clase Usuario. Falta avanzar*/
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		System.out.println(user);
		System.out.println(pass);
		
		//LoginDTO logindto = LoginDTO()
		
		Usuario usuarios = new Usuario();
		//System.out.println(Arrays.toString(usuarios.getArr()));
		//System.out.println(usuarios.validar(user));
		//System.out.println(usuarios.validar("cliente"));
		
		if (usuarios.validar(user)) {
			HttpSession sesion = request.getSession();
			sesion.setAttribute("user", user);
			System.out.println(user);
			
			if (user.equals("cliente")) {
				sesion.setAttribute("tipoUsuario", "cliente");
				response.sendRedirect("AreaCliente.jsp");	
			} else if (user.equals("admin")){
				sesion.setAttribute("tipoUsuario", "admin");
				response.sendRedirect("AreaAdmin.jsp");
			} else {
				sesion.setAttribute("tipoUsuario", "profesional");
				response.sendRedirect("AreaProfesional.jsp");
			}
			
		} else {
			PrintWriter salida = response.getWriter();
			salida.println("<script type=\"text/javascript\">");
			salida.println("alert('User no encontrado');");
			salida.println("location='index.jsp';");
			salida.println("</script>");
		}
				
	}

}
