package com.xjtlu.timetable;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class logo extends Activity {

    private final int SPLASH_DISPLAY_LENGHT = 500; // 延迟六秒

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logo);

        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent mainIntent = new Intent(logo.this,
                        Main.class);
                logo.this.startActivity(mainIntent);
                logo.this.finish();
            }

        }, SPLASH_DISPLAY_LENGHT);

    }
}