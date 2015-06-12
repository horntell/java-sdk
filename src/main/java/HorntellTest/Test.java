/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HorntellTest;

//import com.horntell.Horntell;
//import com.horntell.exception.HorntellException;
//import com.horntell.model.Profile;
///**
// *
// * @author sahil
// */
//public class Test {
//    public static void main(String[] args) {
//        
//      System.out.println(Profile.get());
//   }
//}
import com.squareup.okhttp.Credentials;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.io.IOException;

public class Test {
  OkHttpClient client = new OkHttpClient();

  String run(String url) throws IOException {
    String credential = Credentials.basic("pVtU9xijt0SYe31aKXoOCzIEU8M8mD33C5G2TzUh", "GhbEuydFa6aYwaqb6Mcg0QLr5Wef9VCLqkxe8azY");
       
    Request request = new Request.Builder()
        .url(url)
        .header("Authorization", credential) 
        .addHeader("Accept", "application/vnd.horntellv1+json") 
        .addHeader("Content-Type", "application/json") 
            .build();

    Response response = client.newCall(request).execute();
    return response.body().string();
  }

  public static void main(String[] args) throws IOException {
    Test example = new Test();
    String response = example.run("http://horntell-api.dev/profiles/3");
    System.out.println(response);
  }
}