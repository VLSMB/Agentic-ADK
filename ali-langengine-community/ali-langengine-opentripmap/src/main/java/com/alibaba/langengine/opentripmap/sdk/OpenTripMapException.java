package com.alibaba.langengine.opentripmap.sdk;

public class OpenTripMapException extends RuntimeException {

    public OpenTripMapException(String message) {
        super(message);
    }

    public OpenTripMapException(String message, Throwable cause) {
        super(message, cause);
    }
}
