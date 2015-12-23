package app.xu.com.listtext.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.AbsListView;

/**
 * ListView footer view
 * <p/>
 * Created by lawrence on 2015/12/7.
 */
public class FooterListTextView extends RootListTextView {

    public FooterListTextView(Context context) {
        super(context);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, DEFAULT_LAYOUT_WIDTH, getResources().getDisplayMetrics()),
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, DEFAULT_LAYOUT_HEIGHT, getResources().getDisplayMetrics()));
        setLayoutParams(layoutParams);
        setBackgroundColor(Color.WHITE);
    }

    public FooterListTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, DEFAULT_LAYOUT_WIDTH, getResources().getDisplayMetrics()),
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, DEFAULT_LAYOUT_HEIGHT, getResources().getDisplayMetrics()));
        setLayoutParams(layoutParams);
        setBackgroundColor(Color.WHITE);
    }

    public FooterListTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, DEFAULT_LAYOUT_WIDTH, getResources().getDisplayMetrics()),
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, DEFAULT_LAYOUT_HEIGHT, getResources().getDisplayMetrics()));
        setLayoutParams(layoutParams);
        setBackgroundColor(Color.WHITE);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(10);
        canvas.drawLine(
                (TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, getResources().getDisplayMetrics())),
                (TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 8, getResources().getDisplayMetrics())),
                (TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 18, getResources().getDisplayMetrics())),
                (TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 13, getResources().getDisplayMetrics())), paint);

        canvas.drawLine(
                (TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 16, getResources().getDisplayMetrics())),
                (TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 13, getResources().getDisplayMetrics())),
                (TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics())),
                (TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 8, getResources().getDisplayMetrics())), paint);

        if (isShowDividingLine) {
            canvas.drawLine(
                    (TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 0, getResources().getDisplayMetrics())),
                    (TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 0, getResources().getDisplayMetrics())),
                    (TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, DEFAULT_LAYOUT_WIDTH, getResources().getDisplayMetrics())),
                    (TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 0, getResources().getDisplayMetrics())), paint);
        }
        canvas.restore();
    }
}
