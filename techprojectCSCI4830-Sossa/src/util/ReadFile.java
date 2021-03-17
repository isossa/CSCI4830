package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.servlet.ServletContext;

public class ReadFile
{
	public static List<String> readFile(ServletContext servletContext, String filename)
	{
		List<String> contents = new ArrayList<String>();
		try(InputStream is = servletContext.getResourceAsStream(filename))
		{
			if (is != null)
			{
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader reader = new BufferedReader(isr);
				String text;
				while ((text = reader.readLine()) != null)
				{
					contents.add(text);
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return contents;
	}
	
	public static List<String> readFile(String filePath)
	{
		List<String> contents = new ArrayList<String>();
		File file = new File(filePath);
		try(Scanner scanner = new Scanner(file))
		{
			while (scanner.hasNextLine())
			{
				String line = scanner.nextLine();
				contents.add(line);
			}
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		return contents;
	}
}
