package controller.cliente;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReporteAccidenteDAO;
import modelo.ReporteAccidenteDTO;
import utilidades.FechaSQL;

/**
 * Servlet implementation class ReporteAccCreate
 */
@WebServlet("/ReporteAccCreate")
public class ReporteAccCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReporteAccCreate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("cliente/RegAccidentesClienteCreate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String tipoAccidente = request.getParameter("tipoAccidente");
		int diasPerdidos = (Integer.parseInt(request.getParameter("diasPerdidos")));
		
		String fechaAccidente = request.getParameter("fechaAccidente");
		java.sql.Date sqlFechaAccidente = new FechaSQL().toSQL(fechaAccidente); // convierte la fecha a formato compatible con SQL
		
		String lugarAccidente = request.getParameter("lugarAccidente");
		String descripcion = request.getParameter("descripcion");
		int idCliente = (Integer.parseInt(request.getParameter("idCliente")));

		ReporteAccidenteDTO reporte = new ReporteAccidenteDTO(tipoAccidente, diasPerdidos, sqlFechaAccidente, lugarAccidente, descripcion, idCliente);
		ReporteAccidenteDAO reportedao = new ReporteAccidenteDAO();
		boolean agregar = reportedao.create(reporte);
		
		String mensaje = "";
		
		if (agregar)
			mensaje = "El reporte se ha creado exitosamente";
		else
			mensaje = "Ocurrió un error al crear el reporte";
		
		request.setAttribute("cumensaje", mensaje);
		request.getRequestDispatcher("cliente/RegAccidentesClienteCreate.jsp").forward(request, response);
		
		
		
	}

}
