package de.goeuro.devtest.csv;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import de.goeuro.devtest.csv.exception.AirPortException;
import de.goeuro.devtest.csv.service.AirPortService;

@SpringBootApplication
public class Application
{

	final static Logger logger = Logger.getLogger(Application.class);

	public static void main(String[] args)
	{
		ApplicationContext applicationContext = SpringApplication.run(Application.class, args);
		AirPortService airPortService = applicationContext.getBean(AirPortService.class);

		if (args != null && args[0].length() > 0)
		{
			try
			{
				airPortService.generateCSVFile(args[0].trim().toUpperCase());
			} catch (AirPortException e)
			{
				logger.error("Could not generate CSV file for: " + args[0] + "\n\t" + e.getMessage(), e);
			} catch (Exception e)
			{
				logger.error("Unexpected error!", e);
			}
		} else
		{
			logger.warn("A city name is required!!!");
		}
	}

}