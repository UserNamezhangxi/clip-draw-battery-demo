package com.zx.drawable;

import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{
    private int num = 0;
    private ClipDrawable  mClipDrawable;
    private Handler mHandler = new Handler();

    private Runnable r = new Runnable() {
        @Override
        public void run() {
            num = num+10;
            if (num <= 100){
                mClipDrawable.setLevel(num*100);
            }else{
                num = 0;
            }
            mHandler.postDelayed(this, 500);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView view = (ImageView) findViewById(R.id.imgView);
        mClipDrawable = (ClipDrawable)view.getBackground();
        mHandler.postDelayed(r,1000);
    }

}
