package com.example.tripsmodule.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.tripsmodule.Adapters.myadapter;
import com.example.tripsmodule.DAO.EventDao;
import com.example.tripsmodule.Database.AppDatabase;
import com.example.tripsmodule.Domains.EventsDomain;
import com.example.tripsmodule.R;

import java.util.List;

public class fetchdata extends AppCompatActivity {
    RecyclerView recview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetchdata);


        getroomdata();
    }

    public void getroomdata(){
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "room_db").allowMainThreadQueries().build();
        EventDao eventDao = db.eventDao();
        recview=findViewById(R.id.recview);
        recview.setLayoutManager(new LinearLayoutManager(this ));
        List<EventsDomain> eventsDomains=eventDao.getAllEvents();
        myadapter adapter=new myadapter(eventsDomains);
        recview.setAdapter(adapter);

    }


}
