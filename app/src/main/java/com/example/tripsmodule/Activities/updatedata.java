package com.example.tripsmodule.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.tripsmodule.DAO.EventDao;
import com.example.tripsmodule.Database.AppDatabase;
import com.example.tripsmodule.R;

public class updatedata extends AppCompatActivity {

    int id;
    EditText ftitle, flocation,fdescription,
            fscore, fpic, fprice;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatedata);

        ftitle=findViewById(R.id.edittitle);
        flocation=findViewById(R.id.editlocation);
        fdescription=findViewById(R.id.editdescription);
        fscore=findViewById(R.id.editscore);
        fpic=findViewById(R.id.editpic);
        fprice=findViewById(R.id.editprice);
        btn=findViewById(R.id.btn);




        ftitle.setText(getIntent().getStringExtra("ufname"));
        flocation.setText(getIntent().getStringExtra("ulocation"));
        fdescription.setText(getIntent().getStringExtra("udescription"));
        fscore.setText(String.valueOf(getIntent().getDoubleExtra("uscore", 0.0))); // 0.0 est une valeur par défaut si l'attribut n'est pas trouvé
        fpic.setText(getIntent().getStringExtra("upic"));
        fprice.setText(String.valueOf(getIntent().getIntExtra("uprice", 0))); // 0 est une valeur par défaut si l'attribut n'est pas trouvé


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                        AppDatabase.class, "room_db").allowMainThreadQueries().build();
                EventDao eventDao = db.eventDao();
                eventDao.updateById(id, ftitle.getText().toString(), flocation.getText().toString(),
                        fdescription.getText().toString(), Double.parseDouble(fscore.getText().toString()), fpic.getText().toString()
                        , Integer.parseInt(fprice.getText().toString()));


                startActivity(new Intent(getApplicationContext(), fetchdata.class));
                finish();
            }

        });
    }



    }
