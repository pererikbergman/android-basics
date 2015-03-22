package com.jayway.androidbasics.screen.detail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.jayway.androidbasics.R;
import com.jayway.androidbasics.model.Data;
import com.jayway.androidbasics.screen.detail.fragment.DataDetailFragment;

public class DetailActivity extends ActionBarActivity {

    private static String DATA_ID = "dataId";

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
            mDataDetailFragment = DataDetailFragment.getInstance(id);

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, mDataDetailFragment, "tag")
                    .commit();
        }
    }

    public static void start(Context context, Data data) {
        Intent myIntent = new Intent(context, DetailActivity.class);
        myIntent.putExtra(DetailActivity.DATA_ID, data.getId()); //Optional parameters
        context.startActivity(myIntent);
    }
}
