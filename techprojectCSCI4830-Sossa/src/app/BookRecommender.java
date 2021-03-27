package app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datamodel.BookEntry;
import util.Info;
import util.UtilDB;

@WebServlet(name = "/BookRecommender", urlPatterns = {"/home", "/book"})
public class BookRecommender extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BookRecommender() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		retrieveDisplayData(response.getWriter());
	}

	void retrieveDisplayData(PrintWriter out) {
		String title = "Database Result";
		String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + //
				"transitional//en\">\n"; //
		out.println(docType + //
				"<html>\n" + //
				"<head>"
				+ "<title>" + title + "</title>"
				+ "<link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">"
				+ "<script src=\"js/bootstrap.min.js\"></script>"
				+ "</head>\n" + //
				"<body bgcolor=\"#f0f0f0\">\n" + //
				"<h1 align=\"center\">" + title + "</h1>\n");
		
		List<BookEntry> listBooks = UtilDB.listBooks();
		
		out.println("<br/><br/>");
		out.println("<table class=\"table table-striped table-bordered table-hover\">"
				+ "<tr>"
				+ "<th>ID</th>"
				+ "<th>Average Rating</th>"
				+ "<th>Gender</th>"
				+ "<th>Name</th>"
				+ "<th>Birthplace</th>"
				+ "<th>Book Title</th>"
				+ "<th>Genre</th>"
				+ "</tr>");
		for (BookEntry book : listBooks){
			out.println("<tr>"
					+ "<td>" + book.getId() + "</td>"
					+ "<td>" + book.getAuthor_average_rating() + "</td>"
					+ "<td>" + book.getAuthorGender() + "</td>"
					+ "<td>" + book.getAuthorName() + "</td>"
					+ "<td>" + book.getBirthplace() + "</td>"
					+ "<td>" + book.getBookTitle() + "</td>"
					+ "<td>" + book.getGenre() + "</td>"
					+ "</tr>");
		}
		out.println("</table>");
		out.println("<br/><br/>");
		out.println("<a href=/" + Info.PROJECT_NAME + "/" + Info.SEARCH_WEB_NAME + ">Search Book</a> <br>");
		out.println("<a href=/" + Info.PROJECT_NAME + "/" + Info.INSERT_WEB_NAME + ">Search Insert Book</a> <br>");
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
