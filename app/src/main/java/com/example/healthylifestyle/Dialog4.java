package com.example.healthylifestyle;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

public class Dialog4 extends AppCompatActivity {

    Dialog dialog4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog4);

        dialog4 =new Dialog(this);
        dialog4.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog4.setContentView(R.layout.activity_dialog4);

        dialog4.setCancelable(false);

        TextView btnclose = (TextView)dialog4.findViewById(R.id.btnclose);
        btnclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Dialog4.this,RecommendActivity.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {
                }
                dialog4.dismiss();

            }
        });

        dialog4.show();
    }
}