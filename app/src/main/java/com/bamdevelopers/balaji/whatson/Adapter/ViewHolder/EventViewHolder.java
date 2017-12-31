package com.bamdevelopers.balaji.whatson.Adapter.ViewHolder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bamdevelopers.balaji.whatson.Model.Event;
import com.bamdevelopers.balaji.whatson.R;
import com.bumptech.glide.Glide;

import butterknife.BindView;

/**
 * Created by Balaji on 31-12-2017.
 */

public class EventViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    @BindView(R.id.iv_event_image)
    private ImageView imageviewEvent;
    @BindView(R.id.tv_event_start)
    private TextView textViewDateStart;
    @BindView(R.id.tv_event_name)
    private TextView textviewEventName;

    public EventViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);

        imageviewEvent          = itemView.findViewById(R.id.iv_event_image);
        textViewDateStart       = itemView.findViewById(R.id.tv_event_start);
        textviewEventName       = itemView.findViewById(R.id.tv_event_name);
    }
    public void loaddata(Event event, Context context)
    {
        String s = String.valueOf(event.getStartDate());
        Glide.with(context).load(event.getImg_url()).into(imageviewEvent);
        textViewDateStart.setText(event.getStartDate());
        textviewEventName.setText(event.getEvent_name());
    }
    @Override
    public void onClick(View v) {

    }
}
