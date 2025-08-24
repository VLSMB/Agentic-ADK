package com.alibaba.langengine.opentripmap.sdk.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Geoname {
    @JsonProperty("name")
    private String name; // The name of the place
    
    @JsonProperty("country")
    private String country; // ISO-3166 2-letter country code
    
    @JsonProperty("lon")
    private double lon; // Longitude
    
    @JsonProperty("lat")
    private double lat; // Latitude
    
    @JsonProperty("timezone")
    private String timezone; // The iana timezone id
    
    @JsonProperty("population")
    private Integer population; // Population count
    
    @JsonProperty("partial_match")
    private Boolean partialMatch; // A sign that the method did not return an exact match for the requested name

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public double getLon() { return lon; }
    public void setLon(double lon) { this.lon = lon; }

    public double getLat() { return lat; }
    public void setLat(double lat) { this.lat = lat; }

    public String getTimezone() { return timezone; }
    public void setTimezone(String timezone) { this.timezone = timezone; }

    public Integer getPopulation() { return population; }
    public void setPopulation(Integer population) { this.population = population; }

    public Boolean getPartialMatch() { return partialMatch; }
    public void setPartialMatch(Boolean partialMatch) { this.partialMatch = partialMatch; }
}
