package com.example.cabeloni.epcomp;

import android.app.Dialog;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

import static com.example.cabeloni.epcomp.startv2.musicFlg;


public class groups extends AppCompatActivity {
    private static final int TIME_LIMIT = 1500;
    private static long backPressed;
    public static String nameone="";
    public static String nametwo="";
    public static String namethree="";
    public static String namefour="";
    public static String namefive="";
    public static int flag= 0;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.groups);
        final MediaPlayer beep1  = MediaPlayer.create(this,R.raw.beep);
        final MediaPlayer beep2  = MediaPlayer.create(this,R.raw.beep);
        final MediaPlayer beep3  = MediaPlayer.create(this,R.raw.beep);
        final MediaPlayer beep4  = MediaPlayer.create(this,R.raw.beep);
        final MediaPlayer beep5  = MediaPlayer.create(this,R.raw.beep);
        final ImageButton stage1 = (ImageButton) findViewById(R.id.b1);
        final ImageButton stage2 = (ImageButton) findViewById(R.id.b2);
        final ImageButton stage3 = (ImageButton) findViewById(R.id.b3);
        final ImageButton stage4 = (ImageButton) findViewById(R.id.b4);
        final ImageButton stage5 = (ImageButton) findViewById(R.id.b5);
        stage1.setVisibility(View.INVISIBLE);
        stage2.setVisibility(View.INVISIBLE);
        stage3.setVisibility(View.INVISIBLE);
        stage4.setVisibility(View.INVISIBLE);
        stage5.setVisibility(View.INVISIBLE);
        musicFlg = 0;
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
               final Animation fadein = AnimationUtils.loadAnimation(groups.this, R.anim.fade_in);
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        stage1.setVisibility(View.VISIBLE);
                        beep1.start();
                        ObjectAnimator.ofFloat(stage1, "alpha", 1f).setDuration(100).start();
                    }
                }, 500);
                handler.postDelayed(new Runnable() {
                    public void run() {
                        stage2.setVisibility(View.VISIBLE);
                        beep2.start();
                        ObjectAnimator.ofFloat(stage2, "alpha", 1f).setDuration(100).start();
                    }
                }, 1000);
                handler.postDelayed(new Runnable() {
                    public void run() {
                        stage3.setVisibility(View.VISIBLE);
                        beep3.start();
                        ObjectAnimator.ofFloat(stage3, "alpha", 1f).setDuration(100).start();
                    }
                }, 1500);
                handler.postDelayed(new Runnable() {
                    public void run() {
                        stage4.setVisibility(View.VISIBLE);
                        beep4.start();
                        ObjectAnimator.ofFloat(stage4, "alpha", 1f).setDuration(100).start();
                    }
                }, 2000);
                handler.postDelayed(new Runnable() {
                    public void run() {
                        stage5.setVisibility(View.VISIBLE);
                        beep5.start();
                        ObjectAnimator.ofFloat(stage5, "alpha", 1f).setDuration(100).start();
                    }
                }, 2500);
            }
        }, 2000);
        final ImageButton backbutton = (ImageButton) findViewById(R.id.backbutton);
        final MediaPlayer But  = MediaPlayer.create(this,R.raw.soundbut);
        int temp=0;
        global.setc(temp);
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                But.start();
                backbutton.setImageResource(R.drawable.backp);
                Intent myIntent = new Intent(groups.this,MainActivity.class);
                startActivity(myIntent);
            }
        });
        stage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                But.start();
                stage1.setImageResource(R.drawable.p1);
               final AlertDialog alert = new AlertDialog.Builder(groups.this).create();
                alert.setTitle("אנא בחר שם לקבוצה");
                final EditText input = new EditText(groups.this);
                alert.setView(input);
                alert.setButton(Dialog.BUTTON_POSITIVE, "שלח",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String textValue1 = input.getText().toString();
                                nameone = textValue1.toString();
                                if(!textValue1.isEmpty() && textValue1.length() < 9 ) {
                                    mDatabase = FirebaseDatabase.getInstance().getReference("blue");
                                    mDatabase.child("Name").setValue(nameone + " " + "הכחולים");
                                    mDatabase.child("bluep").setValue("טרם סיימו");
                                    mDatabase.child("stage").setValue("1");
                                    flag = 1;
                                    Intent myIntent = new Intent(groups.this, maavar.class);
                                    startActivity(myIntent);
                                }
                                else
                                    Toast.makeText(getBaseContext(),"שם הקבוצה חייב להיות באורך 1-8 תווים!",Toast.LENGTH_LONG).show();
                            }
                        });
                alert.setButton(Dialog.BUTTON_NEGATIVE, "חזרה",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // TODO Auto-generated method stub
                            }
                        });
                alert.show();
                alert.show();
            }
        });

        stage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                But.start();
                stage2.setImageResource(R.drawable.p2);
                final AlertDialog alert = new AlertDialog.Builder(groups.this).create();
                alert.setTitle("אנא בחר שם לקבוצה");
                final EditText input = new EditText(groups.this);
                alert.setView(input);
                alert.setButton(Dialog.BUTTON_POSITIVE, "שלח",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String textValue1 = input.getText().toString();
                                nametwo = textValue1.toString();
                                if(!textValue1.isEmpty() && textValue1.length() < 9  ) {
                                    mDatabase = FirebaseDatabase.getInstance().getReference("green");
                                    mDatabase.child("Name").setValue(nametwo + " " + "הירוקים");
                                    mDatabase.child("greenp").setValue("טרם סיימו");
                                    mDatabase.child("stage").setValue("1");
                                    flag = 2;
                                    Intent myIntent = new Intent(groups.this, maavar.class);
                                    startActivity(myIntent);
                                }
                                else
                                    Toast.makeText(getBaseContext(),"שם הקבוצה חייב להיות באורך 1-8 תווים!",Toast.LENGTH_LONG).show();
                            }
                        });
                alert.setButton(Dialog.BUTTON_NEGATIVE, "חזרה",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // TODO Auto-generated method stub
                            }
                        });
                alert.show();
                alert.show();
            }
        });
        stage3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                But.start();
                stage3.setImageResource(R.drawable.p3);
                final AlertDialog alert = new AlertDialog.Builder(groups.this).create();
                alert.setTitle("אנא בחר שם לקבוצה");
                final EditText input = new EditText(groups.this);
                alert.setView(input);
                alert.setButton(Dialog.BUTTON_POSITIVE, "שלח",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String textValue1 = input.getText().toString();
                                namethree = textValue1.toString();
                                if(!textValue1.isEmpty() && textValue1.length() < 9  ) {
                                    mDatabase = FirebaseDatabase.getInstance().getReference("red");
                                    mDatabase.child("Name").setValue(namethree + " " + "האדומים");
                                    mDatabase.child("redp").setValue("טרם סיימו");
                                    mDatabase.child("stage").setValue("1");
                                    flag = 3;
                                    Intent myIntent = new Intent(groups.this, maavar.class);
                                    startActivity(myIntent);
                                }
                                else
                                    Toast.makeText(getBaseContext(),"שם הקבוצה חייב להיות באורך 1-8 תווים!",Toast.LENGTH_LONG).show();
                            }
                        });
                alert.setButton(Dialog.BUTTON_NEGATIVE, "חזרה",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // TODO Auto-generated method stub
                            }
                        });
                alert.show();
                alert.show();
            }
        });
        stage4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                But.start();
                stage4.setImageResource(R.drawable.p4);
                final AlertDialog alert = new AlertDialog.Builder(groups.this).create();
                alert.setTitle("אנא בחר שם לקבוצה");
                final EditText input = new EditText(groups.this);
                alert.setView(input);
                alert.setButton(Dialog.BUTTON_POSITIVE, "שלח",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String textValue1 = input.getText().toString();
                                namefour = textValue1.toString();
                                if(!textValue1.isEmpty() && textValue1.length() < 9 ) {
                                    mDatabase = FirebaseDatabase.getInstance().getReference("purple");
                                    mDatabase.child("Name").setValue(namefour + " " + "הסגולים");
                                    mDatabase.child("purplep").setValue("טרם סיימו");
                                    mDatabase.child("stage").setValue("1");
                                    flag = 4;
                                    Intent myIntent = new Intent(groups.this, maavar.class);
                                    startActivity(myIntent);
                                }
                                else
                                    Toast.makeText(getBaseContext(),"שם הקבוצה חייב להיות באורך 1-8 תווים!",Toast.LENGTH_LONG).show();
                            }
                        });
                alert.setButton(Dialog.BUTTON_NEGATIVE, "חזרה",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // TODO Auto-generated method stub
                            }
                        });
                alert.show();
                alert.show();
            }
        });
        stage5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                But.start();
                stage5.setImageResource(R.drawable.p5);
                final AlertDialog alert = new AlertDialog.Builder(groups.this).create();
                alert.setTitle("אנא בחר שם לקבוצה");
                final EditText input = new EditText(groups.this);
                alert.setView(input);
                alert.setButton(Dialog.BUTTON_POSITIVE, "שלח",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String textValue1 = input.getText().toString();
                                namefive = textValue1.toString();
                                if(!textValue1.isEmpty() && textValue1.length() < 9 ) {
                                    mDatabase = FirebaseDatabase.getInstance().getReference("yellow");
                                    mDatabase.child("Name").setValue(namefive + " " + "הצהובים");
                                    mDatabase.child("yellowp").setValue("טרם סיימו");
                                    mDatabase.child("stage").setValue("1");
                                    flag = 5;
                                    Intent myIntent = new Intent(groups.this, maavar.class);
                                    startActivity(myIntent);
                                }
                                else
                                    Toast.makeText(getBaseContext(),"שם הקבוצה חייב להיות באורך 1-8 תווים!",Toast.LENGTH_LONG).show();
                            }
                        });
                alert.setButton(Dialog.BUTTON_NEGATIVE, "חזרה",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // TODO Auto-generated method stub
                            }
                        });
                alert.show();
                alert.show();
            }
        });

  }
    @Override
    public void onBackPressed() {
        if(TIME_LIMIT+backPressed > System.currentTimeMillis()){
            Intent myIntent = new Intent(groups.this,MainActivity.class);
            startActivity(myIntent);
        }
        else{
            Toast.makeText(getApplicationContext(),"לחץ חזור שוב כדי להגיע לתפריט הראשי",Toast.LENGTH_SHORT).show();
        }
        backPressed = System.currentTimeMillis();
    }

}
