package com.example.cabeloni.epcomp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.VideoView;
import android.os.Handler;

public class startv extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startv);
        VideoView view = (VideoView)findViewById(R.id.videoView);
        String path = "android.resource://" + getPackageName() + "/" + R.raw.vid;
        view.setVideoURI(Uri.parse(path));
        view.start();
        final Handler h = new Handler();

        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(startv.this, startv2.class);

                startActivity(intent);
            }

        }, 10000);
        }
    }

