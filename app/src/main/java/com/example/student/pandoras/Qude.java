package com.example.student.pandoras;


/**
 * Created by Student on 2017-11-15.
        */


import java.util.ArrayList;
public class Qude {

    private ArrayList<Question> questionList;
    private int randomNumber;


    public Qude(){
        questionList = new ArrayList<Question>();
    }
    //addquestion
    public void addQuestion(Question quest){
        questionList.add(quest);
    }
    //remove question
    public void removeQuestion(){
            questionList.remove(randomNumber);
    }
    //get question
    public String getQuestion(){
        randomInt();
        return questionList.get(randomNumber).getQuestion();
    }

    public void randomInt(){
        randomNumber = (int)Math.round(Math.random()* (getI()-1));
    }
    public int getRandomNumber(){
        return randomNumber;
    }
    public int getI(){return questionList.size();}
}


   /*use i
    public void increaseI(){
        i++;
    }
    public void decreaseI(){
        i--;
    }*/