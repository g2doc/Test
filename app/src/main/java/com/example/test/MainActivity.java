package com.example.test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test.Database.MyDB;


public class MainActivity extends AppCompatActivity {
    //@ 成员变量 member variate
    private Button bt_toData ;
    private Button bt_toRegister;
    private Button bt_login;


    //private MyDBHelper myDBHelper;
    //private MyDBHelper myDBHelper;
    private MyDB myDBHelper;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }


    // @初始化控件和功能
    public void initView(){
//        ArrayList<String> columnList = new ArrayList<String>();
//        columnList.add("username");
//        columnList.add("password");
//        columnList.add("passwordQuestion");
//        columnList.add("passwordAnswer");
//        columnList.add("studyLevel");
//        for (String i : columnList){
//            System.out.println(i);
//        }
//        System.out.println( columnList.get(1) ); // 0是 username 1 是 password


        // bind < 绑定控件和 variates >
        bt_toData       = (Button) findViewById(R.id.bt_todata);
        bt_login        = (Button) findViewById(R.id.bt_login);
        bt_toRegister   = (Button) findViewById(R.id.bt_toRegister);


        bt_toData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( MainActivity.this, ServiceTest.class );
                intent.putExtra("content","OK!");
                startActivity( intent );
                // 最简单 的跳转, 第一种, 无返回值

            }
        });

        bt_login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                intent.putExtra("content","succ");
                startActivity( intent );
            }
        });

        bt_toRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                intent.putExtra("content","toRegisterOK");
                startActivity( intent );
            }
        });

    }

}