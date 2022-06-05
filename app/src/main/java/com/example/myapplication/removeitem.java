package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.datapack.databasehelper;

public class removeitem extends AppCompatActivity {
    Button remove;
    TextView details;
    databasehelper db;
    String type,name,descrption,date,location,phone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_removeitem);

        remove = findViewById(R.id.removebutton);
        details = findViewById(R.id.itemdetails);
        db = new databasehelper(this);

        Intent intent = getIntent();

        name= getIntent().getStringExtra("name");
        type= getIntent().getStringExtra("post_type");
        descrption = getIntent().getStringExtra("description");
        date = getIntent().getStringExtra("date");
        location = getIntent().getStringExtra("location");
        phone = getIntent().getStringExtra("phone");

        details.setText(type+" "+name+"\n"+descrption+"\n"+date+"\n"+location);

        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.deleteItem(name, descrption);
                details.setText("");

                }
        });
    }

}