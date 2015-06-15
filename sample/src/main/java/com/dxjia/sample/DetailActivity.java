package com.dxjia.sample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.dxjia.lulling.LullingImageView;
import com.dxjia.lulling.R;

public class DetailActivity extends Activity {

    private int mImageResId;
    private String mTitle;
    private String mSizeInfo;
    private String mDetails;

    private LullingImageView mLullingImageView;
    private BeanShowingTextView mTitleBeanShoingTextView;
    private BeanShowingTextView mSizeInfoBeanShowingTextView;
    private BeanShowingTextView mDetailBeanShowingTextView;
	
	private boolean mInited = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        mLullingImageView = (LullingImageView) findViewById(R.id.lulling_image);
        mTitleBeanShoingTextView = (BeanShowingTextView) findViewById(R.id.title_bean);
        mSizeInfoBeanShowingTextView = (BeanShowingTextView) findViewById(R.id.size_info_bean);
        mDetailBeanShowingTextView = (BeanShowingTextView) findViewById(R.id.detail_bean);

        Intent intent = getIntent();

        mImageResId = intent.getIntExtra(BillView.KEY_IMAGE_RES_ID, R.mipmap.test_1);
        mTitle = intent.getStringExtra(BillView.KEY_TITLE_STR);
        mSizeInfo = intent.getStringExtra(BillView.KEY_SIZE_INFO_STR);
        mDetails = intent.getStringExtra(BillView.KEY_DETAIL_STR);
        Log.d("TEST", "mTitle = " + mTitle);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sample, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onStart() {
        super.onStart();
		if (!mInited) {
			mLullingImageView.setImage(mImageResId);
			mTitleBeanShoingTextView.setText(mTitle, R.color.text_color);
			mSizeInfoBeanShowingTextView.setText(mSizeInfo, R.color.text_color);
			mDetailBeanShowingTextView.setText(mDetails, R.color.text_color);
			mInited = true;
		}
    }

    @Override
    public void onPause() {
        super.onPause();
        overridePendingTransition(0, 0);
    }
}
