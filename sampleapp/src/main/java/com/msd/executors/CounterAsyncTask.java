package com.msd.executors;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;
import android.widget.Toast;


/**
 * This class exists for reference purpose and not used by the sample app
 * To migrate this class, use AsyncTaskV2 instead of AsyncTask
 */
public class CounterAsyncTask extends AsyncTask<Integer, Integer, Integer> {

    private final Context context;
    private final TextView textView;

    public CounterAsyncTask(Context context, TextView textView) {
        this.context = context;
        this.textView = textView;
    }

    @Override
    protected Integer doInBackground(Integer... integers) {
        int startNumber = integers[0];
        int endNumber = integers[1];
        int sum = 0;
        for (int i=startNumber;i<=endNumber;i++) {
            sleepFor(1000);
            if (isCancelled()) {
                break;
            }
            sum += i;
            publishProgress(i);
        }

        return sum;
    }

    private void sleepFor(long timeInMillis) {
        try {
            Thread.sleep(timeInMillis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        textView.setText(" ");
        Toast.makeText(context, "Adding Numbers", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPostExecute(Integer integer) {
        super.onPostExecute(integer);
        Toast.makeText(context, "Sum of Integers is " + integer, Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onProgressUpdate(Integer... integer) {
        textView.setText(String.valueOf(integer[0]));
        super.onProgressUpdate(integer);
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
        textView.setText("Cancelled.." );
    }

}
