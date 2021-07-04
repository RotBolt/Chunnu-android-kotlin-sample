package io.dagger.bomber;

import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import io.dagger.bomber.data.DbService;
import io.dagger.bomber.data.FakeModel;
import io.dagger.bomber.data.NetworkApi;
import io.dagger.bomber.data.Repository;
import java.util.Set;
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
public final class App_MembersInjector implements MembersInjector<App> {
  private final Provider<Repository> repositoryProvider;

  private final Provider<DbService> dbServiceProvider;

  private final Provider<NetworkApi> apiProvider;

  private final Provider<Set<FakeModel>> modelSetProvider;

  private final Provider<Set<Integer>> emptySetProvider;

  public App_MembersInjector(Provider<Repository> repositoryProvider,
      Provider<DbService> dbServiceProvider, Provider<NetworkApi> apiProvider,
      Provider<Set<FakeModel>> modelSetProvider, Provider<Set<Integer>> emptySetProvider) {
    this.repositoryProvider = repositoryProvider;
    this.dbServiceProvider = dbServiceProvider;
    this.apiProvider = apiProvider;
    this.modelSetProvider = modelSetProvider;
    this.emptySetProvider = emptySetProvider;
  }

  public static MembersInjector<App> create(Provider<Repository> repositoryProvider,
      Provider<DbService> dbServiceProvider, Provider<NetworkApi> apiProvider,
      Provider<Set<FakeModel>> modelSetProvider, Provider<Set<Integer>> emptySetProvider) {
    return new App_MembersInjector(repositoryProvider, dbServiceProvider, apiProvider, modelSetProvider, emptySetProvider);
  }

  @Override
  public void injectMembers(App instance) {
    injectRepository(instance, repositoryProvider.get());
    injectDbService(instance, dbServiceProvider.get());
    injectApi(instance, apiProvider.get());
    injectModelSet(instance, modelSetProvider.get());
    injectEmptySet(instance, emptySetProvider.get());
  }

  @InjectedFieldSignature("io.dagger.bomber.App.repository")
  public static void injectRepository(App instance, Repository repository) {
    instance.repository = repository;
  }

  @InjectedFieldSignature("io.dagger.bomber.App.dbService")
  public static void injectDbService(App instance, DbService dbService) {
    instance.dbService = dbService;
  }

  @InjectedFieldSignature("io.dagger.bomber.App.api")
  public static void injectApi(App instance, NetworkApi api) {
    instance.api = api;
  }

  @InjectedFieldSignature("io.dagger.bomber.App.modelSet")
  public static void injectModelSet(App instance, Set<FakeModel> modelSet) {
    instance.modelSet = modelSet;
  }

  @InjectedFieldSignature("io.dagger.bomber.App.emptySet")
  public static void injectEmptySet(App instance, Set<Integer> emptySet) {
    instance.emptySet = emptySet;
  }
}
