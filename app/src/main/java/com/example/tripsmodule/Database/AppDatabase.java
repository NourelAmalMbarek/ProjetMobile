package com.example.tripsmodule.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.tripsmodule.DAO.EventDao;
import com.example.tripsmodule.Domains.EventsDomain;

@Database(entities = {EventsDomain.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract EventDao eventDao() ;


}
