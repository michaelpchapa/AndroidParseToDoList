package com.example.chapa.androidparsetodolist.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Chapa on 11/9/2015.
 */
public class TaskAdapter extends ArrayAdapter<Task> {

    public TaskAdapter(Context context, ArrayList<Task> tasks) {
        super(context, 0, tasks);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Task task = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.layout.item_task, parent, false);
        }
        TextView txtName = (TextView) convertView.findViewById(R.id.id.txtName);
        txtName.setText(task.name);
        return convertView;
    }
}{
}
