package com.example.akash.independencedayapp;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

class MyPageAdapter extends FragmentPagerAdapter {

    private Context context;

    public MyPageAdapter(Context context, FragmentManager fragmentManager) {
        super(fragmentManager);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return QuotesFragment.newInstance(context,context.getResources().getString(R.string.quote1));
            case 1:
                return QuotesFragment.newInstance(context,context.getResources().getString(R.string.quote2));
            default:
                return QuotesFragment.newInstance(context,context.getResources().getString(R.string.quote3));
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
