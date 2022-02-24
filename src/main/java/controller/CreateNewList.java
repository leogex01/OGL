package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GeographyItem;
import model.ListDetails;
import model.Student;

/**
 * Servlet implementation class CreateNewList
 */
@WebServlet("/createNewListServlet")
public class CreateNewList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		StudentHelper sh = new StudentHelper();
		String listOfCountries = request.getParameter("listOfCOuntries");
		System.out.println("List Name: " + listOfCountries);
		String[] selectedItems = request.getParameterValues("allItemsToAdd");
		String studentName  = request.getParameter("studentName");
		
		List<GeographyItem> selectedItemsInList = new ArrayList<GeographyItem>();
		//make sure something was selected –otherwise we get a null pointer exception
		if (selectedItems != null && selectedItems.length > 0) {
			for(int i = 0; i<selectedItems.length; i++) {
				System.out.println(selectedItems[i]);
				GeographyItem c = sh.searchForItemById(Integer.parseInt(selectedItems[i]));
				selectedItemsInList.add(c);
				}
			}
		Student student = new Student(studentName);
		ListDetails sld = new ListDetails(listOfCountries, student);
		
		sld.setListOfCountries(selectedItemsInList);
		ListDetailsHelper slh = new ListDetailsHelper();
		slh.insertNewListDetails(sld);
		System.out.println("Success!");
		System.out.println(sld.toString());
		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
