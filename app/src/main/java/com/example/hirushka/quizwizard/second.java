package com.example.hirushka.quizwizard;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class second extends AppCompatActivity {

    TextView txt1;
    ImageButton imgbtn1;
    ImageButton imgbtn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        txt1 = (TextView) findViewById(R.id.textView);
        Typeface myCustomFont = Typeface.createFromAsset(getAssets(), "fonts/10 FN_Nilanthi  sinhala font by Aluth.com.TTF");
        txt1.setTypeface(myCustomFont);

        txt1 = (TextView) findViewById(R.id.textView2);
        Typeface myCustomFont2 = Typeface.createFromAsset(getAssets(), "fonts/10 FN_Nilanthi  sinhala font by Aluth.com.TTF");
        txt1.setTypeface(myCustomFont2);

       imgbtn1= (ImageButton) findViewById(R.id.imageButton1);
        imgbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeintent = new Intent(second.this,thirdGrade10.class);
                startActivity(homeintent);

            }
        });

        imgbtn2= (ImageButton) findViewById(R.id.imageButton2);
        imgbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeintent = new Intent(second.this,thirdGrade11.class);
                startActivity(homeintent);

            }
        });

    }


}
