package com.dxjia.sample;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dxjia.lulling.R;

public class BillView extends RelativeLayout {

    public final static String KEY_IMAGE_RES_ID  = "image_res_id";
    public final static String KEY_TITLE_STR     = "title";
    public final static String KEY_SIZE_INFO_STR = "size_info";
    public final static String KEY_DETAIL_STR    = "detail";

    private ImageView mBillImage;
    private View mMaskView;
    private TextView mTitleTextView;
    private TextView mSizeInfoTextView;
    private Context mContext;

    public BillView(Context context) {
        super(context);
        init(context, null, 0);
    }

    public BillView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public BillView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs, defStyle);
    }

    private void init(Context context, AttributeSet attrs, int defStyle) {
        mContext = context;

        // inflate from xml
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.bill_view, this);

        mBillImage = (ImageView) findViewById(R.id.bill_image);
        mMaskView = findViewById(R.id.mask);
        mTitleTextView = (TextView) findViewById(R.id.title);
        mSizeInfoTextView = (TextView) findViewById(R.id.size_info);

        // Load attributes
        final TypedArray a = mContext.obtainStyledAttributes(attrs, R.styleable.BillView, defStyle, 0);

        Drawable billImage = a.getDrawable(R.styleable.BillView_image);
        int maskColor = a.getColor(R.styleable.BillView_maskColor, R.color.mask_color);
        String title = a.getString(R.styleable.BillView_titleStr);
        String sizeInfo = a.getString(R.styleable.BillView_sizeInfoStr);

        a.recycle();

        mBillImage.setImageDrawable(billImage);
        mMaskView.setBackgroundColor(maskColor);
        mTitleTextView.setText(title);
        mSizeInfoTextView.setText(sizeInfo);

        setClickable(true);
    }

    public void setOnClick(View.OnClickListener l) {
        mMaskView.setOnClickListener(l);
    }
}
