package io.dagger.bomber.data;

import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class DbServiceImpl_Factory implements Factory<DbServiceImpl> {
  @Override
  public DbServiceImpl get() {
    return newInstance();
  }

  public static DbServiceImpl_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static DbServiceImpl newInstance() {
    return new DbServiceImpl();
  }

  private static final class InstanceHolder {
    private static final DbServiceImpl_Factory INSTANCE = new DbServiceImpl_Factory();
  }
}
