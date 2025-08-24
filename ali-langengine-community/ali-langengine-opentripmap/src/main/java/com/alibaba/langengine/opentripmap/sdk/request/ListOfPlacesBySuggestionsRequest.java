package com.alibaba.langengine.opentripmap.sdk.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ListOfPlacesBySuggestionsRequest {
    @JsonProperty("lang")
    private String lang; // Language code (2 characters, ISO639-1)
    
    @JsonProperty("name")
    private String name; // The query term on which to search
    
    @JsonProperty("radius")
    private double radius; // Maximum distance from selected point in meters
    
    @JsonProperty("lon")
    private double lon; // Longitude of selected point
    
    @JsonProperty("lat")
    private double lat; // Latitude of selected point
    
    @JsonProperty("src_geom")
    private String srcGeom; // The source of the object geometry (optional)
    
    @JsonProperty("src_attr")
    private String srcAttr; // The source of the object attributes (optional)
    
    @JsonProperty("kinds")
    private String kinds; // Object category (optional)
    
    @JsonProperty("rate")
    private String rate; // Minimum rating of the object popularity (optional)
    
    @JsonProperty("format")
    private String format; // The output format (optional)
    
    @JsonProperty("props")
    private String props; // Search properties (base or address) (optional)
    
    @JsonProperty("limit")
    private Integer limit; // Maximum number of returned objects (optional)

    // Getters and Setters
    public String getLang() { return lang; }
    public void setLang(String lang) { this.lang = lang; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getRadius() { return radius; }
    public void setRadius(double radius) { this.radius = radius; }

    public double getLon() { return lon; }
    public void setLon(double lon) { this.lon = lon; }

    public double getLat() { return lat; }
    public void setLat(double lat) { this.lat = lat; }

    public String getSrcGeom() { return srcGeom; }
    public void setSrcGeom(String srcGeom) { this.srcGeom = srcGeom; }

    public String getSrcAttr() { return srcAttr; }
    public void setSrcAttr(String srcAttr) { this.srcAttr = srcAttr; }

    public String getKinds() { return kinds; }
    public void setKinds(String kinds) { this.kinds = kinds; }

    public String getRate() { return rate; }
    public void setRate(String rate) { this.rate = rate; }

    public String getFormat() { return format; }
    public void setFormat(String format) { this.format = format; }

    public String getProps() { return props; }
    public void setProps(String props) { this.props = props; }

    public Integer getLimit() { return limit; }
    public void setLimit(Integer limit) { this.limit = limit; }
}
