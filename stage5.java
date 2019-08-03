package com.example.cabeloni.epcomp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.cunoraz.gifview.library.GifView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static com.example.cabeloni.epcomp.groups.flag;

public class stage5 extends AppCompatActivity {
    private static final int TIME_LIMIT = 1500;
    private static long backPressed;
    public static int bluetime;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stage5);
        final TextInputLayout passwordWrapper = (TextInputLayout) findViewById(R.id.passwordWrapper);
        final Button send = (Button) findViewById(R.id.send);
        final ImageButton next = (ImageButton) findViewById(R.id.nextbtn);
        final ImageButton tryagain = (ImageButton) findViewById(R.id.tryagain);
        final ImageButton good = (ImageButton) findViewById(R.id.good);
        final ImageButton sofb = (ImageButton) findViewById(R.id.sofb);
        final MediaPlayer But  = MediaPlayer.create(this,R.raw.soundbut);
        final GifView gifViewb = (GifView) findViewById(R.id.bandanab);
        final GifView gifViewg = (GifView) findViewById(R.id.bandanag);
        final GifView gifViewr = (GifView) findViewById(R.id.bandanar);
        final GifView gifViewp = (GifView) findViewById(R.id.bandanap);
        final GifView gifViewy = (GifView) findViewById(R.id.bandanay);
        final GifView title1 = (GifView) findViewById(R.id.titleg);
        final GifView desc = (GifView) findViewById(R.id.desc);
        desc.pause();
        title1.pause();
        final Handler h2 = new Handler();
        h2.postDelayed(new Runnable() {
            @Override
            public void run() {
                title1.play();
            }

        }, 1000);
        final Handler h3 = new Handler();
        h3.postDelayed(new Runnable() {
            @Override
            public void run() {
                desc.play();
            }

        }, 3000);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                title1.pause();
            }
        }, 3500);
        Handler handler2 = new Handler();
        handler2.postDelayed(new Runnable() {
            public void run() {
                desc.pause();
            }
        }, 6000);
        if (flag == 1){
            gifViewb.setVisibility(View.VISIBLE);
        }
        else if (flag == 2){
            gifViewg.setVisibility(View.VISIBLE);
        }
        else if (flag == 3){
            gifViewr.setVisibility(View.VISIBLE);
        }
        else if (flag == 4){
            gifViewp.setVisibility(View.VISIBLE);
        }
        else {
            gifViewy.setVisibility(View.VISIBLE);
        }
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                But.start();

                if(v==send) {
                    send.setBackgroundResource(R.drawable.sendp);
                }
                try  {
                    InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                } catch (Exception e) {

                }
                String password5 = passwordWrapper.getEditText().getText().toString();
                if(((String) password5).equals("1")) {
                    good.setVisibility(View.VISIBLE);
                    tryagain.setVisibility(View.INVISIBLE);
                    send.setVisibility(View.INVISIBLE);
                    int temp = global.getc();
                    temp++;
                    global.setc(temp);
                    if (temp == 5) {
                        sofb.setVisibility(View.VISIBLE);
                        sofb.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                bluetime = MyFragment.timeleft/1000;
                                sofb.setVisibility(View.INVISIBLE);
                                title1.play();
                                desc.play();
                                But.start();
                                sofb.setImageResource(R.drawable.sofbp);
                                Handler handler4 = new Handler();
                                handler4.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        title1.setVisibility(View.INVISIBLE);
                                    }
                                }, 1800);
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        title1.setVisibility(View.INVISIBLE);
                                        desc.setVisibility(View.INVISIBLE);
                                        mDatabase = FirebaseDatabase.getInstance().getReference("blue").child("stage");
                                        mDatabase.setValue("6");
                                        Intent myIntent = new Intent(stage5.this, stage6.class);
                                        startActivity(myIntent);
                                    }
                                }, 3000);

                            }
                        });
                    } else {
                        next.setVisibility(View.VISIBLE);
                        next.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                next.setVisibility(View.INVISIBLE);
                                title1.play();
                                desc.play();
                                But.start();
                                next.setImageResource(R.drawable.nextqp);
                                Handler handler5 = new Handler();
                                handler5.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        title1.setVisibility(View.INVISIBLE);
                                    }
                                }, 1800);
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        title1.setVisibility(View.INVISIBLE);
                                        desc.setVisibility(View.INVISIBLE);
                                        Intent myIntent = new Intent(stage5.this, stage1.class);
                                        startActivity(myIntent);
                                    }
                                }, 3000);
                            }
                        });
                    }
                } else {
                    tryagain.setVisibility(View.VISIBLE);
                    next.setVisibility(View.INVISIBLE);
                    ((TextView) findViewById(R.id.password5)).setText("");
                }
            }
        });
    }
    @Override
    public void onBackPressed() {
        if(TIME_LIMIT+backPressed > System.currentTimeMillis()){
            Intent myIntent = new Intent(stage5.this,groups.class);
            startActivity(myIntent);
        }
        else{
            Toast.makeText(getApplicationContext(),"לחץ חזור שוב כדי להגיע לתפריט בחירת הקבוצות",Toast.LENGTH_SHORT).show();
        }
        backPressed = System.currentTimeMillis();
    }

}
