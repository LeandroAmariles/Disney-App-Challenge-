package com.disney.disneyproject.DTO;

import java.util.Date;

public class MovieFilter {

    private String image;
    private String Tituo;
    private Date date;

    public MovieFilter(){

    }

    public MovieFilter(String image, String tituo, Date date) {
        this.image = image;
        Tituo = tituo;
        this.date = date;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTituo() {
        return Tituo;
    }

    public void setTituo(String tituo) {
        Tituo = tituo;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

