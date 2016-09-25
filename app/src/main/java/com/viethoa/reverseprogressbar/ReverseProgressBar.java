package com.viethoa.reverseprogressbar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.ColorRes;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by VietHoa on 24/09/2016.
 */

public class ReverseProgressBar extends View {
    private static final float arcAngle = 360;
    private static final int start = -90;
    private int max = 100;
    private int progress = 100;
    private int strokeWidth = 5;
    private int color;

    private RectF rectF;
    private final Paint paint = new Paint();

    {
        rectF = new RectF();
        paint.setAntiAlias(true);
        paint.setStrokeWidth(strokeWidth);
        paint.setStyle(Paint.Style.STROKE);
        //paint.setStrokeCap(Paint.Cap.ROUND);
    }

    public ReverseProgressBar(Context context) {
        super(context);
        initialize(context);
    }

    public ReverseProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize(context);
    }

    public ReverseProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize(context);
    }

    private void initialize(Context context) {
        max = 100;
        progress = 100;
        strokeWidth = 5;
        color = context.getResources().getColor(R.color.colorPrimary);
    }

    //----------------------------------------------------------------------------------------------
    //  Options
    //----------------------------------------------------------------------------------------------

    public void setMax(int max) {
        this.max = max;
        invalidate();
    }

    public void setProgress(int progress) {
        this.progress = progress;
        invalidate();
    }

    public void setColor(@ColorRes int color) {
        this.color = getContext().getResources().getColor(color);
    }

    public void setStrokeWidth(int strokeWidth) {
        this.strokeWidth = strokeWidth;
    }

    //----------------------------------------------------------------------------------------------
    //
    //----------------------------------------------------------------------------------------------

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(widthMeasureSpec, heightMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        rectF.set(strokeWidth, strokeWidth, width - strokeWidth, height - strokeWidth);
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float finishedSweepAngle = progress / (float) max * arcAngle;
        float unfinishedSweepAngle = arcAngle - finishedSweepAngle;
        float invertPosition = start + unfinishedSweepAngle;
        Log.d("onDraw", String.format("%s, %s, %s", finishedSweepAngle, unfinishedSweepAngle, invertPosition));

        paint.setColor(Color.TRANSPARENT);
        canvas.drawArc(rectF, start, unfinishedSweepAngle, false, paint);
        paint.setColor(color);
        canvas.drawArc(rectF, invertPosition, finishedSweepAngle, false, paint);
    }


}
