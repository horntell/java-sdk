/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.horntell.model;

import com.horntell.exception.*;
import com.horntell.net.HorntellRequest;
import com.horntell.net.HorntellResponse;

import java.io.IOException;
import java.util.Map;

/**
 * @author sahil
 */

public class Card {

    private static final String DEFAULT_CANVAS = "default";
    private static final String CANVAS_KEY = "canvas";


    public static HorntellResponse toProfile(String uid, Map<String, Object> card) throws IOException, AuthenticationException, ForbiddenException, NotFoundException, ServiceException, HorntellException {

        if (!card.containsKey(CANVAS_KEY)) {
            card.put(CANVAS_KEY, DEFAULT_CANVAS);
        }

        return HorntellRequest._request("POST", "/profiles/" + uid + "/cards", card);
    }

    public static HorntellResponse toProfiles(String[] profileUids, Map<String, Object> card) throws IOException, AuthenticationException, ForbiddenException, NotFoundException, ServiceException, HorntellException {
        if (!card.containsKey(CANVAS_KEY)) {
            card.put(CANVAS_KEY, DEFAULT_CANVAS);
        }

        card.put("profile_uids", profileUids);
        return HorntellRequest._request("POST", "/profiles/cards", card);
    }

    public static HorntellResponse toChannel(String uid, Map<String, Object> card) throws IOException, AuthenticationException, ForbiddenException, NotFoundException, ServiceException, HorntellException {
        if (!card.containsKey(CANVAS_KEY)) {
            card.put(CANVAS_KEY, DEFAULT_CANVAS);
        }
        return HorntellRequest._request("POST", "/channels/" + uid + "/cards", card);
    }

    public static HorntellResponse toChannels(String[] channelUids, Map<String, Object> card) throws IOException, AuthenticationException, ForbiddenException, NotFoundException, ServiceException, HorntellException {

        if (!card.containsKey(CANVAS_KEY)) {
            card.put(CANVAS_KEY, DEFAULT_CANVAS);
        }

        card.put("channel_uids", channelUids);

        return HorntellRequest._request("POST", "/channels/cards", card);
    }
}
