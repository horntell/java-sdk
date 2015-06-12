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
     public static HorntellResponse toProfile(String uid, Map<String, Object> params) throws IOException, AuthenticationException, ForbiddenException, NotFoundException, ServiceException, HorntellException {
	return HorntellRequest._request("POST", "/profiles/" +uid+ "/horns", params);
    }
     
    public static HorntellResponse toProfiles(String[] profiles, Map<String, Object> params) throws IOException, AuthenticationException, ForbiddenException, NotFoundException, ServiceException, HorntellException {
        params.put("profile_uids", profiles);
	return HorntellRequest._request("POST", "/profiles/horns" , params);
    }
}
