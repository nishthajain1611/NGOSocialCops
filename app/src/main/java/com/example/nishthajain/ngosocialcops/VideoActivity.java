package com.example.nishthajain.ngosocialcops;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.File;

public class VideoActivity extends AppCompatActivity implements SurfaceHolder.Callback, MediaPlayer.OnPreparedListener {

    private MediaPlayer mediaPlayer;
    private SurfaceHolder vidHolder;
    private SurfaceView vidSurface;
    private String videoAddress;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

       // Intent intent = getIntent();
     //   videoAddress = intent.getStringExtra("videoAddress");

        vidSurface = (SurfaceView) findViewById(R.id.surfaceView);
        textView = (TextView) findViewById(R.id.textView2);
        textView.setVisibility(View.VISIBLE);

        vidHolder = vidSurface.getHolder();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        vidHolder.addCallback(this);





    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        textView.setVisibility(View.INVISIBLE);
        vidHolder.setFixedSize(vidSurface.getWidth(),mediaPlayer.getVideoHeight()*vidSurface.getWidth()/mediaPlayer.getVideoWidth());
        Toast.makeText(getApplicationContext(),String.valueOf(mediaPlayer.getDuration()),Toast.LENGTH_LONG).show();


    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        try {


            mediaPlayer = new MediaPlayer();
            mediaPlayer.setDisplay(vidHolder);

            mediaPlayer.setDataSource(String.valueOf(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES))+ File.separator+"video1.mp4");
            mediaPlayer.prepareAsync();

            mediaPlayer.setOnPreparedListener(this);
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    @Override
    public void onBackPressed() {
        mediaPlayer.stop();
        super.onBackPressed();
    }

    public void play(View view) {
        mediaPlayer.start();
    }
}
