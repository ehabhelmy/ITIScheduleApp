package com.jets.mad.itischeduleapp.UI.Fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jets.mad.itischeduleapp.R;
import com.jets.mad.itischeduleapp.UI.Activity.HomeActivity;
import com.jets.mad.itischeduleapp.UI.Presenter.Interface.IHome;

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

        dayMarker = (RecyclerView) rootView.findViewById(R.id.day_list_marker);
        LinearLayoutManager markerLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        dayMarker.setLayoutManager(markerLayoutManager);

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        recyclerView.setAdapter(homeActivity.getAdapter(1));
        dayMarker.setAdapter(homeActivity.getAdapter(0));


    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        homeActivity = (HomeActivity) context;

    }

}
