package com.tiktoknew.trimmodule;

import android.content.Context;
import android.graphics.PorterDuff;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ProgressBar;

import androidx.annotation.RequiresApi;

import com.tiktoknew.R;


public class CustomProgress extends ProgressBar {

    public CustomProgress(Context context) {
        super(context);
        setTintColor(context);
    }

    public CustomProgress(Context context, AttributeSet attrs) {
        super(context, attrs);
        setTintColor(context);
    }

    public CustomProgress(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setTintColor(context);
    }

    public CustomProgress(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setTintColor(context);
    }

    private void setTintColor(Context context) {
        this.getIndeterminateDrawable().setColorFilter(TrimmerUtils.getColor(
                context, R.color.colorAccent), PorterDuff.Mode.MULTIPLY);
    }
}