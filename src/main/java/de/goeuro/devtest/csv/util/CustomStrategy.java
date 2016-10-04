package de.goeuro.devtest.csv.util;

import java.util.Map;
import java.util.Set;

import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;

public class CustomStrategy<T> extends HeaderColumnNameTranslateMappingStrategy<T>
{

	@Override
	public void setColumnMapping(Map<String, String> columnMapping)
	{
		super.setColumnMapping(columnMapping);
		header = new String[columnMapping.size()];
		int i = 0;

		Set<String> keys = columnMapping.keySet();

		for (Object key : keys)
		{
			header[i] = columnMapping.get(key).toString().toUpperCase();
			i++;
		}
	}

	public String[] getHeader()
	{
		return header;
	}
}
