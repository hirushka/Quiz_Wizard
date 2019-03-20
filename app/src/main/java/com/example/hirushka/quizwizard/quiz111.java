package com.example.hirushka.quizwizard;

        import android.content.Context;
        import android.content.DialogInterface;
        import android.content.Intent;
        import android.content.res.ColorStateList;
        import android.database.sqlite.SQLiteDatabase;
        import android.graphics.Color;
        import android.graphics.Typeface;
        import android.os.DropBoxManager;
        import android.provider.MediaStore;
        import android.support.v7.app.AlertDialog;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Button;
        import android.widget.ImageView;
        import android.widget.RadioButton;
        import android.widget.RadioGroup;
        import android.widget.TextView;
        import android.widget.Toast;
        import java.io.FileOutputStream;
        import java.io.IOException;
        import java.io.InputStream;
        import java.io.OutputStream;
        import java.security.Principal;
        import java.util.ArrayList;
        import java.util.Collection;
        import java.util.Collections;
        import java.util.List;
        import java.util.Random;

        import javax.microedition.khronos.egl.EGL10;

public class quiz111 extends AppCompatActivity {

    private Button btnconfirm, btnnext;
    private TextView txt2 , txt3;
    private TextView question;
    private RadioButton radiobtn1,radiobtn2,radiobtn3,radiobtn4;
    private int rightAnswerCount = 0;
    private int quizCount = 1;
    private String rightAnswer;
    private static final int QUIZ_COUNT = 13;
    private RadioGroup radioGroup;
    private ArrayList<ArrayList<String>>  quizArray = new ArrayList<>();
    private ColorStateList defaultcolor;
    private boolean answered;
    public static final String EXTRA_VALUE="Passing rightAnswercount";
    ImageView imageview1,imageview2;
    int category;

    questionBank2 qb = new questionBank2();
    String quizdata1[][] = qb.getQuizdata1();
    String quizdata2[][] = qb.getQuizdata2();
    String quizdata3[][] = qb.getQuizdata3();
    String quizdata4[][]= qb.getQuizdata4();
    String quizdata5[][] = qb.getQuizdata5();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz111);

        btnconfirm = (Button) findViewById(R.id.btnconfirm);
        btnnext = (Button) findViewById(R.id.btnnext);
        Typeface myCustomFont = Typeface.createFromAsset(getAssets(), "fonts/2 Astro11 sinhala font by Aluth.com.TTF");
        btnconfirm.setTypeface(myCustomFont);
        btnnext.setTypeface(myCustomFont);

        Typeface myfont3 = Typeface.createFromAsset(getAssets(), "fonts/33 FN_Suresh_02 sinhala font by Aluth.com.ttf");
        txt2 = (TextView) findViewById(R.id.qno);
        txt2.setTypeface(myfont3);

        txt3 = (TextView) findViewById(R.id.score);
        txt3.setTypeface(myfont3);


        Typeface myfont4 = Typeface.createFromAsset(getAssets(), "fonts/35 sara_gune sinhala font by Aluth.com.ttf");
        question = (TextView) findViewById(R.id.question);
        question.setTypeface(myfont4);

        radiobtn1 = (RadioButton) findViewById(R.id.radio1);
        radiobtn1.setTypeface(myfont4);

        radiobtn2 = (RadioButton) findViewById(R.id.radio2);
        radiobtn2.setTypeface(myfont4);

        radiobtn3 = (RadioButton) findViewById(R.id.radio3);
        radiobtn3.setTypeface(myfont4);

        radiobtn4 = (RadioButton) findViewById(R.id.radio4);
        radiobtn4.setTypeface(myfont4);
        radioGroup = (RadioGroup) findViewById(R.id.radiogroup);
        defaultcolor = radiobtn1.getTextColors();

        imageview1 = (ImageView)findViewById(R.id.thumbsup);
        imageview2 = (ImageView)findViewById(R.id.thumbsdown);



        Intent intent = getIntent();
        category = intent.getIntExtra(thirdGrade11.QUIZ_CATEGORY123,0);


        if(category==1){

            for(int i=0 ; i<quizdata1.length; i++){

                ArrayList<String> tmparray = new ArrayList<>();
                tmparray.add(quizdata1[i][0]);
                tmparray.add(quizdata1[i][1]);
                tmparray.add(quizdata1[i][2]);
                tmparray.add(quizdata1[i][3]);
                tmparray.add(quizdata1[i][4]);

                quizArray.add(tmparray);
            }
        }else if(category==2){
            for(int i=0 ; i<quizdata2.length; i++){

                ArrayList<String> tmparray = new ArrayList<>();
                tmparray.add(quizdata2[i][0]);
                tmparray.add(quizdata2[i][1]);
                tmparray.add(quizdata2[i][2]);
                tmparray.add(quizdata2[i][3]);
                tmparray.add(quizdata2[i][4]);

                quizArray.add(tmparray);
            }

        }else if(category==3){
            for(int i=0 ; i<quizdata3.length; i++){

                ArrayList<String> tmparray = new ArrayList<>();
                tmparray.add(quizdata3[i][0]);
                tmparray.add(quizdata3[i][1]);
                tmparray.add(quizdata3[i][2]);
                tmparray.add(quizdata3[i][3]);
                tmparray.add(quizdata3[i][4]);

                quizArray.add(tmparray);
            }

        } else if(category==4){
            for(int i=0 ; i<quizdata4.length; i++){

                ArrayList<String> tmparray = new ArrayList<>();
                tmparray.add(quizdata4[i][0]);
                tmparray.add(quizdata4[i][1]);
                tmparray.add(quizdata4[i][2]);
                tmparray.add(quizdata4[i][3]);
                tmparray.add(quizdata4[i][4]);

                quizArray.add(tmparray);
            }

        } else if(category==5){
            for(int i=0 ; i<quizdata5.length; i++){

                ArrayList<String> tmparray = new ArrayList<>();
                tmparray.add(quizdata5[i][0]);
                tmparray.add(quizdata5[i][1]);
                tmparray.add(quizdata5[i][2]);
                tmparray.add(quizdata5[i][3]);
                tmparray.add(quizdata5[i][4]);

                quizArray.add(tmparray);
            }

        }

        showNextQuiz();

        btnconfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!answered) {
                    if (radiobtn1.isChecked() || radiobtn2.isChecked() || radiobtn3.isChecked() || radiobtn4.isChecked()) {
                        checkAnswer();
                    } else {
                        Toast.makeText(quiz111.this, "select the answer" , Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });



        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizCount<QUIZ_COUNT) {
                    //  quizCount++;
                    showNextQuiz();
                }else if(quizCount==QUIZ_COUNT){
                    Intent intent = new Intent(quiz111.this,ResultActivity.class);
                    intent.putExtra(EXTRA_VALUE,rightAnswerCount);
                    startActivity(intent);

                }
            }
        });

    }


    public void showNextQuiz(){


        resetButtonGruop();

        txt2.setText("m%Iak wxl  " + quizCount);
        txt3.setText(",l=Kq  " + rightAnswerCount);
        Random random = new Random();
        int randomNr = random.nextInt(quizArray.size());

        ArrayList<String> quiz = quizArray.get(randomNr);

        question.setText(quiz.get(0));
        rightAnswer = quiz.get(1);
        quiz.remove(0);
        Collections.shuffle(quiz);


        radiobtn1.setText(quiz.get(0));
        radiobtn2.setText(quiz.get(1));
        radiobtn3.setText(quiz.get(2));
        radiobtn4.setText(quiz.get(3));

        answered = false;
        quizArray.remove(randomNr);
        quizCount++;

    }


    public void checkAnswer(){
        answered = true;
        RadioButton answerbtn = findViewById(radioGroup.getCheckedRadioButtonId());
        String btntext = answerbtn.getText().toString();


        if (btntext.equals(rightAnswer)) {
            answerbtn.setTextColor(Color.GREEN);
            rightAnswerCount++;
            txt3.setText(",l=Kq  " + rightAnswerCount);
            imageview1.setVisibility(View.VISIBLE);

        } else {
            answerbtn.setTextColor(Color.RED);
            imageview2.setVisibility(View.VISIBLE);
            //Toast.makeText(quiz101.this,"ksjeros ms<s;=r  " + rightAnswer,Toast.LENGTH_SHORT).show();
        }

    }


    public void resetButtonGruop(){
        imageview1.setVisibility(View.GONE);
        imageview2.setVisibility(View.GONE );
        radiobtn1.setTextColor(defaultcolor);
        radiobtn2.setTextColor(defaultcolor);
        radiobtn3.setTextColor(defaultcolor);
        radiobtn4.setTextColor(defaultcolor);
        radioGroup.clearCheck();
    }


    public void quizFinish(){
        finish();

    }

}


