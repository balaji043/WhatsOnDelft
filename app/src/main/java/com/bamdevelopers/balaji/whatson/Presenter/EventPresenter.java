package com.bamdevelopers.balaji.whatson.Presenter;

import android.content.Context;
import android.support.annotation.NonNull;

import com.bamdevelopers.balaji.whatson.Adapter.EventAdapter;
import com.bamdevelopers.balaji.whatson.Model.Event;
import com.bamdevelopers.balaji.whatson.Model.WebService.ApiClient;
import com.bamdevelopers.balaji.whatson.Model.WebService.ApiInterface;
import com.bamdevelopers.balaji.whatson.View.EventView;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Balaji on 31-12-2017.
 */

public class EventPresenter implements IEventPresenter
{
    private EventView eventView;
    private Context context;
    private Map<String,Event> eventMap;

    public EventPresenter(EventView eventView, Context context) {
        this.eventView = eventView;
        eventView.setPresenter(this);
        this.context = context;
    }

    @Override
    public void start() {
        reloadData();
    }

    @Override
    public void onAddItemClicked() {
    }

    @Override
    public void reloadData() {
        ApiInterface apiService = ApiClient.getRetrofit().create(ApiInterface.class);
        Call<Map<String,Event>> call = apiService.getAllEvent();
        call.enqueue(new Callback<Map<String, Event>>() {
            @Override
            public void onResponse(@NonNull Call<Map<String, Event>> call, @NonNull Response<Map<String, Event>> response) {
                eventMap = response.body();
                eventView.setAdapter(new EventAdapter(eventMap,context));
            }

            @Override
            public void onFailure(@NonNull Call<Map<String, Event>> call, @NonNull Throwable t) {
                eventView.showNetworkError();

            }
        });

    }

    @Override
    public void onItemClicked(Event event) {
    }

    @Override
    public void onAboutClicked() {
    }
}

