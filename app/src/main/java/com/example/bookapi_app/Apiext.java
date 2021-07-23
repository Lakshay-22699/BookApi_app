package com.example.bookapi_app;

import retrofit2.Call;
import retrofit2.http.GET;

public class Apiext implements Api{

    @Override
    public Call<AllBooks> getbooks(String url) {
        return null;
    }
}
