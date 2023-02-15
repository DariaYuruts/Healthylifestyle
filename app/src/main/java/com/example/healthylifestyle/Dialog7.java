package com.example.healthylifestyle;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

public class Dialog7 extends AppCompatActivity {

    Dialog dialog7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog7);

        dialog7 =new Dialog(this);
        dialog7.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog7.setContentView(R.layout.activity_dialog7);

        dialog7.setCancelable(false);

        TextView btnclose = (TextView)dialog7.findViewById(R.id.btnclose);
        btnclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Dialog7.this,RecommendActivity.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {
                }
                dialog7.dismiss();

            }
        });

        dialog7.show();
    }
}