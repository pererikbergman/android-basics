package com.jayway.androidbasics.screen.detail.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jayway.androidbasics.R;
import com.jayway.androidbasics.model.Data;
import com.jayway.androidbasics.model.Service;
import com.jayway.androidbasics.screen.list.widget.DataView;

public class DataDetailFragment extends Fragment {

    private static String DATA_ID = "dataId";

    private DataView mDataView;

    private Data mData;
    private int  mId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_details, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mDataView = (DataView)view.findViewById(R.id.data_view);

        parseBundle(
                savedInstanceState == null ? getArguments() : savedInstanceState
        );

        setDataId(mId);

        update();
    }

    private void parseBundle(Bundle bundle) {
        if (bundle != null) {
            mId = bundle.getInt(DATA_ID, -1);
        }
    }

    public void setDataId(int id) {
        setData(Service.getModel().findById(id));
    }

    public void setData(Data data) {
        mData = data;
    }

    public void update() {
        if (mData != null) {
            mDataView.setData(mData);
        }
    }

    public static DataDetailFragment getInstance(int id) {
        DataDetailFragment fragment = new DataDetailFragment();
        Bundle             bundle   = new Bundle();
        bundle.putInt(DataDetailFragment.DATA_ID, id);
        fragment.setArguments(bundle);

        return fragment;
    }
}
