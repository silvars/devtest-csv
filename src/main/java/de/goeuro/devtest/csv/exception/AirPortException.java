package de.goeuro.devtest.csv.exception;

public class AirPortException extends Exception
{

	private static final long serialVersionUID = 1392081117926262929L;

	public AirPortException(Exception e)
	{
		super();
	}

	public AirPortException(String message)
	{
		super(message);
	}

	public AirPortException(String message, Exception e)
	{
		super(message, e);
	}

}
