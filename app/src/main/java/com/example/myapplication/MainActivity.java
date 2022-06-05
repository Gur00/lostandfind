package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button newItem;
    Button showlist;

    //@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newItem = findViewById(R.id.newAdvert);
        showlist = findViewById(R.id.showAll);

        newItem.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, newitems.class);
                startActivity(intent);
            }
        });
        showlist.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShowAllitem.class);
                startActivity(intent);
            }
        });
    }
}