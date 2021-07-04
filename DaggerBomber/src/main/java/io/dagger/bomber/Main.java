package io.dagger.bomber;

import io.dagger.bomber.data.FakeModel;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        App app = new App();
        FakeModel model = app.repository.getModel();
        System.out.println(model);
        System.out.println(app.emptySet.size() );


    }
}
