package com.task.harmeet.projectmanage;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    Button buttonSignin;
    TextView textViewRegistration;
    TextView textViewForgetPassword;

    EditText edt_usernameEditText , edt_passwordEditText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonSignin = (Button) findViewById(R.id.buttonSignin);
        textViewRegistration = (TextView) findViewById(R.id.textViewRegistration);
        textViewForgetPassword = (TextView) findViewById(R.id.textViewForgetPassword);

        edt_usernameEditText = (EditText) findViewById(R.id.edt_username);
        edt_passwordEditText = (EditText) findViewById(R.id.edt_password);

        buttonSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.v("log", " Password " + edt_passwordEditText.getText().toString());
                Log.v("log"," Edittext " + edt_usernameEditText.getText().toString());

                if(!edt_usernameEditText.getText().toString().equals("") && !edt_passwordEditText.getText().toString().equals(""))
                {
                    edt_usernameEditText.setText("");
                    edt_passwordEditText.setText("");
                    Intent intentMainActivty = new Intent(MainActivity.this , TaskMenuPage.class);
                    startActivity(intentMainActivty);
                }else{
                    Toast.makeText(MainActivity.this , "PLease insert all Filed First.." , Toast.LENGTH_LONG).show();
                }
            }
        });

        textViewRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentMainActivty = new Intent(MainActivity.this , RegisterActivity.class);
                startActivity(intentMainActivty);
            }
        });

        textViewForgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentMainActivty = new Intent(MainActivity.this , ForgotActivity.class);
                startActivity(intentMainActivty);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
