package com.alibaba.langengine.opentripmap.sdk.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Places {
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
    
    @JsonProperty("rate")
    private String rate; // Rating of the object popularity
    
    @JsonProperty("image")
    private String image; // Image URL
    
    @JsonProperty("preview")
    private Preview preview; // Image thumbnail
    
    @JsonProperty("wikipedia")
    private String wikipedia; // Link to Wikipedia
    
    @JsonProperty("wikipedia_extracts")
    private WikipediaExtracts wikipediaExtracts; // Extracts of the wikipedia page
    
    @JsonProperty("voyage")
    private String voyage; // Link to WikiVoyage
    
    @JsonProperty("url")
    private String url; // Link to website
    
    @JsonProperty("otm")
    private String otm; // Link to object at opentripmap.com
    
    @JsonProperty("sources")
    private Sources sources; // Sources of information on object
    
    @JsonProperty("info")
    private Info info; // Extended object information (for some object categories)
    
    @JsonProperty("bbox")
    private Bbox bbox; // Minimum bounding box for the object geometry
    
    @JsonProperty("point")
    private Point point; // Point geographic coordinates of the object

    // Getters and Setters
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

    public String getRate() { return rate; }
    public void setRate(String rate) { this.rate = rate; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public Preview getPreview() { return preview; }
    public void setPreview(Preview preview) { this.preview = preview; }

    public String getWikipedia() { return wikipedia; }
    public void setWikipedia(String wikipedia) { this.wikipedia = wikipedia; }

    public WikipediaExtracts getWikipediaExtracts() { return wikipediaExtracts; }
    public void setWikipediaExtracts(WikipediaExtracts wikipediaExtracts) { this.wikipediaExtracts = wikipediaExtracts; }

    public String getVoyage() { return voyage; }
    public void setVoyage(String voyage) { this.voyage = voyage; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public String getOtm() { return otm; }
    public void setOtm(String otm) { this.otm = otm; }

    public Sources getSources() { return sources; }
    public void setSources(Sources sources) { this.sources = sources; }

    public Info getInfo() { return info; }
    public void setInfo(Info info) { this.info = info; }

    public Bbox getBbox() { return bbox; }
    public void setBbox(Bbox bbox) { this.bbox = bbox; }

    public Point getPoint() { return point; }
    public void setPoint(Point point) { this.point = point; }

    public static class Preview {
        @JsonProperty("source")
        private String source; // Image thumbnail URL
        
        @JsonProperty("width")
        private Integer width; // Thumbnail width in pixels
        
        @JsonProperty("height")
        private Integer height; // Thumbnail height in pixels

        public String getSource() { return source; }
        public void setSource(String source) { this.source = source; }

        public Integer getWidth() { return width; }
        public void setWidth(Integer width) { this.width = width; }

        public Integer getHeight() { return height; }
        public void setHeight(Integer height) { this.height = height; }
    }

    public static class WikipediaExtracts {
        @JsonProperty("title")
        private String title; // Page title in wikipedia
        
        @JsonProperty("text")
        private String text; // Plain-text extract
        
        @JsonProperty("html")
        private String html; // Limited HTML extract

        public String getTitle() { return title; }
        public void setTitle(String title) { this.title = title; }

        public String getText() { return text; }
        public void setText(String text) { this.text = text; }

        public String getHtml() { return html; }
        public void setHtml(String html) { this.html = html; }
    }

    public static class Sources {
        @JsonProperty("geometry")
        private String geometry; // Source of object geometry
        
        @JsonProperty("attributes")
        private List<String> attributes; // Sources of object attributes

        public String getGeometry() { return geometry; }
        public void setGeometry(String geometry) { this.geometry = geometry; }

        public List<String> getAttributes() { return attributes; }
        public void setAttributes(List<String> attributes) { this.attributes = attributes; }
    }

    public static class Info {
        @JsonProperty("src")
        private String src; // Source ID
        
        @JsonProperty("src_id")
        private Long srcId; // Object identifier in the source
        
        @JsonProperty("descr")
        private String descr; // Object description
        
        @JsonProperty("image")
        private String image; // Image identifier
        
        @JsonProperty("img_width")
        private Integer imgWidth; // Image width in pixels
        
        @JsonProperty("img_height")
        private Integer imgHeight; // Image height in pixels

        public String getSrc() { return src; }
        public void setSrc(String src) { this.src = src; }

        public Long getSrcId() { return srcId; }
        public void setSrcId(Long srcId) { this.srcId = srcId; }

        public String getDescr() { return descr; }
        public void setDescr(String descr) { this.descr = descr; }

        public String getImage() { return image; }
        public void setImage(String image) { this.image = image; }

        public Integer getImgWidth() { return imgWidth; }
        public void setImgWidth(Integer imgWidth) { this.imgWidth = imgWidth; }

        public Integer getImgHeight() { return imgHeight; }
        public void setImgHeight(Integer imgHeight) { this.imgHeight = imgHeight; }
    }

    public static class Bbox {
        @JsonProperty("lon_min")
        private double lonMin; // Minimum longitude
        
        @JsonProperty("lon_max")
        private double lonMax; // Maximum longitude
        
        @JsonProperty("lat_min")
        private double latMin; // Minimum latitude
        
        @JsonProperty("lat_max")
        private double latMax; // Maximum latitude

        public double getLonMin() { return lonMin; }
        public void setLonMin(double lonMin) { this.lonMin = lonMin; }

        public double getLonMax() { return lonMax; }
        public void setLonMax(double lonMax) { this.lonMax = lonMax; }

        public double getLatMin() { return latMin; }
        public void setLatMin(double latMin) { this.latMin = latMin; }

        public double getLatMax() { return latMax; }
        public void setLatMax(double latMax) { this.latMax = latMax; }
    }

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
