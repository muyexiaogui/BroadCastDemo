package lhx.com.broadcastdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyBroadCastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"接受到的广播",Toast.LENGTH_SHORT).show();
        Log.e("info","我收到的一个自定义广播");
        abortBroadcast();
    }
}
