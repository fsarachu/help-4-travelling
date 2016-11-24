package uy.edu.cure.servidor.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RestController {

    public <T> T doGET(String urlWithParamsIncluded, Class<T> typeParameterClass) {
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(urlWithParamsIncluded);
        request.addHeader("content-type", "application/json");
        ObjectMapper mapper = new ObjectMapper();
        HttpResponse response;
        String result = "";
        try {
            response = client.execute(request);
            result = getStringFromInputStream(response.getEntity().getContent());
        } catch (IOException ex) {
            Logger.getLogger(RestController.class.getName()).log(Level.SEVERE, null, ex);
        }
        T tResult = null;
        try {
            tResult = mapper.readValue(result, typeParameterClass);
        } catch (IOException ex) {
            Logger.getLogger(RestController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tResult;
    }

    public <T> T doPOST(String url, Object data, Class<T> typeParameterClass) {
        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpPost request = new HttpPost(url);
            request.addHeader("content-type", "application/json");
            ObjectMapper mapper = new ObjectMapper();
            String entityContent = mapper.writeValueAsString(data);
            StringEntity entity = new StringEntity(entityContent);
            request.setEntity(entity);
            HttpResponse response;
            String result = "";
            try {
                response = client.execute(request);
                result = getStringFromInputStream(response.getEntity().getContent());
            } catch (IOException ex) {
                Logger.getLogger(RestController.class.getName()).log(Level.SEVERE, null, ex);
            }
            T tResult = null;
            try {
                tResult = mapper.readValue(result, typeParameterClass);
            } catch (IOException ex) {
                Logger.getLogger(RestController.class.getName()).log(Level.SEVERE, null, ex);
            }
            return tResult;
        } catch (JsonProcessingException | UnsupportedEncodingException ex) {
            Logger.getLogger(RestController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public <T> T doPUT(String url, Object data, Class<T> typeParameterClass) {
        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpPut request = new HttpPut(url);
            request.addHeader("content-type", "application/json");
            ObjectMapper mapper = new ObjectMapper();
            String entityContent = mapper.writeValueAsString(data);
            StringEntity entity = new StringEntity(entityContent);
            request.setEntity(entity);
            HttpResponse response;
            String result = "";
            try {
                response = client.execute(request);
                result = getStringFromInputStream(response.getEntity().getContent());
            } catch (IOException ex) {
                Logger.getLogger(RestController.class.getName()).log(Level.SEVERE, null, ex);
            }
            T tResult = null;
            try {
                tResult = mapper.readValue(result, typeParameterClass);
            } catch (IOException ex) {
                Logger.getLogger(RestController.class.getName()).log(Level.SEVERE, null, ex);
            }
            return tResult;
        } catch (JsonProcessingException | UnsupportedEncodingException ex) {
            Logger.getLogger(RestController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }


    private static String getStringFromInputStream(InputStream is) {

        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();

        String line;
        try {

            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }

}