package io.dagger.bomber.di;

import dagger.internal.Preconditions;
import dagger.internal.SetBuilder;
import io.dagger.bomber.App;
import io.dagger.bomber.App_MembersInjector;
import io.dagger.bomber.data.DbServiceImpl;
import io.dagger.bomber.data.FakeModel;
import io.dagger.bomber.data.Repository;
import java.util.Collections;
import java.util.Set;
import javax.annotation.Generated;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class DaggerAppComponent implements AppComponent {
  private final AppModule appModule;

  private DaggerAppComponent(AppModule appModuleParam) {
    this.appModule = appModuleParam;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static AppComponent create() {
    return new Builder().build();
  }

  private Repository getRepository() {
    return new Repository(AppModule_ProvideNetworkApiFactory.provideNetworkApi(appModule));
  }

  private Set<FakeModel> getSetOfFakeModel() {
    return SetBuilder.<FakeModel>newSetBuilder(2).add(AppModule_ProvideF1Factory.provideF1(appModule)).add(AppModule_ProvideF2Factory.provideF2(appModule)).build();
  }

  @Override
  public void inject(App app) {
    injectApp(app);
  }

  private App injectApp(App instance) {
    App_MembersInjector.injectRepository(instance, getRepository());
    App_MembersInjector.injectDbService(instance, new DbServiceImpl());
    App_MembersInjector.injectApi(instance, AppModule_ProvideNetworkApiFactory.provideNetworkApi(appModule));
    App_MembersInjector.injectModelSet(instance, getSetOfFakeModel());
    App_MembersInjector.injectEmptySet(instance, Collections.<Integer>emptySet());
    return instance;
  }

  public static final class Builder {
    private AppModule appModule;

    private Builder() {
    }

    public Builder appModule(AppModule appModule) {
      this.appModule = Preconditions.checkNotNull(appModule);
      return this;
    }

    public AppComponent build() {
      if (appModule == null) {
        this.appModule = new AppModule();
      }
      return new DaggerAppComponent(appModule);
    }
  }
}
