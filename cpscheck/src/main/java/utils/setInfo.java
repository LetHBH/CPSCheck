package utils;

import android.os.Handler;
import android.widget.Button;

public class setInfo {

    public void setButton(Button button, long delay) {

        // 设置按钮不可点击
        button.setAlpha(0.5f);
        button.setClickable(false);
        // 使用Handler在delay后重新设置按钮为可点击
        new Handler().postDelayed(() -> {
            // 设置按钮可点击
            button.setAlpha(1f);
            button.setClickable(true);

        }, delay);
    }

}
