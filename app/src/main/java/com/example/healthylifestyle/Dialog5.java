package com.example.healthylifestyle;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

public class Dialog5 extends AppCompatActivity {

    Dialog dialog5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog5);

        dialog5 =new Dialog(this);
        dialog5.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog5.setContentView(R.layout.activity_dialog5);

        dialog5.setCancelable(false);

        TextView btnclose = (TextView)dialog5.findViewById(R.id.btnclose);
        btnclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Dialog5.this,RecommendActivity.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {
                }
                dialog5.dismiss();

            }
        });

        dialog5.show();
    }
}