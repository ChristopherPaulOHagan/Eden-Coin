package com.example.tree_tracker;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends BaseActivity {

    private Button btnAddPlant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAddPlant = findViewById(R.id.btn_add_plant);
        btnAddPlant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AddPlantActivity.class));
            }
        });

        // Request permissions if not already granted
        if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED ||
            checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED
||
            checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) !=
PackageManager.PERMISSION_GRANTED) {

            requestPermissions(new String[]{
                Manifest.permission.CAMERA,
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            }, 1);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == 1) {
            // Check if all permissions are granted
            boolean cameraGranted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
            boolean locationGranted = grantResults[1] == PackageManager.PERMISSION_GRANTED;
            boolean storageGranted = grantResults[2] == PackageManager.PERMISSION_GRANTED;

            if (!cameraGranted || !locationGranted || !storageGranted) {
                // Handle permission denial here
                finish();
            }
        }
    }
}
