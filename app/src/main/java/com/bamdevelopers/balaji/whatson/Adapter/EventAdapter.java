package com.bamdevelopers.balaji.whatson.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bamdevelopers.balaji.whatson.Adapter.ViewHolder.EventViewHolder;
import com.bamdevelopers.balaji.whatson.Model.Event;
import com.bamdevelopers.balaji.whatson.R;
import com.bamdevelopers.balaji.whatson.View.Activity.EventActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Balaji on 31-12-2017.
 */
public class EventAdapter extends RecyclerView.Adapter<EventViewHolder>{

    private Map<String ,Event> eventMap;
    private Context context;
    private List<Event> eventList = new ArrayList<>();

    public EventAdapter(Map<String, Event> eventMap,Context context) {
        this.eventMap = eventMap;
        this.context = context;
        setHasStableIds(true);
        for (Map.Entry<String, Event> entry : eventMap.entrySet())
        {
            eventList.add(entry.getValue());
        }
    }

    @Override
    public EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_single_event,parent,false);
        final EventViewHolder result= new EventViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Event event=eventList.get(result.getAdapterPosition());
                Intent intent = new Intent(context, EventActivity.class);
                intent.putExtra("event",event);
                intent.putExtra("pos",result.getAdapterPosition());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
        return result;
    }

    @Override
    public void onBindViewHolder(EventViewHolder holder, int position) {
        holder.loaddata(eventList.get(position),context);
    }

    @Override
    public int getItemCount() {
        return eventMap.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}

