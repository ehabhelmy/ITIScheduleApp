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
 * Created by ehabm on 6/2/2017.
 */

public class NEventHolder extends BaseViewHolder<Events> implements View.OnClickListener {

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

    public NEventHolder(View itemView, BaseRecyclerViewAdapter adapter) {
        super(itemView);
        this.adapter = (EventAdapter) adapter;
        imageView = (ImageView) itemView.findViewById(R.id.neventImage);
        name = (TextView) itemView.findViewById(R.id.neventName);
        date = (TextView) itemView.findViewById(R.id.neventDate);
        imageButton = (ImageButton) itemView.findViewById(R.id.nimageButton);
        imageButton.setOnClickListener(this);
    }

    public ImageButton getImageButton() {
        return imageButton;
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==imageButton.getId()){
            System.out.println(getAdapterPosition());
            adapter.getEventFragment().register((Events) adapter.getData().get(getAdapterPosition()));
            adapter.getEventFragment().sendEventToRegistered((Events) adapter.getData().get(getAdapterPosition()));
            adapter.getData().remove(getAdapterPosition());
            adapter.notifyItemRemoved(getAdapterPosition());
        }
    }
}
