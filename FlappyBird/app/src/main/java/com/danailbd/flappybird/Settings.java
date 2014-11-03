package com.danailbd.flappybird;

/**
 * Created by danailbd on 11/3/14.
 */
public class Settings {

    static final int MOVE_FRAME = 20;

    //--- Obstacles ---//
    public static final int TUBE_WIDTH = 5;

    static final int OBST_MOVE_FRAME = 25;
    static final int OBST_VENT_DIPL_PERC = 25;
    static int MIN_TUBE_LENGHT_PERSENT = 10;
    static int MAX_TUBE_LENGHT_PERSENT = 31; // + min_tube_lenght
    static final int HEIGHT_DISPL_PER = 40;
    //--- End Obstacles ---//

    //--- Background texuture ---//
    static final int STARTING_POS = 0; // the top most vertical pixel of the bg image
    //static final int MOVE_FRAME = 3;

    //--- End Background texuture ---//

    //--- Bird --- //
    static final int FLY_PERC = 3;
    static final int FALLING_PERC = 3;
    static final int DIST_FROM_LEFT_END = 80; // pixels from left side of the screen

    //--- End Bird ---//
}
