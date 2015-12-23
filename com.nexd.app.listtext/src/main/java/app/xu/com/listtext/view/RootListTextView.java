package app.xu.com.listtext.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by lawrence on 2015/12/23.
 */
public abstract class RootListTextView extends View {

    public static final int DEFAULT_LAYOUT_WIDTH = 35;

    public static final int DEFAULT_LAYOUT_HEIGHT = 20;

    protected static boolean isShowDividingLine = false;

    public RootListTextView(Context context) {
        super(context);
    }

    public RootListTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RootListTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public RootListTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
