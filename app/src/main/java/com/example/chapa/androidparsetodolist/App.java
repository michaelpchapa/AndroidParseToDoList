package com.example.chapa.androidparsetodolist;

/**
 * Created by Chapa on 11/9/2015.
 */
import android.app.Application;

import com.parse.Parse;


public class App extends Application {

    @Override public void onCreate() {
        super.onCreate();


        Parse.initialize(this, "GCb2oPNR3NKLb8rDEprDzXu8fCCZmeqyzhmAOCMI", "KqIKdJpKPAa4IIdckMy3xGqyaloi5rI1CUiNJ2Wb"); // Your Application ID and Client Key are defined elsewhere
    }
}