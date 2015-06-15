package com.dxjia.sample;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.TextView;

import static android.R.color.transparent;

/**
 * Created by djia on 15-6-9.
 */
public class BeanShowingTextView extends TextView {

    /**
     * default duration
     * 20ms
     */
    private static final int DEFAULT_DURATION = 15;
    /**
     * duration one by one
     * ms
     */
    private int mDuration;

    /**
     * handler
     */
    private BeanShowingHandler mHandler;

    private int mOriginalTextColor;

    private String mOriginalText;

    private String[] mStringList;

    private int mCurrentIndex;

    private String mCurrentText;

    /**
     * handler event
     */
    private static final int EVENT_BEAN_START = 0;
    private static final int EVENT_BEAN_SHOW = 1;

    public BeanShowingTextView(Context context) {
        super(context);
        init();
    }

    public BeanShowingTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BeanShowingTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @SuppressLint("ResourceAsColor")
    private void init() {
        mOriginalTextColor = android.R.color.white;//getCurrentTextColor();
        mOriginalText = (String) getText();
        mStringList = mOriginalText.split("");
        mCurrentIndex = 0;


        mDuration = DEFAULT_DURATION;
        mHandler = new BeanShowingHandler();
        mHandler.sendEmptyMessage(EVENT_BEAN_START);
    }

    private class BeanShowingHandler extends Handler {
        public BeanShowingHandler() {

        }

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case EVENT_BEAN_START:
                    mCurrentText = "";
                    mCurrentIndex = 0;
                    sendEmptyMessage(EVENT_BEAN_SHOW);
                    break;
                case EVENT_BEAN_SHOW:
                    doBeanShowText();
                    break;
                default:
                    break;
            }
        }
    }

    private void doBeanShowText() {
        mCurrentIndex++;
        if (mCurrentIndex > mOriginalText.length()) {
            return;
        }

        mCurrentText = mCurrentText + mStringList[mCurrentIndex];

        super.setText(mCurrentText);

        mHandler.sendEmptyMessageDelayed(EVENT_BEAN_SHOW, DEFAULT_DURATION);
    }

    /**
     * set text
     * @param text
     */
    public void setText(String text, int textColor) {
        mHandler.removeMessages(EVENT_BEAN_SHOW);
        mHandler.removeMessages(EVENT_BEAN_START);

        mOriginalTextColor = textColor;
		// reset text
        setText("");
        mOriginalText = text;
        mStringList = mOriginalText.split("");

        mHandler.sendEmptyMessage(EVENT_BEAN_START);
    }
}
