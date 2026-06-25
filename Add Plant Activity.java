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

public class AddPlantActivity extends BaseActivity {

    private ImageView ivPlantImage;
    private Button btnTakePhoto, btnSavePlant;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_plant);

        ivPlantImage = findViewById(R.id.iv_plant_image);
        btnTakePhoto = findViewById(R.id.btn_take_photo);
        btnSavePlant = findViewById(R.id.btn_save_plant);

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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            ivPlantImage.setImageBitmap(imageBitmap);

            // Here you can save the image to storage or upload it
        }
    }

    private void savePlantData() {
        // Implement logic to collect plant data and store it locally
        // For now, just show a simple toast message
        // You would need to add EditText fields for height, branches, water cycles, etc.
        // Also, you'll need to get the current location and save that data
    }
}
