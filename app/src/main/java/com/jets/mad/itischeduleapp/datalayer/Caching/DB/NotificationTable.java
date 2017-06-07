package com.jets.mad.itischeduleapp.datalayer.Caching.DB;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.jets.mad.itischeduleapp.datalayer.Models.BaseModel;
import com.jets.mad.itischeduleapp.datalayer.Models.Events;
import com.jets.mad.itischeduleapp.datalayer.Models.Notification;

/**
 * Created by lenovo on 6/6/2017.
 */

public class NotificationTable extends AbstractTable<Notification> {

    public static final String TABLE_NAME = "notification_table";
    public static final String ID = "id";
    public static final String TITLE = "title";
    public static final String DETAILS = "details";
    public static final String TYPE = "type";
    public static final String TIME = "time";

    @Override
    protected String getTableName() {
        return TABLE_NAME;
    }

    @Override
    protected Notification getModelFromCursor(Cursor cursor) {
        return null;
    }

    @Override
    protected ContentValues getContentValuesFromModel(BaseModel baseModel) {
        return null;
    }

    @Override
    protected void createTable(SQLiteDatabase db) {

        String CREATE_TABLE_QUERY
                = "CREATE TABLE " + getTableName()+ "("
                                + ID + " INTEGER PRIMARY KEY, "
                                + TITLE + " TEXT,"
                                + DETAILS + " TEXT,"
                                + TIME +" TEXT)";

        db.execSQL(CREATE_TABLE_QUERY);
    }

    /** CRUD OPERATIONS **/

    public void insert(Notification notification){
        dataBaseManager.getDb().insert(getTableName(),null,getContentValuesFromModel(notification));
    }
    public void update(Notification notification){
        dataBaseManager.getDb()
                .update(getTableName(),getContentValuesFromModel(notification)
                        ,ID + " = ? ",new String[]{String.valueOf(notification.getId())});
    }
    public void delete(int id){
        dataBaseManager.getDb()
                .delete(getTableName()
                        ,ID + " = ? ",new String[]{String.valueOf(id)});
    }
}
