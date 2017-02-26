package com.example.nishthajain.ngosocialcops;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class ActivityMain extends AppCompatActivity {

    static String videoAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        android.os.StrictMode.ThreadPolicy policy = new android.os.StrictMode.ThreadPolicy.Builder().permitAll().build();
        android.os.StrictMode.setThreadPolicy(policy);

    }
    public void playVideoActivity(View view){
        videoAddress = "https://socialcops.com/images/spec/home/header-img-background_video-1920-480.mp4";
        DownloaderClass dc=new DownloaderClass();
        Thread downloadThread=new Thread(dc);
        downloadThread.start();
         Intent intent = new Intent(this, VideoActivity.class);
        // intent.putExtra("videoAddress", videoAddress);
         startActivity(intent);
    }

    public void playVideo(View view) {





    }


}
