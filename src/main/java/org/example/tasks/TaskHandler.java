package org.example.tasks;

import org.apache.http.client.fluent.Request;
import org.json.JSONArray;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TaskHandler {
    private static final String TODOS_URL = "https://jsonplaceholder.typicode.com/users/%s/todos";

    public static String getUncompletedTask(long id) throws IOException {
        String response = Request.Get(String.format(TODOS_URL, id)).execute().returnContent().asString();
        JSONArray todos = new JSONArray(response);
        List<String> openTasks = new ArrayList<>();

        for (int i = 0; i < todos.length(); i++) {
            if (!todos.getJSONObject(i).getBoolean("completed")){
                openTasks.add(todos.getJSONObject(i).toString());
            }
        }

        return openTasks.toString();
    }
}
