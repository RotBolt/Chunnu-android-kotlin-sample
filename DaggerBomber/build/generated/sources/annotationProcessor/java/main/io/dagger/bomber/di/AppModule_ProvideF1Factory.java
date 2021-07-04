package io.dagger.bomber.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import io.dagger.bomber.data.FakeModel;
import javax.annotation.Generated;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class AppModule_ProvideF1Factory implements Factory<FakeModel> {
  private final AppModule module;

  public AppModule_ProvideF1Factory(AppModule module) {
    this.module = module;
  }

  @Override
  public FakeModel get() {
    return provideF1(module);
  }

  public static AppModule_ProvideF1Factory create(AppModule module) {
    return new AppModule_ProvideF1Factory(module);
  }

  public static FakeModel provideF1(AppModule instance) {
    return Preconditions.checkNotNull(instance.provideF1(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
