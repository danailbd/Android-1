package com.danailbd.flappybird;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;

/**
 * Created by danailbd on 10/29/14.
 */
public class BackGround extends GameObject {

    Paint backGround = new Paint();
    private int width;
    private int height;
    private Context context;

    public BackGround(Context _context) {
        context = _context;

    }

    public BackGround(int r, int b, Context _context) {
        width = r;
        height = b;
        context = _context;
    }

    public void setWidthAndHeight(int w, int h){
        width = w;
        height = h;
    }

    @Override
    public void draw(Canvas canvas) {
        backGround.setColor(context.getResources().getColor(R.color.bgBlue));
        canvas.drawRect(0, 0, width, height, backGround);
    }

    @Override
    PointF getPosition() {
        return null;
    }

    @Override
    public void onGameEvent(GameEvent gameEvent) {}
}
