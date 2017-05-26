package com.jets.mad.itischeduleapp.UI.Adapter;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by ehabm on 5/26/2017.
 */

public class VerticalViewPager extends ViewPager{

    private WindowManager windowManager;
    private Context context;
    private static final float MIN_SCALE = 0.75f;

    public VerticalViewPager(Context context) {
        super(context);
        this.context = context;
        setPageTransformer(true,new VerticalPageTransformer());
        setOverScrollMode(OVER_SCROLL_NEVER);
    }

    public VerticalViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        setPageTransformer(true,new VerticalPageTransformer());
        setOverScrollMode(OVER_SCROLL_NEVER);    }

    ///////////// transform horizontal scrolling to vertical scrolling ////////////
    private class VerticalPageTransformer implements ViewPager.PageTransformer{

        @Override
        public void transformPage(View page, float position) {

            if (position < -1) {
                // This page is way off-screen to the left.
                page.setAlpha(0);
            } else if (position <= 1) {
                page.setAlpha(1);
                // Counteract the default slide transition
                page.setTranslationX(page.getWidth() * -position);
                // set Y position to swipe in from top
                float yPosition = position * page.getHeight();
                page.setTranslationY(yPosition);
            } else {
                // This page is way off-screen to the right.
                page.setAlpha(0);
            }
        }
    }

    private MotionEvent swapXY(MotionEvent motionEvent){
        windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        float width = this.getWidth();
        float height = this.getHeight();
        float newX=(motionEvent.getY()/height)*width;
        float newY=(1-motionEvent.getX()/width)*height;
        motionEvent.setLocation(newX,newY);
        return motionEvent;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return super.onInterceptTouchEvent(swapXY(ev));
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return super.onTouchEvent(swapXY(ev));
    }
}
