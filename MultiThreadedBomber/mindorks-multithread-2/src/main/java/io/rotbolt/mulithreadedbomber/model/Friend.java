package io.rotbolt.mulithreadedbomber.model;

import java.util.Date;

public class Friend implements Activity{

    private Date createdAt;

    public Friend(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public Date getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return "Friend created at "+createdAt;
    }
}
