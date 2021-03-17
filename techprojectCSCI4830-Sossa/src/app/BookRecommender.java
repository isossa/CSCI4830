package app;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datamodel.BookEntry;
import service.BookService;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/BookRecommender")
public class BookRecommender extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	BookService bookService = new BookService();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookRecommender() 
    {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		response.setContentType("text/html");
		response.getWriter().println("We are back online." + "</br></br>");
		
		String action = request.getParameter("searchAction");
		response.getWriter().println(action + "</br>");

//        if (action!=null)
//        {
//            switch (action)
//            {           
//            	case "searchById":
//            		searchBookById(request, response);
//                break;           
//            
//            	case "searchByName":
//            		searchBookByName(request, response);
//                break;
//            }
//        }
//        else
//        {
            List<BookEntry> result = bookService.getAllBooks();
            for (BookEntry book : result)
            {
            	System.out.println(book.getTitle());
            }
            forwardListBooks(request, response, result);
//        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		doGet(request, response);
	}

	private void forwardListBooks(HttpServletRequest request, HttpServletResponse response, List<BookEntry> bookList)
			throws ServletException, IOException
	{
		String nextJSP = "/jsp/list-books.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        request.setAttribute("bookList", bookList);
        dispatcher.forward(request, response);
	}

	private void searchBookById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		long idBook = Integer.valueOf(request.getParameter("idBook"));
		
        BookEntry book = null;
        
        try
        {
            book = bookService.getEmployee(idBook);
        }
        catch (Exception ex)
        {
            Logger.getLogger(BookRecommender.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.setAttribute("book", book);
        request.setAttribute("action", "edit");
        String nextJSP = "/jsp/new-book.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request, response);
	}

	private void searchBookByName(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String bookName = request.getParameter("bookName");
        List<BookEntry> result = bookService.searchBooksByName(bookName);        
        forwardListBooks(request, response, result);
	}
}
