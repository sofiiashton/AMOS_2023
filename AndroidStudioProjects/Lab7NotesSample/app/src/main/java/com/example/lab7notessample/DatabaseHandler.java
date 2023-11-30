package com.example.lab7notessample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final String DB_NAME = "course_db";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "mycourses";
    private static final String ID_COL = "_id";
    private static final String KEY_NAME = "name";
    private static final String DURATION_COL = "duration";
    private static final String DESCRIPTION_COL = "description";
    private static final String TRACKS_COL = "tracks";
    public DatabaseHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + KEY_NAME + " TEXT) ";
        ;
        db.execSQL(query);
    }

    public void addNewCourse(String courseName) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, courseName);
        db.insert(TABLE_NAME, null, values);
        Log.d("CUSTOM_TAG", "CALLED!");
        db.close();
    }

    // Get User Details
    public ArrayList<HashMap<String, String>> GetRows(){
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<HashMap<String, String>> userList = new ArrayList<>();
        String query = "SELECT name FROM "+ TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);
        return  userList;
    }

    public void DeleteRow(int userid){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, ID_COL+" = ?",new String[]{String.valueOf(userid)});
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}