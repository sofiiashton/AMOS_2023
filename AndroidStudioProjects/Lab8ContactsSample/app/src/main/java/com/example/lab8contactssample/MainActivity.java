package com.example.lab8contactssample;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.provider.ContactsContract;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends ListActivity {
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lv = getListView();
        get(getListView());


    }

    public void get(View v){
        Cursor cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                null, null, null, null);
        startManagingCursor(cursor);
        String[] from = {ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME, ContactsContract.CommonDataKinds.Phone.NUMBER,
                ContactsContract.CommonDataKinds.Phone._ID};
        int[] to = {R.id.contact_name, R.id.contact_number};
        SimpleCursorAdapter simpleCursorAdapter = new SimpleCursorAdapter(this, R.layout.list_item, cursor, from , to);
        lv.setAdapter(simpleCursorAdapter);
        lv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

    }
}