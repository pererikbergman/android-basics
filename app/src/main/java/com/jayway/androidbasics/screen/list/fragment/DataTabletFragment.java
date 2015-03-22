package com.jayway.androidbasics.screen.list.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jayway.androidbasics.R;
import com.jayway.androidbasics.screen.list.adapter.DataAdapter;
import com.jayway.androidbasics.screen.detail.fragment.DataDetailFragment;
import com.jayway.androidbasics.model.Data;

public class DataTabletFragment extends Fragment implements DataAdapter.OnDataItemClickedListener {

    public static final String DATA_LIST   = "list";
    public static final String DATA_DETAIL = "detail";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_containers, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        loadDataListFragment();
        loadDataDetailFragment(null);
    }

    private void loadDataListFragment() {
        DataListFragment fragment = (DataListFragment) getChildFragmentManager().findFragmentByTag(DATA_LIST);

        if (fragment == null) {
            fragment = new DataListFragment();
            getChildFragmentManager().beginTransaction()
                    .add(R.id.left_container, fragment, DATA_LIST)
                    .commit();
        }
    }

    private void loadDataDetailFragment(Data data) {
        DataDetailFragment fragment = (DataDetailFragment) getChildFragmentManager().findFragmentByTag(DATA_DETAIL);

        if (fragment == null) {
            fragment = new DataDetailFragment();
            getChildFragmentManager().beginTransaction()
                    .add(R.id.right_container, fragment, DATA_DETAIL)
                    .commit();
        }

        if (data != null) {
            fragment.setData(
                    data
            );
            fragment.update();
        }
    }

    @Override
    public void onDataItemClicked(Data data) {
        loadDataDetailFragment(data);
    }
}
