package com.ict.mutd.leader.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

import com.ict.mutd.leader.R;
import com.ict.mutd.leader.util.ActvityManager;

public class SplashActivity extends AppCompatActivity implements Animation.AnimationListener {
    private static final String TAG = SplashActivity.class.getSimpleName();
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        ActvityManager.activityList.add(SplashActivity.this);

        view = getLayoutInflater().inflate(R.layout.activity_splash, null);
        setContentView(view);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        init();

        Animation animation = new AlphaAnimation(0.4f, 1.0f);
        animation.setDuration(2000);
        animation.setInterpolator(getApplicationContext(), android.R.anim.decelerate_interpolator);
        view.startAnimation(animation);
        animation.setAnimationListener(this);
    }

    private void init() {
    }

    @Override
    public void onAnimationStart(Animation animation) {


    }

    @Override
    public void onAnimationEnd(Animation animation) {
        startLogin();

    }

    /**
     * 跳转到登陆页面
     */
    private void startLogin() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }

    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.none, R.anim.right_out);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
