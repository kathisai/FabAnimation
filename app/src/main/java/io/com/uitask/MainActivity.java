package io.com.uitask;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.com.uitask.adapter.ShopAdapter;
import io.com.uitask.customViews.FABRevealLayout;
import io.com.uitask.customViews.OnRevealChangeListener;
import io.com.uitask.models.Reminder;

/**
 * Created by saiprathap on 3/8/2018.
 */
public class MainActivity extends AppCompatActivity {

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

    private ShopAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        configureFABReveal(fabRevealLayout);
        setupRecycler();
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

}
