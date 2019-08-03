package com.example.cabeloni.epcomp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class startv2 extends AppCompatActivity {
    public static int musicFlg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startv2);
        final VideoView view2 = (VideoView)findViewById(R.id.videoView2);
        final Button presshere = findViewById(R.id.pressherebutton);
        final MediaPlayer beep1  = MediaPlayer.create(this,R.raw.soundtwo);
        String path = "android.resource://" + getPackageName() + "/" + R.raw.vid4;
        musicFlg = 1;
        view2.setVideoURI(Uri.parse(path));
        view2.start();
        beep1.start();
        final Handler h = new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                view2.pause();
                presshere.setVisibility(View.VISIBLE);
                presshere.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        view2.start();
                        presshere.setVisibility(View.INVISIBLE);
                        final Handler h = new Handler();

                        h.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                beep1.stop();
                                Intent intent = new Intent(startv2.this, MainActivity.class);
                                startActivity(intent);
                            }

                        }, 3000);
                    }
                });
            }

        }, 17500);
    }
}


