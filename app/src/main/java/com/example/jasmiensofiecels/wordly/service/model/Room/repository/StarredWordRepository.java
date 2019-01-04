package com.example.jasmiensofiecels.wordly.service.model.Room.repository;

import com.example.jasmiensofiecels.wordly.service.model.Room.Dao.StarredWordDao;
import com.example.jasmiensofiecels.wordly.service.model.Room.Entities.StarredWord;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Single;

/**
 * The purpose of this class is to represent the db interaction repository
 * This architecture practice will enable further separation of concerns
 * Created by jcels on 10/12/2018.
 */

@Singleton
public class StarredWordRepository {

    private final StarredWordDao starredWordDao;

    @Inject
    public StarredWordRepository(StarredWordDao starredWordDao) {
        this.starredWordDao = starredWordDao;
    }

    public Single<List<StarredWord>> getAllStarredWords() {
        return (Single<List<StarredWord>>) starredWordDao.getAll();
    }

    public StarredWord getStarredWord(String word) {
        return starredWordDao.getWord(word);
    }

    public void insertWord(String word) {
        java.util.Date utilDate = new Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

        //TODO: Increment the id
        StarredWord starredWord = new StarredWord(1, word, utilDate.getTime());

        starredWordDao.insertStarredWord(starredWord);
    }

    public void deleteStarredWord(String word) {
        StarredWord starredWord = starredWordDao.getWord(word);
        starredWordDao.deleteWord(starredWord);
    }

}
