package com.example.developer.cropdiagnosis.mvp.ui.activities;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.developer.cropdiagnosis.R;
import com.example.developer.cropdiagnosis.mvp.ui.activities.base.BaseActivity;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    private static final int REQUEST_REGISTER = 0;
    private static final int REQUEST_LOGIN = 1;

    @BindView(R.id.iv_logo_main)
    ImageView ivLogo;

    @BindView(R.id.iv_logo_bg_main)
    ImageView ivLogoBg;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initVariables() {
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initAnimation();
    }

    @Override
    protected void initializeInjector() {

    }

    private void initAnimation() {
        startLogoAnimation();
    }

    private void startLogoBgAnimation() {
        AnimatorSet set = new AnimatorSet();
        set.setDuration(900);
        set.playTogether(ObjectAnimator.ofFloat(ivLogoBg, "scaleX", new float[]{1.0F, 1.25F, 0.75F, 1.15F, 1.0F}),
                ObjectAnimator.ofFloat(ivLogoBg, "scaleY", new float[]{1.0F, 0.75F, 1.25F, 0.85F, 1.0F}));
        set.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if (PreferenceManager.getDefaultSharedPreferences(MainActivity.this).getBoolean("isLogined", false)) {
                    finish();
                    startActivity(new Intent(MainActivity.this, HomeActivity.class));
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        set.start();
    }

    private void startLogoAnimation() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim_top_in);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                startLogoBgAnimation();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        ivLogo.startAnimation(animation);
    }

    public void register(View view) {
        Intent it = new Intent(MainActivity.this, RegisterActivity.class);
        startActivityForResult(it, REQUEST_REGISTER);
        finish();
    }

    public void login(View view) {
        Intent it = new Intent(MainActivity.this, LoginActivity.class);
        startActivityForResult(it, REQUEST_LOGIN);
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQUEST_LOGIN:
            case REQUEST_REGISTER:
                if (resultCode == RESULT_OK) {
                    finish();
                    startActivity(new Intent(MainActivity.this, HomeActivity.class));
                }
                break;
            default:
                break;
        }
    }
}
