package com.example.healthylifestyle;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

public class Dialog6 extends AppCompatActivity {

    Dialog dialog6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog6);

        dialog6 =new Dialog(this);
        dialog6.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog6.setContentView(R.layout.activity_dialog6);

        dialog6.setCancelable(false);

        TextView btnclose = (TextView)dialog6.findViewById(R.id.btnclose);
        btnclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Dialog6.this,RecommendActivity.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {
                }
                dialog6.dismiss();

            }
        });

        dialog6.show();
    }
}