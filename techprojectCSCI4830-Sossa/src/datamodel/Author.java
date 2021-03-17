package datamodel;

import java.util.List;

public class Author
{
	private double averageRating;
	
	private String gender;
	
	private String name;
	
	private String pageUrl;
	
	private String birthPlace;
	
	private List<BookEntry> catalog;
	
	public Author(String name, String pageUrl, String birthPlace)
	{
		
	}

	public List<BookEntry> getCatalog()
	{
		return catalog;
	}

	public void setCatalog(List<BookEntry> catalog)
	{
		this.catalog = catalog;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getPageUrl()
	{
		return pageUrl;
	}

	public void setPageUrl(String pageUrl)
	{
		this.pageUrl = pageUrl;
	}

	public String getBirthPlace()
	{
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace)
	{
		this.birthPlace = birthPlace;
	}

	public double getAverageRating()
	{
		return averageRating;
	}

	public void setAverageRating(double averageRating)
	{
		this.averageRating = averageRating;
	}

	public String getGender()
	{
		return gender;
	}

	public void setGender(String gender)
	{
		this.gender = gender;
	}
}
