package com.timqi.awesomeplayeranim;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.LinearInterpolator;

/**
 * Created by qiqi on 15/10/23.
 */
public class PlayerAnimHelper {

    private ObjectAnimator anim;
    private View ivBg, ivPlay, ivPause;

    /**
     * @param bg a view of background
     * @param vPlay a view of the playing image
     * @param vPause a view of the pausing image
     */
    public PlayerAnimHelper(View bg, View vPlay, View vPause) {
        this.ivBg = bg;
        this.ivPlay = vPlay;
        this.ivPause = vPause;
    }


    public void startPlayingAnim() {
        anim = startBgAnimation(ivBg);
        playingTransitionAnim(ivPlay, ivPause);
    }


    public void stopPlayingAnim() {
        playingTransitionAnim(ivPause, ivPlay);
        stopBgAnimation(ivBg, anim);
    }

    private ObjectAnimator startBgAnimation(View v) {
        anim = ObjectAnimator.ofFloat(ivBg, "rotation", 0, 360);
        anim.setInterpolator(new LinearInterpolator());
        anim.setRepeatCount(ValueAnimator.INFINITE);
        anim.setDuration(22000);
        anim.start();
        return anim;
    }

    private void stopBgAnimation(View v, ObjectAnimator anim) {
        anim.cancel();

        ObjectAnimator a = ObjectAnimator.ofFloat(v, "rotation", v.getRotation(), 360);
        float d = 360 - v.getRotation();
        System.out.println("### :"+v.getRotation());
        a.setDuration((long) ((d / 275)*1000));
        a.start();
    }

    public void playingTransitionAnim(final View toHide, final View toShow) {

        PropertyValuesHolder rotation = PropertyValuesHolder.ofFloat("rotation", 0, 360);
        PropertyValuesHolder scaleX = PropertyValuesHolder.ofFloat("scaleX", 1, 0);
        PropertyValuesHolder scaleY = PropertyValuesHolder.ofFloat("scaleY", 1, 0);
        PropertyValuesHolder alpha = PropertyValuesHolder.ofFloat("alpha", 1, 0);
        ObjectAnimator animToHide = ObjectAnimator.ofPropertyValuesHolder(toHide, rotation, scaleX, scaleY, alpha);
        animToHide.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                toHide.setVisibility(View.GONE);
                toHide.setAlpha(1);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        animToHide.setDuration(1000);
        animToHide.start();

        PropertyValuesHolder scaleXR = PropertyValuesHolder.ofFloat("scaleX", 0.3f, 1);
        PropertyValuesHolder scaleYR = PropertyValuesHolder.ofFloat("scaleY", 0.3f, 1);
        ObjectAnimator animToShow = ObjectAnimator.ofPropertyValuesHolder(toShow, rotation, scaleXR, scaleYR);
        animToShow.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                toShow.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

        animToShow.setStartDelay(300);
        animToShow.setDuration(1000);
        animToShow.start();
    }
}
