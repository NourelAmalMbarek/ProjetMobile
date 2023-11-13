package com.example.tripsmodule.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.tripsmodule.Domains.EventsDomain;

import java.util.List;

@Dao
public interface EventDao {
    @Insert
    void insertrecord(EventsDomain eventsDomain);
    @Delete
    void delete(EventsDomain eventsDomain);
    @Query("SELECT * FROM events")
    List<EventsDomain> getAllEvents();

    @Query("DELETE FROM events WHERE id=:id")
    void deleteById(int id);

    @Query("UPDATE events SET title = :ftitle, location = :flocation, description = :fdescription, " +
            "score = :fscore, pic = :fpic, price = :fprice WHERE id = :id")
    void updateById(int id, String ftitle, String flocation, String fdescription,
                    double fscore, String fpic, int fprice);

}
