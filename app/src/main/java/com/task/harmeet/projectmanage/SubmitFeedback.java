package com.task.harmeet.projectmanage;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by akshar-4 on 3/19/2016.
 */
public class SubmitFeedback extends Activity {

    EditText edtfeedback;
    Button btnsubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        edtfeedback = (EditText) findViewById(R.id.edtfeedback);
        btnsubmit = (Button) findViewById(R.id.btnsubmitfeedback);

        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Toast.makeText(SubmitFeedback.this , " Feedback Send SuccessFully " , Toast.LENGTH_LONG).show();

                edtfeedback.setText("");
            }
        });


    }
}
