package com.inflearn.lightinstagram.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;

public class LoadingBar extends ProgressBar {

    public LoadingBar(Context context) {
        super(context);
        hide();
    }

    public LoadingBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        hide();
    }

    public LoadingBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        hide();
    }

    public void show() {
        setVisibility(View.VISIBLE);
    }

    public void hide() {
        setVisibility(View.GONE);
    }
}