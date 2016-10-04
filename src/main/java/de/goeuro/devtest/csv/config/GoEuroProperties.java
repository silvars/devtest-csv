package de.goeuro.devtest.csv.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "goeuro.properties")
public class GoEuroProperties
{

	@Value("${goeuro.baseUrl}")
	private String baseURL;

	@Value("${goeuro.file.location}")
	private String fileLocation;

	public String getBaseURL()
	{
		return baseURL;
	}

	public void setBaseURL(String baseURL)
	{
		this.baseURL = baseURL;
	}

	public String getFileLocation()
	{
		return fileLocation;
	}

	public void setFileLocation(String fileLocation)
	{
		this.fileLocation = fileLocation;
	}

}
