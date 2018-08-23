package shortcut.bro.com.shortcutdemo;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends BaseActivity {
    TextView tv_top;
    LinearLayout ll_bar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        ll_bar = findViewById(R.id.ll_bar);
        tv_top = findViewById(R.id.tv_top);


    }

    @Override
    void getDisplayCutoutHeight(int height) {
        Log.e("TAG", "安全区域距离屏幕上边的距离 :" + height);
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(ll_bar.getLayoutParams());
        lp.setMargins(0, height, 0, 0);
        ll_bar.setLayoutParams(lp);
    }
}
