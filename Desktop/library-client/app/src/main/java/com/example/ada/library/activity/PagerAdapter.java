package com.example.ada.library.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.ada.library.model.Favorite;

/**
 * Created by ada on 10.01.2019.
 */

class PagerAdapter extends FragmentPagerAdapter{


    private static int NUM_ITEMS = 2;



    public PagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);

    }


    @Override
    public int getCount() {
        return NUM_ITEMS;
    }


    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return OrderFragment.newInstance(0);
            case 1:
                return FavoriteFragment.newInstance(1);
            default:
                return null;

        }
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return "Page " + position;
    }

}