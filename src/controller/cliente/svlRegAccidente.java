package controller.cliente;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class svlRegAccidente
 */
@WebServlet("/svlRegAccidente")
public class svlRegAccidente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public svlRegAccidente() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		
		PrintWriter salida = response.getWriter();
		
		salida.println("<html><body>");
		salida.println("<h1>Registros Accidentes</h1>");
		salida.println("<p>Tipo Accidente: " + request.getParameter("asunto") + "</p>");
		salida.println("<p>Fecha: " + request.getParameter("fechaAccidente") + "</p>");
		salida.println("<p>Hora Accidente: " + request.getParameter("horaAccidente") + "</p>");
		salida.println("<p>Lugar Accidente: " + request.getParameter("lugarAccidente") + "</p>");
		salida.println("<p>Detalle Accidente: " + request.getParameter("detalleAccidente") + "</p>");
		salida.println("<p>Fecha Registro: " + request.getParameter("fechaRegistro") + "</p>");
		salida.println("</body></html>");
		salida.close();
	}

}
