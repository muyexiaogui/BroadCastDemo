package lhx.com.broadcastdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;
/**
 * 使用步骤
 * 1、新建一个类继承BroadcastReceiver  重写onReceive方法
 * 2、在AndroidManifest文件中注册广播receiver 声明intent-filter 指定action
 * 3、添加权限android.permission.RECEIVE_BOOT_COMPLETED
 * **/

public class BootCompleteReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"Boot Complete",Toast.LENGTH_SHORT).show();
        Log.e("info", "接收到开机广播");
    }
}
