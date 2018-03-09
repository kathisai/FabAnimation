package io.com.uitask;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fabreveal.FABRevealLayout;
import fabreveal.OnRevealChangeListener;

public class MainActivity extends AppCompatActivity {

    private final int amountToMoveRight = -140;
    private final int amountToMoveDown = 300;
    @BindView(R.id.rv_calender_container)
    RelativeLayout mCalenderContainer;
    @BindView(R.id.cv_date_container)
    CardView mDateContainer;
    @BindView(R.id.ll_calender_day_container)
    LinearLayout mCalenderDayContainer;
    @BindView(R.id.rv_remainders)
    RecyclerView recyclerView;
    @BindView(R.id.fab_add_Reminder)
    FloatingActionButton fabAdd;
    @BindView(R.id.layoutButtons)
    LinearLayout layoutButtons;
    @BindView(R.id.close_button)
    Button closeButton;

    @BindView(R.id.fab_reveal_layout)
    FABRevealLayout fabRevealLayout;
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
        configureFABReveal(fabRevealLayout);

    }

    private void configureFABReveal(FABRevealLayout fabRevealLayout) {
        fabRevealLayout.setOnRevealChangeListener(new OnRevealChangeListener() {
            @Override
            public void onMainViewAppeared(FABRevealLayout fabRevealLayout, View mainView) {
            }

            @Override
            public void onSecondaryViewAppeared(final FABRevealLayout fabRevealLayout, View secondaryView) {
                prepareBackTransition(fabRevealLayout);
            }
        });
    }

    private void prepareBackTransition(final FABRevealLayout fabRevealLayout) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                fabRevealLayout.revealMainView();
            }
        }, 2000);
    }

    @OnClick(R.id.fab_add_Reminder)
    void revelView() {
        fabRevealLayout.revealSecondaryView();
    }
}
