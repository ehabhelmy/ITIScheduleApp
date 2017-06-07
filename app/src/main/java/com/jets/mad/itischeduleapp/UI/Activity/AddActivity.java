package com.jets.mad.itischeduleapp.UI.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.jets.mad.itischeduleapp.R;
import com.jets.mad.itischeduleapp.UI.Adapter.AbstractRecyclerViewAdapter.BaseRecyclerViewAdapter;
import com.jets.mad.itischeduleapp.UI.Presenter.Interface.IAdd;
import com.jets.mad.itischeduleapp.UI.Presenter.classes.AddEventPresenter;

public class AddActivity extends AppCompatActivity implements IAdd.IAddActivity{

    private Button save;
    private Button cancel;
    private AddEventPresenter addEventPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        addEventPresenter = new AddEventPresenter(this);
        save = (Button) findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
            }
        });
        cancel = (Button) findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancel();
            }
        });
    }

    private void save(){
        //TODO : call presenter to connect to web service with the event or session
    }
    private void cancel(){
        finish();
    }

    @Override
    public void setAdapterData(BaseRecyclerViewAdapter adapter) {
        addEventPresenter.setAdapterData(adapter);
    }
}
