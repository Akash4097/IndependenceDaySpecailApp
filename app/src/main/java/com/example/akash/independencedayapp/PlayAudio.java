package com.example.akash.independencedayapp;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

public class PlayAudio extends Service {
    MediaPlayer objPlayer;

    public void onCreate() {
        super.onCreate();
        objPlayer = MediaPlayer.create(this, R.raw.saare_jaha_se);
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        objPlayer.start();
        objPlayer.setLooping(true);
        return 0;
    }

    public void onStop(){
        objPlayer.stop();
        objPlayer.release();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
