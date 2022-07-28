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
import android.widget.Toast;


public class ReceiveSms extends BroadcastReceiver{
    String messageBody;
    String meme, password;
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


            if (messageBody.equals(password+" modes")) {
                boolean a = sharedPreferences.getBoolean("value7",false);
                if(a){
                    new Sound_Mode(this.context).Silentmode();
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

            }if (messageBody.equals(password+" wifion")) {
                boolean a = sharedPreferences.getBoolean("value11",false);
                if(a){
                    new Wifim(this.context).wifion();
                }
            }


            if (messageBody.equals(password+" wifioff")) {
                boolean a = sharedPreferences.getBoolean("value10",false);
                if(a){
                    new Wifim(this.context).wifioff();
                }

            }
            if (messageBody.equals(password+" help")) {
                boolean a = sharedPreferences.getBoolean("value9",false);
                if(a){
                     SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(meme.substring(1), null, "that", null, null);
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


