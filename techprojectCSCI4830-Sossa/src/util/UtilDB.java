/**
 */
package util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import datamodel.BookEntry;

/**
 * @since JavaSE-1.8
 */
public class UtilDB {
	static SessionFactory sessionFactory = null;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory != null) {
			return sessionFactory;
		}
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		sessionFactory = configuration.buildSessionFactory(builder.build());
		return sessionFactory;
	}

	public static List<BookEntry> listBooks() {
		List<BookEntry> resultList = new ArrayList<BookEntry>();

		Session session = getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			List<?> books = session.createQuery("FROM BookEntry").list();
			for (Iterator<?> iterator = books.iterator(); iterator.hasNext();) {
				BookEntry book = (BookEntry) iterator.next();
				resultList.add(book);
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return resultList;
	}

	public static List<BookEntry> listBooks(String keyword) {
		List<BookEntry> resultList = new ArrayList<BookEntry>();

		Session session = getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			System.out.println((BookEntry) session.get(BookEntry.class, 1)); // use "get" to fetch data
			List<?> books = session.createQuery("FROM BookEntry").list();
			for (Iterator<?> iterator = books.iterator(); iterator.hasNext();) {
				BookEntry book = (BookEntry) iterator.next();
				if (book.getAuthorName().toLowerCase().contains(keyword.toLowerCase())) {
					resultList.add(book);
				}
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return resultList;
	}

	public static void createBook(String authorAverageRating, String authorGender, String authorName, String birthplace,
			String bookTitle, String genre) {
		Session session = getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(new BookEntry(authorAverageRating, authorGender, authorName, birthplace, bookTitle, genre));
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
