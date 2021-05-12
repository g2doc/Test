package com.example.test;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


/**
 * 自定义 Service ,并重写相关的方法
 *
 */
class Myservice extends Service {
    private final String TAG = "我的服务：";

    // 必须要实现的方法  onbuild
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG,"onBuild 方法调用");
        return null;
    }

    /* Service 被创建的时候调用 */
    @Override
    public void onCreate() {
        Log.i(TAG,"onCreate 方法调用");
        super.onCreate();
    }


    /* Service 被 启动 的时候调用 */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG,"onStartCommand 方法调用");
        return super.onStartCommand(intent, flags, startId);
    }



    /* Service 被 关闭 之前回调  */
    @Override
    public void onDestroy() {
        Log.i(TAG,"onDestroy 方法调用");
        super.onDestroy();
    }
}

// 自定义完成 Myservice 之后还要在 Manifest.xml 中注册 Service
/*
        <!--配置 service 组件, 同时配置一个 action  -->
        <service
            android:name=".Myservice"
            >
            <intent-filter>
                <action android:name="com.example.zh.service.MY_SERVICE" />
            </intent-filter>
        </service>

 */

public class ServiceTest extends AppCompatActivity {

    private Button bt_startservice;
    private Button bt_stopservice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_test);
    }


    public void Init(){
        bt_startservice = (Button)findViewById(R.id.bt_startservice);
        bt_stopservice = (Button)findViewById(R.id.bt_stopservice);

        // 创建启动 service 的 intent 以及 intent 的属性
        final Intent intent = new Intent();
        intent.setAction("com.example.zh.service.MY_SERVICE");

        bt_startservice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(intent);
            }
        });


        bt_stopservice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(intent);
            }
        });

    }


}