package io.dagger.bomber.di;

import dagger.Component;
import io.dagger.bomber.App;

@Component(modules = {AppModule.class, PUIModule.class,EmptyModule.class})
public interface AppComponent {
    void inject(App app);
}
