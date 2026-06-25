package com.example.tree_tracker;

import android.app.Application;
import android.util.Log;

public class TreeTrackerApplication extends Application {

    private static final String TAG = "TreeTracker";

    @Override
    public void onCreate() {
        super.onCreate();
        // Initialize logging and any global dependencies here
        Log.d(TAG, "App initialized");
    }
}
