package com.example.hirushka.quizwizard;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txt1;
    private static int SPLASH_TIME= 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt1 = (TextView) findViewById(R.id.welcome);
        Typeface myCustomFont = Typeface.createFromAsset(getAssets(), "fonts/10 FN_Nilanthi  sinhala font by Aluth.com.TTF");
        txt1.setTypeface(myCustomFont);


        txt1 = (TextView) findViewById(R.id.welcome2);
        Typeface myCustomFont2 = Typeface.createFromAsset(getAssets(), "fonts/10 FN_Nilanthi  sinhala font by Aluth.com.TTF");
        txt1.setTypeface(myCustomFont2);

        new Handler().postDelayed(new Runnable(){
          @Override
          public void run(){
              Intent homeIntent = new Intent(MainActivity.this,second.class);
              startActivity(homeIntent);
              finish();
          }
        },SPLASH_TIME);

    }
}
