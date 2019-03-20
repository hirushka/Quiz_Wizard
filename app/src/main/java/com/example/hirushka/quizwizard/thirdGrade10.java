package com.example.hirushka.quizwizard;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class thirdGrade10 extends AppCompatActivity {

    Button btnls1;
    Button btnls2;
    Button btnls3;
    Button btnls4;
    Button btnls5;


    
    TextView txt1;
    int category;
    public static final String QUIZ_CATEGORY = "passing quiz category";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_grade10);

        txt1 = (TextView) findViewById(R.id.textView3);
        Typeface myCustomFont2 = Typeface.createFromAsset(getAssets(), "fonts/10 FN_Nilanthi  sinhala font by Aluth.com.TTF");
        txt1.setTypeface(myCustomFont2);

        btnls2 = (Button) findViewById(R.id.button2);
        Typeface myCustomFont = Typeface.createFromAsset(getAssets(), "fonts/2 Astro11 sinhala font by Aluth.com.TTF");
        btnls2.setTypeface(myCustomFont);

        btnls1 = (Button) findViewById(R.id.button1);
        btnls1.setTypeface(myCustomFont);

        btnls3 = (Button) findViewById(R.id.button3);
        btnls3.setTypeface(myCustomFont);

        btnls4 = (Button) findViewById(R.id.button4);
        btnls4.setTypeface(myCustomFont);

        btnls5 = (Button) findViewById(R.id.button5);
        btnls5.setTypeface(myCustomFont);

    }



    public void startquiz(View view) {

        category=0;

        switch (view.getId()){
            case R.id.button1:
                category = 1;
                break;

            case R.id.button2:
                category =2;
                break;

            case R.id.button3:
                category=3;
                break;

            case R.id.button4:
                category=4;
                break;

            case R.id.button5:
                category=5;
                break;

        }

        Intent intent = new Intent(thirdGrade10.this,quiz101.class);
        intent.putExtra(QUIZ_CATEGORY,category);
        startActivity(intent);
    }
}
