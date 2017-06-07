package com.jets.mad.itischeduleapp.UI.Fragment;

import android.app.Dialog;
import  android.support.v4.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.jets.mad.itischeduleapp.R;
import com.jets.mad.itischeduleapp.UI.Adapter.MyEventsAdapter.MyEventsAdapter;
import com.jets.mad.itischeduleapp.UI.Presenter.Interface.IAdd;

/**
 * Created by ehabm on 6/6/2017.
 */

public class AddSessionFragment extends DialogFragment {

    private AddEventFragment addEventFragment;
    private RecyclerView eventsList;
    private Button done;
    private MyEventsAdapter myEventsAdapter;
    private IAdd.IAddActivity activity;

    public AddSessionFragment() {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.activity = (IAdd.IAddActivity) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.events_list,container,false);
        done = (Button) view.findViewById(R.id.done);
        eventsList = (RecyclerView) view.findViewById(R.id.allEvents);
        myEventsAdapter = new MyEventsAdapter(R.layout.add_event_cell);
        eventsList.setLayoutManager(new LinearLayoutManager(this.getActivity().getBaseContext()));
        activity.setAdapterData(myEventsAdapter);
        eventsList.setAdapter(myEventsAdapter);
        getDialog().setTitle("Add Session");
        return view;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        return dialog;
    }


}
