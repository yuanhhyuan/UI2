package com.hy.appui.userdefinedview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hy.app.ui2.R;


/**
 * 自定义View控件（一）----组合控件
 * <p>
 * Android中自定义组合控件 https://www.cnblogs.com/ivan-xu/p/4545929.html
 */
public class Header extends RelativeLayout {
    String tag = "060_Header";

    private TextView mTextView,mLeftTV;
    private ImageButton mImageButton;

    private String titleText;
    private int titleTextColor;
    private float titleTextSize;

    public Header(Context context) {
        super(context);
    }

    public Header(Context context, AttributeSet attrs) {
        super(context, attrs);

        //动态加载布局文件
        LayoutInflater.from(context).inflate(R.layout.header, this, true);

        //加载自定义的属性
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.Header);
        titleText = a.getString(R.styleable.Header_titleText);
        titleTextColor = a.getColor(R.styleable.Header_titleTextColor, Color.WHITE);
        titleTextSize = a.getDimension(R.styleable.Header_titleTextSize, 20f);

        //回收资源，这一句必须调用
        a.recycle();
    }

    /**
     * 此方法会在所有的控件都从xml文件中加载完成后调用
     */
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        //获取子控件
        mLeftTV = (TextView) findViewById(R.id.leftTV);
        mTextView = (TextView) findViewById(R.id.tv_header);
        mImageButton = (ImageButton) findViewById(R.id.ib_header);

        //将从资源文件中加载的属性设置给子控件
        if (!TextUtils.isEmpty(titleText)) {
            setPageTitleText(titleText);
        }
        setPageTitleTextColor(titleTextColor);
        setPageTitleTextSize(titleTextSize);
    }

    /**
     * 设置标题文字
     *
     * @param text
     */
    public void setPageTitleText(String text) {
        mTextView.setText(text);
    }

    /**
     * 设置标题文字颜色
     *
     * @param color
     */
    public void setPageTitleTextColor(int color) {
        mTextView.setTextColor(color);
    }

    /**
     * 设置标题文字大小
     *
     * @param size
     */
    public void setPageTitleTextSize(float size) {
        mTextView.setTextSize(size);
    }



    /**
     * 设置按钮点击事件监听器
     * （定义子view的监听事件）
     * @param listener
     */
    public void setOnHeaderClickListener(OnClickListener listener) {
        mLeftTV.setOnClickListener(listener);
        mTextView.setOnClickListener(listener);
        mImageButton.setOnClickListener(listener);
    }


}
