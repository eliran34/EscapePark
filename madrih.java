package com.example.cabeloni.epcomp;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import static com.example.cabeloni.epcomp.startv2.musicFlg;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class madrih extends AppCompatActivity {
    private static final int TIME_LIMIT = 1500;
    private static long backPressed;
    private DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.madrih);
        final ImageView code = (ImageView) findViewById(R.id.code);
        final TextView haster = (TextView) findViewById(R.id.textView9);
        final TextView hare = (TextView) findViewById(R.id.textView11);
        final ImageButton backbutton = (ImageButton) findViewById(R.id.backbutton);
        final ImageButton removeb = (ImageButton) findViewById(R.id.removedb);
        final ImageButton stats = (ImageButton) findViewById(R.id.stats);
        final MediaPlayer But  = MediaPlayer.create(this,R.raw.soundbut);
        Switch switch1 = (Switch)findViewById(R.id.switch1);
        musicFlg = 0;
        mDatabase = FirebaseDatabase.getInstance().getReference("admin");
        mDatabase.child("Name").setValue("admin");
        switch1.setChecked(true);
        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    code.setVisibility(View.VISIBLE);
                    haster.setVisibility(View.VISIBLE);
                    hare.setVisibility(View.INVISIBLE);

                }
                else {
                    code.setVisibility(View.INVISIBLE);
                    haster.setVisibility(View.INVISIBLE);
                    hare.setVisibility(View.VISIBLE);
                }
            }
        });
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                But.start();
                backbutton.setImageResource(R.drawable.backmenup);
                Intent myIntent = new Intent(madrih.this, MainActivity.class);
                startActivity(myIntent);
            }
        });
        removeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                But.start();
                removeb.setImageResource(R.drawable.dbcleanp);
                new AlertDialog.Builder( madrih.this )
                        .setTitle( "האם אתה בטוח?" )
                        .setMessage( "האם אתה בטוח שברצונך למחוק את כל נתוני הקבוצות?" )
                        .setPositiveButton( "כן", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                mDatabase = FirebaseDatabase.getInstance().getReference();
                                mDatabase.setValue(null);
                            }
                        })
                        .setNegativeButton( "לא", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        } )
                        .show();
                removeb.setImageResource(R.drawable.dbclean);
            }
        });

        stats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(madrih.this, stats.class);
                startActivity(myIntent);

            }
        });
    }

        @Override
        public void onBackPressed() {
            if(TIME_LIMIT+backPressed > System.currentTimeMillis()){
                Intent myIntent = new Intent(madrih.this,MainActivity.class);
                startActivity(myIntent);
            }
            else{
                Toast.makeText(getApplicationContext(),"לחץ חזור שוב כדי להגיע לתפריט הראשי",Toast.LENGTH_SHORT).show();
            }
            backPressed = System.currentTimeMillis();
        }
    }




