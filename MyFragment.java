package com.example.cabeloni.epcomp;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.CountDownTimer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.v4.app.Fragment;
import java.util.concurrent.TimeUnit;

public class MyFragment extends Fragment {
    public static int timeleft;
    public static int flg = 0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View myLayout = inflater.inflate(R.layout.my_fragment_layout, container, false);
        final TextView time = myLayout.findViewById(R.id.time);
        Typeface typeface = Typeface.createFromAsset(getContext().getAssets(),
                "Fonts/scoreboard.ttf");
        time.setTypeface(typeface);
        time.setTextColor(Color.RED);
        if (getActivity() instanceof maavar && flg == 0) {
            CountDownTimer timer = new CountDownTimer(3600000, 1000) {

                public void onTick(long millisUntilFinished) {
                    flg = 1;
                    timeleft = (int)millisUntilFinished;
                    time.setText(""+String.format("%02d"+" "+":"+" "+"%02d",
                            TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) -
                                    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))
                    ,TimeUnit.MILLISECONDS.toMinutes( millisUntilFinished)));
                }

                public void onFinish() {
                    flg = 0;
                    Intent i = new Intent(getActivity(), sof.class);
                    startActivity(i);
                }

            }.start();
        }
        CountDownTimer timer = new CountDownTimer(timeleft, 1000) {

            public void onTick(long millisUntilFinished) {
                flg = 1;
                timeleft = (int)millisUntilFinished;
                time.setText(""+String.format("%02d"+" "+":"+" "+"%02d",
                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))
                        ,TimeUnit.MILLISECONDS.toMinutes( millisUntilFinished)));
            }

            public void onFinish() {
            }

        }.start();


        return myLayout;
    }
}

