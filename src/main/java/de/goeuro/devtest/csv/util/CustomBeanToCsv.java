package de.goeuro.devtest.csv.util;

import java.beans.IntrospectionException;

import com.opencsv.bean.BeanToCsv;
import com.opencsv.bean.MappingStrategy;

public class CustomBeanToCsv<T> extends BeanToCsv<T>
{
	@Override
	protected String[] processHeader(MappingStrategy<T> mapper) throws IntrospectionException
	{
		if (mapper instanceof CustomStrategy)
		{
			return ((CustomStrategy<T>) mapper).getHeader();
		} else
		{
			return super.processHeader(mapper);
		}
	}
}
