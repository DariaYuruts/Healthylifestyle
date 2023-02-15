package com.example.healthylifestyle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RecommendActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Intent intent = new Intent(RecommendActivity.this, Dialog1.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){

                }

            }
        });

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Intent intent = new Intent(RecommendActivity.this, Dialog2.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){

                }

            }
        });

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Intent intent = new Intent(RecommendActivity.this, Dialog3.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){

                }

            }
        });

        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Intent intent = new Intent(RecommendActivity.this, Dialog4.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){

                }

            }
        });

        Button button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Intent intent = new Intent(RecommendActivity.this, Dialog5.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){

                }

            }
        });

        Button button6 = (Button) findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Intent intent = new Intent(RecommendActivity.this, Dialog6.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){

                }

            }
        });

        Button button7 = (Button) findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Intent intent = new Intent(RecommendActivity.this, Dialog7.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){

                }

            }
        });

        Button button8 = (Button) findViewById(R.id.button8);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Intent intent = new Intent(RecommendActivity.this, Dialog8.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){

                }

            }
        });

        Button button9 = (Button) findViewById(R.id.button9);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Intent intent = new Intent(RecommendActivity.this, Dialog9.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){

                }

            }
        });

        Button button10 = (Button) findViewById(R.id.button10);
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Intent intent = new Intent(RecommendActivity.this, Dialog10.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){

                }

            }
        });
    }
}