package com.example.hirushka.quizwizard;

import android.database.sqlite.SQLiteOpenHelper;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.hirushka.quizwizard.QuizContract.*;

import java.util.ArrayList;
import java.util.List;


public class QuizDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "quizwizard.db";
    private static final int DATABASE_VERSION = 1;

    private SQLiteDatabase db;


    public QuizDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db= db;

        final String SQLITE_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuizContract.QuizTable.TABLE_NAME + "(" +
                QuizTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuizTable.QUESTION + "TEXT, " +
                QuizTable.OPTION1 + "TEXT, " +
                QuizTable.OPTION2 + "TEXT, " +
                QuizTable.OPTION3 + "TEXT, " +
                QuizTable.OPTION4 + "TEXT, " +
                QuizTable.ANSWER_NR + "INTEGER" +
                ")";

        db.execSQL(SQLITE_CREATE_QUESTIONS_TABLE);
        fillQuestionTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + QuizTable.TABLE_NAME);
        onCreate(db);
    }


    public void fillQuestionTable(){
        Question q1 = new Question("b;sydih wOHkfhaoS f;dr;=re ,nd .; yels uQ,dY% m%Odk jYfhka jr.",";=kls ","y;rls ","yhls","folls",4);
        addQuestion(q1);
        Question q2 = new Question("YS% ,xldfj foaYSh idys;H uQ,dY% w;r jvd;a merKs;u lD;sh jkafka ","uyjxYh","oSmjxYh","qmjxYh","merl=usnd isrs;",2);
        addQuestion(q2);
        Question q3 = new Question("uyjxYh rpkd jS we;af;a","ls%mq 4-5 ishjfiaoSh","ls%j 4-5 ishjfiaoSh","ls%j 5-6 ishjfiaoSh","ls%mq  5-6 ishjfiaoSh",3);
        addQuestion(q3);
        Question q4 = new Question("Y%S ,xldfj b;sydih ms<sn|j f;dr;=re wOHkh l< yels pSk uq,dY%hla jkafka","bnka n=;=;df.a foaYdgk jdr;dj","rsfnhsfrdaf. ,xld b;sydih","mdyshka ysushkaf.a foaYdgk jdr;dj","ne,avshiaf. ,xld mqrdjD;a;h",3);
        addQuestion(q4);
        Question q5 = new Question("Y%S ,xldfj b;sydih yeoErSug bjy,a lr .; yels mqrd jsoHd;aul uq,dY%hla jkafka","wNsf,aLk","ikafoaY ldjH","ygka ldjH","m%Yia;s ldjH",1);
        addQuestion(q5);
        Question q6 = new Question("furg merKs;u Ys,d ,sms y|qkajkq ,nkafka","f,ka ,sms kusks","mqjre ,sms kusks","geus ,sms kusks","n%dyauSh ,sms kusks",4);
        addQuestion(q6);
        Question q7 = new Question(";uka jsiska kqoqgq tfy;a fjk;a wh jsiska mjik ,o f;dr;=re u; msysgd Y%s ,xldj ms<sn|j ;nd we;s jsfoAYSh jdr;djla jkafka","yshqx ishExf.a foYdgk jdr;dj","mdyshka ysushkaf.a foaYdgk jdr;dj","bnka n=;=;df.a foaYdgk jdr;dj","ne,avshiaf. ,xld mqrdjD;a;h",1);
        addQuestion(q7);
        Question q8 = new Question("merKs ldis ms<sn|j yodrk jsYh yoqkajkq ,nkafka","wNsf,aLk f,ih","kdKl jsoHdj f,ih","jdia;= jsoHdj f,ih","fl!;=ld.dr jsoHdj f,ih",2);
        addQuestion(q8);
        Question q9 = new Question("uyjxYhg wra:jsjrKh i|yd iusmdos; lD;sh jkafka","ioaOrud,xldrh","jxi;a:mamldiskS","iSy,gsGl;d uydjxYh","jskhgsGl;d",2);
        addQuestion(q9);
        Question q10 = new Question("furg b;sydih ms<sn|j ,shejS we;s lD;sh jkafka","rcdj,sh","mqcdj,sh","ksldh ix.%yh",":qmjxYh",3);
        addQuestion(q10);
        Question q11 = new Question("bkavsld keu;s lD;sh rpkd lr we;af;a","wersiafgdag,a","ma,Sks","fu.ia;Sksia","fgd,us",3);
        addQuestion(q11);
        Question q12 = new Question("wNsf,aLk jr.hla fkdjkafka","rka ;yvq","mqjre ,sms","oej",";U ;yvq",2);
        addQuestion(q12);
    }


    private void addQuestion(Question question){
        ContentValues cv = new ContentValues();
        cv.put(QuizTable.QUESTION , question.getQuestion());
        cv.put(QuizTable.OPTION1, question.getOption1());
        cv.put(QuizTable.OPTION2, question.getOption2());
        cv.put(QuizTable.OPTION3, question.getOption3());
        cv.put(QuizTable.OPTION4, question.getOption4());
        cv.put(QuizTable.ANSWER_NR, question.getAnswerNo());

        db.insert(QuizTable.TABLE_NAME, null, cv);
    }

    public List<Question> getAllQuestion(){

        List<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuizTable.TABLE_NAME ,null);

        if(c.moveToFirst()){
            do{
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuizTable.QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuizTable.OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuizTable.OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuizTable.OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(QuizTable.OPTION4)));
                question.setAnswerNo(c.getInt(c.getColumnIndex(QuizTable.ANSWER_NR)));
                questionList.add(question);
            }while (c.moveToNext());
        }
        c.close();
        return questionList;
    }




}
