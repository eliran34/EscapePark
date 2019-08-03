package com.example.cabeloni.epcomp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.VideoView;

public class sof extends AppCompatActivity {
    MediaPlayer mdx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startv);
        VideoView view = (VideoView)findViewById(R.id.videoView);
        String path = "android.resource://" + getPackageName() + "/" + R.raw.timeoff;
        view.setVideoURI(Uri.parse(path));
        view.start();
        final Handler h2 = new Handler();

        h2.postDelayed(new Runnable() {
            @Override
            public void run() {
                mdx = MediaPlayer.create(sof.this, R.raw.fail);
                mdx.start();
            }

        }, 5000);
        final Handler h = new Handler();

        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(sof.this, sof2.class);

                startActivity(intent);
            }

        }, 12000);
    }
}
