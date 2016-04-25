/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.horntell.model;

import com.horntell.exception.HorntellException;
import com.horntell.exception.AuthenticationException;
import com.horntell.exception.ForbiddenException;
import com.horntell.exception.NotFoundException;
import com.horntell.exception.ServiceException;
import java.util.Map;

import com.horntell.net.HorntellRequest;
import com.horntell.net.HorntellResponse;
import java.io.IOException;

/**
 *
 * @author sahil
 */
public class Horn {
    
    public static HorntellResponse toProfile(String uid, Map<String, Object> horn) throws IOException, AuthenticationException, ForbiddenException, NotFoundException, ServiceException, HorntellException {
		return HorntellRequest._request("POST", "/profiles/" + uid + "/horns", horn);
    }
     
    public static HorntellResponse toProfiles(String[] profileUids, Map<String, Object> horn) throws IOException, AuthenticationException, ForbiddenException, NotFoundException, ServiceException, HorntellException {
        horn.put("profile_uids", profileUids);
		return HorntellRequest._request("POST", "/profiles/horns" , horn);
    }

    public static HorntellResponse toChannel(String uid, Map<String, Object> horn) throws IOException, AuthenticationException, ForbiddenException, NotFoundException, ServiceException, HorntellException {
		return HorntellRequest._request("POST", "/channels/" + uid + "/horns", horn);
    }
     
    public static HorntellResponse toChannels(String[] channelUids, Map<String, Object> horn) throws IOException, AuthenticationException, ForbiddenException, NotFoundException, ServiceException, HorntellException {
        horn.put("channel_uids", channelUids);
		return HorntellRequest._request("POST", "/channels/horns" , horn);
    }
}
