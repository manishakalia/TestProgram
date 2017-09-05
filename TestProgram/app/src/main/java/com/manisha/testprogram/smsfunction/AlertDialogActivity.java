package com.manisha.testprogram.smsfunction;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.manisha.testprogram.R;

/**
 * Created by Manisha on 9/3/2017.
 * This activity is used for creating dialogbox for incoming mobile number message
 */

public class AlertDialogActivity extends Activity {

    Dialog alertDialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String senderNum = getIntent().getStringExtra("SenderNum");
        String senderMessage = getIntent().getStringExtra("SenderMessage");
        Log.d("message","sendermsg"+senderMessage);
        View view = View.inflate(this, R.layout.dialogbox_layout, null);
        TextView txtMsg = (TextView) view.findViewById(R.id.tvTitleMsg);
        txtMsg.setText("You got SMS from " + "\"" + senderNum + "\"");
        EditText etSmsMsg = (EditText) view.findViewById(R.id.etSmsMsg);
        etSmsMsg.setTextColor(Color.BLACK);
        etSmsMsg.setText(senderMessage);
        etSmsMsg.setClickable(false);
        Button btnCancel = (Button) view.findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.cancel();
                /*finish();*/
                System.exit(0);
            }
        });
        Button btnOk = (Button) view.findViewById(R.id.btnOk);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.cancel();
               // finish();
                System.exit(0);
            }
        });
        AlertDialog.Builder alert = new AlertDialog.Builder(AlertDialogActivity.this);
        alert.setView(view);
        alertDialog = alert.create();
        alertDialog.show();

    }
}
