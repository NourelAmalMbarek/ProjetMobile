package com.example.tripsmodule.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.tripsmodule.Adapters.CategoryAdapter;
import com.example.tripsmodule.Adapters.EventsAdapter;
import com.example.tripsmodule.Domains.CategoryDomain;
import com.example.tripsmodule.Domains.EventsDomain;
import com.example.tripsmodule.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapterTrips,adapterCat;
    private RecyclerView recyclerViewTrips,recyclerViewCategory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRecyclerView();

        ImageButton adminButton = findViewById(R.id.adminButton);
        adminButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirigez vers la page du formulaire (FormActivity) en utilisant une intention (Intent).
                Intent intent = new Intent(getApplicationContext(), FormActivity.class);
                startActivity(intent);
            }
        });



    }

    private void initRecyclerView() {
        ArrayList<EventsDomain> items = new ArrayList<>();
        items.add(new EventsDomain("Summer Festival","sidi bou said, Tunisia","Join us for a vibrant" +
                " celebration at our annual festival! Immerse yourself in a world of music, art, and culture as we bring together " +
                "diverse communities for a weekend of joy and connection. Experience the thrill of live performances from talented " +
                "artists, indulge in delicious local cuisine, and explore a marketplace filled with unique crafts. With activities " +
                "for all ages, our festival is a lively, family-friendly event that promises unforgettable moments. Come be a part of " +
                "the magic and create lasting memories with friends and family. Join us in celebrating the spirit of community and " +
                "creativity at Summer festival!",2,
                "festival",50));
        items.add(new EventsDomain("Picnic","Bizerte ","Escape the hustle and bustle of daily life and join us for" +
                " a delightful picnic in [Location]. Picture a day filled with laughter, good food, and the great outdoors. Spread out" +
                " your blanket, savor delicious bites from local vendors, and enjoy the company of friends and family. Engage in classic " +
                "picnic games, unwind to live music, and let the kids play in the designated play area. With a picturesque backdrop and a " +
                "relaxed atmosphere, our picnic event promises a perfect day of leisure and connection. ",1,
                "picnic",15));
        items.add(new EventsDomain("Charity ","Ariana","Join us for a heartwarming evening at [Charity Event Name], " +
                "where compassion meets action. This special event brings our community together to make a positive impact. Enjoy an inspiring" +
                " program, connect with like-minded individuals, and contribute to meaningful causes. Your presence helps us support those in " +
                "need, making a difference one act of kindness at a time. Let's come together for a night of philanthropy, camaraderie, and shared" +
                " purpose at [Charity Event Name]",3,
                "crt",5));
        recyclerViewTrips = findViewById(R.id.view_trip);
        recyclerViewTrips.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        adapterTrips=new EventsAdapter(items);
        recyclerViewTrips.setAdapter(adapterTrips);

        ArrayList<CategoryDomain> catsList =new ArrayList<>();
        catsList.add(new CategoryDomain("Beaches","cat1"));
        catsList.add(new CategoryDomain("Camps","cat2"));
        catsList.add(new CategoryDomain("Desert","cat3"));
        catsList.add(new CategoryDomain("Forest","cat4"));
        catsList.add(new CategoryDomain("Mountain","cat5"));

       recyclerViewCategory=findViewById(R.id.view_cat);
        recyclerViewCategory.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        adapterCat=new CategoryAdapter(catsList);
        recyclerViewCategory.setAdapter(adapterCat);
    }
}