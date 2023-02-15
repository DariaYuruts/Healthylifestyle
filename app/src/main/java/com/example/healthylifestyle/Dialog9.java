package com.example.healthylifestyle;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

public class Dialog9 extends AppCompatActivity {

    Dialog dialog9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog9);

        dialog9 =new Dialog(this);
        dialog9.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog9.setContentView(R.layout.activity_dialog9);

        dialog9.setCancelable(false);

        TextView btnclose = (TextView)dialog9.findViewById(R.id.btnclose);
        btnclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Dialog9.this,RecommendActivity.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {
                }
                dialog9.dismiss();

            }
        });

        dialog9.show();
    }
}