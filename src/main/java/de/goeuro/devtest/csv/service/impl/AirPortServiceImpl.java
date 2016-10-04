package de.goeuro.devtest.csv.service.impl;

import java.net.URLEncoder;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import de.goeuro.devtest.csv.config.GoEuroProperties;
import de.goeuro.devtest.csv.dto.AirPortDTO;
import de.goeuro.devtest.csv.exception.AirPortException;
import de.goeuro.devtest.csv.service.AirPortService;
import de.goeuro.devtest.csv.service.ConnectService;
import de.goeuro.devtest.csv.service.FileService;

@Service
public class AirPortServiceImpl implements AirPortService
{

	final static Logger logger = Logger.getLogger(AirPortServiceImpl.class);

	@Autowired
	private GoEuroProperties goEuroProperties;

	@Autowired
	private ConnectService connectService;

	@Autowired
	private FileService fileService;

	@Override
	public void generateCSVFile(final String psCity) throws AirPortException
	{

		logger.info("INI: generateCSVFile(" + psCity + ") throws AirPortException");

		if (StringUtils.isBlank(psCity))
		{
			throw new AirPortException("A city name is required!!!");
		}

		String jsonResult;
		try
		{
			jsonResult = connectService.connect(String.format(goEuroProperties.getBaseURL(), URLEncoder.encode(psCity, "UTF-8")));

			ObjectMapper mapper = new ObjectMapper();

			// JSON from String to Object
			AirPortDTO[] airports = mapper.readValue(jsonResult, AirPortDTO[].class);
			if (airports != null && airports.length > 0)
			{
				fileService.saveFile(airports, psCity);

			} else
			{
				throw new AirPortException("There are no data to generate CSV file for: " + psCity);
			}
		} catch (Exception e)
		{
			throw new AirPortException(e);
		} finally
		{
			logger.info("END: generateCSVFile(" + psCity + ") throws AirPortException");
		}

	}

}
