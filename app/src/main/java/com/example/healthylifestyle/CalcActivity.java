package com.example.healthylifestyle;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.healthylifestyle.AuthenticationPapterAdapter.AuthenticationPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class CalcActivity extends AppCompatActivity {

    AuthenticationPagerAdapter myFragmentPagerAdapter;
    ViewPager viewPager;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        setPagerAdapter();
        setTableLayout();
    }

    private void setTableLayout() {
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setText("ИМТ");
        tabLayout.getTabAt(1).setText("КБЖУ");
    }

    private void setPagerAdapter(){
        myFragmentPagerAdapter = new AuthenticationPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(myFragmentPagerAdapter);
    }

}