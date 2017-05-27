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
import com.jets.mad.itischeduleapp.UI.Activity.HomeActivity;
import com.jets.mad.itischeduleapp.UI.Adapter.DayRecyclerViewAdapter.DayMarker.DayMarkerRecyclerAdapter;
import com.jets.mad.itischeduleapp.UI.Presenter.Interface.IHome;

import java.util.ArrayList;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 */
public class DayFragment extends Fragment{

    //UI References
    private RecyclerView recyclerView;
    private RecyclerView dayMarker;


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
        recyclerView.setAdapter(homeActivity.getAdapter());

        dayMarker = (RecyclerView) rootView.findViewById(R.id.day_list_marker);
        LinearLayoutManager markerLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        dayMarker.setLayoutManager(markerLayoutManager);

        ArrayList<Date> dateArrayList = new ArrayList<>();
        dateArrayList.add(new Date(2015, 20,9));
        dateArrayList.add(new Date(2015, 20,10));
        dateArrayList.add(new Date(2015, 20,11));
        dateArrayList.add(new Date(2015, 20,12));
        dateArrayList.add(new Date(2015, 20,13));
        dateArrayList.add(new Date(2015, 20,14));
        dateArrayList.add(new Date(2015, 20,15));

        dayMarker.setAdapter(new DayMarkerRecyclerAdapter(dateArrayList, R.layout.cell_day_marker));

        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        homeActivity = (HomeActivity) context;

    }


}
