package com.example.hirushka.quizwizard;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {


    TextView txt1,txt2,scoretxt,highscoretxt,reviewtxt;
    Button btnreturn;
    int score,highscore;
    public static final String SHARED_PREFS = "sharedprefs";
    public static final String KEY_HIGH_SCORE = "keyhighscore";
    ImageView rewiveimage1,rewiveimage2,rewiveimage3,rewiveimage4;

    //RatingBar ratingBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

       Typeface myCustomFont = Typeface.createFromAsset(getAssets(), "fonts/2 Astro11 sinhala font by Aluth.com.TTF");
        Typeface myfont3 = Typeface.createFromAsset(getAssets(), "fonts/33 FN_Suresh_02 sinhala font by Aluth.com.ttf");
        Typeface myfont4 = Typeface.createFromAsset(getAssets(), "fonts/35 sara_gune sinhala font by Aluth.com.ttf");
        Typeface myCustomFont2 = Typeface.createFromAsset(getAssets(), "fonts/10 FN_Nilanthi  sinhala font by Aluth.com.TTF");

        txt1 = (TextView)findViewById(R.id.textView1);
        txt1.setTypeface(myfont4);

        txt2 = (TextView)findViewById(R.id.textView);
        txt2.setTypeface(myfont4);

        scoretxt = (TextView) findViewById(R.id.score);
        scoretxt.setTypeface(myfont3);

        highscoretxt = (TextView) findViewById(R.id.highscore);
        highscoretxt.setTypeface(myfont3);
        LoadHighScore();

        reviewtxt = (TextView) findViewById(R.id.review);
        reviewtxt.setTypeface(myfont3);
        //ratingBar = (RatingBar)findViewById(R.id.ratingbar);

        btnreturn = (Button)findViewById(R.id.btnreturn);
        btnreturn.setTypeface(myfont4);

        rewiveimage1 = (ImageView) findViewById(R.id.reviewimg1);
        rewiveimage2 = (ImageView) findViewById(R.id.reviewimg2);
        rewiveimage3 = (ImageView) findViewById(R.id.reviewimg3);
        rewiveimage4 = (ImageView) findViewById(R.id.reviewimg4);


        Intent intent = getIntent();
        score = intent.getIntExtra(quiz101.EXTRA_VALUE,0);


        Intent intent1 = getIntent();
        score = intent1.getIntExtra(quiz111.EXTRA_VALUE,0);

        scoretxt.setText(""+score);

        setReview(score);


        if(score>highscore){
            updateHighScore(score);
        }else if(score==highscore){
            updateHighScore(score);
        }

        btnreturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(ResultActivity.this,second.class);
                startActivity(intent1);
            }
        });


    }

    private void updateHighScore(int newHighScore){
        highscore = newHighScore;
        highscoretxt.setText(""+ highscore);

        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_HIGH_SCORE,highscore);
        editor.apply();
    }

    private void LoadHighScore(){

        SharedPreferences prefs= getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        highscore = prefs.getInt(KEY_HIGH_SCORE,0);
        highscoretxt.setText(""+ highscore);

    }

    private void setReview( int score){
        if(score<=3){
            reviewtxt.setText(";j ;j;a W;aiy lrkak ");
            rewiveimage1.setVisibility(View.VISIBLE);
        }else if(score<=6&&score>3){
            reviewtxt.setText("kej; m%Yak lrkak ");
            rewiveimage2.setVisibility(View.VISIBLE);
        }else if(score<=9&&score>6){
            reviewtxt.setText("idr:l jEhuls");
            rewiveimage3.setVisibility(View.VISIBLE);
        }else{
            reviewtxt.setText("w;sjsYsYaghs");
            rewiveimage4.setVisibility(View.VISIBLE);
        }
    }


}
