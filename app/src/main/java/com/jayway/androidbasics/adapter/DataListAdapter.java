package com.jayway.androidbasics.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.jayway.androidbasics.fragment.SortByNameFragment;
import com.jayway.androidbasics.fragment.SortByValueFragment;

public class DataListAdapter extends FragmentPagerAdapter {

    public DataListAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return new SortByNameFragment();
            case 1:
                return new SortByValueFragment();
        }

        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Sort By Name";
            case 1:
                return "Sort By Value";
        }

        return null;
    }
}
