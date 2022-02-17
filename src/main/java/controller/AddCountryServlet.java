package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GeographyItem;

/**
 * Servlet implementation class AddCountryServlet
 */
@WebServlet("/addCountryServlet")
public class AddCountryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCountryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String country = request.getParameter("country");
		String capital = request.getParameter("capital");
		String language = request.getParameter("language");
		
		GeographyItem gi = new GeographyItem(country, capital, language);
		GeographyItemHelper dao = new GeographyItemHelper();
		dao.InsertItem(gi);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
