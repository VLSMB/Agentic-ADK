package com.alibaba.langengine.opentripmap.sdk.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlaceByXidRequest {
    @JsonProperty("lang")
    private String lang; // Two-letter language code (ISO639-1)
    
    @JsonProperty("xid")
    private String xid; // Unique identifier of the object in OpenTripMap

    // Getters and Setters
    public String getLang() { return lang; }
    public void setLang(String lang) { this.lang = lang; }

    public String getXid() { return xid; }
    public void setXid(String xid) { this.xid = xid; }
}
