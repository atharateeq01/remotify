package com.example.remotfiy;


import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.provider.Settings;
import android.widget.Toast;

import static android.content.Context.NOTIFICATION_SERVICE;

public class DontDisturb {

    Context context;
    private NotificationManager mNotificationManager;

    public DontDisturb(Context context) {
        this.context = context;
        this.mNotificationManager = (NotificationManager) this.context.getSystemService(NOTIFICATION_SERVICE);

    }


    public void disturbon() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            if (this.mNotificationManager.isNotificationPolicyAccessGranted()) {

                this.mNotificationManager.setInterruptionFilter(NotificationManager.INTERRUPTION_FILTER_NONE);

            }

//        return true;
        }
//        else {
//            return false;
//        }
    }

    public void disturboff() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (this.mNotificationManager.isNotificationPolicyAccessGranted()) {
                this.mNotificationManager.setInterruptionFilter(NotificationManager.INTERRUPTION_FILTER_ALL);

            }
            //   changeInterruptionFiler(NotificationManager.INTERRUPTION_FILTER_NONE);
//            return true;
        }
//        else {
//        return false;
//    }
    }


    public void disturbAlarms() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            if (this.mNotificationManager.isNotificationPolicyAccessGranted()) {

                this.mNotificationManager.setInterruptionFilter(NotificationManager.INTERRUPTION_FILTER_ALARMS);

            }

//        return true;
        }
//        else {
//            return false;
//        }
    }

    public void disturbpriority() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            if (this.mNotificationManager.isNotificationPolicyAccessGranted()) {

                this.mNotificationManager.setInterruptionFilter(NotificationManager.INTERRUPTION_FILTER_PRIORITY);

            }

//        return true;
        }
//        else {
//            return false;
//        }
    }

    protected void changeInterruptionFiler(int interruptionFilter) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

        }
    }
}
