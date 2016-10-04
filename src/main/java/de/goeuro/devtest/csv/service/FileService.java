package de.goeuro.devtest.csv.service;

import de.goeuro.devtest.csv.dto.AirPortDTO;
import de.goeuro.devtest.csv.exception.AirPortException;

public interface FileService
{

	public void saveFile(final AirPortDTO[] poAirPorts, final String psFileName) throws AirPortException;

}
