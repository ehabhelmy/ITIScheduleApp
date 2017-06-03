package com.jets.mad.itischeduleapp.UI.Presenter.classes;

import com.android.volley.VolleyError;
import com.jets.mad.itischeduleapp.UI.Adapter.AbstractRecyclerViewAdapter.BaseRecyclerViewAdapter;
import com.jets.mad.itischeduleapp.UI.Adapter.EventsAdapter.EventAdapter;
import com.jets.mad.itischeduleapp.UI.Presenter.Interface.IEvent;
import com.jets.mad.itischeduleapp.UI.Presenter.Interface.IHome;
import com.jets.mad.itischeduleapp.datalayer.Caching.DB.EventsTable;
import com.jets.mad.itischeduleapp.datalayer.Models.Events;
import com.jets.mad.itischeduleapp.datalayer.Network.NetworkCallback;
import com.jets.mad.itischeduleapp.datalayer.Network.NetworkHandler;
import com.jets.mad.itischeduleapp.utils.Network.NetworkUtils;
import com.jets.mad.itischeduleapp.utils.Network.URLS;
import com.jets.mad.itischeduleapp.utils.TypeDefinitions.NetworkMethods;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ehabm on 5/31/2017.
 */

public class EventPresenter implements IEvent.IEventPresenter,NetworkCallback {


    public static final int REGEVENTS = 1;
    public static final int NREGEVENTS = 2;
    private IHome.IHomeActivity iHomeActivity;
    private EventsTable eventsTable;
    private EventAdapter eventAdapter;


    public EventPresenter(IHome.IHomeActivity iHomeActivity) {
        this.iHomeActivity = iHomeActivity;
    }

    /***
     * This function is called by the network when it gets data fom backend to set registered events
     ***/
    @Override
    public ArrayList<Events> prepareRegEventAdapter(ArrayList<Events> events) {
        /////////////////////////// raw data ////////////////////////////////
//        events.add(new Events("5/6/2017",null,"MDW",0,"EVENT",1,""));
//        events.add(new Events("19/6/2017",null,"GAME JAM",0,"EVENT",2,""));
//        events.add(new Events("5/8/2017",null,"NASA",0,"EVENT",3,""));
//        return events;

        ////////////////////////// actual data from Database /////////////////
        eventsTable = new EventsTable();
        return (ArrayList<Events>) eventsTable.getBySelection(EventsTable.TYPE + " = ? AND " + EventsTable.REGISTERED + " = ? ",new String[]{"EVENT",Events.REGISTERED} );

    }
    /***
     * This function is called by the network when it gets data fom backend to set Not registered events
     ***/
    @Override
    public ArrayList<Events> prepareNRegEventAdapter(ArrayList<Events> events) {
        /////////////////////////// raw data ////////////////////////////////
//        events.add(new Events("5/4/2017",null,"BUG",0,"EVENT",4,""));
//        events.add(new Events("12/2/2017",null,"FUN DAY",0,"EVENT",5,""));
//        events.add(new Events("22/8/2017",null,"TERBO",0,"EVENT",6,""));
//        return events;

        ////////////////////////// actual data from Database /////////////////
        eventsTable = new EventsTable();
        return (ArrayList<Events>) eventsTable.getBySelection(EventsTable.TYPE + " = ? AND " + EventsTable.REGISTERED + " = ? ",new String[]{"EVENT",Events.NOTREGISTERED} );

    }

    @Override
    public void setAdapterData(int flag, BaseRecyclerViewAdapter adapter) {
        eventAdapter = (EventAdapter) adapter;
        switch (flag){
            case REGEVENTS :
                adapter.setData(prepareRegEventAdapter(new ArrayList<Events>()));
                break;
            default:
                adapter.setData(prepareNRegEventAdapter(new ArrayList<Events>()));
        }
    }
    @Override
    public void registerEvent(Events events){
        if (NetworkUtils.isConnected()){
            Map<String,String> params = new HashMap<>();
            params.put("eventId",String.valueOf(events.getId()));
            params.put("flag","register");
            NetworkHandler.callWebService(URLS.REGISTER_URL, NetworkMethods.GET,params,this);
        }
    }
    @Override
    public void  unregisterEvent(Events events){
        if (NetworkUtils.isConnected()){
            Map<String,String> params = new HashMap<>();
            params.put("eventId",String.valueOf(events.getId()));
            params.put("flag","unregister");
            NetworkHandler.callWebService(URLS.REGISTER_URL, NetworkMethods.GET,params,this);
        }
    }

    @Override
    public void onSuccess(String response) {
        /// response should be json containing the event after updating in the backend
        /// then update database
        /// eventsTable.update(event)
    }

    @Override
    public void onError(VolleyError volleyError) {
        /// show error message ///
    }
}
