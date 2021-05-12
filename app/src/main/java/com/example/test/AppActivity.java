package com.example.test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

/*
    App 的主界面
 */

public class AppActivity extends AppCompatActivity {
    private Button bt_toDict;
    private Button bt_toVoice;
    private Button bt_toArticle;
    private Button bt_toWordRecord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);
        Init(); 
    }

    void Init(){
        bt_toArticle    = (Button)findViewById(R.id.bt_toArticle);
        bt_toDict       = (Button)findViewById(R.id.bt_toDict);
        bt_toVoice      = (Button)findViewById(R.id.bt_toVoice);
        bt_toWordRecord = (Button)findViewById(R.id.bt_wordRecord);


        bt_toVoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AppActivity.this,EnglishActivity.class);
                intent.putExtra("content", "succ");
                startActivity(intent);

            }
        });

        bt_toDict.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AppActivity.this,StartDictActivity.class);
                intent.putExtra("content","OK");
                startActivity(intent);
                System.out.println("==================================");

            }
        });

        bt_toArticle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AppActivity.this,ArticleActivity.class);
                intent.putExtra("content","OK");
                startActivity(intent);
                System.out.println("==================================");

            }

        });

        bt_toWordRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AppActivity.this,WordRecordActivity.class);
                intent.putExtra("content","OK");
                startActivity(intent);
                System.out.println("==================================");

            }

        });



    }
}