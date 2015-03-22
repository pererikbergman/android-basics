package com.jayway.androidbasics.screen.list.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.jayway.androidbasics.R;
import com.jayway.androidbasics.model.Data;

public class DataView extends FrameLayout {

    private TextView mName;
    private TextView mValue;
    private TextView mDetails;

    public DataView(Context context) {
        super(context);
        init();
    }

    public DataView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DataView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
//        LayoutInflater.from(getContext()).inflate(R.layout.list_item, this, true);
    }

    protected void onFinishInflate() {
        mName = (TextView) findViewById(R.id.name);
        mValue = (TextView) findViewById(R.id.value);
        mDetails = (TextView) findViewById(R.id.details);
    }

    public void setData(Data data) {
        mName.setText(data.getName());
        mValue.setText(Integer.toString(data.getValue()));

        if (mDetails != null) {
            mDetails.setText("Details:" + Integer.toString(data.getValue() / 1000));
        }
    }
}
