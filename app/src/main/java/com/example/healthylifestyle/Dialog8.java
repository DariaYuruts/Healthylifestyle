package com.example.healthylifestyle;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

public class Dialog8 extends AppCompatActivity {

    Dialog dialog8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog8);

        dialog8 =new Dialog(this);
        dialog8.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog8.setContentView(R.layout.activity_dialog8);

        dialog8.setCancelable(false);

        TextView btnclose = (TextView)dialog8.findViewById(R.id.btnclose);
        btnclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Dialog8.this,RecommendActivity.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {
                }
                dialog8.dismiss();

            }
        });

        dialog8.show();
    }
}