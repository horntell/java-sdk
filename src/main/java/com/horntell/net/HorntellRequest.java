/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.horntell.net;


import com.google.gson.Gson;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.Credentials;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Response;
import java.io.IOException;
import java.util.Map;
import com.horntell.model.App;
import com.squareup.okhttp.RequestBody;
import com.horntell.exception.AuthenticationException;
import com.horntell.exception.ForbiddenException;
import com.horntell.exception.HorntellException;
import com.horntell.exception.InvalidRequestException;
import com.horntell.exception.NotFoundException;
import com.horntell.exception.ServiceException;
import org.json.JSONObject;

        /**
 *
 * @author sahil
 */
public class HorntellRequest {
    public static final MediaType JSON
      = MediaType.parse("application/json; charset=utf-8");

    OkHttpClient client = new OkHttpClient();

    public static HorntellResponse _request(String method, String endpoint, Map<String, Object> params) throws IOException, InvalidRequestException, AuthenticationException, ForbiddenException, NotFoundException, ServiceException, HorntellException {
         
        String url = App.getBase() +endpoint;
         
         HorntellRequest horntellRequest = new HorntellRequest();
         
         HorntellResponse response = null;
    
         switch (method) {
            case "GET":       
               response = horntellRequest.doGetRequest(url);           
                break;
            case "POST":
               response = horntellRequest.doPostRequest(url, params);
                break;
            case "DELETE":
                response = horntellRequest.doDeleteRequest(url);
                break;
            case "PUT":
                response = horntellRequest.doPutRequest(url, params);
                break;
            default:
                break;
        }
                               
        int code = response.getStatusCode();

        if(code == 204)
        {
            return response;
        }
        
        if(200 < code || code > 300)
        {
            HorntellRequest.handleApiExceptions(code, response);
        }

        return  response;
    }
    
    private static HorntellRequest handleApiExceptions(int code, HorntellResponse response) throws InvalidRequestException, AuthenticationException, ForbiddenException, NotFoundException, ServiceException, HorntellException
    {
        String body = response.getBody();
        JSONObject errorObject = new JSONObject(body);

        String message = (String) ((JSONObject) errorObject.get("error")).get("message");
        Integer errorCode = (Integer) ((JSONObject) errorObject.get("error")).get("code");
        String type = (String) ((JSONObject) errorObject.get("error")).get("type");
        
        switch(code)
        {
            case 400:
                throw new InvalidRequestException(message, errorCode, type);
            case 401:
                    throw new AuthenticationException(message, errorCode, type);
            case 403:
                    throw new ForbiddenException(message, errorCode, type);
            case 404:                
                    throw new NotFoundException(message, errorCode, type);
            case 500:
                    throw new ServiceException(message, errorCode, type);
            // for backwards compatibility, we will handle other
            // HTTP status codes too (to keep the SDK working,
            // even when we send more variants of HTTP status codes
            // through API)
            default:
                    return HorntellRequest.handleUnknownException(response);
        }

    }
    
    private static HorntellRequest handleUnknownException(HorntellResponse response) throws ServiceException, HorntellException
    {
        String body = response.getBody();
        JSONObject errorObject = new JSONObject(body);
        
        String message = (String) ((JSONObject) errorObject.get("error")).get("message");
        Integer errorCode = (Integer) ((JSONObject) errorObject.get("error")).get("code");
        String type = (String) ((JSONObject) errorObject.get("error")).get("type");
        
        switch(response.getStatusCode() / 100)
        {
            // client error (4xx)
            case 4:
                throw new InvalidRequestException(message, errorCode, type);
            // server error (5xx)
            case 5:
                throw new ServiceException(message, errorCode, type);

            // very generic error (if all else fails)
            default:
                throw new HorntellException(message, errorCode, type);
        }
        
    }
    
    HorntellResponse doGetRequest(String url) throws IOException {
           
        String credential = Credentials.basic(App.getKey(), App.getSecret());
    
        com.squareup.okhttp.Request request = new com.squareup.okhttp.Request.Builder()
          .url(url)
          .header("Authorization", credential) 
          .addHeader("Accept", "application/vnd.horntell."+ App.getVersion() +"+json")
          .addHeader("Content-Type", "text/json")
          .build();

        Response response = client.newCall(request).execute();
 
        return new HorntellResponse(response);
      
    }

    private HorntellResponse doPostRequest(String url, Map<String, Object> params) throws IOException {
      
        String credential = Credentials.basic(App.getKey(), App.getSecret());
        Gson gson = new Gson(); 
        String json = gson.toJson(params);
     
        RequestBody body = RequestBody.create(JSON, json);
        com.squareup.okhttp.Request request; 
        request = new com.squareup.okhttp.Request.Builder() 
                .url(url)
                .header("Authorization", credential)
                .addHeader("Accept", "application/vnd.horntell."+ App.getVersion() +"+json")
                .addHeader("Content-Type", "text/json")
                .post(body) 
                .build();
    
        Response response = client.newCall(request).execute();
        
        return new HorntellResponse(response);
    }
    
    private HorntellResponse doDeleteRequest(String url) throws IOException {
      
        String credential = Credentials.basic(App.getKey(), App.getSecret());

        com.squareup.okhttp.Request request; 
        request = new com.squareup.okhttp.Request.Builder() 
                .url(url)
                .header("Authorization", credential)
                .addHeader("Accept", "application/vnd.horntell."+ App.getVersion() +"+json")
                .addHeader("Content-Type", "text/json")
                .delete() 
                .build();
    
        Response response = client.newCall(request).execute();
        
        return new HorntellResponse(response);
    }

    private HorntellResponse doPutRequest(String url, Map<String, Object> params) throws IOException {
      
        String credential = Credentials.basic(App.getKey(), App.getSecret());
        Gson gson = new Gson(); 
        String json = gson.toJson(params);
     
        RequestBody body = RequestBody.create(JSON, json);
        com.squareup.okhttp.Request request; 
        request = new com.squareup.okhttp.Request.Builder() 
                .url(url)
                .header("Authorization", credential)
                .addHeader("Accept", "application/vnd.horntell."+ App.getVersion() +"+json")
                .addHeader("Content-Type", "text/json")
                .put(body) 
                .build();
    
        Response response = client.newCall(request).execute();
        
        return new HorntellResponse(response);
    }
}
