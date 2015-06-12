/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.horntell.net;

import com.squareup.okhttp.ResponseBody;
import java.io.IOException;

public class HorntellResponse {
	
        ResponseBody responseOrignal;    
	int responseCode;
	String responseBody;
	
	public HorntellResponse(com.squareup.okhttp.Response response) throws IOException {
            this.responseOrignal = response.body();
            System.out.println("response code");            
            System.out.println(response.code());
            this.responseCode = response.code();
            this.responseBody = response.body().string();
	}

    HorntellResponse(HorntellResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getStatusCode() {
            return responseCode;
    }

    public String getBody() {
            return responseBody;
    }

    public ResponseBody getOriginal()
    {
        return responseOrignal;
    }
}
