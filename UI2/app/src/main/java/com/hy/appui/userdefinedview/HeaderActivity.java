package com.hy.appui.userdefinedview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;

import com.hy.app.ui2.R;


/**

 */
public class HeaderActivity extends Activity {

    Button mStartAnim;
    Header mHeader;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_header);

        initView();  //初始化view
        initListener();  //初始化多个监听事件
    }

    private void initView() {
        mHeader = (Header) findViewById(R.id.header);
        mStartAnim = (Button) findViewById(R.id.mStartAnim);
    }

    private void initListener() {
        mHeader.setOnHeaderClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.tv_header:
                        Toast.makeText(getApplicationContext(), "标题栏的文字被点击了", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.ib_header:
                        Toast.makeText(getApplicationContext(), "标题栏的按钮被点击了", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.leftTV:
                        finish();
                        break;
                    default:
                        break;
                }
            }
        });

        mStartAnim.setOnClickListener(new MyListener());
    }

    private class MyListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.mStartAnim:
                    mHeader.setAnimation(AnimationUtils.loadAnimation(HeaderActivity.this, R.anim.translate_demo));
                    break;
                default:
                    break;
            }
        }
    }
}
