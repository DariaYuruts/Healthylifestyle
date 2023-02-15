package com.example.healthylifestyle;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

public class Dialog3 extends AppCompatActivity {

    Dialog dialog3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog3);

        dialog3 =new Dialog(this);
        dialog3.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog3.setContentView(R.layout.activity_dialog3);

        dialog3.setCancelable(false);

        TextView btnclose = (TextView)dialog3.findViewById(R.id.btnclose);
        btnclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Dialog3.this,RecommendActivity.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {
                }
                dialog3.dismiss();

            }
        });

        dialog3.show();
    }
}