package controller.cliente;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SolicitudAsesoriaDAO;
import modelo.SolicitudAsesoriaDTO;
import utilidades.FechaSQL;

/**
 * Servlet implementation class SolicitarAsesoriaCreate
 */
@WebServlet("/SolicitarAsesoriaCreate")
public class SolicitarAsesoriaCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SolicitarAsesoriaCreate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("cliente/SolicitudAsesoriaClienteCreate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String fechaSolicitud = request.getParameter("fechaSolicitud");
		java.sql.Date sqlFechaSolicitud = new FechaSQL().toSQL(fechaSolicitud); // convierte la fecha a formato compatible con SQL
		
		String motivo = request.getParameter("motivo");
		String horario = request.getParameter("horario");
		int idCliente = (Integer.parseInt(request.getParameter("idCliente")));

		SolicitudAsesoriaDTO solicitud = new SolicitudAsesoriaDTO(sqlFechaSolicitud, motivo, horario, idCliente);
		SolicitudAsesoriaDAO solicituddao = new SolicitudAsesoriaDAO();
		boolean agregar = solicituddao.create(solicitud);
		
		String mensaje = "";
		
		if (agregar)
			mensaje = "La solicitud se ha creado exitosamente. Nuestros ejecutivos se contactarán con ud para confirmar agenda";
		else
			mensaje = "Ocurrió un error al crear la solicitud";
		
		request.setAttribute("cumensaje", mensaje);
		request.getRequestDispatcher("cliente/SolicitudAsesoriaClienteCreate.jsp").forward(request, response);
		
		
		
	}

}
