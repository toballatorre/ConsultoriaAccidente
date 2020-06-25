package controller.login;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


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
		
		if(pass.equals("123")) {
			HttpSession sesion = request.getSession();
			sesion.setAttribute("user", user);
			response.sendRedirect("AreaCliente.jsp");			
		}else {
			PrintWriter salida = response.getWriter();
			salida.println("<script type=\"text/javascript\">");
			salida.println("alert('User or password incorrect');");
			salida.println("location='index.jsp';");
			salida.println("</script>");
		}
		
	}

}
