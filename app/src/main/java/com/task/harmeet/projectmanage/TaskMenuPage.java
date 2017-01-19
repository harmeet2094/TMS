package com.task.harmeet.projectmanage;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;


public class TaskMenuPage extends ActionBarActivity {

    LinearLayout buttonAddproject;
    LinearLayout buttonAddTask;

    LinearLayout buttonviewProject;
    LinearLayout buttonViewtask;

    Button send_feedback;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_menu_page);

        buttonAddproject = (LinearLayout) findViewById(R.id.buttonAddproject);
        buttonAddTask = (LinearLayout) findViewById(R.id.buttonAddtask);
        buttonviewProject = (LinearLayout) findViewById(R.id.buttonview);
        buttonViewtask = (LinearLayout) findViewById(R.id.buttonViewtask);
        send_feedback = (Button) findViewById(R.id.send_feedback);

        buttonAddproject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intAddproject = new Intent(TaskMenuPage.this , AddProject.class);
                startActivity(intAddproject);

            }
        });

        buttonAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intAddTask = new Intent(TaskMenuPage.this , AddTask.class);
                startActivity(intAddTask);

            }
        });

        buttonviewProject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intViewProject = new Intent(TaskMenuPage.this , ViewProject.class);
                startActivity(intViewProject);

            }
        });

        buttonViewtask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intViewTask = new Intent(TaskMenuPage.this , ViewTask.class);
                startActivity(intViewTask);

            }
        });

        send_feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            Intent intFeedBackPage = new Intent(TaskMenuPage.this , SubmitFeedback.class);
            startActivity(intFeedBackPage);



            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_task_menu_page, menu);
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
