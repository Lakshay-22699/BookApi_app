package com.example.bookapi_app;
import retrofit2.Call;
import retrofit2.http.GET;
public interface Api {
    String BASE_URL = "https://www.googleapis.com/books/v1/";
    static String s = null;
    @GET("volumes?q=Good")
    Call<AllBooks> getbooks();


}
