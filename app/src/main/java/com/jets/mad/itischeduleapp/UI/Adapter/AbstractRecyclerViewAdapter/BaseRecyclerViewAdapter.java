package com.jets.mad.itischeduleapp.UI.Adapter.AbstractRecyclerViewAdapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.jets.mad.itischeduleapp.datalayer.Models.BaseModel;

import java.util.ArrayList;

public abstract class BaseRecyclerViewAdapter extends RecyclerView.Adapter<BaseViewHolder>{

    ArrayList<? extends BaseModel> data;

    public BaseRecyclerViewAdapter(ArrayList<? extends BaseModel> data){
        this.data = data;
    }

    @Override
    public abstract BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType);

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.configure(data.get(position));
    }


    @Override
    public int getItemCount() {
        return data.size();
    }
}

