
package io.com.uitask.customViews;

import android.view.View;

/**
 * Created by saiprathap on 3/8/2018.
 */

public interface OnRevealChangeListener {
    void onMainViewAppeared(FABRevealLayout fabRevealLayout, View mainView);

    void onSecondaryViewAppeared(FABRevealLayout fabRevealLayout, View secondaryView);
}
