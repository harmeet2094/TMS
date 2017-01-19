package com.task.harmeet.projectmanage;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class RegisterActivity extends ActionBarActivity {

    SQLiteDatabase db;

    Button buttonsave;
    Button buttonCancel;

    EditText edtusername;
    EditText edtpass;
    EditText edtconfpass;
    EditText edtdob;


    String struname,strpass,strconpass,strdob;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        CreateDB();

        buttonCancel = (Button) findViewById(R.id.buttonCancel);
        buttonsave = (Button) findViewById(R.id.buttonRegister);

        edtusername = (EditText) findViewById(R.id.txtusername);
        edtpass = (EditText) findViewById(R.id.editText3);
        edtconfpass = (EditText) findViewById(R.id.txtconpass);
        edtdob = (EditText) findViewById(R.id.txtdob);

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();

            }
        });

        buttonsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                struname = edtusername.getText().toString();
                strpass = edtpass.getText().toString();

                strconpass = edtconfpass.getText().toString();
                strdob = edtdob.getText().toString();

                if(!edtusername.getText().toString().equals("") && !edtpass.getText().toString().equals("") && !edtconfpass.getText().toString().equals("") && !edtdob.getText().toString().equals(""))
                {
                    edtusername.setText("");
                    edtpass.setText("");
                    edtconfpass.setText("");
                    edtdob.setText("");

                    Intent intentregisterActivity = new Intent(RegisterActivity.this , TaskMenuPage.class);
                    startActivity(intentregisterActivity);
                    db.execSQL("insert into Register values('" + struname + "','" + strpass + "', '" + strconpass + "'  ,'" + strdob + "');");
                    Toast.makeText(RegisterActivity.this, "Register Successfully!!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                   Toast.makeText(RegisterActivity.this , "PLease insert all Filed First.." , Toast.LENGTH_LONG).show();
                }

/*
                db.execSQL("insert into Register values('" + struname + "','" + strpass + "', '" + strconpass + "'  ,'" + strdob + "');");
                Toast.makeText(RegisterActivity.this, "Register Successfully!!", Toast.LENGTH_SHORT).show();
*/

                edtusername.setText("");
                edtpass.setText("");
                edtconfpass.setText("");
                edtdob.setText("");

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity2, menu);
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

    public void CreateDB(){

        db=this.openOrCreateDatabase("ProjectManagement.db", MODE_PRIVATE, null);
        db.execSQL("create table if not exists Register(username text,password text,confirmpass text,dob text);");
    }
}
