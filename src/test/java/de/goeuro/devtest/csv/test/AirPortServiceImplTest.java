package de.goeuro.devtest.csv.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import de.goeuro.devtest.csv.Application;
import de.goeuro.devtest.csv.exception.AirPortException;
import de.goeuro.devtest.csv.service.AirPortService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class AirPortServiceImplTest
{
	@Autowired
	private AirPortService airPortService;

	@Test
	public void testSaoPaulo() throws AirPortException
	{
		airPortService.generateCSVFile("Sao Paulo");
	}

	@Test
	public void testSaoPauloEspecialChar() throws AirPortException
	{
		airPortService.generateCSVFile("São Paulo");
	}

	@Test
	public void testLondon() throws AirPortException
	{
		airPortService.generateCSVFile("London");

	}

	@Test
	public void testBerlin() throws AirPortException
	{
		airPortService.generateCSVFile("Berlin");

	}

	@Test(expected = AirPortException.class)
	public void testInvalidyCity() throws AirPortException
	{
		airPortService.generateCSVFile("XXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

	}

	@Test(expected = AirPortException.class)
	public void testInvalidCity() throws AirPortException
	{
		airPortService.generateCSVFile(null);
	}

}
