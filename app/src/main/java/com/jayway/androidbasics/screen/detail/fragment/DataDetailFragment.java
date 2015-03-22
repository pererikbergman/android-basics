package com.jayway.androidbasics.screen.detail.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jayway.androidbasics.R;
import com.jayway.androidbasics.model.Service;
import com.jayway.androidbasics.model.Data;

public class DataDetailFragment extends Fragment {

    public static String DATA_ID = "dataId";

    private TextView mName;
    private TextView mValue;
    private TextView mDetails;
    private Data     mData;
    private int      mId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_details, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mName = (TextView) view.findViewById(R.id.name);
        mValue = (TextView) view.findViewById(R.id.value);
        mDetails = (TextView) view.findViewById(R.id.details);

        parseBundle(
                savedInstanceState == null ? getArguments() : savedInstanceState
        );

        setDataId(mId);

        update();
    }

    private void parseBundle(Bundle bundle) {
        if(bundle!=null){
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
            mName.setText(mData.getName());
            mValue.setText(Integer.toString(mData.getValue()));
            mDetails.setText("Details:" + Integer.toString(mData.getValue() / 1000));
        }
    }
}
