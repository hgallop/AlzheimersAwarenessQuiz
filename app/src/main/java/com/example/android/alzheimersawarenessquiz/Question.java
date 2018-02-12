package com.example.android.alzheimersawarenessquiz;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by doyou on 2/12/2018.
 */

public class Question {

    String questionNumber;
    String questionText;
    String answerExample1;
    String answerExample2;
    String answerExample3;
    String answerExample4;
    String answerExampleNone;
    String toastMessage;

    //constructor for making a question object
    public Question(String questionNumber,
                    String questionText,
                    String answerExample1,
                    String answerExample2,
                    String answerExample3,
                    String answerExample4,
                    String answerExampleNone,
                    String toastMessage){
       this.questionNumber = questionNumber;
       this.questionText = questionText;
       this.answerExample1 = answerExample1;
       this.answerExample2 = answerExample2;
       this.answerExample3 = answerExample3;
       this.answerExample4 = answerExample4;
       this.answerExampleNone = answerExampleNone;
       this.toastMessage = toastMessage;
    }

    //mutator. allows question number to be set
    public void setQuestionNumber(String questionNumberText){
        questionNumber = questionNumberText;
    }

    //accessor. allows question number to be accessed
    public String getQuestionNumber(){
        return questionNumber;
    }

    //mutator. allows question text to be set
    public void setQuestionText(String questionText){
        this.questionText = questionText;
    }

    //accessor. allows question text to be accessed
    public String getQuestionText(){
        return questionText;
    }

    //mutator. allows answer example 1 to be set
    public void setAnswerExample1(String answerExample1){
        this.answerExample1 = answerExample1;
    }

    //accessor. allows answer example 1 to be accessed
    public String getAnswerExample1(){
        return answerExample1;
    }

    //mutator. allows answer example 2 to be set
    public void setAnswerExample2(String answerExample2){
        this.answerExample2 = answerExample2;
    }

    //accessor. allows answer example 2 to be accessed
    public String getAnswerExample2(){
        return answerExample2;
    }

    //mutator. allows answer example 3 to be set
    public void setAnswerExample3(String answerExample3){
        this.answerExample3 = answerExample3;
    }

    //accessor. allows answer example 3 to be accessed
    public String getAnswerExample3(){
        return answerExample3;
    }

    //mutator. allows answer example 4 to be set
    public void setAnswerExample4(String answerExample4){
        this.answerExample4 = answerExample4;
    }

    //accessor. allows answer example 4 to be accessed
    public String getAnswerExample4(){
        return answerExample4;
    }

    //mutator. allows answer example none to be set
    public void setAnswerExampleNone(String answerExampleNone){
        this.answerExampleNone = answerExampleNone;
    }

    //accessor. allows answer example none to be accessed
    public String getAnswerExampleNone(){
        return answerExampleNone;
    }

    //mutator. allows toast message to be set
    public void setToastMessage(String toastMessage){
        this.toastMessage = toastMessage;
    }

    //accessor. allows toast message to be accessed
    public String getToastMessage(){
        return toastMessage;
    }
}
