package ir.elegam.amlakbashi.Activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import ir.elegam.amlakbashi.R;

/**
 * Created by Mehrdad Latifi on 2/15/2017.
 */

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)//***********************************************************
    {//_____________________________________________________________________________________________ Start onCreate
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        OnSetDelayShow();
    }//_____________________________________________________________________________________________ End onCreate


    private void OnSetDelayShow()//**************************************************************************************
    {//_____________________________________________________________________________________________ Start OnSetDelayShow
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
            }
        },4000);
    }//_____________________________________________________________________________________________ End OnSetDelayShow
}
