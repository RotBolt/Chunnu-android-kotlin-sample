package io.rotbolt.mulithreadedbomber;

import io.rotbolt.mulithreadedbomber.model.Activity;
import io.rotbolt.mulithreadedbomber.model.Comment;

import javax.swing.plaf.TableHeaderUI;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class App {
    public static void main(String[] args) throws Exception {

        System.out.println("Program Started");

        System.out.println("Thread name of main " + Thread.currentThread().getName());
        AtomicBoolean processing = new AtomicBoolean(true);
        RemoteService service = new RemoteService();

        service.getUserRecentActivities(activities -> {

            System.out.println("Thread name in callback " + Thread.currentThread().getName());
            for (Activity activity : activities) {
                System.out.println(activity);
            }
            processing.set(false);
        });


        while (processing.get()) {
            // keeo running
        }

        List<Comment> comments = service.getComments("").call();
        comments.forEach(System.out::println);
        service.stop();

        System.out.println("Program Terminated");
    }
}
