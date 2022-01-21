package com.msd.executors;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.msd.asynctask.AsyncTaskV2;

public class MainActivity extends AppCompatActivity {

    private Button startAsyncButton;
    private Button stopAsyncButton;
    private TextView counterTextView;
    private CounterAsyncTaskV2 counterAsyncTask;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        startAsyncButton.setOnClickListener(view -> startAsyncAction());
        stopAsyncButton.setOnClickListener(view -> stopAsyncAction());

    }

    private void initViews() {
        startAsyncButton = findViewById(R.id.startAsyncButton);
        stopAsyncButton = findViewById(R.id.stopAsyncButton);
        counterTextView = findViewById(R.id.counterTextView);
    }

    private synchronized void startAsyncAction() {
       if (counterAsyncTask == null) {
           counterAsyncTask = new CounterAsyncTaskV2(this, counterTextView);
       } else {
           counterAsyncTask.cancel(true);
           counterAsyncTask = new CounterAsyncTaskV2(this, counterTextView);
       }

       counterAsyncTask.execute(1, 10);

    }

    private synchronized void stopAsyncAction() {
      if (counterAsyncTask != null && counterAsyncTask.getStatus() == AsyncTaskV2.Status.RUNNING) {
          counterAsyncTask.cancel(true);
      }
    }
}