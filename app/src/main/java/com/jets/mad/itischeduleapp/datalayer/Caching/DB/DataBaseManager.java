package com.jets.mad.itischeduleapp.datalayer.Caching.DB;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.jets.mad.itischeduleapp.AppController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ehabm on 5/15/2017.
 */

public class DataBaseManager extends SQLiteOpenHelper {

    /**
     * name of the database file
     */
    private static final String DATABASE_NAME = "ScheduleApp";
    /**
     * database version that should be incremented if there is any structural changes
     */
    private static final int DATABASE_VERSION = 1;
    /**
     * List of registered tables in the application
     */
    private List<AbstractTable> dbTables;

    private static DataBaseManager instance;
    private SQLiteDatabase db;

    private DataBaseManager() {
        super(AppController.getInstance(), DATABASE_NAME, null, DATABASE_VERSION);
        dbTables = new ArrayList<>();
    }

    public void initializeTables() {
        //call your tables here
        EventsTable eventsTable = new EventsTable();
        addTable(eventsTable);
    }
    public static synchronized DataBaseManager getInstance(){
        if (instance == null){
            instance = new DataBaseManager();
        }
        return instance;
    }

    public void addTable(AbstractTable table){
        dbTables.add(table);
    }

    public SQLiteDatabase getDb(){
        if (db == null){
            db = getWritableDatabase();
        }
        return db;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            initializeTables();
            for (AbstractTable table : dbTables) {
                System.out.println("ana d5lt gwa el tables");
                table.createTable(db);
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {
            for (AbstractTable table : dbTables) {
                dropTable(db, table.getTableName());
                onCreate(db);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void dropTable(SQLiteDatabase db, String table) {
        db.execSQL("DROP TABLE IF EXISTS " + table + ";");
    }
}
