package lhx.com.anotherbroadcastdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class AnotherBroadCastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"另外一个项目接受的广播",Toast.LENGTH_SHORT).show();
        Log.e("info", "另外一个项目接受的广播");
    }
}
