package com.bamdevelopers.balaji.whatson.View.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bamdevelopers.balaji.whatson.Adapter.EventAdapter;
import com.bamdevelopers.balaji.whatson.Presenter.EventPresenter;
import com.bamdevelopers.balaji.whatson.R;
import com.bamdevelopers.balaji.whatson.View.EventView;


public class MainActivity extends AppCompatActivity implements EventView {

    RecyclerView recyclerViewEvent;
    private EventPresenter eventPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerViewEvent = findViewById(R.id.recyclerview_event);
    }

    @Override
    protected void onStart() {
        super.onStart();
        eventPresenter = new EventPresenter(this,getApplicationContext());
        recyclerViewEvent.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }

    @Override
    public void setPresenter(EventPresenter presenter) {
        eventPresenter = presenter;
    }

    @Override
    public void showNetworkError() {

    }

    @Override
    public void setAdapter(EventAdapter eventAdapter) {
        recyclerViewEvent.setAdapter(eventAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        eventPresenter.start();
    }
}
