package com.jets.mad.itischeduleapp.UI.Fragment;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.jets.mad.itischeduleapp.R;
import com.jets.mad.itischeduleapp.UI.Activity.HomeActivity;
import com.jets.mad.itischeduleapp.UI.Adapter.DayList.DayRecyclerViewAdapter;
import com.jets.mad.itischeduleapp.UI.Presenter.Interface.IHome;
import com.jets.mad.itischeduleapp.datalayer.Models.Events;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class DayFragment extends Fragment{

    //UI References
    private RecyclerView recyclerView;


    private IHome.IHomeActivityUI homeActivity;

    public DayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_day, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.day_list);
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLinearLayoutManager);

        recyclerView.setAdapter(homeActivity.getDayAdapter());


        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        homeActivity = (HomeActivity) context;

    }


}
