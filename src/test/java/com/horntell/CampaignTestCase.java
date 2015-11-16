package com.horntell;

import com.horntell.exception.HorntellException;
import com.horntell.model.Campaign;
import com.horntell.model.Horn;
import com.horntell.net.HorntellResponse;
import junit.framework.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;


/**
 * Created by dave on 14/11/15.
 */


public class CampaignTestCase extends BaseTest{

    private static final Logger log = Logger.getLogger(CampaignTestCase.class.getName());

    private static String savedUid;



    @Test
    public final void runACampaignToSingleProfileSuccessTest() throws HorntellException, IOException {

        Map<String,Object> requestMap = new HashMap<>();
        requestMap.put("name","Dave");
        HorntellResponse response = Campaign.toProfile("500132", "56496ba09f17f6ba348b4567", requestMap);

        Assert.assertNotNull(response);
    }

    @Test
    public final void runACampaignToMultipleProfileSuccessTest() throws HorntellException, IOException {

        Map<String,Object> requestMap = new HashMap<>();
        requestMap.put("name","Dave");

        String[] profile_ids = {"500132","836408.4419760975"};
        HorntellResponse response = Campaign.toProfiles(profile_ids,"56496ba09f17f6ba348b4567", requestMap);

        Assert.assertNotNull(response);
    }

}
