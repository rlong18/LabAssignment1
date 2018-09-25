package com.example.robertlong.labassignment1;
import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MyListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final ArrayList<String> title;
    private final ArrayList<String> subtitle;
    private final ArrayList<Integer> ids;
    FeedReaderDbHelper mDbHelper;
    SQLiteDatabase db;

    public MyListAdapter(Activity context, ArrayList<String> title, ArrayList<String> subtitle, ArrayList<Integer> ids) {
        super(context, R.layout.activity_main4, title);


        this.context=context;
        this.title=title;
        this.subtitle=subtitle;
        this.ids=ids;
        mDbHelper =  new FeedReaderDbHelper(context);

        db = mDbHelper.getWritableDatabase();
    }

    public View getView(final int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.activity_main4, null,true);

        final TextView titleText = (TextView) rowView.findViewById(R.id.title);
        TextView subtitleText = (TextView) rowView.findViewById(R.id.subtitle);
        Button delete = (Button) rowView.findViewById(R.id.delete);
        titleText.setText(title.get(position));
        subtitleText.setText(subtitle.get(position));

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Item Deleted",Toast.LENGTH_LONG).show();
                db.delete("Main","_id" + "=" + ids.get(position), null);
                context.recreate();
            }
        });
        return rowView;

    };
}


