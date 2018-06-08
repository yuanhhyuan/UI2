package com;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.hy.app.ui2.R;
import com.hy.appui.userdefinedview.CircleViewActivity;
import com.hy.appui.userdefinedview.HeaderActivity;
import com.hy.appui.userdefinedview.UnlockActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Activity标准形式
 *
 */
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.header)
    Button header;
    @BindView(R.id.mPanelViewActivity)
    Button mPanelViewActivity;
    @BindView(R.id.munlock)
    Button munlock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_androidui);

        //绑定初始化ButterKnife
        ButterKnife.bind(this);
    }


    @OnClick({R.id.header,R.id.mPanelViewActivity,R.id.munlock,R.id.mSuperSwipeRefreshLayout})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.header:
                newHeaderActivity();
                break;
            case R.id.mPanelViewActivity:
                newPanelViewActivity();
                break;
            case R.id.munlock:
                newUnlockActivity();
                break;
            default:
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }



    private void newHeaderActivity(){
        Intent i = new Intent(MainActivity.this,HeaderActivity.class);
        startActivity(i);
    }

    private void newPanelViewActivity(){
        Intent i = new Intent(MainActivity.this,CircleViewActivity.class);
        startActivity(i);
    }

    private void newUnlockActivity(){
        Intent i = new Intent(MainActivity.this,UnlockActivity.class);
        startActivity(i);
    }


}
