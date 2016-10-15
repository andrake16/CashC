package com.nd.cashc;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class handler extends AppCompatActivity {

    // считаем нажатия кнопки
    private int mButtonPressed = 0;

    // счетчик времени
    private long mTime = 0L;

    private TextView mCounterTextView;
    private TextView mTimeTextView;

    // обработчик потока - обновляет сведения о времени
    // Создаётся в основном UI-потоке
    private Handler mHandler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_handler);

        mTimeTextView = (TextView) findViewById(R.id.textViewTime);
        mCounterTextView = (TextView) findViewById(R.id.textViewCounter);

        if (mTime == 0L) {
            mTime = SystemClock.uptimeMillis();
            mHandler.removeCallbacks(timeUpdaterRunnable);
            // Добавляем Runnable-объект timeUpdaterRunnable в очередь
            // сообщений, объект должен быть запущен после задержки в 100 мс
            mHandler.postDelayed(timeUpdaterRunnable, 100);
        }
    }

    // Описание Runnable-объекта
    private Runnable timeUpdaterRunnable = new Runnable() {
        public void run() {
            // вычисляем время
            final long start = mTime;
            long millis = SystemClock.uptimeMillis() - start;
            int second = (int) (millis / 1000);
            int min = second / 60;
            second = second % 60;
            // выводим время
            mTimeTextView.setText("" + min + ":" + String.format("%02d", second));
            // повторяем через каждые 200 миллисекунд
            mHandler.postDelayed(this, 200);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    @Override
    protected void onPause() {
        // Удаляем Runnable-объект для прекращения задачи
        mHandler.removeCallbacks(timeUpdaterRunnable);
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Добавляем Runnable-объект
        mHandler.postDelayed(timeUpdaterRunnable, 100);
    }

    public void onClick(View v) {
        Log.i("TAG","asdfasd");
        mCounterTextView.setText("a" + ++mButtonPressed);
    }
}

