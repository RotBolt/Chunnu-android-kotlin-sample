package io.dagger.bomber.di;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import io.dagger.bomber.data.FakeModel;
import io.dagger.bomber.data.NetworkApi;

@Module
public class AppModule {

    @Provides
    public NetworkApi provideNetworkApi() {
        return new NetworkApi();
    }

    @Provides
    public Integer provideInt() {
        return 90;
    }

    @Provides
    @IntoSet
    public FakeModel provideF1(){
        return new FakeModel("1");
    }

    @Provides
    @IntoSet
    public FakeModel provideF2(){
        return new FakeModel("1");
    }
}
