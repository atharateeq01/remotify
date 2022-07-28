package com.example.remotfiy;


import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Handler;
import android.widget.Toast;

import androidx.annotation.RequiresApi;


public class Sound_Mode {
    Context context;
    AudioManager myAudioManger;
    MediaPlayer mp;

    public Sound_Mode(Context context) {
        this.context = context;
        this.myAudioManger = (AudioManager) this.context.getSystemService(Context.AUDIO_SERVICE);
    }

    public void normalmode() {
        this.myAudioManger.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
        this.myAudioManger.setStreamVolume(2, this.myAudioManger.getStreamMaxVolume(2), 0);
        this.myAudioManger.setStreamVolume(3, this.myAudioManger.getStreamMaxVolume(3), 0);
        this.myAudioManger.setStreamVolume(4, this.myAudioManger.getStreamMaxVolume(4), 0);
        this.myAudioManger.setStreamVolume(1, this.myAudioManger.getStreamMaxVolume(1), 0);
    }

    public void Vibratemode() {
        this.myAudioManger.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
    }

    public void Silentmode() {

        this.myAudioManger.setRingerMode(0);


    }
//    public void playsound(){
//        this.mp = MediaPlayer.create(context, R.raw.sample);
//        this.mp.setLooping(true);
//        this.mp.start();
//    }
//
//    public  void stopsound() {
//        if (mp.isPlaying()) {
//        Toast.makeText(this.context, "kch bhi dikhaya ja skta he", Toast.LENGTH_SHORT).show();
//        this.mp.setLooping(false);
//        this.mp.stop();
//
//            return true;
//        } else
//            return false;
//    }
}
