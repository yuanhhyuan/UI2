package com.hy.appui.userdefinedview;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.hy.app.ui2.R;


/**

 */
public class CircleViewActivity extends Activity {
    String tag = "060_CircleViewActivity";

    CircleView c1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panelview);

        c1 = (CircleView)findViewById(R.id.c1);
        Log.e(tag, " onCreate >>>>>>>>>>>> "
                + " , " + " left" + c1.getLeft()
                + " , " + " top" + c1.getTop()
                + " , " + " right" + c1.getRight()
                + " , " + " bottom" + c1.getBottom());

    }

    @Override
    public void onResume() {
        super.onResume();

        Log.e(tag, " onResume >>>>>>>>>>>> "
                + " , " + " left" + c1.getLeft()
                + " , " + " top" + c1.getTop()
                + " , " + " right" + c1.getRight()
                + " , " + " bottom" + c1.getBottom());

    }
}
