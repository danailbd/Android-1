package com.danailbd.flappybird;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;

/**
 * Created by danailbd on 10/29/14.
 */
public class BackGroundTextures extends GameObject {

    Bitmap textures;
    PointF position = new PointF();
    private int width;
    private int height;

    BackGroundTextures(Bitmap _textures){
        textures = _textures;
    }

    BackGroundTextures(Bitmap _textures, int _width, int _height){
        textures = _textures;
        width = _width;
        height = _height;
    }

    public void setWidthAndHeight(int w, int h){
        width = w;
        height = h;
    }

    @Override
    public void draw(Canvas canvas) {

        if(position.x < (-1)*width) position.x = 0;
        canvas.drawBitmap(textures, new Rect(0, 0, textures.getWidth(), textures.getHeight()),
                new Rect(0+(int)position.x, Settings.STARTING_POS, width+(int)position.x, height * Settings.HEIGHT_DISPL_PER/100), null);
        canvas.drawBitmap(textures, new Rect(0, 0, textures.getWidth(), textures.getHeight()),
                new Rect(width+(int)position.x, Settings.STARTING_POS, width+width+(int)position.x, height * Settings.HEIGHT_DISPL_PER/100), null);

    }

    @Override
    PointF getPosition() {
        return position;
    }

    @Override
    public void onGameEvent(GameEvent gameEvent) {
        position.x -= Settings.MOVE_FRAME;
    }
}
