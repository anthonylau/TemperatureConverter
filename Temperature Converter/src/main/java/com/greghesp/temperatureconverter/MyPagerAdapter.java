package com.greghesp.temperatureconverter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MyPagerAdapter extends FragmentPagerAdapter {

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int pos) {
        switch(pos) {

            case 0: return resultFragment.newInstance("resultFragment, Instance 1");
            case 1: return resultFragment.newInstance("resultFragment, Instance 2");
            default: return resultFragment.newInstance("resultFragment, Default");
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}