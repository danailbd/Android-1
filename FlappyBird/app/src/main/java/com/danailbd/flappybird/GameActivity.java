package com.danailbd.flappybird;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;


public class GameActivity extends Activity {

    DrawingView mDecorView;
    private MediaPlayer mediaPlayer;

    private FlyingHandler flyHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mDecorView = new DrawingView(this);
        flyHandler = new FlyingHandler(mDecorView);

        ViewGroup.LayoutParams mainParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);

        backgroundSound();
        setContentView(mDecorView, mainParams);


        mDecorView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch(motionEvent.getAction()){
                case MotionEvent.ACTION_DOWN:
                // Start printing the letter in the callback now
                    mDecorView.makeBirdyFly();
                    flyHandler.continuesFlyStart();
                break;
                case MotionEvent.ACTION_CANCEL:
                case MotionEvent.ACTION_UP:
                // Stop printing the letter
                     flyHandler.continuesFlyStop();
                }
                 return true;
            }
        });
    }

    private void backgroundSound() {
        mediaPlayer = MediaPlayer.create(this, R.raw.prey_overture);
        mediaPlayer.setLooping(true);
        mediaPlayer.start(); // no need to call prepare(); create() does that for you
    }


    // This snippet hides the system bars.
//    private void hideSystemUI() {
//        // Set the IMMERSIVE flag.
//        // Set the content to appear under the system bars so that the content
//        // doesn't resize when the system bars hide and show.
//        mDecorView.setSystemUiVisibility(
//                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
//                        | View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
//                        | View.SYSTEM_UI_FLAG_IMMERSIVE);
//    }
//
//    private void hideSystemUI() {
//        mDecorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
//                | View.SYSTEM_UI_FLAG_FULLSCREEN
//                | View.SYSTEM_UI_FLAG_LOW_PROFILE
//                | View.SYSTEM_UI_FLAG_IMMERSIVE);
//    }


    @Override
    protected void onPause() {
        super.onPause();

        mediaPlayer.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();

        mediaPlayer.start();
    }


    /// Imersive mode ---------

}
