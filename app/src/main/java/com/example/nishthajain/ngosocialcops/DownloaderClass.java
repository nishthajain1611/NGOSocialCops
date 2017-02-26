package com.example.nishthajain.ngosocialcops;

import android.os.Environment;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by nishtha jain on 26-02-2017.
 */

public class DownloaderClass implements Runnable {
    @Override
    public void run() {
            downloadVideo(ActivityMain.videoAddress);
    }

    public void downloadVideo(String videoAddress){
        URL url=null;
        URLConnection ucon=null;
        try {
            url = new URL(videoAddress);

            long startTime = System.currentTimeMillis();
            Log.d("ImageManager", "download begining");
            Log.d("ImageManager", "download url:" + url);
            Log.d("ImageManager", "downloaded file name:" + "video");

            ucon = url.openConnection();

            InputStream is = null;
            is = ucon.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);

            File fileVideo = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES), "video1.mp4");
            fileVideo.createNewFile();

            FileOutputStream out = new FileOutputStream(fileVideo);
            byte buf[] = new byte[16384];

            do {
                int numread = bis.read(buf);
                if (numread <= 0) break;
                out.write(buf, 0, numread);
            } while (true);
            Log.d("ImageManager", "download ready in"
                    + ((System.currentTimeMillis() - startTime))
                    + " msec");

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
