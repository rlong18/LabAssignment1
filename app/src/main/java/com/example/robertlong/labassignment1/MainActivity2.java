package com.example.robertlong.labassignment1;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;
import android.view.View;
import android.widget.Button;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.util.Patterns;
import android.widget.AdapterView;
import android.support.annotation.Nullable;


import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;



public class MainActivity2 extends AppCompatActivity {
    //TextView fname;
    TextView lname, email;
    Button add;
    FeedReaderDbHelper mDbHelper;
    ListView list;
    MyListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mDbHelper = new FeedReaderDbHelper(this);
        //fname = (TextView) findViewById(R.id._fname);
        lname = (TextView) findViewById(R.id._lname);
        email = (TextView) findViewById(R.id._email);
        add = (Button) findViewById(R.id.add);


        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from Main", null);
        ArrayList<String> title = new ArrayList<>();
        ArrayList<String> subtitle = new ArrayList<>();
        ArrayList<Integer> ids = new ArrayList<>();
        if (cursor.moveToFirst()){
            while(!cursor.isAfterLast()){
                String name1 = cursor.getString(cursor.getColumnIndex("title"));
                String name2 = cursor.getString(cursor.getColumnIndex("des"));
                Integer name3 = cursor.getInt(cursor.getColumnIndex("_id"));

                title.add(name1);
                subtitle.add(name2);
                ids.add(name3);
                cursor.moveToNext();

            }
        }
        adapter= new MyListAdapter(this, title, subtitle, ids);
        list=(ListView)findViewById(R.id.list_view);
        list.setAdapter(adapter);



    }

    @Override
    protected void onStart() {

        super.onStart();
        adapter.notifyDataSetChanged();
        //fname.setText(getIntent().getStringExtra("First name"));
        lname.setText(getIntent().getStringExtra("Last name"));
        email.setText(getIntent().getStringExtra("Email"));
        Toast.makeText(MainActivity2.this, getIntent().getStringExtra("First name"), Toast.LENGTH_SHORT).show();

        mDbHelper = new FeedReaderDbHelper(this);
        add.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);

                startActivity(intent);
            }
        });

        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from Main",null);
        ArrayList<String> title = new ArrayList<>();
        ArrayList<String> subtitle = new ArrayList<>();
        ArrayList<Integer> ids = new ArrayList<>();
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                String name = cursor.getString(cursor.getColumnIndex("title"));
                String name2 = cursor.getString(cursor.getColumnIndex("des"));
                Integer name3 = cursor.getInt(cursor.getColumnIndex("_id"));

                title.add(name);
                subtitle.add(name2);
                ids.add(name3);
                cursor.moveToNext();
            }
        }

        adapter=new MyListAdapter(this, title, subtitle, ids);
        list=(ListView)findViewById(R.id.list_view);
        list.setAdapter(adapter);

    }
}
       // String str[]={"Apple","Ball","Cat"};
       // ArrayAdapter adapter = new ArrayAdapter<String>(MainActivity2.this,R.layout.activity_main3,str);
       // ListView listView = (ListView) findViewById(R.id.info);
       // listView.setAdapter(adapter);









