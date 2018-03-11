package io.com.uitask.customViews;

import android.animation.TypeEvaluator;

/**
 * Created by saiprathap on 3/8/2018.
 */
public class CurvedPathEvaluator implements TypeEvaluator<Point> {

    @Override
    public Point evaluate(float t, Point startValue, Point endValue) {
        float x, y;
        // Line Path
        x = startValue.x + t * (endValue.x - startValue.x);
        y = startValue.y + t * (endValue.y - startValue.y);
        return new Point(x, y);
    }
}
