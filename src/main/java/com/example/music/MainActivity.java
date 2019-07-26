package com.example.music;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.music.fragment.Matching;
import com.example.music.fragment.Playing;
import com.example.music.fragment.SongList;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    TabLayout tabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.view_pager);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);

//        FragmentManager fragmentManager = getSupportFragmentManager();
//        PagerAdapter pagerAdapter = new PagerAdapter(fragmentManager, this);
//        viewPager.setAdapter(pagerAdapter);
//
//        tabLayout.setupWithViewPager(viewPager);
//        tabLayout.getTabAt(0).setIcon(R.mipmap.song_list_96);
//        tabLayout.getTabAt(1).setIcon(R.mipmap.headphones_96);
//        tabLayout.getTabAt(2).setIcon(R.mipmap.matching_96);
//
//        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
//        tabLayout.setTabsFromPagerAdapter(pagerAdapter);
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();
    }

    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(R.mipmap.song_list_96);
        tabLayout.getTabAt(1).setIcon(R.mipmap.headphones_96);
        tabLayout.getTabAt(2).setIcon(R.mipmap.matching_96);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new SongList(), "");
        adapter.addFrag(new Playing(), "");
        adapter.addFrag(new Matching(), "");
        viewPager.setAdapter(adapter);
    }
    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            String title = "";
            switch (position)
            {
                case 0:
                    title = getResources().getString(R.string.song_list);
                    break;
                case 1:
                    title = getResources().getString(R.string.playing);
                    break;
                case 2:
                    title = getResources().getString(R.string.matching);
                    break;
            }
            return title;
        }
    }
}
