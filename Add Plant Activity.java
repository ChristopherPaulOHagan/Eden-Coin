package com.example.tree_tracker;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class AddPlantActivity extends BaseActivity {

    private ImageView ivPlantImage;
    private Button btnTakePhoto, btnSavePlant;
    private TextView tvLocation, tvHeight, tvBranches, tvWaterCycles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_plant);

        ivPlantImage = findViewById(R.id.iv_plant_image);
        btnTakePhoto =.findViewById(R.id.btn_take_photo);
        btnSavePlant =findViewById(R.id.btn_save_plant);

        // Location setup
        tvLocation = findViewById(R.id.tv_location);
        updateLocation();

        btnTakePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takePhoto();
            }
        });

        btnSavePlant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savePlantData();
            }
        });
    }

    private void takePhoto() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 1);
    }

    // Implement onActivityResult and other methods here...

    private void updateLocation() {
        // Get location and update tvLocation
        // You'll need to implement the LocationListener and request permissions
    }

    private void savePlantData() {
        // Here you would collect all data points and store them locally or via IPFS
        // For now, we'll just log it
        System.out.println("Save plant data");
    }
}