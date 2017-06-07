package com.jets.mad.itischeduleapp.UI.Fragment;


import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.TimePicker;

import com.jets.mad.itischeduleapp.R;
import com.jets.mad.itischeduleapp.UI.Adapter.MyEventsAdapter.MyEventsAdapter;
import com.jets.mad.itischeduleapp.UI.Presenter.Interface.IAdd;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import hirondelle.date4j.DateTime;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddEventFragment extends Fragment implements IAdd.IAddFragment{

    private EditText eventName;
    private TextView startDate;
    private TextView endDate;
    private TextView startTime;
    private TextView endTime;
    private EditText description;
    private Calendar calendar,calendar2;
    private int year, month, day, hours, minutes;
    private long EventStart, EventEnd;
    private String sessionDescription = "";
    private Button done;
    private IAdd.IAddActivity activity;
    private AddSessionFragment addSessionFragment;


    public AddEventFragment() {
        // Required empty public constructor
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.activity = (IAdd.IAddActivity) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_event, container, false);
        calendar = Calendar.getInstance();
        calendar2=Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        hours = calendar.get(Calendar.HOUR_OF_DAY);
        minutes = calendar.get(Calendar.MINUTE);
        eventName = (EditText) view.findViewById(R.id.nEvent);
        startDate = (TextView) view.findViewById(R.id.startDate);
        endDate = (TextView) view.findViewById(R.id.endDate);
        startTime = (TextView) view.findViewById(R.id.startTime);
        endTime = (TextView) view.findViewById(R.id.endTime);
        description = (EditText) view.findViewById(R.id.descripe);
        eventName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSessionView();
            }
        });
        startDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(AddEventFragment.this.getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        String myFormat = "MMM dd, yyyy";
                        SimpleDateFormat sdformat = new SimpleDateFormat(myFormat);
                        calendar.set(Calendar.YEAR, year);
                        calendar.set(Calendar.MONTH, month);
                        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                        startDate.setText(sdformat.format(calendar.getTime()));
                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });
        endDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(AddEventFragment.this.getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        String myFormat = "MMM dd, yyyy";
                        SimpleDateFormat sdformat = new SimpleDateFormat(myFormat);
                        calendar2.set(Calendar.YEAR, year);
                        calendar2.set(Calendar.MONTH, month);
                        calendar2.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                        endDate.setText(sdformat.format(calendar2.getTime()));
                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });
        startTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(AddEventFragment.this.getContext(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                        calendar.set(Calendar.MINUTE, minute);
                        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
                        startTime.setText(timeFormat.format(calendar.getTime()));
                    }
                }, hours, minutes, false);
                timePickerDialog.show();
            }
        });
        endTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(AddEventFragment.this.getContext(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        calendar2.set(Calendar.HOUR_OF_DAY, hourOfDay);
                        calendar2.set(Calendar.MINUTE, minute);
                        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
                        endTime.setText(timeFormat.format(calendar2.getTime()));
                    }
                }, hours, minutes, false);
                timePickerDialog.show();
            }
        });
        return view;
    }

    @Override
    public long getStartDate() {
        return calendar.getTimeInMillis();
    }

    @Override
    public long getEndDate() {
        return calendar2.getTimeInMillis();
    }

    @Override
    public String getEventDescritpion() {
        return description.getText().toString();
    }

    @Override
    public String getSessionDescription() {
        return sessionDescription;
    }

    private void openSessionView(){
        addSessionFragment = new AddSessionFragment();
        addSessionFragment.show(getFragmentManager(),"Session");
    }
}
