package com.jets.mad.itischeduleapp.UI.Presenter.Interface;

import com.jets.mad.itischeduleapp.UI.Adapter.AbstractRecyclerViewAdapter.BaseRecyclerViewAdapter;
import com.jets.mad.itischeduleapp.datalayer.Models.Events;

import java.util.ArrayList;

/**
 * Created by ehabm on 5/31/2017.
 */

public interface IEvent {

    public interface IEventPresenter{
        public ArrayList<Events> prepareRegEventAdapter(ArrayList<Events> events);
        public ArrayList<Events> prepareNRegEventAdapter(ArrayList<Events> events);
        public void setAdapterData(int flag, BaseRecyclerViewAdapter adapter);
        public void registerEvent(Events events);
        public void unregisterEvent(Events events);
    }

    interface IEventActivity{
        public IEventPresenter getEventPresenter();
        public void setEventAdapterData(int flag, BaseRecyclerViewAdapter adapter);
    }
}
