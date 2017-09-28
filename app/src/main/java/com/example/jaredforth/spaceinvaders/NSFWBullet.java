package com.example.jaredforth.spaceinvaders;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.RectF;
import android.view.animation.LinearInterpolator;

/**
 * Created by jaredforth on 9/27/17.
 */

public class NSFWBullet {
    private float x;
    private float y;
    private Bitmap bitmap1;


    private RectF rect;

    // Which way is it shooting
    public final int UP = 0;
    public final int DOWN = 1;

    // Going nowhere
    int heading = -1;
    float speed =  350;

    private int width = 1;
    private int height;
    private int length;

    private boolean isActive;
    boolean isVisible;

    public NSFWBullet(Context context, int screenY, int screenX) {

        length = screenX / 20;
        height = screenY / 20;
        isActive = false;
        isVisible = true;

        rect = new RectF();
        bitmap1 = BitmapFactory.decodeResource(context.getResources(), R.drawable.cum);
        // stretch the first bitmap to a size appropriate for the screen resolution
        bitmap1 = Bitmap.createScaledBitmap(bitmap1,
                (int) (length),
                (int) (height),
                false);
    }

    public void setInvisible(){
        isVisible = false;
    }

    public boolean getVisibility(){
        return isVisible;
    }

    public RectF getRect(){
        return rect;
    }

    public float getX(){
        return x;
    }

    public Bitmap getBitmap(){
        return bitmap1;
    }

    public boolean getStatus(){
        return isActive;
    }

    public void setInactive(){
        isActive = false;
    }

    public float getImpactPointY(){
        if (heading == DOWN){
            return y + height;
        }else{
            return  y;
        }

    }

    public boolean shoot(float startX, float startY, int direction) {
        if (!isActive) {
            x = startX;
            y = startY;
            heading = direction;
            isActive = true;
            return true;
        }

        // Bullet already active
        return false;
    }

    public void update(long fps){

        // Just move up or down
        if(heading == UP){
            y = y - speed / fps;
        }else{
            y = y + speed / fps;
        }

        // Update rect
        rect.left = x;
        rect.right = x + width;
        rect.top = y;
        rect.bottom = y + height;


    }
}
