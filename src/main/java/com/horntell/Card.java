package com.horntell;

import com.horntell.exception.*;
import com.horntell.exception.Exception;
import com.horntell.http.Request;
import com.horntell.http.Response;

import java.io.IOException;
import java.util.Map;

public class Card {

    private static final String DEFAULT_CANVAS = "default";
    private static final String CANVAS_KEY = "canvas";


    /**
     * Creates card for a profile
     *
     * @param uid  the uid
     * @param card the card
     * @return the response
     * @throws IOException             the io exception
     * @throws AuthenticationException the authentication exception
     * @throws ForbiddenException      the forbidden exception
     * @throws NotFoundException       the not found exception
     * @throws ServiceException        the service exception
     * @throws Exception               the exception
     */
    public static Response toProfile(String uid, Map<String, Object> card) throws IOException, AuthenticationException, ForbiddenException, NotFoundException, ServiceException, Exception {

        if (!card.containsKey(CANVAS_KEY)) {
            card.put(CANVAS_KEY, DEFAULT_CANVAS);
        }

        return Request._request("POST", "/profiles/" + uid + "/cards", card);
    }

    /**
     * Creates card for multiple profiles
     *
     * @param profileUids the profile uids
     * @param card        the card
     * @return the response
     * @throws IOException             the io exception
     * @throws AuthenticationException the authentication exception
     * @throws ForbiddenException      the forbidden exception
     * @throws NotFoundException       the not found exception
     * @throws ServiceException        the service exception
     * @throws Exception               the exception
     */
    public static Response toProfiles(String[] profileUids, Map<String, Object> card) throws IOException, AuthenticationException, ForbiddenException, NotFoundException, ServiceException, Exception {
        if (!card.containsKey(CANVAS_KEY)) {
            card.put(CANVAS_KEY, DEFAULT_CANVAS);
        }

        card.put("profile_uids", profileUids);
        return Request._request("POST", "/profiles/cards", card);
    }

    /**
     * Creates card for a channel
     *
     * @param uid  the uid
     * @param card the card
     * @return the response
     * @throws IOException             the io exception
     * @throws AuthenticationException the authentication exception
     * @throws ForbiddenException      the forbidden exception
     * @throws NotFoundException       the not found exception
     * @throws ServiceException        the service exception
     * @throws Exception               the exception
     */
    public static Response toChannel(String uid, Map<String, Object> card) throws IOException, AuthenticationException, ForbiddenException, NotFoundException, ServiceException, Exception {
        if (!card.containsKey(CANVAS_KEY)) {
            card.put(CANVAS_KEY, DEFAULT_CANVAS);
        }
        return Request._request("POST", "/channels/" + uid + "/cards", card);
    }

    /**
     * Creates card for multiple channels
     *
     * @param channelUids the channel uids
     * @param card        the card
     * @return the response
     * @throws IOException             the io exception
     * @throws AuthenticationException the authentication exception
     * @throws ForbiddenException      the forbidden exception
     * @throws NotFoundException       the not found exception
     * @throws ServiceException        the service exception
     * @throws Exception               the exception
     */
    public static Response toChannels(String[] channelUids, Map<String, Object> card) throws IOException, AuthenticationException, ForbiddenException, NotFoundException, ServiceException, Exception {

        if (!card.containsKey(CANVAS_KEY)) {
            card.put(CANVAS_KEY, DEFAULT_CANVAS);
        }

        card.put("channel_uids", channelUids);

        return Request._request("POST", "/channels/cards", card);
    }
}
