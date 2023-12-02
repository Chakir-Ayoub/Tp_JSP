package controllers;

import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sessions.VehiculeFacade;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import entities.Vehicule;
@WebServlet("/")
public class VehiculeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private VehiculeFacade facade;

	public VehiculeController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();
		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertVehicule(request, response);
				break;
			case "/delete":
				deleteVehicule(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateVehicule(request, response);
				break;
			default:
				listVehicule(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void listVehicule(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Vehicule> listVehicule = facade.findAll();
		request.setAttribute("listVehicule", listVehicule);
		RequestDispatcher dispatcher = request.getRequestDispatcher("vehicule-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("vehicule-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Vehicule existingVehicule = facade.find(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("vehicule-form.jsp");
		request.setAttribute("vehicule", existingVehicule);
		dispatcher.forward(request, response);

	}

	private void insertVehicule(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String matricule = request.getParameter("matricule");
		Vehicule newVehicule = new Vehicule(matricule);
		facade.create(newVehicule);
		response.sendRedirect("list");
	}

	private void updateVehicule(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String matricule = request.getParameter("matricule");
        System.out.println("ID: " + id);
        System.out.println("Matricule: " + matricule);
		Vehicule vehicule = new Vehicule(id, matricule);
		facade.edit(vehicule);
		response.sendRedirect("list");
	}

	private void deleteVehicule(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Vehicule existingVehicule = facade.find(id);
		facade.remove(existingVehicule);
		response.sendRedirect("list");

	}

}
