package com.timqi.awesomeplayeranim;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private boolean isPlaying = false;
    private View.OnClickListener clickListener
            = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (isPlaying) {
                animHelper.stopPlayingAnim();
            } else {
                animHelper.startPlayingAnim();
            }
            isPlaying = !isPlaying;
        }
    };


    @Bind(R.id.ivBg)
    ImageView ivBg;
    @Bind(R.id.fl)
    FrameLayout fl;

    @Bind(R.id.ivPlay)
    ImageView ivPlay;
    @Bind(R.id.ivPause)
    ImageView ivPause;

    private PlayerAnimHelper animHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        animHelper = new PlayerAnimHelper(ivBg, ivPlay, ivPause);
        fl.setOnClickListener(clickListener);
    }
}

