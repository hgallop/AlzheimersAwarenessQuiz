package com.example.android.alzheimersawarenessquiz;

/**
 * Created to form Question
 */

public class Question {

    private String mQuestionNumber;
    private String mQuestionText;
    private String mAnswerExample1;
    private String mAnswerExample2;
    private String mAnswerExample3;
    private String mAnswerExample4;
    private String mAnswerExampleNone;
    private String mToastMessage;

    //constructor for making a question object
    public Question(String questionNumber,
                    String questionText,
                    String answerExample1,
                    String answerExample2,
                    String answerExample3,
                    String answerExample4,
                    String answerExampleNone,
                    String toastMessage){
       mQuestionNumber = questionNumber;
       mQuestionText = questionText;
       mAnswerExample1 = answerExample1;
       mAnswerExample2 = answerExample2;
       mAnswerExample3 = answerExample3;
       mAnswerExample4 = answerExample4;
       mAnswerExampleNone = answerExampleNone;
       mToastMessage = toastMessage;
    }

    //accessor. allows question number to be accessed
    String getQuestionNumber(){
        return mQuestionNumber;
    }

    //accessor. allows question text to be accessed
    String getQuestionText(){
        return mQuestionText;
    }

    //accessor. allows answer example 1 to be accessed
    String getAnswerExample1(){
        return mAnswerExample1;
    }

    //accessor. allows answer example 2 to be accessed
    String getAnswerExample2(){
        return mAnswerExample2;
    }

    //accessor. allows answer example 3 to be accessed
    String getAnswerExample3(){
        return mAnswerExample3;
    }

    //accessor. allows answer example 4 to be accessed
    String getAnswerExample4(){
        return mAnswerExample4;
    }

    //accessor. allows answer example none to be accessed
    String getAnswerExampleNone(){
        return mAnswerExampleNone;
    }

    //accessor. allows toast message to be accessed
    String getToastMessage(){
        return mToastMessage;
    }
}
