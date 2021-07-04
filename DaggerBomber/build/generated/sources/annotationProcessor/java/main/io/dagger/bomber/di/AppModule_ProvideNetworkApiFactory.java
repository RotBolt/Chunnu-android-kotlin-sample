package io.dagger.bomber.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import io.dagger.bomber.data.NetworkApi;
import javax.annotation.Generated;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class AppModule_ProvideNetworkApiFactory implements Factory<NetworkApi> {
  private final AppModule module;

  public AppModule_ProvideNetworkApiFactory(AppModule module) {
    this.module = module;
  }

  @Override
  public NetworkApi get() {
    return provideNetworkApi(module);
  }

  public static AppModule_ProvideNetworkApiFactory create(AppModule module) {
    return new AppModule_ProvideNetworkApiFactory(module);
  }

  public static NetworkApi provideNetworkApi(AppModule instance) {
    return Preconditions.checkNotNull(instance.provideNetworkApi(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
