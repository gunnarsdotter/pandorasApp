package com.example.student.pandoras;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.text.method.ScrollingMovementMethod;


public class Startsida extends AppCompatActivity {
    public Qude myQude;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        myQude = new Qude();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startsida);
        final Button button = findViewById(R.id.button);
        button.setBackgroundResource(R.drawable.spelaknapp);

    }
    public void openStartsida(View v){
        setContentView(R.layout.startsida);
    }
    public void openAddQuestion(final View v){

        setContentView(R.layout.add_questionpage);

        final Button buttonChange = findViewById(R.id.button6);
        buttonChange.setEnabled(false);
        buttonChange.setBackgroundResource(R.drawable.laggtillfragagra);
        Button buttonChange2 = findViewById(R.id.button7);
        buttonChange2.setBackgroundResource(R.drawable.oppnakistangra);
        buttonChange2.setEnabled(false);

        final EditText editText = findViewById(R.id.editText);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                bottomChange(v);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        //Enter funkar om knappen är enter så i visa fall
        editText.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN)
                    if ((keyCode == KeyEvent.KEYCODE_DPAD_CENTER) || (keyCode == KeyEvent.KEYCODE_ENTER)) {
                        add_question(v);
                        return true;
                    }
                return false;
            }
        });
    }

    public void openQuestion(View v) {
        if(myQude.getI() != 0){
            setContentView(R.layout.questionpage);
            TextView textViewer = findViewById(R.id.textView3);
            textViewer.setText(myQude.getQuestion());
            textViewer.setMovementMethod(new ScrollingMovementMethod());
            final Button button = findViewById(R.id.button9);
            button.setBackgroundResource(R.drawable.nastafragaknapp);   ///nästa fråga knapp

            final Button button1 = findViewById(R.id.button5);
            button1.setBackgroundResource(R.drawable.laggtrillfragaknapp);
        }
       /* else{
            //TextView textViewer = findViewById(R.id.textView3);
            //textViewer.setText("Inga frågor gå tillbaka?");
            //Button buttonChangeText = findViewById(R.id.button4);
            //buttonChangeText.setVisibility(View.VISIBLE);
        }*/

    }
    public void openInfo1(View v) {
        // 1. Instantiate an AlertDialog.Builder with its constructor
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // 2. Chain together various setter methods to set the dialog characteristics
        builder.setMessage(R.string.alert_info_text1).setTitle(R.string.alert_info);
        builder.setPositiveButton(R.string.alert_button, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) { }
        });

        // 3. Get the AlertDialog from create()
        AlertDialog dialog = builder.create();
        dialog.show();

    }
    public void openInfo2(View v) {
        // 1. Instantiate an AlertDialog.Builder with its constructor
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // 2. Chain together various setter methods to set the dialog characteristics
        builder.setMessage(R.string.alert_info_text2).setTitle(R.string.alert_info);

        builder.setPositiveButton(R.string.alert_button, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) { }
        });
        // 3. Get the AlertDialog from create()
        AlertDialog dialog = builder.create();
        dialog.show();
    }
    public void openInfo3(View v) {
        // 1. Instantiate an AlertDialog.Builder with its constructor
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // 2. Chain together various setter methods to set the dialog characteristics
        builder.setMessage(R.string.alert_info_text4).setTitle(R.string.alert_info);

        builder.setPositiveButton(R.string.alert_button, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) { }
        });
        // 3. Get the AlertDialog from create()
        AlertDialog dialog = builder.create();
        dialog.show();
    }


    public void bottomChange(View v){
        Button buttonChange = findViewById(R.id.button6);
        buttonChange.setBackgroundResource(R.drawable.laggtrillfragaknapp);
        buttonChange.setEnabled(true);
       // getKeybord();
    }
    public void add_question(View v){
        EditText textWriter = findViewById(R.id.editText);
        if(!textWriter.getText().toString().isEmpty()){
            myQude.addQuestion(new Question(textWriter.getText().toString()));
            textWriter.setText("");
            textWriter.setHint("Lägg till en ny fråga");
            Button buttonChange = findViewById(R.id.button7);
            //Om man vill ha en ny bakgrundsbild när man har lagt till en fråga. Glöm inte att sätta de som ändring när man öppnar sidan. (open add_question)
            buttonChange.setBackgroundResource(R.drawable.oppnakistanknapp);
            buttonChange.setEnabled(true);

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
            textViewer.setText(myQude.getQuestion());

            myQude.increas();
            TextView rubric = findViewById(R.id.textView);
            rubric.setText("Fråga ".concat(Integer.toString(myQude.getNumber())));
        }
        else{
            myQude.removeQuestion();
            TextView textViewer = findViewById(R.id.textView3);
            textViewer.setText(" ");
            myQude.setNumber(1);

            ImageView kista = findViewById(R.id.kista);
            kista.setVisibility(View.VISIBLE);
            TextView rubric = findViewById(R.id.textView);
            rubric.setText(R.string.text_end);
            //Button buttonChangeText = findViewById(R.id.button4);
            //buttonChangeText.setVisibility(View.VISIBLE);
            Button buttonChangeVisible = findViewById(R.id.button9);
            buttonChangeVisible.setBackgroundResource(R.drawable.spelanyrundaknapp);
            buttonChangeVisible.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    openAddQuestion(view);
                }
            });
            //buttonChangeVisible.setVisibility(View.GONE);
            Button buttonchangeble = findViewById(R.id.button5);
            buttonchangeble.setBackgroundResource(R.drawable.huvudmenyknapp); ///huvudmeny knapp
            buttonchangeble.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    openStartsida(view);
                }
            });
        }
    }

    public void getKeybord(){
        InputMethodManager im = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        im.toggleSoftInput( InputMethodManager.SHOW_FORCED, 0);
    }
    public void hideKeybord(View v){
        InputMethodManager im = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        im.hideSoftInputFromWindow(v.getWindowToken(), 0);

    }


    public void laggTill(View v){
        //öppna add_question
        setContentView(R.layout.add_questionpage);
        //sätter knapparna enabel
        /*final Button buttonChange = findViewById(R.id.button6);
        buttonChange.setEnabled(false);
        buttonChange.setBackgroundResource(R.drawable.laggtillfragagra);
        Button buttonChange2 = findViewById(R.id.button7);
        buttonChange2.setBackgroundResource(R.drawable.oppnakistangra);
        buttonChange2.setEnabled(false);*/
        //Sätter att skrivbordet skulle upp
        bottomChange(v);
        bottomChange(v);
        final EditText editText = findViewById(R.id.editText);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //bottomChange(v);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        //Enter funkar om knappen är enter så i visa fall
        editText.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN)
                    if ((keyCode == KeyEvent.KEYCODE_DPAD_CENTER) || (keyCode == KeyEvent.KEYCODE_ENTER)) {
                        add_question(v);
                        return true;
                    }
                return false;
            }
        });
    }

}
