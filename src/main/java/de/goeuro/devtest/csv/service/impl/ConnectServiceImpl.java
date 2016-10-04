package de.goeuro.devtest.csv.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import de.goeuro.devtest.csv.exception.AirPortException;
import de.goeuro.devtest.csv.service.ConnectService;

@Service
public class ConnectServiceImpl implements ConnectService
{

	final static Logger logger = Logger.getLogger(ConnectServiceImpl.class);

	@Override
	public String connect(String psUrl) throws AirPortException
	{

		logger.info("INI: connect(" + psUrl + ") throws AirPortException");

		StringBuilder sb = new StringBuilder();

		HttpURLConnection connection;
		try
		{

			connection = (HttpURLConnection) new URL(psUrl).openConnection();

			connection.setRequestMethod("GET");
			connection.setRequestProperty("Accept", "application/json");

			logger.info("EXE: connecting... " + psUrl);

			if (connection.getResponseCode() != HttpURLConnection.HTTP_OK)
			{
				throw new AirPortException("Failed : HTTP error code : " + connection.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			while ((line = br.readLine()) != null)
			{
				sb.append(line);
			}
			br.close();

		} catch (IOException e)
		{
			logger.error("EXC: connect(" + psUrl + ")  throws AirPortException", e);
			throw new AirPortException(e.getMessage(), e);
		}

		logger.info("END: connect(" + psUrl + ")  throws AirPortException");

		return sb.toString();

	}

}
