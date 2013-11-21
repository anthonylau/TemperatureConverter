package com.greghesp.temperatureconverter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MyPagerAdapter extends FragmentPagerAdapter {
    //Define Listeners
    public CustomOnItemSelectedListener selectedListener;

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int pos) {
        switch(pos) {

            case 0: return resultFragment.newInstance(selectedListener.degree);
            case 1: return resultFragment.newInstance("resultFragment, Instance 2");
            default: return resultFragment.newInstance("resultFragment, Default");
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
