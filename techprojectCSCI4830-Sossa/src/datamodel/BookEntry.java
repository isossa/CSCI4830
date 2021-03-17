package datamodel;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @since J2SE-1.8 CREATE TABLE BookTable ( id INT NOT NULL AUTO_INCREMENT,
 *        first_name VARCHAR(30) NOT NULL, last_name VARCHAR(30) NOT NULL, phone
 *        VARCHAR(30) NOT NULL, email VARCHAR(30) NOT NULL, PRIMARY KEY (id));
 */
@Entity
@Table(name = "BookTable")
public class BookEntry
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "average_rating")
	private Double averageRating;
	
	@Column(name = "url")
	private String url;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "genre")
	private Set<Genre> genres;
	
	@Column(name = "publication_year")
	private Integer publicationYear;
	
	@Column(name = "number_of_rating")
	private Integer numberOfRating;
	
	@Column(name = "number_of_review")
	private Integer numberOfReview;
	
	@Column(name = "number_of_pages")
	private Integer numberOfPages;
	
	@Column(name = "score")
	private Integer score;
	
	@Column(name = "author")
	private Author author;
	
	@Column(name = "book_rating_count")
	private Integer ratingCount;
	
	@Column(name = "book_review_count")
	private Integer reviewCount;
	
	public BookEntry() 
	{	}

	
	public BookEntry(Integer id, String title, Integer publicationYear, Integer score, Author author)
	{
		this.id = id;
		this.title = title;
		this.publicationYear = publicationYear;
		this.score = score;
		this.author = author;
	}


	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Double getAverageRating()
	{
		return averageRating;
	}

	public void setAverageRating(Double averageRating)
	{
		this.averageRating = averageRating;
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public Set<Genre> getGenres()
	{
		return genres;
	}

	public void setGenres(List<Genre> genres)
	{
		for (Genre genre : genres)
		{
			this.genres.add(genre);
		}
	}

	public Integer getPublicationYear()
	{
		return publicationYear;
	}

	public void setPublicationYear(Integer publicationYear)
	{
		this.publicationYear = publicationYear;
	}

	public Integer getNumberOfRating()
	{
		return numberOfRating;
	}

	public void setNumberOfRating(Integer numberOfRating)
	{
		this.numberOfRating = numberOfRating;
	}

	public Integer getNumberOfReview()
	{
		return numberOfReview;
	}

	public void setNumberOfReview(Integer numberOfReview)
	{
		this.numberOfReview = numberOfReview;
	}

	public Integer getNumberOfPages()
	{
		return numberOfPages;
	}

	public void setNumberOfPages(Integer numberOfPages)
	{
		this.numberOfPages = numberOfPages;
	}

	public Integer getScore()
	{
		return score;
	}

	public void setScore(Integer score)
	{
		this.score = score;
	}
	
	public Author getAuthor()
	{
		return author;
	}

	public void setAuthor(Author author)
	{
		this.author = author;
	}
	
	public int getReviewCount()
	{
		return reviewCount;
	}

	public void setReviewCount(int reviewCount)
	{
		this.reviewCount = reviewCount;
	}
	
	public int getRatingCount()
	{
		return ratingCount;
	}

	public void setRatingCount(int ratingCount)
	{
		this.ratingCount = ratingCount;
	}
}