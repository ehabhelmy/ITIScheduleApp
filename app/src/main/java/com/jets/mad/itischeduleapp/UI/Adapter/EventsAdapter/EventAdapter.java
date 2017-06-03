package com.jets.mad.itischeduleapp.UI.Adapter.EventsAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jets.mad.itischeduleapp.R;
import com.jets.mad.itischeduleapp.UI.Adapter.AbstractRecyclerViewAdapter.BaseRecyclerViewAdapter;
import com.jets.mad.itischeduleapp.UI.Adapter.AbstractRecyclerViewAdapter.BaseViewHolder;
import com.jets.mad.itischeduleapp.UI.Fragment.EventFragment;

/**
 * Created by ehabm on 5/31/2017.
 */

public class EventAdapter<Events> extends BaseRecyclerViewAdapter {

    private int eventCellId;
    private EventFragment eventFragment;

    public EventAdapter(int eventCellId, EventFragment eventFragment) {
        super();
        this.eventCellId = eventCellId;
        this.eventFragment = eventFragment;
    }


    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(eventCellId,parent,false);
        if (eventCellId == R.layout.event_cell){
            EventHolder eventHolder = new EventHolder(view,this);
            return eventHolder;
        }else {
            NEventHolder neventHolder = new NEventHolder(view,this);
            return neventHolder;
        }
    }

    public EventFragment getEventFragment() {
        return eventFragment;
    }
}
