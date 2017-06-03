package com.jets.mad.itischeduleapp.UI.Adapter.EventsAdapter;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.jets.mad.itischeduleapp.R;
import com.jets.mad.itischeduleapp.UI.Adapter.AbstractRecyclerViewAdapter.BaseRecyclerViewAdapter;
import com.jets.mad.itischeduleapp.UI.Adapter.AbstractRecyclerViewAdapter.BaseViewHolder;
import com.jets.mad.itischeduleapp.datalayer.Models.Events;

/**
 * Created by ehabm on 5/31/2017.
 */

public class EventHolder extends BaseViewHolder<Events> implements View.OnClickListener {

    private ImageView imageView;
    private TextView name;
    private TextView date;
    private ImageButton imageButton;
    private EventAdapter adapter;
    @Override
    public void configure(Events events) {
        //imageView.setImageURI();
        name.setText(events.getEventName());
        date.setText(events.getStartTime());
    }

    public EventHolder(View itemView,BaseRecyclerViewAdapter adapter) {
        super(itemView);
        this .adapter = (EventAdapter) adapter;
        imageView = (ImageView) itemView.findViewById(R.id.EventImage);
        name = (TextView) itemView.findViewById(R.id.eventName);
        date = (TextView) itemView.findViewById(R.id.eventDate);
        imageButton = (ImageButton) itemView.findViewById(R.id.imageButton);
        imageButton.setOnClickListener(this);
    }

    public ImageButton getImageButton() {
        return imageButton;
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==imageButton.getId()){
            System.out.println(getAdapterPosition());
//            adapter.getData().remove(getAdapterPosition());
//            adapter.notifyItemRemoved(getAdapterPosition());
            adapter.getEventFragment().register((Events) adapter.getData().get(getAdapterPosition()));
        }
    }
}
