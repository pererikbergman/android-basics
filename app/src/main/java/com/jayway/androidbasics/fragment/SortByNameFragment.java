package com.jayway.androidbasics.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jayway.androidbasics.R;
import com.jayway.androidbasics.adapter.DataAdapter;
import com.jayway.androidbasics.model.Data;
import com.jayway.androidbasics.model.Service;
import com.jayway.androidbasics.util.DataUtil;

import java.util.ArrayList;
import java.util.Collections;

public class SortByNameFragment extends Fragment {

    private RecyclerView                          mRecyclerView;
    private DataAdapter.OnDataItemClickedListener mOnDataItemClickedListener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        Fragment fragment = this;
        while (fragment != null && mOnDataItemClickedListener == null) {
            if (fragment instanceof DataAdapter.OnDataItemClickedListener) {
                mOnDataItemClickedListener = (DataAdapter.OnDataItemClickedListener) fragment;
            } else {
                fragment = fragment.getParentFragment();
            }
        }
        if (mOnDataItemClickedListener == null && activity instanceof DataAdapter.OnDataItemClickedListener) {
            mOnDataItemClickedListener = (DataAdapter.OnDataItemClickedListener) activity;
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        final ArrayList<Data> dataList = new ArrayList<>(Service.getModel().getDataList());
        Collections.sort(dataList, DataUtil.NameComparator);
        final DataAdapter adapter = new DataAdapter(dataList);
        adapter.setOnDataItemClicked(mOnDataItemClickedListener);
        mRecyclerView.setAdapter(adapter);
    }


}
