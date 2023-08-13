package utils;

public interface CountDownListener {
    void onSecondsRemaining(long seconds);

    void onCountdownFinished();
}
