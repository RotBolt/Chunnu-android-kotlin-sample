package io.dagger.bomber.data;

public class NetworkApi {

    public FakeModel makeCall() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new FakeModel("pui");
    }
}
