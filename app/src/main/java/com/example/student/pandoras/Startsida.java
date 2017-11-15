package com.example.student.pandoras;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Startsida extends AppCompatActivity {
    public Qude myQude;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        myQude = new Qude();
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
        TextView textViewer = findViewById(R.id.textView3);
        textViewer.setText(myQude.getQuestion().concat(Integer.toString(myQude.getRandomNumber())));
    }
    public void openInfo(View v) {
        v.setBackgroundResource(R.color.colorPrimaryDark);
    }

    public void add_question(View v){
        EditText textWriter = findViewById(R.id.editText);
        if(textWriter.getText().toString() != ""){
            myQude.addQuestion(new Question(textWriter.getText().toString()));
            textWriter.setText("Du har lagt till en fråga");
        }

    }
    public void next_question(View v) {
        myQude.removeQuestion();
        TextView textViewer = findViewById(R.id.textView3);
        textViewer.setText(myQude.getQuestion().concat(Integer.toString(myQude.getRandomNumber())));
        Button buttonChangeText = findViewById(R.id.button4);
        buttonChangeText.setText(getResources().getString(R.string.new_game));
    }

}
