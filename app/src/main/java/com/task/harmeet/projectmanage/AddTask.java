package com.task.harmeet.projectmanage;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class AddTask extends ActionBarActivity {

    Button buttonSave;

    //String[] strProjectName = {"project1","project2","project3"};

    List<String> listProjectName = new ArrayList<String>();

    Spinner edt_task_client_name;
    EditText textTaskName;

    EditText editTextAssignTask;

    EditText editDateTime;
    EditText editAboutText;



    TextView textViewAddTask;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        CreateDB();

        buttonSave = (Button) findViewById(R.id.buttonSave);

        textViewAddTask = (TextView) findViewById(R.id.textViewAddTask);

        editDateTime = (EditText) findViewById(R.id.editDateTime);

        edt_task_client_name = (Spinner) findViewById(R.id.edt_task_client_name);
        textTaskName = (EditText) findViewById(R.id.editTextTask);

        editTextAssignTask = (EditText) findViewById(R.id.editTextAssignTask);
        editDateTime = (EditText) findViewById(R.id.editDateTime);

        editAboutText = (EditText) findViewById(R.id.editTextAbouttask);

        Cursor c = db.rawQuery("select * from Project", null);
        c.moveToFirst();
        String d = "";

        if(c != null)
        {
            if(c.getString(0) != null)
            {
                do {
                    //  d = d + c.getString(0) + "," + c.getString(1) + "," + c.getString(2) + "," + c.getString(3) + "," + c.getString(4) + " ," + c.getString(5) + "\n";
                    listProjectName.add(c.getString(0));
                } while (c.moveToNext());

                edt_task_client_name.setAdapter(new ArrayAdapter<String>(AddTask.this , android.R.layout.simple_list_item_1 , android.R.id.text1 , listProjectName));
            }else{
                Toast.makeText(AddTask.this , " Please add at list one Project From Add project Tab.." , Toast.LENGTH_LONG).show();

            }
        }

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                db.execSQL("insert into Task values( '" + edt_task_client_name.getSelectedItem().toString() + "', '" + textTaskName.getText().toString() + "','" + editTextAssignTask.getText().toString() + "','" + editAboutText.getText().toString() + "');");
                Toast.makeText(AddTask.this, "Record inserted!!", Toast.LENGTH_SHORT).show();
                textTaskName.setText("");
                editTextAssignTask.setText("");
                editDateTime.setText("");


            }
        });

    }

    public void CreateDB()
    {
        db=this.openOrCreateDatabase("ProjectManagement.db", MODE_PRIVATE, null);
        db.execSQL("create table if not exists Project(projectname text primary key,clientname text,devname text,contactno number,amount text,aboutname text);");
        db.execSQL("create table if not exists Task(clientname text primary key,taskname text,assigntask text,abouttask text);");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_task, menu);
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
}
