package com.example.arrakh.breakoutgame;

import android.graphics.RectF;

public class Paddle {

    private RectF rect;
    private float length;
    private float height;
    private float x;
    private float y;
    private float paddleSpeed;
    public final int STOPPED = 0;
    public final int LEFT = 1;
    public final int RIGHT = 2;
    private int paddleMoving = STOPPED;

    private float screenwidth;

    public Paddle(int screenX, int screenY){
        // 130 pixels wide and 20 pixels high
        length = 130;
        height = 20;

        screenwidth = screenX;
        x = screenX / 2;
        y = screenY - 20;

        // Initialize rectangle
        rect = new RectF(x, y, x + length, y + height);

        // How fast is the paddle in pixels per second
        paddleSpeed = 350;
    }


    // This is a getter method to make the rectangle that
    // defines our paddle available in BreakoutView class
    public RectF getRect(){
        return rect;
    }

    // This method will be used to change/set if the paddle is going left, right or nowhere
    public void setMovementState(int state){
        paddleMoving = state;
    }

    // This update method will be called from update in BreakoutView
    // It determines if the paddle needs to move and changes the coordinates
    // contained in rect if necessary
    public void update(long fps){
        if(paddleMoving == LEFT && x >= 0){
            x = x - paddleSpeed / fps;
        }

        if(paddleMoving == RIGHT && x <= (screenwidth - length)){
            x = x + paddleSpeed / fps;
        }

        rect.left = x;
        rect.right = x + length;
    }

}
