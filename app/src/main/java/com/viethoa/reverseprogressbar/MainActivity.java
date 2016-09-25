package com.viethoa.reverseprogressbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private int progress = 200;
    private ReverseProgressBar reverseProgressBar;
    private TextView progressText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reverseProgressBar = (ReverseProgressBar) findViewById(R.id.reverse_progress_bar);
        progressText = (TextView) findViewById(R.id.tv_progress);

        initializeReverseProgress();
    }

    private void initializeReverseProgress() {
        reverseProgressBar.setMax(progress);
        reverseProgressBar.setProgress(progress);

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
            }
        }, 0, 1000);
    }

    private void updateProgress() {
        runOnUiThread(new TimerTask() {
            @Override
            public void run() {
                reverseProgressBar.setProgress(progress);
                String percent = String.format("%s", progress) + "%";
                progressText.setText(percent);
            }
        });
    }
}
