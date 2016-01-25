package com.duby.astragtc;

import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ImageView iv_screen;
    private int[] IMAGE_RESOURCES = null;

    //WAY 1.
    //***********************************************************
    private FramesSequenceAnimation framesSequenceAnimation  = null;

    //WAY 3.
    //***********************************************************
    FasterAnimationsContainer mFasterAnimationsContainer;
    private static final int ANIMATION_INTERVAL = 800;  // 200ms


    @Override
    //***************************************************************************************************************************
    //***************************************************************************************************************************
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv_screen = (ImageView) findViewById(R.id.iv_screen);

        TypedArray ta_imgs = getResources().obtainTypedArray(R.array.astra_imgs);  //load typedArray
        int len = ta_imgs.length();
        IMAGE_RESOURCES = new int[len];
        for (int i = 0; i < len; i++)
            IMAGE_RESOURCES[i] = ta_imgs.getResourceId(i, 0);
        ta_imgs.recycle();

        //WAY 1.
        //***********************************************************
        //iv_astra.setBackgroundResource(R.drawable.astra_anim);
        //iv_astra.setImageDrawable(getResources().getDrawable(R.drawable.astra_anim));
        //astraAnim = (AnimationDrawable) iv_astra.getBackground();

        //WAY 2.
        //***********************************************************
        //imageView.setImageResource(R.drawable.astra_garage);
        //onShowAnimByFrame();

        //WAY 3.
        //***********************************************************
        //load type array and convert it to int array
        mFasterAnimationsContainer = FasterAnimationsContainer.getInstance(iv_screen);
        mFasterAnimationsContainer.addAllFrames(IMAGE_RESOURCES, ANIMATION_INTERVAL);
        mFasterAnimationsContainer.start();

    }

    @Override
    //***************************************************************************************************************************
    protected void onDestroy() {
        super.onDestroy();
        mFasterAnimationsContainer.stop();
    }

    //***************************************************************************************************************************
    //***************************************************************************************************************************
    /*
    private void onShowAnimByFrame() {
        ImageView image  = (ImageView)findViewById(R.id.iv_screen);
        framesSequenceAnimation = new FramesSequenceAnimation(this, image, R.array.feed_icons, 60);
//		framesSequenceAnimation.setOneShot(true);
        framesSequenceAnimation.start();
    }*/

    /*
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            astraAnim.start();
            return true;
        }
        return super.onTouchEvent(event);
    }*/

}