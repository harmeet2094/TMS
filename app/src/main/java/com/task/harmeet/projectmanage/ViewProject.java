package com.task.harmeet.projectmanage;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class ViewProject extends ActionBarActivity {

    SQLiteDatabase db;
    ListView list_projectlist;

    List listProject = new ArrayList();
    List listClientName = new ArrayList<>();
    List listContactno = new ArrayList<>();
    List listDevname = new ArrayList<>();
    List listAboutName = new ArrayList<>();
    List listAmount = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_project);

        CreateDB();

        list_projectlist = (ListView) findViewById(R.id.list_projectlist);

          Cursor c = db.rawQuery("select * from Project", null);
                c.moveToFirst();
                String d = "";
                do {
                    d = d + c.getString(0) + "," + c.getString(1) + "," + c.getString(2) + "," + c.getString(3) + "," + c.getString(4) + " ," + c.getString(5) + "\n";
                    listProject.add(c.getString(0));
                    listClientName.add(c.getString(1));
                    listDevname.add(c.getString(2));

                    listContactno.add(c.getString(3));
                    listAmount.add(c.getString(4));
                    listAboutName.add(c.getString(5));

                } while (c.moveToNext());

              /*  TextView t = (TextView) findViewById(R.id.textViewAddProject);
                t.setText("" + d);*/

                 listProject.size();

                Log.v("log", " listTask Size " + listProject.size() + " Slected Data Project ==> " + d);

                Toast.makeText(ViewProject.this, "Display Projects!!", Toast.LENGTH_SHORT).show();

        list_projectlist.setAdapter(new ArrayAdapter<String>(ViewProject.this, android.R.layout.simple_list_item_1, listProject));

        list_projectlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Log.v("log", " Contact Number ==> " + listContactno.get(position));
                Log.v("log", " Amount ==> " + listAmount.get(position));
                Log.v("log", " AboutName ==> " + listAboutName.get(position));

                Log.v("log", " Project Name ==> " + listProject.get(position));
                Log.v("log", " ClientName ==> " + listClientName.get(position));
                Log.v("log", " Devname ==> " + listDevname.get(position));

                Intent intDetails = new Intent(ViewProject.this , ProjectDetailsActivity.class);
                intDetails.putExtra("pro_name", listProject.get(position) + "");
                intDetails.putExtra("cli_name" , listClientName.get(position)+"");
                intDetails.putExtra("dev_name" , listDevname.get(position)+"");

                intDetails.putExtra("con_name" , listContactno.get(position)+"");
                intDetails.putExtra("amount_name" , listAmount.get(position)+"");
                intDetails.putExtra("about_name" , listAboutName.get(position)+"");
                startActivity(intDetails);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_view_project, menu);
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
        db.execSQL("create table if not exists Project(projectname text primary key,clientname text,devname text,contactno number,amount text,aboutname text);");
     //   Toast.makeText(ViewProject.this, "Database Created!!", Toast.LENGTH_SHORT).show();
    }
}
