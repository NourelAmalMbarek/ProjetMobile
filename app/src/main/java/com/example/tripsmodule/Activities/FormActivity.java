package com.example.tripsmodule.Activities;

import android.content.Intent;
import android.media.metrics.Event;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.tripsmodule.DAO.EventDao;
import com.example.tripsmodule.Database.AppDatabase;
import com.example.tripsmodule.Domains.EventsDomain;
import com.example.tripsmodule.R;

import java.text.BreakIterator;
import java.util.List;

public class FormActivity extends AppCompatActivity {
    EditText t1,t2,t3,t4,t5,t6;
    Button b1,b2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        t1=findViewById(R.id.t1);
        t2=findViewById(R.id.t2);
        t3=findViewById(R.id.t3);
        t4=findViewById(R.id.t4);
        t5=findViewById(R.id.t5);
        t6=findViewById(R.id.t6);
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new bgthread().start();

            }
        });

        b2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(getApplicationContext(), fetchdata.class));





            }
        });


    }


    class bgthread extends Thread {
        public void run() {
            super.run();
            AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                    AppDatabase.class, "room_db").allowMainThreadQueries().build();
            EventDao eventDao = db.eventDao();
            eventDao.insertrecord(new EventsDomain(
                    t1.getText().toString(),
                    t2.getText().toString(),
                    t3.getText().toString(),
                    Double.parseDouble(t4.getText().toString()),
                    t5.getText().toString(),
                    Integer.parseInt(t6.getText().toString())
            ));

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    t1.setText("");
                    t2.setText("");
                    t3.setText("");
                    t4.setText("");
                    t5.setText("");
                    t6.setText("");

                    Toast.makeText(getApplicationContext(), "Inserted Successfully", Toast.LENGTH_LONG).show();
                }
            });



        }


    }}
