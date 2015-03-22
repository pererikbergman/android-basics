package com.jayway.androidbasics.screen.list.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jayway.androidbasics.model.Data;
import com.jayway.androidbasics.screen.list.viewholder.DataViewHolder;
import com.jayway.androidbasics.R;

import java.util.ArrayList;
import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataViewHolder> {

    private List<Data>                mDataList;
    private LayoutInflater            mLayoutInflater;
    private OnDataItemClickedListener mListener;

    public DataAdapter(ArrayList<Data> dataList) {
        mDataList = dataList;
    }

    @Override
    public DataViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (mLayoutInflater == null) {
            mLayoutInflater = LayoutInflater.from(viewGroup.getContext());
        }

        return new DataViewHolder(
                mLayoutInflater.inflate(R.layout.list_item, viewGroup, false)
        );
    }

    @Override
    public void onBindViewHolder(DataViewHolder dataViewHolder, int i) {
        final Data data = mDataList.get(i);
        dataViewHolder.setName(data.getName());
        dataViewHolder.setValue(data.getValue());
        dataViewHolder.getView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onDataItemClicked(data);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public void setOnDataItemClicked(OnDataItemClickedListener listener) {
        mListener = listener;
    }

    public interface OnDataItemClickedListener {
        void onDataItemClicked(Data data);
    }
}
