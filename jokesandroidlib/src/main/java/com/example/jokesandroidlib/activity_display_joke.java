package com.example.jokesandroidlib;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class activity_display_joke extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_joke);
        TextView text_joke =(TextView)findViewById(R.id.text_joke);

        String ResultForJoke = null;

        Intent intent = getIntent();
        ResultForJoke = intent.getStringExtra("result");

        if (ResultForJoke != null) {
            text_joke.setText(ResultForJoke);
        } else {
            text_joke.setText("Q. What did the big flower say to the little flower?\n" +
                    "\n" +"A. Hi, bud!");
        }
    }

}

