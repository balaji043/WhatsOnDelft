package com.bamdevelopers.balaji.whatson.Model.WebService;

import com.bamdevelopers.balaji.whatson.Model.Event;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Balaji on 31-12-2017.
 */

public interface ApiInterface {
    @GET("/Events.json")
    Call<Map<String, Event>> getAllEvent();
}