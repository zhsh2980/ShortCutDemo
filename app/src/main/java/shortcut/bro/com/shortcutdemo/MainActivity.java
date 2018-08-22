package shortcut.bro.com.shortcutdemo;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends BaseActivity {
    Button btnTop;
    LinearLayout ll_bar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
////            Log.d("BaseActivity", "Build.VERSION.SDK_INT: P");
//            WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
//            layoutParams.layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_DEFAULT;
//            getWindow().setAttributes(layoutParams);
//        }
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.hide();
        setContentView(R.layout.activity_main);


        ll_bar = findViewById(R.id.ll_bar);
        btnTop = findViewById(R.id.btn_top);

//        View decorView = getWindow().getDecorView();
//        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
//        decorView.setSystemUiVisibility(uiOptions);
    }

    @Override
    void getDisplayCutoutHeight(int height) {
        Log.e("TAG", "安全区域距离屏幕上边的距离 :" + height);
//        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(ll_bar.getLayoutParams());
////        lp.setMargins(0, SizeUtils.px2dp(height), 0, 0);
//        lp.setMargins(0, height, 0, 0);
//        ll_bar.setLayoutParams(lp);
    }
}
