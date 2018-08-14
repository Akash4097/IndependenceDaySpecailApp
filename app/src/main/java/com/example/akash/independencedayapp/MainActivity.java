package com.example.akash.independencedayapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Visibility;
import android.view.Gravity;
import android.view.Window;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private int currentPage = 0, NUM_PAGES = 5;
    final long DELAY_MS = 1000;
    final long PERIOD_MS = 5000;

    @Override
    protected void onStop() {
        super.onStop();
        Intent objIntent = new Intent(this, PlayAudio.class);
        stopService(objIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ViewPager viewPager = findViewById(R.id.viewpager);
        viewPager.setAdapter(new MyPageAdapter(this, getSupportFragmentManager()));
        viewPager.setPageTransformer(true, new DepthPageTransformer());

        Intent objIntent = new Intent(this, PlayAudio.class);
        startService(objIntent);

        final Handler handler = new Handler();
        final Runnable update = new Runnable() {
            public void run() {
                if (currentPage == NUM_PAGES) {
                    currentPage = 0;
                }
                viewPager.setCurrentItem(currentPage++, true);
            }
        };
        new Timer().schedule(new TimerTask() {

            @Override
            public void run() {
                handler.post(update);
            }
        }, DELAY_MS, PERIOD_MS);

        ImageView imageView = findViewById(R.id.gifImage);
        Glide.with(this).load(R.drawable.indian_flag).into(imageView);
    }
}
