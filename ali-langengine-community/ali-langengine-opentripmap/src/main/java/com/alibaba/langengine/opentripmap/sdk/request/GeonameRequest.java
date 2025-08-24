package com.alibaba.langengine.opentripmap.sdk.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GeonameRequest {
    @JsonProperty("lang")
    private String lang; // Two-letter language code (ISO639-1)
    
    @JsonProperty("name")
    private String name; // Placename
    
    @JsonProperty("country")
    private String country; // Two-letter country code, ISO-3166 (optional)

    // Getters and Setters
    public String getLang() { return lang; }
    public void setLang(String lang) { this.lang = lang; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }
}
