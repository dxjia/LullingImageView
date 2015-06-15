package com.dxjia.sample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;

import com.dxjia.lulling.R;

public class BillsShowingActivity extends Activity {

    private BillView mBillView1;
    private BillView mBillView2;
    private BillView mBillView3;
    private BillView mBillView4;
    private BillView mBillView5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bills_showing);
        mBillView1 = (BillView) findViewById(R.id.bill_1);
        mBillView2 = (BillView) findViewById(R.id.bill_2);
        mBillView3 = (BillView) findViewById(R.id.bill_3);
        mBillView4 = (BillView) findViewById(R.id.bill_4);
        mBillView5 = (BillView) findViewById(R.id.bill_5);

        mBillView1.setOnClick(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BillsShowingActivity.this, DetailActivity.class);
                intent.putExtra(BillView.KEY_IMAGE_RES_ID, R.mipmap.test_1);
                intent.putExtra(BillView.KEY_TITLE_STR, "Reventon / 浩瀚宇宙");
                intent.putExtra(BillView.KEY_SIZE_INFO_STR, "#奇观  / 2'30''");
                intent.putExtra(BillView.KEY_DETAIL_STR, "因为采用了APS-C规格的X-Trans CMOS传感器，所以富士X-E1这款可换镜头相机拥有出色的画质表现。而且无低通滤镜的设计也让其拥有更锐利的成像画质。复古的机身外形也是X-E1受到关注的原因之一。");
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });

        mBillView2.setOnClick(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BillsShowingActivity.this, DetailActivity.class);
                intent.putExtra(BillView.KEY_IMAGE_RES_ID, R.mipmap.test_2);
                intent.putExtra(BillView.KEY_TITLE_STR, "Flowers / 美丽芬芳的桃花");
                intent.putExtra(BillView.KEY_SIZE_INFO_STR, "#美景  / 3'45''");
                intent.putExtra(BillView.KEY_DETAIL_STR, "因为采用了APS-C规格的X-Trans CMOS传感器，所以富士X-E1这款可换镜头相机拥有出色的画质表现。而且无低通滤镜的设计也让其拥有更锐利的成像画质。复古的机身外形也是X-E1受到关注的原因之一。");
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });

        mBillView3.setOnClick(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = new TranslateAnimation(0, 0, mBillView3.getTop(), 0);
                animation.setDuration(500);
                animation.setFillAfter(true);
                mBillView3.startAnimation(animation);
                /*Intent intent = new Intent(BillsShowingActivity.this, DetailActivity.class);
                intent.putExtra(BillView.KEY_IMAGE_RES_ID, R.mipmap.test_3);
                intent.putExtra(BillView.KEY_TITLE_STR, "Dream / 带着梦想去旅行");
                intent.putExtra(BillView.KEY_SIZE_INFO_STR, "#旅行  / 5'06'''");
                intent.putExtra(BillView.KEY_DETAIL_STR, "因为采用了APS-C规格的X-Trans CMOS传感器，所以富士X-E1这款可换镜头相机拥有出色的画质表现。而且无低通滤镜的设计也让其拥有更锐利的成像画质。复古的机身外形也是X-E1受到关注的原因之一。");
                startActivity(intent);
                overridePendingTransition(0, 0);*/
            }
        });

        mBillView4.setOnClick(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BillsShowingActivity.this, DetailActivity.class);
                intent.putExtra(BillView.KEY_IMAGE_RES_ID, R.mipmap.test_4);
                intent.putExtra(BillView.KEY_TITLE_STR, "Sunshine / 邂逅清晨的阳光");
                intent.putExtra(BillView.KEY_SIZE_INFO_STR, "#美景  / 4'26''");
                intent.putExtra(BillView.KEY_DETAIL_STR, "因为采用了APS-C规格的X-Trans CMOS传感器，所以富士X-E1这款可换镜头相机拥有出色的画质表现。而且无低通滤镜的设计也让其拥有更锐利的成像画质。复古的机身外形也是X-E1受到关注的原因之一。");
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });

        mBillView5.setOnClick(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BillsShowingActivity.this, DetailActivity.class);
                intent.putExtra(BillView.KEY_IMAGE_RES_ID, R.mipmap.test_5);
                intent.putExtra(BillView.KEY_TITLE_STR, "Seaboard / 断崖下的海洋");
                intent.putExtra(BillView.KEY_SIZE_INFO_STR, "#奇观  / 2'30''");
                intent.putExtra(BillView.KEY_DETAIL_STR, "因为采用了APS-C规格的X-Trans CMOS传感器，所以富士X-E1这款可换镜头相机拥有出色的画质表现。而且无低通滤镜的设计也让其拥有更锐利的成像画质。复古的机身外形也是X-E1受到关注的原因之一。");
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bills_showing, menu);
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
}
