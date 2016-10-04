package de.goeuro.devtest.csv.service;

import de.goeuro.devtest.csv.exception.AirPortException;

public interface ConnectService
{

	public String connect(final String psUrl) throws AirPortException;

}
