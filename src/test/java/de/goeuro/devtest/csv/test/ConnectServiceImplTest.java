package de.goeuro.devtest.csv.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import de.goeuro.devtest.csv.Application;
import de.goeuro.devtest.csv.config.GoEuroProperties;
import de.goeuro.devtest.csv.exception.AirPortException;
import de.goeuro.devtest.csv.service.ConnectService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ConnectServiceImplTest
{
	@Autowired
	private ConnectService connectService;

	@Autowired
	private GoEuroProperties goEuroProperties;

	@Test(expected = AirPortException.class)
	public void testSaoPaulo() throws AirPortException
	{
		connectService.connect(String.format(goEuroProperties.getBaseURL(), "São Paulo"));
	}

}
