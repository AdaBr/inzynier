package com.example.ada.library.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by ada on 10.01.2019.
 */

class PagerAdapter extends FragmentPagerAdapter{


    public PagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }


    @Override
    public int getCount() {
        return 1;
    }


    @Override
    public Fragment getItem(int position) {
        return null;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return "Page " + position;
    }

}
