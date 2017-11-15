package com.example.student.pandoras;


/**
 * Created by Student on 2017-11-15.
        */


import java.util.ArrayList;
public class Qude {

    private ArrayList<Question> questionList;
    private int i;
    private int randomNumber;


    public Qude(){
        questionList = new ArrayList<Question>();
        i = 0;
    }
    //addquestion
    public void addQuestion(Question quest){
        questionList.add(quest);
        increaseI();
    }
    //remove question
    public void removeQuestion(){
            questionList.remove(randomNumber);
            decreaseI();

    }
    //get question
    public String getQuestion(){
        randomInt();
        return questionList.get(randomNumber).getQuestion();
    }
    //use i
    public void increaseI(){
        i++;
    }
    public void decreaseI(){
        i--;
    }
    public void randomInt(){
        randomNumber = (int)Math.round(Math.random()* i);
    }
    public int getRandomNumber(){
        return randomNumber;
    }
}
