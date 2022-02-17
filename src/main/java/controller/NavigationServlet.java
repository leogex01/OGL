package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GeographyItem;

/**
 * Servlet implementation class NavigationServlet
 */
@WebServlet("/navigationServlet")
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NavigationServlet() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
		// after all changes, we should redirect to the viewAllItems servlet
		// The only time we don't is if they select to add a new item or edit
		String path = "/viewCountriesServlet";

		GeographyItemHelper dao = new GeographyItemHelper();
		String act = request.getParameter("doThisToItem");

		if(act.equals("delete")) {
			try {
	    		Integer tempid = Integer.parseInt(request.getParameter("id"));
	    		GeographyItem itemToDelete = dao.searchForItemById(tempid);
	    		dao.deleteItem(itemToDelete);
	    	} catch (NumberFormatException e) {
				System.out.println("Forgot to select an item");
	    	}
		    } else if(act.equals("edit")) {
		    	try {
		    		Integer tempId = Integer.parseInt(request.getParameter("id"));
		    		GeographyItem itemToEdit = dao.searchForItemById(tempId);
		    		request.setAttribute("itemToEdit", itemToEdit);
		    		path = "/edit-country.jsp";
		    	}catch (NumberFormatException e) {
		    		System.out.println("Forgot to select an item");
		    	}
		    	} else if (act.equals("add")) {
			path="/index.html";
		}
		getServletContext().getRequestDispatcher(path).forward(request, response);




	}
	
}
