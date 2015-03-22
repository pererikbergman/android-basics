package com.jayway.androidbasics.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.jayway.androidbasics.R;

public class DataViewHolder extends RecyclerView.ViewHolder {

    private final View     mView;
    private final TextView mName;
    private final TextView mValue;

    public DataViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        mName = (TextView) itemView.findViewById(R.id.name);
        mValue = (TextView) itemView.findViewById(R.id.value);
    }

    public View getView() {
        return mView;
    }

    public void setName(String name) {
        mName.setText(name);
    }

    public void setValue(int value) {
        mValue.setText(Integer.toString(value));
    }

}
