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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import com.cunoraz.gifview.library.GifView;

import in.myinnos.androidscratchcard.ScratchCard;

import static com.example.cabeloni.epcomp.groups.flag;

public class stage6 extends AppCompatActivity {
    private static final int TIME_LIMIT = 1500;
    private static long backPressed;
    private ScratchCard mScratchCard;
    private DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stage6);
        final TextInputLayout passwordWrapper = (TextInputLayout) findViewById(R.id.passwordWrapper);
        final Button send = (Button) findViewById(R.id.send);
        final ImageButton tryagain = (ImageButton) findViewById(R.id.tryagain);
        final MediaPlayer But  = MediaPlayer.create(this,R.raw.soundbut);
        final ImageButton good = (ImageButton) findViewById(R.id.good);
        final GifView gifViewb = (GifView) findViewById(R.id.bandanab);
        final GifView gifViewg = (GifView) findViewById(R.id.bandanag);
        final GifView gifViewr = (GifView) findViewById(R.id.bandanar);
        final GifView gifViewp = (GifView) findViewById(R.id.bandanap);
        final GifView gifViewy = (GifView) findViewById(R.id.bandanay);
        ImageView targil = (ImageView) findViewById(R.id.targil);
        ImageView frame = (ImageView) findViewById(R.id.frame);
        TextView num = (TextView) findViewById(R.id.cardnum);
        mScratchCard = (ScratchCard) findViewById(R.id.scratchCard);
        mScratchCard.setOnScratchListener(new ScratchCard.OnScratchListener() {
            @Override
            public void onScratch(ScratchCard scratchCard, float visiblePercent) {
                if (visiblePercent > 0.3) {
                    mScratchCard.setVisibility(View.GONE);
                }
            }
        });
        if (flag == 1){
            gifViewb.setVisibility(View.VISIBLE);
            targil.setImageResource(R.drawable.t1);
            frame.setImageResource(R.drawable.bf);
            num.setText("1");
        }
        else if (flag == 2){
            gifViewg.setVisibility(View.VISIBLE);
            targil.setImageResource(R.drawable.t2);
            frame.setImageResource(R.drawable.gf);
            num.setText("4");
        }
        else if (flag == 3){
            gifViewr.setVisibility(View.VISIBLE);
            targil.setImageResource(R.drawable.t3);
            frame.setImageResource(R.drawable.rf);
            num.setText("9");
        }
        else if (flag == 4){
            gifViewp.setVisibility(View.VISIBLE);
            targil.setImageResource(R.drawable.t4);
            frame.setImageResource(R.drawable.pf);
            num.setText("8");
        }
        else {
            gifViewy.setVisibility(View.VISIBLE);
            targil.setImageResource(R.drawable.t5);
            frame.setImageResource(R.drawable.yf);
            num.setText("3");
        }
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
                String password6 = passwordWrapper.getEditText().getText().toString();
                if(((String) password6).equals("150") && flag == 1 || ((String) password6).equals("168") && flag == 2 ||
                        ((String) password6).equals("250") && flag == 3 || ((String) password6).equals("205") && flag == 4
                        || ((String) password6).equals("116") && flag == 5) {
                    good.setVisibility(View.VISIBLE);
                    tryagain.setVisibility(View.INVISIBLE);
                    send.setVisibility(View.INVISIBLE);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if (flag == 1){
                                mDatabase = FirebaseDatabase.getInstance().getReference("blue").child("stage");
                                mDatabase.setValue("7");
                            }
                            else if (flag == 2){
                                mDatabase = FirebaseDatabase.getInstance().getReference("green").child("stage");
                                mDatabase.setValue("7");
                            }
                            else if (flag == 3){
                                mDatabase = FirebaseDatabase.getInstance().getReference("red").child("stage");
                                mDatabase.setValue("7");
                            }
                            else if (flag == 4){
                                mDatabase = FirebaseDatabase.getInstance().getReference("purple").child("stage");
                                mDatabase.setValue("7");
                            }
                            else {
                                mDatabase = FirebaseDatabase.getInstance().getReference("yellow").child("stage");
                                mDatabase.setValue("7");
                            }
                            Intent myIntent = new Intent(stage6.this, stage7.class);
                            startActivity(myIntent);
                        }
                    }, 3000);

                } else{
                    tryagain.setVisibility(View.VISIBLE);
                    good.setVisibility(View.INVISIBLE);
                    ((TextView) findViewById(R.id.password6)).setText("");
                }
            }
        });
    }
    @Override
    public void onBackPressed() {
        if(TIME_LIMIT+backPressed > System.currentTimeMillis()){
            Intent myIntent = new Intent(stage6.this,groups.class);
            startActivity(myIntent);
        }
        else{
            Toast.makeText(getApplicationContext(),"לחץ חזור שוב כדי להגיע לתפריט בחירת הקבוצות",Toast.LENGTH_SHORT).show();
        }
        backPressed = System.currentTimeMillis();
    }
}
