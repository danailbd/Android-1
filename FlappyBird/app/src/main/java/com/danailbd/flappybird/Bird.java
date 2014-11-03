package com.danailbd.flappybird;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;

/**
 * Created by danailbd on 10/29/14.
 */
public class Bird extends GameObject{


    Bitmap birdBit;
    PointF position = new PointF(Settings.DIST_FROM_LEFT_END, 50);
    private int height;

    public Bird(Bitmap bird) {
        birdBit = bird;
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawBitmap(birdBit, position.x, position.y, null);
    }

    @Override
    PointF getPosition() {
        return position;
    }


    @Override
    public void onGameEvent(GameEvent gameEvent) {
        if(position.y > -51 && position.y < height-height*3/100)
            position.y += Settings.MOVE_FRAME+height* Settings.FALLING_PERC/100;
        else if (position.y >= height-height*3/100)
            position.y = height-height/100;
    }

    public void fly(){
        if(position.y > -20 && position.y < height)
            position.y -= height* Settings.FLY_PERC/100;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }
}
