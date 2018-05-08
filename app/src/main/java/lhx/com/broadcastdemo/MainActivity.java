package lhx.com.broadcastdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

/**
 * 使用广播进行网络监听
**/

public class MainActivity extends AppCompatActivity {

    private IntentFilter intentFilter;
    private NetWorkChangerReceiver netWorkChangerReceiver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intentFilter = new IntentFilter();
        //网络发生变化时，系统过发出一条ndroid.net.conn.CONNECTIVITY_CHANGE的广播，我们将广播加入到过滤器中
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        netWorkChangerReceiver = new NetWorkChangerReceiver();
        //通过调用registerReceiver方法进行注册广播，传入广播接收器和过滤器
        registerReceiver(netWorkChangerReceiver,intentFilter);
    }

    /**
     * 动态注册的广播一定要取消才行
     * **/
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(netWorkChangerReceiver);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.demo2:
                startActivity(new Intent(MainActivity.this,Demo2Activity.class));
                break;
            case R.id.demo3:
                startActivity(new Intent(MainActivity.this,Demo3Activity.class));
                break;

        }
        return true;
    }

    /**
   *定义一个内部类NetWorkChangerReceiver 继承BroadcastReceiver  重写 onReceive()
   *这样每次网络状态发生改变时，onReceive的方法就会执行
   **/
    class NetWorkChangerReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo info = manager.getActiveNetworkInfo();
            if(info != null && info.isAvailable()){
                Log.e("info", "有网络使用" );
                Toast.makeText(MainActivity.this,"有网络可以使用",Toast.LENGTH_SHORT).show();
            }else{
                Log.e("info", "没有可使用的网络");
                Toast.makeText(MainActivity.this,"没有网络可以使用",Toast.LENGTH_SHORT).show();
            }


        }
    }
}
