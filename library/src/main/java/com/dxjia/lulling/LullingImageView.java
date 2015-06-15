package com.dxjia.lulling;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;

import com.dxjia.library.R;
import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.animation.ValueAnimator;
import android.os.Message;
import android.os.Handler;

/**
 * Created by dxjia on 15-6-5.
 */
public class LullingImageView extends ImageView {

    /**
     * Scaling will maintain the aspect-ratio of the original image.
     * If only a single out bound is specified, the other bound will be calculated.
     */
    final static boolean KEEP_SCALE_DEFAULT = true;

    /**
     * default scale
     */
    final static float TARGET_MAX_SCALE_VALUE_DEFAULT = 1.2f;

    /**
     * default duration
     * 5s
     */
    final static int DURATION_DEFAULT = 5000;

    /**
     * the default start delay
     * default will begin immitently
     */
    final static int START_DELAY_DEFAULT = 500;

    private static enum ScaleState {
        SCALE_NONE,
        SCALE_STARTED,
        SCALE_ZOOM_OUT,
        SCALE_MAX,
        SCALE_ZOOM_IN,
        SCALE_END;

        private ScaleState() {
        }
    }

    /**
     * view size
     */
    private int mViewWidth;
    private int mViewHeight;

    /**
     * center x, y
     */
    private int mCenterX;
    private int mCenterY;

    /**
     * ValueAnimator for scale
     */
    ValueAnimator mScaleValueAnimator = null;

    private ScaleState mScaleState = ScaleState.SCALE_NONE;

    private ScaleType mScaleType;

    private static final boolean AUTO_PLAY_DEFAULT = true;
    /**
     * play auto
     */
    private boolean mAutoPlay = AUTO_PLAY_DEFAULT;

    /**
     * target scale size, zoomout max
     */
    private float mTargetMaxScaleValue = TARGET_MAX_SCALE_VALUE_DEFAULT;

    /**
     * duration
     */
    private long mDuration = DURATION_DEFAULT;


    /**
     * original matrix
     */
    private Matrix mOriginalMatrix;


    public LullingImageView(Context context) {
        super(context);
        init(context, null);
    }

    public LullingImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public LullingImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.lulling);

        // auto play?
        mAutoPlay = typedArray.getBoolean(R.styleable.lulling_autoPlay, AUTO_PLAY_DEFAULT);
        // scale value
        mTargetMaxScaleValue = typedArray.getFloat(R.styleable.lulling_scaleValue, TARGET_MAX_SCALE_VALUE_DEFAULT);
        // duration
        mDuration = typedArray.getInt(R.styleable.lulling_duration, DURATION_DEFAULT);

        typedArray.recycle();


        setScaleType(ScaleType.MATRIX);
        // record
        mScaleType = getScaleType();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stop();
    }

    @Override
    protected void onVisibilityChanged(View changedView, int vis) {
        super.onVisibilityChanged(changedView, vis);
    }

    /**
     * start the animator
     */
    private void start() {
        mViewWidth = getWidth();
        mViewHeight = getHeight();

        mCenterX = mViewWidth/2;
        mCenterY = mViewHeight/2;

        mScaleState = ScaleState.SCALE_STARTED;
        setScaleType(ScaleType.MATRIX);

        startAnimatorScale();
    }

    /**
     * stop the animator
     */
    private void stop() {
        if (mScaleValueAnimator == null) {
            setScaleType(ScaleType.MATRIX);
            return;
        }

        mScaleValueAnimator.removeAllUpdateListeners();
        mScaleValueAnimator.cancel();
        mScaleValueAnimator = null;

        mScaleState = ScaleState.SCALE_NONE;

        // reset image
        setScaleType(ScaleType.MATRIX);
        resetDrawable();
    }

    /**
     * reset image to the original state
     */
    private void resetDrawable() {
        Matrix matrix = new Matrix(mOriginalMatrix);
        matrix.postScale(1.0f, 1.0f, mCenterX, mCenterY);
        setImageMatrix(matrix);
    }

    /**
     * animator update listener
     * change the image matrix here
     */
    private class ScaleAnimatorListener implements ValueAnimator.AnimatorUpdateListener {

        /**
         * drawable matrix
         */
        private Matrix mDrawableMatrix;

        /**
         * for checking is zooming out?
         */
        private float mOldScaleValue;

        /**
         * constructor
         */
        public ScaleAnimatorListener(Matrix matrix) {
            mDrawableMatrix = matrix;
            mOldScaleValue = 0.0f;
        }

        @Override
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
             // get scale from value animator
            float scale = (Float)valueAnimator.getAnimatedValue ();

            // record the scale, compare next time
            // set correct zoom state
            // the first time
            if (mOldScaleValue == mTargetMaxScaleValue) {
                mScaleState = ScaleState.SCALE_MAX;
            } else if (mOldScaleValue > scale) {
                if (mScaleState == ScaleState.SCALE_ZOOM_OUT) {
                    mScaleState = ScaleState.SCALE_MAX;
                } else {
                    mScaleState = ScaleState.SCALE_ZOOM_IN;
                }
            } else if (mOldScaleValue < scale) {
                mScaleState = ScaleState.SCALE_ZOOM_OUT;
            }

            mOldScaleValue = scale;

            // applay the scale matrix
            Matrix matrix = new Matrix(mDrawableMatrix);
            matrix.postScale(scale, scale, mCenterX, mCenterY);
            setImageMatrix(matrix);
        }
    }
    /**
     * change to use ValueAnimator
     * here we use nineoleanroid library for lower version
     */
    private void startAnimatorScale() {
        // reset first
        if (mScaleValueAnimator != null) {
            mScaleValueAnimator.removeAllUpdateListeners();
            mScaleValueAnimator.cancel();
            mScaleValueAnimator = null;
        }

        mOriginalMatrix = getImageMatrix();

        mScaleValueAnimator = ObjectAnimator.ofFloat(1.0f, mTargetMaxScaleValue);
        mScaleValueAnimator.setDuration(mDuration);
        mScaleValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        mScaleValueAnimator.setRepeatCount(ValueAnimator.INFINITE);
        mScaleValueAnimator.setRepeatMode(ValueAnimator.REVERSE);
        mScaleValueAnimator.addUpdateListener(new ScaleAnimatorListener(mOriginalMatrix));
        mScaleValueAnimator.start();
    }

    /**
     * is animating
     * @return boolean
     */
    private boolean isAnimating() {
        if (mScaleValueAnimator == null) {
            return false;
        }

        return mScaleValueAnimator.isRunning();
    }

    /**
     * toggle animator
     */
    public void toggle() {
        if (isAnimating()) {
            stop();
        } else {
            start();
        }
    }

    public void setImage(int resid) {
        if (isAnimating()) {
            stop();
        }
        setScaleType(ScaleType.MATRIX);
        setImageResource(resid);
        //start();
		mHandler.sendEmptyMessageDelayed(EVENT_START_DELAY, 500);
    }
	
	private static int EVENT_START_DELAY = 100;
	private Handler mHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			if (msg.what == EVENT_START_DELAY) {
				start();
			}
		}
	};
}
