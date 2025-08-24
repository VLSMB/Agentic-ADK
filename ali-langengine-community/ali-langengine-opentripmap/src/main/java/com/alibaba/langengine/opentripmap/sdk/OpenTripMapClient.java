
package com.alibaba.langengine.opentripmap.sdk;

import com.alibaba.langengine.opentripmap.sdk.request.GeonameRequest;
import com.alibaba.langengine.opentripmap.sdk.request.ListOfPlacesByLocationRequest;
import com.alibaba.langengine.opentripmap.sdk.request.ListOfPlacesByRadiusRequest;
import com.alibaba.langengine.opentripmap.sdk.request.ListOfPlacesBySuggestionsRequest;
import com.alibaba.langengine.opentripmap.sdk.request.PlaceByXidRequest;
import com.alibaba.langengine.opentripmap.sdk.response.Geoname;
import com.alibaba.langengine.opentripmap.sdk.response.Places;
import com.alibaba.langengine.opentripmap.sdk.response.SimpleFeature;
import com.alibaba.langengine.opentripmap.sdk.response.SimpleSuggestFeature;
import okhttp3.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.IOException;
import java.util.List;

import static com.alibaba.langengine.opentripmap.OpenTripMapConfiguration.OPEN_TRIP_MAP_API_KEY;
import static com.alibaba.langengine.opentripmap.sdk.OpenTripMapConstant.OPEN_TRIP_MAP_BASE_URL;

public class OpenTripMapClient {

    private final OkHttpClient client;

    private final ObjectMapper objectMapper;

    private final String apiKey;

    public OpenTripMapClient(String apiKey) {
        this.apiKey = apiKey;
        this.client = new OkHttpClient();
        this.objectMapper = new ObjectMapper();
    }

    public OpenTripMapClient() {
        this(OPEN_TRIP_MAP_API_KEY);
    }

    /**
     * Returns geographic coordinates for the given placename
     * @param request GeonameRequest object with request parameters
     * @return Geoname object with geographic coordinates
     * @throws OpenTripMapException if request fails
     */
    public Geoname getGeoname(GeonameRequest request) throws OpenTripMapException {
        HttpUrl.Builder urlBuilder = HttpUrl.parse(OPEN_TRIP_MAP_BASE_URL + "/" + request.getLang() + "/places/geoname").newBuilder();
        urlBuilder.addQueryParameter("name", request.getName());
        if (request.getCountry() != null) {
            urlBuilder.addQueryParameter("country", request.getCountry());
        }
        urlBuilder.addQueryParameter("apikey", apiKey);

        Request httpRequest = new Request.Builder()
                .url(urlBuilder.build())
                .build();

        try (Response response = client.newCall(httpRequest).execute()) {
            if (!response.isSuccessful()) {
                throw new OpenTripMapException("Unexpected code " + response);
            }
            return objectMapper.readValue(response.body().charStream(), Geoname.class);
        } catch (IOException e) {
            throw new OpenTripMapException("Error processing geoname request", e);
        }
    }

    /**
     * Returns all objects in the given bounding box
     * @param request ListOfPlacesByLocationRequest object with request parameters
     * @return List of SimpleFeature objects
     * @throws OpenTripMapException if request fails
     */
    public List<SimpleFeature> getListOfPlacesByLocation(ListOfPlacesByLocationRequest request) throws OpenTripMapException {
        HttpUrl.Builder urlBuilder = HttpUrl.parse(OPEN_TRIP_MAP_BASE_URL + "/" + request.getLang() + "/places/bbox").newBuilder();
        urlBuilder.addQueryParameter("lon_min", String.valueOf(request.getLonMin()));
        urlBuilder.addQueryParameter("lon_max", String.valueOf(request.getLonMax()));
        urlBuilder.addQueryParameter("lat_min", String.valueOf(request.getLatMin()));
        urlBuilder.addQueryParameter("lat_max", String.valueOf(request.getLatMax()));

        if (request.getSrcGeom() != null) urlBuilder.addQueryParameter("src_geom", request.getSrcGeom());
        if (request.getSrcAttr() != null) urlBuilder.addQueryParameter("src_attr", request.getSrcAttr());
        if (request.getKinds() != null) urlBuilder.addQueryParameter("kinds", request.getKinds());
        if (request.getName() != null) urlBuilder.addQueryParameter("name", request.getName());
        if (request.getRate() != null) urlBuilder.addQueryParameter("rate", request.getRate());
        if (request.getFormat() != null) urlBuilder.addQueryParameter("format", request.getFormat());
        if (request.getLimit() != null) urlBuilder.addQueryParameter("limit", String.valueOf(request.getLimit()));

        urlBuilder.addQueryParameter("apikey", apiKey);

        Request httpRequest = new Request.Builder()
                .url(urlBuilder.build())
                .build();

        try (Response response = client.newCall(httpRequest).execute()) {
            if (!response.isSuccessful()) {
                throw new OpenTripMapException("Unexpected code " + response);
            }
            return objectMapper.readValue(response.body().charStream(),
                    new TypeReference<List<SimpleFeature>>() {});
        } catch (IOException e) {
            throw new OpenTripMapException("Error processing list of places by location request", e);
        }
    }

    /**
     * Returns objects closest to the selected point
     * @param request ListOfPlacesByRadiusRequest object with request parameters
     * @return List of SimpleFeature objects
     * @throws OpenTripMapException if request fails
     */
    public List<SimpleFeature> getListOfPlacesByRadius(ListOfPlacesByRadiusRequest request) throws OpenTripMapException {
        HttpUrl.Builder urlBuilder = HttpUrl.parse(OPEN_TRIP_MAP_BASE_URL + "/" + request.getLang() + "/places/radius").newBuilder();
        urlBuilder.addQueryParameter("radius", String.valueOf(request.getRadius()));
        urlBuilder.addQueryParameter("lon", String.valueOf(request.getLon()));
        urlBuilder.addQueryParameter("lat", String.valueOf(request.getLat()));

        if (request.getSrcGeom() != null) urlBuilder.addQueryParameter("src_geom", request.getSrcGeom());
        if (request.getSrcAttr() != null) urlBuilder.addQueryParameter("src_attr", request.getSrcAttr());
        if (request.getKinds() != null) urlBuilder.addQueryParameter("kinds", request.getKinds());
        if (request.getName() != null) urlBuilder.addQueryParameter("name", request.getName());
        if (request.getRate() != null) urlBuilder.addQueryParameter("rate", request.getRate());
        if (request.getFormat() != null) urlBuilder.addQueryParameter("format", request.getFormat());
        if (request.getLimit() != null) urlBuilder.addQueryParameter("limit", String.valueOf(request.getLimit()));

        urlBuilder.addQueryParameter("apikey", apiKey);

        Request httpRequest = new Request.Builder()
                .url(urlBuilder.build())
                .build();

        try (Response response = client.newCall(httpRequest).execute()) {
            if (!response.isSuccessful()) {
                throw new OpenTripMapException("Unexpected code " + response);
            }
            return objectMapper.readValue(response.body().charStream(),
                    new TypeReference<List<SimpleFeature>>() {});
        } catch (IOException e) {
            throw new OpenTripMapException("Error processing list of places by radius request", e);
        }
    }

    /**
     * Returns detailed information about the object
     * @param request PlaceByXidRequest object with request parameters
     * @return Places object with detailed information
     * @throws OpenTripMapException if request fails
     */
    public Places getPlaceByXid(PlaceByXidRequest request) throws OpenTripMapException {
        HttpUrl.Builder urlBuilder = HttpUrl.parse(OPEN_TRIP_MAP_BASE_URL + "/" + request.getLang() + "/places/xid/" + request.getXid()).newBuilder();
        urlBuilder.addQueryParameter("apikey", apiKey);

        Request httpRequest = new Request.Builder()
                .url(urlBuilder.build())
                .build();

        try (Response response = client.newCall(httpRequest).execute()) {
            if (!response.isSuccessful()) {
                throw new OpenTripMapException("Unexpected code " + response);
            }
            return objectMapper.readValue(response.body().charStream(), Places.class);
        } catch (IOException e) {
            throw new OpenTripMapException("Error processing place by xid request", e);
        }
    }

    /**
     * Returns suggestions for search term closest to the selected point
     * @param request ListOfPlacesBySuggestionsRequest object with request parameters
     * @return List of SimpleSuggestFeature objects
     * @throws OpenTripMapException if request fails
     */
    public List<SimpleSuggestFeature> getListOfPlacesBySuggestions(ListOfPlacesBySuggestionsRequest request) throws OpenTripMapException {
        HttpUrl.Builder urlBuilder = HttpUrl.parse(OPEN_TRIP_MAP_BASE_URL + "/" + request.getLang() + "/places/autosuggest").newBuilder();
        urlBuilder.addQueryParameter("name", request.getName());
        urlBuilder.addQueryParameter("radius", String.valueOf(request.getRadius()));
        urlBuilder.addQueryParameter("lon", String.valueOf(request.getLon()));
        urlBuilder.addQueryParameter("lat", String.valueOf(request.getLat()));

        if (request.getSrcGeom() != null) urlBuilder.addQueryParameter("src_geom", request.getSrcGeom());
        if (request.getSrcAttr() != null) urlBuilder.addQueryParameter("src_attr", request.getSrcAttr());
        if (request.getKinds() != null) urlBuilder.addQueryParameter("kinds", request.getKinds());
        if (request.getRate() != null) urlBuilder.addQueryParameter("rate", request.getRate());
        if (request.getFormat() != null) urlBuilder.addQueryParameter("format", request.getFormat());
        if (request.getProps() != null) urlBuilder.addQueryParameter("props", request.getProps());
        if (request.getLimit() != null) urlBuilder.addQueryParameter("limit", String.valueOf(request.getLimit()));

        urlBuilder.addQueryParameter("apikey", apiKey);

        Request httpRequest = new Request.Builder()
                .url(urlBuilder.build())
                .build();

        try (Response response = client.newCall(httpRequest).execute()) {
            if (!response.isSuccessful()) {
                throw new OpenTripMapException("Unexpected code " + response);
            }
            return objectMapper.readValue(response.body().charStream(),
                    new TypeReference<List<SimpleSuggestFeature>>() {});
        } catch (IOException e) {
            throw new OpenTripMapException("Error processing list of places by suggestions request", e);
        }
    }
}
