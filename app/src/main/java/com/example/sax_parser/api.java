package com.example.sax_parser;

import retrofit2.Call;
import retrofit2.http.GET;

public interface api {



    @GET("xml/simple.xml")
    Call<breakfast_menu> get_all();




}
