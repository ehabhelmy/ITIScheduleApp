package com.jets.mad.itischeduleapp.UI.Presenter.Interface;

import com.jets.mad.itischeduleapp.UI.Adapter.AbstractRecyclerViewAdapter.BaseRecyclerViewAdapter;
import com.jets.mad.itischeduleapp.datalayer.Models.Events;

import hirondelle.date4j.DateTime;

/**
 * Created by ehabm on 6/5/2017.
 */

public interface IAdd {
    interface IAddPresenter{
        public void addEvent(Events events);
        public void addSession(Events events);
        public void setAdapterData(BaseRecyclerViewAdapter adapter);
    }
    interface IAddFragment{
        public long getStartDate();
        public long getEndDate();
        public String getEventDescritpion();
        public String getSessionDescription();
    }
    interface IAddActivity{
        public void setAdapterData(BaseRecyclerViewAdapter adapter);
    }
}
