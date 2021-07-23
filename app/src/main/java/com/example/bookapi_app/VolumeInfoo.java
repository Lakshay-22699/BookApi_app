package com.example.bookapi_app;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class VolumeInfoo {
    @SerializedName("title")
    String title;
    @SerializedName("description")
    String desc;
    @SerializedName("authors")
    String[] authors;
    @SerializedName("imageLinks")
    Imagelinkss imagelinkss;


    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public String[] getAuthors() {
        return authors;
    }

    public Imagelinkss getImagelinkss() {
        return imagelinkss;
    }

    public VolumeInfoo(String title, String desc, String[] authors, Imagelinkss imagelinkss) {
        this.title = title;
        this.desc = desc;
        this.authors = authors;
        this.imagelinkss = imagelinkss;
    }
}
