package com.disney.disneyproject.DTO;

import com.disney.disneyproject.entities.Character;
import com.disney.disneyproject.entities.Gender;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MovieDTO {


    private long pkMovieId;
    private String image;
    private String title;
    private Date date;
    @Max(value = 5, message = "The Rating is betwen 1 - 5")
    @Min(value = 1,message = "The Rating is betwen 1-5")
    private int rating;




    public MovieDTO(){

    }

    public MovieDTO(long pkMovieId, String image, String title, Date date, int rating, Gender genders) {
        this.pkMovieId = pkMovieId;
        this.image = image;
        this.title = title;
        this.date = date;
        this.rating = rating;

    }

    public long getPkMovieId() {
        return pkMovieId;
    }

    public void setPkMovieId(long pkMovieId) {
        this.pkMovieId = pkMovieId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

}
