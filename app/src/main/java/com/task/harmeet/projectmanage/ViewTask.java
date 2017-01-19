package com.task.harmeet.projectmanage;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class ViewTask extends ActionBarActivity {

    SQLiteDatabase db;
    ListView list_tasklist;

    List listTask = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_task);

        CreateDB();

                Cursor c = db.rawQuery("select * from Task", null);
                c.moveToFirst();
                String d = "";
                do {
                    d = d + c.getString(0) + "," + c.getString(1) + "," + c.getString(2) + "," + c.getString(3) +"\n";
                    listTask.add(c.getString(0));
                } while (c.moveToNext());

        list_tasklist = (ListView) findViewById(R.id.list_tasklist);
        listTask.size();

        Log.v("log", " listTask Size " + listTask.size() + " Slected Data Project ==> " + d);

        Toast.makeText(ViewTask.this, "Display Task!!", Toast.LENGTH_SHORT).show();

        list_tasklist.setAdapter(new ArrayAdapter<String>(ViewTask.this, android.R.layout.simple_list_item_1, listTask));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_view_task, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void CreateDB()
    {
        db=this.openOrCreateDatabase("ProjectManagement.db", MODE_PRIVATE, null);
        db.execSQL("create table if not exists Task(clientname text primary key,taskname text,assigntask text,abouttask text);");
     //   Toast.makeText(ViewTask.this, "Database Created!!", Toast.LENGTH_SHORT).show();
    }


}
