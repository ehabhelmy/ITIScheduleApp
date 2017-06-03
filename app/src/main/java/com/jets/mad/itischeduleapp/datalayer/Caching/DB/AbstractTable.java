package com.jets.mad.itischeduleapp.datalayer.Caching.DB;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.jets.mad.itischeduleapp.datalayer.Models.BaseModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ehabm on 5/13/2017.
 */

public abstract class AbstractTable<T extends BaseModel> {

    protected DataBaseManager dataBaseManager;
    protected abstract String getTableName();

    protected abstract T getModelFromCursor(Cursor cursor);

    protected abstract ContentValues getContentValuesFromModel(BaseModel baseModel);

    protected abstract void createTable(SQLiteDatabase db);

    protected AbstractTable(){
        dataBaseManager = DataBaseManager.getInstance();
    }

    public List<T> getBySelection(String selection,String[] args){
        Cursor cursor = DataBaseManager.getInstance().getDb().query(getTableName(),null,selection,args,null,null,null);
        List<T> items = new ArrayList<>();
        if (cursor != null && cursor.getCount()>0){
            cursor.moveToFirst();
           while (!cursor.isAfterLast()){
               T baseModel = getModelFromCursor(cursor);
               items.add(baseModel);
               cursor.moveToNext();
           }
        }
        if (cursor != null){
            cursor.close();
        }
        return items;
    }

}
