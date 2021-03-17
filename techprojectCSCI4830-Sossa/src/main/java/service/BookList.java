package service;

import java.util.ArrayList;
import java.util.List;

import datamodel.Author;
import datamodel.BookEntry;

public class BookList
{
	private static final List<BookEntry> bookList = new ArrayList<BookEntry>();
    
    private BookList()
    {    }
    
    static
    {
    	bookList.add(new BookEntry(1, "Hey there", 2020, 23, new Author("Mike Andreason", null, "USA")));
    	bookList.add(new BookEntry(2, "Hi there", 2010, 289, new Author("Andrew Wiles", null, "Australia")));
    	bookList.add(new BookEntry(3, "Hey there", 2020, 23, new Author("Robert Millers", null, "USA")));
    	bookList.add(new BookEntry(4, "Hey there", 1998, 93, new Author("Rebecca Williams", null, "Canada")));
    	bookList.add(new BookEntry(5, "Hey there", 2008, 25, new Author("Stephan Harms", null, "USA")));
    	bookList.add(new BookEntry(6, "Hey there", 2000, 83, new Author("William Hamilton", null, "Canada")));
    }
    
    public static List <BookEntry> getInstance()
    {
        return bookList;
    }
}
