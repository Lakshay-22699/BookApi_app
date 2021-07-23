package com.example.bookapi_app;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Url;

public interface Api {
    @GET()
    Call<AllBooks> getbooks(@Url String url);

}
