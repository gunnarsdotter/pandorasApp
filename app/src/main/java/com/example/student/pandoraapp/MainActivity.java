package com.example.student.pandoraapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void initGame() {

    }
    public void que(View v){
        TextView text=(TextView)findViewById(R.id.textView);
        text.setText("Fungerar");
    }
    public void start(View v){
        setContentView(R.layout.layout);
    }

}
