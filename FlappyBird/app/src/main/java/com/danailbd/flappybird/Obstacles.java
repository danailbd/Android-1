package com.danailbd.flappybird;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.PointF;
import android.graphics.Rect;

import java.util.Random;

/**
 * Created by danailbd on 10/29/14.
 */
public class Obstacles extends GameObject {

    private int height, width;
    private final int OBST_VENT_DIPL_PERC = 25;

    PointF position = new PointF(0, height);
    Paint bg = new Paint();
    private  Bitmap pipeDown;
    private  Bitmap pipeUp;

    private Random obstLenght = new Random();
    private int dispPercent = obstLenght.nextInt(31) + 10; // sets the obstacle height

    public Obstacles(Bitmap bg, Bitmap bitmap) {
        pipeUp = bg;
        pipeDown = bitmap;
    }

    public void setWandH(int w, int h){
        height = h;
        width = w;
    }

    @Override
    public void draw(Canvas canvas) {
        bg.setColor(Color.GREEN);
        canvas.drawBitmap( pipeDown, new Rect(0, 0, pipeDown.getWidth(), pipeDown.getHeight()), new Rect( width-(int)position.x, 0,
                width+width*5/100 - (int)position.x ,height*dispPercent/100), bg);  // add what to draw


        canvas.drawBitmap( pipeUp, new Rect(0, 0, pipeUp.getWidth(), pipeUp.getHeight()), new Rect( width-(int)position.x, height*(OBST_VENT_DIPL_PERC + dispPercent)/100,
                width+width*5/100 - (int)position.x ,height), bg);  // add what to draw

    }

    @Override
    PointF getPosition() {
        return null;
    }

    @Override
    public void onGameEvent(GameEvent gameEvent) {
        if(position.x > width+width*5/100){
            dispPercent = obstLenght.nextInt(31) + 20;
            position.x = 0;
        } else{
            position.x += MOVE_FRAME+5;
        }
    }
}
