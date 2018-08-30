package org.aihdint.aihd.app;

/*
 * Developed by Rodney on 05/02/2018.
 */

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.Charset;

public class HttpHandler {

    private static final String TAG = HttpHandler.class.getSimpleName();

    public HttpHandler() {
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String makeServiceCall(String reqUrl) {
        String response = null;
        try {
            // open url connection
            URL url = new URL( reqUrl );
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // set up url connection to get retrieve information back
            conn.setRequestMethod( "GET" );
            conn.setDoInput( true );

            Authenticator.setDefault(new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(
                            AppController.getInstance().getSessionManager().getUserDetails().get("name"),
                            AppController.getInstance().getSessionManager().getUserDetails().get("password").toCharArray());
                }
            });

            // read the response
            InputStream in = new BufferedInputStream(conn.getInputStream());
            response = convertStreamToString(in);
        } catch (MalformedURLException e) {
            Log.e(TAG, "MalformedURLException: " + e.getMessage());
        } catch (ProtocolException e) {
            Log.e(TAG, "ProtocolException: " + e.getMessage());
        } catch (IOException e) {
            Log.e(TAG, "IOException: " + e.getMessage());
        } catch (Exception e) {
            Log.e(TAG, "Exception: " + e.getMessage());
        }
        return response;
    }

    public String patient(){
        String url="http://45.79.145.240:8080/ems/ws/rest/v1/person";
        try {
            URL urlconn = new URL(url);

            HttpURLConnection con = (HttpURLConnection) urlconn.openConnection();
            con.setDoOutput(true);
            con.setDoInput(true);

            Authenticator.setDefault(new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(
                            AppController.getInstance().getSessionManager().getUserDetails().get("name"),
                            AppController.getInstance().getSessionManager().getUserDetails().get("password").toCharArray());
                }
            });

            con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            con.setRequestProperty("Acceptcharset", "en-us");
            con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
            con.setRequestProperty("charset", "EN-US");
            con.setRequestMethod("POST");

            System.out.println("HTTP Header:"+con.getRequestProperties()+" "+con.getErrorStream() );

            JSONObject jsonObject = new JSONObject();

            JSONObject jsonObjectNames = new JSONObject();
            jsonObjectNames.accumulate("givenName","James");
            jsonObjectNames.accumulate("familyName","Bay");
            jsonObject.accumulate("names", "["+jsonObjectNames+"]");
            jsonObject.accumulate("gender", "M");

            String json = jsonObject.toString();
            json = json.replace("\\","");

            OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream());
            wr.write(json);

            OutputStream os = con.getOutputStream();
            os.write(json.getBytes("UTF-8"));
            //os.close();

            //display what returns the POST request
            StringBuilder sb = new StringBuilder();
            int HttpResult = con.getResponseCode();
            if (HttpResult == HttpURLConnection.HTTP_OK) {
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(con.getInputStream(), "utf-8"));
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line).append("\n");
                }
                br.close();
                System.out.println("Data " + sb.toString());
            } else {
                System.out.println("HTTP Response:"+HttpResult+" "+con.getResponseMessage());
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    private String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return sb.toString();
    }
}

