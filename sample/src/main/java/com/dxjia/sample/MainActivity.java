package com.dxjia.sample;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.dxjia.lulling.LullingImageView;
import com.dxjia.lulling.R;

public class MainActivity extends Activity {

    LullingImageView mImageView1;
    LullingImageView mImageView2;
    Button mToggleAllButton;

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

        mToggleAllButton = (Button) findViewById(R.id.toggle);
        mToggleAllButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mImageView1.toggle();
                mImageView2.toggle();
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
        if (id == R.id.action_Setting) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
