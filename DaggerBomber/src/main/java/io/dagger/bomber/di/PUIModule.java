package io.dagger.bomber.di;

import dagger.Binds;
import dagger.Module;
import io.dagger.bomber.data.DbService;
import io.dagger.bomber.data.DbServiceImpl;

@Module
public interface PUIModule {

    @Binds
    DbService bindDbService(DbServiceImpl dbService);
}
