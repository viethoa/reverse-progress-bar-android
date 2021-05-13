package com.viethoa.reverseprogressbar;

import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements ValueAnimator.AnimatorUpdateListener {
    private final int PROGRESS = 10;
    private final int STROKE_WIDTH = 15;

    private CountdownProgressBar countdownProgressBar;
    private TextView countDownProgressText;
    private ReverseProgressBar reverseProgressBar;
    private TextView reverseProgressText;
    private FillCountdownProgressBar fillCountdownProgressBar;
    private int progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countdownProgressBar = findViewById(R.id.countdown_progress_bar);
        countDownProgressText = findViewById(R.id.tv_countdown_progress);
        reverseProgressBar = findViewById(R.id.reverse_progress_bar);
        reverseProgressText = findViewById(R.id.tv_reverse_progress);
        fillCountdownProgressBar = findViewById(R.id.fill_countdown_progress_bar);

        progress = PROGRESS;
        initializeProgress();
        initFillCountdownProgress();
    }

    private void initializeProgress() {
        reverseProgressBar.setMax(progress);
        reverseProgressBar.setProgress(progress);
        reverseProgressBar.setStrokeWidth(STROKE_WIDTH);
        reverseProgressBar.strockCap(true);
        countdownProgressBar.setMax(progress);
        countdownProgressBar.setProgress(progress);
        countdownProgressBar.strockCap(true);
        countdownProgressBar.setStrokeWidth(STROKE_WIDTH);

        final Timer progressSchedule = new Timer();
        progressSchedule.schedule(new TimerTask() {
            @Override
            public void run() {
                progress -= 1;
                if (progress < 0) {
                    this.cancel();
                } else {
                    updateProgress();
                }

                if (progress == 5) {
                    countdownProgressBar.setColor(R.color.colorRed);
                }
            }
        }, 500, 1000);
    }

    private void updateProgress() {
        runOnUiThread(new TimerTask() {
            @Override
            public void run() {
                countdownProgressBar.setProgress(progress);
                String rest = String.format("%s", progress);
                countDownProgressText.setText(rest);

                reverseProgressBar.setProgress(progress);
                String percent = String.format("%s", PROGRESS - progress) + "%";
                reverseProgressText.setText(percent);
            }
        });
    }

    private void initFillCountdownProgress() {
        fillCountdownProgressBar.setMax(progress);
        fillCountdownProgressBar.setProgress(progress);

        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0.1f, PROGRESS);
        valueAnimator.setDuration(PROGRESS * 1000);
        valueAnimator.addUpdateListener(this);
        valueAnimator.setStartDelay(500);
        valueAnimator.start();
    }

    @Override
    public void onAnimationUpdate(ValueAnimator animator) {
        float value = (float) animator.getAnimatedValue();
        fillCountdownProgressBar.setProgress(PROGRESS - value);
    }
}
