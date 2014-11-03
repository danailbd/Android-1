package com.danailbd.flappybird;

import android.os.Handler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by danailbd on 10/29/14.
 */
public class GameClock {

    private static final int FRAMERATE_CONSTANT = 16;
    private List<GameClockListener> clockListeners = new ArrayList<GameClockListener>();

    public static interface GameClockListener {
        public void onGameEvent( GameEvent gameEvent);
    }

    private Handler handler = new Handler();

    public GameClock() {
        handler.post(new ClockRunnable());
    }

    public void subscribe(GameClockListener listener) {
        clockListeners.add(listener);
    }

    private class ClockRunnable implements Runnable {
        @Override
        public void run() {
            onTimerTick();
            handler.postDelayed(this, FRAMERATE_CONSTANT);
        }

        private void onTimerTick() {
            for (GameClockListener listener : clockListeners) {
                listener.onGameEvent(new GameEvent());
            }
        }
    }
}
