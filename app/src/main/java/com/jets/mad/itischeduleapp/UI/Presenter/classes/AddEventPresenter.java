package com.jets.mad.itischeduleapp.UI.Presenter.classes;

import com.jets.mad.itischeduleapp.UI.Adapter.AbstractRecyclerViewAdapter.BaseRecyclerViewAdapter;
import com.jets.mad.itischeduleapp.UI.Adapter.MyEventsAdapter.MyEventsAdapter;
import com.jets.mad.itischeduleapp.UI.Presenter.Interface.IAdd;
import com.jets.mad.itischeduleapp.datalayer.Caching.DB.EventsTable;
import com.jets.mad.itischeduleapp.datalayer.Models.Events;

import java.util.ArrayList;

/**
 * Created by ehabm on 6/5/2017.
 */

public class AddEventPresenter implements IAdd.IAddPresenter {

    private IAdd.IAddActivity activity;
    private MyEventsAdapter myEventsAdapter;
    private EventsTable eventsTable;

    public AddEventPresenter(IAdd.IAddActivity activity) {
        this.activity = activity;
    }

    @Override
    public void addEvent(Events events) {

    }

    @Override
    public void addSession(Events events) {

    }

    @Override
    public void setAdapterData(BaseRecyclerViewAdapter adapter) {
        myEventsAdapter = (MyEventsAdapter) adapter;
        myEventsAdapter.setData(prepareAllEvents(new ArrayList<Events>()));
    }

    private ArrayList<Events> prepareAllEvents(ArrayList<Events> events){
        eventsTable = new EventsTable();
        return (ArrayList<Events>) eventsTable.getBySelection(EventsTable.TYPE + " = ? ",new String[]{"EVENT"} );
    }
}
