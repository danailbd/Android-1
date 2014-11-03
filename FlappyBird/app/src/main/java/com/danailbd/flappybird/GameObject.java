package com.danailbd.flappybird;

import android.graphics.Canvas;
import android.graphics.PointF;

/**
 * Created by danailbd on 10/29/14.
 */
public abstract class GameObject implements GameClock.GameClockListener{

    abstract public void draw(Canvas canvas);

    abstract PointF getPosition();
}
