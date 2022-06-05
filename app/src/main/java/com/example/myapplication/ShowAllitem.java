package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.myapplication.datapack.databasehelper;
import com.example.myapplication.model.item;
public class ShowAllitem extends AppCompatActivity {
    ListView listView;
    ListAdapter adapter;
    ArrayList<String> list;
    String name, type, date, phn, descrp, loc;



    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_allitem);

        listView = findViewById(R.id.listview);
        list =  new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        ArrayList<ArrayList<String>> finalist= new ArrayList<ArrayList<String>>();

        databasehelper db = new databasehelper(this);
        Cursor c = db.fetchAllItem();
        //List<item> itemList = db.fetchAllItem();

        while(c.moveToNext())
        {
            type = c.getString(0);
            name = c.getString(1);
            phn = c.getString(2);
            descrp = c.getString(3);
            date = c.getString(4);
            loc = c.getString(5);
            ArrayList<String> nlist = new ArrayList<>(Arrays.asList(type,name,phn,descrp,date,loc));
            list.add(type+" "+name);
            list2.add(type+" "+name+"\n"+descrp+"\n"+date+"\n"+loc+"\n"+phn);
            finalist.add(nlist);

        }

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);

       listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


           @Override
            public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
                String select = list2.get(pos).toString();

                Intent iIntent = new Intent(ShowAllitem.this, removeitem.class);
                iIntent.putExtra("post_type", finalist.get(pos).get(0));
                iIntent.putExtra("name", finalist.get(pos).get(1));
                iIntent.putExtra("phone", finalist.get(pos).get(2));
                iIntent.putExtra("description", finalist.get(pos).get(3));
                iIntent.putExtra("location", finalist.get(pos).get(5));
                iIntent.putExtra("date", finalist.get(pos).get(4));


                iIntent.putExtra("item", select);
                startActivity(iIntent);
           }
        });
    }
}
