package com.example.lihao.myapplication;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.mycompany.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();



        DatenUse re=new DatenUse(this);
        re.insert_tp(message,"www.google.com");


        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }
    public void jump(View view){
        Intent intent = new Intent(this, mainac.class);
        startActivity(intent);
    }
}
