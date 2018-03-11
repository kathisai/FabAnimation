package io.com.uitask;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.com.uitask.adapter.ShopAdapter;
import io.com.uitask.customViews.FABRevealLayout;
import io.com.uitask.customViews.OnRevealChangeListener;
import io.com.uitask.models.Reminder;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rv_calender_container)
    LinearLayout mCalenderContainer;
    @BindView(R.id.cv_date_container)
    LinearLayout mDateContainer;
    @BindView(R.id.ll_calender_day_container)
    LinearLayout mCalenderDayContainer;
    @BindView(R.id.rv_remainders)
    RecyclerView recyclerView;
    @BindView(R.id.fab_add_Reminder)
    FloatingActionButton fabAdd;
    @BindView(R.id.layoutButtons)
    LinearLayout layoutButtons;
    @BindView(R.id.btn_close)
    AppCompatButton closeButton;

    @BindView(R.id.fab_container)
    FABRevealLayout fabRevealLayout;
    Animation alphaAnimation;
    float pixelDensity;
    boolean flag = true;
    private ShopAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        pixelDensity = getResources().getDisplayMetrics().density;

        alphaAnimation = AnimationUtils.loadAnimation(this, R.anim.alpha_anim);
        configureFABReveal(fabRevealLayout);
        setupRecycler();

    }

    private void configureFABReveal(FABRevealLayout fabRevealLayout) {
        fabRevealLayout.setOnRevealChangeListener(new OnRevealChangeListener() {
            @Override
            public void onMainViewAppeared(FABRevealLayout fabRevealLayout, View mainView) {
            }

            @Override
            public void onSecondaryViewAppeared(final FABRevealLayout fabRevealLayout, View secondaryView) {
            }
        });
    }


    @OnClick(R.id.fab_add_Reminder)
    void revealSecondaryView() {
        fabRevealLayout.revealSecondaryView();
    }

    @OnClick(R.id.btn_close)
    void revealMainView() {
        fabRevealLayout.revealMainView();
    }

    private void setupRecycler() {

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new ShopAdapter(new ArrayList<Reminder>(), this);
        recyclerView.setAdapter(mAdapter);

        recyclerView.addItemDecoration(
                new DividerItemDecoration(this, 0));
    }

}
