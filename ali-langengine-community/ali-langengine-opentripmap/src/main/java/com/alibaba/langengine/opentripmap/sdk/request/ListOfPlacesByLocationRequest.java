package com.alibaba.langengine.opentripmap.sdk.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ListOfPlacesByLocationRequest {
    @JsonProperty("lang")
    private String lang; // Language code (2 characters, ISO639-1)
    
    @JsonProperty("lon_min")
    private double lonMin; // Minimum longitude
    
    @JsonProperty("lon_max")
    private double lonMax; // Maximum longitude
    
    @JsonProperty("lat_min")
    private double latMin; // Minimum latitude
    
    @JsonProperty("lat_max")
    private double latMax; // Maximum latitude
    
    @JsonProperty("src_geom")
    private String srcGeom; // The source of the object geometry (optional)
    
    @JsonProperty("src_attr")
    private String srcAttr; // The source of the object attributes (optional)
    
    @JsonProperty("kinds")
    private String kinds; // Object category (optional)
    
    @JsonProperty("name")
    private String name; // Search term for object name (optional)
    
    @JsonProperty("rate")
    private String rate; // Minimum rating of the object popularity (optional)
    
    @JsonProperty("format")
    private String format; // The output format (optional)
    
    @JsonProperty("limit")
    private Integer limit; // Maximum number of returned objects (optional)

    // Getters and Setters
    public String getLang() { return lang; }
    public void setLang(String lang) { this.lang = lang; }

    public double getLonMin() { return lonMin; }
    public void setLonMin(double lonMin) { this.lonMin = lonMin; }

    public double getLonMax() { return lonMax; }
    public void setLonMax(double lonMax) { this.lonMax = lonMax; }

    public double getLatMin() { return latMin; }
    public void setLatMin(double latMin) { this.latMin = latMin; }

    public double getLatMax() { return latMax; }
    public void setLatMax(double latMax) { this.latMax = latMax; }

    public String getSrcGeom() { return srcGeom; }
    public void setSrcGeom(String srcGeom) { this.srcGeom = srcGeom; }

    public String getSrcAttr() { return srcAttr; }
    public void setSrcAttr(String srcAttr) { this.srcAttr = srcAttr; }

    public String getKinds() { return kinds; }
    public void setKinds(String kinds) { this.kinds = kinds; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getRate() { return rate; }
    public void setRate(String rate) { this.rate = rate; }

    public String getFormat() { return format; }
    public void setFormat(String format) { this.format = format; }

    public Integer getLimit() { return limit; }
    public void setLimit(Integer limit) { this.limit = limit; }
}
