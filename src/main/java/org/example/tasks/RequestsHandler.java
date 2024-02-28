package org.example.tasks;


import org.apache.http.HttpEntity;

import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class RequestsHandler {
    private static final String USERS_URL =  "https://jsonplaceholder.typicode.com/users";
    private static final String USER_URL = "https://jsonplaceholder.typicode.com/users/1";


    public static String createObjectData(String obj) throws Exception {
        HttpEntity entity = Request.Post(USERS_URL)
                .bodyString(obj, ContentType.APPLICATION_JSON)
                .execute()
                .returnResponse()
                .getEntity();

        return entity != null ? EntityUtils.toString(entity) : "";
    }

    public static String updateObjectData(String obj) throws IOException {
        HttpEntity entity = Request.Put(USER_URL)
                .bodyString(obj, ContentType.APPLICATION_JSON)
                .execute()
                .returnResponse()
                .getEntity();

        return entity != null ? EntityUtils.toString(entity) : "";
    }

    public static String deleteObjectData(long id) throws IOException {
        String response = Request.Delete(String.format("https://jsonplaceholder.typicode.com/users/%s", id))
                .execute()
                .returnResponse()
                .getStatusLine()
                .toString();

        return response;
    }

    public static String getUsersData() throws IOException {
        HttpEntity response = Request.Get(USERS_URL)
                .execute()
                .returnResponse()
                .getEntity();

        return response != null ? EntityUtils.toString(response) : "";
    }

    public static String getUserDataFromId(long id) throws IOException {
        HttpEntity entity = Request.Get(String.format("https://jsonplaceholder.typicode.com/users/%s", id))
                .execute()
                .returnResponse()
                .getEntity();

        return entity != null ? EntityUtils.toString(entity) : "";
    }

    public static String getUserDataFromUsername(String username) throws IOException {
        HttpEntity entity = Request.Get(String.format("https://jsonplaceholder.typicode.com/users?username=%s", username))
                .execute()
                .returnResponse()
                .getEntity();

        return entity != null ? EntityUtils.toString(entity) : "";
    }
}
