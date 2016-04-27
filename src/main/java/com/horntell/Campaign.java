package com.horntell;

import com.horntell.exception.*;
import com.horntell.exception.Exception;
import com.horntell.http.Request;
import com.horntell.http.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * The type Campaign.
 */
public class Campaign {

    /**
     * Triggers campaign for a profile
     *
     * @param uid        the uid
     * @param campaignId the campaign id
     * @param meta       the meta
     * @return the response
     * @throws IOException             the io exception
     * @throws AuthenticationException the authentication exception
     * @throws ForbiddenException      the forbidden exception
     * @throws NotFoundException       the not found exception
     * @throws ServiceException        the service exception
     * @throws Exception               the exception
     */
    public static Response toProfile(String uid, String campaignId, Map<String, Object> meta) throws IOException, AuthenticationException, ForbiddenException, NotFoundException, ServiceException, Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("meta", meta);

        return Request._request("POST", "/profiles/" + uid + "/campaigns/" + campaignId, params);
    }

    /**
     * Triggers campaign for multiple profiles
     *
     * @param profileUids the profile uids
     * @param campaignId  the campaign id
     * @param meta        the meta
     * @return the response
     * @throws IOException             the io exception
     * @throws InvalidRequestException the invalid request exception
     * @throws AuthenticationException the authentication exception
     * @throws ForbiddenException      the forbidden exception
     * @throws NotFoundException       the not found exception
     * @throws ServiceException        the service exception
     * @throws Exception               the exception
     */
    public static Response toProfiles(String[] profileUids, String campaignId, Map<String, Object> meta) throws IOException, InvalidRequestException, AuthenticationException, ForbiddenException, NotFoundException, ServiceException, Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("meta", meta);
        params.put("profile_uids", profileUids);

        return Request._request("POST", "/profiles/campaigns/" + campaignId, params);
    }

    /**
     * Triggers campaign for a channel
     *
     * @param uid        the uid
     * @param campaignId the campaign id
     * @param meta       the meta
     * @return the response
     * @throws IOException             the io exception
     * @throws AuthenticationException the authentication exception
     * @throws ForbiddenException      the forbidden exception
     * @throws NotFoundException       the not found exception
     * @throws ServiceException        the service exception
     * @throws Exception               the exception
     */
    public static Response toChannel(String uid, String campaignId, Map<String, Object> meta) throws IOException, AuthenticationException, ForbiddenException, NotFoundException, ServiceException, Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("meta", meta);

        return Request._request("POST", "/channels/" + uid + "/campaigns/" + campaignId, params);
    }

    /**
     * Triggers campaign for multiple channels
     *
     * @param channelUids the channel uids
     * @param campaignId  the campaign id
     * @param meta        the meta
     * @return the response
     * @throws IOException             the io exception
     * @throws InvalidRequestException the invalid request exception
     * @throws AuthenticationException the authentication exception
     * @throws ForbiddenException      the forbidden exception
     * @throws NotFoundException       the not found exception
     * @throws ServiceException        the service exception
     * @throws Exception               the exception
     */
    public static Response toChannels(String[] channelUids, String campaignId, Map<String, Object> meta) throws IOException, InvalidRequestException, AuthenticationException, ForbiddenException, NotFoundException, ServiceException, Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("meta", meta);
        params.put("channel_uids", channelUids);

        return Request._request("POST", "/channels/campaigns/" + campaignId, params);
    }
}
