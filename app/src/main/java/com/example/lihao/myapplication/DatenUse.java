package com.example.lihao.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

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


    public void UnlockID(String id){
        // Define 'where' part of query.
        String selection = FeedReaderContract.idlockedt.il_ID + " LIKE ?";
        // Specify arguments in placeholder order.
        String[] selectionArgs = { String.valueOf(id) };
        ContentValues values = new ContentValues();
        values.put(FeedReaderContract.idlockedt.il_Locked, 1);
        int count = db.update(
                FeedReaderContract.idlockedt.il_TABLE_NAME,
                values,
                selection,
                selectionArgs);

    }

    public boolean IsUnlockedID(String id) {

        String result="";
        String rowId=id;
        String table=FeedReaderContract.idlockedt.il_TABLE_NAME;

        // Define 'where' part of query.
        String selection = FeedReaderContract.idlockedt.il_ID + " LIKE ?";
        // Specify arguments in placeholder order.
        String[] selectionArgs = { String.valueOf(rowId) };
        Cursor cursor = db.query(table, null, selection, selectionArgs, null, null, FeedReaderContract.idlockedt.il_CID+" desc");

        //获取id列的索引
        int idIndex = cursor.getColumnIndex(FeedReaderContract.idlockedt.il_CID);
        //获取title列的索引
        int locked = cursor.getColumnIndex(FeedReaderContract.idlockedt.il_Locked);
        int i=0;
        for (cursor.moveToFirst();!(cursor.isAfterLast());cursor.moveToNext()) {
            int iflocke=cursor.getInt(idIndex);
            if (1==iflocke){
                return true;
            }
            else{
                return false;
            }
        }
        return false;
    }

    public List<String> GetAllUnlockedIDs(){
        String result="";
        boolean rowId=true;
        String table=FeedReaderContract.idlockedt.il_TABLE_NAME;
        ArrayList<String> listSub=new ArrayList<String>();
        // Define 'where' part of query.
        String selection = FeedReaderContract.idlockedt.il_Locked + " LIKE ?";
        // Specify arguments in placeholder order.
        String[] selectionArgs = { String.valueOf(rowId) };
        Cursor cursor = db.query(table, null, selection, selectionArgs, null, null, FeedReaderContract.idlockedt.il_CID+" desc");

        //获取id列的索引
        int idIndex = cursor.getColumnIndex(FeedReaderContract.idlockedt.il_CID);
        //获取title列的索引
        int listid = cursor.getColumnIndex(FeedReaderContract.idlockedt.il_ID);
        int i=0;
        for (cursor.moveToFirst();!(cursor.isAfterLast());cursor.moveToNext()) {
            TID[i]=i;
            DID[i]=cursor.getString(idIndex);
//            Title[i]=cursor.getString(listid);
            String id=cursor.getString(listid);
            listSub.add(id);
            ++i;
        }
        return listSub;
//        return ;
    }


    public void SetValue(String name, String value){
        ContentValues values = new ContentValues();
        values.put(FeedReaderContract.valuet.v_NAME, name);
        values.put(FeedReaderContract.valuet.v_VALUE, value);
        db.insert(
                FeedReaderContract.valuet.v_TABLE_NAME,
                FeedReaderContract.valuet.v_CID,
                values);
    }

    public String GetValue(String name){
        String result="";
        String table=FeedReaderContract.valuet.v_TABLE_NAME;
        String selection = FeedReaderContract.valuet.v_NAME + " LIKE ?";
        String[] selectionArgs = { String.valueOf(name) };
        Cursor cursor = db.query(table, null, selection, selectionArgs, null, null, FeedReaderContract.valuet.v_CID+" desc");
        int listid = cursor.getColumnIndex(FeedReaderContract.valuet.v_VALUE);
        for (cursor.moveToFirst();!(cursor.isAfterLast());cursor.moveToNext()) {
            result=cursor.getString(listid);
            break;
        }
        return result;
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

        }

    }

    public void setdate(int tid,String Title,String Path){

    }

}
