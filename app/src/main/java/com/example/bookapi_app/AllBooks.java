package com.example.bookapi_app;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AllBooks {
    @SerializedName("totalItems")
    String totalItems;
    @SerializedName("kind")
    String kind;

    @SerializedName("items")
    List<Itemsss> items;

    public List<Itemsss> getItems() {
        return items;
    }

    public String getKind() {
        return kind;
    }

    public  AllBooks(String s)
    {
        this.totalItems=s;
    }

    public String getbooks(){
        return totalItems;
    }

}
