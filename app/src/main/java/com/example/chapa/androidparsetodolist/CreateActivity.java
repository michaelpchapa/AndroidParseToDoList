package com.example.chapa.androidparsetodolist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class CreateActivity extends ActionBarActivity {

    private TextView txtName;
    private TextView txtDescription;
    private String name;
    private String description;
    private Button btnCreate;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        txtName = (TextView) findViewById(R.id.txtName);
        txtDescription = (TextView) findViewById(R.id.txtDescription);

        btnCreate = (Button) findViewById(R.id.btnCreate);
        btnCreate.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {

                name = txtName.getText().toString();
                description = txtDescription.getText().toString();

                if (name.equals("") && description.equals("")) {
                    Toast.makeText(getApplicationContext(),
                            "Please enter name and description",
                            Toast.LENGTH_LONG).show();

                } else {
                    ParseObject task = new ParseObject("Task");
                    task.put("name", name);
                    task.put("description", description);
                    task.saveInBackground();

                    Intent listActivity = new Intent(getApplicationContext(), ListActivity.class);
                    startActivity(listActivity);
                }

            }
        });

        btnBack = (Button) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {

                Intent listActivity = new Intent(getApplicationContext(), ListActivity.class);
                startActivity(listActivity);

            }
        });
    }

}
