package com.example.student.pandoras;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
    public void openQuestion(View v) {
        if(myQude.getI() != 0){
            setContentView(R.layout.questionpage);
            TextView textViewer = findViewById(R.id.textView3);
            textViewer.setText(myQude.getQuestion().concat(Integer.toString(myQude.getRandomNumber())));
        }
        else{
            setContentView(R.layout.questionpage);
            TextView textViewer = findViewById(R.id.textView3);
            textViewer.setText("Inga frågor gå tillbaka?");
            Button buttonChangeText = findViewById(R.id.button4);
            buttonChangeText.setVisibility(View.VISIBLE);
            Button buttonChangeVisible = findViewById(R.id.button9);
            buttonChangeVisible.setVisibility(View.GONE);
        }
    }
    public void openInfo(View v) {
        v.setBackgroundResource(R.color.colorPrimaryDark);
    }
    public void clean(View v) {
        EditText text = findViewById(R.id.editText);
        text.setText("");
    }

    public void add_question(View v){
        EditText textWriter = findViewById(R.id.editText);

        if(!textWriter.getText().toString().isEmpty()){
            myQude.addQuestion(new Question(textWriter.getText().toString()));
            textWriter.setText("Du har lagt till en fråga");
        }
        else{
            // 1. Instantiate an AlertDialog.Builder with its constructor
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            // 2. Chain together various setter methods to set the dialog characteristics
                builder.setMessage(R.string.aleart_text).setTitle(R.string.alert_rubric);

            builder.setPositiveButton(R.string.alert_button, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) { }
            });
            // 3. Get the AlertDialog from create()
                AlertDialog dialog = builder.create();

                dialog.show();
        }

    }

    public void next_question(View v) {
        if(myQude.getI() > 1) {
            myQude.removeQuestion();
            TextView textViewer = findViewById(R.id.textView3);
            textViewer.setText(myQude.getQuestion().concat(Integer.toString(myQude.getRandomNumber())));
        }
        else{
            myQude.removeQuestion();
            TextView textViewer = findViewById(R.id.textView3);
            textViewer.setText(R.string.text_end);
            Button buttonChangeText = findViewById(R.id.button4);
            buttonChangeText.setVisibility(View.VISIBLE);
            Button buttonChangeVisible = findViewById(R.id.button9);
            buttonChangeVisible.setVisibility(View.GONE);
        }
    }

}
