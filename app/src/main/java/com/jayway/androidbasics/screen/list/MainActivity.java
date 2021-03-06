package com.jayway.androidbasics.screen.list;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.jayway.androidbasics.R;
import com.jayway.androidbasics.screen.list.fragment.DataPhoneFragment;
import com.jayway.androidbasics.screen.list.fragment.DataTabletFragment;
import com.jayway.androidbasics.util.CompatibilityUtil;


public class MainActivity extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_container);

        if(CompatibilityUtil.isTablet(this)){
            loadTabletFragment();
        } else {
            loadPhoneFragment();
        }
    }

    private void loadTabletFragment() {
        DataTabletFragment fragment = (DataTabletFragment) getSupportFragmentManager().findFragmentByTag("tag");

        if (fragment == null) {
            fragment = DataTabletFragment.getInstance();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, fragment, "tag")
                    .commit();
        }
    }

    private void loadPhoneFragment() {
        DataPhoneFragment fragment = (DataPhoneFragment) getSupportFragmentManager().findFragmentByTag("tag");

        if (fragment == null) {
            fragment = DataPhoneFragment.getInstance();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, fragment, "tag")
                    .commit();
        }
    }
}
