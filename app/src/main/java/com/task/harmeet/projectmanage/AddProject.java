package com.task.harmeet.projectmanage;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class AddProject extends ActionBarActivity {

    SQLiteDatabase db;


    Button buttonSave;
    Button buttonBack;

    EditText edtprojname;
    EditText edtmobno;
    EditText edtcliname;
    EditText edtdevname;
    EditText edtamount;
    EditText abouproj;

    TextView textViewAddProject;


    String strProName , strMonNo , strCliName , strdevName , strAmountName , strAboutProj ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_project);

        CreateDB();

        buttonSave = (Button) findViewById(R.id.btnsave);
        buttonBack = (Button) findViewById(R.id.btnback);

        edtprojname = (EditText) findViewById(R.id.edt_proname);
        edtmobno = (EditText) findViewById(R.id.edtmnumber);

        edtcliname = (EditText) findViewById(R.id.edtclname);
        edtdevname = (EditText) findViewById(R.id.edtdevname);

        edtamount = (EditText) findViewById(R.id.edtamount);
        abouproj = (EditText) findViewById(R.id.edtabproj);

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();

            }
        });

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                strProName = edtprojname.getText().toString();
                strMonNo = edtmobno.getText().toString();

                strCliName = edtcliname.getText().toString();
                strdevName = edtdevname.getText().toString();

                strAmountName = edtamount.getText().toString();
                strAboutProj = abouproj.getText().toString();

                db.execSQL("insert into Project values('" + strProName + "','" + strCliName + "', '" + strdevName + "'  ,'" + strMonNo + "' , '" + strAmountName + "','" + strAboutProj + "');");
                Toast.makeText(AddProject.this, "Record inserted!!", Toast.LENGTH_SHORT).show();

                edtprojname.setText("");
                edtmobno.setText("");
                edtcliname.setText("");
                edtdevname.setText("");
                edtamount.setText("");
                abouproj.setText("");

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_project, menu);
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
       // Toast.makeText(AddProject.this, "Database Created!!", Toast.LENGTH_SHORT).show();
    }


    /**
     *
     *    add.setOnClickListener(new View.OnClickListener()
     {
     @Override
     public void onClick(View v)
     {
     EditText name=(EditText)findViewById(R.id.ed_Name);
     EditText address=(EditText)findViewById(R.id.ed_Address);
     EditText contactno=(EditText)findViewById(R.id.ed_Contactno);
     EditText gender=(EditText)findViewById(R.id.ed_Gender);
     db.execSQL("insert into login values('" + name.getText().toString() + "','" + address.getText().toString() + "','" + contactno.getText().toString() + "','" + gender.getText().toString() + "');");
     Toast.makeText(MainActivity.this, "Record inserted!!", Toast.LENGTH_SHORT).show();
     }
     });

     display.setOnClickListener(new View.OnClickListener()
     {
     @Override
     public void onClick(View v)
     {
     Cursor c=db.rawQuery("select * from login", null);
     c.moveToFirst();
     String d="";
     do
     {
     d = d +c.getString(0)+  ","  +c.getString(1)+  ","  +c.getString(2)+ "," +c.getString(3) + "\n";
     }while(c.moveToNext());

     TextView t=(TextView)findViewById(R.id.tv_display);
     t.setText("" + d);
     Toast.makeText(MainActivity.this, "Display Record!!", Toast.LENGTH_SHORT).show();
     }
     });

     update.setOnClickListener(new View.OnClickListener()
     {
     @Override
     public void onClick(View v)
     {
     EditText name=(EditText)findViewById(R.id.ed_Name);
     EditText address=(EditText)findViewById(R.id.ed_Address);
     EditText contactno=(EditText)findViewById(R.id.ed_Contactno);
     EditText gender=(EditText)findViewById(R.id.ed_Gender);
     db.execSQL("update login set name='" + name.getText().toString() + "',address='" + address.getText().toString() + "',gender='"+gender.getText().toString()+"' where ContactNo=" + contactno.getText().toString() + "");
     Toast.makeText(MainActivity.this, "Record updated!!", Toast.LENGTH_SHORT).show();
     }
     });

     delete.setOnClickListener(new View.OnClickListener()
     {
     @Override
     public void onClick(View v)
     {
     EditText ContactNo=(EditText)findViewById(R.id.ed_Contactno);
     db.execSQL("delete from login where(name="+ContactNo.getText().toString()+")");
     Toast.makeText(MainActivity.this, "Record deleted!!", Toast.LENGTH_SHORT).show();
     }
     });

     *
     *
     */




}
