package com.alibaba.langengine.opentripmap.sdk.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SimpleSuggestFeature {
    @JsonProperty("xid")
    private String xid; // Unique identifier of the object in OpenTripMap
    
    @JsonProperty("name")
    private String name; // The name of the object
    
    @JsonProperty("highlighted_name")
    private String highlightedName; // The name of the object with highlighted search term
    
    @JsonProperty("kinds")
    private String kinds; // Comma-separated list of categories
    
    @JsonProperty("osm")
    private String osm; // OpenStreetMap identifier of the object
    
    @JsonProperty("wikidata")
    private String wikidata; // Wikidata identifier of the object
    
    @JsonProperty("dist")
    private Double dist; // Distance in meters from selected point (for radius query)
    
    @JsonProperty("point")
    private Point point; // Point location of the object

    // Getters and Setters
    public String getXid() { return xid; }
    public void setXid(String xid) { this.xid = xid; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getHighlightedName() { return highlightedName; }
    public void setHighlightedName(String highlightedName) { this.highlightedName = highlightedName; }

    public String getKinds() { return kinds; }
    public void setKinds(String kinds) { this.kinds = kinds; }

    public String getOsm() { return osm; }
    public void setOsm(String osm) { this.osm = osm; }

    public String getWikidata() { return wikidata; }
    public void setWikidata(String wikidata) { this.wikidata = wikidata; }

    public Double getDist() { return dist; }
    public void setDist(Double dist) { this.dist = dist; }

    public Point getPoint() { return point; }
    public void setPoint(Point point) { this.point = point; }

    public static class Point {
        @JsonProperty("lon")
        private double lon; // Longitude
        
        @JsonProperty("lat")
        private double lat; // Latitude

        public double getLon() { return lon; }
        public void setLon(double lon) { this.lon = lon; }

        public double getLat() { return lat; }
        public void setLat(double lat) { this.lat = lat; }
    }
}
