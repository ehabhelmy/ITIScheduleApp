package com.jets.mad.itischeduleapp.UI.Fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jets.mad.itischeduleapp.R;
import com.jets.mad.itischeduleapp.UI.Adapter.EventsAdapter.EventAdapter;
import com.jets.mad.itischeduleapp.UI.Presenter.Interface.IEvent;
import com.jets.mad.itischeduleapp.UI.Presenter.classes.EventPresenter;
import com.jets.mad.itischeduleapp.datalayer.Models.Events;

/**
 * A simple {@link Fragment} subclass.
 */
public class EventFragment extends Fragment {

    private RecyclerView notRegisteredEvents;
    private RecyclerView registeredEvents;
    private IEvent.IEventActivity homeActivity;


    public EventFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.homeActivity = (IEvent.IEventActivity) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_event, container, false);
        prepareRegEventRecycleView(view);
        prepareNRegEventRecycleView(view);
        return view;
    }

    private void prepareRegEventRecycleView(View view) {
        registeredEvents = (RecyclerView) view.findViewById(R.id.regEvents);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        registeredEvents.setLayoutManager(linearLayoutManager);
        EventAdapter eventAdapter = new EventAdapter(R.layout.event_cell,this);
        homeActivity.setEventAdapterData(EventPresenter.REGEVENTS,eventAdapter);
        registeredEvents.setAdapter(eventAdapter);
    }

    private void prepareNRegEventRecycleView(View view) {
        notRegisteredEvents = (RecyclerView) view.findViewById(R.id.nregEvents);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        notRegisteredEvents.setLayoutManager(linearLayoutManager);
        EventAdapter eventAdapter = new EventAdapter(R.layout.notregistered_event_cell,this);
        homeActivity.setEventAdapterData(EventPresenter.NREGEVENTS,eventAdapter);
        notRegisteredEvents.setAdapter(eventAdapter);
    }

    public void register(Events events){
        homeActivity.getEventPresenter().registerEvent(events);
    }
    public void unregister(Events events){
        homeActivity.getEventPresenter().unregisterEvent(events);
    }

    public void sendEventToRegistered(Events events){
        EventAdapter eventAdapter = (EventAdapter) registeredEvents.getAdapter();
        eventAdapter.getData().add(events);
        eventAdapter.notifyItemInserted(eventAdapter.getItemCount()-1);
    }
    public void sendEventToUnregistered(Events events){
        EventAdapter eventAdapter = (EventAdapter) notRegisteredEvents.getAdapter();
        eventAdapter.getData().add(events);
        eventAdapter.notifyItemInserted(eventAdapter.getItemCount()-1);
    }

}
