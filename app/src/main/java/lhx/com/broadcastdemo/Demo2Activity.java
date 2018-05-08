package lhx.com.broadcastdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 *
 * 发送自定义广播
 *
 * 步骤：
 * 1、通过Intent 定义一个广播，指定广播的action
 * 2、通过sendBroadcast将Intent的发送出去
 * 3、自定义一个广播接收器继承BroadcastReceiver，重写Onreceiver（）方法
 * 4、在AndroidManifest中声明receiver，指定action为自己指定的广播action（必须完全一致）
 **/

public class Demo2Activity extends AppCompatActivity {

    private Button mBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo2);
        mBtn = (Button)findViewById(R.id.activity_demo2_btn);
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("com.example.broadcast.MY_BROADCAST");
                //发送普通广播
               // sendBroadcast(intent);
                // 发送有序广播
                sendOrderedBroadcast(intent,null);
            }
        });

    }
}
