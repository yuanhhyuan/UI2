package com.hy.appui.userdefinedview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.hy.app.ui2.R;


/**
 * 自定义View控件（三）----重写View来实现全新控件
 */
public class CircleView extends View {
    String tag = "060_CircleView";
    // 设置画笔变量
    Paint mPaint1;

    // 自定义View有四个构造函数
    // 如果View是在Java代码里面new的，则调用第一个构造函数
    public CircleView(Context context) {
        super(context);

        // 在构造函数里初始化画笔的操作
        init();
    }


    // 如果View是在.xml里声明的，则调用第二个构造函数
    // 自定义属性是从AttributeSet参数传进来的
    public CircleView(Context context, AttributeSet attrs) {
        super(context, attrs);


        // 加载自定义属性集合CircleView
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CircleView);

        // 解析集合中的属性circle_color属性
        // 该属性的id为:R.styleable.CircleView_circle_color
        // 将解析的属性传入到画圆的画笔颜色变量当中（本质上是自定义画圆画笔的颜色）
        // 第二个参数是默认设置颜色（即无指定circle_color情况下使用）
        mColor = a.getColor(R.styleable.CircleView_circle_color, Color.RED);

        // 解析后释放资源
        a.recycle();

        init();

    }

    int mColor;

    // 不会自动调用
    // 一般是在第二个构造函数里主动调用
    // 如View有style属性时
    public CircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        // 加载自定义属性集合CircleView
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CircleView);

        // 解析集合中的属性circle_color属性
        // 该属性的id为:R.styleable.CircleView_circle_color
        // 将解析的属性传入到画圆的画笔颜色变量当中（本质上是自定义画圆画笔的颜色）
        // 第二个参数是默认设置颜色（即无指定circle_color情况下使用）
        mColor = a.getColor(R.styleable.CircleView_circle_color, Color.RED);

        // 解析后释放资源
        a.recycle();

        init();
    }


    //API21之后才使用
    // 不会自动调用
    // 一般是在第二个构造函数里主动调用
    // 如View有style属性时
    public CircleView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    // 画笔初始化
    private void init() {

        // 创建画笔
        mPaint1 = new Paint();
        // 设置画笔颜色为蓝色
        mPaint1.setColor(mColor);
        // 设置画笔宽度为10px
        mPaint1.setStrokeWidth(5f);
        //设置画笔模式为填充
        mPaint1.setStyle(Paint.Style.FILL);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec,heightMeasureSpec);

        Log.e(tag, "onMeasure >>>>>>>>>>>>widthMeasureSpec : " + widthMeasureSpec + " , " + " heightMeasureSpec" + heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed,left,top,right,bottom);

        Log.e(tag, "onLayout >>>>>>>>>>>>changed : " + changed
                + " , " + " left" + left
                + " , " + " top" + top
                + " , " + " right" + right
                + " , " + " bottom" + bottom);
    }

    // 复写onDraw()进行绘制
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Log.e(tag, "onDraw");
        //
        //        // 获取控件的高度和宽度
        //        int width = getWidth();
        //        int height = getHeight();
        //
        //        // 设置圆的半径 = 宽,高最小值的2分之1
        //        int r = Math.min(width, height)/2;
        //
        //        // 画出圆（蓝色）
        //        // 圆心 = 控件的中央,半径 = 宽,高最小值的2分之1
        //        canvas.drawCircle(width/2,height/2,r,mPaint1);


        // 获取传入的padding值
        final int paddingLeft = getPaddingLeft();
        final int paddingRight = getPaddingRight();
        final int paddingTop = getPaddingTop();
        final int paddingBottom = getPaddingBottom();


        // 获取绘制内容的高度和宽度（考虑了四个方向的padding值）
        int width = getWidth() - paddingLeft - paddingRight;
        int height = getHeight() - paddingTop - paddingBottom;

        // 设置圆的半径 = 宽,高最小值的2分之1
        int r = Math.min(width, height) / 2;

        // 画出圆(蓝色)
        // 圆心 = 控件的中央,半径 = 宽,高最小值的2分之1
        canvas.drawCircle(paddingLeft + width / 2, paddingTop + height / 2, r, mPaint1);

    }

}
