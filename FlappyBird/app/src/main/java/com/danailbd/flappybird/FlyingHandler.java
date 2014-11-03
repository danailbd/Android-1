package com.danailbd.flappybird;

import android.os.Handler;

/**
 * Created by danailbd on 10/30/14.
 */
public class FlyingHandler{

    private DrawingView birdy;

    FlyingHandler(DrawingView bird){
        birdy = bird;
    }

    public void continuesFlyStart(){
        handler.post(runnable);
    }

    public void continuesFlyStop(){
        handler.removeCallbacks(runnable);
    }

    private Handler handler = new Handler();

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            birdy.makeBirdyFly();

            // Call the runnable again
            handler.postDelayed(this, 10);
        }
    };
}
