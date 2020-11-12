package com.viethoa.reverseprogressbar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.viethoa.R;


/**
 * Created by VietHoa on 25/09/2016.
 */

public class FillCountdownProgressBar extends View {
    private static final float arcAngle = 360;
    private static final int start = -90;
    private int max = 100;
    private float progress = 100;

    private RectF rectF;
    private final Paint paint = new Paint();
    {
        rectF = new RectF();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
    }

    public FillCountdownProgressBar(Context context) {
        super(context);
        initialize(context);
    }

    public FillCountdownProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize(context);
    }

    public FillCountdownProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize(context);
    }

    private void initialize(Context context) {
        max = 100;
        progress = 100f;
        paint.setColor(context.getResources().getColor(R.color.colorPrimary));
    }

    //----------------------------------------------------------------------------------------------
    //  Options
    //----------------------------------------------------------------------------------------------

    public void setMax(int max) {
        this.max = max;
    }

    public void setProgress(float progress) {
        this.progress = progress;
        invalidate();
    }

    //----------------------------------------------------------------------------------------------
    // Handler
    //----------------------------------------------------------------------------------------------

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(widthMeasureSpec, heightMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        rectF.set(0, 0, width, height);
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float finishedSweepAngle = (progress / (float) max) * arcAngle;
        float unfinishedSweepAngle = arcAngle - finishedSweepAngle;
        float invertPosition = start + unfinishedSweepAngle;
        canvas.drawArc(rectF, invertPosition, finishedSweepAngle, true, paint);
    }
}
