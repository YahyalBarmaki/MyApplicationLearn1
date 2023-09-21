package com.example.myapplicationlearn;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button button;
    EditText editText;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.edit_text);
        button = findViewById(R.id.btn_luck);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputNmae = editText.getText().toString();
                Intent intent = new Intent(
                        getApplicationContext(),
                        SecondActivity.class
                );

                intent.putExtra("name",inputNmae);
                startActivity(intent);
            }

        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.action_search){
            Toast.makeText(
                    this,
                    "You selected search",
                    Toast.LENGTH_LONG).show();
        } else if (itemId == R.id.action_home) {
            Toast.makeText(
                    this,
                    "You selected home",
                    Toast.LENGTH_LONG).show();

        }
        return super.onOptionsItemSelected(item);
    }
}