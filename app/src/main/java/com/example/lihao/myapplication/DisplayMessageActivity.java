package com.example.lihao.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        // Get the message from the intent
//        Intent intent = getIntent();
//        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);



        //Datenbank Class
        String result = "";
        DatenUse re=new DatenUse(this);
        re.listDaten();

        for (int i:re.TID){
            result = result + re.TID[i]+ "\t\t";
            result = result + re.Title[i]+ "\t\t";
            result = result + re.Path[i]+"       \n";
        }
        String message =result;


        // Create the text view
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(message);


        // Set the text view as the activity layout
        setContentView(textView);
    }

    public void backb(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}
