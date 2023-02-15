package com.example.healthylifestyle;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

public class Dialog10 extends AppCompatActivity {

    Dialog dialog10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog10);

        dialog10 =new Dialog(this);
        dialog10.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog10.setContentView(R.layout.activity_dialog10);

        dialog10.setCancelable(false);

        TextView btnclose = (TextView)dialog10.findViewById(R.id.btnclose);
        btnclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Dialog10.this,RecommendActivity.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {
                }
                dialog10.dismiss();

            }
        });

        dialog10.show();
    }
}