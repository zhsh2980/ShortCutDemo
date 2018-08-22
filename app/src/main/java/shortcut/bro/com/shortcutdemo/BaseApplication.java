package shortcut.bro.com.shortcutdemo;

import android.app.Application;

import com.blankj.utilcode.util.Utils;

/**
 * Created by zhangshan on 2018/8/22 18:10.
 */
public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
    }
}
