package de.goeuro.devtest.csv.service.impl;

import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opencsv.CSVWriter;
import com.opencsv.bean.BeanToCsv;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;

import de.goeuro.devtest.csv.config.GoEuroProperties;
import de.goeuro.devtest.csv.dto.AirPortDTO;
import de.goeuro.devtest.csv.exception.AirPortException;
import de.goeuro.devtest.csv.service.FileService;
import de.goeuro.devtest.csv.util.CustomBeanToCsv;
import de.goeuro.devtest.csv.util.CustomStrategy;

@Service
public class FileServiceImpl implements FileService
{

	@Autowired
	private GoEuroProperties goEuroProperties;

	final static Logger logger = Logger.getLogger(FileServiceImpl.class);

	@Override
	public void saveFile(final AirPortDTO[] poAirPorts, final String psFileName) throws AirPortException
	{

		logger.info("INI: saveFile(AirPortDTO[], String) throws AirPortException");

		BeanToCsv<AirPortDTO> beanToCsv = new CustomBeanToCsv<AirPortDTO>();

		Map<String, String> columnMapping = new HashMap<String, String>();
		columnMapping.put("_id", "_id");
		columnMapping.put("name", "name");
		columnMapping.put("type", "type");
		columnMapping.put("latitude", "latitude");
		columnMapping.put("longitude", "longitude");

		HeaderColumnNameTranslateMappingStrategy<AirPortDTO> strategy = new CustomStrategy<AirPortDTO>();
		strategy.setType(AirPortDTO.class);
		strategy.setColumnMapping(columnMapping);

		File arquivo = new File(new File(goEuroProperties.getFileLocation()), File.separator + psFileName.replaceAll(" ", "") + ".csv");

		arquivo.delete();

		try
		{

			arquivo.createNewFile();

			CSVWriter writer = new CSVWriter(new FileWriter(arquivo));
			beanToCsv.write(strategy, writer, Arrays.asList(poAirPorts));
			writer.close();

		} catch (Exception e)
		{
			throw new AirPortException(e);
		}

		logger.info("EXE: ***********************************************************************");
		logger.info("EXE: Generated file: " + arquivo.getAbsolutePath());
		logger.info("EXE: ***********************************************************************");

		logger.info("END: saveFile(AirPortDTO[], String) throws AirPortException");

	}

}
