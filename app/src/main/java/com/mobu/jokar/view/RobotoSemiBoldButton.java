package com.mobu.jokar.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

/**
 * Created by mahesh on 27/1/17.
 * SanFranciscoDisplay-Regular font TextView
 */

public class RobotoSemiBoldButton extends android.support.v7.widget.AppCompatButton {
    public RobotoSemiBoldButton(Context context) {
        super(context);
        createFont();
    }

    public RobotoSemiBoldButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        createFont();
    }

    public RobotoSemiBoldButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        createFont();
    }

    public void createFont() {
        Typeface font = Typeface.createFromAsset(getContext().getAssets(), "fonts/Roboto-Medium.ttf");
        setTypeface(font);
    }

}
