package com.jets.mad.itischeduleapp.UI.Fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.jets.mad.itischeduleapp.R;
import com.jets.mad.itischeduleapp.UI.Activity.HomeActivity;
import com.jets.mad.itischeduleapp.UI.Adapter.AbstractRecyclerViewAdapter.onItemClick;
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

        ArrayList<String> dateArrayList = new ArrayList<>();
        dateArrayList.add("Tues 29");
        dateArrayList.add("Wed 30");
        dateArrayList.add("Thur 31");
        dateArrayList.add("Fri 1");
        dateArrayList.add("Sat 2");
        dateArrayList.add("Sun 3");
        dateArrayList.add("Mon 4");

        dayMarker.setAdapter(new DayMarkerRecyclerAdapter(dateArrayList, R.layout.cell_day_marker, new onItemClick() {
            @Override
            public void onItemClick(ArrayList data, int position) {
                Toast.makeText(getActivity(), "" + data.get(position), Toast.LENGTH_SHORT).show();
            }
        }));

        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        homeActivity = (HomeActivity) context;

    }


}
