package com.example.cabeloni.epcomp;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;
import android.widget.VideoView;
import static com.example.cabeloni.epcomp.MainActivity.mdx;




import com.cunoraz.gifview.library.GifView;

import static com.example.cabeloni.epcomp.groups.nameone;
import static com.example.cabeloni.epcomp.groups.nametwo;
import static com.example.cabeloni.epcomp.groups.namethree;
import static com.example.cabeloni.epcomp.groups.namefour;
import static com.example.cabeloni.epcomp.groups.namefive;
import static com.example.cabeloni.epcomp.groups.flag;

public class maavar extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maavar);
        final Animation fadeIn = new AlphaAnimation(0.0f, 1.0f);
        fadeIn.setDuration(1000);
        fadeIn.setStartOffset(1000);
        final VideoView view = (VideoView)findViewById(R.id.videoView);
        final TextView text1=(TextView)findViewById(R.id.text1);
        final TextView text2=(TextView)findViewById(R.id.text2);
        final GifView gifView = (GifView) findViewById(R.id.gif1);
        if (flag == 1){
            String path = "android.resource://" + getPackageName() + "/" + R.raw.bluesmoke;
            view.setVideoURI(Uri.parse(path));
            view.start();
        }
        else if (flag == 2){
            String path = "android.resource://" + getPackageName() + "/" + R.raw.greensmoke;
            view.setVideoURI(Uri.parse(path));
            view.start();
        }
        else if (flag == 3){
            String path = "android.resource://" + getPackageName() + "/" + R.raw.redsmoke;
            view.setVideoURI(Uri.parse(path));
            view.start();
        }
        else if (flag == 4){
            String path = "android.resource://" + getPackageName() + "/" + R.raw.perpulesmoke;
            view.setVideoURI(Uri.parse(path));
            view.start();
        }
        else{
            String path = "android.resource://" + getPackageName() + "/" + R.raw.yellowsmoke;
            view.setVideoURI(Uri.parse(path));
            view.start();
        }
        gifView.pause();
        final Handler h2 = new Handler();
        h2.postDelayed(new Runnable() {
            @Override
            public void run() {
                gifView.play();
            }

        }, 1000);
        final Handler h3 = new Handler();
        h3.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (flag == 1) {
                    text1.startAnimation(fadeIn);
                    text2.startAnimation(fadeIn);
                    text1.setText("   " +nameone);
                    text2.setText("   " + "הכחולים");
                    text1.setShadowLayer(5.6f,5.5f,5.3f,Color.WHITE);
                    text1.setTextColor(Color.parseColor("#00a1dd"));
                    text2.setShadowLayer(5.6f,5.5f,5.3f,Color.WHITE);
                    text2.setTextColor(Color.parseColor("#00a1dd"));
                }
                else if (flag == 2) {
                    text1.startAnimation(fadeIn);
                    text2.startAnimation(fadeIn);
                    text1.setText("   " +nametwo);
                    text2.setText("   " + "הירוקים");
                    text1.setShadowLayer(5.6f,5.5f,5.3f,Color.WHITE);
                    text1.setTextColor(Color.parseColor("#00bf04"));
                    text2.setShadowLayer(5.6f,5.5f,5.3f,Color.WHITE);
                    text2.setTextColor(Color.parseColor("#00bf04"));
                }
                else if (flag == 3) {
                    text1.startAnimation(fadeIn);
                    text2.startAnimation(fadeIn);
                    text1.setText("   " +namethree);
                    text2.setText("   " + "האדומים");
                    text1.setShadowLayer(5.6f,5.5f,5.3f,Color.WHITE);
                    text1.setTextColor(Color.parseColor("#ff171a"));
                    text2.setShadowLayer(5.6f,5.5f,5.3f,Color.WHITE);
                    text2.setTextColor(Color.parseColor("#ff171a"));
                }
                else if (flag == 4) {
                    text1.startAnimation(fadeIn);
                    text2.startAnimation(fadeIn);
                    text1.setText("   " +namefour);
                    text2.setText("   " + "הסגולים");
                    text1.setShadowLayer(5.6f,5.5f,5.3f,Color.WHITE);
                    text1.setTextColor(Color.parseColor("#e900d8"));
                    text2.setShadowLayer(5.6f,5.5f,5.3f,Color.WHITE);
                    text2.setTextColor(Color.parseColor("#e900d8"));
                }
                else {
                    text1.startAnimation(fadeIn);
                    text2.startAnimation(fadeIn);
                    text1.setText("   " +namefive);
                    text2.setText("   " + "הצהובים");
                    text1.setShadowLayer(5.6f,5.5f,5.3f,Color.WHITE);
                    text1.setTextColor(Color.parseColor("#bdbd18"));
                    text2.setShadowLayer(5.6f,5.5f,5.3f,Color.WHITE);
                    text2.setTextColor(Color.parseColor("#bdbd18"));
                }
            }

        }, 2500);
        final Handler h = new Handler();

        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (flag == 1){
                    mdx.stop();
                    mdx.release();
                    gifView.setVisibility(View.INVISIBLE);
                    Intent intent = new Intent(maavar.this, stage1.class);
                    startActivity(intent);
                }
                else if (flag == 2){
                    mdx.stop();
                    mdx.release();
                    gifView.setVisibility(View.INVISIBLE);
                    Intent intent = new Intent(maavar.this, stage2.class);
                    startActivity(intent);
                }
                else if (flag == 3){
                    mdx.stop();
                    mdx.release();
                    gifView.setVisibility(View.INVISIBLE);
                    Intent intent = new Intent(maavar.this, stage3.class);
                    startActivity(intent);
                }
                else if (flag == 4){
                    mdx.stop();
                    mdx.release();
                    gifView.setVisibility(View.INVISIBLE);
                    Intent intent = new Intent(maavar.this, stage4.class);
                    startActivity(intent);
                }
                else{
                    mdx.stop();
                    mdx.release();
                    gifView.setVisibility(View.INVISIBLE);
                    Intent intent = new Intent(maavar.this, stage5e.class);
                    startActivity(intent);
                }
            }

        }, 9500);
    }
}

