package com.horntell;

import com.horntell.exception.ForbiddenException;
import com.horntell.exception.HorntellException;
import com.horntell.exception.ServiceException;
import com.horntell.model.Profile;
import com.horntell.net.HorntellResponse;
import junit.framework.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Created by dave on 14/11/15.
 */


public class ProfileTestCase extends BaseTest{

    private static final Logger log = Logger.getLogger(ProfileTestCase.class.getName());

    private static String savedUid;



    @Test
    public final void createProfileSuccessTest() throws HorntellException, IOException {

        Map<String,Object> requestMap = new HashMap<>();
        requestMap.put("app_id","123456");
        requestMap.put("email","abcd@xyz.com");
        requestMap.put("first_name","Mohit");
        requestMap.put("gender","male");
        requestMap.put("uid", String.valueOf(((Double) (Math.random() * 1000000)).intValue()));

        HorntellResponse response = Profile.create(requestMap);

        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getResponseMap().get("data"));
        log.log(Level.INFO, "Saved uid is : "+savedUid);
        savedUid = (String)((Map) response.getResponseMap().get("data")).get("uid");
    }

    @Test
    public final void updateProfileSuccessTest() throws IOException, HorntellException {
        Map<String,Object> requestMap = new HashMap<>();
        requestMap.put("app_id","123456");
        requestMap.put("email","abcde@xyz.com");
        requestMap.put("first_name","Mohit");
        requestMap.put("gender","male");
        requestMap.put("uid", String.valueOf(((Double) (Math.random() * 1000000)).intValue()));

        HorntellResponse response = Profile.update(savedUid, requestMap);

        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getResponseMap().get("data"));
        log.log(Level.INFO, "Updated uid is : " + savedUid);
        savedUid = (String)((Map) response.getResponseMap().get("data")).get("uid");
    }

    @Test
    public final void getProfileSuccessTest() throws IOException, HorntellException {

        HorntellResponse response = Profile.find(savedUid);

        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getResponseMap().get("data"));
        log.log(Level.INFO, "getting uid is : "+savedUid);
        savedUid = (String)((Map) response.getResponseMap().get("data")).get("uid");
    }

    @Test
    public final void deleteProfileSuccessTest() throws IOException, HorntellException {

        HorntellResponse response = Profile.delete(savedUid);

        Assert.assertNotNull(response.getStatusCode());
    }

}
