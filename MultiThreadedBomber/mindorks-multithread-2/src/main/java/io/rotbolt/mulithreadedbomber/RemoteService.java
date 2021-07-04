package io.rotbolt.mulithreadedbomber;

import io.rotbolt.mulithreadedbomber.model.*;

import java.util.*;
import java.util.concurrent.*;

public class RemoteService {

    private static final int cores = Runtime.getRuntime().availableProcessors();
    private static final ExecutorService executor = Executors.newFixedThreadPool(cores + 1);

    public void getUserRecentActivities(ResultCallback callback) {
        executor.execute(() -> {
            List<Like> likes = new ArrayList<>();
            List<Post> posts = new ArrayList<>();
            List<Comment> comments = new ArrayList<>();
            List<Friend> friends = new ArrayList<>();

            Future<List<Like>> futureLikes = executor.submit(getLikes("https://dummy.com/likes"));
            Future<List<Post>> futurePosts = executor.submit(getPosts("https://dummy.com/posts"));
            Future<List<Comment>> futureComments = executor.submit(getComments("https://dummy.com/comments"));
            Future<List<Friend>> futureFriends = executor.submit(getFriends("https://dummy.com/friends"));

            try {
                likes = futureLikes.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }

            try {
                posts = futurePosts.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }

            try {
                comments = futureComments.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }

            try {
                friends = futureFriends.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }

            List<Activity> activities = new ArrayList<>();
            activities.addAll(likes);
            activities.addAll(posts);
            activities.addAll(comments);
            activities.addAll(friends);
            activities.sort(Comparator.comparing(Activity::getCreatedAt));

            callback.onResult(activities);
        });
    }

    public Callable<List<Like>> getLikes(String url) {
        return () -> {
            System.out.println("getting likes");
            Thread.sleep(2000);
            return Arrays.asList(new Like(new Date(1616854438155L)), new Like(new Date(1616854438178L)));
        };
    }


    public Callable<List<Post>> getPosts(String url) {
        return () -> {
            System.out.println("getting posts");
            Thread.sleep(800);
            return Arrays.asList(new Post(new Date(1616854488155L)), new Post(new Date(1616878438178L)));
        };
    }

    public Callable<List<Comment>> getComments(String url) {
        return () -> {
            System.out.println("getting comments");
            Thread.sleep(1000);
            return Arrays.asList(new Comment(new Date(16168548938155L)), new Comment(new Date(1616854438778L)));
        };
    }

    public Callable<List<Friend>> getFriends(String url) {
        return () -> {
            System.out.println("getting friends");
            Thread.sleep(2600);
            return Arrays.asList(new Friend(new Date(1616854438355L)), new Friend(new Date(1616854488178L)));
        };
    }

    public void stop() {
        executor.shutdown();
    }


}
