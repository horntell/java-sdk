package com.horntell;

import org.json.JSONObject;

import javax.servlet.ServletRequest;

/**
 * The type Event.
 */
public class Event {

    private static final String EVENT_KEY = "horntell_event";

    /**
     * To get the JsonObject from the request object
     *
     * @param servletRequest The ServletRequest object received on hitting the server for webhook
     * @return the json object
     */
    public static JSONObject fromWebhook(ServletRequest servletRequest) {

        String event = servletRequest.getParameter(EVENT_KEY);

        if (event != null || !"".equals(event)) {
            return new JSONObject(event);
        }

        return null;

    }
}
