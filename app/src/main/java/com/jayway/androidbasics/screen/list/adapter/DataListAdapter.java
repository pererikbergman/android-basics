package com.jayway.androidbasics.screen.list.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.jayway.androidbasics.screen.list.fragment.SortByNameFragment;
import com.jayway.androidbasics.screen.list.fragment.SortByValueFragment;

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
                return SortByNameFragment.getInstance();
            case 1:
                return SortByValueFragment.getInstance();
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
