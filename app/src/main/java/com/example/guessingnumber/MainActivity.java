package com.example.guessingnumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int n;
    String message1 ="";
    int numberOfTimes = 0;

    public void randomNumberGenerator(){
        Random randomNum = new Random();
        n = randomNum.nextInt(1000) + 1;

    }

    public void guess(View view){
        EditText guess = (EditText) findViewById(R.id.guess);
        int guessInt = Integer.parseInt(guess.getText().toString());

        if(n > guessInt) {
            message1 = "Higher!!";
            numberOfTimes++;

        }
        else if(n < guessInt){
            message1 = "Lower!!";
            numberOfTimes++;
        }
        else if(n == guessInt) {
            numberOfTimes++;
            message1 = "Correct! and You guessed all " + numberOfTimes +  " times.";
            randomNumberGenerator();
            numberOfTimes = 0;
        }

        TextView txt = (TextView) findViewById(R.id.result);
        txt.setText(message1);

    }
    public void restart(View view){
        randomNumberGenerator();
        TextView txt = (TextView) findViewById(R.id.result);
        txt.setText("");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        randomNumberGenerator();
    }
}