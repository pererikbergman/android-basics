package com.jayway.androidbasics.screen.list.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.jayway.androidbasics.model.Data;
import com.jayway.androidbasics.screen.list.viewholder.DataViewHolder;

import java.util.ArrayList;
import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataViewHolder> {

    private List<Data>                               mDataList;
    private DataViewHolder.OnDataItemClickedListener mListener;

    public DataAdapter(ArrayList<Data> dataList) {
        mDataList = dataList;
    }

    @Override
    public DataViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        return DataViewHolder.create(viewGroup);
    }

    @Override
    public void onBindViewHolder(DataViewHolder dataViewHolder, int position) {
        dataViewHolder.bind(mDataList.get(position), mListener);
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public void setOnDataItemClicked(DataViewHolder.OnDataItemClickedListener listener) {
        mListener = listener;
    }
}
