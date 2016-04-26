package com.horntell.model;

import org.json.JSONObject;

import javax.servlet.ServletRequest;

/**
 * Created by dave on 25/4/16.
 */
public class Event {

    private static final String HORNTELL_EVENT_KEY = "horntell_event";

    public static JSONObject fromWebhook(ServletRequest servletRequest) {

        String horntellEventObject = servletRequest.getParameter(HORNTELL_EVENT_KEY);

        if (horntellEventObject != null || !"".equals(horntellEventObject)) {
            return new JSONObject(horntellEventObject);
        }

        return null;

    }
}
