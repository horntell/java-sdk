/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.horntell.model;

import com.horntell.exception.HorntellException;
import com.horntell.exception.AuthenticationException;
import com.horntell.exception.ForbiddenException;
import com.horntell.exception.InvalidRequestException;
import com.horntell.exception.NotFoundException;
import com.horntell.exception.ServiceException;
import com.horntell.net.HorntellResponse;
import java.util.Map;

import com.horntell.net.HorntellRequest;
import java.io.IOException;

/**
 *
 * @author sahil
 */
public class Profile {

    public static HorntellResponse  find(String uid) throws IOException, InvalidRequestException, AuthenticationException, ForbiddenException, NotFoundException, ServiceException, HorntellException {
	   return HorntellRequest._request("GET", "/profiles/" + uid, null);
    }
    
    public static HorntellResponse create(Map<String, Object> profile) throws IOException, AuthenticationException, ForbiddenException, NotFoundException, ServiceException, HorntellException {
	   return HorntellRequest._request("POST", "/profiles", profile);
    }
    
    public static HorntellResponse update(String uid, Map<String, Object> profile) throws IOException, AuthenticationException, ForbiddenException, NotFoundException, ServiceException, HorntellException {
	   return HorntellRequest._request("PUT", "/profiles/" + uid, profile);
    }
    
    public static HorntellResponse delete(String uid) throws IOException, AuthenticationException, ForbiddenException, NotFoundException, ServiceException, HorntellException {
	   return HorntellRequest._request("DELETE", "/profiles/" + uid, null);
    }

}
