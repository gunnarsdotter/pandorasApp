package com.example.student.pandoras;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Startsida extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startsida);
    }

    public void openStartsida(View v){
        setContentView(R.layout.startsida);
    }
    public void openAddQuestion(View v){
        setContentView(R.layout.add_questionpage);
    }
    public void openQuestion(View v){
        setContentView(R.layout.questionpage);
    }

}
