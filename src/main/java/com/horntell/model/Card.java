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
public class Card {
    
    public static HorntellResponse toProfile(String uid, Map<String, Object> card) throws IOException, AuthenticationException, ForbiddenException, NotFoundException, ServiceException, HorntellException {
		return HorntellRequest._request("POST", "/profiles/" + uid + "/cards", card);
    }
     
    public static HorntellResponse toProfiles(String[] profileUids, Map<String, Object> card) throws IOException, AuthenticationException, ForbiddenException, NotFoundException, ServiceException, HorntellException {
        card.put("profile_uids", profileUids);
		return HorntellRequest._request("POST", "/profiles/horns" , card);
    }

    public static HorntellResponse toChannel(String uid, Map<String, Object> card) throws IOException, AuthenticationException, ForbiddenException, NotFoundException, ServiceException, HorntellException {
		return HorntellRequest._request("POST", "/channels/" + uid + "/horns", card);
    }
     
    public static HorntellResponse toChannels(String[] channelUids, Map<String, Object> card) throws IOException, AuthenticationException, ForbiddenException, NotFoundException, ServiceException, HorntellException {
        card.put("channel_uids", channelUids);
		return HorntellRequest._request("POST", "/channels/horns" , card);
    }
}
