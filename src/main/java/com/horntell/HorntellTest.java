/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.horntell;
import com.horntell.exception.HorntellException;
import com.horntell.exception.InvalidRequestException;
import com.horntell.exception.NotFoundException;
import java.util.HashMap;
import java.util.Map;

import com.horntell.model.Profile;
import java.io.IOException;
import com.horntell.model.App;
import com.horntell.model.Campaign;
import com.horntell.model.Horn;
import org.json.JSONObject;
/**
 *
 * @author sahil
 */

public class HorntellTest {
    
    public static void profileGet() throws IOException
    {
     try{
            System.out.println(Profile.find("3").getBody());
        }
        catch(NotFoundException e)
        {
            System.out.println(e.getMessage());
             System.out.println(e.getType());
              System.out.println(e.getCode());
        }
        catch(HorntellException e)
        {
                System.out.println("main");
                System.out.println(e);

        //        System.out.println(((JSONObject) mainObject.get("data")).get("email"));  

        //         System.out.println(Profile.find("3").getStatusCode());
        //        System.out.println(Profile.create(chargeParams));
         }
    }
    
    public static void profileDelete() throws IOException
    {
     
        try {
            System.out.println(Profile.delete("213").getStatusCode());
        }
        catch(NotFoundException e)
        {
            System.out.println(e.getMessage());
            System.out.println(e.getType());
            System.out.println(e.getCode());
        }
        catch(HorntellException e)
        {
                System.out.println("main");
                System.out.println(e);

        //        System.out.println(((JSONObject) mainObject.get("data")).get("email"));  

        //         System.out.println(Profile.find("3").getStatusCode());
        //        System.out.println(Profile.create(chargeParams));
         }
    }
    
        
    public static void profilePost() throws IOException
    {
         Map<String, Object> profileParams = new HashMap<String, Object>();
        profileParams.put("uid", "213");
        profileParams.put("currency", "usd");

//        String response = Profile.find("3343434").getBody();
//        JSONObject mainObject = new JSONObject(response);
//        System.out.println(((JSONObject) mainObject.get("error")).get("message"));
//        JSONObject mainObject = new JSONObject(response);
     
        try{
            System.out.println(Profile.create(profileParams).getBody());
        }
        catch(InvalidRequestException e)
        {
            System.out.println(e.getMessage());
             System.out.println(e.getType());
              System.out.println(e.getCode());
        }
        catch(NotFoundException e)
        {
            System.out.println(e.getMessage());
             System.out.println(e.getType());
              System.out.println(e.getCode());
        }
        catch(HorntellException e)
        {
                System.out.println("main");
                System.out.println(e);

        //        System.out.println(((JSONObject) mainObject.get("data")).get("email"));  

        //         System.out.println(Profile.find("3").getStatusCode());
        //        System.out.println(Profile.create(chargeParams));
         }
    }
    
    public static void profilePut() throws IOException
    {
         Map<String, Object> profileParams = new HashMap<String, Object>();
        profileParams.put("uid", "213");
        profileParams.put("first_name", "Sahil");

//        String response = Profile.find("3343434").getBody();
//        JSONObject mainObject = new JSONObject(response);
//        System.out.println(((JSONObject) mainObject.get("error")).get("message"));
//        JSONObject mainObject = new JSONObject(response);
     
        try{
            System.out.println(Profile.update("214", profileParams).getBody());
        }
        catch(InvalidRequestException e)
        {
            System.out.println(e.getMessage());
             System.out.println(e.getType());
              System.out.println(e.getCode());
        }
        catch(NotFoundException e)
        {
            System.out.println(e.getMessage());
             System.out.println(e.getType());
              System.out.println(e.getCode());
        }
        catch(HorntellException e)
        {
                System.out.println("main");
                System.out.println(e);

        //        System.out.println(((JSONObject) mainObject.get("data")).get("email"));  

        //         System.out.println(Profile.find("3").getStatusCode());
        //        System.out.println(Profile.create(chargeParams));
         }
    }
    
    public static void hornToProfile() throws IOException
    {
         Map<String, Object> hornParams = new HashMap<String, Object>();
        hornParams.put("format", "link");
        hornParams.put("type", "danger");
        hornParams.put("icon", "paw");
        hornParams.put("bubble", true);
        hornParams.put("link", "http://horntell.com/invitation");
        hornParams.put("text", "Invitations running out. Request an invitation, NOW!");
	 	
//        String response = Profile.find("3343434").getBody();
//        JSONObject mainObject = new JSONObject(response);
//        System.out.println(((JSONObject) mainObject.get("error")).get("message"));
//        JSONObject mainObject = new JSONObject(response);
     
        try{
            System.out.println(Horn.toProfile("3", hornParams).getBody());
        }
        catch(InvalidRequestException e)
        {
            System.out.println(e.getMessage());
             System.out.println(e.getType());
              System.out.println(e.getCode());
        }
        catch(NotFoundException e)
        {
            System.out.println(e.getMessage());
             System.out.println(e.getType());
              System.out.println(e.getCode());
        }
        catch(HorntellException e)
        {
                System.out.println("main");
                System.out.println(e);

        //        System.out.println(((JSONObject) mainObject.get("data")).get("email"));  

        //         System.out.println(Profile.find("3").getStatusCode());
        //        System.out.println(Profile.create(chargeParams));
         }
    }
    public static void hornToProfiles() throws IOException
    {
         Map<String, Object> hornParams = new HashMap<String, Object>();
        hornParams.put("format", "link");
        hornParams.put("type", "danger");
        hornParams.put("icon", "paw");
        hornParams.put("bubble", true);
        hornParams.put("link", "http://horntell.com/invitation");
        hornParams.put("text", "Invitations running out. Request an invitation, NOW!");
	 	
//        String response = Profile.find("3343434").getBody();
//        JSONObject mainObject = new JSONObject(response);
//        System.out.println(((JSONObject) mainObject.get("error")).get("message"));
//        JSONObject mainObject = new JSONObject(response);

        try{
             String[] profiles = {"3"};
            System.out.println(Horn.toProfiles(profiles, hornParams).getBody());
        }
        catch(InvalidRequestException e)
        {
            System.out.println(e.getMessage());
             System.out.println(e.getType());
              System.out.println(e.getCode());
        }
        catch(NotFoundException e)
        {
            System.out.println(e.getMessage());
             System.out.println(e.getType());
              System.out.println(e.getCode());
        }
        catch(HorntellException e)
        {
                System.out.println("main");
                System.out.println(e);

        //        System.out.println(((JSONObject) mainObject.get("data")).get("email"));  

        //         System.out.println(Profile.find("3").getStatusCode());
        //        System.out.println(Profile.create(chargeParams));
         }
    }
    
    public static void campaignToSingleProfile() throws IOException
    {
         Map<String, Object> metaParams = null;
//	 	557a5f67d76af15d1e8b4567
//        String response = Profile.find("3343434").getBody();
//        JSONObject mainObject = new JSONObject(response);
//        System.out.println(((JSONObject) mainObject.get("error")).get("message"));
//        JSONObject mainObject = new JSONObject(response);

        try{
             String[] profiles = {"3"};
            System.out.println(Campaign.toProfile("3", "557a5f67d76af15d1e8b4567", metaParams).getBody());
        }
        catch(InvalidRequestException e)
        {
            System.out.println(e.getMessage());
             System.out.println(e.getType());
              System.out.println(e.getCode());
        }
        catch(NotFoundException e)
        {
            System.out.println(e.getMessage());
             System.out.println(e.getType());
              System.out.println(e.getCode());
        }
        catch(HorntellException e)
        {
                System.out.println("main");
                System.out.println(e);

        //        System.out.println(((JSONObject) mainObject.get("data")).get("email"));  

        //         System.out.println(Profile.find("3").getStatusCode());
        //        System.out.println(Profile.create(chargeParams));
         }
    }
    
    public static void campaignToMultipleProfiles() throws IOException
    {
         Map<String, Object> metaParams = null;
//	 	557a5f67d76af15d1e8b4567
//        String response = Profile.find("3343434").getBody();
//        JSONObject mainObject = new JSONObject(response);
//        System.out.println(((JSONObject) mainObject.get("error")).get("message"));
//        JSONObject mainObject = new JSONObject(response);

        try{
             String[] profiles = {"3"};
            System.out.println(Campaign.toProfiles(profiles, "557a5f67d76af15d1e8b4567", metaParams).getBody());
        }
        catch(InvalidRequestException e)
        {
            System.out.println(e.getMessage());
             System.out.println(e.getType());
              System.out.println(e.getCode());
        }
        catch(NotFoundException e)
        {
            System.out.println(e.getMessage());
             System.out.println(e.getType());
              System.out.println(e.getCode());
        }
        catch(HorntellException e)
        {
                System.out.println("main");
                System.out.println(e);

        //        System.out.println(((JSONObject) mainObject.get("data")).get("email"));  

        //         System.out.println(Profile.find("3").getStatusCode());
        //        System.out.println(Profile.create(chargeParams));
         }
    }
    

     public static void main(String[] args) throws IOException, Exception {    
        App.init("pVtU9xijt0SYe31aKXoOCzIEU8M8mD33C5G2TzUh", "GhbEuydFa6aYwaqb6Mcg0QLr5Wef9VCLqkxe8azY");
        App.setBase("http://horntell-api.dev");
        App.setVersion("v1");
        System.out.println(App.getSecret());
        System.out.println(App.getBase());
        System.out.println(App.getVersion());
        
//        HorntellTest.profileGet();
//        HorntellTest.profilePost();
//          HorntellTest.profilePut();
//           HorntellTest.profileDelete();
//           HorntellTest.hornToProfile();  
//        HorntellTest.hornToProfiles();

//         HorntellTest.campaignToSingleProfile();
     
         HorntellTest.campaignToMultipleProfiles();
     }
}
