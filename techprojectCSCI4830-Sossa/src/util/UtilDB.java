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

public class UtilDB
{
	static SessionFactory sessionFactory = null;

	public static SessionFactory getSessionFactory()
	{
		if (sessionFactory != null)
		{
			return sessionFactory;
		}
		
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		
		sessionFactory = configuration.buildSessionFactory(builder.build());
		return sessionFactory;
	}

	public static List<BookEntry> listEmployees()
	{
		List<BookEntry> resultList = new ArrayList<BookEntry>();

		Session session = getSessionFactory().openSession();
		Transaction tx = null;

		try
		{
			tx = session.beginTransaction();
			List<?> employees = session.createQuery("FROM MyEmployeeSossa").list();
			for (Iterator<?> iterator = employees.iterator(); iterator.hasNext();)
			{
				BookEntry employee = (BookEntry) iterator.next();
				resultList.add(employee);
			}
			tx.commit();
		}
		catch (HibernateException e)
		{
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
		return resultList;
	}

	public static void createEmployees(String firstnameIn, String lastnameIn, String phoneIn, String emailIn)
	{
		Session session = getSessionFactory().openSession();
		Transaction tx = null;
		try
		{
			tx = session.beginTransaction();
			session.save(new BookEntry());
			tx.commit();
		}
		catch (HibernateException e)
		{
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
	}
}
