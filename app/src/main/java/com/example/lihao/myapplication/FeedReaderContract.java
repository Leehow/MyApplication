package com.example.lihao.myapplication;

import android.provider.BaseColumns;

/**
 * Created by lihao on 16/6/6.
 */
public final class FeedReaderContract {
    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    public FeedReaderContract() {
    }

    /* Inner class that defines the table contents */
    public static abstract class FeedEntry implements BaseColumns {
        public static final String TABLE_NAME = "entry";
        public static final String COLUMN_NAME_ENTRY_ID = "entryid";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_PATH = "path";
    }

    public static abstract class idlockedt implements BaseColumns {
        public static final String il_TABLE_NAME = "idlocked";
        public static final String il_CID = "il_cid";
        public static final String il_ID = "il_id";
        public static final String il_Locked = "il_locked";
    }
    public static abstract class valuet implements BaseColumns {
        public static final String v_TABLE_NAME = "Nvalue";
        public static final String v_CID = "v_cid";
        public static final String v_NAME = "v_name";
        public static final String v_VALUE = "v_value";
    }





}
