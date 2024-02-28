package org.example;

import lombok.SneakyThrows;
import org.example.tasks.CommentHandler;
import org.example.tasks.RequestsHandler;
import org.example.tasks.TaskHandler;

import java.io.IOException;

public class Demo {
    @SneakyThrows
    public static void main(String[] args) {
        String jsonObject = "{" +
                "\"id\": 2," +
                "\"name\": \"John Doe\"," +
                "\"username\": \"johndoe\"," +
                "\"email\": \"john.doe@example.com\"," +
                "\"address\": {" +
                "\"street\": \"123 Main Street\"," +
                "\"suite\": \"Apt. 101\"," +
                "\"city\": \"Anytown\"," +
                "\"zipcode\": \"12345\"," +
                "\"geo\": {" +
                "\"lat\": \"40.7128\"," +
                "\"lng\": \"-74.0060\"" +
                "}" +
                "}," +
                "\"phone\": \"555-555-5555\"," +
                "\"website\": \"example.com\"," +
                "\"company\": {" +
                "\"name\": \"Example Company\"," +
                "\"catchPhrase\": \"Making examples since 2000\"," +
                "\"bs\": \"Example business strategies\"" +
                "}" +
                "}";

//        System.out.println(RequestsHandler.createObjectData(jsonObject));
//        System.out.println(RequestsHandler.updateObjectData(jsonObject));
//        System.out.println(RequestsHandler.deleteObjectData(4));
//        System.out.println(RequestsHandler.getUsersData());
//        System.out.println(RequestsHandler.getUserDataFromId(1));
//        System.out.println(RequestsHandler.getUserDataFromUsername("Bret"));

//        CommentHandler.writeCommentsToFile(1);
//        CommentHandler.writeCommentsToFile(4);

//        System.out.println(TaskHandler.getUncompletedTask(1));

    }
}
