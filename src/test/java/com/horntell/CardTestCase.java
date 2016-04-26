package com.horntell;

import com.horntell.exception.HorntellException;
import com.horntell.model.App;
import com.horntell.model.Card;
import com.horntell.model.Horn;
import com.horntell.net.HorntellResponse;
import junit.framework.Assert;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;


/**
 * Created by dave on 14/11/15.
 */


public class CardTestCase extends BaseTest{

    private static final Logger log = Logger.getLogger(CardTestCase.class.getName());

    private static String savedUid;

//    Credentials for myntra

    private static final String key = "WKG5YmQAOlPHhq1kkzWPl4qoUBWhqPpyDocCavwo";
    private static final String secret = "D8cBpF0OixIUXHmKGzfGwHvzaVx2ossATtMjhJMi";



    @org.junit.Test
    public final void createCardSuccessTest() throws HorntellException, IOException {

        App.init(key,secret);
        App.setBase("http://demo.api.horntell.com");

        Map requestData = new HashMap();
        requestData.put("text","Hello");

        Map includeData = new HashMap();
        includeData.put("format","quote");
        includeData.put("icon","http://1.bp.blogspot.com/-2LTvCCufBKc/T3L3KgcTj2I/AAAAAAAABbQ/Ki60e1LU9sE/s1600/Sachin%2BTendulkar.png");
        includeData.put("title","heroine");
        includeData.put("text","bindaas heroine");

        requestData.put("include",includeData);

        Map actionData = new HashMap();
        actionData.put("format","reply");

        Map replyData = new HashMap();
        replyData.put("placeholder","Wanna talk to me??");
        actionData.put("reply",replyData);

        requestData.put("action", actionData);

        HorntellResponse response = Card.toProfiles(new String[]{"009"},requestData);

        System.out.println(response);

    }


    @org.junit.Test
    public final void createCardToChannelSuccessTest() throws HorntellException, IOException {

        App.init(key,secret);
        App.setBase("http://demo.api.horntell.com");

        Map requestData = new HashMap();
        requestData.put("canvas", "default");
        requestData.put("text","Hello");

        Map includeData = new HashMap();
        includeData.put("format","quote");
        includeData.put("icon","http://1.bp.blogspot.com/-2LTvCCufBKc/T3L3KgcTj2I/AAAAAAAABbQ/Ki60e1LU9sE/s1600/Sachin%2BTendulkar.png");
        includeData.put("title","heroine");
        includeData.put("text","bindaas heroine");

        requestData.put("include",includeData);

        Map actionData = new HashMap();
        actionData.put("format","reply");

        Map replyData = new HashMap();
        replyData.put("placeholder","Wanna talk to me??");
        actionData.put("reply",replyData);

        requestData.put("action", actionData);




        HorntellResponse response = Card.toChannel("default",requestData);

        System.out.println(response);

    }




}
