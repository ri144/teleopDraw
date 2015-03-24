package com.github.rosjava.android_apps.teleop;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class MultiTouchView extends View {
    private Paint paint = new Paint();
    private Path path = new Path();

    public MultiTouchView(Context context, AttributeSet attrs) {
        super(context, attrs);

        paint.setAntiAlias(true);
        paint.setStrokeWidth(6f);

        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawPath(path, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        paint.setColor(Color.RED);  //Red for when the user touches the screen
        float eventX = event.getX();
        float eventY = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(eventX, eventY);
                return true;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(eventX, eventY);
                break;
            case MotionEvent.ACTION_UP:
                // nothing to do
                break;
            default:
                return false;
        }

        // Schedules a repaint.
        invalidate();
        return true;
    }
    public void paintSomething(float x, float y){
        path.lineTo(x,y);
        paint.setColor(Color.WHITE);  //White for when the robot is moving
        invalidate();
    }
}
