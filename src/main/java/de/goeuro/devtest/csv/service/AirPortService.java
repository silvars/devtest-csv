package de.goeuro.devtest.csv.service;

import de.goeuro.devtest.csv.exception.AirPortException;

public interface AirPortService
{

	public void generateCSVFile(final String psCity) throws AirPortException;

}
