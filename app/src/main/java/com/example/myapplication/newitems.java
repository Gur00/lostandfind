package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.datapack.databasehelper;
import com.example.myapplication.model.item;


public class newitems  extends AppCompatActivity {
    Button save;
    TextView name, phn, date, location, descrp;
    RadioButton lost, found;
    boolean postcliked=true;
    databasehelper db;
    item item;

    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newitems);
        lost = findViewById(R.id.lost);
        found = findViewById(R.id.found);
        save = findViewById(R.id.Save);
        name = findViewById(R.id.entername);
        phn = findViewById(R.id.enterphn);
        date = findViewById(R.id.enterdate);
        location = findViewById(R.id.enterloc);
        descrp = findViewById(R.id.enterdesp);

        item = new item();
        databasehelper db = new databasehelper(this);


        lost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(newitems.this, "Selected: lost", Toast.LENGTH_LONG).show();
                postcliked = true;
                item.setPost_type("Lost");
                lost.setChecked(true);

            }
        });

        found.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                postcliked = true;
                found.setChecked(true);
                item.setPost_type("Found");
                Toast.makeText(newitems.this, "Selected F!", Toast.LENGTH_LONG).show();

            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name.getText().toString().isEmpty())
                {
                    Toast.makeText(newitems.this, "Please enter name", Toast.LENGTH_LONG).show();
                }
                else
                {
                    item.setName(name.getText().toString());
                }
                if(phn.getText().toString().isEmpty())
                {
                    Toast.makeText(newitems.this, "Please enter Phone number", Toast.LENGTH_LONG).show();
                }
                else
                {
                    item.setPhn(Integer.parseInt(phn.getText().toString()));
                }
                if(descrp.getText().toString().isEmpty())
                {
                    Toast.makeText(newitems.this, "Please enter the description", Toast.LENGTH_LONG).show();
                }
                else
                {
                    item.setDescrp(descrp.getText().toString());
                }
                if(date.getText().toString().isEmpty())
                {
                    Toast.makeText(newitems.this, "Please enter date", Toast.LENGTH_LONG).show();
                }
                else
                {
                    item.setDate(date.getText().toString());
                }
                if(location.getText().toString().isEmpty())
                {
                    Toast.makeText(newitems.this, "Please enter location", Toast.LENGTH_LONG).show();
                }
                else
                {
                    item.setLocation(location.getText().toString());
                }
                if(!postcliked)
                {
                    Toast.makeText(newitems.this, "Please select post type", Toast.LENGTH_LONG).show();
                }

                boolean allTrue = !name.getText().toString().isEmpty()&&!phn.getText().toString().isEmpty()&&!descrp.getText().toString().isEmpty()&&!date.getText().toString().isEmpty()&&!location.getText().toString().isEmpty()&&!(item.getPost_type().isEmpty());
                if(postcliked&&allTrue){

                    postcliked = false;
                    long result  = db.insertItem(item);

                    if(result > 0){
                        Toast.makeText(newitems.this, "Saved!!", Toast.LENGTH_LONG).show();

                        Intent intent = new Intent(newitems.this,MainActivity.class);
                        startActivity(intent);

                    }
                    else
                        {
                        Toast.makeText(newitems.this,"Not Saved!",Toast.LENGTH_LONG).show();
                    }
                }


            }
        });
    }
}
