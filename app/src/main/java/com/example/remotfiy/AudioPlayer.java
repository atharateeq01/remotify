package com.example.remotfiy;


import android.accounts.AccountManager;
import android.content.Context;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;

public class AudioPlayer {
    private static MediaPlayer player;
    Context context;
    Sound_Mode sound_mode;
    DontDisturb dontDisturb;

    public AudioPlayer(Context context) {
        this.context = context;
        dontDisturb = new DontDisturb(this.context);
        this.sound_mode = new Sound_Mode(this.context);
    }

    public void startPlayer() {
        Uri uri = RingtoneManager.getDefaultUri(1);
        player = MediaPlayer.create(this.context, uri);

        this.dontDisturb.disturboff();
        this.sound_mode.normalmode();
        player.setLooping(true);
        player.start();

    }

    public boolean stopPlayer() {
        if (player.isPlaying()) {
            player.stop();
            return true;
        } else return false;

    }
}
