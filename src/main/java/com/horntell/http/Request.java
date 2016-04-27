/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.horntell.http;


import com.horntell.exception.*;
import com.horntell.App;
import com.horntell.exception.Exception;
import com.squareup.okhttp.*;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Map;

/**
 * @author sahil
 */
public class Request {
    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    OkHttpClient client = new OkHttpClient();

    public static Response _request(String method, String endpoint, Map<String, Object> params) throws IOException, InvalidRequestException, AuthenticationException, ForbiddenException, NotFoundException, ServiceException, Exception {

        String url = App.getBase() + endpoint;

        Request request = new Request();

        Response response = null;

        switch (method) {
            case "GET":
                response = request.doGetRequest(url);
                break;
            case "POST":
                response = request.doPostRequest(url, params);
                break;
            case "DELETE":
                response = request.doDeleteRequest(url);
                break;
            case "PUT":
                response = request.doPutRequest(url, params);
                break;
            default:
                break;
        }

        int code = response.getStatusCode();

        if (code == 204) {
            return response;
        }

        if (200 < code || code > 300) {
            Request.handleApiExceptions(code, response);
        }

        return response;
    }

    private static Request handleApiExceptions(int code, Response response) throws InvalidRequestException, AuthenticationException, ForbiddenException, NotFoundException, ServiceException, Exception {
        String body = response.getBody();
        JSONObject errorObject = new JSONObject(body);

        String message = (String) ((JSONObject) errorObject.get("error")).get("message");
        Integer errorCode = (Integer) ((JSONObject) errorObject.get("error")).get("code");
        String type = (String) ((JSONObject) errorObject.get("error")).get("type");

        switch (code) {
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
                return Request.handleUnknownException(response);
        }

    }

    private static Request handleUnknownException(Response response) throws ServiceException, Exception {
        String body = response.getBody();
        JSONObject errorObject = new JSONObject(body);

        String message = (String) ((JSONObject) errorObject.get("error")).get("message");
        Integer errorCode = (Integer) ((JSONObject) errorObject.get("error")).get("code");
        String type = (String) ((JSONObject) errorObject.get("error")).get("type");

        switch (response.getStatusCode() / 100) {
            // client error (4xx)
            case 4:
                throw new InvalidRequestException(message, errorCode, type);
                // server error (5xx)
            case 5:
                throw new ServiceException(message, errorCode, type);

                // very generic error (if all else fails)
            default:
                throw new Exception(message, errorCode, type);
        }

    }

    Response doGetRequest(String url) throws IOException {

        String credential = Credentials.basic(App.getKey(), App.getSecret());

        com.squareup.okhttp.Request request = new com.squareup.okhttp.Request.Builder()
                .url(url)
                .header("Authorization", credential)
                .addHeader("Accept", "application/vnd.horntell." + App.getVersion() + "+json")
                .addHeader("Content-Type", "text/json")
                .build();

        com.squareup.okhttp.Response response = client.newCall(request).execute();

        return new Response(response);

    }

    private Response doPostRequest(String url, Map<String, Object> params) throws IOException {

        String credential = Credentials.basic(App.getKey(), App.getSecret());
        String json = new JSONObject(params).toString();

        RequestBody body = RequestBody.create(JSON, json);
        com.squareup.okhttp.Request request;
        request = new com.squareup.okhttp.Request.Builder()
                .url(url)
                .header("Authorization", credential)
                .addHeader("Accept", "application/vnd.horntell." + App.getVersion() + "+json")
                .addHeader("Content-Type", "text/json")
                .post(body)
                .build();

        com.squareup.okhttp.Response response = client.newCall(request).execute();

        return new Response(response);
    }

    private Response doDeleteRequest(String url) throws IOException {

        String credential = Credentials.basic(App.getKey(), App.getSecret());

        com.squareup.okhttp.Request request;
        request = new com.squareup.okhttp.Request.Builder()
                .url(url)
                .header("Authorization", credential)
                .addHeader("Accept", "application/vnd.horntell." + App.getVersion() + "+json")
                .addHeader("Content-Type", "text/json")
                .delete()
                .build();

        com.squareup.okhttp.Response response = client.newCall(request).execute();

        return new Response(response);
    }

    private Response doPutRequest(String url, Map<String, Object> params) throws IOException {

        String credential = Credentials.basic(App.getKey(), App.getSecret());
        String json = new JSONObject(params).toString();

        RequestBody body = RequestBody.create(JSON, json);
        com.squareup.okhttp.Request request;
        request = new com.squareup.okhttp.Request.Builder()
                .url(url)
                .header("Authorization", credential)
                .addHeader("Accept", "application/vnd.horntell." + App.getVersion() + "+json")
                .addHeader("Content-Type", "text/json")
                .put(body)
                .build();

        com.squareup.okhttp.Response response = client.newCall(request).execute();

        return new Response(response);
    }
}
