package com.example.remotfiy;

import static android.content.Context.MODE_PRIVATE;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.widget.Toast;


public class ReceiveSms extends BroadcastReceiver{
    String messageBody;
    String meme;
    private Context context;
    private SharedPreferences sharedPreferences;

    @Override

    public void onReceive(Context context, Intent intent) {

        this.context = context;
        if (Telephony.Sms.Intents.SMS_RECEIVED_ACTION.equals(intent.getAction())) {
            for (SmsMessage smsMessage : Telephony.Sms.Intents.getMessagesFromIntent(intent)) {
                messageBody = smsMessage.getMessageBody();
                meme = smsMessage.getDisplayOriginatingAddress();

            }
        //    new Flashonoff(this.context).turnonFlash();
            Toast.makeText(context, messageBody + " by " + meme, Toast.LENGTH_SHORT).show();

           // executecomand(messageBody, meme);


              sharedPreferences = this.context.getSharedPreferences("save", MODE_PRIVATE);
            //   mydb = new History(this.context)
            boolean a = sharedPreferences.getBoolean("value4",false);

            if (messageBody.equals("athar")) {
                if(a){
                    new Flashonoff(this.context).turnonFlash();
                }

            }
            if (messageBody.equals("shair")) {
                new Flashonoff(this.context).turnoffFlash();

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

