package service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import datamodel.BookEntry;

/**
 * Render list of books.
 * 
 * @author isossa
 */
public class BookService
{
	List<BookEntry> bookList = BookList.getInstance();
	
	//Get all employees.
    public List<BookEntry> getAllBooks()
    {        
        return bookList;
    }
    
    //Get all employees whose Name or Last Name match the searchParam, order by name and last name.
    public List<BookEntry> searchBooksByName(String searchParam)
    {
        Comparator<BookEntry> groupByComparator = Comparator.comparing(BookEntry::getTitle)
                                                    .thenComparing(BookEntry::getTitle);
        List<BookEntry> result = bookList
                .stream()
                .filter(e -> e.getTitle().equalsIgnoreCase(searchParam) || e.getTitle().equalsIgnoreCase(searchParam))
                .sorted(groupByComparator)
                .collect(Collectors.toList());
        return result;
    }
    
    //Get the book by id
    public BookEntry getEmployee(long id) throws Exception
    {
        Optional<BookEntry> match
                = bookList.stream()
                .filter(e -> e.getId() == id)
                .findFirst();
        if (match.isPresent())
        {
            return match.get();
        }
        else
        {
            throw new Exception("The BookEntry id " + id + " not found");
        }
    }
}
