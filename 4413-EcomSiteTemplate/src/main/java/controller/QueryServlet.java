package controller;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;

import java.util.ArrayList;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOImpl;
import model.Item;


/**
 * Servlet implementation class QueryServlet
 */
@WebServlet("/QueryServlet")
public class QueryServlet extends HttpServlet {
	private DAOImpl itemDAO = new DAOImpl();
    /**
     * Default constructor. 
     */
	public QueryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String base = "/jsp/"; // Folder linking to jsp location
		String url = base + "home.jsp"; // for example got to jsp/home.jsp
		
		// If any of these key words are found, send it to a different jsp
		String action = request.getParameter("action"); 
		String category = request.getParameter("category");
		String keyWord = request.getParameter("keyWord");
		if (action != null) {
			switch (action) {
			
			// For each of these cases, we create a method!
			case "allBooks":
				findAllItems(request, response);
				url = base + "listOfBooks.jsp";
				break;
			case "category":
				findByBrand(request, response, keyWord);
				url = base + "category.jsp?category=" + category;
				break;
			case "search":
				searchKeyword(request, response, category);
				url = base + "searchResult.jsp";
				break;

			}
		}
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(url);
		requestDispatcher.forward(request, response);
	}

	
	// The methods are below that we call for switch:
	private void findAllItems(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			// calling DAO method to retrieve a list of all books 
			List<Item> bookList = itemDAO.findAllItems();
			
			// CHANGE HERE 
			request.setAttribute("bookList", bookList);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	//search books by keyword
	private void searchKeyword(HttpServletRequest request,
			HttpServletResponse response, String keyWord)
			throws ServletException, IOException {
		try {
			// calling DAO method to search book by keyword 
			List<Item> bookList = itemDAO.searchKeyword(keyWord);

			// CHANGE HERE 
			request.setAttribute("bookList", bookList);

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	private void findByBrand(HttpServletRequest request,
			HttpServletResponse response, String cate)
			throws ServletException, IOException {
		try {
			// calling DAO method to retrieve all items
			List<Item> bookList = itemDAO.findAllItems();
						
			// CHANGE HERE 
			request.setAttribute("bookList", bookList);

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
}
