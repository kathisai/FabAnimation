package io.com.uitask;

import android.animation.Animator;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private final int amountToMoveRight = -140;
    private final int amountToMoveDown = 300;
    @BindView(R.id.rv_calender_container)
    RelativeLayout mCalenderContainer;
    @BindView(R.id.cv_date_container)
    CardView mDateContainer;
    @BindView(R.id.ll_calender_day_container)
    LinearLayout mCalenderDayContainer;
    @BindView(R.id.fl_data_time_container)
    FrameLayout dateTimeContainer;
    @BindView(R.id.rv_remainders)
    RecyclerView recyclerView;
    @BindView(R.id.fab_add_Reminder)
    FloatingActionButton addReminder;
    @BindView(R.id.linearView)
    LinearLayout revealView;
    @BindView(R.id.layoutButtons)
    LinearLayout layoutButtons;
    @BindView(R.id.close_button)
    Button closeButton;
    Animation alphaAnimation;
    float pixelDensity;
    boolean flag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        pixelDensity = getResources().getDisplayMetrics().density;

        alphaAnimation = AnimationUtils.loadAnimation(this, R.anim.alpha_anim);
    }

    @OnClick(R.id.fab_add_Reminder)
    public void launchTwitter() {
        addReminder.setImageResource(R.drawable.ic_close_black_24dp);
        TranslateAnimation moveanim = new TranslateAnimation(0, amountToMoveRight, 0, amountToMoveDown);
        moveanim.setDuration(1000);
        moveanim.setFillAfter(true);
        moveanim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                addReminder.setVisibility(View.GONE);
                circularReveal();

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        addReminder.startAnimation(moveanim);
        flag = false;

    }

    private void circularReopen() {
        int x = addReminder.getRight();
        int y = addReminder.getTop();
        x -= ((28 * pixelDensity) + (16 * pixelDensity));

        int hypotenuse = (int) Math.hypot(recyclerView.getWidth(), recyclerView.getHeight());
        Animator anim = ViewAnimationUtils.createCircularReveal(revealView, x, y, hypotenuse, 0);
        anim.setDuration(400);

        anim.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                revealView.setVisibility(View.GONE);
                layoutButtons.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });

        anim.start();
    }

    private void circularReveal() {

        int x = addReminder.getRight();
        int y = addReminder.getTop();
        x -= ((28 * pixelDensity) + (16 * pixelDensity));

        int hypotenuse = (int) Math.hypot(recyclerView.getWidth(), recyclerView.getHeight());

        FrameLayout.LayoutParams parameters = (FrameLayout.LayoutParams)
                revealView.getLayoutParams();
        // get height of recycle view
        parameters.height = recyclerView.getHeight();
        // set recycler view height to revalView
        revealView.setLayoutParams(parameters);

        Animator anim = ViewAnimationUtils.createCircularReveal(revealView, x, y, 0, hypotenuse);
        anim.setDuration(700);

        anim.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                layoutButtons.setVisibility(View.VISIBLE);
                layoutButtons.startAnimation(alphaAnimation);
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });

        revealView.setVisibility(View.VISIBLE);
        anim.start();
    }

    @OnClick(R.id.close_button)
    public void reOpenView() {

        addReminder.setImageResource(R.drawable.ic_add_black_24dp);

        TranslateAnimation moveanim = new TranslateAnimation(0, 140, 0, -300);
        moveanim.setDuration(1000);
        moveanim.setFillAfter(true);
        moveanim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                addReminder.setVisibility(View.VISIBLE);
                circularReopen();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        addReminder.startAnimation(moveanim);

        //circularReopen();
        flag = true;
    }
}
