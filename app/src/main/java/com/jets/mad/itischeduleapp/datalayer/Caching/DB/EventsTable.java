package com.jets.mad.itischeduleapp.datalayer.Caching.DB;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.jets.mad.itischeduleapp.datalayer.Models.BaseModel;
import com.jets.mad.itischeduleapp.datalayer.Models.Events;

/**
 * Created by ehabm on 6/2/2017.
 */

public class EventsTable extends AbstractTable<Events> {

    public static final String EVENTTABLE = "event_table";
    public static final String EVENT_ID = "event_id";
    public static final String EVENT_NAME = "event_name";
    public static final String EVENT_START = "event_start";
    public static final String EVENT_END = "event_end";
    public static final String EVENT_COLOR = "event_color";
    public static final String TYPE = "event_type";
    public static final String REGISTERED = "registered";



    @Override
    protected String getTableName() {
        return EVENTTABLE;
    }

    @Override
    protected Events getModelFromCursor(Cursor cursor) {
        Events events = new Events();
        events.setId(cursor.getInt(0));
        events.setEventName(cursor.getString(1));
        events.setStartTime(cursor.getString(2));
        events.setEndTime(cursor.getString(3));
        events.setColor(cursor.getInt(4));
        events.setType(cursor.getString(5));
        events.setRegister(cursor.getString(6));
        return events;
    }

    @Override
    protected ContentValues getContentValuesFromModel(BaseModel baseModel) {
        ContentValues values = new ContentValues();
        Events events = (Events) baseModel;
        values.put(EVENT_ID,events.getId());
        values.put(EVENT_NAME,events.getEventName());
        values.put(EVENT_START,events.getStartTime());
        values.put(EVENT_END,events.getEndTime());
        values.put(EVENT_COLOR,events.getColor());
        values.put(TYPE,events.getType());
        values.put(REGISTERED,events.getRegister());
        return values;
    }

    @Override
    protected void createTable(SQLiteDatabase db) {
        String CREATE_EVENTS_TABLE = "CREATE TABLE " + getTableName() + "("
                + EVENT_ID + " INTEGER PRIMARY KEY, " + EVENT_NAME + " TEXT,"
                + EVENT_START + " TEXT," + EVENT_END +" TEXT,"+ EVENT_COLOR +" INTEGER,"+ TYPE +" TEXT,"+ REGISTERED +" TEXT "+")";
        System.out.println(CREATE_EVENTS_TABLE);
        db.execSQL(CREATE_EVENTS_TABLE);
    }

    /** CRUD OPERATIONS **/

    public void insert(Events events){
        dataBaseManager.getDb().insert(getTableName(),null,getContentValuesFromModel(events));
    }
    public void update(Events events){
        dataBaseManager.getDb().update(getTableName(),getContentValuesFromModel(events),EVENT_ID + " = ? ",new String[]{String.valueOf(events.getId())});
    }
    public void delete(int id){
        dataBaseManager.getDb().delete(getTableName(),EVENT_ID + " = ? ",new String[]{String.valueOf(id)});
    }
}
