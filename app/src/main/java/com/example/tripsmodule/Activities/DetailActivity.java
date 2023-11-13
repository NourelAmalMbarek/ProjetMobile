package com.example.tripsmodule.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.tripsmodule.Domains.EventsDomain;
import com.example.tripsmodule.R;

public class DetailActivity extends AppCompatActivity {

    private TextView titleTxt,locationTxt,descriptionTxt,scoreTxt,priceTxt;
    private EventsDomain item;
    private ImageView picImg,backBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initView();
        setVariable();
    }
    private void setVariable(){
        item =(EventsDomain) getIntent().getSerializableExtra("object");
        titleTxt.setText(item.getTitle());
        scoreTxt.setText(""+(int) item.getScore());
        priceTxt.setText(""+(int) item.getPrice());
        locationTxt.setText(item.getLocation());
        descriptionTxt.setText(item.getDescription());




        int drawableResId=getResources().getIdentifier(item.getPic(),"drawable",getPackageName());

        Glide.with(this)
                .load(drawableResId)
                .into(picImg);
        backBtn.setOnClickListener(v -> finish());
    }
    private void initView(){
        titleTxt=findViewById(R.id.titleTxt);
        locationTxt=findViewById(R.id.locationTxt);
        descriptionTxt=findViewById(R.id.descriptionTxt);
        scoreTxt=findViewById(R.id.scoreTxt);
        picImg=findViewById(R.id.picImg);
        scoreTxt=findViewById(R.id.scoreTxt);
        priceTxt=findViewById(R.id.priceTxt);
        backBtn=findViewById(R.id.backBtn);

    }
}