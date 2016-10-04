package de.goeuro.devtest.csv.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GeoPositionDTO implements Serializable
{

	private static final long serialVersionUID = 6688926343998248463L;

	@JsonProperty(value = "latitude")
	private Double latitude;

	@JsonProperty(value = "longitude")
	private Double longitude;

	public Double getLatitude()
	{
		return latitude;
	}

	public void setLatitude(Double latitude)
	{
		this.latitude = latitude;
	}

	public Double getLongitude()
	{
		return longitude;
	}

	public void setLongitude(Double longitude)
	{
		this.longitude = longitude;
	}

}
