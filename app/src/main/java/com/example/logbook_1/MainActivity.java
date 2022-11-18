package com.example.logbook_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

public class MainActivity extends AppCompatActivity {
    Button backward, forward;
    ImageView imageView;
    private String [] imageList;
    private  int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageList = getResources().getStringArray(R.array.images);
        imageView = findViewById(R.id.img_view);
        String url = "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/dog-puppy-on-garden-royalty-free-image-1586966191.jpg";
        backward = findViewById(R.id.backward);
        forward = findViewById(R.id.forward);
    }
    public void previousImage(View view) {
        index++;
        if(index >= imageList.length){
            index = 0;
        }
        loadImage();
    }
    public void nextImage(View view) {
        index --;
        if(index <= -1){
            index = imageList.length - 1;
        }
        loadImage();
    }
    private void loadImage(){
        Glide.with(MainActivity.this)
                .load(imageList[index])
                .apply(new RequestOptions().transform(new CenterCrop()).transform(new RoundedCorners(12)))
                .into(imageView);
    }
}