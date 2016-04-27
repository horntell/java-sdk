package com.horntell;

import com.horntell.exception.Exception;
import com.horntell.exception.AuthenticationException;
import com.horntell.exception.ForbiddenException;
import com.horntell.exception.InvalidRequestException;
import com.horntell.exception.NotFoundException;
import com.horntell.exception.ServiceException;
import com.horntell.http.Response;
import java.util.Map;

import com.horntell.http.Request;

import java.io.IOException;

/**
 * The type Profile.
 */
public class Profile {

    /**
     * Finds a profile by uid
     *
     * @param uid the uid
     * @return the response
     * @throws IOException             the io exception
     * @throws InvalidRequestException the invalid request exception
     * @throws AuthenticationException the authentication exception
     * @throws ForbiddenException      the forbidden exception
     * @throws NotFoundException       the not found exception
     * @throws ServiceException        the service exception
     * @throws Exception               the exception
     */
    public static Response find(String uid) throws IOException, InvalidRequestException, AuthenticationException, ForbiddenException, NotFoundException, ServiceException, Exception {
	   return Request._request("GET", "/profiles/" + uid, null);
    }

    /**
     * Creates a profile
     *
     * @param profile the profile
     * @return the response
     * @throws IOException             the io exception
     * @throws AuthenticationException the authentication exception
     * @throws ForbiddenException      the forbidden exception
     * @throws NotFoundException       the not found exception
     * @throws ServiceException        the service exception
     * @throws Exception               the exception
     */
    public static Response create(Map<String, Object> profile) throws IOException, AuthenticationException, ForbiddenException, NotFoundException, ServiceException, Exception {
	   return Request._request("POST", "/profiles", profile);
    }

    /**
     * Updates a profile
     *
     * @param uid     the uid
     * @param profile the profile
     * @return the response
     * @throws IOException             the io exception
     * @throws AuthenticationException the authentication exception
     * @throws ForbiddenException      the forbidden exception
     * @throws NotFoundException       the not found exception
     * @throws ServiceException        the service exception
     * @throws Exception               the exception
     */
    public static Response update(String uid, Map<String, Object> profile) throws IOException, AuthenticationException, ForbiddenException, NotFoundException, ServiceException, Exception {
	   return Request._request("PUT", "/profiles/" + uid, profile);
    }

    /**
     * Deletes the profile
     *
     * @param uid the uid
     * @return the response
     * @throws IOException             the io exception
     * @throws AuthenticationException the authentication exception
     * @throws ForbiddenException      the forbidden exception
     * @throws NotFoundException       the not found exception
     * @throws ServiceException        the service exception
     * @throws Exception               the exception
     */
    public static Response delete(String uid) throws IOException, AuthenticationException, ForbiddenException, NotFoundException, ServiceException, Exception {
	   return Request._request("DELETE", "/profiles/" + uid, null);
    }

}
