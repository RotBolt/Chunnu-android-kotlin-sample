package io.dagger.bomber;

import io.dagger.bomber.data.DbService;
import io.dagger.bomber.data.FakeModel;
import io.dagger.bomber.data.NetworkApi;
import io.dagger.bomber.data.Repository;
import io.dagger.bomber.di.AppComponent;
import io.dagger.bomber.di.AppModule;
import io.dagger.bomber.di.DaggerAppComponent;


import javax.inject.Inject;
import javax.inject.Provider;
import java.util.Set;

public class App {

    @Inject
    Repository repository;

    @Inject
    DbService dbService;

    @Inject
    NetworkApi api;

    @Inject
    Set<FakeModel> modelSet;

    @Inject
    Set<Integer> emptySet;

    public App() {
        AppComponent appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule())
                .build();
        appComponent.inject(this);
    }

}
