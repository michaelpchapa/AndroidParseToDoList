package com.example.chapa.androidparsetodolist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.chapa.androidparsetodolist.model.Task;
import com.example.chapa.androidparsetodolist.model.TaskAdapter;
import com.parse.FindCallback;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.text.ParseException;
import java.util.ArrayList;

public class ListActivity extends ActionBarActivity {

    private Button btnCreate;
    private Button btnUpdate;
    private TaskAdapter adapter;
    private ArrayList<Task> arrayOfTasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout.activity_list);

        btnCreate = (Button) findViewById(R.id.btnCreate);
        btnCreate.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {

                Intent createActivity = new Intent(getApplicationContext(), CreateActivity.class);
                startActivity(createActivity);

            }
        });
arrayOfTasks = new ArrayList<Task>();
        adapter = new TaskAdapter(this, arrayOfTasks);
        ListView listView = (ListView) findViewById(R.id.lv_task);
        listView.setAdapter(adapter);

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Task");

        query.findInBackground(new FindCallback<ParseObject>(){
                                  public void done(List<ParseObject> taskList, ParseException e){
                                      if (e == null){
                                          for (ParseObject tasks : taskList){
                                              Task task = new Task();

                                              task.setTaskId(task.getObjectId());
                                              task.setName(task.getString("name"));

                                              Log.d("name", task.getName());
                                              adapter.add(task);
                                          }
                                      }else {
                                          Toast.makeText(getApplicationContext(),"Error:" + e.getMessage(),Toast.LENGTH_LONG).show();
                                      }
                                  }
                               });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Task task = adapter.getItem(position);

                Intent intent = new Intent(getBaseContext(), UpdateActivity.class);
                intent.putExtra("ObjectId", task.getTaskId());
                startActivity(intent);
            }
        });
        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        btnUpdate.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {

                Intent updateActivity = new Intent(getApplicationContext(), UpdateActivity.class);
                startActivity(updateActivity);

            }
        });
    }
}
