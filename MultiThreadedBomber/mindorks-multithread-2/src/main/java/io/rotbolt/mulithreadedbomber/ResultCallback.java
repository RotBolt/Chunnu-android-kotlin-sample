package io.rotbolt.mulithreadedbomber;

import io.rotbolt.mulithreadedbomber.model.Activity;

import java.util.List;

public interface ResultCallback {
    void onResult(List<Activity> activities);
}
