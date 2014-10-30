package com.danailbd.flappybird;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by danailbd on 10/29/14.
 */
public class DrawingView extends ImageView {

    private List<GameObject> gameObjects = new ArrayList<GameObject>();
    private GameClock gameClock = new GameClock();

    private BackGround bg = new BackGround(this.getContext());
    private BackGroundTextures bgBit = new BackGroundTextures(
            BitmapFactory.decodeResource(getResources(),
                    R.drawable.clouds));
    private Bird bird = new Bird(BitmapFactory.decodeResource(getResources(),
            R.drawable.bird));
    private Obstacles obst = new Obstacles(this.getContext());

    public DrawingView(Context context) {
        super(context);

        gameObjects.add(bg);
        gameObjects.add(bgBit);
        gameObjects.add(obst);
        gameObjects.add(bird);

        for(GameClock.GameClockListener item : gameObjects){
            gameClock.subscribe(item);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for(GameObject obj : gameObjects){
            obj.draw(canvas);       // passes through all objects and write them to the canvas
        }

        invalidate(); // set the change of draw
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);

        obst.setWandH(right,bottom);
        bird.setHeight(bottom);
        bg.setWidthAndHeight(right, bottom);
        bgBit.setWidthAndHeight(right, bottom);
    }

    public void addGameObject(GameObject obj){
        gameObjects.add(obj);
    }
}
