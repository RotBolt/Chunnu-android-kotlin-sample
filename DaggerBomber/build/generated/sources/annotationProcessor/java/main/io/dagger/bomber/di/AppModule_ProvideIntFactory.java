package io.dagger.bomber.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class AppModule_ProvideIntFactory implements Factory<Integer> {
  private final AppModule module;

  public AppModule_ProvideIntFactory(AppModule module) {
    this.module = module;
  }

  @Override
  public Integer get() {
    return provideInt(module);
  }

  public static AppModule_ProvideIntFactory create(AppModule module) {
    return new AppModule_ProvideIntFactory(module);
  }

  public static Integer provideInt(AppModule instance) {
    return Preconditions.checkNotNull(instance.provideInt(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
