package com.eleven.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.eleven.toolkit.LogUtils;
import com.eleven.toolkit.ThreadPoolUtils;
import com.eleven.toolkit.app.PhoneUtils;

import java.util.concurrent.TimeUnit;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LogUtils.d("execute~~~~~~~~~~~~~~~~~~~~~~~~");

    }

    @Override
    protected void onStart() {
        super.onStart();
        LogUtils.d("execute~~~~~~~~~~~~~~~~~~~~~~~~");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        LogUtils.d("execute~~~~~~~~~~~~~~~~~~~~~~~~");

    }

    @Override
    protected void onResume() {
        super.onResume();
//        String ass = getIntent().getStringExtra("assist");
        LogUtils.d("execute~~~~~~~~~~~~~~~~~~~~~~~~" + getIntent().hasExtra("assist"));

    }

    @Override
    protected void onPause() {
        super.onPause();
        LogUtils.d("execute~~~~~~~~~~~~~~~~~~~~~~~~");

    }

    @Override
    protected void onStop() {
        super.onStop();
        LogUtils.d("execute~~~~~~~~~~~~~~~~~~~~~~~~");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtils.d("execute~~~~~~~~~~~~~~~~~~~~~~~~");

    }

    private int times = 0;

    public void thread(View view) {

        ThreadPoolUtils.executeByFixedWithDelay(3, new ThreadPoolUtils.SimpleTask<String>() {
            @Override
            public String doInBackground() throws Throwable {
                times++;
                return "execute times " + times;
            }

            @Override
            public void onSuccess(String result) {
                LogUtils.d(result);
                startActivity(new Intent(MainActivity.this, AnotherActivity.class));
            }
        }, 30, TimeUnit.SECONDS);
    }

    public void log(View view) {
        String FILE_SEP = System.getProperty("file.separator");
        final String LINE_SEP = System.getProperty("line.separator");
        LogUtils.d("Android Id:" + PhoneUtils.getAndroidId());
//        LogUtils.d(Environment.getExternalStorageDirectory());
//        LogUtils.e(LogUtils.getConfig().toString());
//        LogUtils.d("write test");
    }

    public void home(View view) {
//        ActivityUtils.startHomeActivity();
        moveTaskToBack(true);

    }

    public static void launch(Context context, String action, String assist, String ext) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra("action", action);
        intent.putExtra("assist", assist);
        intent.putExtra("ext", ext);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

}
