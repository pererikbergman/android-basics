package com.jayway.androidbasics.screen.detail;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.jayway.androidbasics.R;
import com.jayway.androidbasics.screen.detail.fragment.DataDetailFragment;

public class DetailActivity extends ActionBarActivity {

    public static String DATA_ID = "dataId";

    private int                mId;
    private DataDetailFragment mDataDetailFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_container);
        parseBundle(
                savedInstanceState == null ? getIntent().getExtras() : savedInstanceState
        );
        loadDetailFragment(mId);
    }

    private void parseBundle(Bundle bundle) {
        if (bundle != null) {
            mId = bundle.getInt(DATA_ID, -1);
        }
    }

    private void loadDetailFragment(int id) {
        mDataDetailFragment = (DataDetailFragment) getSupportFragmentManager().findFragmentByTag("tag");

        if (mDataDetailFragment == null) {
            mDataDetailFragment = new DataDetailFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(DataDetailFragment.DATA_ID, id);
            mDataDetailFragment.setArguments(bundle);

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, mDataDetailFragment, "tag")
                    .commit();
        }
    }
}
