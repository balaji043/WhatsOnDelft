package com.bamdevelopers.balaji.whatson.View.Activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bamdevelopers.balaji.whatson.Adapter.EventAdapter;
import com.bamdevelopers.balaji.whatson.Model.Event;
import com.bamdevelopers.balaji.whatson.Presenter.EventPresenter;
import com.bamdevelopers.balaji.whatson.R;
import com.bamdevelopers.balaji.whatson.View.EventView;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.BindView;


public class EventActivity extends AppCompatActivity implements EventView{

    private static final String TAG   = "SingleActivity" ;
    private static final String place = "Place  : ";
    private static final String start = "Starts : ";
    private static final String end   = "Ends   : ";
    private static final String cost  = "Cost   : ";

    @BindView(R.id.iv_main_image)
    ImageView imageViewMain;
    @BindView(R.id.iv_main_goBack)
    ImageView imageViewGoBack;

    @BindView(R.id.tv_main_title)
    TextView textViewTitle;
    @BindView(R.id.tv_main_name)
    TextView textViewName;
    @BindView(R.id.tv_main_place)
    TextView textViewPlace;
    @BindView(R.id.tv_main_start)
    TextView textViewStart;
    @BindView(R.id.tv_main_end)
    TextView textViewEnd;
    @BindView(R.id.tv_main_cost)
    TextView textViewCost;
    @BindView(R.id.tv_main_about)
    TextView textViewAbout;
    @BindView(R.id.tv_main_route)
    TextView textViewRoute;

    @BindView(R.id.bt_main_route)
    Button buttonTickets;
    @BindView(R.id.bt_main_share)
    Button buttonShare;
    @BindView(R.id.bt_main_route)
    Button buttonRoute;

    Map<String ,Event> eventMap;
    Context context;
    int position;
    String dateFormat = "dd/MM/yyyy";
    List<Event> eventList = new ArrayList<>();
    public void data(){
        for (Map.Entry<String, Event> entry : eventMap.entrySet())
        {
            eventList.add(entry.getValue());
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        textViewTitle       =   findViewById(R.id.tv_main_title);
        textViewName        =   findViewById(R.id.tv_main_name);
        textViewPlace       =   findViewById(R.id.tv_main_place);
        textViewStart       =   findViewById(R.id.tv_main_start);
        textViewEnd         =   findViewById(R.id.tv_main_end);
        textViewCost        =   findViewById(R.id.tv_main_cost);
        textViewAbout       =   findViewById(R.id.tv_main_about);
        textViewRoute       =   findViewById(R.id.tv_main_route);
        buttonTickets       =   findViewById(R.id.bt_main_tickets);
        buttonShare         =   findViewById(R.id.bt_main_share);
        buttonRoute         =   findViewById(R.id.bt_main_route);
        imageViewMain       =   findViewById(R.id.iv_main_image);
        imageViewGoBack     =   findViewById(R.id.iv_main_goBack);

        context = getApplicationContext();
        position = getIntent().getIntExtra("pos",0);

        try {
            if(getIntent().getExtras().getParcelable("event") != null) {
                final Event event = getIntent().getExtras().getParcelable("event");
                loaddata(event);
            }
        }catch (Exception e){
            Log.d(TAG, "onCreate: "+e.toString());
        }
        imageViewGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void loaddata(final Event event) {

        textViewTitle.setText(event.getEvent_name());
        textViewName.setText(event.getEvent_name());
        textViewPlace.setText(String.format("%s%s", place, event.getAddress()));
        textViewStart.setText(String.format("%s%s",start,event.getStartDate()));
        textViewEnd.setText(String.format("%s%s",end,event.getEnd_date()));
        textViewCost.setText(String.format("%s%s", cost, event.getPrice()));
        textViewAbout.setText(event.getAbout_event());
        textViewRoute.setText(event.getAddress());
        Glide.with(context).load(event.getImg_url()).into(imageViewMain);

        buttonTickets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(event.getWebsite()));
                startActivity(intent);
            }
        });
        buttonTickets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse(event.getWebsite()));
                startActivity(intent);
            }
        });
        buttonShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT,event.getEvent_name());
                intent.putExtra(Intent.EXTRA_TEXT,event.getWebsite());
                startActivity(Intent.createChooser(intent,"choose one"));

            }
        });
        buttonRoute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public void showNetworkError() {
    }

    @Override
    public void setAdapter(EventAdapter eventAdapter) {
    }

    @Override
    public void setPresenter(EventPresenter presenter) {
    }

}
