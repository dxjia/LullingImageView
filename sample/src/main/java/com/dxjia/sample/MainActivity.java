package com.dxjia.sample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.dxjia.lulling.LullingImageView;
import com.dxjia.lulling.R;

public class MainActivity extends Activity {

    LullingImageView mImageView1;
    LullingImageView mImageView2;
    LullingImageView mImageView3;
    LullingImageView mImageView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageView1 = (LullingImageView) findViewById(R.id.test1);
        mImageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mImageView1.toggle();
            }
        });

        mImageView2 = (LullingImageView) findViewById(R.id.test2);
        mImageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mImageView2.toggle();
            }
        });

        mImageView3 = (LullingImageView) findViewById(R.id.test3);
        mImageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mImageView3.toggle();
            }
        });

        mImageView4 = (LullingImageView) findViewById(R.id.test4);
        mImageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mImageView4.toggle();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_Toggle) {
            /*mImageView1.toggle();
            mImageView2.toggle();
            mImageView3.toggle();
            mImageView4.toggle();*/
            startActivity(new Intent(MainActivity.this, BillsShowingActivity.class));
            return true;
        } else if (id == R.id.action_Sample) {
            startActivity(new Intent(MainActivity.this, DetailActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }
}
