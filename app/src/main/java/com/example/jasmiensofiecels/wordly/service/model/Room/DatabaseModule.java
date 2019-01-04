package com.example.jasmiensofiecels.wordly.service.model.Room;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.example.jasmiensofiecels.wordly.service.model.Room.Dao.StarredWordDao;
import com.example.jasmiensofiecels.wordly.service.model.Room.repository.StarredWordRepository;

import dagger.Module;
import dagger.Provides;

/**
 * The purpose of this module class is to enable Dagger to create these Room related objects to be
 * injected where needed
 * Created by jcels on 10/12/2018.
 */

@Module
public class DatabaseModule {

    @Provides
    public AppDatabase provideAppDatabase(Context context) {
        return Room.databaseBuilder(context,
                AppDatabase.class,
                "Worldy_Database")
                .build();
    }

    @Provides
    public StarredWordDao provideStarredWordDoa(AppDatabase appDatabase) {
        return appDatabase.starredWordDao();
    }

    @Provides
    public StarredWordRepository provideStarredWordRepository(StarredWordDao starredWordDao) { return new StarredWordRepository(starredWordDao);}

}
