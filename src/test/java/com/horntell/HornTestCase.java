package com.horntell;

import com.horntell.exception.HorntellException;
import com.horntell.model.Horn;
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


public class HornTestCase extends BaseTest{

    private static final Logger log = Logger.getLogger(HornTestCase.class.getName());

    private static String savedUid;



    @Test
    public final void createHornSuccessTest() throws HorntellException, IOException {

        Map<String,Object> requestMap = new HashMap<>();
        requestMap.put("format","link");
        requestMap.put("type","info");
        requestMap.put("bubble",true);
        requestMap.put("text","Welcome campaign was fired.");
        requestMap.put("html","<strong>Welcome</strong> campaign was fired.");
        requestMap.put("link","http://app.example.com/campaigns/welcome");
        requestMap.put("new_window",true);
        HorntellResponse response = Horn.toProfile("500132", requestMap);

        Assert.assertNotNull(response);
    }

}
