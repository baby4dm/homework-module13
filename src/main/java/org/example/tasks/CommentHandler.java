package org.example.tasks;

import org.apache.http.client.fluent.Request;
import org.json.JSONArray;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CommentHandler {

    private static final String POSTS_URL = "https://jsonplaceholder.typicode.com/users/%s/posts";
    private static final String COMMENTS_URL = "https://jsonplaceholder.typicode.com/posts/%s/comments";

    private static int getLastPost(long id) throws IOException {
        String entity = Request.Get(String.format(POSTS_URL,id)).execute().returnContent().asString();
        JSONArray posts = new JSONArray(entity);
        int postId = posts.getJSONObject(posts.length() - 1).getInt("id");
        return postId;
    }

    public static void writeCommentsToFile(long id) throws IOException {
        String entity = Request.Get(String.format(COMMENTS_URL, getLastPost(id))).execute().returnContent().asString();
        JSONArray jsonArray = new JSONArray(entity);
        List<String> comments = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++) {
            comments.add(jsonArray.getJSONObject(i).getString("body"));
        }

        FileWriter writer = new FileWriter(String.format("user-%d-post-%d-comments.json", id, getLastPost(id)));
        comments.stream()
                .forEach(s -> {
                    try {
                        writer.write(s);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
    }

}
