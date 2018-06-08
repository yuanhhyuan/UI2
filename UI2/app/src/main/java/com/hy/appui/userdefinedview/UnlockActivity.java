package com.hy.appui.userdefinedview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.hy.app.ui2.R;


/**
 * demo GestureUnlock-master.zip 参考：https://www.jianshu.com/p/a4c29ec5712f
 */


public class UnlockActivity extends AppCompatActivity {

    private UnlockView mUnlockView;
    private String pwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unlock);

        mUnlockView= (UnlockView) findViewById(R.id.unlock);
        mUnlockView.setMode(UnlockView.CREATE_MODE);
        mUnlockView.setGestureListener(new UnlockView.CreateGestureListener() {
            @Override
            public void onGestureCreated(String result) {
                pwd=result;
                Toast.makeText(UnlockActivity.this,"Set Gesture Succeeded!", Toast.LENGTH_SHORT).show();
                mUnlockView.setMode(UnlockView.CHECK_MODE);
            }
        });
        mUnlockView.setOnUnlockListener(new UnlockView.OnUnlockListener() {
            @Override
            public boolean isUnlockSuccess(String result) {
                if(result.equals(pwd)){
                    return true;
                }else{
                    return false;
                }
            }

            @Override
            public void onSuccess() {
                Toast.makeText(UnlockActivity.this,"Check Succeeded!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure() {
                Toast.makeText(UnlockActivity.this,"Check Failed!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}

/**
 * notes：
 *
 * http://blog.csdn.net/wynwynwyn/article/details/48323575
 *
 * 结合Activity的生命周期就是onCreate -> View onFlinshInflate -> onStart -> onResume->View onMeasure->View onLayout -> View onDraw
 View
 *
 *
 */
