package app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Info;
import util.UtilDB;

@WebServlet(name = "/InsertBookServlet", urlPatterns = { "/InsertBookServlet", "/insertBook" })
public class InsertBookServlet extends HttpServlet implements Info {
	private static final long serialVersionUID = 1L;

	public InsertBookServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String authorAverageRating = request.getParameter("averageRating").trim();
		String authorGender = request.getParameter("gender").trim();
		String authorName = request.getParameter("name");
		String birthplace = request.getParameter("birthplace");
		String bookTitle = request.getParameter("bookTitle");
		String genre = request.getParameter("genre");

		UtilDB.createBook(authorAverageRating, authorGender, authorName, birthplace, bookTitle, genre);

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String title = "New Book Inserted";
		String docType = "<!doctype html public \"-//w3c//dtd html 4.0 transitional//en\">\n"; //
		out.println(docType + //
				"<html>\n" + //
				"<head>" + "<title>" + title + "</title>" + "<link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">"
				+ "<script src=\"js/bootstrap.min.js\"></script>" + "</head>\n" + //
				"<body bgcolor=\"#f0f0f0\">\n" + //
				"<h1 align=\"center\">" + title + "</h1>\n");
		
		out.println("<br/><br/>");
		String html = "<form>" 
				+ "<div class=\"form-group row\">"
				+ "<label for=\"authorAverageRating\" class=\"col-sm-2 col-form-label\">Author Average Rating</label>"
				+ "<div class=\"col-sm-10\">"
				+ "<input type=\"text\" class=\"form-control\" name=\"averageRating\" readonly class=\"form-control-plaintext\" value=\"" + authorAverageRating + "\">"
				+ "</div>" + "</div>" + "			<div class=\"form-group row\">"
				+ "				<label for=\"authorGender\" class=\"col-sm-2 col-form-label\">Gender</label>"
				+ "<div class=\"col-sm-10\">"
				+ "<input type=\"text\" class=\"form-control\" name=\"gender\" readonly class=\"form-control-plaintext\" value=\"" + authorGender + "\">"
				+ "			</div>" + "</div>" + "			<div class=\"form-group row\">"
				+ "				<label for=\"authorName\" class=\"col-sm-2 col-form-label\">Name</label>"
				+ "<div class=\"col-sm-10\">"
				+ "				<input type=\"text\" class=\"form-control\" name=\"name\" readonly class=\"form-control-plaintext\" value=\"" + authorName + "\">"
				+ "			</div>" + "			</div>" + "			<div class=\"form-group row\">"
				+ "				<label for=\"authorBirthPlace\" class=\"col-sm-2 col-form-label\">Birthplace</label>"
				+ "<div class=\"col-sm-10\">"
				+ "				<input type=\"text\" class=\"form-control\" name=\"birthplace\" readonly class=\"form-control-plaintext\" value=\"" + birthplace + "\">"
				+ "			</div>" + "			</div>" + "			<div class=\"form-group row\">"
				+ "				<label for=\"bookTitle\" class=\"col-sm-2 col-form-label\">Book Title</label>"
				+ "<div class=\"col-sm-10\">"
				+ "				<input type=\"text\" class=\"form-control\" name=\"bookTitle\" readonly class=\"form-control-plaintext\" value=\"" + bookTitle + "\">"
				+ "			</div>" + "			</div>" + "			<div class=\"form-group row\">"
				+ "				<label for=\"bookGenre\" class=\"col-sm-2 col-form-label\">Genre</label>"
				+ "<div class=\"col-sm-10\">"
				+ "				<input type=\"text\" class=\"form-control\" name=\"genre\" readonly class=\"form-control-plaintext\" value=\"" + genre + "\">"
				+ "			</div>" + "			</div>" 
				+ "</form>";

		out.println(html);
		out.println("<br/><br/>");
		out.println("<a href=/" + PROJECT_NAME + "/" + SEARCH_WEB_NAME + ">Search Data</a> <br>");
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
