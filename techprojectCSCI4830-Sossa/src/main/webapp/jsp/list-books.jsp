<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Book Listing</title>
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<script src="js/bootstrap.min.js"></script>
</head>

<body>
	<div class="container">
		<h2>Books</h2>
		
		<!--Search Form -->
		<form action="/book" method="get" id="seachBookForm" role="form">
			<input type="hidden" id="searchAction" name="searchAction"
				value="searchByName" />
				
			<div class="form-group col-xs-5">
				<input type="text" name="bookName" id="bookName"
					class="form-control" required="true"
					placeholder="Type the Title of the book" />
			</div>
			
			<button type="submit" class="btn btn-info">
				<span class="glyphicon glyphicon-search"></span> Search
			</button>
			<br></br> <br></br>
		</form>
	</div>

	<form action="/book" method="post" id="bookForm" role="form">
		<c:choose>
			<c:when test="${not empty bookList}">
				<table class="table table-striped">
					<thead>
						<tr>
							<td>ID</td>
							<td>Title</td>
							<td>Genres</td>
							<td>Publication Year</td>
							<td>Number of Rating</td>
							<td>Number of Pages</td>
							<td>Author</td>
							<td>Book Rating Count</td>
							<td>Book Review Count</td>
						</tr>
					</thead>
					<c:forEach var="book" items="${bookList}">
						<c:set var="classSucess" value="" />
						<c:if test="${idBook == book.id}">
							<c:set var="classSucess" value="info" />
						</c:if>
						<tr class="${classSucess}">
							<td>${book.id}</td>
							<td>${book.title}</td>
							<td>${book.genres}</td>
							<td>${book.publicationYear}</td>
							<td>${book.numberOfRating}</td>
							<td>${book.numberOfPages}</td>
							<td>${book.author}</td>
							<td>${book.ratingCount}</td>
							<td>${book.reviewCount}</td>
						</tr>
					</c:forEach>
				</table>
			</c:when>
			<c:otherwise>
				<br>
				</br>
				<div class="alert alert-info">No book found matching your
					search criteria</div>
			</c:otherwise>
		</c:choose>
	</form>
</body>
</html>