package com.example.hirushka.quizwizard;


import android.provider.BaseColumns;


public final class QuizContract {

    private QuizContract(){}

    public class QuizTable implements BaseColumns{

        public static final String TABLE_NAME = "quiz101";
        public static final String QUESTION = "Question";
        public static final String ANSWER_NR = "AnswerNr";
        public static final String OPTION1 = "Option1";
        public static final String OPTION2 = "Option2";
        public static final String OPTION3 = "Option3";
        public static final String OPTION4 = "Option4";
    }
}


