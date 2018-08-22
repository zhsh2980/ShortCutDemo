package shortcut.bro.com.shortcutdemo;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.DisplayCutout;
import android.view.View;

import java.util.List;

/**
 * Created by zhangshan on 2018/8/22 15:02.
 */
public abstract class BaseActivity extends AppCompatActivity {
    private static final String TAG = "BaseActivity";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setNavigationBarColor(Color.TRANSPARENT);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
//            Log.d("BaseActivity", "Build.VERSION.SDK_INT: P");
//            WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
//            layoutParams.layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_NEVER;
//            getWindow().setAttributes(layoutParams);
//        }

        getNotchParams();

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH) {
//            final View contentView = getWindow().getDecorView();
//            contentView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
//                @RequiresApi(api = 28)
//                @Override
//                public WindowInsets onApplyWindowInsets(View view, WindowInsets insets) {
//                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
//                        DisplayCutout cutout = insets.getDisplayCutout();
//                        Log.e(TAG, "cutout == null" );
//                        if (cutout != null) {
//                            List<Rect> rects = cutout.getBoundingRects();
//                            if (rects == null || rects.size() == 0) {
//                                Log.e(TAG, "rects == null || rects.size() == 0, is not notch screen");
//                            } else {
//                                Log.e(TAG, "rect size:" + rects.size());
//                                contentView.setPadding(cutout.getSafeInsetLeft(), cutout.getSafeInsetTop(), cutout.getSafeInsetRight(),
//                                        cutout.getSafeInsetBottom());
//                            }
//                        }
//                    }
//                    return insets;
//                }
//            });
//        }

//
//        View decorView = getWindow().getDecorView();
//        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
//        decorView.setSystemUiVisibility(uiOptions);

    }

    @TargetApi(28)
    public void getNotchParams() {
        final View decorView = getWindow().getDecorView();

        decorView.post(new Runnable() {
            @Override
            public void run() {
                DisplayCutout displayCutout = decorView.getRootWindowInsets().getDisplayCutout();
                Log.e("TAG", "安全区域距离屏幕左边的距离 SafeInsetLeft:" + displayCutout.getSafeInsetLeft());
                Log.e("TAG", "安全区域距离屏幕右部的距离 SafeInsetRight:" + displayCutout.getSafeInsetRight());
                Log.e("TAG", "安全区域距离屏幕顶部的距离 SafeInsetTop:" + displayCutout.getSafeInsetTop());
                getDisplayCutoutHeight(displayCutout.getSafeInsetTop());
                Log.e("TAG", "安全区域距离屏幕底部的距离 SafeInsetBottom:" + displayCutout.getSafeInsetBottom());
                decorView.setPadding(displayCutout.getSafeInsetLeft(), displayCutout.getSafeInsetTop(), displayCutout.getSafeInsetRight(),
                        displayCutout.getSafeInsetBottom());
                List<Rect> rects = displayCutout.getBoundingRects();
                if (rects == null || rects.size() == 0) {
                    Log.e("TAG", "不是刘海屏");
                } else {
                    Log.e("TAG", "刘海屏数量:" + rects.size());
                    for (Rect rect : rects) {
                        Log.e("TAG", "刘海屏区域：" + rect);
                    }
                }
            }
        });
    }

    abstract void getDisplayCutoutHeight(int height);

}
