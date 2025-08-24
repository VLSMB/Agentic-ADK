package com.alibaba.langengine.opentripmap;

import com.alibaba.langengine.core.util.WorkPropertiesUtils;

import static com.alibaba.langengine.opentripmap.sdk.OpenTripMapConstant.OPEN_TRIP_MAP_BASE_URL;

public class OpenTripMapConfiguration {

    /**
     * Open Trip Map API key, retrieved from work properties
     */
    public static String OPEN_TRIP_MAP_API_KEY = WorkPropertiesUtils.get("open_trip_map_api_key");

    /**
     * Open Trip Map API base URL, defaults to the constant BASE_URL if not configured
     */
    public static String OPEN_TRIP_MAP_API_URL = WorkPropertiesUtils.get("open_trip_map_api_url", OPEN_TRIP_MAP_BASE_URL);

}
