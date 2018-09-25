package com.example.robertlong.labassignment1;


import android.provider.BaseColumns;

public final class FeedReaderContract {

    private FeedReaderContract() {}


    public static class FeedEntry implements BaseColumns {
        public static final String TABLE_NAME = "Main";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_SUBTITLE = "des";
    }
}

