package com.alibaba.langengine.opentripmap.sdk.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FeatureCollection {
    @JsonProperty("type")
    private String type; // FeatureCollection type
    
    @JsonProperty("features")
    private List<Feature> features; // List of features

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public List<Feature> getFeatures() { return features; }
    public void setFeatures(List<Feature> features) { this.features = features; }

    public static class Feature {
        @JsonProperty("type")
        private String type; // Feature type
        
        @JsonProperty("id")
        private String id; // Feature ID
        
        @JsonProperty("geometry")
        private Geometry geometry; // Geometry object
        
        @JsonProperty("properties")
        private Properties properties; // Properties object

        public String getType() { return type; }
        public void setType(String type) { this.type = type; }

        public String getId() { return id; }
        public void setId(String id) { this.id = id; }

        public Geometry getGeometry() { return geometry; }
        public void setGeometry(Geometry geometry) { this.geometry = geometry; }

        public Properties getProperties() { return properties; }
        public void setProperties(Properties properties) { this.properties = properties; }

        public static class Properties {
            @JsonProperty("xid")
            private String xid; // Unique identifier of the object in OpenTripMap
            
            @JsonProperty("name")
            private String name; // The name of the object
            
            @JsonProperty("kinds")
            private String kinds; // Comma-separated list of categories
            
            @JsonProperty("osm")
            private String osm; // OpenStreetMap identifier of the object
            
            @JsonProperty("wikidata")
            private String wikidata; // Wikidata identifier of the object

            public String getXid() { return xid; }
            public void setXid(String xid) { this.xid = xid; }

            public String getName() { return name; }
            public void setName(String name) { this.name = name; }

            public String getKinds() { return kinds; }
            public void setKinds(String kinds) { this.kinds = kinds; }

            public String getOsm() { return osm; }
            public void setOsm(String osm) { this.osm = osm; }

            public String getWikidata() { return wikidata; }
            public void setWikidata(String wikidata) { this.wikidata = wikidata; }
        }
    }

    public static class Geometry {
        @JsonProperty("type")
        private String type; // Geometry type (Point, etc.)
        
        @JsonProperty("coordinates")
        private List<List<Double>> coordinates; // Coordinate array

        public String getType() { return type; }
        public void setType(String type) { this.type = type; }

        public List<List<Double>> getCoordinates() { return coordinates; }
        public void setCoordinates(List<List<Double>> coordinates) { this.coordinates = coordinates; }
    }
}
