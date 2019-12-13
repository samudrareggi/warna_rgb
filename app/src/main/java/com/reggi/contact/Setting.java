package com.reggi.contact;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.SeekBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class Setting extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    SeekBar redBar, greenBar, blueBar;
    int r,g,b;
    ConstraintLayout cl;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);;
        redBar = (SeekBar) findViewById(R.id.redBar);
        greenBar = (SeekBar) findViewById(R.id.greenBar);
        blueBar = (SeekBar) findViewById(R.id.blueBar);
        cl = (ConstraintLayout)findViewById(R.id.mainlayout);

        sharedPreferences=getSharedPreferences("MySetting", MODE_PRIVATE);

        r=sharedPreferences.getInt("RED",0);
        g=sharedPreferences.getInt("GREEN",0);
        b=sharedPreferences.getInt("BLUE",0);

        redBar.setProgress(r);
        greenBar.setProgress(g);
        blueBar.setProgress(b);

        cl.setBackgroundColor(Color.rgb(r,g,b));

        redBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                cl.setBackgroundColor(Color.rgb(redBar.getProgress(), greenBar.getProgress(),
                        blueBar.getProgress())
                );
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("RED", seekBar.getProgress());
                editor.apply();
            }
        });
        greenBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                cl.setBackgroundColor(Color.rgb(redBar.getProgress(), greenBar.getProgress(),
                        blueBar.getProgress())
                );
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("GREEN", seekBar.getProgress());
                editor.apply();
            }
        });
        blueBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                cl.setBackgroundColor(Color.rgb(redBar.getProgress(), greenBar.getProgress(),
                        blueBar.getProgress())
                );
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("BLUE", seekBar.getProgress());
                editor.apply();
            }
        });
    }
}
