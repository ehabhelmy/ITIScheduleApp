package com.jets.mad.itischeduleapp.UI.Adapter.AbstractRecyclerViewAdapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.jets.mad.itischeduleapp.datalayer.Models.BaseModel;


public abstract class BaseViewHolder<T extends BaseModel> extends RecyclerView.ViewHolder {

    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void configure(T baseModel);
}
