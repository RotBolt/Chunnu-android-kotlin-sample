package io.rotbolt.mulithreadedbomber.model;

import java.util.Date;

public class Post implements Activity{

    private Date createdAt;

    public Post(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public Date getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return "Post created at "+createdAt;
    }
}
