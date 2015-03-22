package com.jayway.androidbasics.screen.list.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jayway.androidbasics.R;
import com.jayway.androidbasics.model.Data;
import com.jayway.androidbasics.screen.list.widget.DataView;

public class DataViewHolder extends RecyclerView.ViewHolder {

    private final DataView mView;

    public DataViewHolder(View itemView) {
        super(itemView);
        mView = (DataView) itemView;
    }

    public void bind(final Data data, final OnDataItemClickedListener listener) {
        mView.setData(data);
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
