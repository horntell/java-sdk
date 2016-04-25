/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.horntell.model;

/**
 *
 * @author sahil
 */
import com.horntell.exception.HorntellException;
import com.horntell.exception.AuthenticationException;
import com.horntell.exception.ForbiddenException;
import com.horntell.exception.InvalidRequestException;
import com.horntell.exception.NotFoundException;
import com.horntell.exception.ServiceException;
import java.util.Map;

import com.horntell.net.HorntellRequest;
import com.horntell.net.HorntellResponse;
import java.io.IOException;
import java.util.HashMap;

public class Campaign {    
     
    public static HorntellResponse toProfile(String uid, String campaignId, Map<String, Object> meta) throws IOException, AuthenticationException, ForbiddenException, NotFoundException, ServiceException, HorntellException {
    	Map<String, Object> params = new HashMap<String, Object>();
        params.put("meta", meta);

        return HorntellRequest._request("POST", "/profiles/" + uid + "/campaigns/" + campaignId, params);
    }
     
    public static HorntellResponse toProfiles(String[] profileUids, String campaignId, Map<String, Object> meta) throws IOException, InvalidRequestException, AuthenticationException, ForbiddenException, NotFoundException, ServiceException, HorntellException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("meta", meta);
        params.put("profile_uids", profileUids);
        
        return HorntellRequest._request("POST", "/profiles/campaigns/" + campaignId, params);
    }

    public static HorntellResponse toChannel(String uid, String campaignId, Map<String, Object> meta) throws IOException, AuthenticationException, ForbiddenException, NotFoundException, ServiceException, HorntellException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("meta", meta);

        return HorntellRequest._request("POST", "/channels/" + uid + "/campaigns/" + campaignId, params);
    }
     
    public static HorntellResponse toChannels(String[] channelUids, String campaignId, Map<String, Object> meta) throws IOException, InvalidRequestException, AuthenticationException, ForbiddenException, NotFoundException, ServiceException, HorntellException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("meta", meta);
        params.put("channel_uids", channelUids);
        
        return HorntellRequest._request("POST", "/channels/campaigns/" + campaignId, params);
    }
}
