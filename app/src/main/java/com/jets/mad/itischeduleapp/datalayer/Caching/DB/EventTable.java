package com.jets.mad.itischeduleapp.datalayer.Caching.DB;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.jets.mad.itischeduleapp.datalayer.Models.BaseModel;
import com.jets.mad.itischeduleapp.datalayer.Models.Event;
import com.jets.mad.itischeduleapp.datalayer.Models.Events;

/**
 * Created by lenovo on 6/7/2017.
 */

public class EventTable extends AbstractTable<Event> {

    public static final String TABLE_NAME = "events_table";
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String DESCRIPTION = "description";
    public static final String REGISTERED = "registered";

    @Override
    protected String getTableName() {
        return TABLE_NAME;
    }

    @Override
    protected Event getModelFromCursor(Cursor cursor) {
        Event event = new Event();
        event.setId(cursor.getInt(0));
        event.setName(cursor.getString(1));
        event.setDescription(cursor.getString(2));
        return event;
    }

    @Override
    protected ContentValues getContentValuesFromModel(BaseModel baseModel) {
        ContentValues values = new ContentValues();

        Event event = (Event) baseModel;
        values.put(ID,event.getId());
        values.put(NAME,event.getName());
        values.put(DESCRIPTION,event.getDescription());
        values.put(REGISTERED,event.getRegister());

        return values;
    }

    @Override
    protected void createTable(SQLiteDatabase db) {
        String CREATE_TABLE_QUERY
                = "CREATE TABLE " + getTableName()+ "("
                + ID + " INTEGER PRIMARY KEY, "
                + NAME + " TEXT,"
                + DESCRIPTION + " TEXT,"
                + REGISTERED + " INTEGER)";

        db.execSQL(CREATE_TABLE_QUERY);
    }

    /** CRUD OPERATIONS **/

    public void insert(Event event){
        dataBaseManager.getDb().insert(getTableName(),null,getContentValuesFromModel(event));
    }
    public void update(Event event){
        dataBaseManager.getDb()
                        .update(getTableName(),getContentValuesFromModel(event)
                                ,ID + " = ? ",new String[]{String.valueOf(event.getId())});
    }
    public void delete(int id){
        dataBaseManager.getDb()
                        .delete(getTableName()
                                ,ID + " = ? ",new String[]{String.valueOf(id)});
    }
}
