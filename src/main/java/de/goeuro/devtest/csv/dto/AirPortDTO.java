package de.goeuro.devtest.csv.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AirPortDTO implements Serializable
{

	private static final long serialVersionUID = 2860938735245175968L;

	@JsonProperty(value = "_id")
	private Integer id;

	@JsonProperty(value = "key")
	private String key;

	@JsonProperty(value = "name")
	private String name;

	@JsonProperty(value = "fullName")
	private String fullName;

	@JsonProperty(value = "iata_airport_code")
	private String iataAirportCode;

	@JsonProperty(value = "type")
	private String type;

	@JsonProperty(value = "country")
	private String country;

	@JsonProperty(value = "geo_position")
	private GeoPositionDTO geoPosition;

	@JsonProperty(value = "inEurope")
	private boolean inEurope;

	@JsonProperty(value = "countryCode")
	private String countryCode;

	@JsonProperty(value = "coreCountry")
	private boolean coreCountry;

	@JsonProperty(value = "distance")
	private String distance;

	@JsonProperty(value = "locationId")
	private Integer locationId;

	@JsonProperty(value = "countryId")
	private Integer countryId;

	/**
	 * Methods used to generate a CSV File
	 * 
	 */
	public Double getLatitude()
	{
		if (geoPosition != null)
			return geoPosition.getLatitude();
		return null;
	}

	public Double getLongitude()
	{
		if (geoPosition != null)
			return geoPosition.getLongitude();
		return null;
	}

	public Integer get_id()
	{
		return id;
	}

	/**
	 * 
	 * ---------------------------------------
	 */

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getKey()
	{
		return key;
	}

	public void setKey(String key)
	{
		this.key = key;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getFullName()
	{
		return fullName;
	}

	public void setFullName(String fullName)
	{
		this.fullName = fullName;
	}

	public String getIataAirportCode()
	{
		return iataAirportCode;
	}

	public void setIataAirportCode(String iataAirportCode)
	{
		this.iataAirportCode = iataAirportCode;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public String getCountry()
	{
		return country;
	}

	public void setCountry(String country)
	{
		this.country = country;
	}

	public GeoPositionDTO getGeoPosition()
	{
		return geoPosition;
	}

	public void setGeoPosition(GeoPositionDTO geoPosition)
	{
		this.geoPosition = geoPosition;
	}

	public boolean isInEurope()
	{
		return inEurope;
	}

	public void setInEurope(boolean inEurope)
	{
		this.inEurope = inEurope;
	}

	public String getCountryCode()
	{
		return countryCode;
	}

	public void setCountryCode(String countryCode)
	{
		this.countryCode = countryCode;
	}

	public boolean isCoreCountry()
	{
		return coreCountry;
	}

	public void setCoreCountry(boolean coreCountry)
	{
		this.coreCountry = coreCountry;
	}

	public String getDistance()
	{
		return distance;
	}

	public void setDistance(String distance)
	{
		this.distance = distance;
	}

	public Integer getLocationId()
	{
		return locationId;
	}

	public void setLocationId(Integer locationId)
	{
		this.locationId = locationId;
	}

	public Integer getCountryId()
	{
		return countryId;
	}

	public void setCountryId(Integer countryId)
	{
		this.countryId = countryId;
	}

}
