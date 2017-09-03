package yuejunfeng20170825.bw.com.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by admin on 2017/9/3.
 */

public class CustomTextView extends RelativeLayout {
    //定义三个布局参数
    private LayoutParams leftParams, rightParams, titleParams;
    private int topTextColor;
    private String topTitle;
    private Drawable topDrawable;
    private float topSize;
    private Drawable leftDrawable;
    private String leftText;
    private int leftColor;
    private float leftSize;
    private float rightSize;
    private int rightColor;
    private String rightText;
    private Drawable rightDrawable;
    private Button left_button;
    private Button right_button;
    private TextView top_textview;

    public CustomTextView(Context context) {
        super(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        //将XML中定义的自定义属性映射到attrs中
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.CustomTextView);
        //从ta结构中获取数据，类似一种key,value结构，通过R.styleable.Topbar_属性名获取
        topTextColor = ta.getColor(R.styleable.CustomTextView_titleColor, 0);
        topTitle = ta.getString(R.styleable.CustomTextView_toptitle);
        topSize = ta.getDimension(R.styleable.CustomTextView_textsize, 0);

        leftDrawable = ta.getDrawable(R.styleable.CustomTextView_leftBackground);
        leftText = ta.getString(R.styleable.CustomTextView_leftTexttitle);
        leftColor = ta.getColor(R.styleable.CustomTextView_leftTextColor, 0);

        rightColor = ta.getColor(R.styleable.CustomTextView_rightTextColor, 0);
        rightText = ta.getString(R.styleable.CustomTextView_rightTexttitle);
        rightDrawable = ta.getDrawable(R.styleable.CustomTextView_rightBackground);
         //进行垃圾回收
        ta.recycle();
        //初始化控件
        left_button = new Button(context);
        right_button = new Button(context);
        top_textview = new TextView(context);

        left_button.setTextColor(leftColor);//设置颜色
        left_button.setText(leftText);//设置文本
        left_button.setBackground(leftDrawable);//设置背景


        right_button.setTextColor(rightColor);//设置颜色
        right_button.setText(rightText);//设置文本
        right_button.setBackground(rightDrawable);//设置背景

        top_textview.setTextColor(topTextColor);         //设置字体颜色
        top_textview.setTextSize(topSize);           //设置字体大小
        top_textview.setText(topTitle);                    //设置文本
        top_textview.setGravity(Gravity.CENTER);           //居中显示

      setBackgroundColor(0xfff59563);               //设置View的背景颜色

        //设置布局属性的width和height
        leftParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        //设置对齐方式为父容器的左侧
        leftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, TRUE);
        //将左边按钮添加到视图中，并设置布局属性
        addView(left_button, leftParams);

        //设置布局属性的width和height
        rightParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        //设置对齐方式为父容器的右侧
        rightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, TRUE);
        //将右边按钮添加到视图中，并设置布局属性
        addView(right_button, rightParams);

        //设置布局属性的width和height
        titleParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        //设置对齐方式为居中对齐
        titleParams.addRule(RelativeLayout.CENTER_IN_PARENT, TRUE);
        //将中间TextView添加到视图中，并设置布局属性
        addView(top_textview, titleParams);

        //添加左侧按钮的Click事件
        left_button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                OnTopBarClickListener.leftClick();
            }
        });

        //添加右侧按钮的Click事件
        right_button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                OnTopBarClickListener.rightClick();
            }
        });
    }
    //定义一个事件接口
    public interface  onTopBarClickListener{
        void leftClick();
        void rightClick();
    }

    //创建接口对象
    public onTopBarClickListener OnTopBarClickListener;

    //创建为事件接口赋值的方法
    public void setOnTopBarClickListener(onTopBarClickListener mOnTopBarClickListener){
        OnTopBarClickListener=mOnTopBarClickListener;
    }





}
