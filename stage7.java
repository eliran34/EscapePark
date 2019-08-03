package com.example.cabeloni.epcomp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.cunoraz.gifview.library.GifView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import in.myinnos.androidscratchcard.ScratchCard;

import static com.example.cabeloni.epcomp.groups.flag;
import static com.example.cabeloni.epcomp.stage1.greentime;
import static com.example.cabeloni.epcomp.stage2.redtime;
import static com.example.cabeloni.epcomp.stage3.purpletime;
import static com.example.cabeloni.epcomp.stage4.yellowtime;
import static com.example.cabeloni.epcomp.stage5.bluetime;


public class stage7 extends AppCompatActivity {
    private static final int TIME_LIMIT = 1500;
    private static long backPressed;
    private DatabaseReference mDatabase;
    private DatabaseReference mDatabase2;
    private TextView blueT;
    private TextView greenT;
    private TextView redT;
    private TextView purpleT;
    private TextView yellowT;
    private TextView blueTt;
    private TextView greenTt;
    private TextView redTt;
    private TextView purpleTt;
    private TextView yellowTt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stage7);
        final TextInputLayout passwordWrapper = (TextInputLayout) findViewById(R.id.passwordWrapper);
        final Button send = (Button) findViewById(R.id.send);
        final ImageButton back = (ImageButton) findViewById(R.id.back);
        final ImageButton tryagain = (ImageButton) findViewById(R.id.tryagain);
        final MediaPlayer But  = MediaPlayer.create(this,R.raw.soundbut);
        final ImageButton good = (ImageButton) findViewById(R.id.good);
        final GifView gifViewb = (GifView) findViewById(R.id.bandanab);
        final GifView gifViewg = (GifView) findViewById(R.id.bandanag);
        final GifView gifViewr = (GifView) findViewById(R.id.bandanar);
        final GifView gifViewp = (GifView) findViewById(R.id.bandanap);
        final GifView gifViewy = (GifView) findViewById(R.id.bandanay);
        final GifView vilon = (GifView) findViewById(R.id.vilon);
        final GifView box = (GifView) findViewById(R.id.box);
        final GifView sign = (GifView) findViewById(R.id.sign);
        blueT = (TextView) findViewById(R.id.textblue);
        blueTt = (TextView) findViewById(R.id.textbluet);
        greenT = (TextView) findViewById(R.id.textgreen);
        greenTt = (TextView) findViewById(R.id.textgreent);
        redT = (TextView) findViewById(R.id.textred);
        redTt = (TextView) findViewById(R.id.textredt);
        purpleT = (TextView) findViewById(R.id.textpurple);
        purpleTt = (TextView) findViewById(R.id.textpurplet);
        yellowT = (TextView) findViewById(R.id.textyellow);
        yellowTt = (TextView) findViewById(R.id.textyellowt);
        mDatabase = FirebaseDatabase.getInstance().getReference("blue").child("Name");
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()) {
                    String name = dataSnapshot.getValue().toString();
                    blueT.setText(name);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        mDatabase = FirebaseDatabase.getInstance().getReference("blue").child("bluep");
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()) {
                    String name = dataSnapshot.getValue().toString();
                    blueTt.setText(name);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        mDatabase = FirebaseDatabase.getInstance().getReference("green").child("Name");
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()) {
                    String name2 = dataSnapshot.getValue().toString();
                    greenT.setText(name2);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        mDatabase = FirebaseDatabase.getInstance().getReference("green").child("greenp");
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()) {
                    String name2 = dataSnapshot.getValue().toString();
                    greenTt.setText(name2);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        mDatabase = FirebaseDatabase.getInstance().getReference("red").child("Name");
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()) {
                    String name3 = dataSnapshot.getValue().toString();
                    redT.setText(name3);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        mDatabase = FirebaseDatabase.getInstance().getReference("red").child("redp");
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()) {
                    String name2 = dataSnapshot.getValue().toString();
                    redTt.setText(name2);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        mDatabase = FirebaseDatabase.getInstance().getReference("purple").child("Name");
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()) {
                    String name4 = dataSnapshot.getValue().toString();
                    purpleT.setText(name4);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        mDatabase = FirebaseDatabase.getInstance().getReference("purple").child("purplep");
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()) {
                    String name2 = dataSnapshot.getValue().toString();
                    purpleTt.setText(name2);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        mDatabase = FirebaseDatabase.getInstance().getReference("yellow").child("Name");
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()) {
                    String name5 = dataSnapshot.getValue().toString();
                    yellowT.setText(name5);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        mDatabase = FirebaseDatabase.getInstance().getReference("yellow").child("yellowp");
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()) {
                    String name2 = dataSnapshot.getValue().toString();
                    yellowTt.setText(name2);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        vilon.pause();
        box.pause();
        if (flag == 1){
            gifViewb.setVisibility(View.VISIBLE);
            sign.setGifResource(R.drawable.bs);
        }
        else if (flag == 2){
            gifViewg.setVisibility(View.VISIBLE);
            sign.setGifResource(R.drawable.gs);
        }
        else if (flag == 3){
            gifViewr.setVisibility(View.VISIBLE);
            sign.setGifResource(R.drawable.rs);
        }
        else if (flag == 4){
            gifViewp.setVisibility(View.VISIBLE);
            sign.setGifResource(R.drawable.ps);
        }
        else {
            gifViewy.setVisibility(View.VISIBLE);
            sign.setGifResource(R.drawable.ys);

        }
        Handler handler2 = new Handler();
        handler2.postDelayed(new Runnable() {
            @Override
            public void run() {
                sign.pause();
                box.play();
            }
        }, 4000);
        Handler handler3 = new Handler();
        handler3.postDelayed(new Runnable() {
            @Override
            public void run() {
                box.pause();
            }
        }, 7000);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                But.start();
                if(v==send){
                    send.setBackgroundResource(R.drawable.sendp);
                }
                try  {
                    InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                } catch (Exception e) {

                }
                String password7 = passwordWrapper.getEditText().getText().toString();
                if(((String) password7).equals("2505")) {
                    if (flag == 1){
                        bluetime = bluetime + MyFragment.timeleft/1000;
                        mDatabase = FirebaseDatabase.getInstance().getReference("blue");
                        mDatabase.child("bluep").setValue(bluetime);
                        mDatabase2 = FirebaseDatabase.getInstance().getReference("blue").child("stage");
                        mDatabase2.setValue("finished");
                    }
                    else if (flag == 2){
                        greentime = greentime + MyFragment.timeleft/1000;
                        mDatabase = FirebaseDatabase.getInstance().getReference("green");
                        mDatabase.child("greenp").setValue(greentime);
                        mDatabase2 = FirebaseDatabase.getInstance().getReference("green").child("stage");
                        mDatabase2.setValue("finished");
                    }
                    else if (flag == 3){
                        redtime = redtime + MyFragment.timeleft/1000;
                        mDatabase = FirebaseDatabase.getInstance().getReference("red");
                        mDatabase.child("redp").setValue(redtime);
                        mDatabase2 = FirebaseDatabase.getInstance().getReference("red").child("stage");
                        mDatabase2.setValue("finished");
                    }
                    else if (flag == 4){
                        purpletime = purpletime + MyFragment.timeleft/1000;
                        mDatabase = FirebaseDatabase.getInstance().getReference("purple");
                        mDatabase.child("purplep").setValue(purpletime);
                        mDatabase2 = FirebaseDatabase.getInstance().getReference("purple").child("stage");
                        mDatabase2.setValue("finished");
                    }
                    else {
                        yellowtime = yellowtime + MyFragment.timeleft/1000;
                        mDatabase = FirebaseDatabase.getInstance().getReference("yellow");
                        mDatabase.child("yellowp").setValue(yellowtime);
                        mDatabase2 = FirebaseDatabase.getInstance().getReference("yellow").child("stage");
                        mDatabase2.setValue("finished");
                    }
                    good.setVisibility(View.VISIBLE);
                    tryagain.setVisibility(View.INVISIBLE);
                    send.setVisibility(View.INVISIBLE);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            vilon.play();
                        }
                    }, 2000);
                    Handler handler2 = new Handler();
                    handler2.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            vilon.pause();
                        }
                    }, 7000);

                } else{
                    tryagain.setVisibility(View.VISIBLE);
                    good.setVisibility(View.INVISIBLE);
                    ((TextView) findViewById(R.id.password7)).setText("");
                }
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                But.start();
                back.setImageResource(R.drawable.backmenup);
                Intent restartIntent = getBaseContext().getPackageManager()
                        .getLaunchIntentForPackage(getBaseContext().getPackageName());
                restartIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(restartIntent);
            }
        });
    }
    @Override
    public void onBackPressed() {
        if(TIME_LIMIT+backPressed > System.currentTimeMillis()){
            Intent myIntent = new Intent(stage7.this,groups.class);
            startActivity(myIntent);
        }
        else{
            Toast.makeText(getApplicationContext(),"לחץ חזור שוב כדי להגיע לתפריט בחירת הקבוצות",Toast.LENGTH_SHORT).show();
        }
        backPressed = System.currentTimeMillis();
    }
}
