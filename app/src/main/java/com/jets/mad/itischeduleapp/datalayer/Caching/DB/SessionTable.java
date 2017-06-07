package com.jets.mad.itischeduleapp.datalayer.Caching.DB;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.jets.mad.itischeduleapp.datalayer.Models.BaseModel;
import com.jets.mad.itischeduleapp.datalayer.Models.Events;
import com.jets.mad.itischeduleapp.datalayer.Models.Session;

/**
 * Created by lenovo on 6/7/2017.
 */

public class SessionTable extends AbstractTable<Session> {
    public static final String TABLE_NAME = "session_table";
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String START_DATE = "start_date";
    public static final String END_DATE = "end_date";
    public static final String ROOM = "room";
    public static final String TOTAL_SESSION_NUM = "total_session_num";
    public static final String SESSION_NUM = "session_num";
    public static final String DESCRIPTION = "description";
    public static final String TYPE = "type";
    public static final String EVENT_ID = "event_id";


    @Override
    protected String getTableName() {
        return TABLE_NAME;
    }

    @Override
    protected Session getModelFromCursor(Cursor cursor) {

        Session session = new Session();
        session.setId(cursor.getInt(0));
        session.setName(cursor.getString(1));
        session.setStartDate(cursor.getLong(2));
        session.setEndDate(cursor.getLong(3));
        session.setRoom(cursor.getInt(4));
        session.setTotalNumOfSession(cursor.getInt(5));
        session.setSessionNum(cursor.getInt(6));
        session.setDescription(cursor.getString(7));
        session.setSessionType(cursor.getString(8));
        session.setEventID(cursor.getInt(9));

        return session;
    }

    @Override
    protected ContentValues getContentValuesFromModel(BaseModel baseModel) {
        ContentValues values = new ContentValues();
        Session session = (Session) baseModel;

        values.put(ID,session.getId());
        values.put(NAME,session.getName());
        values.put(START_DATE,session.getStartDate());
        values.put(END_DATE,session.getEndDate());
        values.put(ROOM,session.getRoom());
        values.put(TOTAL_SESSION_NUM,session.getTotalNumOfSession());
        values.put(SESSION_NUM,session.getSessionNum());
        values.put(DESCRIPTION,session.getDescription());
        values.put(TYPE,session.getSessionType());
        values.put(EVENT_ID,session.getEventID());

        return values;
    }

    @Override
    protected void createTable(SQLiteDatabase db) {
        String CREATE_TABLE_QUERY
                = "CREATE TABLE " + getTableName()+ "("
                + ID + " INTEGER PRIMARY KEY, "
                + NAME + " TEXT,"
                + START_DATE + " INTEGER,"
                + END_DATE + " INTEGER,"
                + ROOM + " INTEGER,"
                + TOTAL_SESSION_NUM + " INTEGER,"
                + SESSION_NUM + " INTEGER,"
                + DESCRIPTION + " TEXT,"
                + TYPE + " TEXT,"
                + EVENT_ID + " INTEGER)";

        db.execSQL(CREATE_TABLE_QUERY);
    }

    /** CRUD OPERATIONS **/

    public void insert(Session session){
        dataBaseManager.getDb().insert(getTableName(),null,getContentValuesFromModel(session));
    }
    public void update(Session session){
        dataBaseManager.getDb()
                .update(getTableName(),getContentValuesFromModel(session)
                        ,ID + " = ? ",new String[]{String.valueOf(session.getId())});
    }
    public void delete(int id){
        dataBaseManager.getDb()
                .delete(getTableName()
                        ,ID + " = ? ",new String[]{String.valueOf(id)});
    }
}
