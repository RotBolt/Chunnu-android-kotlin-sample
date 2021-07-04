package io.dagger.bomber.data;

import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class Repository_Factory implements Factory<Repository> {
  private final Provider<NetworkApi> apiProvider;

  public Repository_Factory(Provider<NetworkApi> apiProvider) {
    this.apiProvider = apiProvider;
  }

  @Override
  public Repository get() {
    return newInstance(apiProvider.get());
  }

  public static Repository_Factory create(Provider<NetworkApi> apiProvider) {
    return new Repository_Factory(apiProvider);
  }

  public static Repository newInstance(NetworkApi api) {
    return new Repository(api);
  }
}
