package com.example.lihao.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by lihao on 16/6/20.
 */
public class DatenUse {
    public int[] TID=new int[5];
    public String[] DID=new String[5],Title=new String[5],Path=new String[5];
    public SQLiteDatabase db;
    //insert date

    public DatenUse(Context context){
        FeedReaderDbHelper mDbHelper = new FeedReaderDbHelper(context);
        db = mDbHelper.getWritableDatabase();
    }

    public void insert_tp(String Insert_Title, String Insert_Path){
// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE, Insert_Title);
        values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_PATH, Insert_Path);


// Insert the new row, returning the primary key value of the new row

        db.insert(
                FeedReaderContract.FeedEntry.TABLE_NAME,
                FeedReaderContract.FeedEntry.COLUMN_NAME_ENTRY_ID,
                values);

    }

    public void listDaten(){
        String result="";
        Cursor cursor = db.query(FeedReaderContract.FeedEntry.TABLE_NAME, null, null, null, null, null, FeedReaderContract.FeedEntry._ID+" desc");

        //获取id列的索引
        int idIndex = cursor.getColumnIndex(FeedReaderContract.FeedEntry._ID);
        //获取title列的索引
        int titleIndex = cursor.getColumnIndex(FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE);
        //获取level列的索引
        int contIndex = cursor.getColumnIndex(FeedReaderContract.FeedEntry.COLUMN_NAME_PATH);
        int i=0;
        for (cursor.moveToFirst();!(cursor.isAfterLast());cursor.moveToNext()) {
            TID[i]=i;
            DID[i]=cursor.getString(idIndex);
            Title[i]=cursor.getString(titleIndex);
            Path[i]=cursor.getString(contIndex);
//            DID[i]=cursor.getString(idIndex);
            ++i;
            if (5==i){
                break;
            }

//            result = result + cursor.getString(idIndex)+ "\t\t";
//            result = result + cursor.getString(titleIndex)+ "\t\t";
//            result = result + cursor.getString(contIndex)+"       \n";
        }

    }

    public void setdate(int tid,String Title,String Path){

    }

}
