package datamodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Books")
public class BookEntry
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "author_average_rating")
	private String authorAverageRating;
	
	@Column(name = "author_gender")
	private String authorGender;
	
	@Column(name = "author_name")
	private String authorName;
	
	@Column(name = "birthplace")
	private String birthplace;
	
	@Column(name = "book_title")
	private String bookTitle;
	
	@Column(name = "genre")
	private String genre;

	public BookEntry() {
	}
	
	public BookEntry(Integer id, String authorAverageRating, String authorGender, String authorName, String birthplace,
			String bookTitle, String genre) {
		this(authorAverageRating, authorGender, authorName, birthplace, bookTitle, genre);
		this.id = id;
	}
	
	public BookEntry(String authorAverageRating, String authorGender, String authorName, String birthplace,
			String bookTitle, String genre) {
		this.authorAverageRating = authorAverageRating;
		this.authorGender = authorGender;
		this.authorName = authorName;
		this.birthplace = birthplace;
		this.bookTitle = bookTitle;
		this.genre = genre;
	}

	public Integer getId() {
		return id;
	}

	public String getAuthor_average_rating() {
		return authorAverageRating;
	}

	public String getAuthorGender() {
		return authorGender;
	}

	public String getAuthorName() {
		return authorName;
	}

	public String getBirthplace() {
		return birthplace;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public String getGenre() {
		return genre;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setAuthor_average_rating(String author_average_rating) {
		this.authorAverageRating = author_average_rating;
	}
	
	public void setAuthorGender(String authorGender) {
		this.authorGender = authorGender;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}


	@Override
	public String toString() {
		return id + ", authorAverageRating=" + authorAverageRating + ", authorGender=" + authorGender
				+ ", authorName=" + authorName + ", birthplace=" + birthplace + ", bookTitle=" + bookTitle + ", genre="
				+ genre;
	}


}