package com.task.harmeet.projectmanage;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by akshar-4 on 4/5/2016.
 */
public class ProjectDetailsActivity extends Activity {

    TextView txt_selected_project_name , txt_selected_client_name , txt_selected_dev_name;
    TextView txt_selected_ammount , txt_selected_about , txt_selected_contactNumber;

    String strProName , strCliName, strDevName , strAmmount , strAboutName , strContactNumer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.project_details_activity);

        strProName = getIntent().getStringExtra("pro_name");
        strCliName = getIntent().getStringExtra("cli_name");
        strDevName = getIntent().getStringExtra("dev_name");

        strContactNumer = getIntent().getStringExtra("con_name");
        strAmmount = getIntent().getStringExtra("amount_name");
        strAboutName = getIntent().getStringExtra("about_name");

        Log.v("log", " Details Contact Number ==> " + strContactNumer);
        Log.v("log", " Details Amount ==> " + strAmmount);
        Log.v("log", " Details AboutName ==> " + strAboutName);

        Log.v("log", " Details Project Name ==> " + strProName);
        Log.v("log", " Details ClientName ==> " + strCliName);
        Log.v("log", " Details Devname ==> " + strDevName);


        txt_selected_project_name = (TextView) findViewById(R.id.txt_selected_project_name);
        txt_selected_project_name.setText(strProName);

        txt_selected_client_name = (TextView) findViewById(R.id.txt_selected_client_name);
        txt_selected_client_name.setText(strCliName);

        txt_selected_dev_name = (TextView) findViewById(R.id.txt_selected_deve_name);
        txt_selected_dev_name.setText(strDevName);



        txt_selected_ammount = (TextView) findViewById(R.id.txt_selected_ammount_name);
        txt_selected_ammount.setText(strAmmount);

        txt_selected_about = (TextView) findViewById(R.id.txt_selected_about);
        txt_selected_about.setText(strAboutName);

        txt_selected_contactNumber = (TextView) findViewById(R.id.txt_selected_contact_number);
        txt_selected_contactNumber.setText(strContactNumer);

    }
}
