package com.example.cabeloni.epcomp;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;
import android.app.AlertDialog;
import android.content.DialogInterface;
import java.util.Random;
import com.cunoraz.gifview.library.GifView;
import android.os.Handler;
import static com.example.cabeloni.epcomp.startv2.musicFlg;
public class MainActivity extends AppCompatActivity {
    int[] sounds={R.raw.mysound1, R.raw.mysound2, R.raw.mysound3,R.raw.mysound4,R.raw.mysound5};
    public static MediaPlayer mdx;
    private static final int TIME_LIMIT = 1500;
    private static long backPressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (musicFlg == 1) {
            Random r = new Random();
            int Low = 0;
            int High = 5;
            int rndm = r.nextInt(High - Low) + Low;
            mdx = MediaPlayer.create(getApplicationContext(), sounds[rndm]);
            mdx.start();
        }
        final MediaPlayer But  = MediaPlayer.create(this,R.raw.soundbut);
        final Button presshere = findViewById(R.id.pressherebutton);
        CheckBox checkbox=(CheckBox)findViewById(R.id.checkBox);
        checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    presshere.setVisibility(View.VISIBLE);
                }else {
                    presshere.setVisibility(View.INVISIBLE);
                }
            }
        });
            final Button madrih = findViewById(R.id.madrih);
        madrih.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                But.start();
                if(v==madrih){
                    madrih.setBackgroundResource(R.drawable.madrih2);
                }
                AlertDialog alert = new AlertDialog.Builder(MainActivity.this).create();
                alert.setTitle("אנא הכנס סיסמת מדריך");
                final EditText input = new EditText(MainActivity.this);
                input.setInputType(InputType.TYPE_CLASS_NUMBER);
                input.setRawInputType(Configuration.KEYBOARD_12KEY);
                alert.setView(input);
                alert.setButton(Dialog.BUTTON_POSITIVE, "שלח",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            String textValue = input.getText().toString();
                                if(textValue.equals("2505")) {
                                Intent myIntent = new Intent(MainActivity.this, madrih.class);
                                startActivity(myIntent);
                            }
                            else
                                Toast.makeText(getBaseContext(),"נסה שנית",Toast.LENGTH_SHORT).show();
                            }
                        });

                alert.setButton(Dialog.BUTTON_NEGATIVE, "יציאה",
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
            final Button pressherebutton = findViewById(R.id.pressherebutton);
            pressherebutton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    But.start();
                    if(v==pressherebutton){
                        pressherebutton.setBackgroundResource(R.drawable.hathel2);
                    }
                    Intent myIntent = new Intent(MainActivity.this, groups.class);
                    startActivity(myIntent);
                }
            });
            final Button stopmusic = findViewById(R.id.stopmusic);
            final Button playmusic = findViewById(R.id.soundon);
            stopmusic.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (musicFlg == 1) {
                        mdx.pause();
                        stopmusic.setVisibility(View.INVISIBLE);
                        playmusic.setVisibility(View.VISIBLE);
                    }
                }
            });
            playmusic.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (musicFlg == 1) {
                    mdx.start();
                    stopmusic.setVisibility(View.VISIBLE);
                    playmusic.setVisibility(View.INVISIBLE);
                    }
                }
            });


        }
        @Override
    public void onBackPressed() {
                if(TIME_LIMIT+backPressed > System.currentTimeMillis()){
                    moveTaskToBack(true);
                    android.os.Process.killProcess(android.os.Process.myPid());
                    System.exit(1);
                }
                else{
                    Toast.makeText(getApplicationContext(),"לחץ חזור שוב כדי לצאת",Toast.LENGTH_SHORT).show();
                }
                backPressed = System.currentTimeMillis();
    }

}
