package com.example.cuongphan.a2ddrawingiicons;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;

/**
 * Created by CuongPhan on 3/14/2017.
 */

public class DrawIconsView extends View {
    private Bitmap[] mIcons = {
            BitmapFactory.decodeResource(getResources(),R.drawable.upload),
            BitmapFactory.decodeResource(getResources(),R.drawable.user_group_icon),
            BitmapFactory.decodeResource(getResources(),R.drawable.settings_icon),
            BitmapFactory.decodeResource(getResources(),R.drawable.user_icon),

    };
    public DrawIconsView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawBitmap(canvas);

    }

    private void drawBitmap(Canvas canvas) {
        int viewWidth, viewHeight;
        float left, top;
        Bitmap icon;
        viewWidth = getWidth();
        viewHeight = getHeight();
        for (int i=0; i<4; i++){
            left = randomFloat(viewWidth);
            top = randomFloat(viewHeight);
            icon = randomBitmap(mIcons);
            canvas.drawBitmap(icon, left, top, null);
        }
    }

    private float randomFloat(int position){
        return (float)(Math.random()*position);
    }

    private Bitmap randomBitmap(Bitmap[] bitmaps){
        Random random = new Random();
        int r = random.nextInt(4);
        return bitmaps[r];
    }
}
