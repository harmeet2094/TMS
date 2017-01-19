package com.task.harmeet.projectmanage;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by akshar-4 on 4/2/2016.
 */
public class ForgotActivity extends Activity {

    EditText edtUserName , edtPass , edtConfirm;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot_layout);

        edtUserName = (EditText) findViewById(R.id.edt_username);
        edtPass = (EditText) findViewById(R.id.edt_password);
        edtConfirm = (EditText) findViewById(R.id.edt_confirm_password);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(ForgotActivity.this , "Changed SuccessFully" , Toast.LENGTH_LONG).show();

                edtConfirm.setText("");
                edtUserName.setText("");
                edtPass.setText("");

            }
        });
    }
}
