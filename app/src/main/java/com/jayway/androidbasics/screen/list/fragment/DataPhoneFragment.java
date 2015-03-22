package com.jayway.androidbasics.screen.list.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jayway.androidbasics.screen.detail.DetailActivity;
import com.jayway.androidbasics.R;
import com.jayway.androidbasics.screen.list.adapter.DataAdapter;
import com.jayway.androidbasics.model.Data;

public class DataPhoneFragment extends Fragment implements DataAdapter.OnDataItemClickedListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_container, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        loadDataListFragment();
    }

    private void loadDataListFragment() {
        DataListFragment fragment = (DataListFragment) getChildFragmentManager().findFragmentByTag("tag");

        if (fragment == null) {
            fragment = new DataListFragment();
            getChildFragmentManager().beginTransaction()
                    .add(R.id.container, fragment, "tag")
                    .commit();
        }
    }

    @Override
    public void onDataItemClicked(Data data) {
        System.out.println("data = " + data.getId());
        Intent myIntent = new Intent(getActivity(), DetailActivity.class);
        myIntent.putExtra(DetailActivity.DATA_ID, data.getId()); //Optional parameters
        getActivity().startActivity(myIntent);
    }
}



