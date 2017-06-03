package com.jets.mad.itischeduleapp.UI.Fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.jets.mad.itischeduleapp.R;
import com.jets.mad.itischeduleapp.UI.Activity.MainActivity;
import com.jets.mad.itischeduleapp.UI.Adapter.AbstractRecyclerViewAdapter.onItemClick;
import com.jets.mad.itischeduleapp.UI.Adapter.DayRecyclerViewAdapter.DayData.DayRecyclerAdapter;
import com.jets.mad.itischeduleapp.UI.Adapter.DayRecyclerViewAdapter.DayMarker.DayMarkerRecyclerAdapter;
import com.jets.mad.itischeduleapp.UI.Presenter.Interface.FragmentsCommunicator;
import com.jets.mad.itischeduleapp.UI.Presenter.Interface.IHome;
import com.jets.mad.itischeduleapp.utils.TypeDefinitions.HomeFragments;

import java.util.ArrayList;

import hirondelle.date4j.DateTime;

/**
 * A simple {@link Fragment} subclass.
 */
public class DayFragment extends Fragment implements FragmentsCommunicator.MonthToDayCommunicator {

    //UI References
    private RecyclerView recyclerView;
    private RecyclerView dayMarker;
    private View rootView;

    //Other References
    private DateTime dateTime;
    private DayMarkerRecyclerAdapter dayMarkerRecyclerAdapter;
    private DayRecyclerAdapter dayRecyclerAdapter;
    private IHome.IHomeActivityUI homeActivity;

    public DayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_day, container, false);
        prepareDayDataRecyclerView();
        prepareDayMarkerRecyclerView();

        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        homeActivity = (MainActivity) context;

    }

    /*================================ HELPFUL METHODS =========================================*/
    private void prepareDayMarkerRecyclerView(){
        //day marker recyclerview
        dayMarker = (RecyclerView) rootView.findViewById(R.id.day_list_marker);
        LinearLayoutManager markerLayoutManager
                = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        dayMarker.setLayoutManager(markerLayoutManager);
        dayMarkerRecyclerAdapter = new DayMarkerRecyclerAdapter(R.layout.cell_day_marker);
        homeActivity.setAdapterData(0, dateTime, dayMarkerRecyclerAdapter);
        dayMarker.setAdapter(dayMarkerRecyclerAdapter);
        dayMarkerRecyclerAdapter.setListener(new onItemClick() {
            @Override
            public void onItemClick(ArrayList data, int position) {
                Toast.makeText(getActivity(), "dayMarker clicked", Toast.LENGTH_SHORT).show();

                homeActivity.setAdapterData(1, dateTime, dayRecyclerAdapter);
                dayRecyclerAdapter.notifyDataSetChanged();

            }
        });
    }

    private void prepareDayDataRecyclerView(){
        //day data recyclerview
        recyclerView = (RecyclerView) rootView.findViewById(R.id.day_list);
        TextView id = (TextView) rootView.findViewById(R.id.day_event_id);
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLinearLayoutManager);
        dayRecyclerAdapter = new DayRecyclerAdapter(R.layout.cell_day);
        homeActivity.setAdapterData(1 ,dateTime, dayRecyclerAdapter);
        dayRecyclerAdapter.setListener(new onItemClick() {
            @Override
            public void onItemClick(ArrayList data, int position) {
                Toast.makeText(getActivity(), "dayDetails clicked", Toast.LENGTH_SHORT).show();


                FragmentManager  fm = getFragmentManager();
                // FragmentTransaction ft = fm.beginTransaction();
                DayDetailFragment dFragment = new DayDetailFragment();
                // Show DialogFragment
                dFragment.show(fm, "Dialog Fragment");




                //homeActivity.replaceFragment(HomeFragments.DETAILS);
            }
        });
        recyclerView.setAdapter(dayRecyclerAdapter);
    }

    /*================================ MonthToDayCommunicator Interface =============================*/
    @Override
    public void setDateTime(DateTime dateTime) {
        this.dateTime = dateTime;
    }
}
