package utils;

import android.os.CountDownTimer;
import android.util.Log;

public class CountDown extends CountDownTimer {

    private CountDownListener mListener;

    public CountDown(long millisInFuture, long countDownInterval, CountDownListener listener) {
        super(millisInFuture, countDownInterval);
        mListener = listener;
    }


    @Override
    public void onTick(long millisUntilFinished) {
        // 每个时间间隔触发的回调方法
        //Log.d("CountDownTimer", "计时开始 ");
        long seconds = millisUntilFinished / 1000;
        mListener.onSecondsRemaining(seconds);
        Log.d("CountDownTimer", "Seconds remaining: " + seconds);
    }

    @Override
    public void onFinish() {
        // 倒计时结束触发的回调方法
        mListener.onCountdownFinished();

    }
}

