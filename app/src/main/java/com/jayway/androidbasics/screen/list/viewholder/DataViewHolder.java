package com.jayway.androidbasics.screen.list.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jayway.androidbasics.R;
import com.jayway.androidbasics.model.Data;

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

    public void bind(final Data data, final OnDataItemClickedListener listener) {
        mName.setText(data.getName());
        mValue.setText(Integer.toString(data.getValue()));
        mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onDataItemClicked(data);
                }
            }
        });
    }

    public interface OnDataItemClickedListener {
        void onDataItemClicked(Data data);
    }

    public static DataViewHolder create(ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());

        return new DataViewHolder(
                inflater.inflate(R.layout.list_item, viewGroup, false)
        );
    }
}
