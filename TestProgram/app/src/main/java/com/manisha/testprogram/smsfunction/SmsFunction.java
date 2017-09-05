package com.manisha.testprogram.smsfunction;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.UiThread;
import android.telephony.PhoneNumberUtils;
import android.telephony.SmsMessage;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.manisha.testprogram.R;

import static com.manisha.testprogram.constant.ErrorCode.SMS_MOBLIE_NUMBER;

/**
 * Created by Manisha on 9/3/2017.
 */

public class SmsFunction extends BroadcastReceiver {

    private static final String SMS_RECEIVED = "android.provider.Telephony.SMS_RECEIVED";
    View view;
    Dialog alertDialog;

    public SmsFunction() {

    }

    @Override
    public void onReceive(final Context context, Intent intent) {
        if (intent.getAction().equals(SMS_RECEIVED)) {
            Log.i("sms","received");
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                // Getting the SMS Object
                Object[] pdus = (Object[]) bundle.get("pdus");
                if (pdus.length == 0) {
                    Log.i("sms","pdus" +pdus);
                    return;
                }
                SmsMessage[] messages = new SmsMessage[pdus.length];
                Log.i("sms","msgs" + messages.toString());
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < pdus.length; i++) {
                    messages[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
                    sb.append(messages[i].getMessageBody());
                    Log.i("sms","for loop ");
                }
                final String sender = messages[0].getOriginatingAddress();
              //  Log.i("sms","msgs2" + sender);
                final String message = sb.toString();
                if (PhoneNumberUtils.compare(SMS_MOBLIE_NUMBER, sender)) {
               //     Log.i("sms context "+context,"msgs3" + sender);
                    Intent intentDialog = new Intent(context,AlertDialogActivity.class);
                    intentDialog.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intentDialog.putExtra("SenderNum",sender);
                    intentDialog.putExtra("SenderMessage",message);
                    context.startActivity(intentDialog);
                }
            }
        }
    }
}
