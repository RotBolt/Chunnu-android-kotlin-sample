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
public final class FakeRepository_Factory implements Factory<FakeRepository> {
  private final Provider<FakeNetworkAPI> networkAPIProvider;

  public FakeRepository_Factory(Provider<FakeNetworkAPI> networkAPIProvider) {
    this.networkAPIProvider = networkAPIProvider;
  }

  @Override
  public FakeRepository get() {
    return newInstance(networkAPIProvider.get());
  }

  public static FakeRepository_Factory create(Provider<FakeNetworkAPI> networkAPIProvider) {
    return new FakeRepository_Factory(networkAPIProvider);
  }

  public static FakeRepository newInstance(FakeNetworkAPI networkAPI) {
    return new FakeRepository(networkAPI);
  }
}
