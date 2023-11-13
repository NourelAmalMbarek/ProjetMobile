package com.example.tripsmodule.Domains;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "events")
public class EventsDomain implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "title")
    private String title ;
    @ColumnInfo(name = "location")
    private String location;
    @ColumnInfo(name = "description")
    private String description;

    @ColumnInfo(name = "score")
    private double score ;
    @ColumnInfo(name = "pic")
    private String pic;

    @ColumnInfo(name = "price")
    private int price;

    public EventsDomain(String title, String location, String description, double score, String pic, int price) {
        this.title = title;
        this.location = location;
        this.description = description;
        this.score = score;
        this.pic = pic;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
