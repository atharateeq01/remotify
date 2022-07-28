package com.example.remotfiy;


import static android.content.Context.MODE_PRIVATE;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.provider.Telephony;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.text.format.DateFormat;
import android.widget.Toast;

import java.util.Date;


public class ReceiveSms extends BroadcastReceiver{
    String messageBody;
    String meme, password, date,s;
    private Context context;
    private SharedPreferences sharedPreferences, sharedpass;



    @Override

    public void onReceive(Context context, Intent intent) {


         this.context = context;

        if (Telephony.Sms.Intents.SMS_RECEIVED_ACTION.equals(intent.getAction())) {
            for (SmsMessage smsMessage : Telephony.Sms.Intents.getMessagesFromIntent(intent)) {
                messageBody = smsMessage.getMessageBody();
                meme = smsMessage.getDisplayOriginatingAddress();

            }
        //    new Flashonoff(this.context).turnonFlash();
            Toast.makeText(context, messageBody+meme, Toast.LENGTH_SHORT).show();
            sharedpass = this.context.getSharedPreferences("Password", MODE_PRIVATE);
            password = sharedpass.getString("pass", "ni");
           // executecomand(messageBody, meme);

              //  print("meme");
              sharedPreferences = this.context.getSharedPreferences("save", MODE_PRIVATE);
            //   mydb = new History(this.context)
         //   boolean a = sharedPreferences.getBoolean("value4",false);

            if (messageBody.equals(password+" flashon")) {
                boolean a = sharedPreferences.getBoolean("value4",false);
                if(a){
                    new Flashonoff(this.context).turnonFlash();
                }

            }
            if (messageBody.equals(password+" flashoff")) {
                boolean a = sharedPreferences.getBoolean("value5",false);
                if(a){
                    new Flashonoff(this.context).turnoffFlash();
                }


            }

            if (messageBody.equals(password+" sound")) {
                boolean a = sharedPreferences.getBoolean("value",false);
                if(a){
                    new AudioPlayer(this.context).startPlayer();
                }
            }

            if (messageBody.equals(password+" nosound")) {
                boolean a = sharedPreferences.getBoolean("value1",false);
                if(a){
                    new AudioPlayer(this.context).stopPlayer();
                }
            }

            if (messageBody.equals(password+" bluon")) {
                boolean a = sharedPreferences.getBoolean("value2",false);
                if(a){
                    new bluetooth(this.context).turn_on_bluetooth();
                }

            }if (messageBody.equals(password+" bluoff")) {
                boolean a = sharedPreferences.getBoolean("value3",false);
                if(a){
                    new bluetooth(this.context).turn_off_bluetooth();
                }
            }


            if (messageBody.equals(password+" bat")) {
                boolean a = sharedPreferences.getBoolean("value7",false);
                if(a){
                    String battery = new BatteryReort(this.context).getbattery();
                    Toast.makeText(context, battery, Toast.LENGTH_SHORT).show();

                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(meme.substring(1), null, battery, null, null);
                }
            }

            if (messageBody.equals(password+" modev")) {
                boolean a = sharedPreferences.getBoolean("value6",false);
                if(a){
                    new Sound_Mode(this.context).Vibratemode();
                }
            }

            if (messageBody.equals(password+" moden")) {
                boolean a = sharedPreferences.getBoolean("value8",false);
                if(a){
                    new Sound_Mode(this.context).normalmode();
                }

            }
            if (messageBody.equals(password+" help")) {
                boolean a = sharedPreferences.getBoolean("value9",false);
                if(a){
                    SmsManager smsManager = SmsManager.getDefault();
                    String help = " Make sound --> \n Stop making sound --> (nosound) \n Vibrate --> (modev) \n All volume full --> (moden) \n Bluetooth on --> (bluon)  \n Flash on --> (flashon)  \n Flash off --> (flashoff)  \n Send location --> (loc) \n  Help --> (help) \n  Format is : password command ";
                    smsManager.sendTextMessage(meme.substring(1), null, "Stop making sound --> (nosound)", null, null);
                    smsManager.sendTextMessage(meme.substring(1), null, "Stop making sound --> (nosound)  ", null, null);
                    smsManager.sendTextMessage(meme.substring(1), null, " Vibrate --> (modev)  ", null, null);
                    smsManager.sendTextMessage(meme.substring(1), null, "All volume full --> (moden)  ", null, null);
                    smsManager.sendTextMessage(meme.substring(1), null, "Bluetooth on --> (bluon))  ", null, null);
                    smsManager.sendTextMessage(meme.substring(1), null, "Bluetooth off --> (bluoff)  ", null, null);
                    smsManager.sendTextMessage(meme.substring(1), null, " Flash on --> (flashon)   ", null, null);
                    smsManager.sendTextMessage(meme.substring(1), null, "Flash off --> (flashoff)  ", null, null);
                    smsManager.sendTextMessage(meme.substring(1), null, " Send location --> (loc)  ", null, null);
                    smsManager.sendTextMessage(meme.substring(1), null, " Battery --> (bat)  ", null, null);
                    smsManager.sendTextMessage(meme.substring(1), null, "Help --> (help)  ", null, null);
                    smsManager.sendTextMessage(meme.substring(1), null, " Format is : password command ", null, null);

                }
            }

            if (messageBody.equals(password+" loc")) {
                boolean a = sharedPreferences.getBoolean("value12",false);
                if(a){
                    new Location(this.context).get(meme);
                }
            }



//            Toast.makeText(context, messageBody +" by "+ meme, Toast.LENGTH_SHORT).show();
//            saveindb a = new saveindb();
//            a.setFoo("something here");
            //      Toast.makeText(context, messageBody +" by "+ meme, Toast.LENGTH_SHORT).show();
//            Intent i = new Intent(context, getna.class);
//            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            i.putExtra("message", messageBody);
//            context.startActivity(i);


//            Bundle extras = intent.getExtras();
//            intent = new Intent("message");
//            // Data you need to pass to another activity
//            intent.putExtra("message", extras.getString(messageBody));
//            context.sendBroadcast(intent);
        }

    }
//        public void executecomand (String mess, String mess_sender){
//            this.context = context;
//            if (mess.equals("athar")) {
//                //  if(sharedPreferences.getBoolean("s_fn",true)){
//                new Flashonoff(this.context).turnonFlash();
//                // }
//            }
//            if (messageBody.equals("shair")) {
//                new Flashonoff(this.context).turnoffFlash();
//
//            }
//
//    }


}