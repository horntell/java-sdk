package com.horntell;

import com.horntell.exception.Exception;
import com.horntell.exception.AuthenticationException;
import com.horntell.exception.ForbiddenException;
import com.horntell.exception.NotFoundException;
import com.horntell.exception.ServiceException;
import java.util.Map;

import com.horntell.http.Request;
import com.horntell.http.Response;

import java.io.IOException;

/**
 * The type Horn.
 */
public class Horn {

    /**
     * Creates horn for a profile
     *
     * @param uid  the uid
     * @param horn the horn
     * @return the response
     * @throws IOException             the io exception
     * @throws AuthenticationException the authentication exception
     * @throws ForbiddenException      the forbidden exception
     * @throws NotFoundException       the not found exception
     * @throws ServiceException        the service exception
     * @throws Exception               the exception
     */
    public static Response toProfile(String uid, Map<String, Object> horn) throws IOException, AuthenticationException, ForbiddenException, NotFoundException, ServiceException, Exception {
		return Request._request("POST", "/profiles/" + uid + "/horns", horn);
    }

    /**
     * Creates horn for multiple profiles
     *
     * @param profileUids the profile uids
     * @param horn        the horn
     * @return the response
     * @throws IOException             the io exception
     * @throws AuthenticationException the authentication exception
     * @throws ForbiddenException      the forbidden exception
     * @throws NotFoundException       the not found exception
     * @throws ServiceException        the service exception
     * @throws Exception               the exception
     */
    public static Response toProfiles(String[] profileUids, Map<String, Object> horn) throws IOException, AuthenticationException, ForbiddenException, NotFoundException, ServiceException, Exception {
        horn.put("profile_uids", profileUids);
		return Request._request("POST", "/profiles/horns" , horn);
    }

    /**
     * Creates horn for a single channel
     *
     * @param uid  the uid
     * @param horn the horn
     * @return the response
     * @throws IOException             the io exception
     * @throws AuthenticationException the authentication exception
     * @throws ForbiddenException      the forbidden exception
     * @throws NotFoundException       the not found exception
     * @throws ServiceException        the service exception
     * @throws Exception               the exception
     */
    public static Response toChannel(String uid, Map<String, Object> horn) throws IOException, AuthenticationException, ForbiddenException, NotFoundException, ServiceException, Exception {
		return Request._request("POST", "/channels/" + uid + "/horns", horn);
    }

    /**
     * Creates horn for multiple channels
     *
     * @param channelUids the channel uids
     * @param horn        the horn
     * @return the response
     * @throws IOException             the io exception
     * @throws AuthenticationException the authentication exception
     * @throws ForbiddenException      the forbidden exception
     * @throws NotFoundException       the not found exception
     * @throws ServiceException        the service exception
     * @throws Exception               the exception
     */
    public static Response toChannels(String[] channelUids, Map<String, Object> horn) throws IOException, AuthenticationException, ForbiddenException, NotFoundException, ServiceException, Exception {
        horn.put("channel_uids", channelUids);
		return Request._request("POST", "/channels/horns" , horn);
    }
}
