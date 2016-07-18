package com.example.admin.httpurlconnection;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.StrictMode;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by admin on 7/14/2016.
 */
public class RestUtil {

    private static final String TAG = "Rest Util --->";

    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static String requestWebService(String url){
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);
        HttpURLConnection connection;
        String response;
        StringBuilder sb = new StringBuilder();

        try {

            URL urlRequest = new URL(url);
            connection = ((HttpURLConnection) urlRequest.openConnection());
            int statusCode = connection.getResponseCode();
            if(statusCode != HttpURLConnection.HTTP_OK){
                Log.wtf(TAG, "This is not a good code: " + statusCode);
                return null;
            }

            try(InputStream in = new BufferedInputStream(connection.getInputStream());
                BufferedReader br = new BufferedReader(new InputStreamReader(in))){
                while ((response = br.readLine()) != null){
                    sb.append(response);
                }
            }catch (IOException e){
                throw e;
            }
            connection.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }

}
