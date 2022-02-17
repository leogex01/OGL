package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GeographyItem;

/**
 * Servlet implementation class EditCountryServlet
 */
@WebServlet("/editCountryServlet")
public class EditCountryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCountryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		GeographyItemHelper dao = new GeographyItemHelper();
		
		String country =request.getParameter("country");
		String capital =request.getParameter("capital");
		String language =request.getParameter("language");
		Integer tempid = Integer.parseInt(request.getParameter("id"));
		
		GeographyItem itemToUpdate = dao.searchForItemById(tempid);
		itemToUpdate.setCountry(country);
		itemToUpdate.setCapital(capital);
		itemToUpdate.setLanguage(language);
		
		dao.updateItem(itemToUpdate);
		
		getServletContext().getRequestDispatcher("/viewCountriesServlet").forward(request, response);
		
	}
	}


