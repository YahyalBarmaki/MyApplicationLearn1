package com.example.myapplicationlearn;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {
    TextView titleLuck,luckyRandomNum;
    Button shareButton;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        luckyRandomNum = findViewById(R.id.lucky_number_txt);
        shareButton = findViewById(R.id.share_btn);

        Intent i = getIntent();
     String username =   i.getStringExtra("name");

        int luckyNum = randomNum();

        luckyRandomNum.setText(""+luckyNum);
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareLucky(username,luckyNum);
            }
        });


    }



    public  int randomNum(){
        Random random = new Random();
        int upper_limit_num = 100;
        int randomValue = random.nextInt(upper_limit_num);
        return randomValue;
    }

    private void shareLucky(String username, int luckyNum) {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");

        i.putExtra(Intent.EXTRA_SUBJECT,username+" get lucky today!");
        i.putExtra(Intent.EXTRA_TEXT,"His luckyNum is :"+luckyNum);

        startActivity(Intent.createChooser(i,"Choose a plateform"));
    }
}