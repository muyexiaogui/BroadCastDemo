package lhx.com.practicedemo.utils;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lhx
 * date:on 2018/5/8 0008.
 * TODO :用来管理所有的Activity
 */

public class ActivityCollector {
    public  static List<Activity> activities = new ArrayList<>();

    public static void addActivity(Activity activity){
        activities.add(activity);
    }
    public  static  void  removeActivity(Activity activity){
        activities.remove(activity);
    }
    public static void finishAll(){
        for (Activity activity: activities) {
            if(!activity.isFinishing()){
                activity.finish();
            }
        }
        activities.clear();
    }
}
