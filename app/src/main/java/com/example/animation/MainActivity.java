package com.example.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;

public class MainActivity extends AppCompatActivity {
    AnimationDrawable fireAnimation;
    Timer t = new java.util.Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = (ImageView)findViewById(R.id.action_image);
        imageView.setBackgroundResource(R.drawable.fire);

        fireAnimation = (AnimationDrawable) imageView.getBackground();
        start();
        stop();
    }

    private void stop() {
        Button stopButton = (Button)findViewById(R.id.btn_stop);
        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fireAnimation.stop();
                t.cancel();
            }
        });
    }

    private void start() {
        Button startButton = (Button)findViewById(R.id.btn_start);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fireAnimation.start();
                t = new java.util.Timer();
                t.schedule(
                        new java.util.TimerTask() {
                            @Override
                            public void run() {
                                // your code here
                                fireAnimation.stop();
                                // close the thread
                                t.cancel();
                            }
                        },
                        10000
                );
            }
        });
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
                fireAnimation.start();
                  t = new java.util.Timer();
                t.schedule(
                        new java.util.TimerTask() {
                            @Override
                            public void run() {
                                // your code here
                                fireAnimation.stop();
                                // close the thread
                                t.cancel();
                            }
                        },
                        10000
                );

    }

}