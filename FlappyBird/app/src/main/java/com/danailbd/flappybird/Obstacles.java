package com.danailbd.flappybird;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;

import java.util.Random;

/**
 * Created by danailbd on 10/29/14.
 */
public class Obstacles extends GameObject {

    private int height, width;


    PointF position = new PointF(0, height);
    Paint bg = new Paint();
    private  Bitmap pipeDown;
    private  Bitmap pipeUp;

    private Random obstLenght = new Random();
    private int dispPercent = obstLenght.nextInt(Settings.MAX_TUBE_LENGHT_PERSENT) + Settings.MIN_TUBE_LENGHT_PERSENT; // sets the obstacle height

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
                width+width* Settings.TUBE_WIDTH /100 - (int)position.x ,height*dispPercent/100), bg);  // add what to draw


        canvas.drawBitmap( pipeUp, new Rect(0, 0, pipeUp.getWidth(), pipeUp.getHeight()),
                new Rect( width-(int)position.x, height*(Settings.OBST_VENT_DIPL_PERC + dispPercent)/100,
                width+width* Settings.TUBE_WIDTH/100 - (int)position.x ,height), bg);  // add what to draw

    }

    @Override
    PointF getPosition() {
        return null;
    }

    @Override
    public void onGameEvent(GameEvent gameEvent) {
        if(position.x > width+width* Settings.TUBE_WIDTH/100){
            dispPercent = obstLenght.nextInt(Settings.MAX_TUBE_LENGHT_PERSENT) + 20;
            position.x = 0;
        } else{
            position.x += Settings.OBST_MOVE_FRAME;
        }
    }
}
