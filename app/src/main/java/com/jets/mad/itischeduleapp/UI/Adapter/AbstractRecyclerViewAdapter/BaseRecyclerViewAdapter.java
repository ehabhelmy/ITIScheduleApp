package com.jets.mad.itischeduleapp.UI.Adapter.AbstractRecyclerViewAdapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;

public abstract class BaseRecyclerViewAdapter<T> extends RecyclerView.Adapter<BaseViewHolder> {

    protected ArrayList<T> data;

    public BaseRecyclerViewAdapter(){
    }

    public ArrayList<T> getData(){
        return data;
    }

    @Override
    public abstract BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType);

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        if(data != null) {
            holder.configure(data.get(position));
        }else{
            //TODO: throw exception
        }
    }


    @Override
    public int getItemCount() {
        return data.size();
    }


    public void setData(ArrayList<T> data){
        this.data = data;
    }
}

