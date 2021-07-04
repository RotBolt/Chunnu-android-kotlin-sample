package io.dagger.bomber.data;

import javax.inject.Inject;

public class Repository {

    private NetworkApi networkApi;

    @Inject
    public Repository(NetworkApi api) {
        networkApi = api;
    }

    public FakeModel getModel() {
        return networkApi.makeCall();
    }
}
