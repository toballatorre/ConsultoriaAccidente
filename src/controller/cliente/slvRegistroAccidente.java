package controller.cliente;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RegistroAccidenteDao;
import modelo.RegistroAccidente;

/**
 * Servlet implementation class slvRegistroAccidente
 */
@WebServlet("/slvRegistroAccidente")
public class slvRegistroAccidente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public slvRegistroAccidente() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
        String jdbcDriver = getServletContext().getInitParameter("jdbcDriver");
        System.out.println(jdbcDriver);
        System.out.println(jdbcURL);
        System.out.println(jdbcUsername);
        System.out.println(jdbcPassword);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/cliente/registroAccidente.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String tipoAccidente = request.getParameter("tipoAccidente");
		int diasPerdidos = Integer.parseInt(request.getParameter("diasPerdidos"));
		String fechaAccidente = request.getParameter("fechaAccidente");
		String lugarAccidente = request.getParameter("lugarAccidente");
		String descripcion = request.getParameter("descripcion");
		
		RegistroAccidente rAccidente = new RegistroAccidente(1, tipoAccidente, diasPerdidos, fechaAccidente, lugarAccidente, descripcion, 3);
		
		RegistroAccidenteDao rAccidenteDao = new RegistroAccidenteDao();
		rAccidenteDao.crear(rAccidente);
		
		
	}

}
