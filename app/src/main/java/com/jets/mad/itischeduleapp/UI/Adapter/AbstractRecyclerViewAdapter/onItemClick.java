package com.jets.mad.itischeduleapp.UI.Adapter.AbstractRecyclerViewAdapter;

import java.util.ArrayList;

/**
 * Created by lenovo on 5/27/2017.
 */

public interface onItemClick<T> {

       void onItemClick(ArrayList<T> data, int position);


}
