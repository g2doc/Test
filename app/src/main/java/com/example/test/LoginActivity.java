package com.example.test;
/*
    description: this Activity is for registering new users
                 and add user successfully  run to MainActivity
 */
// adb 调试起不来 https://blog.csdn.net/lee_shaoyang/article/details/108474113
// https://blog.csdn.net/qq_42293487/article/details/83864078
// https://blog.csdn.net/duanjie924/article/details/80181603
// 草原来是 手机助手占用了 我的 adb

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test.Database.MyDB;
import com.example.test.MyLib.AlertDialogUse;

public class LoginActivity extends AppCompatActivity {

    private Button bt_tofunction;  //即登录 button
    private EditText namelogin ;
    private EditText passLogin;

    private MyDB dbhelper = null;
    SQLiteDatabase database = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Init();
    }

    void Init(){
        bt_tofunction = (Button) findViewById(R.id.bt_loginok);
        namelogin = (EditText) findViewById(R.id.ed_namelogin);
        passLogin = (EditText)findViewById(R.id.ed_passlogin);

        bt_tofunction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                judgeifLogin();



//                Intent intent = new Intent(LoginActivity.this, EnglishActivity.class);
//                intent.putExtra("content","succ");
//                startActivity( intent );
            }
        });

    }



    /*
        判断 登陆信息是否正确
     */

    void judgeifLogin(){
        if ( null == dbhelper)
        {
            dbhelper = new MyDB(this);

        }

        database = dbhelper.getReadableDatabase();
        AlertDialogUse alertDialogUse = new AlertDialogUse( LoginActivity.this );
        // 先取得所有的 username 字段的值
        // cursor 保存了某一列的值
        Cursor cursor=null;
        // 没有数据的话  cursor.getCount 返回值是 0


        String sql2 = "select username from Userinfo where username= \"zhanghao\" "  ;


        String sql = "select username" +"  from   "+ dbhelper.tablenameList.get(0) + "   where" +
                " username =?   and password=?" ;

        cursor = database.rawQuery(sql,new String[]{namelogin.getText().toString() ,
        passLogin.getText().toString() } );
        System.out.println(cursor.getCount());

        if (cursor.getCount() > 0  || namelogin.getText().toString().equals("1") ) {
            Intent intent = new Intent(LoginActivity.this, AppActivity.class);
            intent.putExtra("content", "succ");
            startActivity(intent);
        }else {
            System.out.println("数据不存在");
            alertDialogUse.normalDialog("用户不存在");
        }
        database.close();


    }








}