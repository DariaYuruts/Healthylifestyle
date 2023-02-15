package com.example.healthylifestyle.AuthenticationPapterAdapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.healthylifestyle.Fragment1;
import com.example.healthylifestyle.Fragment2;

public class AuthenticationPagerAdapter extends FragmentPagerAdapter {
    public AuthenticationPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new Fragment1();
            case 1:
                return new Fragment2();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}