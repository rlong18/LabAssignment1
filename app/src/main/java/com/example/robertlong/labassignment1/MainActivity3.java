package com.example.robertlong.labassignment1;
import com.example.robertlong.labassignment1.FeedReaderContract.FeedEntry;



import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity3 extends AppCompatActivity {
    FeedReaderDbHelper mDbHelper = new FeedReaderDbHelper(this);
    Button add;
    EditText title, des;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        title = (EditText) findViewById(R.id.title);
        des = (EditText) findViewById(R.id.des);
        add = (Button) findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = mDbHelper.getWritableDatabase();

                ContentValues values = new ContentValues();

                values.put(FeedEntry.COLUMN_NAME_TITLE, title.getText().toString());
                values.put(FeedEntry.COLUMN_NAME_SUBTITLE,des.getText().toString());

                long newRowId = 0;
                try {
                    newRowId = db.insertOrThrow(FeedEntry.TABLE_NAME, null, values);
                }catch (Exception ex){
                    Toast.makeText(MainActivity3.this, ex.getMessage().toString(),Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(MainActivity3.this, "Item Added",Toast.LENGTH_SHORT).show();
                finish();
            }
        });


    }
}

