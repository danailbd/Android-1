package com.danailbd.flappybird;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.PointF;

import java.util.Random;

/**
 * Created by danailbd on 10/29/14.
 */
public class Obstacles extends GameObject {

    private int height, width;
    private final int OBST_VENT_DIPL_PERC = 15;

    Paint bg = new Paint();
    PointF position = new PointF(0, height);

    private Random obstLenght = new Random();
    private int dispPercent = obstLenght.nextInt(31) + 10; // sets the obstacle height

    public Obstacles(Context context) {
    }

    public void setWandH(int w, int h){
        height = h;
        width = w;
    }

    @Override
    public void draw(Canvas canvas) {
        bg.setColor(Color.GREEN);
        canvas.drawRect( width-position.x, 0,
                width+width*5/100 - position.x ,height*dispPercent/100,
                bg);  // add what to draw

        canvas.drawRect( width-position.x, height*(OBST_VENT_DIPL_PERC + dispPercent)/100,
                width+width*5/100 - position.x ,height,
                bg);  // add what to draw
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
